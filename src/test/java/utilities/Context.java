package utilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import base.base;
import pageObjects.HomePage;
import pageObjects.SearchPage;

public class Context  {
    private DriverManager webDriverManager;
    private POMManager pageObjectManager;
    public ScenarioContext scenarioContext;

    public Context()
    {
       webDriverManager = new DriverManager();
       pageObjectManager = new POMManager(webDriverManager.getDriver());
       scenarioContext = new ScenarioContext();
    }

        public DriverManager getWebDriverManager() {
        return webDriverManager;
    }

        public POMManager getPageObjectManager() {
        return pageObjectManager;
    }

        public ScenarioContext getScenarioContext() {
        return scenarioContext;
    }


}