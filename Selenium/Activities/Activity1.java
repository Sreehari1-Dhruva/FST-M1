package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//Using Selenium:
//Open the training support site. (https://training-support.net)
//Print the title of the page
//Click the about us button
//Print the title of the new page

public class Activity1 {

	public static void main(String[] args) throws InterruptedException {
		// Create a new instance of the Firefox driver
		WebDriver driver = new FirefoxDriver();
		// Open the browser and webPage
		driver.get("https://training-support.net");
		//Print the Page Title
		System.out.println("Page Title is: "+driver.getTitle());
		//Click on About us Button
		driver.findElement(By.linkText("About Us")).click();
		//Print the Page Title
		System.out.println("New Page Title is: "+driver.getTitle());
		//Close the Browser
		driver.quit();
	}

}
