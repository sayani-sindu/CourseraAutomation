package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

	JavascriptExecutor js;
	public HomePage(WebDriver driver) {
		super(driver);
		js = (JavascriptExecutor) driver;
	}
	@FindBy(xpath = "//input[\"search-autocomplete-input\"]")
	WebElement txtSearch;
	

	
	@FindBy(xpath = "//button[@aria-label=\"Submit Search\" and @class=\"nostyle search-button\"]//div")
	WebElement btnSearch;
	
	public void setSearchText(String course) {
		txtSearch.sendKeys(course);
	}
	
	
	
	public void clickSearchBtn() {
		btnSearch.click();
	}
	
}

