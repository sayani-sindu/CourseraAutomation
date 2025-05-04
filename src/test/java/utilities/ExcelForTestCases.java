package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ExcelForTestCases {
	//Declaring the variables
		 XSSFWorkbook workbook;
		 XSSFSheet sheet;
		 XSSFRow row;
		 XSSFCell cell;
		 static ExcelForTestCases excel;
		 
		 //Array to store the details
		 String[] data;
		 
		 //Method to get the row number
		 public int getRowNum(XSSFSheet sheet) {
			 return sheet.getLastRowNum();
		 }
		 
		 //Method to get the cell number(in each row)
		 public int getCellNum(XSSFSheet sheet, XSSFRow row) {
			 return row.getLastCellNum();
		 }
	 
		 //Method to write data into the excel
		 public void writeExcel(int rno, int cno, String msg) throws IOException, FileNotFoundException{
			 String path = System.getProperty("user.dir") + "\\testData\\Identify Courses TCReport.xlsx";
			 FileInputStream file = new FileInputStream(path);
			 workbook = new XSSFWorkbook(file);
			 
			 try {
			 
				 sheet = workbook.getSheet("TEST CASES");
				 if (sheet == null) {
				 sheet = workbook.createSheet("TEST CASES");
				 }
				 XSSFRow row = sheet.getRow(rno);
				 if (row == null) {
				 row = sheet.createRow(rno);
				 }
				 XSSFCell cell = row.getCell(cno);
				 if (cell == null) {
				 cell = row.createCell(cno);
				 }
				 cell.setCellValue(msg);
				 file.close();
				 FileOutputStream outFile = new FileOutputStream(path);
				 workbook.write(outFile);
				 outFile.close();
			 } catch (Exception e) {
				 e.printStackTrace();
			 }
	 }
	 
	
}
