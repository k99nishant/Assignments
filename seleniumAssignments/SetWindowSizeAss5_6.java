package seleniumAssignments;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class SetWindowSizeAss5_6 {

	WebDriver driver;
	String url = "http://reddit.com";

	@Test
	public void f() {
		// set the size of browser window of any web page
		Dimension d = new Dimension(400, 500);
		driver.manage().window().setSize(d);
	}

	@SuppressWarnings("deprecation")
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
