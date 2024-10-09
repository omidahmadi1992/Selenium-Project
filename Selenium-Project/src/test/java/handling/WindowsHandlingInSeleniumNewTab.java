package handling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class WindowsHandlingInSeleniumNewTab {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement openNewWindow = wait.until(ExpectedConditions.elementToBeClickable(By.id("newTabBtn")));
        openNewWindow.click();

        Set<String> allWindows = driver.getWindowHandles();
        Iterator<String> itr = allWindows.iterator();
        String parentWindow = itr.next();
        String childWindow = itr.next();

        driver.switchTo().window(childWindow);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("alertBox"))).click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        Thread.sleep(3000);
        driver.switchTo().window(parentWindow);
        WebElement text = driver.findElement(By.xpath("//h3[text()='Button2']"));
        System.out.println(text.getText());

        System.out.println("This is Parent: " + parentWindow);
        System.out.println("This is Child: " + childWindow);

        Thread.sleep(6000);
        driver.quit();
    }

}
