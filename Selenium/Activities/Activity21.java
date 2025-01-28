package Activities;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity21 {
	public static void main(String[] args) {
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait ( driver,Duration.ofSeconds(10));
        //Open a new browser and open the url
        driver.get("https://training-support.net/webelements/tabs");
        //Get the title of the page and print it to the console.
        System.out.println("Page title: " + driver.getTitle());
        System.out.println("Current tab: " + driver.getWindowHandle());
        
//   Find the button to open a new tab and click it.
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Open A New Tab']"))).click();
        
//   Wait for the new tab to open. Once it opens, print all the handles
        System.out.println("Currently open windows: " + driver.getWindowHandles());
        
//  Switch to the newly opened tab, print the new tab's title and message
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
        
        // Wait for the new page to load
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Another One')]")));
        // Print the handle of the current tab
        System.out.println("Current tab: " + driver.getWindowHandle());
        // Print the title and heading of the new page
        System.out.println("New Page title: " + driver.getTitle());
        System.out.println("New Page message: " + driver.findElement(By.cssSelector("h2.mt-5")).getText());
        // Find and click the button on page to open another tab
        driver.findElement(By.xpath("//button[contains(text(), 'Another One')]")).click();

        // Wait for new tab to open until release message is displayed
//        wait.until(ExpectedConditions.numberOfWindowsToBe(3));
      wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("h2.mt-5"),"release"));
        // Switch focus
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }

        
//  Close the browser.
        driver.quit();
    }
}
