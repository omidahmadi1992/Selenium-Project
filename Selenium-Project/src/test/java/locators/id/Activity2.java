package locators.id;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Activity2 {
    public static void main(String[] args) {

        String browserTye = "firefox";
        WebDriver driver;

        if(browserTye.equals("chrome")){
            driver = new ChromeDriver();
        } else if (browserTye.equals("edge")) {
            driver = new EdgeDriver();
        } else if (browserTye.equals("firefox")) {
            driver = new FirefoxDriver();
        } else if (browserTye.equals("safari")) {
            driver = new SafariDriver();
        }else {
            throw new RuntimeException("Wrong browser type");
        }
        driver.get("https://tek-retail-ui.azurewebsites.net/");
        driver.manage().window().maximize();
        String title = driver.getTitle();
        System.out.println(title);
        String url = driver.getCurrentUrl();
        System.out.println(url);
        driver.quit();
    }
}
