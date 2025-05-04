package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

  

    @DataProvider(name="CourseData")
    public Object[][] getCourseData() throws IOException {
        // File path for the Excel file
    	String path = System.getProperty("user.dir") + "\\testData\\TestDetails (2).xlsx";

        // Initialize ExcelUtility
        ExcelUtility xlutil = new ExcelUtility(path);

        // Fetch row and column count for "course" sheet
        int totalRows = xlutil.getRowCount("Course");
        int totalCols = xlutil.getCellCount("Course", 1);

        // Create a 2D array to store data
        String courseData[][] = new String[totalRows][totalCols];

        // Iterate through rows and columns to populate the array
        for (int i = 1; i <= totalRows; i++) {
            for (int j = 0; j < totalCols; j++) {
                courseData[i-1][j] = xlutil.getCellData("Course", i, j);
            }
        }

        // Close workbook after data extraction
        xlutil.closeWorkbook();

        // Return the 2D array
        return courseData;
    }
    
    @DataProvider(name="FormData")
    public Object[][] getFormData() throws IOException {
        // File path for the Excel file
    	String path = System.getProperty("user.dir") + "\\testData\\TestDetails (2).xlsx";

        // Initialize ExcelUtility
        ExcelUtility xlutil = new ExcelUtility(path);

        // Fetch row and column count for "FormDetails" sheet
        int totalRows = xlutil.getRowCount("FormDetails");
        int totalCols = xlutil.getCellCount("FormDetails", 1);

        // Create a 2D array to store data
        String formData[][] = new String[totalRows][totalCols];

        // Iterate through rows and columns to populate the array
        for (int i = 0; i < totalRows; i++) {
            for (int j = 0; j < totalCols; j++) {
            	formData[i][j] = xlutil.getCellData("FormDetails", i + 1, j);
            }
        }

        // Close workbook after data extraction
        xlutil.closeWorkbook();

        // Return the 2D array
        return formData;
    }
}
