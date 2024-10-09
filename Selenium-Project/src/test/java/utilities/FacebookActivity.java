package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class FacebookActivity {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Create new account"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("firstname"))).sendKeys("Jawid");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("lastname"))).sendKeys("Gulzai");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("reg_email__"))).sendKeys("9169169999");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password_step_input"))).sendKeys("Jawid123$");

        WebElement monthsElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("month")));
        Select monthSelect = new Select(monthsElement);
        //monthSelect.selectByVisibleText("May");
        monthSelect.selectByIndex(4);
       // monthSelect.selectByValue("5");

        WebElement dayElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("day")));
        Select daysSelect = new Select(dayElement);
        daysSelect.selectByIndex(4);

        WebElement yearElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("year")));
        Select yearSelect = new Select(yearElement);
        yearSelect.selectByValue("1995");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='2']"))).click();

        driver.quit();
    }
}
