package com.ameer.learning.automation.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelReader extends BaseTest {

	private static XSSFSheet sheet;

	private static XSSFWorkbook workbook;

	private static XSSFCell Column;

	private static XSSFRow Row;
	
	
	/*@DataProvider(name = "DataFromExcel")

	  public static Object[][] ExcelSheet() throws Exception {

	Object[][] Arr= MESdata("C:/Users/Ameer/Documents/GitHub/automation/Datafiles/ExcelReader_TestNG.xlsx","AmazonIndia");

	       return Arr;
	}
	*/
	
	
	
	
	
	public static Object[][] MESdata(String filename, String sheetName) throws Exception {   

		   String[][] data = null;

		   try {
		//Path of the excel file
		FileInputStream fs = new FileInputStream(filename);
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		XSSFRow Row = sheet.getRow(0);
		int noOfRows =sheet.getPhysicalNumberOfRows();
		int noOfCell =Row.getPhysicalNumberOfCells();
		XSSFCell Column;
		
		data= new String[noOfRows][noOfCell];
		
		for(int i=1;i<noOfRows;i++) {
			for(int j=0;j<noOfCell;j++) {
			Row=sheet.getRow(i);
			Column=Row.getCell(j);
			data [i-1][j]= Column.getStringCellValue();
				}
		}
		
	 }
	    catch (FileNotFoundException e){

				System.out.println("Could not read the Excel sheet");

				e.printStackTrace();

				}
		   
		catch (IOException e){

				System.out.println("Could not read the Excel sheet");

				e.printStackTrace();

				}
		   return (data);
}
	
	
	
	
	
	
	
	
	
	
}
