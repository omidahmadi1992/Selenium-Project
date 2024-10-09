package handling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class FrameHandling2 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://tek-retail-ui.azurewebsites.net/selenium/iframe");

        String mainText = driver.findElement(By.id("title")).getText();
        System.out.println(mainText);
        
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe")));
        String insideFrame = driver.findElement(By.xpath("html/body/h1")).getText();
        System.out.println(insideFrame);

        driver.switchTo().defaultContent();

        mainText = driver.findElement(By.id("title")).getText();
        System.out.println(mainText);
       // driver.quit();
    }
}
