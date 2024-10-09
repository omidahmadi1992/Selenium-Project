package handling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class WindowsHandlingInSelenium {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        //We click to open the next window (child window)
        WebElement openNewWindow = driver.findElement(By.id("newWindowBtn"));
        openNewWindow.click();
        //we are storing our window (the parent and any child after that) here
        Set<String> allWindows = driver.getWindowHandles();
        //iterator will allow us to iterate through windows/tabs that are open by Selenium
        Iterator<String> itr = allWindows.iterator();
        //The reason for below two lines of code is so that later when we call the
        //driver.switchTo().window(we can pass the window we want to switch to) here
        //We are storing the parent window in a String

        String parentWindow = itr.next();
        //We are storing the child window in a String
        String childWindow = itr.next();

        Thread.sleep(3000);

        driver.switchTo().window(childWindow);
        driver.manage().window().maximize();
        driver.findElement(By.id("email")).sendKeys("email@email.com");
        Thread.sleep(3000);

        driver.switchTo().window(parentWindow);
        driver.findElement(By.id("name")).sendKeys("text");

        System.out.println("This is Child: " + childWindow);
        System.out.println("This is Parent: " + parentWindow);

        Thread.sleep(6000);
        driver.quit();
    }
}

