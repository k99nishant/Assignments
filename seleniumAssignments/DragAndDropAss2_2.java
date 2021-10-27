package seleniumAssignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DragAndDropAss2_2 {
	WebDriver driver;
	String url = "https://jqueryui.com/droppable/";

	@Test
	public void f() {
		WebElement draggable = driver.findElement(By.id("draggable"));
		WebElement droppable = driver.findElement(By.id("droppable"));
		
		Actions action = new Actions(driver);
		action.dragAndDrop(draggable, droppable).perform();
		
		String afterDragging = driver.findElement(By.xpath("//*[@id=\"droppable\"]/p")).getText();
		
		if(afterDragging.equals("Dropped!")) {
			System.out.println("Drag Successful");
		}else {
			System.out.println("Drag unsuccessful");
		}
		
	}

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		
	}

	@AfterTest
	public void afterTest() {
		driver.close();
		driver.quit();
	}

}
