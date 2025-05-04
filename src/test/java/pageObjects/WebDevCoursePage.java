package pageObjects;



import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebDevCoursePage extends BasePage{

	JavascriptExecutor js;
	public WebDevCoursePage(WebDriver driver) {
		super(driver);
		js = (JavascriptExecutor) driver;
	}
	
	@FindBy(xpath = "//input[@id=\"cds-react-aria-:R4darconaj6kqikta:\"]")
	WebElement btnEnglish;
	
	@FindBy(xpath = "//input[@id=\"cds-react-aria-:R4darcp7aj6kqikta:\"]")
	WebElement btnBeginner;
	
	
	
	
	
	
	public void clickEnglishCheckBox(){
		js.executeScript("arguments[0].scrollIntoView();", btnEnglish);
		btnEnglish.click();
		
	}
	
	public void clickBeginnerCheckBox(){
		js.executeScript("arguments[0].scrollIntoView();", btnBeginner);
		btnBeginner.click();
		
	}

	
	
	
	
}
