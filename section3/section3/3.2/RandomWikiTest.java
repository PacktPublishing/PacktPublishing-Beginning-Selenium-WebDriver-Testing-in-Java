import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class RandomWikiTest {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "/Users/t33kt33k/Downloads/geckodriver");
        FirefoxDriver driver = new FirefoxDriver();
        driver.get("https://en.wikipedia.org");
        driver.findElement(By.cssSelector("#n-randompage")).click();
        Thread.sleep(5000);
        System.out.println(driver.getTitle());

        // Print First Heading
        String firstHeading = driver.findElement(By.cssSelector(".firstHeading")).getText();
        System.out.println(firstHeading);

        // View Page Info
        driver.findElement(By.linkText("Page information")).click();
        Thread.sleep(5000);

        // New Search
        driver.findElement(By.name("search")).sendKeys("Selenium (software)" + Keys.RETURN);
        Thread.sleep(5000);

        driver.quit();
    }
}
