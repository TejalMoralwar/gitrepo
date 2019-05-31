package retailbanking.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;


import core.Utils;

public class PO_Login {
	WebDriver driver;
	
	//Parameterized constructor
	public PO_Login(WebDriver d){
		this.driver=d;
	}
	
	//Elements
	
	//element for login text box
	@FindBy(how=How.ID, using="user_login")
	WebElement txt_bx_login;
	//element for password text box
	@FindBy(how=How.ID, using="user_password")
	WebElement txt_bx_password;
	//element for signin button
	@FindBy(how=How.NAME, using="submit")
	WebElement btn_signin;
	
	//methods
	
	public void SetUserName(String u)
	{
		try
		{
			txt_bx_login.sendKeys(u);
			Utils.WriteLogs("pass","username set with value:" +u);
		}
		catch(Exception e)
		{
			e.getStackTrace();
			Utils.WriteLogs("fail","invalid user name as:" +u +"Exception:"+e.toString());
		}
	}
	
	public void SetPassword(String p)
	{
		try
		{
			
			txt_bx_password.sendKeys(p);
			Utils.WriteLogs("info","password set with value:"+p);
		}
		catch(Exception e)
		{
			e.getStackTrace();
			Utils.WriteLogs("fail","invalid password:" +p +"Exception is" +e.toString());
		}
	}	
	public void ClickOnsSignIn()
	{
		try {
			btn_signin.click();
			Utils.WriteLogs("pass","clicked on signin button");
			}catch(Exception e){
				e.printStackTrace();
				Utils.WriteLogs("fail","unable to clicked on signin button" +"Exception:" +e.toString());
			}
	}
	
    
   public void LoginIntoApplication(String u, String p)
    {
    	try {
    	SetUserName(u);
    	SetPassword(p);
    	ClickOnsSignIn();
    	Utils.WriteLogs("pass","successfully login with username" +u +"password"+p);
    	//checkpoint
    	String expected="Zero - Account Summary";
     	String actual=driver.getTitle();
    	Assert.assertEquals(actual, expected);
    	Utils.WriteLogs("pass","login successfully");
    	}catch(Exception e) {
    		e.printStackTrace();
    		Utils.WriteLogs("fail","unable to login"+"Exception:"+e.toString());
    	}
    }	
    
  }
