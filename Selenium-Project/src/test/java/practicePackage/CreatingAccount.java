package practicePackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class CreatingAccount {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://tek-retail-ui.azurewebsites.net/");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();

        boolean signInBtnIsEnabled = driver.findElement(By.linkText("Sign in")).isEnabled();
        if (signInBtnIsEnabled){
            System.out.println("Sign in button is enabled");
        }else {
            System.out.println("Sign in button is disabled");
        }
        driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By.id("newAccountBtn")).click();
        driver.findElement(By.id("nameInput")).sendKeys("Jawid");
        String emailPrefix = "jawid-g";
        int number = (int) (Math.random() * 100);
        String randomEmail = emailPrefix + number + "@gmail.com";
        driver.findElement(By.id("emailInput")).sendKeys(randomEmail);
        driver.findElement(By.id("passwordInput")).sendKeys("Jawid123$");
        driver.findElement(By.id("confirmPasswordInput")).sendKeys("Jawid123$");
        driver.findElement(By.id("signupBtn")).click();
        boolean isProfileDisplayed = driver.findElement(By.id("profileImage")).isDisplayed();

        if (isProfileDisplayed){
            System.out.println("Profile image is displayed");
        }else {
            System.out.println("Profile image is no displayed");
        }
        driver.quit();
    }
}
