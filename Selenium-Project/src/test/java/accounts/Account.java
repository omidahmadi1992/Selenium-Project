package accounts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class Account {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://tek-retail-ui.azurewebsites.net/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));

        boolean signInButton = driver.findElement(By.linkText("Sign in")).isEnabled();
        if (signInButton){
            System.out.println("Sign in button is enabled");
        }else {
            System.out.println("Sign in button is disable");
        }
        driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By.id("email")).sendKeys("jawid_g9@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Jawid123$");
        driver.findElement(By.id("loginBtn")).click();
        String text2 = driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/div[2]/a")).getText();
        System.out.println(text2);

        String text = driver.findElement(By.linkText("TEKSCHOOL")).getText();
        System.out.println(text);

        driver.quit();
    }
}
