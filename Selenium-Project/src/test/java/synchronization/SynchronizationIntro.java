package synchronization;


import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SynchronizationIntro {

    /*
    What is synchronization in software testing?
    What is Synchronization in a Selenium Web driver?
    If an action is to take place, we always expect the components to work together at the same pace.
    This coordination process between the components is termed Synchronization.
    Synchronization in Selenium executes the code and applications, which must be in Synchronization to perform the
    operation.
   */

    public static void main(String[] args) {

        /*
        What is the benefit of using timeouts in selenium
        Certainly? In Selenium WebDriver, timeouts are used to manage how long the driver should wait when performing
        certain actions before throwing an exception
         */

        /*
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));20
        */

        /*
        Implicit Wait vs Page Load Timeout: Both are global timeouts set using driver.manage().timeouts().
        Implicit wait applies to finding elements, while page load timeout specifically waits for full page loading.
        WebDriverWait: Offers more granular control with explicit waits based on specific conditions,
        making it versatile for waiting on dynamic elements or complex scenarios.
         */
    }
}
