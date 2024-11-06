package practice.HomepageTest;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageVerificationTest {
	@Test
	public void homePageTest(Method mtd) {
		
		System.out.println(mtd.getName()+"Test Starts");
		
		String expectedPage="Home";
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("123");
		driver.findElement(By.id("submitButton")).click();
		
		String actTitle=driver.findElement(By.xpath("//a[contains (text(),'Home')]")).getText();
		
		//hard assert
		Assert.assertEquals(actTitle, expectedPage);
		
//		if (actTitle.trim().equals(expectedPage)) {
//			System.out.println(expectedPage+"page is verified =PASS");
//		}
//		else {
//			System.out.println(expectedPage+"page is verified =FAIL");
//		}
		
		
		System.out.println(mtd.getName()+"TestEnd");
		driver.close();
	}

	@Test
	public void verifyLogoHomepageTest(Method mtd) {
System.out.println(mtd.getName()+"Test Starts");
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("123");
		driver.findElement(By.id("submitButton")).click();
		
		boolean status=driver.findElement(By.xpath("//img[@title='vtiger-crm-logo.gif']")).isDisplayed();
		
		//hard assert
		Assert.assertTrue(status);
//		if (status) {
//			System.out.println("Logo is verified =PASS");
//		}
//		else {
//			System.out.println("Logo is verified =FAIL");
//		}
		System.out.println(mtd.getName()+"TestEnd");
		driver.close();
	}
	
		
	}

