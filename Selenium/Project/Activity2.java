package seleniumproject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity2 {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	public void setUp() {
	    driver = new FirefoxDriver();
		driver.get("https://alchemy.hguy.co/crm/");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.urlContains("alchemy.hguy.co/crm"));
	}
	
	@Test
	public void headerImageUrlTest() {
		String imageUrl = driver.findElement(By.xpath("//form/div/img")).getAttribute("src");
		System.out.println("URL of header image is: "+imageUrl);
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}

}
