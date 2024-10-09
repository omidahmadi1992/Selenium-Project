package extra;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ArrowHandling2 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://tek-retail-ui.azurewebsites.net/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String mainTab = driver.getWindowHandle();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.findElement(By.linkText("Test Selenium")).click();
        for(String tab : driver.getWindowHandles()){
            System.out.println(tab);
            if(!tab.equals(mainTab)){
                driver.switchTo().window(tab);
                break;
            }
        }
        driver.findElement(By.linkText("Inputs")).click();
        driver.findElement(By.name("text")).sendKeys("Handle new Window");
        driver.findElement(By.id("emailInput")).sendKeys("wrongemail@gmail.com");
        By rangeLocator = By.id("rangeInput");
        Thread.sleep(5000);
        WebElement rangeElement = wait.until(ExpectedConditions.visibilityOfElementLocated(rangeLocator));
        for (int i = 0; i < 50; i ++) {
            //SendKeys can send Keyboard keys to an Element,
            rangeElement.sendKeys(Keys.ARROW_RIGHT);
        }
        driver.close();
        driver.switchTo().window(mainTab);
        driver.findElement(By.linkText("Sign in")).click();
        driver.quit();
    }
}
