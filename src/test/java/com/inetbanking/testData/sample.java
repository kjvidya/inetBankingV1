package com.inetbanking.testData;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class sample {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\PRASANTH\\Desktop\\Git1\\inetBankingV1\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/v4/");
		driver.findElement(By.name("uid")).sendKeys("mngr256802");
		driver.findElement(By.name("password")).sendKeys("tyvevEm");
		driver.findElement(By.name("btnLogin")).click();
		driver.findElement(By.linkText("New Customer")).click();
		

	}

}
