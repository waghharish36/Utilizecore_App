package comboAppPages;

import lib.ComboAppData;
import lib.CommonClass;

import java.sql.Driver;
import java.util.List;

import org.openqa.selenium.Alert;
//import org.apache.bcel.generic.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class PayPrimiumPage extends ComboAppBasePage
{
	public PayPrimiumPage() 
	{
		super();
	}
	

	@FindBy(xpath="//*[@id='questionsForm']")	
	private WebElement weQuestnform;

	@FindBy(xpath="//button[contains(text(),'CONTINUE')]")	
	private WebElement weCountinue;
	
	@FindBy(xpath="/html/body/app-root/main/app-question-health-policy/div[3]/div/div[2]")	
	private WebElement wepopwindow;
	
			
	
	@FindBy(xpath="/html/body/app-root/main/app-question-health-policy/div[3]/div/div[2]/app-get-eia/main/section/div/section/div/button[2]")	
	private WebElement wekRAVCountinue;
	
	@FindBy(xpath="//button[contains(text(),'Done')]")	
	private WebElement weDone;
	
		

	
	@FindBy(xpath="//*[@id='premiumAgreementForm']")
	private WebElement wetoabcomain;
	
	//@FindBy(xpath="//*[@id='premiumAgreementForm']/section/div/section[1]/div[2]/div/div/div/ul/li[1]/div[1]/label")
	@FindBy(xpath="//*[@id='premiumAgreementForm']/section/div/section[1]/div[2]/div/div/div/ul/li[1]/div[1]/label")
	private WebElement wetoabcochk;
	
	//*[@id="premiumAgreementForm"]/section/div/section[1]/div[2]/div/div/div/ul/li[1]/div[1]/label

	                
	@FindBy(xpath="//*[@id='premiumAgreementForm']/section/div/section[1]/div[2]/div/div/div/ul/li[2]/div[1]/label")	
	private WebElement wetcadharchk;
	
	@FindBy(xpath="//*[@id='premiumAgreementForm']/section/div/section[1]/div[2]/div/div/div/ul/li[3]/div[1]/label")	
	private WebElement wereddeclrtnchk;
	
	@FindBy(xpath="//*[@id='premiumAgreementForm']/section/div/section[1]/div[2]/div/div/div/ul/li[4]/div[1]/label")	
	private WebElement wetcproformchk;
	
	@FindBy(xpath="//*[@id='premiumAgreementForm']/section/div/section[1]/div[2]/div/div/div/ul/li[2]/div[1]/label")	
	private WebElement weAgreeBtn;
	
	
	@FindBy(xpath="/html/body/app-root/main/app-pay-premium-agreement/app-normal-modal[3]")	
	private WebElement weAgreempdelwindow;
	
	@FindBy(xpath="//button[contains(text(),'I agree')]")	
	private WebElement weArgrrButnA;
	

		

		

	public void fnPayprmdel(final int iTestCaseID, ComboAppData testData) throws Exception
	{
		    	
    	waitForThread(CommonClass.iWaitForThread2);
    	waitForThread(CommonClass.iWaitForThread1);
    	//wetoabcochk.click();
    	 Actions actions = new Actions(CommonClass.driver);
 	    actions.moveToElement(wetoabcomain).click().perform();
 	   System.out.println("main window switch proper");
 	    waitForThread(CommonClass.iWaitForThread2);
 	   // wetoabcochk.click();
 	   Actions actions1 = new Actions(CommonClass.driver);
	    actions1.moveToElement(wetoabcochk).click().perform();
 	   System.out.println("Tobaco click proper");
 	   waitForThread(CommonClass.iWaitForThread2);
    	 //CommonClass.driver.switchTo().defaultContent();
         
         System.out.println("Default content switch proper");
         
         Actions actions2 = new Actions(CommonClass.driver); 
         actions2.moveToElement(weAgreeBtn).click().perform();
         System.out.println("Argee form switch proper");
         waitForThread(CommonClass.iWaitForThread1);
        // CommonClass.driver.switchTo(weAgreempdelwindow).;
         waitForThread(CommonClass.iWaitForThread1);
         
         weArgrrButnA.click();
    	
    	//weAgreeBtn.click();
    	waitForThread(CommonClass.iWaitForThread);
    	//wetcadharchk.click();
    	Actions actions3 = new Actions(CommonClass.driver); 
        actions3.moveToElement(wetcadharchk).click().perform();
        System.out.println("card check proper");
    	waitForThread(CommonClass.iWaitForThread);
    	wereddeclrtnchk.click();
    	waitForThread(CommonClass.iWaitForThread);
    	wetcproformchk.click();
    	waitForThread(CommonClass.iWaitForThread);
    	weCountinue.click();
       	waitForThread(CommonClass.iWaitForThread2);
    	
        
           }
          
                
    	}
	 	  
    
        
          
               



	
	
	

