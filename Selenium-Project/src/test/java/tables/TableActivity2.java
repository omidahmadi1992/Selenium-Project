package tables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class TableActivity2 {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        try {
            driver.get("https://dev.insurance.tekschool-students.com/");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

            wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Login"))).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))).sendKeys("supervisor");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password"))).sendKeys("tek_supervisor");
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Sign In']"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Plans"))).click();

            System.out.println("******** Plan prices *********");
            List<WebElement> planPricesElement = driver.findElements(By.xpath("//table/tbody/tr/td[3]"));
            for (WebElement planPrice : planPricesElement){
                System.out.println("The price is: " + planPrice.getText());
            }

            System.out.println("******** Plan Types *********");
            List<WebElement> planTypeElement = driver.findElements(By.xpath("//table/tbody/tr/td[2]"));
            for (WebElement planTypes : planTypeElement){
                System.out.println("The plan type is: " + planTypes.getText());
            }

            System.out.println("******** Date Created *********");
            List<WebElement> dateCreatedElement = driver.findElements(By.xpath("//table/tbody/tr/td[4]"));
            for (WebElement dateElement : dateCreatedElement){
                System.out.println("The date created is: " + dateElement.getText());
            }

            System.out.println("******** Date Expired *********");
            List<WebElement> dateExpiredElement = driver.findElements(By.xpath("//table/tbody/tr/td[5]"));
            for (WebElement dateExpire : dateExpiredElement){
                System.out.println("The date expires: " + dateExpire.getText());
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
