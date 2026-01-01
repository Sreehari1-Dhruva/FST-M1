package activities;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestActivity3 {
	
	// declare driver 
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	public void setUp() {
		// Initializing driver object
		driver=new FirefoxDriver();
		// open the page
		driver.get("https://training-support.net/webelements/login-form");
	}
	
	@Test
	public void validLoginTest() {
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("password");
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.titleContains("Selenium: Login Success!"));
		String successmsg=driver.findElement(By.cssSelector("h2.text-center")).getText();
		Assert.assertEquals(successmsg, "Welcome Back, Admin!");		
	}
	
	@AfterClass
	public void tearDown() {
		// close the browser
		driver.quit();
	}
	
}
