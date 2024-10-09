package extra;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class WebElementMethods {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().deleteAllCookies();
        driver.get("https://tek-retail-ui.azurewebsites.net/auth/login");
        WebElement email = driver.findElement(By.id("email"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("loginBtn"));
        email.sendKeys("jawid90@gmail.com");
        password.sendKeys("Tek12345$");
        loginButton.isDisplayed();
        loginButton.isEnabled();
        loginButton.click();
        email.getText();
        email.getTagName();
        email.getAttribute("id");
        driver.quit();

    }

}
