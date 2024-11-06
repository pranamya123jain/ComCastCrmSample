package com.ComCast.crm.TestNgTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.ObjectrepositoryUtility.CreateNewLeadPage;
import com.comcast.crm.ObjectrepositoryUtility.HomePage;
import com.comcast.crm.ObjectrepositoryUtility.LeadInfoPage;
import com.comcast.crm.ObjectrepositoryUtility.LeadPage;
import com.comcast.crm.baseTest.BaseClass;

public class LeadTest extends BaseClass{
		@Test
		public void creatLead() throws Throwable
		{
			HomePage hp = new HomePage(driver);
			hp.getleadLink().click();

			LeadPage leadp = new LeadPage(driver);
			leadp.getCreateLeadLink().click();

			// read test data from excel
			String lastname = eLib.getDtaFromExcel("Lead", 1, 2);
			String company = eLib.getDtaFromExcel("Lead", 4, 2);

			CreateNewLeadPage cnlp = new CreateNewLeadPage(driver);
			cnlp.toCreateLead(lastname, company);
			
			
			// verify the header msg expected result
			LeadInfoPage lip=new LeadInfoPage(driver);
			String headerInfo = lip.getHeaderMsg().getText();
		 boolean actheader=headerInfo.contains(lastname);
			Assert.assertEquals(actheader, true);
			
			
			
			
			
//			if (headerInfo.contains(lastname)) {
//				System.out.println(lastname + " is created ==Pass");
//			} else {
//				System.out.println(lastname + " is not created ==FAIL");
//			}
			
		}
			}

