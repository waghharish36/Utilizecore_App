package comboAppPages;

import lib.ComboAppData;
import lib.CommonClass;

import java.sql.Driver;
import java.util.List;

//import org.apache.bcel.generic.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class PlanPage extends ComboAppBasePage
{
	public PlanPage() 
	{
		super();
	}

	@FindBy(xpath="/html/body/app-root/main/app-quotation/section/div[1]/div[2]/div[1]/div")
	private WebElement wePremiumType;
	

	@FindBy(xpath="/html/body/app-root/main/app-quotation/section/div[2]")
	private WebElement weAnualIncomeedt;
	
	
	@FindBy(xpath="//img[contains(@src,'./assets/images/edit.svg')]")
	private WebElement weAnualIncomeedit;
	
	@FindBy(xpath="/html/body/app-root/main/app-quotation")
	private WebElement weAnualIncm;
	
	@FindBy(xpath="/html/body/app-root/main/app-quotation/div[2]/div/div[2]/div/input")
	private WebElement weAnualIncmeAmt;
	

	@FindBy(xpath="/html/body/app-root/main/app-quotation/div[2]/div/div[2]/button")
	private WebElement weBdone;
	
	@FindBy(xpath="/html/body/app-root/main/app-quotation/div[2]/div/div[2]/div/input")
	private WebElement wePolicyperiod;
	

	@FindBy(xpath="/html/body/app-root/main/app-quotation/div[2]/div/div[2]/button")
	private WebElement weBPPdone;
	
	@FindBy(xpath="/html/body/app-root/main/app-quotation/div[2]/div/div[2]/div[1]/label[1]/div/div[2]/span")
	private WebElement wePSinprem;
	
	@FindBy(xpath="/html/body/app-root/main/app-quotation/div[2]/div/div[2]/div[1]/label[2]/div/div[2]/span")
	private WebElement weP5prem;
	
	
	@FindBy(xpath="/html/body/app-root/main/app-quotation/div[2]/div/div[2]/div[2]/button")
	private WebElement weBPayPeriodDone;

	@FindBy(xpath="/html/body/app-root/main/app-quotation/div[2]/div/div[2]/div[1]/label[1]/div/div[2]/span")
	private WebElement weQualPG;
	
	              
	@FindBy(xpath="/html/body/app-root/main/app-quotation/div[2]/div/div[2]/div[1]/label[2]/div/div[2]/span")
	private WebElement weQualBachlor;
	
	@FindBy(xpath="/html/body/app-root/main/app-quotation/div[2]/div/div[2]/div[1]/label[3]/div/div[2]/span")
	private WebElement weQua12th;
		
	
	@FindBy(xpath="//img[contains(@src,'/assets/images/minus_button.svg')]")
	private WebElement wecovrAmtedit;
	
   

	@FindBy(xpath="//input[@name='coverageAmount']")
	private WebElement wecovrageAmt;
		

	@FindBy(xpath="(//button[@type='button'][@class='main-cta'])")
	 private WebElement weProcedToCustd;
	
	@FindBy(xpath="//img[contains(@src,'assets/images/plus_button.svg')]")
	private WebElement weTermsCondtn;
	

	@FindBy(xpath="//button[contains(text(),'PROCEED TO CUSTOMIZE')]")	
	private WebElement weProcedToCust;

		
	@FindBy(xpath="/html/body/app-root/main/app-quotation/div[2]/div/div[2]/div[4]/button")
	private WebElement weContinue;
	

	@FindBy(xpath="//button[contains(text(),'CONTINUE')]")	
	private WebElement weCountinue;
		
	

	@FindBy(xpath="//select[@id='ddlfrequencyannuty']")
	private WebElement weIncomeFrequency;
	
	@FindBy(xpath="//*[@id='body_txtDateOfCommencement']")
	private WebElement wecosdate;
	
	
	@FindBy(xpath="//select[@id='body_ddTotalTenure']")
	private WebElement weTenure;
	
	//@FindBy(xpath="//*[@id='body_txtCoverAmount']")
	@FindBy(xpath="//input[@id='body_txtCoverAmount']")
	private WebElement weCoverAmt;
	
	@FindBy(xpath="//select[@id='body_ddIsFundedBySIB']")
	private WebElement weFunded;
	
	@FindBy(xpath="//span[@id='body_lblUNWRStatus']")
	private WebElement weProposalStatus;
	
	@FindBy(xpath="//*[@id='body_btnCalculatePremium']")
	private WebElement weCalPremium;
	
	@FindBy(xpath="//span[@id='body_lblFinalSumAssured']")
	private WebElement weSumAssured;
	
	@FindBy(xpath="//span[@id='body_lblKotakPremium']")
	private WebElement weKPremium;
	
	@FindBy(xpath="//span[@id='body_lblServiceTax']")
	private WebElement weServiceTax;
	
	@FindBy(xpath="//span[@id='body_lblTotalPremium']")
	private WebElement weToPremium;
	
	@FindBy(xpath="//span[@id='body_lblUNWRSecStatus']")
	private WebElement weProposalSecStatus;
	
	
	@FindBy(xpath="//*[@id='lnkLogout']")
	private WebElement welogout;
	
	@FindBy(xpath="//span[@id='body_lblSecKotakPremium']")
	private WebElement weKSecPremium;
	
	
			

	public void fnComboProduct(final int iTestCaseID, ComboAppData testData) throws Exception
	{
		waitForThread(CommonClass.iWaitForThread2);
		if(testData.sPremiumType.equalsIgnoreCase("Monthly"))
        { 
        	
            waitForThread(CommonClass.iWaitForThread2);
            clickElement(wePremiumType,"premium Type Monthly and Annually selction");
        }
	 else
	 {
		 System.out.print("This is Anually case");
	 }
		
				
		waitForThread(CommonClass.iWaitForThread);
		//clickElement(weAnualIncomeedit,"click on Anually income edit option");
		//weAnualIncomeedit.click();
		//weAnualIncomeedt.click();
		//sendValue(weAnualIncomeedit,testData.sAnuallIncome,"Annual Income");
		System.out.print("first click ok");
		waitForThread(CommonClass.iWaitForThread);
		Actions actions = new Actions(CommonClass.driver);
		actions.moveToElement(weAnualIncomeedit).click().build().perform();
		waitForThread(CommonClass.iWaitForThread1);
		
		//actions.moveToElement(weAnualIncmeAmt).perform();
		
        waitForThread(CommonClass.iWaitForThread1);
       // sendValue(weAnualIncmeAmt,testData.sAnualIncmeAmt,"Anual Income Field");
       weAnualIncmeAmt.sendKeys(testData.sAnualIncmeAmt);
       waitForThread(CommonClass.iWaitForThread1);
        
       weBdone.click(); 
       waitForThread(CommonClass.iWaitForThread1);
       
         
       wePolicyperiod.clear();
       
       wePolicyperiod.sendKeys(testData.sPolicyPeriod);//excel
       waitForThread(CommonClass.iWaitForThread);
       weBPPdone.click();
       waitForThread(CommonClass.iWaitForThread);
       
       if(testData.sPolicyPremium.equalsIgnoreCase("Single Premium"))
       { 
       	
           waitForThread(CommonClass.iWaitForThread2);
           clickElement(wePSinprem,"Its Single premium case");
       }
	   else
	    {
		 System.out.print("This is 5 Year case");
		 clickElement(weP5prem,"Its 5 Year premium case");
		 
	    }
		
      
      // wePSinprem.click();
       waitForThread(CommonClass.iWaitForThread);
       weBPayPeriodDone.click();
        // numberOfDays;
        //String numberOfDay;
       waitForThread(CommonClass.iWaitForThread);
       if(testData.sQualification.equalsIgnoreCase("Post Graduation"))
       { 
       	
           waitForThread(CommonClass.iWaitForThread2);
           clickElement(weQualPG,"Its Post Graduation Case");
       }
	 else if(testData.sQualification.equalsIgnoreCase("Graduation"))
	 {
		 System.out.print("This is Bachlor case");
		 clickElement(weQualBachlor,"Its Graduation Case");
	 }
	 else
	 {
		 System.out.print("This is 12th Pass case");
		 clickElement(weQua12th,"Its 12th Pass Case");
	 }
       
	 
		
      // weQualPG.click();
       //weQualBachlor.click();
       waitForThread(CommonClass.iWaitForThread);
       weBPayPeriodDone.click();        
           waitForThread(CommonClass.iWaitForThread); 
           
          //wecovrageAmt.clear();
          /* waitForThread(CommonClass.iWaitForThread);
           Actions actions1 = new Actions(CommonClass.driver);
   		   actions1.moveToElement(wecovrAmtedit).click().build().perform();
   		   waitForThread(CommonClass.iWaitForThread1);*/
   		
           
           //waitForThread(CommonClass.iWaitForThread);
   		//wecovrageAmt.click();
           wecovrageAmt.clear();
           //sendValue(wecovrageAmt,"6000000","Covrage Amount Field");
           waitForThread(CommonClass.iWaitForThread);
           wecovrageAmt.sendKeys(testData.sCovrageAmt); 
           
           waitForThread(CommonClass.iWaitForThread);
           
       	((JavascriptExecutor)CommonClass.driver).executeScript("scroll(0, 450)");

       	waitForThread(CommonClass.iWaitForThread);
          // weProcedToCust.click();
       	Actions actions1 = new Actions(CommonClass.driver);
		actions1.moveToElement(weTermsCondtn).click().build().perform();
	 	waitForThread(CommonClass.iWaitForThread2);
	 	//weProcedToCustd.click();
	 	weProcedToCust.click();
		waitForThread(CommonClass.iWaitForThread2);
	 	weContinue.click();
		waitForThread(CommonClass.iWaitForThread2);
		
           }
          
                
    	}
	 	  
    
        
          
               



	
	
	

