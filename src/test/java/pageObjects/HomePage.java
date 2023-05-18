package pageObjects;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;
    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new
                WebDriverWait(this.driver,Duration.ofSeconds(1));
    }

    @FindBy (name ="q") WebElement searchBox;

    public void search(String searchKey)
    {
        wait.until(ExpectedConditions.visibilityOf(searchBox));
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {

        }
        searchBox.clear();
        searchBox.sendKeys(searchKey);

    }
    public void enterSearch()
    {
        searchBox.sendKeys(Keys.ENTER);

    }
}