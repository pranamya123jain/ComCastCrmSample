package practiceTestNg;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.ExelUtility;

public class GetProductInfoTest {

	@Test(dataProvider = "getData")
	public void getProductIngoTest(String brandName, String productName) {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.amazon.in/");

		// search product in amazon
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(brandName, Keys.ENTER);

		// capture the product info
		String x = "//span[text()='" + productName
				+ "']/../../../../div[3]/div[1]/div/div[1]/div[1]/div[1]/a/span/span[2]/span[2]";
		String price = driver.findElement(By.xpath(x)).getText();
		System.out.println(price);

		driver.quit();
	}

	@DataProvider
	public Object[][] getData() throws Throwable, Throwable {
		ExelUtility eLib = new ExelUtility();
		int rowount = eLib.getRowCount("AmezonProduct");

		Object[][] objArr = new Object[3][2];

		for (int i = 0; i < rowount; i++) {

			objArr[i][0] = eLib.getDtaFromExcel("AmezonProduct", i + 1, 0);
			objArr[i][1] = eLib.getDtaFromExcel("AmezonProduct", i + 1, 1);

		}

		return objArr;

//		objArr[1][0]="iphone";
//		objArr[1][1]="Apple iPhone 13 (128GB) - Starlight";
//		
//		objArr[2][0]="iphone";
//		objArr[2][1]="Apple iPhone 13 (128GB) - Midnight";

	}
}
