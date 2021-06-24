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

public class PersonalDeatilPage extends ComboAppBasePage
{
	public PersonalDeatilPage() 
	{
		super();
	}
	
	
	@FindBy(xpath="//*[@id='personalDetailsForm']/div[1]/div[1]/div[1]/div/input")
	private WebElement weaddline1;

	@FindBy(xpath="//*[@id='personalDetailsForm']/div[1]/div[1]/div[2]/div/input")
  	 private WebElement weaddline2;
	
	
	@FindBy(xpath="//*[@id='personalDetailsForm']/div[1]/div[2]/div[1]/div/input")
	private WebElement weaddLandmark;
		
	@FindBy(xpath="//button[contains(text(),'CONTINUE')]")	
	private WebElement weCountinue;
	
	@FindBy(xpath="//*[@id='personalDetailsForm']/div/div[1]/div[1]/div/div/input")	
	private WebElement weAddharno;
	
		
	@FindBy(xpath="//*[@id='personalDetailsForm']/div/div[1]/div[2]/div/div/label[1]")	
	private WebElement wesalaried;
	

	@FindBy(xpath="//*[@id='personalDetailsForm']/div/div[2]/div/div/div/ng-select/div/span")	
	private WebElement wesalarselect;	
		
		
	@FindBy(xpath="//div[@class='ng-option ng-option-marked']/span[@class='ng-option-label']")	
	//@FindBy(xpath="/div[@class='ng-option ng-option-marked']/span[@class='ng-option-label']/contains(text(),'Married')")
	private WebElement wesingle;
	
	//@FindBy(xpath="//span[contains(@class,'ng-option-label') and contains(text(),'Married')]")
	@FindBy(xpath="//span[contains(@class,'ng-value-label') and contains(text(),'Married')]")
	private WebElement wesingleselction;
	
	
	
	@FindBy(xpath="//*[@id='personalDetailsForm']/div/div[2]/div[2]/div/input")	
	private WebElement weweight;
	
	
	@FindBy(xpath="//*[@id='personalDetailsForm']/div/div[3]/div[1]/div/div/div[1]/ng-select/div/span")	
	private WebElement weHeightFt;
	
	
	@FindBy(xpath="//span[contains(@class,'ng-option-label') and contains(text(),'4 feet')]")
	private WebElement weHeightselctFt;
	

	@FindBy(xpath="//*[@id='personalDetailsForm']/div/div[3]/div[1]/div/div/div[2]/ng-select/div/span")	
	private WebElement weHeightinch;
	
	@FindBy(xpath="//span[contains(@class,'ng-option-label') and contains(text(),'3 inches')]")
	private WebElement weHeightselctinch;
	
  
     
     @FindBy(xpath="//*[@id='personalDetailsForm']/div/div[3]/div/div/input")
   //*[@id="personalDetailsForm"]/div/div[2]/div/div/input  
	  private WebElement weFatherName;
     
     @FindBy(xpath="//input[@name='motherName']")	
	  private WebElement weMotherName;
	
			

	public void fnPersonaldetl(final int iTestCaseID, ComboAppData testData) throws Exception
	{
		waitForThread(CommonClass.iWaitForThread2);
		
		 System.out.println("Personal Details info first click");
			waitForThread(CommonClass.iWaitForThread2);
			
			//weaddline1.sendKeys("At Post Nimgul Tal Shindkhed");
			sendValue(weaddline1,testData.saddline1,"Address Line of customer");
			waitForThread(CommonClass.iWaitForThread2);
			//weaddline2.sendKeys("maharshta state citizens");
			sendValue(weaddline2,testData.saddline2,"Address Line2 of customer");

			waitForThread(CommonClass.iWaitForThread);
			//weaddLandmark.sendKeys("new plots road");
			sendValue(weaddLandmark,testData.saddLandmark,"Address landmark of customer");

			
			waitForThread(CommonClass.iWaitForThread2);
			((JavascriptExecutor)CommonClass.driver).executeScript("scroll(0, 450)");
	    	waitForThread(CommonClass.iWaitForThread);
	  
            weCountinue.click();
            waitForThread(CommonClass.iWaitForThread2);
          	    
           // weAddharno.sendKeys("123456789101");
             //sendValue(weAddharno, .s"Aadhar Number value enter");
             sendValue(weAddharno,testData.sAddharno,"Addhar No of customer");
             
            waitForThread(CommonClass.iWaitForThread2);
            
            wesalaried.click();
            
            waitForThread(CommonClass.iWaitForThread2);
            wesalarselect.click();
            waitForThread(CommonClass.iWaitForThread);
            //wesingle.sendKeys("Single");
            Actions actions1 = new Actions(CommonClass.driver); 
            actions1.moveToElement(wesingle).clickAndHold();
            System.out.println("drop down selection ");
            waitForThread(CommonClass.iWaitForThread2);
            wesingle.click();
            waitForThread(CommonClass.iWaitForThread);
            Actions actions2 = new Actions(CommonClass.driver); 
            actions2.moveToElement(wesingleselction).click();
            System.out.println("drop down selection status");
            waitForThread(CommonClass.iWaitForThread2);
            //wesingleselction.click();
            
            //wesingleselction.click();
           
            
            waitForThread(CommonClass.iWaitForThread2);
           // weweight.sendKeys("55");
           //sendValue(weweight, "58");
            sendValue(weweight,testData.sweightd,"Weight value enter");
            
            waitForThread(CommonClass.iWaitForThread);
            ((JavascriptExecutor)CommonClass.driver).executeScript("scroll(0, 350)");
	    	waitForThread(CommonClass.iWaitForThread);
	  
            weHeightFt.click();
            waitForThread(CommonClass.iWaitForThread1);
            Actions actions3 = new Actions(CommonClass.driver); 
            actions3.moveToElement(weHeightselctFt);
            System.out.println("drop down height list selection");
            waitForThread(CommonClass.iWaitForThread);
            weHeightselctFt.click();
           waitForThread(CommonClass.iWaitForThread2);
            weHeightinch.click();
           waitForThread(CommonClass.iWaitForThread);
           Actions actions4 = new Actions(CommonClass.driver); 
           actions4.moveToElement(weHeightselctinch);
           System.out.println("drop down height inch selection ");
           waitForThread(CommonClass.iWaitForThread2);
           weHeightselctinch.click();
            
           // weHeightInch.click();
           waitForThread(CommonClass.iWaitForThread);
          // weFatherName.sendKeys("Gulabrao Patil");
           sendValue(weFatherName,testData.sFatherName,"Father Full Name");

           waitForThread(CommonClass.iWaitForThread);
          // weMotherName.sendKeys("Ranjana Patil");
           sendValue(weMotherName,testData.sMotherName,"Mother Full Name");
           waitForThread(CommonClass.iWaitForThread);
           weCountinue.click();
           waitForThread(CommonClass.iWaitForThread2);
           waitForThread(CommonClass.iWaitForThread);
           ((JavascriptExecutor)CommonClass.driver).executeScript("scroll(0, 450)");
           waitForThread(CommonClass.iWaitForThread);
           weCountinue.click();
           waitForThread(CommonClass.iWaitForThread);
           ((JavascriptExecutor)CommonClass.driver).executeScript("scroll(0, 450)");
           waitForThread(CommonClass.iWaitForThread);
           weCountinue.click();
          
	       
	}
}
	