package Activities;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity16 {
	public static void main(String[] args) {
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait ( driver,Duration.ofSeconds(10));
        
        //Open a new browser and open the url
        driver.get("https://training-support.net/webelements/selects");
        //Get the title of the page and print it to the console.
        System.out.println("Page title: " + driver.getTitle());
        
//        On the Single Select:
//        	Select the second option using the visible text.
      WebElement select1= driver.findElement(By.tagName("select"));
      Select menuOptions = new Select(select1) ;
      menuOptions.selectByVisibleText("Two");
      System.out.println("Selected option is : " +menuOptions.getFirstSelectedOption().getText());
        
//        	Select the third option using the index.
      menuOptions.selectByIndex(3);
      System.out.println("Selected option is : " +menuOptions.getFirstSelectedOption().getText());
      
//        	Select the fourth option using the value.
      menuOptions.selectByValue("four");
      System.out.println("Selected option is : " +menuOptions.getFirstSelectedOption().getText());
      
//        	Get all the options and print them to the console.
      	for(WebElement option : menuOptions.getOptions()) {
      		
      		 System.out.println(option.getText());
      	}
 
//        	Close the browser.
        driver.quit();
    }
}
