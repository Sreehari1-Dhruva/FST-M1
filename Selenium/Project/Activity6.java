package seleniumproject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity6 {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	public void setUp() {
	    driver = new FirefoxDriver();
		driver.get("https://alchemy.hguy.co/crm/");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.urlContains("alchemy.hguy.co/crm"));
	}
	
	@Test(alwaysRun=true)
	public void loginTest() {
		
		// finding user name and password fields
		WebElement username=driver.findElement(By.id("user_name"));
		WebElement password=driver.findElement(By.xpath("//div/input[@placeholder='Password']"));
		
		// passing user name and password values
		username.sendKeys("admin");
		password.sendKeys("pa$$w0rd");
		
		// clicking login button
		driver.findElement(By.id("bigbutton")).click();
		
		// Assertions
		String text = driver.findElement(By.id("tab0")).getText();
		System.out.println(text);
		Assert.assertEquals("SUITECRM DASHBOARD",text);
	}
	
	@Test(dependsOnMethods = "loginTest")
	public void activityMenuTest() {
		WebElement activitiesIcon = driver.findElement(By.id("grouptab_3"));
		try {
			WebElement aIcon = wait.until(ExpectedConditions.elementToBeClickable(activitiesIcon));
			aIcon.click();
			System.out.println("Activities icon is clicked");
		}
		catch(TimeoutException e) {
			System.out.println("Activities icon is not clickable");
		}
	}
	
	@AfterClass(alwaysRun=true)
	public void tearDown() {
		driver.close();
	}

}
