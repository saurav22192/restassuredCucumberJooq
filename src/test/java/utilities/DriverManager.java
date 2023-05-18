package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverManager {
    private WebDriver driver;
    public DriverManager(){
        setup();
    }
    public void setup()
    {
        // Set up the wWebDriverManager for chrome driver
        WebDriverManager.chromedriver().setup();
        // Create the driver object
        ChromeOptions co = new ChromeOptions();
        co.setHeadless(true);
        driver = new ChromeDriver(co);
    }
    public WebDriver getDriver(){
        return driver;
    }
    public void openBaseURL()
    {
        driver.get("https://www.google.com");
    }

    public void tearDown()
    {
        driver.quit();
    }
}
