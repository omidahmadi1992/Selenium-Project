package handling;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertActivity1 {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        try {
            driver.get("https://tek-retail-ui.azurewebsites.net/selenium");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

            wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Javascript Alerts"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.id("alertBtn"))).click();

            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            System.out.println(alertText);
            alert.accept();

            wait.until(ExpectedConditions.elementToBeClickable(By.id("confirmBtn"))).click();
            Alert confirmAlert = wait.until(ExpectedConditions.alertIsPresent());
            String confirmAlertText = confirmAlert.getText();
            System.out.println(confirmAlertText);
            confirmAlert.accept();

            wait.until(ExpectedConditions.elementToBeClickable(By.id("promptBtn"))).click();
            Alert promptAlert = driver.switchTo().alert();
            promptAlert.sendKeys("Jawid learns java");
            promptAlert.accept();

            String text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message"))).getText();
            System.out.println(text);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            driver.quit();
        }
    }
}
