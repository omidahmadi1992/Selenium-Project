package review.week_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity1 {
    public static void main(String[] args) throws InterruptedException {

        /*
        In the Retail app, click on sign in then click on Create new Account,
        then fill up the form and sign up. Expectation is to Create a new Account.
        Once an account is created, make sure profile picture is displayed. (isDisplayed)
        And print result of isDisplayed method.
        Push to your repository
         */

        WebDriver driver = new ChromeDriver();
        Thread.sleep(3000);
        driver.get("https://tek-retail-ui.azurewebsites.net/");
        driver.manage().window().maximize();

        By signInLocator = By.linkText("Sign in");
        WebElement signInElement = driver.findElement(signInLocator);
        signInElement.click();

        By createNewAccountLocator = By.linkText("Create New Account");
        WebElement createNewAccountElement = driver.findElement(createNewAccountLocator);
        createNewAccountElement.click();

        By nameLocator = By.id("nameInput");
        WebElement nameElement = driver.findElement(nameLocator);
        nameElement.sendKeys("Jawid");

        String emailPrefix = "jawid_spartans";
        int number = (int) (Math.random() * 100);
        String randomEmail = emailPrefix + number + "@gmail.com";

        By emailLocator = By.id("emailInput");
        WebElement emailElement = driver.findElement(emailLocator);
        emailElement.sendKeys(randomEmail);

        By passwordLocator = By.id("passwordInput");
        WebElement passwordElement = driver.findElement(passwordLocator);
        passwordElement.sendKeys("Jawid4321@$$");

        By confirmPasswordLocator = By.id("confirmPasswordInput");
        WebElement confirmPasswordElement = driver.findElement(confirmPasswordLocator);
        confirmPasswordElement.sendKeys("Jawid4321@$$");

        By signUpLocator = By.id("signupBtn");
        WebElement signUpElement = driver.findElement(signUpLocator);
        signUpElement.click();

        Thread.sleep(1000);
        By profileLocator = By.id("profileImage");
        WebElement profileElement = driver.findElement(profileLocator);
        boolean isProfileDisplayed = profileElement.isDisplayed();

        if (isProfileDisplayed){
            System.out.println("Test Passed");
        }else {
            System.out.println("Test Failed");
        }
        driver.quit();
    }
}
