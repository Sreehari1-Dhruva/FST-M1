package activities;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class TestActivity1 {
	
	// Driver object
	WebDriver driver;
	// Declaring the wait object
	WebDriverWait wait;
		
  @Test(priority=1)
  public void pageTitleTest() {
	// Get page title and Assertion
	Assert.assertEquals(driver.getTitle(), "Training Support");
  }
  
  @Test(priority=2)
  public void aboutLinkTest() {
	// find and click the about us link
	driver.findElement(By.linkText("About Us")).click();
	  
	// Assertions
	wait.until(ExpectedConditions.titleContains("About"));
	Assert.assertEquals(driver.getTitle(), "About Training Support");
  }
  
  @BeforeClass
  public void setUp() {
	// Initialize driver
	driver = new FirefoxDriver();
	// Initialize the wait object
	wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	// open the page
	driver.get("https://training-support.net");
  }

  @AfterClass
  public void tearDown() {
	// close the browser
	driver.quit();
  }

}
