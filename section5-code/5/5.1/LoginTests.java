import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.AuthPage;

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
        AuthPage authPage = new AuthPage(driver);
        String expectedMessage = "Welcome back,\n" + "registeredUser";
        authPage.authenticate("registeredUser", "1234")
                .verifyLogin(expectedMessage);
        Thread.sleep(5000);
    }

    @Test()
    public void testLoginFail() throws InterruptedException {
        // Sad Path test - login fails
        AuthPage authPage = new AuthPage(driver);
        String expectedMessage = "Account not found. Please sign up by clicking the link below";
        String expectedHeader = "Create an Account";
        authPage.authenticate("otherUser", "qwerty1234")
                .verifyLogin(expectedMessage)
                .clickCreateAccount()
                .verifySignupPage(expectedHeader);
    }

    @AfterTest
    public void endSession(){
        driver.quit();
    }
}

