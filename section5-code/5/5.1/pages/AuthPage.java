package pages;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import pageObjects.LoginPage;
import pageObjects.CreateAcctPage;

public class AuthPage extends BasePage{

    //*********Constructor*********
    public AuthPage(WebDriver driver) {
        super(driver);
    }

    //*********Web Elements*********
    WebElement usernameLocator =  LoginPage.userName(driver);
    WebElement passwordLocator = LoginPage.password(driver);
    WebElement loginButtonLocator = LoginPage.submit(driver);
    WebElement welcomeMessageLocator = LoginPage.message(driver);
    WebElement createAcctLinkLocator = LoginPage.createAcctLink(driver);
    WebElement createAcctHeaderLocator = CreateAcctPage.header(driver);

    //*********Page Methods*********

    public AuthPage authenticate (String username, String password){
        //Enter Username
        writeText(usernameLocator,username);
        //Enter Password
        writeText(passwordLocator, password);
        //Click Login Button
        click(loginButtonLocator);
        return this;
    }

    //Verify Username Condition
    public AuthPage verifyLogin (String expectedText) {
        assertEquals(welcomeMessageLocator, expectedText);
        return this;
    }

    //click Create Account
    public AuthPage clickCreateAccount () {
        //Click Login Button
        click(createAcctLinkLocator);
        return this;
    }

    //Verify Create Account Page Condition
    public AuthPage verifySignupPage (String expectedText) {
        assertEquals(createAcctHeaderLocator, expectedText);
        return this;
    }
}
