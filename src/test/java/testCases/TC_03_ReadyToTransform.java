package testCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import courseraApp.ReadyToTransform;
import testBase.BaseTest;
import utilities.DataProviders;

public class TC_03_ReadyToTransform extends BaseTest {

    ReadyToTransform form;

    @BeforeClass(groups = {"regression"})
    public void openTest() {
        try {
        	logger.info("*** Test TC_03_ReadyToTransform started ***");
            form = new ReadyToTransform(driver);
        } catch (Exception e) {
            
        }
    }

    @Test(priority = 1, groups = {"regression", "ui"})
    public void goToForCampus() {
        try {
        	logger.info("Going to On Campus page");
            form.goToForCampus();
        } catch (Exception e) {
        	logger.info("* Test failed *");
        }
    }

    @Test(priority = 2, groups = {"regression", "form"}, dataProvider= "FormData", dataProviderClass = DataProviders.class)
    public void fillForm(String[] data) throws InterruptedException {
        try {
        	logger.info("Going to form, filling details, displaying error message");
            form.fillDetails(data);
        } catch (Exception e) {
        	logger.info("*** Test TC_03_ReadyToTransform failed ***");
        }
        finally {
        	logger.info("*** Test TC_03_ReadyToTransform passed ***");
        }
    }
}
