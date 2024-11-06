package com.ComCast.crm.TestNgTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.ObjectrepositoryUtility.CreateNewProductPage;
import com.comcast.crm.ObjectrepositoryUtility.HomePage;
import com.comcast.crm.ObjectrepositoryUtility.ProductInformationPage;
import com.comcast.crm.ObjectrepositoryUtility.ProductPage;
import com.comcast.crm.baseTest.BaseClass;

public class ProductTest extends BaseClass{

		@Test
		public void creatProduct() throws Throwable
		{
			HomePage hp = new HomePage(driver);
			hp.getproductsLink().click();

			ProductPage pg = new ProductPage(driver);
			pg.getcreateProductLink().click();

			// read test data from excel
			String produname = eLib.getDtaFromExcel("Product", 1, 2);
			CreateNewProductPage cnpp = new CreateNewProductPage(driver);
			cnpp.toCreateProduct(produname);

			// verify the product is added or not
			ProductInformationPage prip = new ProductInformationPage(driver);
			String headerinfo = prip.getHeaderMsg().getText();
			boolean result=headerinfo.contains(produname);
			Assert.assertEquals(result, true);
			
			
//			if (headerinfo.contains(produname)) {
//				System.out.println("product added");
//			} else {
//				System.out.println("product not added");
//			}
			Thread.sleep(2000);
		}		
}
