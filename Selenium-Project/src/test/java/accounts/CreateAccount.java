package accounts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CreateAccount {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://tek-retail-ui.azurewebsites.net/");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        boolean signInBtnIsEnabled = driver.findElement(By.linkText("Sign in")).isEnabled();
        if (signInBtnIsEnabled) {
            System.out.println("Sign in button is enabled");
        } else {
            System.out.println("Sign in button is disabled");
        }
        By signInLinkLocator = By.linkText("Sign in");
        WebElement signInLinkElement = wait.until(ExpectedConditions.elementToBeClickable(signInLinkLocator));
        signInLinkElement.click();

        By createNewAccountLocator = By.linkText("Create New Account");
        WebElement createNewAccountElement = wait.until(ExpectedConditions.elementToBeClickable(createNewAccountLocator));
        createNewAccountElement.click();

        By nameInputLocator = By.id("nameInput");
        WebElement nameInputElement = wait.until(ExpectedConditions.visibilityOfElementLocated(nameInputLocator));
        nameInputElement.sendKeys("JawidG");

        String emailPrefix = "Jawid";
        int number = (int) (Math.random() * 100);
        String randomEmail = emailPrefix + number + "@gmail.com";

        By emailInputLocator = By.id("emailInput");
        WebElement emailInputElement = wait.until(ExpectedConditions.visibilityOfElementLocated(emailInputLocator));
        emailInputElement.sendKeys(randomEmail);

        By passwordInputLocator = By.id("passwordInput");
        WebElement passwordInputElement = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInputLocator));
        passwordInputElement.sendKeys("Jawid123$");

        By confirmPasswordInputLocator = By.id("confirmPasswordInput");
        WebElement confirmPasswordInputElement = wait.until(ExpectedConditions.visibilityOfElementLocated(confirmPasswordInputLocator));
        confirmPasswordInputElement.sendKeys("Jawid123$");

        By signUpBtnLocator = By.id("signupBtn");
        WebElement signUpBtnElement = wait.until(ExpectedConditions.elementToBeClickable(signUpBtnLocator));
        signUpBtnElement.click();

        By profileImageLocator = By.id("profileImage");
        WebElement profileImageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(profileImageLocator));
        boolean isProfileImageDisplayed = profileImageElement.isDisplayed();

        if (isProfileImageDisplayed) {
            System.out.println("Profile image is displayed");
        } else {
            System.out.println("Profile image is not displayed");
        }
        By userNameLocator = By.className("account__information-username");
        WebElement userNameElement = wait.until(ExpectedConditions.presenceOfElementLocated(userNameLocator));
        boolean userNameIsDisplayed = userNameElement.isDisplayed();
        if (userNameIsDisplayed) {
            System.out.println("User name is displayed! " + true);
        } else {
            System.out.println("User name is not displayed " + false);
        }
        //driver.quit();
    }
}
