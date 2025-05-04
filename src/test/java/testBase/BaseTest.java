package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


public class BaseTest {

    public WebDriver driver;
    public Logger logger;
    public Properties p;
	@Parameters({"browser", "os"})
	@BeforeClass(groups= {"smoke", "regression"})
    public void setUp(String browser, String os, ITestContext context) throws IOException {
	   String path = System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties";
	   FileReader file = new FileReader(path);
	   p = new Properties();
	   p.load(file);
	   logger=LogManager.getLogger(this.getClass());
	   if(p.getProperty("execution_env").equalsIgnoreCase("remote")) {
		   DesiredCapabilities capabilities=new DesiredCapabilities();
			
			//os
			if(os.equalsIgnoreCase("windows"))
			{
				capabilities.setPlatform(Platform.WIN11);
			}
			else if (os.equalsIgnoreCase("mac"))
			{
				capabilities.setPlatform(Platform.MAC);
			}
			else
			{
				System.out.println("No matching os");
				return;
			}
			
			//browser
			switch(browser.toLowerCase())
			{
			case "chrome": capabilities.setBrowserName("chrome"); break;
			case "edge": capabilities.setBrowserName("MicrosoftEdge"); break;
			default: System.out.println("No matching browser"); return;
			}
			
			driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
	   }
	   if(p.getProperty("execution_env").equalsIgnoreCase("local")) {
		   if (browser.equalsIgnoreCase("chrome")) {
	            driver = new ChromeDriver();
	        } else if (browser.equalsIgnoreCase("edge")) {
	            driver = new EdgeDriver();
	        } else if (browser.equalsIgnoreCase("firefox")) {
	            driver = new FirefoxDriver();
	        } else {
	            driver = null;
	        }
	   }
       
        if (driver != null) {
        	
        	
            driver.get(p.getProperty("url"));
            driver.manage().window().maximize();
            logger.info("*** Website Started ***");
            context.setAttribute("driver", driver);
            context.setAttribute("logger", logger);
        }
    }

   @AfterClass(groups= {"smoke", "regression"})
    public void tearDown() {
        driver.quit();
        logger.info("*** Website Closed and test ended ***");

    }
   public String captureScreen(String tname) throws IOException {


		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
		logger.info("** Screenshot is Taken **");
			
		return targetFilePath;

	}
}
