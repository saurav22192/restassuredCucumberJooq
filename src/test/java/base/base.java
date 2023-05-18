package base;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class base {
    public WebDriver driver;

    public void setup()
    {
        // Set up the wWebDriverManager for chrome driver
        WebDriverManager.chromedriver().setup();
        // Create the driver object
        driver = new ChromeDriver();
        if(driver==null)
        {
            driver = new ChromeDriver();
        }
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