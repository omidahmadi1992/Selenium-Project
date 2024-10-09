package extra;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

public class HeadlessBrowsingActivity {
    public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://tek-retail-ui.azurewebsites.net/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        boolean signInLinkIsEnabled = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Sign in"))).isEnabled();
        if (signInLinkIsEnabled){
            System.out.println("Sign in button is enabled");
        }else {
            System.out.println("Sign in button is disabled");
        }

        wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Sign"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email"))).sendKeys("jawid_g9@gmail.com");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys("Jawid123$");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='loginBtn']"))).click();
        String titleText = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'TEK')]"))).getText();
        System.out.println("Actual TekSchool logo is : " + titleText);

        boolean accountBtnIsEnabled = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Account"))).isEnabled();
        if (accountBtnIsEnabled){
            System.out.println("Account button is enabled");
        }else {
            System.out.println("Account button is disabled");
        }

        boolean orderBtnIsEnabled = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Orders"))).isEnabled();
        if (orderBtnIsEnabled){
            System.out.println("Order button is enabled");
        }else {
            System.out.println("Order button is disabled");
        }

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".top-nav__btn[href='/profile']"))).click();
        boolean profileImageIsDisplayed = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("profileImage"))).isDisplayed();
        if (profileImageIsDisplayed){
            System.out.println("Profile image is displayed!");
        }else {
            System.out.println("Profile image is not displayed!");
        }

        WebElement phoneInputElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#personalPhoneInput")));
        phoneInputElement.clear();
        String randomNumber = getRandomPhoneNumber();
        phoneInputElement.sendKeys(randomNumber);
        System.out.println("Random phone number = " + randomNumber);

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#personalUpdateBtn"))).click();
        boolean confirmationPopUpMessageIsDisplayed = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='root']/div[2]"))).isDisplayed();
        if (confirmationPopUpMessageIsDisplayed){
            System.out.println("Confirmation message is displayed");
        }else {
            System.out.println("Confirmation message is not displayed");
        }

        String toastText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='root']/div[2]"))).getText();
        System.out.println(toastText);

        driver.quit();
    }

    private static String getRandomPhoneNumber(){
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i <= 10; i++){
            int digit = random.nextInt(10);
            stringBuilder.append(digit);
        }
       return stringBuilder.toString();
    }

}
