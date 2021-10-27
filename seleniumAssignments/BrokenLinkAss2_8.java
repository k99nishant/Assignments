package seleniumAssignments;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BrokenLinkAss2_8 {

	WebDriver driver;
	String homePage = "http://www.zlti.com/";
	String url = "";
	HttpURLConnection huc = null;
	int broken = 0;
	int valid = 0;

	@Test
	public void f() {
		// find broken link on the given webpage
		List<WebElement> allUrls = driver.findElements(By.tagName("a"));
		System.out.println("Total number of links : " + allUrls.size());

		Iterator<WebElement> iterator = allUrls.iterator();
		while (iterator.hasNext()) {
			url = iterator.next().getAttribute("href");
			// System.out.println(url);

			try {
				huc = (HttpURLConnection) (new URL(url).openConnection());

				// huc.setRequestMethod("HEAD");
				huc.setConnectTimeout(5000);

				huc.connect();

				if (huc.getResponseCode() >= 400) {
					System.out.println(url + huc.getResponseCode() + " is a broken link");
					broken++;
				} else {
					System.out.println(url + huc.getResponseCode() + " is a valid link");
					valid++;
				}

			} catch (Exception e) {

			}

		}
		System.out.println("Total number of links : " + allUrls.size() + "\nBroken Links  : " + broken
				+ "\nValid Links : " + valid);
	}

	@SuppressWarnings("deprecation")
	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(homePage);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
	}

	@AfterTest
	public void afterTest() {
		driver.close();
		driver.quit();
	}
}
