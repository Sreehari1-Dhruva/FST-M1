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

public class Activity17 {
	public static void main(String[] args) {
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait ( driver,Duration.ofSeconds(10));
        
        //Open a new browser and open the url
        driver.get("https://training-support.net/webelements/selects");
        //Get the title of the page and print it to the console.
        System.out.println("Page title: " + driver.getTitle());
        
        WebElement select2= driver.findElement(By.xpath("//select[@multiple='']"));
        Select multiselect = new Select(select2) ;
        
//        On the Multi Select:
//        Select the "HTML" option using the visible text.
      multiselect.selectByVisibleText("HTML");   
      
//        	Select the 4th, 5th and 6th options using the index.
      for(int i=3; i<=5; i++) {
    	  multiselect.selectByIndex(i);
      };

//        	Select the "Node" option using the value
      multiselect.selectByValue("nodejs");

      
//        Deselect the 5th option using index.
      multiselect.deselectByIndex(5);
 
    System.out.println("Selected option are : ");
      List<WebElement> selectedOptions = multiselect.getAllSelectedOptions();
      for (WebElement selectedOption :  selectedOptions) {
    	  System.out.println(selectedOption.getText());
      }
//        	Close the browser.
        driver.quit();
    }
}
