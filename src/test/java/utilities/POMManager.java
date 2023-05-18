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
    }

    public HomePage getHomePage()
    {
        if(homePage==null)
        {
            homePage = new HomePage(driver);
        }
        return homePage;
    }
    public SearchPage getSearchPage()
    {
        if(searchPage==null)
        {
            searchPage = new SearchPage(driver);
        }
        return searchPage;
    }
}
