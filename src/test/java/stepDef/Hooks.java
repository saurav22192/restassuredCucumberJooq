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
    private static boolean homeFeatureRunning = false;
	@Before
    public void beforeScenario(Scenario s){
        if(!homeFeatureRunning && s.getName().contains("homepage 1")){
            homeFeatureRunning = true;
            System.out.println("Home feature running");
        }
    }



    @AfterStep("@ui")
    public void addScreenshot(Scenario scenario) {

//        context.getWebDriverManager()WebDriver driver =  setUp.baseTest.WebDriverManager();
        if(scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) context.getWebDriverManager().getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "image");
        }

    }

	@After("@ui")
    public void afterScenario(Scenario s){
        context.getWebDriverManager().tearDown();
        if(homeFeatureRunning && s.getName().contains("homepage 1")){
            homeFeatureRunning = true;
            System.out.println("Home feature stopped");
        }
    }
}