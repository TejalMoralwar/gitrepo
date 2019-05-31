package retailbanking.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import core.Utils;

public class PO_PayBills_AddNewPayee {
	WebDriver driver;
	
	public PO_PayBills_AddNewPayee(WebDriver d)
	{
		this.driver=d;
	}
	
	//Elements
	
	@FindBy(how=How.LINK_TEXT, using="Add New Payee")
	WebElement lnktxt_addnewpayee;

	@FindBy(how=How.ID, using="np_new_payee_name")
	WebElement txtbox_payeename;

	@FindBy(how=How.ID, using="np_new_payee_address")
	WebElement txtbox_payeeaddress;

	@FindBy(how=How.ID, using="np_new_payee_account")
	WebElement txtbox_account;

	@FindBy(how=How.ID, using="np_new_payee_details")
	WebElement txtbox_payeedetails;
	
	@FindBy(how=How.ID, using="add_new_payee")
	WebElement btn_add;
	
	@FindBy(how=How.ID, using="alert_content")
	WebElement alert;
	
	
	
	//methods
	
	public void SetPayeeName(String name)
	{
		try {
			txtbox_payeename.sendKeys(name);
		Utils.WriteLogs("pass","set payee name as:"+name);
		}catch(Exception e)
		{
			e.printStackTrace();
			Utils.WriteLogs("fail","unable to set payee name"+"Exception:"+e.toString());
		}
	}
	
	public void SetPayeeAddress(String add)
	{
		try {
		txtbox_payeeaddress.sendKeys(add);
		Utils.WriteLogs("pass","set payee address as:"+add);
		}catch(Exception e)
		{
			e.printStackTrace();
			Utils.WriteLogs("fail","unable to set payee address"+"Exception:"+e.toString());
		}
	 }
	
	public void SetAccount(String acc)
	{
		try {
			txtbox_account.sendKeys(acc);
			Utils.WriteLogs("pass","set account as:"+acc);
		    }catch(Exception e)
			{
				e.printStackTrace();
				Utils.WriteLogs("fail","unable to set account"+"Exception:"+e.toString());
			}

	}
	public void SetPayeeDetails(String details)
	{
		try {
			txtbox_payeedetails.sendKeys(details);
			Utils.WriteLogs("pass","set payee details as:"+details);
		    }catch(Exception e)
			{
				e.printStackTrace();
				Utils.WriteLogs("fail","unable to set payee details"+"Exception:"+e.toString());
			}
     }
	
	public void ClickOnAdd()
	{
		try {
			btn_add.click();
			Utils.WriteLogs("pass","add button clicked");
			}catch(Exception e)
			{
				e.printStackTrace();
				Utils.WriteLogs("fail","unable to clicked on add button"+"Exception:"+e.toString());
			}
	}
	
	public void kw_AddNewPayee(String name, String add, String acc, String details )
	{
		try {
			lnktxt_addnewpayee.click();
			SetPayeeName(name);
			SetPayeeAddress(add);
			SetAccount(acc);
			SetPayeeDetails(details);
			ClickOnAdd();
			
			//checkpoint
			String expected=alert.getText();
			String actual="The new payee "+name +" was successfully created.";
		    Assert.assertEquals(actual, expected);
			
			Utils.WriteLogs("pass","add new payee successfully");
			}catch(Exception e)
			{
				e.printStackTrace();
				Utils.WriteLogs("fail","unable to add new payee"+"Exception:"+e.toString());
			}
	}
	
}
