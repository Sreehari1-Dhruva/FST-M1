package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestActivity7 {

	// Driver object
	WebDriver driver;

	// Setup function
	@BeforeClass(alwaysRun=true)
	public void setUp() {
		// Initialize driver
		driver = new FirefoxDriver();
		// open the page
		driver.get("https://training-support.net/webelements/login-form");
	}

	@DataProvider(name = "Credentials")
	public Object[][] creds() {
		return new Object[][] { { "admin", "wrongpassword" }, { "wrongadmin", "password" },
				{ "$_$", "DELETE TABLE USERS;" } };
	}

	@Test(priority = 1)
	public void TitleTest() {
		Assert.assertEquals(driver.getTitle(), "Selenium: Login Form");
	}

	@Test(priority = 2, dataProvider = "Credentials")
	public void invalidLoginTest(String username, String password) {

		// find web elements
		WebElement usernamefield = driver.findElement(By.id("username"));
		WebElement passwordfield = driver.findElement(By.id("password"));

		// clear the input fields
		usernamefield.clear();
		passwordfield.clear();

		// Enter credentials
		usernamefield.sendKeys(username);
		passwordfield.sendKeys(password);

		// click login
		driver.findElement(By.xpath("//button[text()='Submit']")).click();

		// Assertions
		String msg = driver.findElement(By.id("subheading")).getText();
		Assert.assertEquals(msg, "Invalid credentials");

	}

	// Teardown function
	@AfterClass(alwaysRun=true)
	public void tearDown() {
		// close the browser
		driver.quit();
	}

}
