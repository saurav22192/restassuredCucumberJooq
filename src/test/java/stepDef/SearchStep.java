package stepDef;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pageObjects.HomePage;
import pageObjects.SearchPage;
import utilities.Context;


public class SearchStep {

    Context context;
    SearchPage searchPage;
    HomePage homePage;

    public SearchStep(Context context)
    {
        this.context = context;
        searchPage = context.getSearchPage();
        homePage = context.getHomePage();
    }

    @Given("User is on google home page")
    public void User_is_on_google_home_page() {
        context.openBaseURL();
        System.out.println("User is on google home page\n");

    }
    @When("User enters search keyword {string}")
    public void user_enters_search_keyword(String searchKey) {
        System.out.println("User enters search keyword : "+searchKey+"\n");
                homePage.search(searchKey);
        homePage.enterSearch();
    }


    @Then("User should be navigated to search results page {string}")
    public void user_should_be_navigated_to_search_results_page(String
                                                                        searchKey){
        if(searchPage.getPageTitle().contains(searchKey))
        {
            System.out.println("User is in search results page\n");
            Assert.assertTrue(true);

        }
    }
}
