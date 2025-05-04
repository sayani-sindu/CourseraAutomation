package pageObjects;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LanguageAndLevels extends BasePage{

	JavascriptExecutor js;
	public LanguageAndLevels(WebDriver driver) {
		super(driver);
		js = (JavascriptExecutor) driver;
	}
	
	
	
	@FindBy(xpath = "//div[@data-testid=\"search-filter-group-Language\"]/div[2]/button")
	WebElement btnShowMoreLang;
	
	@FindBy(xpath = "//div[@data-testid=\"search-filter-group-Language\"]/div[1]/div[2]/div[1]/div//div")
	List<WebElement> lstLangCourseNum;
	
	@FindBy(xpath = "//div[@data-testid=\"search-filter-group-Level\"]//div[@class=\"css-5ji5n2\"]/div//div/span/span")
	List<WebElement> lstLevelElements;
	

	public List<WebElement> getListLangCourseNum() {
		
		btnShowMoreLang.click();
		return lstLangCourseNum;
	}
	
	public List<WebElement> getListLevelCourses(){
		return lstLevelElements;
	}


}
