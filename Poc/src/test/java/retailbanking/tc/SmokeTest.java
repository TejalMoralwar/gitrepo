package retailbanking.tc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;

import core.Utils;
//import core.Utils.*;
import retailbanking.po.PO_AccountActivity_ShowTrans;
import retailbanking.po.PO_Login;
import retailbanking.po.PO_OnlineStatement;
import retailbanking.po.PO_PayBills;
import retailbanking.po.PO_PayBills_AddNewPayee;
import retailbanking.po.PO_PayBills_PurchaseForeignCurr;
import retailbanking.po.Po_TransferFunds;
@Listeners(ExtentITestListenerClassAdapter.class)
public class SmokeTest {
	WebDriver driver;
  @Parameters({"browser","url"})
  @Test
  public void t_01_login(String browsertype, String url) {
	  try {
		  WebDriver driver=Utils.invokebrowser(browsertype,url);
		  PO_Login login=PageFactory.initElements(driver, PO_Login.class);
		 login.LoginIntoApplication("username","password");
		  Utils.WriteLogs("pass","login successfully");
		  }catch(Exception e)
	      {
			e.printStackTrace();
			Utils.WriteLogs("fail","login unsuccessfully");
	      }
 }
  @Parameters({"browser","url"})
  @Test
  public void t_02_transferfunds(String browsertype, String url)
  {
	  try {
		  WebDriver driver=Utils.invokebrowser(browsertype,url);
		  PO_Login login=PageFactory.initElements(driver, PO_Login.class);
		  login.LoginIntoApplication("username","password");
		  
	  //click on transfer funds
	  Po_TransferFunds transfer=PageFactory.initElements(driver, Po_TransferFunds.class);
	  transfer.clickOnTransferFunds();
	  String from="2";
	  String to="1";
	  String amount="20";
	  String descp="test";
	  transfer.kw_FillTransferFunds(from, to, amount, descp);
	  Utils.WriteLogs("pass","test case completed");
  }catch(Exception e) {
	  e.printStackTrace();
	  Utils.WriteLogs("fail","test case failed");
  }
}
  
  @Parameters({"browser","url"})
  @Test
  public void t_03_paybills(String browsertype, String url)
  {
	  try {
		  WebDriver driver=Utils.invokebrowser(browsertype,url);
		  PO_Login login=PageFactory.initElements(driver, PO_Login.class);
		  login.LoginIntoApplication("username","password");
		  
		  PO_PayBills paybills=PageFactory.initElements(driver, PO_PayBills.class);
		  paybills.clickOnPaybills();
		  String payee="apple";
		  String account="2";
		  String amount="20";
		  String desc="test";
		  paybills.kw_FillPayBills(payee, account, amount, desc);
		  Utils.WriteLogs("pass","test case completed");
	  }catch(Exception e)
	  {
		  e.printStackTrace();
		  Utils.WriteLogs("fail","test case failed");
		  
	  }
  }
  
  @Parameters({"browser","url"})
  @Test
  public void t_04_addNewPayee(String browsertype, String url) {
	  try {
		  WebDriver driver=Utils.invokebrowser(browsertype,url);
		  PO_Login login=PageFactory.initElements(driver, PO_Login.class);
		  login.LoginIntoApplication("username","password");
		 
		  PO_PayBills paybills=PageFactory.initElements(driver, PO_PayBills.class);
		  paybills.clickOnPaybills();
		  
		  PO_PayBills_AddNewPayee addnewpayee=PageFactory.initElements(driver, PO_PayBills_AddNewPayee.class);
		  String name="pooja";
		  String add="pune";
		  String acc="savings";
		  String details="employee";
		  addnewpayee.kw_AddNewPayee(name, add, acc, details);
		  Utils.WriteLogs("pass","test case completed");
		  }catch(Exception e)
	      {
			  e.printStackTrace();
			  Utils.WriteLogs("fail","test case failed");
	      }
  }
  
  
  @Parameters({"browser","url"})
  @Test
  public void t_05_purchaseForeignCurrency(String browsertype, String url) {
	  try {
		  WebDriver driver=Utils.invokebrowser(browsertype,url);
		  PO_Login login=PageFactory.initElements(driver, PO_Login.class);
		  login.LoginIntoApplication("username","password");
		 
		  PO_PayBills paybills=PageFactory.initElements(driver, PO_PayBills.class);
		  paybills.clickOnPaybills();
		  
		  PO_PayBills_PurchaseForeignCurr purchforcurr=PageFactory.initElements(driver, PO_PayBills_PurchaseForeignCurr.class);
		  String curr="SGD";
		  String amt="25";
		  purchforcurr.kw_PurchaseForeignCurrency(curr, amt);

		  Utils.WriteLogs("pass","test case completed");
		  }catch(Exception e)
	      {
			  e.printStackTrace();
			  Utils.WriteLogs("fail","test case failed");
	      }
    }
  
  @Parameters({"browser","url"})
  @Test
  public void t_06_purchaseForeignCurrency(String browsertype, String url) {
	  try {
		  WebDriver driver=Utils.invokebrowser(browsertype,url);
		  PO_Login login=PageFactory.initElements(driver, PO_Login.class);
		  login.LoginIntoApplication("username","password");
		  
		  PO_AccountActivity_ShowTrans showtrans=PageFactory.initElements(driver, PO_AccountActivity_ShowTrans.class);
		  
		  String value="3";
		  showtrans.ClickOnAccountActivity();
		  showtrans.SetShowTransactions(value);

		  Utils.WriteLogs("pass","test case completed");
		  }catch(Exception e)
	      {
			  e.printStackTrace();
			  Utils.WriteLogs("fail","test case failed");
	      }
  }

  @Parameters({"browser","url"})
  @Test
  public void t_07_OnlineStatement(String browsertype, String url) {
	  try {
		  WebDriver driver=Utils.invokebrowser(browsertype,url);
		  PO_Login login=PageFactory.initElements(driver, PO_Login.class);
		  login.LoginIntoApplication("username","password");
		  
		  PO_OnlineStatement onlinestat=PageFactory.initElements(driver, PO_OnlineStatement.class);
		  
		  String acc="3";
		//  String yr="2011";
		  onlinestat.kw_OnlineStatement(acc);

		  Utils.WriteLogs("pass","test case completed");
		  }catch(Exception e)
	      {
			  e.printStackTrace();
			  Utils.WriteLogs("fail","test case failed");
	      }
  }


}