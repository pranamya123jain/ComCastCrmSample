package com.comcast.crm.ObjectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
/**
 * contains login page elements & business library like login()
 *
 * @author Pranamya
 */
public class LoginPage extends WebDriverUtility{
//Rule no 1 create separate java class
	//Rule 2 Object creation
	WebDriver driver;//global variable
	public LoginPage(WebDriver driver)//constructor
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);	//this keyword reffers orrent class object
	}
	
	@FindBy(name="user_name")
	private WebElement usernameEdt;
	
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	
	@FindBy(id="submitButton")
	private WebElement loginBtn;
	//Rule no3 Object Initialization==>done in testScript
	//Rule 4 Object Encapsulation
	
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	/**object Utilization==>in testScript
	//Rule no 5 ==provide action==>business library this method is specific to business
	//and this method you cannot do for any other application.**/
	
	/**
	 * login to application based username,password,url arguments
	 * @param URL
	 * @param username
	 * @param password
	 */
	
	public void loginToApp(String URL,String username,String password)
	{
		waitForPageToLoad(driver);
		maximizeWindow(driver);
		driver.manage().window().maximize();
		driver.get(URL);
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginBtn.click();
	}
	
	
	
	
	
}
