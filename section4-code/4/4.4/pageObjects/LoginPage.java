package pageObjects;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

public class LoginPage {
    private static WebElement element = null;

    public static WebElement userName(WebDriver driver){

        element = driver.findElement(By.cssSelector("#username"));

        return element;

    }

    public static WebElement password(WebDriver driver){

        element = driver.findElement(By.cssSelector("#password"));

        return element;

    }

    public static WebElement submit(WebDriver driver){

        element = driver.findElement(By.name("submit"));

        return element;

    }

    public static WebElement createAcctLink(WebDriver driver){

        element = driver.findElement(By.linkText("Create an account"));

        return element;

    }

    public static WebElement message(WebDriver driver){

        element = driver.findElement(By.cssSelector("#auth-message"));

        return element;

    }
}

