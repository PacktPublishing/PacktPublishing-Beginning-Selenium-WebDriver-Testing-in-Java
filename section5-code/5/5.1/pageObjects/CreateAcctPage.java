package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateAcctPage {
    private static WebElement element = null;

    public static WebElement header(WebDriver driver){

        element = driver.findElement(By.cssSelector("#header"));

        return element;

    }
}

