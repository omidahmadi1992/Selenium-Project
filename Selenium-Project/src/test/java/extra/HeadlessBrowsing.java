package extra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class HeadlessBrowsing {
    public static void main(String[] args) throws InterruptedException {
        //Headless Mode for browsers are when We don't see the Graphical
        //User interface of Browser and browser open in the background.
        //Selenium still can interact with headless browsers.
        ChromeOptions options = new ChromeOptions();
       // FirefoxOptions options1 = new FirefoxOptions();
       // EdgeOptions options2 = new EdgeOptions();
        options.addArguments("--headless");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://retail.tekschool-students.com");

        String title = driver.getTitle();
        Thread.sleep(2000);
        System.out.println(title);
        driver.quit();

    }

}
