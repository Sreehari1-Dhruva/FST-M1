package Activities;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity15 {
	public static void main(String[] args) {
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait ( driver,Duration.ofSeconds(10));
        
        //Open a new browser to https://training-support.net/webelements/dynamic-attributes
        driver.get("https://training-support.net/webelements/dynamic-attributes");
        //Get the title of the page and print it to the console.
        System.out.println("Page title: " + driver.getTitle());

//        	Find the input fields and type in the required data in the fields.
        driver.findElement(By.xpath("//input[starts-with(@id, 'full-name')]")).sendKeys("Preeti");  
        driver.findElement(By.xpath("//input[contains(@id ,'-email')]")).sendKeys("preeti.mishra@ibm.com");
        driver.findElement(By.xpath("//input[@type='date']")).sendKeys("2025-01-11");
        driver.findElement(By.xpath("//textarea[contains(@id ,'additional-details')]")).sendKeys("Party");
        
        // Click the submit button
        driver.findElement(By.xpath("//button[contains(text() ,'Submit')]")).click();
        
//        	Wait for success message to appear and print it to the console.
        String message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/h3[contains(text() ,'scheduled')]"))).getText();
        System.out.println(message);
        
//        	Close the browser.
        driver.quit();
    }
}
