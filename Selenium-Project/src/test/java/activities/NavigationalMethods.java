package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class NavigationalMethods {
    public static void main(String[] args) {

        // Initialize WebDriver instance for Chrome
        WebDriver driver = new ChromeDriver();
        // Navigate to Google's homepage
        driver.get("https://google.com/");
        // Maximize the browser window
        driver.manage().window().maximize();
        // Set implicit wait timeout to 20 seconds for element visibility
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        // Set page load timeout to 20 seconds
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        // Enter "hyr tutorials" into the search input field and submit the form
        driver.findElement(By.id("APjFqb")).sendKeys("hyr tutorials");
        driver.findElement(By.id("gbqfbb")).submit();
        // Navigate to Facebook signup page
        driver.navigate().to("https://facebook.com/signup");
        // Enter "Jawid" into the first name input field
        driver.findElement(By.name("firstname")).sendKeys("Jawid");
        // Refresh the current page
        driver.navigate().refresh();
        // Navigate back to the previous page (Google search results)
        driver.navigate().back();
        // Navigate forward to the Facebook signup page again
        driver.navigate().forward();
        // Quit the WebDriver instance, closing all associated browser windows
        driver.quit();
    }
}
