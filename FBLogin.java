package abcpack;

import static org.junit.Assert.*;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FBLogin {
	WebDriver d;
	@Before
	public void setUp()
	{
		// Launch browser
		System.setProperty("webdriver.gecko.driver","G:\\selenium lib\\geckodriver.exe");
		d=new FirefoxDriver();
		//Maximize
		d.manage().window().maximize();
	}
	@Test
	public void testFBLogin() throws Exception
	{
		//Load web page
		d.get("https://www.facebook.com/");
		//System.out.println(d.getTitle());
		//Verify page title
		assertEquals("Facebook – log in or sign up",d.getTitle());
		//Enter user name
		assertTrue(d.findElement(By.id("email")).isDisplayed());
		d.findElement(By.id("email")).sendKeys("saikiran");
		//Enter password
		d.findElement(By.id("pass")).sendKeys("sai@kiran");
		//Click on Login
		d.findElement(By.id("loginbutton")).click();
		
		d.findElement(By.id("not_me_link")).click();
		//Pause 4sec
		Thread.sleep(4000);
	}
	@After
	public void tearDown()
	{
		//Close browser
		d.quit();
	}

}
