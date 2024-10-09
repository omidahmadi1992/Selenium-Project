package review.week_2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Activity3 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://tek-retail-ui.azurewebsites.net/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        boolean signInLinkIsEnabled = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Sign in"))).isEnabled();
        if (signInLinkIsEnabled){
            System.out.println("Sign in button is enabled");
        }else {
            System.out.println("Sign in button is disabled");
        }

        wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Sign"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email"))).sendKeys("jawid_g66@gmail.com");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys("Jawid123$");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='loginBtn']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".top-nav__btn[href='/profile']"))).click();

        //driver.quit();

    }
}
