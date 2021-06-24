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

public class PremiumPage extends ComboAppBasePage
{
	public PremiumPage() 
	{
		super();
	}
	
	
	@FindBy(xpath="//*[@id='payPremiumForm']/section/div/section[1]/div[2]/div[1]/div/div/input")
	private WebElement wepanno;

	@FindBy(xpath="//*[@id='payPremiumForm']/section/div/section[1]/div[2]/div[1]/div[2]/div/input")
  	 private WebElement wePincode;
	
	
	@FindBy(xpath="//*[@id='payPremiumForm']/section/div/section[1]/div[2]/div[2]/div[1]/div/input")
	private WebElement westate;
	
	@FindBy(xpath="//button[contains(text(),'CONTINUE')]")	
	private WebElement weCountinue;
	
	@FindBy(xpath="//*[@id='premiumAgreementForm']/section/div/section/div[2]/div/div/div/ul/li[1]/div[1]/label")
	private WebElement weTermscondtn;
	
	@FindBy(xpath="//*[@id='paymentmethodForm']/section[2]/div/section[1]/div[2]/div/div[1]/div/ul/label[1]/li/div[1]/div")
	private WebElement weCardBankacT;
			
	
	@FindBy(xpath="//button[contains(text(),'PROCEED TO PAY')]")	
	private WebElement weproctopay;
	

	@FindBy(xpath="//*[@id='ContentPlaceHolder1_rbodisclaimer_1']")	
	private WebElement weConfirmPayment;
	

	@FindBy(xpath="//*[@id='ContentPlaceHolder1_btnPay']")	
	private WebElement weConfirmPaymentButn;
				

	private WebDriver driver;
			

	public void fnPremiumpay(final int iTestCaseID, ComboAppData testData) throws Exception
	{
		waitForThread(CommonClass.iWaitForThread2);
		
		 System.out.println("Premium pay form first click");
			waitForThread(CommonClass.iWaitForThread2);
			waitForThread(CommonClass.iWaitForThread);
			
			//wepanno.sendKeys("AAAAA1234K");
			sendValue(wepanno,testData.sPanNo,"Pan No of the customer");
			waitForThread(CommonClass.iWaitForThread2);
			//wePincode.sendKeys("400001");
			sendValue(wePincode,testData.sPincode,"Pin code of the customer");
			waitForThread(CommonClass.iWaitForThread2);
			westate.click();
			((JavascriptExecutor)CommonClass.driver).executeScript("scroll(0, 450)");
	    	waitForThread(CommonClass.iWaitForThread2);
	    	weCountinue.click();
	    	waitForThread(CommonClass.iWaitForThread2);
	    	
	    	Actions actions1 = new Actions(CommonClass.driver); 
            actions1.moveToElement(weTermscondtn).clickAndHold();
            System.out.println("Terms condition and hold done");
            waitForThread(CommonClass.iWaitForThread2);
            weTermscondtn.click();
           // waitForThread(CommonClass.iWaitForThread2);
                     
            
            waitForThread(CommonClass.iWaitForThread2);
           /* java.util.Set<String> handlesSet =driver.getWindowHandles();
            List<String> handlesList = new ArrayList<String>(handlesSet);
            driver.switchTo().window(handlesList.get(1));
            driver.close();
            driver.switchTo().window(handlesList.get(0));*/
            
            ArrayList<String> tabs2 = new ArrayList<String> (CommonClass.driver.getWindowHandles());
           CommonClass.driver.switchTo().window(tabs2.get(1));
           CommonClass.driver.close();
           CommonClass.driver.switchTo().window(tabs2.get(0));
            
            System.out.println("focus on parent window");
    	//weTermscondtn.click();
	    	waitForThread(CommonClass.iWaitForThread2);
	    	//CommonClass.driver.switchTo().defaultContent();
	     	//waitForThread(CommonClass.iWaitForThread2);
	    	((JavascriptExecutor)CommonClass.driver).executeScript("scroll(0, 450)");
	    	waitForThread(CommonClass.iWaitForThread);
	    	 		    	
		       	 System.out.println("visible radio button self");
	    	
            Actions actions = new Actions(CommonClass.driver); 
            actions.moveToElement(weCardBankacT).clickAndHold();
            System.out.println(" radio button self clcik and hold done");
            waitForThread(CommonClass.iWaitForThread2);
            weCardBankacT.click();
            
           ((JavascriptExecutor)CommonClass.driver).executeScript("scroll(0, 250)");
            waitForThread(CommonClass.iWaitForThread2);
            weproctopay.click();
            waitForThread(CommonClass.iWaitForThread2);
            Actions actions2 = new Actions(CommonClass.driver); 
            actions2.moveToElement(weConfirmPayment).clickAndHold();
            System.out.println("radio button self clcik and hold done");
            waitForThread(CommonClass.iWaitForThread2);
            weConfirmPayment.click();
            waitForThread(CommonClass.iWaitForThread2);
            ((JavascriptExecutor)CommonClass.driver).executeScript("scroll(0, 350)");
            waitForThread(CommonClass.iWaitForThread2);
            weConfirmPaymentButn.click();
                    
            
           // actions.moveToElement(weCardBankacT).click().build().perform();
	    	//weCardBankacT.click();
	    	
	       
	}
}
	