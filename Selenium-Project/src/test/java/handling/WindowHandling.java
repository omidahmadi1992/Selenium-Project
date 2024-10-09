package handling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.*;


public class WindowHandling {
    // To handle a new tab with selenium,
    // Get the current window id before the new tab is open
    //
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
       try {
           driver.get("https://tek-retail-ui.azurewebsites.net/");
           driver.manage().window().maximize();
           driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
           driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
           WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

           String currentWindowId = driver.getWindowHandle();
           driver.findElement(By.linkText("Test Selenium")).click();
           Thread.sleep(2000);

           Set<String> allTabs = driver.getWindowHandles();
           for (String tab : allTabs){
               if(!tab.equals(currentWindowId)){
                   driver.switchTo().window(tab);
                   break;
               }
           }
           driver.findElement(By.linkText("Inputs")).click();
           driver.close();

           driver.switchTo().window(currentWindowId);
           Thread.sleep(2000);

           driver.findElement(By.linkText("Sign in")).click();
           driver.quit();
       }catch (Exception e){
           e.printStackTrace();
       }finally {
           driver.quit();
       }
    }
}
