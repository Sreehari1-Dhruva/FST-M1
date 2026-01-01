package seleniumproject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity1 {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeClass(alwaysRun=true)
	public void setUp() {	
		driver=new FirefoxDriver();
		driver.get("https://alchemy.hguy.co/crm/");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.urlContains("alchemy.hguy.co/crm"));
	}
	
	@Test
	public void pageTitleTest() {
		String title = driver.getTitle();
		System.out.println("Title of the CRM page is: "+title);
		Assert.assertEquals("SuiteCRM", title);	
	}
	
	@AfterClass(alwaysRun=true)
	public void tearDown() {
		driver.close();
	}

}
