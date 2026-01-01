package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestActivity5 {
	
	WebDriver driver;
	
	@BeforeClass(alwaysRun=true)
	public void setUp() {
		driver = new FirefoxDriver();
		// open the page
		driver.get("https://training-support.net/webelements/target-practice");	
	}
	
	@Test(groups= {"HeaderTests", "ButtonTests"})
	public void pageTitleTest() {
		String titlemsg = driver.getTitle();
		System.out.println(titlemsg);
		Assert.assertEquals(titlemsg, "Selenium: Target Practice");
	}
	
	@Test(dependsOnMethods= {"pageTitleTest"}, groups= {"HeaderTests"})
	public void headerTest1() {
		WebElement headerthreetext = driver.findElement(By.xpath("//h3[text()='Heading #3']"));
		System.out.println(headerthreetext);
		Assert.assertEquals(headerthreetext.getText(), "Heading #3");
	}
	
	@Test(dependsOnMethods= {"pageTitleTest"}, groups= {"HeaderTests"})
	public void headerTest2() {
		Color headerfivecolor = Color.fromString(driver.findElement(By.xpath("//h5[contains(@class,'purple')]")).getCssValue("color"));
		System.out.println("color of header5 is: " + headerfivecolor);
		Assert.assertEquals(headerfivecolor.asHex(), "#9333ea");
	}
	
	@Test(dependsOnMethods= {"pageTitleTest"}, groups= {"ButtonTests"})
	public void buttonTest1 () {
		WebElement buttontext = driver.findElement(By.cssSelector("emerald-200"));
		System.out.println(buttontext);
		Assert.assertEquals(buttontext, "Emerald");	
	}
	
	@Test(dependsOnMethods= {"pageTitleTest"}, groups= {"ButtonTests"})
	public void ButtonTest2() {
		Color button2Color = Color.fromString(driver.findElement(By.xpath("//button[contains(@class, 'purple')]")).getCssValue("color"));
		System.out.println("color of button2 is: " + button2Color);
        Assert.assertEquals(button2Color.asHex(), "#581c87");
	}
	
	@AfterClass(alwaysRun=true)
	public void tearDown() {
		// close the driver
		driver.quit();
	}

}
