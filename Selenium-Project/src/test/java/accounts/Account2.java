package accounts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Account2 {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://tek-retail-ui.azurewebsites.net/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));

        boolean signInButtonIsEnabled = driver.findElement(By.linkText("Sign in")).isEnabled();
        if (signInButtonIsEnabled){
            System.out.println("Sign in button is enabled");
        }else {
            System.out.println("Sign in button is disabled");
        }

        driver.findElement(By.partialLinkText("Sign")).click();
        driver.findElement(By.xpath("(//input[@class='login__input'])[1]")).sendKeys("jawid_g9@gmail.com");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Jawid123$");
        driver.findElement(By.xpath("//button[text()='Login']")).click();
        String shopByCategory = driver.findElement(By.className("home__categories-title")).getText();
        System.out.println(shopByCategory);


        //driver.quit();
    }
}
