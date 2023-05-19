package utilities;

import io.restassured.response.Response;
import org.apache.log4j.Logger;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class RestAssuredManager {
    private String baseUrl;
    private Response response;
//    private static Logger logger = LoggerFactory.getLogger(RestAssuredManager.class);
private static Logger logger = Logger.getLogger(RestAssuredManager.class);

    public RestAssuredManager(){
//        logger.isEnabled(Level.ALL);
//        logger.debug("debug message");
        logger.info("info message");

  }

    public Response getResponse() {
        return response;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    public Response performGetOperation(HashMap<String,String> header, HashMap<String,String> pathparams,HashMap<String,String> queryparams, String url){
        response = given().baseUri(baseUrl).headers(header).when().pathParams(pathparams).queryParams(queryparams).get(url);
        logger.info("err"+response.asPrettyString());
        return response;
    }
    public Response performPOSTOperation(HashMap<String,String> header, HashMap<String,String> pathparams,Object pojoRequest, String url){
        response = given().baseUri(baseUrl).headers(header).pathParams(pathparams).body(pojoRequest).when().post(url);
        logger.info(response.asPrettyString());
        return response;
    }
}
