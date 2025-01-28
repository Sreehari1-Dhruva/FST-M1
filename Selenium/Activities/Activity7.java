package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity7 {
    public static void main(String[] args) {
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        
        // Open the page
        driver.get("https://training-support.net/webelements/dynamic-controls");
        // Print the title of the page
        System.out.println("Page title: " + driver.getTitle());

        WebElement textbox = driver.findElement(By.id("textInput"));
        System.out.println("Is the textbox enabled ?" +textbox.isEnabled() );
        driver.findElement(By.id("textInputButton")).click();
        
        System.out.println("Is the textbox enabled ?" +textbox.isEnabled());
        
        driver.quit();
    }
}
