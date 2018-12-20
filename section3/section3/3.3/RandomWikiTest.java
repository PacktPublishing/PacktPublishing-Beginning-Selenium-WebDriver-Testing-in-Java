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

        // Find and print First Heading
        String firstHeading = driver.findElement(By.cssSelector(".firstHeading")).getText();
        System.out.println(firstHeading);

        // View Page Information
        driver.findElement(By.linkText("Page information")).click();
        Thread.sleep(5000);

        // New Search
        driver.findElement(By.name("search")).sendKeys("Selenium (software)" + Keys.RETURN);
        Thread.sleep(5000);

        // XPath Logo Click
        String xpath = "/html/body/div[4]/div[2]/div[1]/a";
        driver.findElement(By.xpath(xpath));
        Thread.sleep(5000);

        driver.quit();
    }
}
