package practiceTestNg;

import org.openqa.selenium.By;
import org.testng.annotations.Test;


import com.comcast.crm.ObjectrepositoryUtility.ChildOrganizationPage;
import com.comcast.crm.ObjectrepositoryUtility.ContactsPage;
import com.comcast.crm.ObjectrepositoryUtility.CreatingNewOrganizationPage;
import com.comcast.crm.ObjectrepositoryUtility.HomePage;
import com.comcast.crm.ObjectrepositoryUtility.LoginPage;
import com.comcast.crm.ObjectrepositoryUtility.OrganizationsPage;
import com.comcast.crm.baseTest.BaseClass;

public class ContactTest extends BaseClass {

	@Test(groups = {"smoke test"})
	public void createContactTest() throws Throwable {
		String lastName = eLib.getDtaFromExcel("contact", 1, 2) + jLib.getRandomNumber();
		System.out.println("done");

		HomePage hp = new HomePage(driver);
		hp.getContactLink();

		ContactsPage cP = new ContactsPage(driver);
		cP.creatContact(lastName);

	}

	@Test(groups = {"regression test"})
	public void CreateContactWithOrgTest() throws Throwable {
		String OrgName = eLib.getDtaFromExcel("contact", 7, 2) + jLib.getRandomNumber();
		String pindustry = eLib.getDtaFromExcel("org", 4, 3);
		String lastName = eLib.getDtaFromExcel("contact", 7, 3) + jLib.getRandomNumber();
		System.out.println("done");

		HomePage hp = new HomePage(driver); // navigate to organization
		hp.getOrgLink().click();

		OrganizationsPage cnp = new OrganizationsPage(driver);// click on create organization(+)
		cnp.getCreateNewOrgBtn().click();

		CreatingNewOrganizationPage oIp = new CreatingNewOrganizationPage(driver);// enter all the details and create
																					// new organization
		oIp.creatOrg(OrgName, pindustry);

		Thread.sleep(2000);
		hp.getContactLink();// click on contact page

		ContactsPage cP = new ContactsPage(driver);
		cP.creatContact(lastName);

		wLib.SwitchToTabToURL(driver, "module=Accounts&action");// switch to child window
		ChildOrganizationPage cOp = new ChildOrganizationPage(driver);
		cOp.creatChildOrg(OrgName);
		driver.findElement(By.xpath("//a[text()='" + OrgName + "']"));

		wLib.SwitchToTabToURL(driver, "module=Contacts&action");// switch to parent window

		cP.getSaveBtn().click();

		String actLastName = cP.getHeaderMsg().getText();
		if (actLastName.contains(lastName)) {
			System.out.println("pass");
		} else {
			System.out.println("fail");
		}
	}

	@Test(groups = {"regression test"})
	public void createContacctWithSupportTest() throws Throwable {
		String OrgName = eLib.getDtaFromExcel("contact", 7, 2) + jLib.getRandomNumber();
		String pindustry = eLib.getDtaFromExcel("org", 4, 3);
		String lastName = eLib.getDtaFromExcel("contact", 7, 3) + jLib.getRandomNumber();
		// String lastName = eLib.getDtaFromExcel("contact", 4,
		// 2)+jLib.getRandomNumber();
		System.out.println("done");

		HomePage hp = new HomePage(driver); // navigate to organization
		hp.getOrgLink().click();

		OrganizationsPage cnp = new OrganizationsPage(driver);// click on create organization(+)
		cnp.getCreateNewOrgBtn().click();

		CreatingNewOrganizationPage oIp = new CreatingNewOrganizationPage(driver);// enter all the details and create
																					// new organization
		oIp.creatOrg(OrgName, pindustry);

		Thread.sleep(2000);
		hp.getContactLink();// click on contact page

		ContactsPage cP = new ContactsPage(driver);
		cP.creatContact(lastName);

		wLib.SwitchToTabToURL(driver, "module=Accounts&action");// switch to child window
		ChildOrganizationPage cOp = new ChildOrganizationPage(driver);
		cOp.creatChildOrg(OrgName);
		driver.findElement(By.xpath("//a[text()='" + OrgName + "']"));

		wLib.SwitchToTabToURL(driver, "module=Contacts&action");// switch to parent window

		String startDate = jLib.getSystemDateYYYYMMDD();
		String endDate = jLib.getRequiredDateYYYYMMDD(30);
		cP.creatContact(startDate, endDate);

		cP.getSaveBtn().click();

		// verify LastName
		String actName = cP.getActLastName().getText();
		if (actName.equals(lastName)) {
			System.out.println(actName + "is present==PASS");
		} else {
			System.out.println(actName + "is not present==FAIL");
		}

		// verify Start Date
		String actdateSrtaDate = cP.getActStartDate().getText();
		if (actdateSrtaDate.equals(startDate)) {
			System.out.println(actdateSrtaDate + "is present==PASS");
		} else {
			System.out.println(actdateSrtaDate + "is not present==FAIL");
		}

		// verify End date
		String actEndDate = cP.getActEndDate().getText();
		if (actEndDate.equals(endDate)) {
			System.out.println(actEndDate + "is present==PASS");

		} else {
			System.out.println(actEndDate + "is not present==FAIL");
		}
	}

}
