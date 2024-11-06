package practice.HomepageTest;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageSampleReportTest3 {
	@Test
	public void homePageTest(Method mtd) {

		System.out.println(mtd.getName() + "Test Starts");
		System.out.println("Step-1");
		System.out.println("Step-2");
		Assert.assertEquals("home", "homePage");
		System.out.println("Step-3");
		Assert.assertEquals("home-CRM", "home-CRM");
		System.out.println("Step-4");

		System.out.println(mtd.getName() + "TestEnd");

	}

	@Test
	public void verifyLogoHomepageTest(Method mtd) {
		System.out.println(mtd.getName() + "Test Starts");
		System.out.println("Step-1");
		System.out.println("Step-2");
		Assert.assertTrue(true);
		System.out.println("Step-3");
		System.out.println("Step-4");

		System.out.println(mtd.getName() + "TestEnd");

	}

}
