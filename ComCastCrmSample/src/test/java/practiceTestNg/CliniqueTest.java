package practiceTestNg;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.reactivex.rxjava3.functions.Action;

public class CliniqueTest {
	
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.clinique.com/");
	driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		////li[@class='gnav-block__navigation-item js-gnav-block-navigation-item'][4]
		WebElement element = driver.findElement(By.xpath("//input[@id='gnav-link-Skincare']"));
		Actions act= new Actions(driver);
		act.moveToElement(element).perform();
		
		
	}

}
