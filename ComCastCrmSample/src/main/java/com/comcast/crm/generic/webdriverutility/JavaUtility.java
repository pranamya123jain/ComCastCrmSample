package com.comcast.crm.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	
 public int getRandomNumber()
 {
	 Random random= new Random();
	int randomInt= random.nextInt(5000);
	return randomInt;
 }
 
 SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
 public String getSystemDateYYYYMMDD()
 {
	 Date dateobj=new Date();
	 String date=sdf.format(dateobj);
	return date; 
 }
 public String getRequiredDateYYYYMMDD(int days)
 {
		Calendar cal=sdf.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, days);
		String endDate=sdf.format(cal.getTime());
		return endDate;
 }
}
