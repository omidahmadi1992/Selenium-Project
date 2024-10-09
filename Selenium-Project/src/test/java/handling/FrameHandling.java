package handling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FrameHandling {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://tek-retail-ui.azurewebsites.net/selenium/iframe");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.switchTo().frame(0);

        String insideFrame = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='This page is inside an iframe']"))).getText();
        System.out.println(insideFrame);

        driver.switchTo().defaultContent();

        String outSideFrame = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("title"))).getText();
        System.out.println(outSideFrame);

        driver.quit();
    }
}