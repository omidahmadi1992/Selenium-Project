package crossBrowsing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Scanner;

public class CrossBrowsingHandlingUsingScanner2 {
    public static void main(String[] args) {

        // Creating a scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Prompting the user to enter their preferred browser type
        System.out.println("Enter your browser please!.");
        String browserType = scanner.next(); // Reading user input

        WebDriver driver; // Declaring a variable to hold the WebDriver instance

        // Checking the user input to determine which browser driver to instantiate
        if (browserType.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver(); // Creating a ChromeDriver instance
        } else if (browserType.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver(); // Creating a FirefoxDriver instance
        } else if (browserType.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver(); // Creating an EdgeDriver instance
        } else {
            // Throwing a RuntimeException if an unsupported browser type is entered
            throw new RuntimeException("Wrong driver");
        }

        // Using the WebDriver instance to navigate to a specific URL
        driver.get("https://google.com");

        // Maximizing the browser window
        driver.manage().window().maximize();

        // Getting the title of the current web page
        String title = driver.getTitle();
        System.out.println(title); // Printing the title to the console

        // Quitting the WebDriver instance, closing all associated windows and ending the session
        driver.quit();
    }
}
