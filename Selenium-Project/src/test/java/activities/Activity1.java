package activities;

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

            // Click on "Sign in" link
            wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Sign"))).click();

            // Enter email and password
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email"))).sendKeys("jawid_g66@gmail.com");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys("Jawid123$");

            // Click on the login button
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='loginBtn']"))).click();

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

            // Generate random passwords for newPassword and confirmNewPassword fields
            String previousPassword = "Jawid123$"; // Replace with actual previous password logic if needed
            String newPassword = generateRandomPassword();
            String confirmNewPassword = newPassword;

            // Enter generated passwords into the respective fields
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("previousPasswordInput"))).sendKeys(previousPassword);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("newPasswordInput"))).sendKeys(newPassword);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("confirmPasswordInput"))).sendKeys(confirmNewPassword);

            // Click on Change Password button
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Change Password']"))).click();

            // Check if confirmation message popup is displayed after changing the password
            boolean confirmationPopUpMessageIsDisplayed2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='root']/div[2]"))).isDisplayed();
            if (confirmationPopUpMessageIsDisplayed2){
                System.out.println("Confirmation message is displayed");
            } else {
                System.out.println("Confirmation message is not displayed");
            }

            // Get and print toast message
            String toastText2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='root']/div[2]"))).getText();
            System.out.println("Toast message after password change: " + toastText2);

        } catch (Exception e) {
            System.err.println("Error occurred: " + e.getMessage());
            // Handle exception as per your application's requirements
        } finally {
            // Quit WebDriver instance
            //driver.quit();
        }
    }

    // Method to generate a random password meeting specific criteria
    private static String generateRandomPassword() {
        String upperCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String specialChars = "!@#$%^&*()-_=+[{]}\\|;:'\",<.>/?";

        Random random = new Random();
        StringBuilder sb = new StringBuilder(8); // Length of the generated password

        // Ensure the password contains at least one uppercase letter, one lowercase letter, one digit, and one special character
        sb.append(upperCaseLetters.charAt(random.nextInt(upperCaseLetters.length())));
        sb.append(lowerCaseLetters.charAt(random.nextInt(lowerCaseLetters.length())));
        sb.append(numbers.charAt(random.nextInt(numbers.length())));
        sb.append(specialChars.charAt(random.nextInt(specialChars.length())));

        // Fill the rest of the password with random characters
        for (int i = 4; i < 8; i++) {
            String randomChars = upperCaseLetters + lowerCaseLetters + numbers + specialChars;
            sb.append(randomChars.charAt(random.nextInt(randomChars.length())));
        }

        // Shuffle the generated password to ensure randomness
        String password = sb.toString();
        char[] passwordArray = password.toCharArray();
        for (int i = 0; i < passwordArray.length; i++) {
            int randomIndex = random.nextInt(passwordArray.length);
            char temp = passwordArray[i];
            passwordArray[i] = passwordArray[randomIndex];
            passwordArray[randomIndex] = temp;
        }
        return new String(passwordArray);
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
