package practice.HomepageTest;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HomePageSampleSoftAssertTest3 {
	@Test
	public void homePageTest(Method mtd) {
SoftAssert sa= new SoftAssert();
		System.out.println(mtd.getName() + "Test Starts");
		System.out.println("Step-1");
		System.out.println("Step-2");
		Assert.assertEquals("home", "homePage");
		System.out.println("Step-3");
		sa.assertEquals("home-CRM", "home-CRM");
		System.out.println("Step-4");

		System.out.println(mtd.getName() + "TestEnd");

	}

	@Test
	public void verifyLogoHomepageTest(Method mtd) {
		SoftAssert sa= new SoftAssert();
		System.out.println(mtd.getName() + "Test Starts");
		System.out.println("Step-1");
		System.out.println("Step-2");
		sa.assertTrue(true);
		System.out.println("Step-3");
		System.out.println("Step-4");

		System.out.println(mtd.getName() + "TestEnd");

	}

}
