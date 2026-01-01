package seleniumproject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity7 {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeClass(alwaysRun = true)
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
	
	@Test
	public void readInfoSales() {
		//  Navigate to Sales -> Leads 
		driver.findElement(By.id("grouptab_0")).click();
		driver.findElement(By.xpath("//a[@id='grouptab_0']/following::a[contains(text(), 'Leads')][1]")).click();
		String title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2.module-title-text"))).getText();
		Assert.assertEquals(title, " LEADS");
			
		// Find and click the Additional information icon at the end of the row
		WebElement addtlInfo = driver.findElement(By.xpath("(//span[@title='Additional Details'])[1]"));
		addtlInfo.click();
			
		// Print the phone number
		WebElement phone = driver.findElement(By.xpath("//span[@class='phone']"));
		String phoneNumber = wait.until(ExpectedConditions.visibilityOf(phone)).getText();
		System.out.println("Phone number: " + phoneNumber);	
	}
	
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		driver.close();
	}

}
