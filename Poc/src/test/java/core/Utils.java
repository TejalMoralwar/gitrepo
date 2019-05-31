package core;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

import com.aventstack.extentreports.service.ExtentTestManager;

public class Utils {
	
  public static WebDriver invokebrowser(String browsertype, String url)
  {
	try {
		WebDriver driver=null;
		//invoke browser
	    if(browsertype.equalsIgnoreCase("chrome"))
	    {
    	System.setProperty("webdriver.chrome.driver", "F:\\automation\\chromedriver.exe");
		driver=new ChromeDriver();
	    }else if(browsertype.equalsIgnoreCase("firefox"))
	    {
	    	System.setProperty("webdriver.chrome.driver", "F:\\automation\\chromedriver.exe");

	    }
		driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);
		Utils.WriteLogs("pass","chrome browser invoked with url as:"+url);
		return driver;
	}catch(Exception e)
	{
		Utils.WriteLogs("fail","unable to invoke chrome browser");
		return null;
	}
  }
	public static void WriteLogs(String logtype,String msg)
	{
		Reporter.log(logtype+"-"+msg+"<br>",true);
		switch(logtype.toLowerCase()) {
		case "pass":
		      ExtentTestManager.getTest().pass(msg);
		      break;
		case "fail":
		      ExtentTestManager.getTest().fail(msg);
		      break;
		case "info":
		      ExtentTestManager.getTest().info(msg);
		      break;
		     
		}
	}
  }


