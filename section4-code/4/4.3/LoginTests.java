import org.openqa.selenium.firefox.FirefoxDriver;

import pageObjects.LoginPage;
import pageObjects.CreateAcctPage;

public class LoginTests {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "/Users/accraze/Downloads/geckodriver");
        FirefoxDriver driver = new FirefoxDriver();
        driver.get("http://localhost:8000");

        // Happy Path test - login succeeds

        // Perform actions with locators
        LoginPage.userName(driver).sendKeys("registeredUser");
        LoginPage.password(driver).sendKeys("1234");
        LoginPage.submit(driver).click();
        Thread.sleep(5000);
        String message = LoginPage.message(driver).getText();
        System.out.println(message);

        // Sad Path test - login fails
        // Locate web elements
        driver.get("http://localhost:8000");

        // Perform actions
        LoginPage.userName(driver).sendKeys("otherUser");
        LoginPage.password(driver).sendKeys("qwerty1234");
        LoginPage.submit(driver).click();
        Thread.sleep(5000);
        String message2 = LoginPage.message(driver).getText();
        System.out.println(message2);

        // Create acct
        LoginPage.createAcctLink(driver).click();

        Thread.sleep(5000);

        String header =  CreateAcctPage.header(driver).getText();
        System.out.println(header);

        driver.quit();
    }
}

