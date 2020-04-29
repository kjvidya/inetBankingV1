package com.inetbanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.XLUtils;

import junit.framework.Assert;

public class TC_LoginDDT_002 extends BaseClass {
	
	@Test(dataProvider = "LoginData")
	public void loginDDT(String user,String pass) throws InterruptedException
	{
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(user);
		logger.info("user name provided");
		lp.setPassword(pass);
		logger.info("password provided");
		lp.clickSubmit();
		Thread.sleep(3000);
		
		if(isAlertPresent() == true)
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("login failed");
		}
		else
		{
			Assert.assertTrue(true);
			logger.info("login passed");
			lp.clickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
		
	}
	
	
	public boolean isAlertPresent()//user defined method created to check alert present or not
	{
		try
		{
			driver.switchTo().alert();
			return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
	}
	
	@DataProvider(name = "LoginData")
	String [][] getData() throws IOException
	
	{
		String path = System.getProperty("user.dir")+"/src/test/java/com/inetbanking/testData/Testdata.xlsx";
		//String path = "C:\\Users\\PRASANTH\\Desktop\\Property\\LoginData.xlsx";
		int rowcount = XLUtils.getRowCount(path, "Sheet1");
		int colcount = XLUtils.getCellCount(path, "Sheet1", 1);
		System.out.println(rowcount);
		System.out.println(colcount);
		String logindata[][] = new String[rowcount][colcount];
		
		for(int i=1;i<=rowcount;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1",i,j);
			}
		}
		return logindata;
	}
}
