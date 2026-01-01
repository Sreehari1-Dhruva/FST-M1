package seleniumproject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.support.Color;

public class Activity5 {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	public void setUp() {
	    driver = new FirefoxDriver();
		driver.get("https://alchemy.hguy.co/crm/");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.urlContains("alchemy.hguy.co/crm"));
	}
	
	@Test(priority=1)
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
	
	@Test(priority=2)
	public void colorOfMenuTest() {
		
		Color colormenu = Color.fromString(driver.findElement(By.id("toolbar")).getCssValue("color"));
		System.out.println(colormenu.getColor());
		System.out.println(colormenu.asHex());
		// Assertion
		Assert.assertEquals("#534d64", colormenu.asHex());
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}

}
