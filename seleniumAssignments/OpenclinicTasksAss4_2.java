package seleniumAssignments;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OpenclinicTasksAss4_2 {
	WebDriver driver;
	String url = "http://openclinic.sourceforge.net/openclinic/home/index.php";

	@SuppressWarnings("deprecation")
	@Test
	public void f() {
		/*
		 * Write automation script to switch on new tab by clicking on "medical records"
		 * -> after switching on new tab click on "search patient" and select dropdown
		 * as "frst name" ansd click on search button
		 */
		String openLinkInNewTab = Keys.chord(Keys.CONTROL, Keys.RETURN);
		driver.findElement(By.linkText("Medical Records")).sendKeys(openLinkInNewTab);
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

		String mainWindowHandle = driver.getWindowHandle();

		Set<String> allWindowHandles = driver.getWindowHandles();
		Iterator<String> iterator = allWindowHandles.iterator();
		while (iterator.hasNext()) {
			String ChildWindow = iterator.next();
			if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
				driver.switchTo().window(ChildWindow);
//				WebElement text = driver.findElement(By.id("sampleHeading"));
//				System.out.println("Heading of child window is " + text.getText());
			}
		}
		driver.findElement(By.linkText("Search Patient")).click();
		Select selectFrom = new Select(driver.findElement(By.id("search_type")));
		selectFrom.selectByVisibleText("First Name");
		driver.findElement(By.id("search_patient")).click();
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
