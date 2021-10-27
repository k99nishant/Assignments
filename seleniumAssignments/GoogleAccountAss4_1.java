package seleniumAssignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GoogleAccountAss4_1 {
	WebDriver driver;
	String url = "https://accounts.google.com/signup";

	@SuppressWarnings("deprecation")
	@Test
	public void f() {
		/*
		 * Create script to perform to create your google acount for the folllowing
		 * given website using getAttribute();
		 */
		driver.findElement(By.id("firstName")).sendKeys("Nishant");
		System.out.println("First Name : " + driver.findElement(By.id("firstName")).getAttribute("data-initial-value"));
		driver.findElement(By.id("lastName")).sendKeys("Gupta");
		System.out.println("Last Name : " + driver.findElement(By.id("lastName")).getAttribute("data-initial-value"));
		driver.findElement(By.id("username")).sendKeys("nishantjklol");
		System.out.println("Username : " + driver.findElement(By.id("username")).getAttribute("data-initial-value"));
		driver.findElement(By.xpath("//*[@id=\"passwd\"]/div[1]/div/div[1]/input")).sendKeys("pwwordpassjklol");
		System.out.println("Password : " + driver.findElement(By.xpath("//*[@id=\"passwd\"]/div[1]/div/div[1]/input"))
				.getAttribute("data-initial-value"));
		driver.findElement(By.xpath("//*[@id=\"confirm-passwd\"]/div[1]/div/div[1]/input")).sendKeys("pwwordpassjklol");
		driver.findElement(By.xpath("//*[@id=\"accountDetailsNext\"]/div/button")).click();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"yDmH0d\"]")));
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		driver.findElement(By.id("phoneNumberId")).sendKeys("7764099124");
		driver.findElement(By.xpath("//*[@id=\"view_container\"]/div/div/div[2]/div/div[2]/div/div[1]/div/div/button"))
				.click();

	}

	@SuppressWarnings("deprecation")
	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		driver.manage().window().maximize();
	}

	@AfterTest
	public void afterTest() {
		driver.close();
		driver.quit();
	}
}
