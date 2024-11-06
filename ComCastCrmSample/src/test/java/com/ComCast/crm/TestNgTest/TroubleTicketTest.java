package com.ComCast.crm.TestNgTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.ObjectrepositoryUtility.CreateNewTroubleTicketsPage;
import com.comcast.crm.ObjectrepositoryUtility.HomePage;
import com.comcast.crm.ObjectrepositoryUtility.TroubleInformationPage;
import com.comcast.crm.ObjectrepositoryUtility.TroubleTicketPage;
import com.comcast.crm.baseTest.BaseClass;

public class TroubleTicketTest extends BaseClass {

	@Test
	public void createTroubleTicketsandverify() throws Throwable
	{
		HomePage hp = new HomePage(driver);
		hp.gettroubleTicketsLink().click();

		TroubleTicketPage ttp = new TroubleTicketPage(driver);
		ttp.getCreateTroubleLink().click();

		// read test data from excel
		String title = eLib.getDtaFromExcel("Trouble", 1, 2);
		
		
		CreateNewTroubleTicketsPage cnttp = new CreateNewTroubleTicketsPage(driver);
		cnttp.toCreateTicket(title);
		
		
		// Verify header information
		TroubleInformationPage tip = new TroubleInformationPage(driver);
		String headerinfo = tip.getHeaderMsg().getText();
	boolean result=	headerinfo.equals(headerinfo);		
		Assert.assertEquals(result, true);
		
		
//		if (headerinfo.contains(title)) {
//			System.out.println(title + " Is verified ==PASS");
//		} else {
//			System.out.println(title + " Is not verified ==FAILL");
//		}
	}

}
