package seleniumAssignments;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class VerifyPinCodeAss4_5 {
	WebDriver driver;
	String url = "https://chennaiiq.com/chennai/pincode_by_postal.asp";

	@Test
	public void f() {
		// Verify that the pin code of two different areas are unique / not same
		
		//Assert.assertEquals(driver.findElement(By.));
		List<WebElement> tb = driver.findElements(By.xpath("/html/body/table/tbody/tr[3]/td[2]/table[1]/tbody"));
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
	
	@DataProvider(name="dataForVerification")
	public Object[][] cities(){
		return new Object[][]{
			{"",""},
			{"",""}
		};

	}
	
	@DataProvider(name = "dataForDelete")
	public Object[] dataForDelete(){
		return new  Object[] {
				1,7
		};
	}
}
