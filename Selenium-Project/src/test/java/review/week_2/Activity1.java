package review.week_2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Random;


public class Activity1 {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://tek-retail-ui.azurewebsites.net/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#signinLink"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#email"))).sendKeys("jawid_g66@gmail.com");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#password"))).sendKeys("Jawid123$");
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#loginBtn"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#accountLink"))).click();

        WebElement phoneElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("personalPhoneInput")));
        phoneElement.clear();
        String number = getRandomPhoneNumber();
        phoneElement.sendKeys(number);
        System.out.println("Random number = " + number);

        wait.until(ExpectedConditions.elementToBeClickable(By.id("personalUpdateBtn"))).click();

        boolean isToastDisplayed = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("Toastify"))).isDisplayed();
        String toastText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".Toastify div.Toastify__toast-body > div:last-child"))).getText();
        System.out.println(toastText);

        if (isToastDisplayed)
            System.out.println("Test Passed Toast Displayed");
        else
            System.out.println("Test Failed");
        driver.quit();
    }
    private static String getRandomPhoneNumber() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            int digit = random.nextInt(10);
            sb.append(digit);
        }
        return sb.toString();
    }
}
