package stepDef;

import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Context;

public class Hooks {
    Context context;
    public Hooks(Context context)
    {
        this.context = context;
    }
//	@Before
//    public void beforeScenario(){
//        System.out.println("This will run before the Scenario");
//    }
//'


    @AfterStep
    public void addScreenshot(Scenario scenario) {

//        context.getWebDriverManager()WebDriver driver =  setUp.baseTest.WebDriverManager();
//        if(scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) context.getWebDriverManager().getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "image");
//        }

    }

	@After
    public void afterScenario(){
        context.getWebDriverManager().tearDown();
    }
}