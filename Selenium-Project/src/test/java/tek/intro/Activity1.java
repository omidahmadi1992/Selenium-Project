package tek.intro;

import org.openqa.selenium.chrome.ChromeDriver;

public class Activity1 {
    public static void main(String[] args) {

        ChromeDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https:/facebook.com");
        chromeDriver.manage().window().maximize();
        String title = chromeDriver.getTitle();
        System.out.println(title);

        chromeDriver.quit();


    }
}
