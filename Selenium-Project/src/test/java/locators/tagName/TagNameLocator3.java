package locators.tagName;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class TagNameLocator3 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.bbc.com/");
        //Activity Find how many buttons are in the bbc home pages.
        //And print the text of each button.

        List<WebElement> buttonElements = driver.findElements(By.tagName("button"));
        System.out.println(buttonElements.size());

        for(WebElement element : buttonElements){
            String text = element.getText();
            if (!text.isEmpty())
                System.out.println(text);
        }

        driver.quit();
    }
}
