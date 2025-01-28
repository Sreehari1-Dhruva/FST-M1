package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity9 {
    public static void main(String[] args) {
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        Actions builder = new Actions(driver);
        
//        Actions builder = new Actions(driver);
//        Open a new browser to https://training-support.net/webelements/keyboard-events
       driver.get("https://training-support.net/webelements/keyboard-events");
        // Print the title of the page
        System.out.println("Page title: " + driver.getTitle());

//    	On the page, type out a string from the Selenium script to show on the page
        builder.sendKeys("Preeti").sendKeys(Keys.RETURN).build().perform();
        
//    	Print the message to the console.
        String message =driver.findElement(By.cssSelector("h1.mt-3")).getText();
        System.out.println(message);
        
        driver.quit();
    }
}
