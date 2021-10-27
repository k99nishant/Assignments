package seleniumAssignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderAss3_2 {

	WebDriver driver;
	String url = "http://www.google.com/";

	@Test(dataProvider = "SearchTerms")
	public void f(String terms) {
		// write an automation script by passing paramenters using @DataProviders annotation
		
			driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")).sendKeys(terms);
			driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[2]/div[2]/div[5]/center/input[1]")).click();
			driver.navigate().back();
		
	}
	
	@SuppressWarnings("deprecation")
	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(5000l, TimeUnit.MILLISECONDS);
	}

	@AfterTest()
	public void afterTest() {
		driver.close();
		driver.quit();
	}
	
	@DataProvider(name="SearchTerms")
	public Object[] getdData() {
		
		String st[] = {"Car", "Phone", "Laptop", "HeadPhones", "Shoes"};
		
		return st;
		
	}

}
