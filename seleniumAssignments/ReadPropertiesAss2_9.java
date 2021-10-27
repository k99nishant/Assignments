package seleniumAssignments;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class ReadPropertiesAss2_9 {
	WebDriver driver;
	String url = "http://www.google.com/";

	@Test
	public void f() {
		/*
		 * Write a code to read the properties from property file. Hint ; Create
		 * config.properties file in your project and mention all the properties
		 * regarding credentials, browser name, url etc.
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
		driver.close();
		driver.quit();
	}

}
