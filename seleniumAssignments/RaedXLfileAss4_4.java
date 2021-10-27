package seleniumAssignments;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RaedXLfileAss4_4 {
	WebDriver driver;
	String url = "http://www.google.co.in";

	@Test
	public void f() throws IOException {
		/*
		 * Write automation script to read excel file using apache POI(Download and
		 * configure Apache jars in your project)
		 */
		String xlPath = "./Data/TestData.xlsx";
		XSSFWorkbook workBook = new XSSFWorkbook(xlPath);
		XSSFSheet sheet = workBook.getSheet("Sheet1");
		for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
			driver.findElement(By.name("q")).sendKeys(sheet.getRow(i).getCell(0).getStringCellValue());
			driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
			driver.navigate().back();
		}
		workBook.close();
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
	}

}