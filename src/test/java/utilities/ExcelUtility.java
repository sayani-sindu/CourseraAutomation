package utilities;

import java.io.FileInputStream;

import java.io.IOException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtility {
    private Workbook workbook;

    // Constructor to initialize Workbook
    public ExcelUtility(String filePath) throws IOException {
        FileInputStream fis = new FileInputStream(filePath);
        workbook = new XSSFWorkbook(fis);
    }

    // Method to get the total row count in a sheet
    public int getRowCount(String sheetName) {
        Sheet sheet = workbook.getSheet(sheetName);
        return sheet.getLastRowNum();
    }

    // Method to get the total cell count in a row
    public int getCellCount(String sheetName, int rowNum) {
        Sheet sheet = workbook.getSheet(sheetName);
        Row row = sheet.getRow(rowNum);
        return row.getLastCellNum();
    }

    // Method to retrieve cell data
    public String getCellData(String sheetName, int rowNum, int colNum) {
        Sheet sheet = workbook.getSheet(sheetName);
        Row row = sheet.getRow(rowNum);
        DataFormatter formatter = new DataFormatter();
        return formatter.formatCellValue(row.getCell(colNum));
    }
   
    // Close workbook to free resources
    public void closeWorkbook() throws IOException {
        if (workbook != null) {
            workbook.close();
        }
    }
}
