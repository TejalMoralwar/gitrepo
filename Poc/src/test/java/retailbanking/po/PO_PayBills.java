package retailbanking.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import core.Utils;

public class PO_PayBills {
	WebDriver driver;
	
	public PO_PayBills(WebDriver d)
	{
		this.driver=d;
	}
	
	//elements for "pay saved payee"
	
	@FindBy(how=How.LINK_TEXT, using="Pay Bills")
	WebElement lnktxt_paybills;

	@FindBy(how=How.ID, using="sp_payee")
	WebElement list_payee;

	@FindBy(how=How.ID, using="sp_account")
	WebElement list_account;

	@FindBy(how=How.ID, using="sp_amount")
	WebElement txtbox_amount;

	@FindBy(how=How.ID, using="sp_date")
	WebElement date;
	
    @FindBy(how=How.XPATH, using="//span[@class='ui-datepicker-month']")
	WebElement currmonth;
  
    @FindBy(how=How.XPATH, using="//a[contains(text(),'10')]")
   	WebElement seldate;
     
	@FindBy(how=How.ID, using="sp_description")
	WebElement txtbox_desc;
	
    @FindBy(how=How.ID, using="pay_saved_payees")
	WebElement button_pay;
  
    @FindBy(how=How.XPATH, using="//div[@id='alert_content']")
   	WebElement alert;
    
    
    //methods for "pay saved payee"
    
    public void clickOnPaybills()
    {
    	try {
    		lnktxt_paybills.click();
    		Utils.WriteLogs("pass","clicked on paybills");
    	}catch(Exception e) {
    		e.printStackTrace();
    		Utils.WriteLogs("fail","unable to clicked on paybills");
    	}
    		
    }
    public void SetPayee(String value)
    {
    	try {
    	Select payee=new Select(list_payee);
    	payee.selectByValue(value);
    	Utils.WriteLogs("pass","select payee from list as:"+value);
    	}catch(Exception e) {
    		e.printStackTrace();
    		Utils.WriteLogs("fail","unable to select payee from list"+"Exception:"+e.toString());
    	}
    	
    }
	
    public void SetAccount(String value)
    {
    	try {
    	Select account=new Select(list_account);
    	account.selectByValue(value);
    	Utils.WriteLogs("pass","select account from list as:"+value);
    	}catch(Exception e) {
    		e.printStackTrace();
    		Utils.WriteLogs("fail","unable to select account from list"+"Exception:"+e.toString());
    	}
    	
    }
    
    public void SetAmount(String amt)
    {
    	try {
    	txtbox_amount.sendKeys(amt);
    	Utils.WriteLogs("pass","sent amount as:"+amt);
    	}catch(Exception e) {
    		e.printStackTrace();
    		Utils.WriteLogs("fail","unable to send amount"+"Exception:"+e.toString());
    	}
    	

    }
    
    public void SetDate() throws InterruptedException 
    {
    	try {
    	date.click();
    	seldate.click();
    	Utils.WriteLogs("pass","select date");
    	}catch(Exception e) {
    		e.printStackTrace();
    		Utils.WriteLogs("fail","unable to select date"+"Exception:"+e.toString());
    	}
    	
   
		/*
		 * String expmon="May 2019"; String currmon=currmonth.getText();
		 * if(expmon.equals(currmon)) { System.out.println("month is already selected");
		 * } else { for(int i=0; i<12;i++) { date.click(); Thread.sleep(3000);
		 * currmon=currmonth.getText(); if(expmon.equals(currmon)) {
		 * System.out.println("month selected"); break; } }
		 * 
		 * }
		 */
    	
     
    }
    
    public void SetDescription(String value)
    {
    	try {
    	txtbox_desc.sendKeys(value);
    	Utils.WriteLogs("pass","sent description as:"+value);
    	}catch(Exception e) {
    		e.printStackTrace();
    		Utils.WriteLogs("fail","unable to sent description"+"Exception:"+e.toString());
    	}
    	
    }
    
    public void ClickOnPay()
    {
    	try {
    	button_pay.click();
    	Utils.WriteLogs("pass","pay button clicked successfully");
    	}catch(Exception e) {
    		e.printStackTrace();
    		Utils.WriteLogs("fail","unable to clicked pay button"+"Exception:"+e.toString());
    	}
    	
    	
    }
    
    public void kw_FillPayBills(String payee, String account, String amount, String desc) throws InterruptedException
    {
    	try {
    	SetPayee(payee);
    	SetAccount(account);
    	SetAmount(amount);
    	SetDate();
    	SetDescription(desc);
    	ClickOnPay();
    	
    	//checkpoint
    	String actual="The payment was successfully submitted.";
    	String expected=alert.getText();
    	Assert.assertEquals(actual, expected);
    	Utils.WriteLogs("pass","fill pay bills successfully");
    	}catch(Exception e)
    	{
    		e.printStackTrace();
    		Utils.WriteLogs("fail","unable to fill pay bills"+"Exception:"+e.toString());
    	
    	}
    }
}
