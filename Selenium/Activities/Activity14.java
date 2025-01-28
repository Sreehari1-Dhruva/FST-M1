package Activities;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity14 {
	public static void main(String[] args) {
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
 //       WebDriverWait wait = new WebDriverWait ( driver,Duration.ofSeconds(10));
        
        //Open a new browser to https://training-support.net/webelements/dynamic-content
        driver.get("https://training-support.net/webelements/tables");
        //Get the title of the page and print it to the console.
        System.out.println("Page title: " + driver.getTitle());
        
        List<WebElement> columns = driver.findElements(By.xpath("//table[contains(@class,'table-auto')]/thead/tr/th"));
        List<WebElement> rows = driver.findElements(By.xpath("//table[contains(@class,'table-auto')]/tbody/tr"));
        //        Using xpaths on the table:
//        	Find the number of rows and columns in the table and print them.
        
        System.out.println("the no. rows in the table is :" + rows.size());
        System.out.println("the no. columns in the table is :" + columns.size());
        
//        	Find and print the Book Name in the 5th row
        WebElement bookNameInFifthRow = driver.findElement(By.xpath("//table[contains(@class,'table-auto')]/tbody/tr[5]/td[2]"));
        System.out.println("values in the third row in the table are :" + bookNameInFifthRow.getText());
        
//        	Click the header of the Price column to sort it in ascending order
        driver.findElement(By.xpath("//table[contains(@class,'table-auto')]/thead/tr/th[5]")).click();
        
//        Find and print the Book Name in the 5th row again.
        WebElement bookNameInFifthRowAfterSorting = driver.findElement(By.xpath("//table[contains(@class,'table-auto')]/tbody/tr[5]/td[2]"));
        System.out.println("values in the second row second column in the table are :" +bookNameInFifthRowAfterSorting.getText());
        
        
//        	Close the browser.
        driver.quit();
    }
}
