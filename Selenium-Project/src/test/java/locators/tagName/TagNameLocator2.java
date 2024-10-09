package locators.tagName;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class TagNameLocator2 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.bbc.com/");

        //find how many images are in BBC Home page.
        By imageTag  = By.tagName("img");
        List<WebElement> imagesElements = driver.findElements(imageTag);
        System.out.println(imagesElements.size());

        driver.quit();
    }
}
