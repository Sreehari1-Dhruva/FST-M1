package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//Using Selenium:
//
//Open a new browser to https://training-support.net/webelements/login-form/
//Get the title of the page and print it to the console.
//Find the username field using any locator and enter "admin" into it.
//Find the password field using any locator and enter "password" into it.
//Find the "Log in" button using any locator and click it.
//Close the browser.

public class Activity2 {

	public static void main(String[] args) throws InterruptedException {
		// Create a new instance of the Firefox driver
		WebDriver driver = new FirefoxDriver();
		// Open the browser and webPage
		driver.get("https://training-support.net/webelements/login-form/");
		//Print the Page Title
		System.out.println("Page Title is: "+driver.getTitle());
		//Click on About us Button
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("password");
		driver.findElement(By.xpath("//div/main/div/div/div/div/div[2]/form/button")).click();
		//Print the Page Title
		System.out.println("New Page Title is: "+driver.getTitle());
		//Close the Browser
		driver.quit();
	}

}