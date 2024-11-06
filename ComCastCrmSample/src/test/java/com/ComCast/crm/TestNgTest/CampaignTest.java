package com.ComCast.crm.TestNgTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.ObjectrepositoryUtility.CampaignInfoPage;
import com.comcast.crm.ObjectrepositoryUtility.CampaignPage;
import com.comcast.crm.ObjectrepositoryUtility.CreateNewCampaignPage;
import com.comcast.crm.ObjectrepositoryUtility.HomePage;
import com.comcast.crm.baseTest.BaseClass;

public class CampaignTest extends BaseClass {

	@Test
	public void createCampaign() throws Throwable {
		String campaignName = eLib.getDtaFromExcel("Campaigns", 1, 2);

		HomePage hp = new HomePage(driver);
		hp.navigatetoMore();
		hp.navigateToCampaignspage();

		CampaignPage cP = new CampaignPage(driver);
		cP.getcreateCampaignLink().click();

		CreateNewCampaignPage cNcP = new CreateNewCampaignPage(driver);
		cNcP.toCreateCampaign(campaignName);
		
		CampaignInfoPage cIp=new CampaignInfoPage(driver);
		String actCampaign=cIp.getHeaderMsg().getText();
		boolean result=actCampaign.contains(campaignName);
		Assert.assertEquals(result, true);
		
		String actcampaignName=cIp.getCampaignNameInfo().getText();
		boolean result1=actcampaignName.equals(campaignName);
		Assert.assertEquals(result1, true);
		
		
		//String headerInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
//		if (headerInfo.contains(campaignName)) {
//			System.out.println(campaignName + "is created==PASS");
//		} else {
//			System.out.println(campaignName + "is not created==FAIL");
//		}

	}

}
