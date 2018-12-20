import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import pageObjects.CreateAcctPage;

@Test()
public class LoginTests {
    public String baseURL = "http://localhost:8000";
    public FirefoxDriver driver;

    @BeforeTest
    public void setup(){
        System.setProperty("webdriver.gecko.driver", "/Users/accraze/Downloads/geckodriver");
        driver = new FirefoxDriver();
        driver.get(baseURL);
    }

    @Test()
    public void testLoginSucceed() throws InterruptedException {
        // Happy Path test - login succeeds
        // Perform actions with locators
        LoginPage.userName(driver).sendKeys("registeredUser");
        LoginPage.password(driver).sendKeys("1234");
        LoginPage.submit(driver).click();
        Thread.sleep(5000);
        String message = LoginPage.message(driver).getText();
        String expectedMessage = "Welcome back,\n" + "registeredUser";
        Assert.assertEquals(message, expectedMessage);

    }

    @Test()
    public void testLoginFail() throws InterruptedException {
        // Sad Path test - login fails
        // Perform actions
        LoginPage.userName(driver).sendKeys("otherUser");
        LoginPage.password(driver).sendKeys("qwerty1234");
        LoginPage.submit(driver).click();
        Thread.sleep(5000);
        String message = LoginPage.message(driver).getText();
        System.out.println(message);
        String expectedMessage = "Account not found. Please sign up by clicking the link below";
        Assert.assertEquals(message, expectedMessage);

        // Create acct
        LoginPage.createAcctLink(driver).click();
        Thread.sleep(5000);
        String header =  CreateAcctPage.header(driver).getText();
        System.out.println(header);
        String expectedHeader = "Create an Account";
        Assert.assertEquals(header, expectedHeader);
    }

    @AfterTest
    public void endSession(){
        driver.quit();
    }
}

