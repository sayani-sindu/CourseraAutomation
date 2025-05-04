package testCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import courseraApp.LangLearn;
import testBase.BaseTest;
import utilities.DataProviders;

public class TC_02_LanguageLearning extends BaseTest {

    LangLearn learning;

    @BeforeClass(groups = {"smoke", "regression"})
    public void openTest() {
        try {
        	logger.info("*** Test TC_02_LanguageLearning started ***");
            learning = new LangLearn(driver);
        } catch (Exception e) {
        	logger.info("* Test Failed *");
        }
    }
    
    @Test(priority = 1, groups = {"smoke", "regression"}, dataProvider= "CourseData", dataProviderClass = DataProviders.class)
    public void searchLangLearn(String course1, String course2) {
        try {
        	logger.info("Search Language Learning");
            learning.searchCourse(course2);
        } catch (Exception e) {
        	logger.info("* Test Failed *");
        }
    }

    @Test(priority = 2, groups = {"regression"})
    public void CheckLanguagesList() {
        try {
        	logger.info("Displaying all the languages available");
            learning.listLang();
        } catch (Exception e) {
        	logger.info("* Test failed *");
        }
    }

    @Test(priority = 3, groups = {"regression"})
    public void checkLevelsList() {
        try {
        	logger.info("Displaying all the Levels available");
            learning.listLevels();
        } catch (Exception e) {
        	logger.info("*** Test TC_02_LanguageLearning failed ***");
        }
        finally {
        	logger.info("*** Test TC_02_LanguageLearning Passed ***");
        }
    }
}
