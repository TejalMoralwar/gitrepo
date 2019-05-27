package retailbanking.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import core.Utils;

public class Po_TransferFunds {
	WebDriver driver;
	public Po_TransferFunds(WebDriver d)
	{
		this.driver=d;
	}
	
	//Elements
	@FindBy(how=How.LINK_TEXT, using="Transfer Funds")
	WebElement lnk_transferfnd;
	
	@FindBy(how=How.ID, using="tf_fromAccountId")
	WebElement list_fromaccount;
	
	@FindBy(how=How.ID, using="tf_toAccountId")
	WebElement list_toaccount;
	
	@FindBy(how=How.ID, using="tf_amount")
	WebElement txtbox_amount;
	
	@FindBy(how=How.ID, using="tf_description")
	WebElement txtbox_description;
	
	@FindBy(how=How.ID, using="btn_submit")
	WebElement btn_continue;
	
	@FindBy(how=How.ID, using="btn_submit")
	WebElement btn_submit;
	
	@FindBy(how=How.XPATH, using="//h2[@class='board-header']")
	WebElement board_header;
	

	
	//Methods
	public void clickOnTransferFunds()
	{
		lnk_transferfnd.click();
	}
	public void SetFromAccount(String value)
	{
		try {
			Select listfromaccount=new Select(list_fromaccount);
			listfromaccount.selectByValue(value);
			Utils.WriteLogs("pass","set value from from_account as"+value);
		}catch(Exception e)
		{
			e.printStackTrace();
			Utils.WriteLogs("fail","unable to set value as:"+value +"Exception:"+e.toString());
		}
	}
	
	public void SetToAccount(String value)
	{
		try {
			Select listtoaccount=new Select(list_toaccount);
			listtoaccount.selectByValue(value);
			Utils.WriteLogs("pass","set value from to_account as"+value);
		}catch(Exception e)
		{
			e.printStackTrace();
			Utils.WriteLogs("fail","unable to set value as:"+value +"Exception:"+e.toString());
		}
	}
	
	public void Setamount(String amt)
	{
		try {
			txtbox_amount.sendKeys(amt);
			Utils.WriteLogs("pass","entered amount as:"+amt);
		}catch(Exception e)
		{
			e.printStackTrace();
			Utils.WriteLogs("fail","unable to enter amount as:"+amt +"Exception:"+e.toString());
		}
	}
	
	public void SetDescription(String des)
	{
		try {
			txtbox_description.sendKeys(des);
			Utils.WriteLogs("pass","entered description as:"+des);
		}catch(Exception e)
		{
			e.printStackTrace();
			Utils.WriteLogs("fail","unable to enter description as:"+des +"Exception:"+e.toString());
		}
	}
	
	public void SetBtnContinue()
	{
		try {
			btn_continue.click();
			Utils.WriteLogs("pass","clicked on continue");
		}catch(Exception e)
		{
			e.printStackTrace();
			Utils.WriteLogs("fail","unable to clicked on continue"+"Exception:"+e.toString());
		}
	}
	
	public void SetBtnSubmit()
	{
		try {
			btn_submit.click();
			Utils.WriteLogs("pass","clicked on submit");
		}catch(Exception e)
		{
			e.printStackTrace();
			Utils.WriteLogs("fail","unable to clicked on submit"+"Exception:"+e.toString());
		}
	}
	
	public void kw_FillTransferFunds(String from, String to, String amount, String descp)
	{
		try {
			SetFromAccount(from);
			SetToAccount(to);
			Setamount(amount);
			SetDescription(descp);
			SetBtnContinue();
			
			//validation
			Assert.assertEquals(btn_submit.isDisplayed(), true);
			Assert.assertEquals(list_toaccount.isEnabled(), false);
			Utils.WriteLogs("pass","page navigated to transfer funds verify");
			
			//click on submit
			btn_submit.click();
			Utils.WriteLogs("pass","page navigated to transfer funds verify page");
			
			//checkpoint
			String expected=board_header.getText();
			String actual="Transfer Money & Make Payments - Confirm";
		    Assert.assertEquals(actual, expected);
		}catch(Exception e)
		{
			e.printStackTrace();
			Utils.WriteLogs("fail","unable to fill transfer funds"+"exception:"+e.toString());
		}
		
	}

	
}
