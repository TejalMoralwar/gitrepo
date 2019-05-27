package retailbanking.tc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import core.Utils;
//import core.Utils.*;

import retailbanking.po.PO_Login;
import retailbanking.po.Po_TransferFunds;

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
}