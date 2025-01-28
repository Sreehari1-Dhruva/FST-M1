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

public class Activity22 {
	public static void main(String[] args) {
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait ( driver,Duration.ofSeconds(10));
        //Open a new browser and open the url
        driver.get("https://training-support.net/webelements/popups");
        //Get the title of the page and print it to the console.
        System.out.println("Page title: " + driver.getTitle());
        
//   Find the button on the page and click it to launch the popup.
        wait.until(ExpectedConditions.elementToBeClickable(By.id("launcher"))).click();
        
//        Wait for the popup to appear and then enter the credentials:
//        	username: admin
//        	password: password
        
        wait.until(ExpectedConditions.elementToBeClickable(By.id("popup")));
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("password");
        
//        Click submit and print the message on the page after logging in.
        driver.findElement(By.xpath("//button[@class='svelte-1pdjkmx']")).click();
        String message = driver.findElement(By.tagName("h2")).getText();
        System.out.println(message);
//  Close the browser.
        driver.quit();
    }
}
