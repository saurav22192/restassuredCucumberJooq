package utilities;

import org.openqa.selenium.WebDriver;
import pageObjects.HomePage;
import pageObjects.SearchPage;

public class POMManager {
    private  WebDriver driver;
    private  HomePage homePage;
    private  SearchPage searchPage;
    public POMManager(WebDriver driver){
        this.driver = driver;
        if(homePage==null)
        {
            homePage = new HomePage(driver);
        }
        if(searchPage==null)
        {
            searchPage = new SearchPage(driver);
        }
    }

    public HomePage getHomePage()
    {

        return homePage;
    }
    public SearchPage getSearchPage()
    {

        return searchPage;
    }
}
