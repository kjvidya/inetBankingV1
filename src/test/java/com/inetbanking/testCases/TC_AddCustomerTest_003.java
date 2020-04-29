package com.inetbanking.testCases;

import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass{
	
	@Test
	public void AddNewCustomer() throws InterruptedException, IOException
	{
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("username provided");
		lp.setPassword(password);
		logger.info("password provided");
		lp.clickSubmit();
		 
		
		
		
		AddCustomerPage addcust = new AddCustomerPage(driver);
		
		logger.info("Adding customer details....");
		
		addcust.clickAddNewCustomer();
		addcust.custName("ppp");
		addcust.custgender("female");
		addcust.custdob("10", "15", "1985");
		Thread.sleep(3000);
		addcust.custaddress("INDIA");
		addcust.custcity("bangalore");
		addcust.custstate("KA");
		addcust.custpinno("500074");
		addcust.custtelephoneno("99884666061");
		
		String email = randomstring()+"@gmail.com";
		addcust.custemailid(email);
		addcust.custpassword("password");
		addcust.custsubmit();
		
		Thread.sleep(3000);
		
		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
		System.out.println(res);
		
		
		logger.info("Validation started..");
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("Testcase passed...");
		}
		else
		{
			
			logger.info("Testcase failed");
			captureScreen(driver,"AddNewCustomer");
			Assert.assertTrue(false);
		}
		
		
	}
	
	
	

}
