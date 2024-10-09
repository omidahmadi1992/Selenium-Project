package accounts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TekRetailAccount {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://tek-retail-ui.azurewebsites.net/");
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
        String emailPrefix = "jawid_g";
        int number = (int) (Math.random() * 100);
        String randomEmail = emailPrefix + number + "@gmail.com";
        driver.findElement(By.id("emailInput")).sendKeys(randomEmail);
        driver.findElement(By.id("passwordInput")).sendKeys("Jawid123$");
        driver.findElement(By.id("confirmPasswordInput")).sendKeys("Jawid123$");
        driver.findElement(By.id("signupBtn")).click();
        Thread.sleep(3000);
        boolean isProfileImageDisplayed = driver.findElement(By.id("profileImage")).isDisplayed();

          if (isProfileImageDisplayed){
              System.out.println("Test passed and account has been created successfully!");
          }else {
              System.out.println("Test failed and account has not been created successfully");
          }

          driver.quit();
    }
}
