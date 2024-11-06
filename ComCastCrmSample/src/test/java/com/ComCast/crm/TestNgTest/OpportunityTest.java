package com.ComCast.crm.TestNgTest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.ObjectrepositoryUtility.ChildOrganizationPage;
import com.comcast.crm.ObjectrepositoryUtility.CreatingNewOpportunityPage;
import com.comcast.crm.ObjectrepositoryUtility.CreatingNewOrganizationPage;
import com.comcast.crm.ObjectrepositoryUtility.HomePage;
import com.comcast.crm.ObjectrepositoryUtility.OpportunitiesPage;
import com.comcast.crm.ObjectrepositoryUtility.OpportunityInformationPage;
import com.comcast.crm.ObjectrepositoryUtility.OrganizationsPage;
import com.comcast.crm.baseTest.BaseClass;

public class OpportunityTest extends BaseClass {
	
@Test
public void createOpp()
{
	String parentId = driver.getWindowHandle();
	wLib.waitForPageToLoad(driver);

	HomePage hp = new HomePage(driver);
	hp.getOrgLink().click();// click on organization link
	
	hp.getOpportunityLink().click();// click on opportunity link

}
	
	@Test
	public void createOpportunity() throws Throwable {
		// data from Opportunity excel page
		String oppName = eLib.getDtaFromExcel("Opportunity", 1, 2) + jLib.getRandomNumber();
		String orgName = eLib.getDtaFromExcel("Opportunity", 4, 2) + jLib.getRandomNumber();

		String parentId = driver.getWindowHandle();
		wLib.waitForPageToLoad(driver);

		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();// click on organization link

		OrganizationsPage cnp = new OrganizationsPage(driver);
		cnp.getCreateNewOrgBtn().click();// click on create new org +

		CreatingNewOrganizationPage oIp = new CreatingNewOrganizationPage(driver);
		oIp.creatOrg(orgName);// enter org name//click on save
		Thread.sleep(2000);

		hp.getOpportunityLink().click();// click on opportunity link

		OpportunitiesPage oP = new OpportunitiesPage(driver);
		oP.getCreatNewOpportunityBtn().click();// create opp +

		CreatingNewOpportunityPage cnop = new CreatingNewOpportunityPage(driver);
		cnop.creatOpportunity(oppName);// enter opp name and click on +

		wLib.SwitchToTabToURL(driver, "Accounts&action");// switch to child window

		ChildOrganizationPage cO = new ChildOrganizationPage(driver);
		cO.creatChildOrg(orgName);// enter org name and click on search button in child popup
		driver.findElement(By.xpath("//a[text()='" + orgName + "']")).click();

		wLib.SwitchToTabToURL(driver, "module=Potentials");// switch to parent window

		cnop.getSaveBtn().click();

		// OppIp.getOpportunityInformation();
		OpportunityInformationPage oppIp = new OpportunityInformationPage(driver);
		String actOppName = oppIp.getHeaderMsg().getText();
		boolean result=actOppName.contains(oppName);
		Assert.assertEquals(result, true);
		
		
//		if (actOppName.contains(oppName)) {
//			System.out.println("pass");
//		} else {
//			System.out.println("fail");
//		}
	}

}
