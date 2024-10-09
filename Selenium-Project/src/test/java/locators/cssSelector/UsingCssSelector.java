package locators.cssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class UsingCssSelector {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://tek-retail-ui.azurewebsites.net/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));

        driver.findElement(By.cssSelector("#signinLink")).click();
        driver.findElement(By.cssSelector("#email")).sendKeys("jawid_g66@gmail.com");
        driver.findElement(By.cssSelector("#password")).sendKeys("Jawid123$");
        driver.findElement(By.cssSelector("#loginBtn")).click();
        driver.findElement(By.cssSelector("#accountLink")).click();
        String emailText = driver.findElement(By.cssSelector("#accountInformation > div.account__information-detail-wrapper > div > h1.account__information-email")).getText();
        System.out.println(emailText);
        driver.quit();

    }
}
