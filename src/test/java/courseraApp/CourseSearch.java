package courseraApp;

import java.util.List;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pageObjects.CourseDetails;
import pageObjects.HomePage;
import pageObjects.WebDevCoursePage;

public class CourseSearch {

	WebDriver driver;
	WebDevCoursePage coursePage;
	CourseDetails details;
	HomePage homePage;
	public CourseSearch(WebDriver driver) {
		this.driver = driver;
		coursePage = new WebDevCoursePage(driver);
		details = new CourseDetails(driver);
		homePage = new HomePage(driver);
     }
	
	
	public void searchCourse(String course){
		homePage.setSearchText(course);
		homePage.clickSearchBtn();
		
	}
	public void englishCheckBox(){
		
		coursePage.clickEnglishCheckBox();
	}
	public void beginnerCheckBox(){
	
		coursePage.clickBeginnerCheckBox();
		
	}
	 

	public void listCourseNames() {
		List<WebElement> courseNames = details.getListCourseNames();
		for(WebElement courseName: courseNames) {
			System.out.println(courseName.getText());
		}
	}
	
	public void listRatings() {
		List<WebElement> ratings = details.getListCourseRatings();
		for(WebElement rating: ratings) {
			System.out.println(rating.getText());
		}
	}
	
	public void listDuration() {
		List<WebElement> durations = details.getListCourseDuration();
		for(WebElement duration: durations) {
			System.out.println(duration.getText());
		}
	}
	
	public void goToHomePage() {
		details.goBackToHome();
	}
	
}
	 
