package seleniumAssignments;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class PopUpWindowHandleAss2_3 {

	WebDriver driver;
	String url = "http://demo.guru99.com/popup.php";

	@Test
	public void f() {
		/*
		 * Write automation script to handle the window popup for following website.
		 * Also write script to switch on Parent as well as on Child popup window along
		 * with Title of the popup window.
		 */

		driver.findElement(By.linkText("Click Here")).click();
		String MainWindow = driver.getWindowHandle();
		System.out.println("Parent Window : " + driver.getTitle() + " : " + driver.getCurrentUrl());
		// To handle all new opened window.
		Set<String> s1 = driver.getWindowHandles();
		Iterator<String> i1 = s1.iterator();

		while (i1.hasNext()) {
			String ChildWindow = i1.next();

			if (!MainWindow.equalsIgnoreCase(ChildWindow)) {

				// Switching to Child window
				driver.switchTo().window(ChildWindow);
				System.out.println("Child Window : " + driver.getTitle() + " : " + driver.getCurrentUrl());
				driver.findElement(By.name("emailid")).sendKeys("steverogers@infosys.com");

				driver.findElement(By.name("btnLogin")).click();
			}
		}
		driver.switchTo().window(MainWindow);

	}

	@SuppressWarnings("deprecation")
	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
	}

	@AfterTest
	public void afterTest() {
		driver.close();
		driver.close();
	}

}
