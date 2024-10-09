package dropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HandlingDropdownWithoutSelect {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://tek-retail-ui.azurewebsites.net/selenium/dropdown");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        By countrySelect = By.id("countrySelect");
        wait.until(ExpectedConditions.elementToBeClickable(countrySelect)).click();

        By countOptionsLocator = By.xpath("//select[@id='countrySelect']/option");
        List<WebElement> optionElements = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(countOptionsLocator));
        //Method to select by visible text.
        //selectByVisibleText(optionElements,"United States");
        // do the same thing and select by index.
//        selectByIndex(optionElements , 4);

        selectByValue(optionElements, "India");
        driver.quit();

    }

    public static void selectByValue(List<WebElement> optionElements, String value) {
        for(WebElement option: optionElements) {
            //Returning String value of given element attribute.
            String valueAttribute = option.getAttribute("value");
            if (valueAttribute.equalsIgnoreCase(value)) {
                option.click();
                break;
            }
        }
    }

    public static void selectByIndex(List<WebElement> optionElements, int index) {
        optionElements.get(index).click();
    }

    public static void selectByVisibleText(List<WebElement> optionElements ,String visibleText) {
        for (WebElement option : optionElements) {
            String text = option.getText();
            if (text.equalsIgnoreCase(visibleText)) {
                option.click();
                break;
            }
        }
    }
}
