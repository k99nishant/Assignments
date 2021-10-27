package seleniumAssignments;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class GoogleSearchAss2_4 {

	WebDriver driver;
	String url = "https://www.google.com/";

	@Test
	public void f() {
		/*
		 * Write automation script for google search web page create the customized
		 * Xpath and then get the list of size, iterate the list then the moment you
		 * find the suggestion perform click();
		 */
		
		
		
		
	}

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
	}

	@AfterTest
	public void afterTest() {
		//driver.close();
	}

}
