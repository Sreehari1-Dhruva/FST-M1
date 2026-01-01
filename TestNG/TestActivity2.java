package activities;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestActivity2 {
	
	WebDriver driver;

	@BeforeClass
	public void setUp() {
		// Initializing driver object
		driver = new FirefoxDriver();
		// open the page
		driver.get("https://training-support.net/webelements/target-practice");	
	}
	
	@Test
	public void pageTitleTest() {
		// Get title of page and assertion
		System.out.println("title is: "+driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Selenium: Target Practice");
	}
	
	@Test
	public void buttonIncorrectTest() {
		// this test will be failed
		// get the black button
		WebElement black_button = driver.findElement(By.cssSelector("button.black"));
		Assert.assertTrue(black_button.isDisplayed());
		Assert.assertEquals(black_button.getText(), "black");
	}
	
	@Test(enabled=false)
	public void subHeadingSkippedTest() {
		// this test will be skipped
		String subheading = driver.findElement(By.className("sub")).getText();
		Assert.assertTrue(subheading.contains("heading"));
	}
	
	@Test
	public void skipTest() {
		// This test will be skipped and will be be shown as skipped
		throw new SkipException("skipping this test");
	}
	
	@AfterClass
	public void tearDown() {
		// closing the driver
		driver.close();
	}

}
