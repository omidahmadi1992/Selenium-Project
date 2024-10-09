package extra;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class Screenshot2 {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        try {
            driver.get("https://tek-retail-ui.azurewebsites.net/");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            // Take a screenshot of the entire page
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            // Define the location to save the screenshot
            File destinationFile = new File("screenshot.png");
            // Copy the screenshot file to the desired location
            FileHandler.copy(screenshot, destinationFile);
            System.out.println("Screenshot taken and saved as screenshot.png");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
