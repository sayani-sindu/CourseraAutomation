package courseraApp;


import java.time.Duration;


import org.openqa.selenium.WebDriver;

import pageObjects.ReadyToTransformPage;


public class ReadyToTransform {
	
	WebDriver driver;
	
	ReadyToTransformPage transform;
	
	
	public ReadyToTransform(WebDriver driver) {
		this.driver = driver;
		transform = new ReadyToTransformPage(driver);
	}
	
	public void goToForCampus() {
		transform.clickForCampus();
	}
	
	public void fillDetails(String[] data) throws InterruptedException {
		transform.setFirstName(data[0]);
		transform.setLastName(data[1]);
		transform.setEmail(data[2]);
		transform.setPhoneNo(data[3]);
		transform.setInstitution(data[4]);
		transform.setCompany(data[5]);
		transform.setTitle(data[6]);
		transform.setDepartment(data[7]);
		transform.setLeadAns(data[8]);
		transform.setNeeds(data[9]);
		transform.setNoOfLearners(data[10]);
		transform.setCountry(data[11]);
		transform.setState(data[12]);
		transform.submitForm();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		System.out.println(transform.getErrorMsg());
		
		
		
	}
	
	
	
	

}
