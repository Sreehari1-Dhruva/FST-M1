package Activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

//Open a new browser to https://training-support.net/webelements/dynamic-content
//Get the title of the page and print it to the console.
//On the page, perform:
//Find and click the "Click me!" button.
//Wait till the word "release" appears.
//Get the text and print it to console.
//Close the browser.
public class Activity12 {

	public static void main(String[] args) {
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait ( driver,Duration.ofSeconds(10));
        
        //Open a new browser to https://training-support.net/webelements/dynamic-content
        driver.get("https://training-support.net/webelements/dynamic-content");
        //Get the title of the page and print it to the console.
        System.out.println("Page title: " + driver.getTitle());

      //On the page, perform:
      //Find and click the "Click me!" button.      
        driver.findElement(By.id("genButton")).click();
        
      //Wait till the word "release" appears.
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("word"), "release"));
        
      //Get the text and print it to console.
        System.out.println(driver.findElement( By.id("word")).getText());
       
      //Close the browser.
        driver.quit();
    }
	
}
