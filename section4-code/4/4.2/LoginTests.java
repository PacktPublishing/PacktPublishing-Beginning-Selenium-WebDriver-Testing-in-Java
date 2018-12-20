import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;

public class LoginTests {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "/Users/accraze/Downloads/geckodriver");
        FirefoxDriver driver = new FirefoxDriver();
        driver.get("http://localhost:8000");

        // Happy Path test - login succeeds
        // Locate web elements
        WebElement username = driver.findElement(By.cssSelector("#username"));
        WebElement password = driver.findElement(By.cssSelector("#password"));
        WebElement submit = driver.findElement(By.name("submit"));

        // Perform actions
        username.sendKeys("registeredUser");
        password.sendKeys("1234");
        submit.click();
        Thread.sleep(5000);
        String message = driver.findElement(By.cssSelector("#auth-message")).getText();
        System.out.println(message);

        // Sad Path test - login fails
        // Locate web elements
        driver.get("http://localhost:8000");
        WebElement username2 = driver.findElement(By.cssSelector("#username"));
        WebElement password2 = driver.findElement(By.cssSelector("#password"));
        WebElement submit2 = driver.findElement(By.name("submit"));

        // Perform actions
        username2.sendKeys("otherUser");
        password2.sendKeys("qwerty1234");
        submit2.click();
        Thread.sleep(5000);
        String message2 = driver.findElement(By.cssSelector("#auth-message")).getText();
        System.out.println(message2);

        // Create acct
        WebElement createAccountLink = driver.findElement(By.linkText("Create an account"));
        createAccountLink.click();

        Thread.sleep(5000);

        String header = driver.findElement(By.cssSelector("#header")).getText();
        System.out.println(header);

        driver.quit();
    }
}

