package practicePackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://tek-retail-ui.azurewebsites.net/");
        driver.manage().window().maximize();
        driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By.linkText("Create New Account")).click();
        driver.findElement(By.id("nameInput")).sendKeys("Jawid");

        String preFixEmail = "jawid_gul";
        int number = (int) (Math.random() * 100);
        String randomEmail = preFixEmail + number + "@gmail.com";

        driver.findElement(By.id("emailInput")).sendKeys(randomEmail);
        driver.findElement(By.id("passwordInput")).sendKeys("Jawid12345$");
        driver.findElement(By.id("confirmPasswordInput")).sendKeys("Jawid12345$");
        driver.findElement(By.id("signupBtn")).click();

        driver.quit();
    }
}
