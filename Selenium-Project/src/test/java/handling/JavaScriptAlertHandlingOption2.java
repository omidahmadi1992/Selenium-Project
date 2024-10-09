package handling;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class JavaScriptAlertHandlingOption2 {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://tek-retail-ui.azurewebsites.net/selenium/javascript-alerts");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Option2
        wait.until(ExpectedConditions.elementToBeClickable(By.id("promptBtn"))).click();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.sendKeys("The alert has been commented");
        alert.accept();
       // alert.dismiss();

        String text = driver.findElement(By.id("message")).getText();
        System.out.println(text);
        driver.quit();

    }
}
