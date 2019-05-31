package retailbanking.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import core.Utils;

public class PO_AccountActivity_FindTrans {
	WebDriver driver;
	 //parameterised constructor
	public PO_AccountActivity_FindTrans(WebDriver d)
	{
		this.driver=d;
	}
	
	//Elements
	
	@FindBy(how=How.LINK_TEXT, using="Account Activity")
	WebElement lnktxt_accactivity;
   
	//for find transactions
		@FindBy(how=How.LINK_TEXT,using="Find Transactions")
		WebElement lnktxt_findtrans;

		@FindBy(how=How.ID, using="aa_description")
		WebElement txtbox_description;
		
		@FindBy(how=How.ID, using="aa_fromDate")
		WebElement date_from ;
		
	    @FindBy(how=How.XPATH, using="//span[@class='ui-datepicker-month']")
	    WebElement currmonth_from;
		
		@FindBy(how=How.ID, using="aa_toDate")
		WebElement date_to;
		
		@FindBy(how=How.XPATH, using="//span[@class='ui-datepicker-month']")
		WebElement currmon_to;
		@FindBy(how=How.ID, using="aa_fromAmount")
		WebElement fromamount ;
		
		@FindBy(how=How.ID, using="aa_toAmount")
		WebElement toamount;
		
		@FindBy(how=How.ID, using="aa_type")
		WebElement list_type;
		
		//methods for find transactions
		public void findTransaction()
		{
			lnktxt_findtrans.click();
		}
		public void SetDescription(String txt)
		{
			try {
			txtbox_description.sendKeys(txt);	
			Utils.WriteLogs("pass","set value in description as:"+txt);
		    }catch(Exception e)
			{
		    	e.printStackTrace();
		    	Utils.WriteLogs("fail","unable to set in description box"+"Exception:"+e.toString());
			}
		}
		
		public void SelectDateFrom() throws InterruptedException
		{
			date_from.click();
			String expmon="May 2019";
			String currmon=currmonth_from.getText();
			if(expmon.equals(currmon))
			{
				System.out.println("month is already selected");
			}
			else
			{
				for(int i=0; i<12;i++)
				{
					date_from.click();
					Thread.sleep(3000);
					currmon=currmonth_from.getText();
					if(expmon.equals(currmon))
					{
						System.out.println("month selected");
						break;
					}
				}
			
		    }
	    }
		public void SelectDateTo() throws InterruptedException
		{
			date_from.click();
			String expmon="May 2019";
			String currmon=currmon_to.getText();
			if(expmon.equals(currmon))
			{
				System.out.println("month is already selected");
			}
			else
			{
				for(int i=0; i<12;i++)
				{
					date_from.click();
					Thread.sleep(3000);
					currmon=currmon_to.getText();
					if(expmon.equals(currmon))
					{
						System.out.println("month selected");
						break;
					}
				}
			
		     }
	     }
		
		


}
