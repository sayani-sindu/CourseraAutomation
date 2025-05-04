package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ReadyToTransformPage extends BasePage{
	
	JavascriptExecutor js;

	public ReadyToTransformPage(WebDriver driver) {
		super(driver);
		js = (JavascriptExecutor) driver;
		
	}
	
	@FindBy(xpath = "//a[text() = \"For Campus\"]")
	WebElement lnkForCampus;
	
	@FindBy(xpath = "//div[@class=\"css-3o18c4\"]")
	WebElement divForm;
	
	@FindBy(xpath = "//input[@id=\"FirstName\"]")
	WebElement txtFirstName;
	
	@FindBy(xpath = "//input[@id=\"LastName\"]")
	WebElement txtLastName;
	
	@FindBy(xpath = "//input[@id=\"Email\"]")
	WebElement txtEmail;
	
	@FindBy(xpath = "//input[@id=\"Phone\"]")
	WebElement txtPhoneNo;
	
	@FindBy(xpath = "//select[@id=\"Institution_Type__c\"]")
	WebElement selectInstitution;
	
	@FindBy(xpath = "//input[@id=\"Company\"]")
	WebElement txtCompany;
	
	@FindBy(xpath = "//select[@id=\"Title\"]")
	WebElement selectTitle;
	
	@FindBy(xpath = "//select[@id=\"Department\"]")
	WebElement selectDept;
	
	@FindBy(xpath = "//select[@id=\"What_the_lead_asked_for_on_the_website__c\"]")
	WebElement selectLead;
	
	@FindBy(xpath = "//textarea[@id=\"rentalField5\"]")
	WebElement txtNeeds;
	
	@FindBy(xpath= "//select[@id=\"Self_reported_employees_to_buy_for__c\"]")
	WebElement selectNumOfPeople;
	
	@FindBy(xpath = "//select[@id=\"Country\"]")
	WebElement selectCountry;
	
	@FindBy(xpath = "//select[@id=\"State\"]")
	WebElement selectState;
	
	@FindBy(xpath = "//button[@type=\"submit\"]")
	WebElement btnSubmit;
	
	@FindBy(xpath = "//div[@id=\"ValidMsgEmail\"]")
	WebElement errMailMsg;
	
	public void clickForCampus(){
		js.executeScript("arguments[0].scrollIntoView();", lnkForCampus);
		lnkForCampus.click();
	}
	
	public void goToForm() {
		js.executeScript("arguments[0].scrollIntoView();", divForm);
		
	}
	
	public void setFirstName(String firstName) {
		txtFirstName.sendKeys(firstName);
	}
	
	public void setLastName(String lastName) {
		txtLastName.sendKeys(lastName);
	}
	
	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void setPhoneNo(String phoneNo) {
		txtPhoneNo.sendKeys(phoneNo);
	}
	
	public void setInstitution(String Institution) {
		Select instOptions = new Select(selectInstitution);
		instOptions.selectByVisibleText(Institution);
	}
	
	public void setCompany(String company) {
		txtCompany.sendKeys(company);
	}
	
	public void setTitle(String title) {
		Select titleOptions = new Select(selectTitle);
		titleOptions.selectByVisibleText(title);
	}
	
	public void setDepartment(String department) {
		Select deptOptions = new Select(selectDept);
		deptOptions.selectByVisibleText(department);
	}
	
	public void setLeadAns(String ans) {
		Select leadOptions = new Select(selectLead);
		leadOptions.selectByVisibleText(ans);
	}
	
	public void setNeeds(String needs) {
		txtNeeds.sendKeys(needs);
	}
	
	public void setNoOfLearners(String num) {
		Select peopleOptions = new Select(selectNumOfPeople);
		peopleOptions.selectByVisibleText(num);
	}
	
	public void setCountry(String country) {
		Select countryOptions = new Select(selectCountry);
		countryOptions.selectByVisibleText(country);
	}
	
	public void setState(String state) {
		Select stateOptions = new Select(selectState);
		stateOptions.selectByVisibleText(state);
	}
	
	public void submitForm() {
		btnSubmit.click();
	}
	
	public String getErrorMsg() {
		return errMailMsg.getText();
	}
}
