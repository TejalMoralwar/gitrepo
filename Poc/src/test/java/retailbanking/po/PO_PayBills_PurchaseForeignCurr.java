package retailbanking.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import core.Utils;

public class PO_PayBills_PurchaseForeignCurr {
	WebDriver driver;
	public PO_PayBills_PurchaseForeignCurr(WebDriver d)
	{
		this.driver=d;
	}
	
	//Elements
	@FindBy(how=How.LINK_TEXT, using="Purchase Foreign Currency")
	WebElement lnktxt_purchaseforeigncurr;

	@FindBy(how=How.ID, using="pc_currency")
	WebElement list_curr;

	@FindBy(how=How.ID, using="pc_amount")
	WebElement txtbox_amount;

	@FindBy(how=How.ID, using="pc_inDollars_false")
	WebElement radiobtn_selcurr;

	@FindBy(how=How.ID, using="pc_calculate_costs")
	WebElement btn_calcosts;

	@FindBy(how=How.ID, using="purchase_cash")
	WebElement btn_purchase;
	
	@FindBy(how=How.ID, using="alert_content")
	WebElement alert;
	

	//Methods
	
	public void SelCurrency(String curr)
	{
		try {
		Select sel=new Select(list_curr);
		sel.selectByValue(curr);
		Utils.WriteLogs("pass","selected currency is: "+curr);
		}catch(Exception e) 
		{
			e.printStackTrace();
			Utils.WriteLogs("fail","unable select currency"+"Exception:"+e.toString() );
		}
    }
	public void SetAmount(String amt)
	{
		try {
	    txtbox_amount.sendKeys(amt);
		Utils.WriteLogs("pass","set amount as: "+amt);
		}catch(Exception e) 
		{
			e.printStackTrace();
			Utils.WriteLogs("fail","unable to set amount"+"Exception:"+e.toString() );
		}
    }
	public void SelRadiobtn_curr()
	{
		try {
		radiobtn_selcurr.click();
		Utils.WriteLogs("pass","select currency radio button");
		}catch(Exception e) 
		{
			e.printStackTrace();
            Utils.WriteLogs("fail","unable to select radio button"+"Exception:"+e.toString() );
		}
    }

	public void ClickOnCalCosts()
	{
		try {
		btn_calcosts.click();
		Utils.WriteLogs("pass","calculate costs button clicked successfully");
		}catch(Exception e) 
		{
			e.printStackTrace();
            Utils.WriteLogs("fail","unable to clicked on calculate costs button"+"Exception:"+e.toString() );
		}
    }

	public void ClickOnPurchase()
	{
		try {
		btn_purchase.click();
		Utils.WriteLogs("pass","purchase button clicked successfully");
		}catch(Exception e) 
		{
			e.printStackTrace();
			Utils.WriteLogs("fail","unable to clicked on purchase button"+"Exception:"+e.toString() );
		}
    }
	
	public void kw_PurchaseForeignCurrency(String curr, String amt)
	{
		try {
		lnktxt_purchaseforeigncurr.click();
		SelCurrency(curr);
		SetAmount(amt);
		SelRadiobtn_curr();
		ClickOnCalCosts();
		ClickOnPurchase();
		
		//checkpoint
		String expected=alert.getText();
		String actual="Foreign currency cash was successfully purchased.";
		Assert.assertEquals(actual, expected);
		Utils.WriteLogs("pass","currency purchased successfully");
		}catch(Exception e) 
		{
			e.printStackTrace();
            Utils.WriteLogs("fail","unable to purchase currency"+"Exception:"+e.toString() );
		}
	}

}
