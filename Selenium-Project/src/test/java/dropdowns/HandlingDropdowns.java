package dropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;


public class HandlingDropdowns {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://tek-retail-ui.azurewebsites.net/");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Sign in"))).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email"))).sendKeys("jawid_g9@gmail.com");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys("Jawid123$");
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='loginBtn']"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Test Selenium"))).click();
            // Switch to the new window or frame after clicking "Test Selenium" link
            switchToNewWindow(driver);
            wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Drop Down"))).click();
            WebElement selectProgrammingLanguage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("programmingLanguageSelect")));
            selectProgrammingLanguage.click();
            // Assuming select is a valid Select element
            Select select = new Select(selectProgrammingLanguage);
            //select.selectByIndex(2);// Replace with actual selection logic
            select.selectByVisibleText("PHP");
            // Optionally, switch back to the main window if needed
            //driver.switchTo().defaultContent();

            // Get all options from the dropdown
            List<WebElement> options = select.getOptions();
            System.out.println("Printing all options from the dropdown:");
            for (WebElement option : options) {
                System.out.println(option.getText());
            }

        } catch (Exception e) {
            System.err.println("Error occurred: " + e.getMessage());
            e.printStackTrace(); // Print stack trace for detailed error analysis
        } finally {
            driver.quit();
        }
    }

    private static void switchToNewWindow(WebDriver driver) {
        // Get the handle of the main window
        String mainWindowHandle = driver.getWindowHandle();
        // Iterate through all available window handles
        for (String handle : driver.getWindowHandles()) {
            // Check if the current handle is not equal to the main window handle
            if (!handle.equals(mainWindowHandle)) {
                // Switch WebDriver's focus to the new window identified by 'handle'
                driver.switchTo().window(handle);
                // Exit the loop after switching to the new window
                break;
            }
        }
    }
}