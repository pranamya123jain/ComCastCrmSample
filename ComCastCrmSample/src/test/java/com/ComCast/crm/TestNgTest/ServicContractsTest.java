package com.ComCast.crm.TestNgTest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.ObjectrepositoryUtility.CreateServiceContractPage;
import com.comcast.crm.ObjectrepositoryUtility.HomePage;
import com.comcast.crm.ObjectrepositoryUtility.ServiceContractInfoPage;
import com.comcast.crm.ObjectrepositoryUtility.ServiceContractPage;
import com.comcast.crm.baseTest.BaseClass;

public class ServicContractsTest extends BaseClass{

@Test
public void creatServicContractsTest() throws Throwable
{
	HomePage hp = new HomePage(driver);
	hp.navigatetoMore();
	hp.navigatetoserviceContractsPage();
					
	// click on create campaign module
	ServiceContractPage scp=new ServiceContractPage(driver);
	scp.getServiceContractLink().click();
	
	String subject = eLib.getDtaFromExcel("Service", 1, 2);
	
	CreateServiceContractPage cscp=new CreateServiceContractPage(driver);
	cscp.toCreateserviceContract(subject);

	// verify header msg expected result
	
	ServiceContractInfoPage sCI=new ServiceContractInfoPage(driver);
	String actHeader=sCI.getHeaderInfo().getText();
	boolean result=actHeader.contains(subject);
	Assert.assertEquals(result, true);

//	String headerInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
//	if (headerInfo.contains(subject)) {
//	System.out.println(subject + "is created==PASS");
//	} else {
//			System.out.println(subject + "is not created==FAIL");
//			}
	

	}

}
