package extra;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class ArrowHandling1 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://tek-retail-ui.azurewebsites.net/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        String currentWindowId = driver.getWindowHandle();
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Test Selenium"))).click();
        Thread.sleep(4000);

        Set<String> allTabs = driver.getWindowHandles();
        for (String tab : allTabs){
            if (!tab.equals(currentWindowId)){
                driver.switchTo().window(tab);
                break;
            }
        }
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Inputs"))).click();

        WebElement rangeInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("rangeInput")));
       for (int i = 0; i <50; i++){
           rangeInput.sendKeys(Keys.ARROW_RIGHT);
       }

    }
}
