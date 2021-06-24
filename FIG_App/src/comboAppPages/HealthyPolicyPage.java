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

public class HealthyPolicyPage extends ComboAppBasePage
{
	public HealthyPolicyPage() 
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
	
		
	@FindBy(xpath="//*[@id='discountform']/section/div/section[1]/div/div/div[1]/div/ul/li[1]/label/div/div[1]/div/span")	
	private WebElement weIndiancitzn;
	
	
	@FindBy(xpath="/html/body/app-root/main/app-pay-premium-agreement/app-normal-modal[3]/div[2]/div[3]/button")	
	private WebElement weAgreeBtn;
	
	//indBy(xpath="//*[@id='premiumAgreementForm']/section/div/section[1]/div[2]/div/div/div/ul/li[1]/div[1]/label")
	//@FindBy(xpath="//input[@type='checkbox' and @id='tandc')]")
	//private WebElement wetoabcochk;
	
	@FindBy(xpath="//*[@id='premiumAgreementForm']/section/div/section[1]/div[2]/div/div/div/ul/li[2]/div[1]/label")	
	private WebElement wetcadharchk;
	
	@FindBy(xpath="//*[@id='premiumAgreementForm']/section/div/section[1]/div[2]/div/div/div/ul/li[3]/div[1]/label")	
	private WebElement wereddeclrtnchk;
	
	@FindBy(xpath="//*[@id='premiumAgreementForm']/section/div/section[1]/div[2]/div/div/div/ul/li[4]/div[1]/label")	
	private WebElement wetcproformchk;
		

	
	
	
			

	public void fnHealtydel(final int iTestCaseID, ComboAppData testData) throws Exception
	{
		waitForThread(CommonClass.iWaitForThread2);
		waitForThread(CommonClass.iWaitForThread1);
		
		System.out.println("Issue resolve continue button click");
	        
       	((JavascriptExecutor)CommonClass.driver).executeScript("scroll(0, 650)");
       	waitForThread(CommonClass.iWaitForThread2);
    	waitForThread(CommonClass.iWaitForThread);
       	weCountinue.click();
    	waitForThread(CommonClass.iWaitForThread2);
    	waitForThread(CommonClass.iWaitForThread);
       	
        ((JavascriptExecutor)CommonClass.driver).executeScript("scroll(0, 650)");
       	
       	weCountinue.click();
       	waitForThread(CommonClass.iWaitForThread2);
       // Alert alert = CommonClass.driver.switchTo().alert();		

    	//weCountinue.click();       	      
        
       CommonClass.driver.switchTo().defaultContent();
       
       System.out.println("default content switch proper");
       
       Actions actions1 = new Actions(CommonClass.driver); 
       actions1.moveToElement(weQuestnform).perform();
       System.out.println("Question form switch proper");
             	
       //Actions actions3 = new Actions(CommonClass.driver); 
       // actions3.moveToElement(wepopwindow).build().perform();
       	
        waitForThread(CommonClass.iWaitForThread2);
        waitForThread(CommonClass.iWaitForThread);
       	
       // Actions actions4 = new Actions(CommonClass.driver); 
       // actions4.moveToElement(weCountinue).click();
       	wekRAVCountinue.click();
     	waitForThread(CommonClass.iWaitForThread2);
     	waitForThread(CommonClass.iWaitForThread);
    	weIndiancitzn.click();
    	waitForThread(CommonClass.iWaitForThread2);
    	
    	weDone.click();
    	
    	waitForThread(CommonClass.iWaitForThread2);
    	//wetoabcochk.click();
    	
    	 //CommonClass.driver.switchTo().defaultContent();
         
         //System.out.println("default content switch proper");
         
        // Actions actions2 = new Actions(CommonClass.driver); 
        // actions2.moveToElement(weAgreeBtn).perform();
        // System.out.println("Argee form switch proper");
        
    	
    	//weAgreeBtn.click();
    
    	
        
           }
          
                
    	}
	 	  
    
        
          
               



	
	
	

