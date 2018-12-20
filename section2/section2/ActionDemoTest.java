import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class ActionDemoTest {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "/Users/accraze/Downloads/geckodriver");
        FirefoxDriver driver = new FirefoxDriver();
        driver.get("https://google.com");

        //locate the search box element
        WebElement searchBox = driver.findElement(By.name("q"));
        Thread.sleep(5000);

        //type in our search query into search box
        searchBox.sendKeys("seleniumhq" + Keys.RETURN);

        Thread.sleep(10000);
        System.out.println(driver.getTitle());
        driver.quit();
    }
}
