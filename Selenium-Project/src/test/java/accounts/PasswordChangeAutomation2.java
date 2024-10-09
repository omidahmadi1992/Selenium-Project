package accounts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

public class PasswordChangeAutomation2 {

    public static void main(String[] args) {
        // Initialize WebDriver (ChromeDriver in this case)
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to the website
            driver.get("https://tek-retail-ui.azurewebsites.net/");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));

            // Initialize WebDriverWait
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

            // Check if "Sign in" link is enabled
            boolean signInLinkIsEnabled = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Sign in"))).isEnabled();
            if (signInLinkIsEnabled){
                System.out.println("Sign in button is enabled");
            } else {
                System.out.println("Sign in button is disabled");
            }

            // Click on "Sign in" link
            wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Sign"))).click();

            // Enter email and password
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email"))).sendKeys("jawid_g9@gmail.com");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys("Jawid123$");

            // Click on the login button
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='loginBtn']"))).click();

            // Verify TEKSchool logo text
            String titleText = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'TEK')]"))).getText();
            System.out.println("Actual TekSchool logo is : " + titleText);

            // Check if "Account" button is enabled
            boolean accountBtnIsEnabled = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Account"))).isEnabled();
            if (accountBtnIsEnabled){
                System.out.println("Account button is enabled");
            } else {
                System.out.println("Account button is disabled");
            }

            // Check if "Orders" button is enabled
            boolean orderBtnIsEnabled = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Orders"))).isEnabled();
            if (orderBtnIsEnabled){
                System.out.println("Order button is enabled");
            } else {
                System.out.println("Order button is disabled");
            }

            // Click on profile button
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".top-nav__btn[href='/profile']"))).click();

            // Check if the profile image is displayed
            boolean profileImageIsDisplayed = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("profileImage"))).isDisplayed();
            if (profileImageIsDisplayed){
                System.out.println("Profile image is displayed!");
            } else {
                System.out.println("Profile image is not displayed!");
            }

            // Generate a random phone number and enter it
            WebElement phoneInputElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#personalPhoneInput")));
            phoneInputElement.clear();
            String randomNumber = generateRandomPhoneNumber();
            phoneInputElement.sendKeys(randomNumber);
            System.out.println("Random phone number = " + randomNumber);

            // Click on update button
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#personalUpdateBtn"))).click();

            // Check if confirmation message popup is displayed
            boolean confirmationPopUpMessageIsDisplayed = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='root']/div[2]"))).isDisplayed();
            if (confirmationPopUpMessageIsDisplayed){
                System.out.println("Confirmation message is displayed");
            } else {
                System.out.println("Confirmation message is not displayed");
            }

            // Get and print toast message
            String toastText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='root']/div[2]"))).getText();
            System.out.println(toastText);

            // Generate random passwords for previousPassword, newPassword, and confirmPassword fields
            String previousPassword = generateRandomPassword("Jawid");
            String newPassword = generateRandomPassword("Jawid-");
            String confirmNewPassword = generateRandomPassword("Jawid-");

            // Enter generated passwords into the respective fields
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("previousPasswordInput"))).sendKeys(previousPassword);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("newPasswordInput"))).sendKeys(newPassword);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("confirmPasswordInput"))).sendKeys(confirmNewPassword);

            if (!newPassword.equals(confirmNewPassword)) {
                System.out.println("New Password and Confirm Password do not match!");
                return; // Exit the method if passwords do not match
            }

            // Click on Change Password button
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Change Password']"))).click();

            boolean confirmationPopUpMessageIsDisplayed2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='root']/div[2]"))).isDisplayed();
            if (confirmationPopUpMessageIsDisplayed2){
                System.out.println("Confirmation message is displayed");
            }else {
                System.out.println("Confirmation message is not displayed");
            }

            String toastText2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='root']/div[2]"))).getText();
            System.out.println(toastText2);


        } catch (Exception e) {
            System.err.println("Error occurred: " + e.getMessage());
            // Handle exception as per your application's requirements
        } finally {
            // Quit WebDriver instance
            //driver.quit();
        }
    }

    // Method to generate a random password with a given prefix
    private static String generateRandomPassword(String prefix) {
        Random random = new Random();
        int number = random.nextInt(100); // Generate a random number between 0 and 99
        return prefix + number; // Concatenate prefix and random number to form the password
    }

    // Method to generate a random phone number
    private static String generateRandomPhoneNumber(){
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++){ // Generate a 10-digit phone number
            int digit = random.nextInt(10); // Generate a random digit between 0 and 9
            sb.append(digit); // Append the digit to StringBuilder
        }
        return sb.toString(); // Convert StringBuilder to String and return
    }
}
