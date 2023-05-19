package runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(        features = "src/test/resources/features"
        ,glue={"stepDef"},
        plugin= {"pretty", "html:test-output","json:target/cucumber/cucumber.json", "html:target/cucumber-html-report"},
        monochrome = true,
//dryRun = true,
        tags = "@test_rest"
)

public class TestNgRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}