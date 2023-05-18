package utilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import base.base;
import pageObjects.HomePage;
import pageObjects.SearchPage;

public class Context  {
    public DriverManager webDriverManager;
    public POMManager pageObjectManager;
     public Context()
    {
       webDriverManager = new DriverManager();
       pageObjectManager = new POMManager(webDriverManager.getDriver());
    }

}