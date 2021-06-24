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

public class NomineePage extends ComboAppBasePage
{
	public NomineePage() 
	{
		super();
	}

	@FindBy(xpath="//*[@id='nomineeForm']/section[1]/div[2]/div[1]/div[1]/div/div/label[1]")
	private WebElement weNominGenFemale;
	
	@FindBy(xpath="//*[@id='nomineeForm']/section[1]/div[2]/div[1]/div[1]/div/div/label[2]")
	private WebElement weNominGenMale;
	

	@FindBy(xpath="//*[@id='nomineeForm']/section[1]/div[2]/div[2]/div[1]/div/input")
	private WebElement weNomineeDOb;
	
	
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

		
	//@FindBy(xpath="/html/body/app-root/main/app-quotation/div[2]/div/div[2]/div[4]/button")
	//private WebElement weContinue;
	

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
	
	
			

	public void fnNomineedetl(final int iTestCaseID, ComboAppData testData) throws Exception
	{
		waitForThread(CommonClass.iWaitForThread2);
		((JavascriptExecutor)CommonClass.driver).executeScript("scroll(450, 0)");
		waitForThread(CommonClass.iWaitForThread2);
		if(testData.sNominGender.equalsIgnoreCase("Male"))
        { 
        	
            waitForThread(CommonClass.iWaitForThread2);
            clickElement(weNominGenMale,"Gender Male selction");
        }
	 else
	 {
		 clickElement(weNominGenFemale,"Gender FeMale selction");
	 }
		
				
		waitForThread(CommonClass.iWaitForThread);
		//weNomineeDOb.sendKeys("12-12-2000");
		weNomineeDOb.sendKeys(testData.sNomineeDOb);
	
		//clickElement(weAnualIncomeedit,"click on Anually income edit option");
		//weAnualIncomeedit.click();
		//weAnualIncomeedt.click();
		//sendValue(weAnualIncomeedit,testData.sAnuallIncome,"Annual Income");
		           waitForThread(CommonClass.iWaitForThread);
           
       	((JavascriptExecutor)CommonClass.driver).executeScript("scroll(0, 650)");

 
       	weCountinue.click();
		waitForThread(CommonClass.iWaitForThread2);
		weCountinue.click();
		waitForThread(CommonClass.iWaitForThread2);
		waitForThread(CommonClass.iWaitForThread);
        
       	((JavascriptExecutor)CommonClass.driver).executeScript("scroll(0, 550)");
       	
       	weCountinue.click();
       	
       // ((JavascriptExecutor)CommonClass.driver).executeScript("scroll(0, 550)");
       	
       	//weCountinue.click();
        
           }
          
                
    	}
	 	  
    
        
          
               



	
	
	

