package practicePackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

public class PhoneUpdating {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://tek-retail-ui.azurewebsites.net/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Sign"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email"))).sendKeys("jawid_g66@gmail.com");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys("Jawid123$");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='loginBtn']"))).click();
        String titleText = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'TEK')]"))).getText();
        System.out.println("Actual TekSchool logo is : " + titleText);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".top-nav__btn[href='/profile']"))).click();

        WebElement phoneInputElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("personalPhoneInput")));
        phoneInputElement.clear();
        String phoneNumber = generateRandomPhoneNumber();
        phoneInputElement.sendKeys(phoneNumber);

        wait.until(ExpectedConditions.elementToBeClickable(By.id("personalUpdateBtn"))).click();
        boolean popUpMessageConfirmation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=root]/div[2]"))).isDisplayed();
        if (popUpMessageConfirmation){
            System.out.println("Popup confirmation message is displayed");
        }else {
            System.out.println("Popup confirmation message is not displayed");
        }

        driver.quit();
    }

    public static String generateRandomPhoneNumber(){
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i <= 10; i++){
            int digit = random.nextInt(10);
            sb.append(digit);
        }
        return sb.toString();
    }

}
