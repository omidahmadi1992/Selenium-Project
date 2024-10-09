package synchronization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExampleOfSynchro {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://tek-retail-ui.azurewebsites.net/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        WebElement signInLinkElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#signinLink")));
        signInLinkElement.click();

        WebElement emailElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#email")));
        emailElement.sendKeys("jawid_g66@gmail.com");

        WebElement passwordElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#password")));
        passwordElement.sendKeys("Jawid123$");

        WebElement logInBtnElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#loginBtn")));
        logInBtnElement.click();

        WebElement accountLinkElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#accountLink")));
        accountLinkElement.click();

        String emailText = driver.findElement(By.cssSelector("#accountInformation > div.account__information-detail-wrapper " +
                "> div > h1.account__information-email")).getText();
        System.out.println(emailText);
        //driver.quit();

    }
}
