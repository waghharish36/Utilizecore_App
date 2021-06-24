package comboAppPages;

import lib.ComboAppData;
import lib.CommonClass;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends ComboAppBasePage 
{
	public static Logger log = LogManager.getLogger(ComboAppBasePage.class);

	public MainPage() 
	{
		super();
	}

		//by harish
	@FindBy(xpath="//*[@id='getQuoteForm']/div[1]/section/div[1]/div/div[1]")
	private WebElement weGenderM;
	

	@FindBy(xpath="//*[@id='getQuoteForm']/div[1]/section/div[1]/div/div[2]")
	private WebElement weGenderF;
	
	@FindBy(xpath="//*[@id='getQuoteForm']/div[1]/section/div[2]/div/div[1]")
	private WebElement weTobacoYes;
	
	@FindBy(xpath="//*[@id='getQuoteForm']/div[1]/section/div[2]/div/div[2]")
	private WebElement weTobacoNo;
	
	
	@FindBy(xpath="//*[@id='full_name']")
	private WebElement weName;

	@FindBy(xpath="//*[@id='mat-input-0']")
	private WebElement weDOB;
	
	@FindBy(xpath="//*[@id='getQuotePage']/app-error-component-web/div[2]/div/button[1]")
	private WebElement weYespopup;
	

	@FindBy(xpath="//*[@id='getQuotePage']/app-error-component-web/div[2]/div/button[2]")
	private WebElement weNopopup;
	

	@FindBy(xpath="//*[@id='phone']")
	private WebElement weMobileno;
	
	
	@FindBy(xpath="//*[@id='email']")
	private WebElement weEmail;
	
	//@FindBy(xpath="//*[@id='getQuoteForm']/div[7]/section/div/div/button")
	@FindBy(xpath="//button[contains(text(),'Get free quote')]")	
	private WebElement weGetFreQuoteBtn;

	
	

	public void fnHomePage(final int iTestCaseID, ComboAppData testData)throws Exception 
	{
			
		CommonClass.driver.get(CommonClass.sBaseURL);
		//CommonClass.driver.get(CommonClass.sBaseURL);
		//log.info("Verifying page title - Login Page Open");
		 waitForThread(CommonClass.iWaitForThread2);
			 
		 if(testData.sGender.equalsIgnoreCase("Male"))
	        { 
	        	//System.out.println("This is joint Life Case");
	            waitForThread(CommonClass.iWaitForThread2);
	            weGenderM.click();
	        }
		 else
		   {
			 System.out.print("This is Female case");
			 weGenderF.click();
		   }
		 
		 waitForThread(CommonClass.iWaitForThread2);
		 
		 if(testData.sTobacoUser.equalsIgnoreCase("Yes"))
	        { 
	        	//System.out.println("This is joint Life Case");
	            waitForThread(CommonClass.iWaitForThread2);
	            weTobacoYes.click();
	        }
		 else
		 {
			 System.out.print("This is No Tobbaco");
			 weTobacoNo.click();
		 }
		 
		 waitForThread(CommonClass.iWaitForThread2);
		
         sendValue(weName, testData.sName,"Enter the name");
         
         waitForThread(CommonClass.iWaitForThread2);
 		
         sendValue(weDOB, testData.sDOB,"Enter the Dob");
         
         waitForThread(CommonClass.iWaitForThread2);
         
         if(weYespopup.isDisplayed())
         {
        	
                  
         if(testData.sPopUp.equalsIgnoreCase("Yes"))
	        { 
	        	
	            waitForThread(CommonClass.iWaitForThread2);
	            weYespopup.click();
	        }
		 else if(testData.sPopUp.equalsIgnoreCase("No"))
		 {
			 System.out.print("This is No Selction On the pop up");
			 weNopopup.click();
		 }
         else
         {
        	 System.out.print("pop up not display"); 
         }
		
         }
        // weYespopup.click();

        // weNopopup.click();
         
         
         
         
         waitForThread(CommonClass.iWaitForThread2);
  		
         sendValue(weMobileno, testData.sMobileNO,"Enter the mobile no");
         
         waitForThread(CommonClass.iWaitForThread2);
   		
         sendValue(weEmail, testData.sEmail,"Enter the Email");
         
         waitForThread(CommonClass.iWaitForThread2);
        
       
         weGetFreQuoteBtn.click();
         waitForThread(CommonClass.iWaitForThread2);
         
		 }
}
	
	
