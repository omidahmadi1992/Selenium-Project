package extra;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Set;

public class ArrowHandling3 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://tek-retail-ui.azurewebsites.net/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        String currentWindowId = driver.getWindowHandle();

        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Test Selenium"))).click();
        Thread.sleep(4000);  // Wait for the new tab to open

        Set<String> allTabs = driver.getWindowHandles();
        for (String tab : allTabs) {
            if (!tab.equals(currentWindowId)) {
                driver.switchTo().window(tab);
                break;
            }
        }

        // Click on the "Inputs" link
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Inputs"))).click();
        // Locate the button or control to increase the number
        WebElement increaseButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("numberInput"))); // Adjust this locator

        // Click on the increase button until the number is 20
        for (int i = 0; i < 20; i++) {
            increaseButton.click();
            // Optionally, wait for the number to update
            Thread.sleep(500);  // Wait for the number to update, adjust the delay as necessary
        }

        // Verify the final value
        String finalValue = increaseButton.getAttribute("value");
        System.out.println("Final value: " + finalValue);

        driver.quit();
    }
}
