package comboAppPages;

import lib.ComboAppData;
import lib.CommonClass;
import net.bytebuddy.asm.Advice.Enter;

import java.sql.Driver;
import java.util.List;

//import org.apache.bcel.generic.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BenifitPage extends ComboAppBasePage
{
	public BenifitPage() 
	{
		super();
	}
	
	


	@FindBy(xpath="//*[@id='benefitForm']/section/div/section[1]/div[2]")
	private WebElement webenetform;

	@FindBy(xpath="/html/body/app-root/main/app-benefit/main/form/section/div/section[1]/div[2]/div/div/ul/li[2]/div[1]/div[1]")
                	//*[@id="benefitForm"]/section/div/section[1]/div[2]/div/div/ul/li[1]/div[2]/button 
	//@FindBy(xpath="//button[contains(text(),'ADD')]")
	//@FindBy(xpath="//*[@id='benefitForm']/section/div/section[1]/div[2]/div/div/ul/li[1]/div[2]/button/span")
    // @FindBy(xpath="//button[@title='Add']")
	//@FindBy(xpath="//button[@title='Add']")
   //button[@class='btn-add show-mob'][.//span[contains(text(), 'Add')]]
	//@FindBy(xpath="//*[@id='benefitForm']/section/div/section[1]/div[2]/div/div/ul/li[1]/div[2]/button")
	//@FindBy(className="btn-add show-mob")
	 private WebElement weLifeSecureAdd;
	

	@FindBy(xpath="//*[@id='benefitForm']")
	private WebElement webenefitform;
	
	@FindBy(xpath="//button[contains(text(),'CONTINUE')]")	
	private WebElement weCountinue;
	
		
			

	public void fnBenifitcovrge(final int iTestCaseID, ComboAppData testData) throws Exception
	{
		waitForThread(CommonClass.iWaitForThread2);
		 System.out.println("Benifit form first click");
			waitForThread(CommonClass.iWaitForThread2);
	       
	       	//((JavascriptExecutor)CommonClass.driver).executeScript("scroll(0, 450)");
		if(testData.sCovrageAddon.equalsIgnoreCase("Life Secure"))
        { 
        	
            waitForThread(CommonClass.iWaitForThread2);
            //clickElement(weLifeSecureAdd,"Life secured button selction");
            //clickElement(weLifeSecureAdd);
            

            Actions actions = new Actions(CommonClass.driver);
    	    actions.moveToElement(webenetform).click().build().perform();
    	    waitForThread(CommonClass.iWaitForThread2);
    	    
    	    System.out.println("Benifit first Action Complete");
    	    
    	    weLifeSecureAdd.isEnabled();
    	    {
    	    	System.out.println("Benifit element Enable");
    	    	//doubleclick(weLifeSecureAdd);
    	    	waitForThread(CommonClass.iWaitForThread2);
    	    	//clickElement(weLifeSecureAdd,"life secured button click");
    	    	Actions actions1 = new Actions(CommonClass.driver);
  	    	     actions1.moveToElement(weLifeSecureAdd).clickAndHold();
  	    	   waitForThread(CommonClass.iWaitForThread);
    	    	weLifeSecureAdd.click();
    	    	waitForThread(CommonClass.iWaitForThread2);
    			//ClickAndTakeImage("Proceed", weLifeSecureAdd);
    			
    	    	
    	    	//weLifeSecureAdd.submit();
    	    	
    	    	waitForThread(CommonClass.iWaitForThread);
    	    	//weLifeSecureAdd.sendKeys(Keys.ENTER);
    	    	 // Actions actions1 = new Actions(CommonClass.driver);
    	    	  // actions1.moveToElement(weLifeSecureAdd).click();
    	    	 	//waitForThread(CommonClass.iWaitForThread);
    	    	
    	    	 	System.out.println("Action Performed");
    	    }
    	    
    	    
    	    
    	   // WebDriverWait wait= New WebDriverWait(Driver,15)
    	  //  wait.Until(Ex.VisibilityOfAllElementsLocatedBy(By.Id("")));


            
            //Actions actions1 = new Actions(CommonClass.driver);
    	    //actions1.moveToElement(weLifeSecureAdd).click().build().perform();
    	    
    	    System.out.print("benifit form click");
    		waitForThread(CommonClass.iWaitForThread1);
            
    		//weLifeSecureAdd.click();
    		//waitForThread(CommonClass.iWaitForThread1);
    		
       }
	else
	 {
		 System.out.print("This is Life Secured option selection");
	 }
		
    	((JavascriptExecutor)CommonClass.driver).executeScript("scroll(0, 450)");
    	waitForThread(CommonClass.iWaitForThread1);
    	weCountinue.click();
    	
		
				
		//waitForThread(CommonClass.iWaitForThread);
		//clickElement(weAnualIncomeedit,"click on Anually income edit option");
		//weAnualIncomeedit.click();
		//weAnualIncomeedt.click();
		//sendValue(weAnualIncomeedit,test
		
           }




	          
                
    	}
	 	  
    
        
          
               



	
	
	

