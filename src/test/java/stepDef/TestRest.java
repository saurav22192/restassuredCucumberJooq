package stepDef;

import POJOs.AuthUser;
import POJOs.book;
import POJOs.collectionOfIsbns;
import POJOs.getAllBooks;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.minidev.json.JSONArray;
import org.testng.Assert;
import utilities.Context;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class TestRest {
    private static final String USER_ID = "2e0ebcb9-b359-4664-a453-66d7e4093b4b";
    private static final String USERNAME = "abcd1213";
    private static final String PASSWORD = "A@123456aa";
//    private static final String BASE_URL = "https://bookstore.toolsqa.com";
//private String baseUri ;
     String token;
     Response response;
     String jsonString;
     String bookId;
    Context context;

    public TestRest(Context context)
    {
        this.context = context;
        context.getRestAssuredManager().setBaseUrl("https://bookstore.toolsqa.com");
//        RestAssured.baseURI= context.getBaseUri();
    }
    @Given("I am an authorized user")
    public void iAmAnAuthorizedUser() {

//        RequestSpecification request = given();

//        request.header("Content-Type", "application/json");
//        response = request.body("{ \"userName\":\"" + USERNAME + "\", \"password\":\"" + PASSWORD + "\"}")
//                .post("/Account/v1/GenerateToken");

//        String jsonString = response.asString();
//        token = JsonPath.from(jsonString).get("token");
//        Header hr = new Header("Content-Type","application/json");
//        given().baseUri(context.getRestAssuredManager().getBaseUrl()).header(hr).body();
        HashMap<String,String> hm = new HashMap<>();
        hm.put("Content-Type","application/json");
        AuthUser au =AuthUser.builder().userName(USERNAME).password(PASSWORD).build();
        response = context.getRestAssuredManager().performPOSTOperation(hm,new HashMap<>(),au,"Account/v1/GenerateToken");
        context.getScenarioContext().setContext("lastResponse",response);
        JSONArray jr = JsonPath.read(response.asString(),"$..token");
        token=jr.get(0).toString();
    }

    @Given("A list of books are available")
    public void listOfBooksAreAvailable() throws JsonProcessingException {
//        RestAssured.baseURI = BASE_URL;
//        RequestSpecification request = given();
//        response = request.get("/BookStore/v1/Books");
        HashMap<String,String> hm = new HashMap<>();
        hm.put("Content-Type","application/json");

        response = context.getRestAssuredManager().performGetOperation(hm,new HashMap<>(),new HashMap<>(),"/BookStore/v1/Books");

        jsonString = response.asString();
//        List<Map<String, String>> books
//        JsonPath path = JsonPath.compile("$..books");
//        List<Object> list = path.read(response.asString());
//        JSONArray ja = (JSONArray) list.get(0);

        JSONArray j= JsonPath.read(response.asString(),"$..books");
        JSONArray ja = (JSONArray) j.get(0);

        Assert.assertTrue(ja.size() > 0);

        JSONArray ja1 = JsonPath.read(response.asString(),"$..books[0].isbn");
        bookId = ja1.get(0).toString();

        //deserilization of response object
        getAllBooks myPojo = response
                .getBody()
                .as(getAllBooks.class);
        Assert.assertEquals(ja.size(),myPojo.getBooks().size());

        //comparing two jsons
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode1 = objectMapper.readTree(jsonString);
        JsonNode jsonNode2 = objectMapper.readTree(jsonString);

        // Compare two json using Jackson and displaying the result
        System.out.println(jsonNode1.equals(jsonNode2));

    }

    @When("I add a book to my reading list")
    public void addBookInList() {
        HashMap<String,String> hm = new HashMap<>();
        hm.put("Content-Type","application/json");
        hm.put("Authorization","Bearer " + token);
//        response = request.body("{ \"userId\": \"" + USER_ID + "\", " +
//                        "\"collectionOfIsbns\": [ { \"isbn\": \"" + bookId + "\" } ]}")
//                .post("/BookStore/v1/Books");
List<collectionOfIsbns> k = new ArrayList<>();
k.add(collectionOfIsbns.builder().isbn(bookId).build());
       response= context.getRestAssuredManager().performPOSTOperation(hm,new HashMap<>(), book.builder().userId(USER_ID).collectionOfIsbns(k).build(),"/BookStore/v1/Books");
    }

    @Then("The book is added")
    public void bookIsAdded() {
        Assert.assertEquals(201, response.getStatusCode());
    }

    @When("I remove a book from my reading list")
    public void removeBookFromList() {
        RestAssured.baseURI = context.getRestAssuredManager().getBaseUrl();
        RequestSpecification request = given();

        request.header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json");

        response = request.body("{ \"isbn\": \"" + bookId + "\", \"userId\": \"" + USER_ID + "\"}")
                .delete("/BookStore/v1/Book");


    }

    @Then("The book is removed")
    public void bookIsRemoved() {
        Assert.assertEquals(204, response.getStatusCode());

        RestAssured.baseURI = context.getRestAssuredManager().getBaseUrl();
        RequestSpecification request = given();

        request.header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json");

        response = request.get("/Account/v1/User/" + USER_ID);
        Assert.assertEquals(200, response.getStatusCode());

        jsonString = response.asString();
        List<Map<String, String>> booksOfUser = io.restassured.path.json.JsonPath.from(jsonString).get("books");
        Assert.assertEquals(0, booksOfUser.size());
    }
}


