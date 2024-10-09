package extra;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class RadioButtonHandling {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath("//a[text()='Create new account']")).click();
		WebElement radioButton = driver.findElement(By.xpath("//span[@data-type='radio']//input[@value='1']"));
		boolean isDisplayed = radioButton.isDisplayed();
		System.out.println("isDisplayed");
		radioButton.isEnabled();
		radioButton.isSelected();

	}

}
