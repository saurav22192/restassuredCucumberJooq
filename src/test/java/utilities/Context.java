package utilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import pageObjects.HomePage;
import pageObjects.SearchPage;

public class Context  {
    private DriverManager webDriverManager;
    private POMManager pageObjectManager;
    public ScenarioContext scenarioContext;

    public Context()
    {
       webDriverManager = new DriverManager();
//       System.out.println("i am here");
//       pageObjectManager = new POMManager(webDriverManager.getDriver());
       scenarioContext = new ScenarioContext();
    }

        public DriverManager getWebDriverManager() {
        return webDriverManager;
    }

        public POMManager getPageObjectManager() {
        return pageObjectManager;
    }

    public void setPageObjectManager(POMManager pm){
        this.pageObjectManager=pm;
    }

        public ScenarioContext getScenarioContext() {
        return scenarioContext;
    }


}