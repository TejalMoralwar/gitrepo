package retailbanking.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import core.Utils;

public class PO_OnlineStatement {

	WebDriver driver;
	 //Parameterized constructor
	public PO_OnlineStatement(WebDriver d)
	{
		this.driver=d;
	}
	
	//Elements
	
	@FindBy(how=How.LINK_TEXT, using="Online Statements")
	WebElement lnktxt_onlinestatement;
  
	@FindBy(how=How.ID, using="os_accountId")
	WebElement list_account;
  
	
	 @FindBy(how=How.LINK_TEXT, using="2011") 
	 WebElement btn_year;
	 
	
	@FindBy(how=How.XPATH, using="//ul[@class='nav nav-pills']")
	WebElement list_yr;
	
	
	//methods
  
	public void SelAccount(String acc)
	{
		try {
		Select sel=new Select(list_account);
		sel.selectByValue(acc);
		Utils.WriteLogs("pass","Account selected as: "+acc);
		}catch(Exception e) 
		{
			e.printStackTrace();
			Utils.WriteLogs("fail","unable to select account"+"Exception:"+e.toString() );
		}
    }
	
	public void SelYear()
	{
		try {
			list_yr.sendKeys();
			Utils.WriteLogs("pass","year selected");
			}catch(Exception e) 
		    {
				e.printStackTrace();
				Utils.WriteLogs("fail","unable to select year"+"Exception:"+e.toString());
			}
	}
	
	public void kw_OnlineStatement(String acc)
	{
		
		lnktxt_onlinestatement.click();
		SelAccount(acc);
		SelYear();
		
	}
}
