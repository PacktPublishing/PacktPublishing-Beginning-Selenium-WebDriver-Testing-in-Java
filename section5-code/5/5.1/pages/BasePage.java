package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;

    //Constructor
    public BasePage (WebDriver driver){
        this.driver = driver;
    }

    //Click Method
    public void click (WebElement element) {
        element.click();
    }

    //Write Text
    public void writeText (WebElement element, String text) {
        element.sendKeys(text);
    }

    //Read Text
    public String readText (WebElement element) {
        return element.getText();
    }

    //Assert
    public void assertEquals (WebElement element, String expectedText) {
        Assert.assertEquals(readText(element), expectedText);

    }
}
