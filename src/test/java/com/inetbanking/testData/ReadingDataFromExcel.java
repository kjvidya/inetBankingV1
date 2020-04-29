package com.inetbanking.testData;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingDataFromExcel {

	public static void main(String[] args) throws IOException {
		
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"/src/test/java/com/inetbanking/testData/Testdata.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		int rowcount = sheet.getLastRowNum();
		
		System.out.println(rowcount);
		int colcount = sheet.getRow(0).getLastCellNum();
		
		for(int i=1;i<rowcount;i++)
		{
			XSSFRow currentrow = sheet.getRow(i);
			
			for(int j=0;j<colcount;j++)
			{
				String value = currentrow.getCell(j).toString();
				System.out.print( " " +value);
			}
			
			System.out.println();
		}
		

	}

}
