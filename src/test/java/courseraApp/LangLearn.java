package courseraApp;

import java.util.List;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pageObjects.HomePage;
import pageObjects.LanguageAndLevels;


public class LangLearn {

	WebDriver driver;
	LanguageAndLevels levels;
	HomePage homePage;
	
	public LangLearn(WebDriver driver) {
		this.driver = driver;
		
		levels = new LanguageAndLevels(driver);
		homePage = new HomePage(driver);
	}
	
	
	public void searchCourse(String course){
	
		homePage.setSearchText(course);
		homePage.clickSearchBtn();
		
	}
	
	 
	
	public void listLang() {	
		
		
		List<WebElement> languages = levels.getListLangCourseNum();
		for(WebElement ele:languages) {
			System.out.println(ele.getText());
		}
	}
	public void listLevels() {	
		
		List<WebElement> levelC = levels.getListLevelCourses();
		for(WebElement ele:levelC) {
			System.out.println(ele.getText());
		}
		
		
	}
	
}
