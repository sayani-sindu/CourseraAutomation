package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CourseDetails extends BasePage{

	public CourseDetails(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(xpath = "//ul[@class=\"cds-9 css-5t8l4v cds-10\"]//li//div[@class=\"cds-ProductCard-content\"]//a/h3")
	List<WebElement> lstCourseNames;
	
	@FindBy(xpath = "//ul[@class=\"cds-9 css-5t8l4v cds-10\"]//li//div[@class=\"cds-RatingStat-sizeLabel css-1i7bybc\"]//div/span")
	List<WebElement> lstCourseRatings;
	

	
	
	@FindBy(xpath = "//div[@data-testid=\"product-card-cds\"]//div[@class=\"cds-ProductCard-footer\"]//div[@class=\"cds-CommonCard-metadata\"]/p")
	List<WebElement> lstCourseDuration;
	
	
	
	public List<WebElement> getListCourseNames(){
		return lstCourseNames;
	}
	
	public List<WebElement> getListCourseRatings(){
		return lstCourseRatings;
	}
	
	public List<WebElement> getListCourseDuration(){
		return lstCourseDuration;
	}

	public void goBackToHome(){
		driver.findElement(By.xpath("//a[@data-click-key=\"search.search.click.logo\"]")).click();
	}
			
		
	
}
