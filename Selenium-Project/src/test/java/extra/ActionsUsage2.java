package extra;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class ActionsUsage2 {
    public static void main(String[] args) throws InterruptedException {
        // Initialize the Chrome WebDriver
        WebDriver driver = new ChromeDriver();
        driver.get("https://retail.tekschool-students.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Create an instance of Actions class
        Actions actions = new Actions(driver);

        // Perform the scrolling to the bottom of the page
        // Use the WebElement to perform scroll actions
        WebElement body = driver.findElement(By.xpath("//*[contains(text(),'Our Latest Products')]"));
        actions.moveToElement(body).sendKeys(Keys.END).perform();

        // Optionally, you can add sleep to visualize the scroll action
        Thread.sleep(5000);

        // Close the browser
        //driver.quit();
    }

}
