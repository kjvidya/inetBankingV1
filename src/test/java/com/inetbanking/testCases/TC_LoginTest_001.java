package com.inetbanking.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass{
	
	
	@Test
	public void LoginTest() throws InterruptedException, IOException
	{
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		
		logger.info("URL is opened");
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Username entered");
		Thread.sleep(2000);
		
		lp.setPassword(password);
		logger.info("password entered");
		
		lp.clickSubmit();
		System.out.println("hiii");
		
		String Title = driver.getTitle();
		System.out.println(Title);
		
		if(Title.equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("testcase passed");
		}
		else
		{
			captureScreen(driver,"LoginTest");
			Assert.assertTrue(false);
			logger.info("testcase failed");
		}
		
	}
	

}
