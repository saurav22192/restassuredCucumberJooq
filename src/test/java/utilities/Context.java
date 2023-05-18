package utilities;
import org.openqa.selenium.WebDriver;
import base.base;
import pageObjects.HomePage;
import pageObjects.SearchPage;

public class Context extends base {

    private  HomePage homePage;
    private  SearchPage searchPage;
    public Context()
    {
        setup();
    }

    public WebDriver getDriver()
    {
        return driver;
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