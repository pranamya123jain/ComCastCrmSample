package com.comcast.crm.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DatabaseUtility {
	Connection con;
	public void getDBConnection(String url,String username,String password) throws Throwable 
	{
		try {
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			con= DriverManager.getConnection(url, username, password);
			
		} catch (Exception e) {
			
		}	
	}
	
	public void getDBConnection() throws Throwable 
	{
		try {
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			con= DriverManager.getConnection("jdbc:mysql://106.51.90.215:3333/projects","root@%", "root");
			
		} catch (Exception e) {
			
		}	
	}
	
	public void closeConnection() {
		try {
			con.close();
		} catch (Exception e) {
			
		}
	}
	public ResultSet exicuteSelectQuery(String query) throws Throwable 
	{
		ResultSet result=null;
		try {
			Statement stat=con.createStatement();
			 result= stat.executeQuery(query);	 
		} catch (Exception e) {	
		}
		return result;
	}
	public int exicuteNonSelectQuery(String query)
	{
		int result = 0;
		try {
			Statement stat=con.createStatement();
			result=stat.executeUpdate(query);
		} catch (Exception e) {
		}
		return result;
	}
}
