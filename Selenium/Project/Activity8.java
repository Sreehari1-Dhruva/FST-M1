package seleniumproject;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

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

public class Activity8 {
	
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
	
	// Open the accounts page and print the contents of the table
	@Test(dependsOnMethods = "loginTest")
	public void traverseTableTest() {
		// Navigate to Sales -> Accounts
		driver.findElement(By.id("grouptab_0")).click();
		driver.findElement(By.xpath("//a[@id='grouptab_0']/following::a[contains(text(), 'Accounts')][1]")).click();
		String title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2.module-title-text")))
				.getText();
		Assert.assertEquals(title, " ACCOUNTS");
		
		// Print the names of the first 5 odd-numbered rows of the table
		List<WebElement> names = driver.findElements(By.xpath("//td[@field='name']//b//a"));
		List<String> fiveNames = new ArrayList<>();
		for(int i=0; i<names.size(); i++) {
			if(i%2 == 0) {
				fiveNames.add(names.get(i).getText());
			}
			if(fiveNames.size()==5) {
				break;
			}
		}		
		System.out.println(fiveNames);
	}

	// Teardown function
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		// Close the browser
		driver.quit();
	}

}
