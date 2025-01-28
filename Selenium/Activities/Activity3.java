package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//Using Selenium:
//
//Open a new browser to https://training-support.net/webelements/login-form/
//Get the title of the page and print it to the console.
//Find the username field using xpath locator and enter "admin" into it.
//Find the password field using xpath locator and enter "password" into it.
//Find the "Log in" button using xpath locator and click it.
//Close the browser.

public class Activity3 {

	public static void main(String[] args) throws InterruptedException {
		// Create a new instance of the Firefox driver
		WebDriver driver = new FirefoxDriver();
		// Open the browser and webPage
		driver.get("https://training-support.net/webelements/login-form/");
		//Print the Page Title
		System.out.println("Page Title is: "+driver.getTitle());
		//Click on About us Button
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("password");
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		//Print the Page Title
		System.out.println("New Page Title is: "+driver.getTitle());
		//Close the Browser
		driver.quit();
	}

}