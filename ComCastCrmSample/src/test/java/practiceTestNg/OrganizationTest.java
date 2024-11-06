package practiceTestNg;

import org.testng.annotations.Test;


import com.comcast.crm.ObjectrepositoryUtility.CreatingNewOrganizationPage;
import com.comcast.crm.ObjectrepositoryUtility.HomePage;
import com.comcast.crm.ObjectrepositoryUtility.OrganizationInformationPage;
import com.comcast.crm.ObjectrepositoryUtility.OrganizationsPage;
import com.comcast.crm.baseTest.BaseClass;

public class OrganizationTest extends BaseClass {
	@Test(groups = {"smoke test"})
	public void CreateOrganization() throws Throwable {
		String orgName = eLib.getDtaFromExcel("org", 10, 2) + jLib.getRandomNumber();
		String pindustry = eLib.getDtaFromExcel("org", 4, 3);

		HomePage hp = new HomePage(driver);// navigate to organization
		hp.getOrgLink().click();

		OrganizationsPage cnp = new OrganizationsPage(driver);
		cnp.getCreateNewOrgBtn().click();// click on create organization(+)

		CreatingNewOrganizationPage oNp = new CreatingNewOrganizationPage(driver);
		oNp.creatOrg(orgName, pindustry);// enter all the details and create new organization

		OrganizationInformationPage oip = new OrganizationInformationPage(driver);
		String actOrgName = oip.getHeaderMsg().getText();// verify the header msg
		if (actOrgName.contains(orgName)) {
			System.out.println("pass");
		} else {
			System.out.println("fail");
		}
		// go back to organization page
		hp.getOrgLink().click();
		System.out.println("exicuted");

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
		if (indDD.contains(pindustry)) {
			System.out.println(pindustry + "is present==PASS");
		} else {
			System.out.println(pindustry + "is not present==FAIL");
		}

		// verify type expected result

		String actType = oIp.getTypeDD().getText();
		if (actType.contains(type)) {
			System.out.println(type + "info is correct==PASS");
		} else {
			System.out.println(type + "info is correct==FAIL");
		}
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

	}

}
