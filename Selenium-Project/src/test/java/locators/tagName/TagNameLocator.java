package locators.tagName;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class TagNameLocator {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.bbc.com/");

        By anchorsTagLocator = By.tagName("a");
        //method findElements return List<WebElement> contains all the elements find with By strategy
        List<WebElement> anchorElements = driver.findElements(anchorsTagLocator);
        System.out.println(anchorElements.size());

        for(WebElement element : anchorElements) {
            System.out.println(element.getText());
        }

        driver.quit();
    }
}
