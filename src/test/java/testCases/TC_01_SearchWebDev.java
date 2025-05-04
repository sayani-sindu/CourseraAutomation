package testCases;


import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import courseraApp.CourseSearch;
import testBase.BaseTest;
import utilities.DataProviders;
import utilities.ExcelForTestCases;

public class TC_01_SearchWebDev extends BaseTest {

    private CourseSearch webDev;
    ExcelForTestCases excelWrite = new ExcelForTestCases();

    @BeforeClass(groups = {"smoke", "regression"})
    public void openTest() throws FileNotFoundException, IOException {
    	try {
    		logger.info("Test case TC_01_SearchWebCourse started");
    		
    		webDev = new CourseSearch(driver);
    		excelWrite.writeExcel(1, 7, "Passed");
    	}
    	catch(Exception e) {
    		logger.info("Test case failed");
    		excelWrite.writeExcel(1, 7, "Failed");
    	}
    	
        
    }

    @Test(priority = 1, groups = {"smoke", "regression"}, dataProvider= "CourseData", dataProviderClass = DataProviders.class)
    public void searchWebDevCourse(String course1, String course2) {
    	try {
    		logger.info("**Course Search started**");
        	webDev.searchCourse(course1);
    	}
    	catch(Exception e) {
    		logger.info("* Test failed *");
    	}
    }

    @Test(priority = 2, groups = {"regression"})
    public void clickEnglishCheckBox() {
    	try {
    		logger.info("Checking the English Check box");
            webDev.englishCheckBox();
    	}
    	catch(Exception e) {
    		logger.info("*** Test failed ***");
    	}
    }

    @Test(priority = 3, groups = {"regression"})
    public void clickBeginnerCheckBox() {
    	try {
    		
    		logger.info("Checking the Beginner Check box");
    		webDev.beginnerCheckBox();
    	}
    	catch(Exception e) {
    		logger.info("*** Test failed ***");
    	}
    	//Assert.fail();
    }

    @Test(priority = 4, groups = {"regression"})
    public void checkCourseNames() throws InterruptedException {
    	try {
    		logger.info("Displaying course names");
            Thread.sleep(2000);
            webDev.listCourseNames();
    	}
    	
        catch(Exception e) {
    		logger.info("*** Test failed ***");
    	}
    }

    @Test(priority = 5, groups = {"regression"})
    public void checkCourseRatings() {
    	try {
    		logger.info("Displaying course Ratings");
            webDev.listRatings();
    	}
    	
        catch(Exception e) {
    		logger.info("*** Test failed ***");
    	}
    }

    @Test(priority = 6, groups = {"regression"})
    public void checkCourseDuration() {
    	try {
    		logger.info("Displaying course Duration");
            webDev.listDuration();
    	}
    	
        catch(Exception e) {
    		logger.info("*** Test failed ***");
    	}
    }
    
    @Test(priority = 7, groups = {"regression"})
    public void goToHome() {
    	try {
    		logger.info("Go back to Home page");
        	webDev.goToHomePage();
        	
    	}
    	
    	catch(Exception e) {
    		logger.info("* Test case TC_01_SearchWebCourse Failed *");
    	}
    	finally {
    		logger.info("* Test case TC_01_SearchWebCourse Passed *");
    	}
    }
    
    
}
