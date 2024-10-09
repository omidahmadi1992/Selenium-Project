package extra;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UsefulMethods {

    private static WebDriver driver;
    public static void main(String[] args) {
        openBrowser("https://retail.tekschool-students.com");
        click(By.linkText("Sign in"));
        sendKeys(By.name("email"), "jawid_g9@gmail.com");
        sendKeys(By.name("password"), "Jawid123$");
        click(By.id("loginBtn"));
        click(By.linkText("Account"));
        sendKeys(By.name("cardNumber"), "1234567891234566");
        sendKeys(By.name("nameOnCard"), "Jawid");
        selectByVisibleText(By.name("expirationYear"), "2025");
        selectByVisibleText(By.name("expirationMonth"), "5");
        sendKeys(By.name("securityCode"), "123");
        click(By.id("paymentSubmitBtn"));
        String text = getText(By.xpath("//*[@id='accountInformation']/div[1]/div/h1[2]"));
        System.out.println(text);
        driver.quit();
    }
    private static void openBrowser(String url) {
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    private static void click(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }
    private static void sendKeys(By locator, String value) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator)).sendKeys(value);
    }
    private static void selectByVisibleText(By locator, String text) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }
    private static String getText(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator)).getText();
    }
}
