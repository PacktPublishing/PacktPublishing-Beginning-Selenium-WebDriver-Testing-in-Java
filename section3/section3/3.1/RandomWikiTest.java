import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;

public class RandomWikiTest {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "/Users/t33kt33k/Downloads/geckodriver");
        FirefoxDriver driver = new FirefoxDriver();
        driver.get("https://en.wikipedia.org");
        driver.findElement(By.cssSelector("#n-randompage")).click();
        Thread.sleep(5000);
        System.out.println(driver.getTitle());
        driver.quit();
    }
}
