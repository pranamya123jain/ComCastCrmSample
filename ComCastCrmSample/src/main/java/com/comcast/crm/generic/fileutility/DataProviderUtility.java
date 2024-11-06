package com.comcast.crm.generic.fileutility;

import org.testng.annotations.DataProvider;

public class DataProviderUtility {
	@DataProvider
	public Object[][]getData() throws Throwable, Throwable
	{
		ExelUtility eLib=new ExelUtility();
		
		int rowCount=eLib.getRowCount("AmezonProduct");
		
		Object objArr[][]=new Object[3][2];
		
		for (int i = 0; i < rowCount; i++) {
			objArr[i][0]= eLib.getDtaFromExcel("AmezonProduct", i+1, 0);
			objArr[i][1]= eLib.getDtaFromExcel("AmezonProduct", i+1, 1);
		}
		
		return objArr;
	}
}

