package seleniumAssignments;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class DropDownImpWaitAss2_1 {

	static WebDriver driver;
	String url = "https://www.jquery-az.com/boots/demo.php?ex=63.0_2";

	@SuppressWarnings("deprecation")
	@Test
	public void f() {
		driver.get(url);
		driver.findElement(By.xpath("/html/body/div[3]/table/tbody/tr[2]/td[3]/div/span/div/button")).click();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
	}

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();

	}

	@AfterTest
	public void afterTest() {
		driver.quit();
		driver.quit();
	}

}
