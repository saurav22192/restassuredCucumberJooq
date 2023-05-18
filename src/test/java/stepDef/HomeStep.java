package stepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import utilities.Context;
public class HomeStep {
    Context context;
    HomePage homePage;
    public HomeStep(Context context)
    {
        this.context = context;
        homePage = context.getHomePage();
    }

    @Given("User opens the google website")
    public void user_opens_the_google_website() {
        context.openBaseURL();
        System.out.println("User opens the google website\n");
    }

    @When("User is on home page")
    public void User_is_on_home_page() {
        System.out.println("User is on homepage\n");
    }

    @Then("User should be able to enter the search key {string} in the search box")
            public void
            user_should_be_able_to_enter_the_search_key_in_the_search_box(String
            searchKey) {
        homePage.search(searchKey);
        System.out.println("User can enter the seach key\n");
    }
}