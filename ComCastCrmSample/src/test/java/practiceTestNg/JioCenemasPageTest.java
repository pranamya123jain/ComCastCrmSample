package practiceTestNg;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class JioCenemasPageTest {

	@Test
	public void getCwenemaInfoTest() {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.jiocinema.com/");

//		// search product in amazon
//		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("puma shoes", Keys.ENTER);


		driver.quit();
	}
	@Test
	public void getProductIngfoTest() {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.amazon.in/");

		// search product in amazon
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("puma shoes", Keys.ENTER);


		driver.quit();
	}
}
