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

public class Activity18 {
	public static void main(String[] args) {
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        
        //Open a new browser and open the url
        driver.get("https://training-support.net/webelements/alerts");
        //Get the title of the page and print it to the console.
        System.out.println("Page title: " + driver.getTitle());
        

        
//        Find the button to open a SIMPLE alert and click it
        driver.findElement(By.id("simple")).click();
        Alert simplAlert = driver.switchTo().alert();
//    Switch the focus from the main window to the Alert box and get the text in it and print it.
        System.out.println(simplAlert.getText());
//   Close the alert once with OK.
        simplAlert.accept();
        
//Print the results
        System.out.println("Action performed was :" +driver.findElement(By.id("result")).getText() );

//        	Close the browser.
        driver.quit();
    }
}
