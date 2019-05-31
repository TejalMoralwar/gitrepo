package retailbanking.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import core.Utils;

public class PO_AccountActivity_ShowTrans {
	WebDriver driver;
	 //parameterised constructor
	public PO_AccountActivity_ShowTrans(WebDriver d)
	{
		this.driver=d;
	}
	
	//Elements
	@FindBy(how=How.LINK_TEXT, using="Account Activity")
	WebElement lnktxt_accactivity;
  
	@FindBy(how=How.ID, using="aa_accountId")
	WebElement list_account;
    
	//Methods
	
	public void ClickOnAccountActivity()
	{
		lnktxt_accactivity.click();
	}
	
	public void SetShowTransactions(String value) 
	{
		try {
		Select listacc=new Select(list_account);
		listacc.selectByValue(value);
		Utils.WriteLogs("pass","select value from account"+value);
		}catch(Exception e) {
			e.printStackTrace();
			Utils.WriteLogs("fail","unable to select value"+"Exception:"+e.toString());
	    }
     }
	 
	}
