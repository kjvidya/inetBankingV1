package com.inetbanking.testData;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class RegistrationTest {

	public static void main(String[] args) throws IOException {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\PRASANTH\\Desktop\\Git1\\inetBankingV1\\Drivers\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://newtours.demoaut.com/");
		
		FileInputStream file = new FileInputStream("System.getProperty(\"user.dir\")+\"/src/test/java/com/inetbanking/testData/Registration.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook(file);
		
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		
		int NoOfRows = sheet.getLastRowNum();
		
		System.out.println("No of Rows" +NoOfRows);
		
		for(int row=1; row<=NoOfRows; row++)
		{
			 	 XSSFRow currentrow = sheet.getRow(row);
			 	 
			 	String First_name = currentrow.getCell(0).getStringCellValue();
			 	
			 	String Last_name = currentrow.getCell(1).getStringCellValue();
			 	
			 	
			 	String Phone = currentrow.getCell(2).toString();
			 	
			 	
			 	String Email = currentrow.getCell(3).getStringCellValue();
			 	
			 	
			 	String Address = currentrow.getCell(4).getStringCellValue();
			 	
			 	
			 	String City = currentrow.getCell(5).getStringCellValue();
			 	
			 	String State = currentrow.getCell(6).getStringCellValue();
			 	
			 	String PinCode = currentrow.getCell(7).toString();
			 	
			 	String Country = currentrow.getCell(8).getStringCellValue();
			 	
			 	String UserName = currentrow.getCell(9).getStringCellValue();
			 	
			 	String Password = currentrow.getCell(10).getStringCellValue();
			 	
			 	driver.findElement(By.linkText("REGISTER")).click();
			 	
			    driver.findElement(By.name("firstName")).sendKeys(First_name);
			    driver.findElement(By.name("lastName")).sendKeys(Last_name);
			    driver.findElement(By.name("phone")).sendKeys(Phone);
			    driver.findElement(By.name("userName")).sendKeys(Email);
			    			    
			    driver.findElement(By.name("address1")).sendKeys(Address);
			    driver.findElement(By.name("address2")).sendKeys(Address);
			    driver.findElement(By.name("city")).sendKeys(City);
			    driver.findElement(By.name("state")).sendKeys(State);
			    driver.findElement(By.name("postalCode")).sendKeys(PinCode);
			    
			    Select dropcountry = new Select(driver.findElement(By.xpath("//select[@name='country']")));
			    dropcountry.selectByVisibleText(Country);
			    
			    driver.findElement(By.name("email")).sendKeys(UserName);
			    
			    driver.findElement(By.name("password")).sendKeys(Password);
			    driver.findElement(By.name("confirmPassword")).sendKeys(Password);
			    
			    
			    driver.findElement(By.name("register")).click();
			    
			    if(driver.getPageSource().contains("Thank you for registering"))
			    {
			    	System.out.println("Registration completed for " + row + "record");
			    }
			    else
			    {
			    	System.out.println("Registration failed for" + row + "record");
			    }
			    
		    
		}
		
		System.out.println("Data driven testing completed");
		driver.close();
		driver.quit();
		file.close();
	}

}


