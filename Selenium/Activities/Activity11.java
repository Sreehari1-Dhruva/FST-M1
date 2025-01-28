package Activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//Open a new browser to https://training-support.net/webelements/dynamic-controls
//Get the title of the page and print it to the console.
//On the page, perform:
//Find the checkbox on the page.
//Click the "Toggle Checkbox" button to remove the checkbox.
//Wait for the checkbox to disappear.
//Toggle the checkbox again.
//Wait for it appear and then select it.
//Close the browser.

public class Activity11 {
	public static void main(String[] args) {
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait ( driver,Duration.ofSeconds(10));
       
        driver.get("https://training-support.net/webelements/dynamic-controls");
        // Print the title of the page
        System.out.println("Page title: " + driver.getTitle());

        // Find the checkbox element
        WebElement checkbox = driver.findElement(By.id("checkbox"));
        
      //Click the "Toggle Checkbox" button to remove the checkbox.
         driver.findElement(By.xpath("//button[text()='Toggle Checkbox']")).click();

      //Wait for the checkbox to disappear.
        wait.until(ExpectedConditions.invisibilityOf(checkbox));
        
      //Toggle the checkbox again.
        driver.findElement(By.xpath("//button[text()='Toggle Checkbox']")).click();

        
      //Wait for it appear and then select it.
        wait.until(ExpectedConditions.visibilityOf(checkbox)).click();
      
      
        driver.quit();
    }

}
