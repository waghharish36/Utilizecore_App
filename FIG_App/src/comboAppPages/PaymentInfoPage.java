package comboAppPages;

import lib.ComboAppData;
import lib.CommonClass;
import net.bytebuddy.asm.Advice.Enter;

import java.sql.Driver;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

//import org.apache.bcel.generic.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import com.gargoylesoftware.htmlunit.javascript.host.Set;

//import javafx.scene.Parent;

public class PaymentInfoPage extends ComboAppBasePage
{
	public PaymentInfoPage() 
	{
		super();
	}
	
	
	@FindBy(xpath="//*[@id='creditCardNumber']")
	private WebElement weCardno;

	@FindBy(xpath="//*[@id='expiryMonthCreditCard']")
  	 private WebElement wemonthcreditcard;
	
	
	@FindBy(xpath="//*[@id='expiryYearCreditCard']")
	private WebElement weyearcreditcard;
	
	@FindBy(xpath="//*[@id='CVVNumberCreditCard']")	
	private WebElement weCvvnocreditcard;
	
	
	
	@FindBy(xpath="//*[@id='SubmitBillShip']/span")	
	private WebElement wesubmitb;
	
	///html/body/form/table/tbody/tr[9]/td/input
	//input[@value="Generate Schedules"]
    
	
	@FindBy(xpath="//input[@value='Return To the Merchant Site']")	
	private WebElement weReturnMarButn;
		
	
	@FindBy(xpath="//button[contains(text(),'CONTINUE')]")	
	private WebElement weCountinue;
	
			

	public void fnPayinfo(final int iTestCaseID, ComboAppData testData) throws Exception
	{
		waitForThread(CommonClass.iWaitForThread2);
		
		 System.out.println("Payment info form first click");
			waitForThread(CommonClass.iWaitForThread2);
			
			//weCardno.sendKeys("5123456789012346");
			sendValue(weCardno,testData.sCardno,"card Details of the");
			waitForThread(CommonClass.iWaitForThread2);
			//wemonthcreditcard.sendKeys("May (05)");
			wemonthcreditcard.sendKeys(testData.sMonthcreitcrd);
			//sendValue(wemonthcreditcard,testData.sMonthcreitcrd,"Months Details of the card");
			waitForThread(CommonClass.iWaitForThread2);
			//weyearcreditcard.sendKeys("2021");
			weyearcreditcard.sendKeys(testData.sYearcrdtcard);
		  // selectValue(weyearcreditcard,testData.sYearcrdtcard,"Year Details of the card");
			//sendValue(weyearcreditcard,testData.sYearcrdtcard,"Year Details of the card");
			waitForThread(CommonClass.iWaitForThread2);
			//weCvvnocreditcard.sendKeys("123");
			sendValue(weCvvnocreditcard,testData.sCvvnocredtcard,"CVV Details of the card");
			waitForThread(CommonClass.iWaitForThread2);
			((JavascriptExecutor)CommonClass.driver).executeScript("scroll(0, 450)");
	    	waitForThread(CommonClass.iWaitForThread);
	    
	    	wesubmitb.click();
            waitForThread(CommonClass.iWaitForThread2);
            weReturnMarButn.click();
            waitForThread(CommonClass.iWaitForThread2);
            weCountinue.click();
            waitForThread(CommonClass.iWaitForThread);
          	    	
	       
	}
}
	