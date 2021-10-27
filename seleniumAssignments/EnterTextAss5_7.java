package seleniumAssignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EnterTextAss5_7 {

	WebDriver driver;
	String url = "https://duckduckgo.com/";

	@Test
	public void f() {
		// enter a text without using send keys for any web site i,e in google search
		// box
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("document.getElementById('search_form_input_homepage').value='memes'");
	
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
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
