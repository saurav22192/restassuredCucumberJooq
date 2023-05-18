package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchPage {
    WebDriver driver;
    WebDriverWait wait;
    public SearchPage(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(1));
    }

    @FindBy (xpath ="") WebElement Title;

    public String getPageTitle()
    {
        return driver.getTitle();
    }
}