package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity8 {
    public static void main(String[] args) {
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        
        Actions builder = new Actions(driver);
        // Open the page
        driver.get("https://training-support.net/webelements/mouse-events");
        // Print the title of the page
        System.out.println("Page title: " + driver.getTitle());

        WebElement cargoLock = driver.findElement(By.xpath("//h1[text()='Cargo.lock']"));
        WebElement cargoToml = driver.findElement(By.xpath("//h1[text()='Cargo.toml']"));
        WebElement srcButton = driver.findElement(By.xpath("//h1[text()='src']"));
        WebElement targetButton = driver.findElement(By.xpath("//h1[text()='target']"));
       
        
        // Left click . lock button, then click .toml button
        builder.click(cargoLock).pause(5000L).moveToElement(cargoToml).pause(5000L).click().build().perform();
        //Print the message at the end of the sequence
        System.out.println(driver.findElement(By.id("result")).getText());
        
        // double click src button, then right click target button 
        builder.doubleClick(srcButton).pause(5000L).contextClick(targetButton).pause(5000L).click().build().perform();
        //Then click the Open Option
        driver.findElement(By.xpath("//div[@id='menu']/div/ul/li[1]")).click();
        //Print the message at the end of the sequence
        System.out.println(driver.findElement(By.id("result")).getText());
        
        
        driver.quit();
    }
}
