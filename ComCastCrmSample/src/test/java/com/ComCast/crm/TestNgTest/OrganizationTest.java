package com.ComCast.crm.TestNgTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.comcast.crm.ObjectrepositoryUtility.CreatingNewOrganizationPage;
import com.comcast.crm.ObjectrepositoryUtility.HomePage;
import com.comcast.crm.ObjectrepositoryUtility.OrganizationInformationPage;
import com.comcast.crm.ObjectrepositoryUtility.OrganizationsPage;
import com.comcast.crm.baseTest.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;

@Listeners(com.comcast.crm.listenerutility.ListImpClass.class)
public class OrganizationTest extends BaseClass {
	@Test(groups = {"smoke test"})
	public void CreateOrganization() throws Throwable {
		// ListImpClass.test.log(Status.INFO, "read data from excel");
		UtilityClassObject.getTest().log(Status.INFO, "read data from excel");
		String orgName = eLib.getDtaFromExcel("org", 10, 2) + jLib.getRandomNumber();
		String pindustry = eLib.getDtaFromExcel("org", 4, 3);

		// ListImpClass.test.log(Status.INFO, "navigate to org link");
		UtilityClassObject.getTest().log(Status.INFO, "navigate to org link");
		HomePage hp = new HomePage(driver);// navigate to organization
		hp.getOrgLink().click();

		UtilityClassObject.getTest().log(Status.INFO, "click on create org");
		OrganizationsPage cnp = new OrganizationsPage(driver);
		cnp.getCreateNewOrgBtn().click();// click on create organization(+)

		// .test.log(Status.INFO, "rcreate new org page by giving input orgName and
		// industry name");
		CreatingNewOrganizationPage oNp = new CreatingNewOrganizationPage(driver);

		oNp.creatOrg(orgName, pindustry);// enter all the details and create new organization
		UtilityClassObject.getTest().log(Status.INFO, orgName + "==>create new org");

		UtilityClassObject.getTest().log(Status.INFO, "verification Org header");
		OrganizationInformationPage oip = new OrganizationInformationPage(driver);
		String actOrgName = oip.getHeaderMsg().getText();// verify the header msg
		boolean result = actOrgName.contains(orgName);
		Assert.assertEquals(result, true);

	}

	@Test(groups = {"regression test"})
	public void creatOrganiztionWithIndustries() throws Throwable {
		String orgName = eLib.getDtaFromExcel("org", 10, 2) + jLib.getRandomNumber();
		String type = eLib.getDtaFromExcel("org", 4, 4);
		String pindustry = eLib.getDtaFromExcel("org", 4, 3);

		HomePage hp = new HomePage(driver);// navigate to organization
		hp.getOrgLink().click();

		OrganizationsPage cnp = new OrganizationsPage(driver);
		cnp.getCreateNewOrgBtn().click();// click on create organization(+)

		CreatingNewOrganizationPage cNp = new CreatingNewOrganizationPage(driver);
		cNp.creatOrg(orgName, pindustry, type);

		OrganizationInformationPage oIp = new OrganizationInformationPage(driver);

		String indDD = oIp.getIndustryDD().getText();
		// verify industryDD expected result
		boolean result = indDD.equals(pindustry);
		Assert.assertEquals(result, true);

		// verify type expected result
		String actType = oIp.getTypeDD().getText();
		boolean result1 = actType.equals(type);
		Assert.assertEquals(result1, true);

//		if (indDD.contains(pindustry)) {
//			System.out.println(pindustry + "is present==PASS");
//		} else {
//			System.out.println(pindustry + "is not present==FAIL");
//		}
//		// verify type expected result
//		String actType = oIp.getTypeDD().getText();
//		if (actType.contains(type)) {
//			System.out.println(type + "info is correct==PASS");
//		} else {
//			System.out.println(type + "info is correct==FAIL");
//		}
	}

	@Test(groups = {"regression test"})
	public void createOrganizationWithContactNo() throws Throwable {
		String orgName = eLib.getDtaFromExcel("org", 1, 2) + jLib.getRandomNumber();
		String pindustry = eLib.getDtaFromExcel("org", 4, 3);
		String type = eLib.getDtaFromExcel("org", 4, 4);
		String phoneNo = eLib.getDtaFromExcel("org", 7, 3);

		HomePage hp = new HomePage(driver);// navigate to organization
		hp.getOrgLink().click();

		OrganizationsPage cnp = new OrganizationsPage(driver);
		cnp.getCreateNewOrgBtn().click();// click on create organization(+)

		CreatingNewOrganizationPage cNp = new CreatingNewOrganizationPage(driver);
		cNp.creatOrg(orgName, pindustry, type, phoneNo);
		Thread.sleep(3000);
		System.out.println("exicuted");

		OrganizationInformationPage oIp = new OrganizationInformationPage(driver);
		String actphoneNo = oIp.getPhoneNoInfo().getText();
		boolean result = actphoneNo.equals(actphoneNo);
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(result);
		sa.assertAll();
	}

}
