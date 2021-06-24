package lib;

import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.AssertJUnit;

public class BaseClass extends ComboAppData
{
	public static Logger log = LogManager.getLogger(BaseClass.class);
	// To Check all the validation messages - Print/Capture Screenshot
	public boolean myAssertEquals (String str1, String str2, String strMsg) throws Exception
	{
		try
		{
			AssertJUnit.assertEquals (str1, str2);
			log.debug(getClassFuncName(3)+"Verified: " + strMsg);
			return true;
		}
		catch (Error e)
		{
			CommonClass.verificationErrors.append("Not done: " + strMsg + ":" + e.toString());
			log.error(getClassFuncName(3)+"Not done: " + strMsg );
			log.error(getClassFuncName(3)+getStackTrace(e));

			vTakeImage(strMsg, true, 4);
			throw e;
		}
	}

	// To check Fields present or not - Print/Capture Screenshot
	public boolean myAssertTrue (boolean condition, String strMsg) throws Exception
	{
		try
		{
			AssertJUnit.assertTrue (condition);
			log.debug(getClassFuncName(3)+"Verified: " + strMsg);
			return true;
		}
		catch (Error e)
		{
			CommonClass.verificationErrors.append(strMsg + ":" + e.toString());
			log.error(getClassFuncName(3)+"Not done: " + strMsg );
			log.error(getClassFuncName(3)+getStackTrace(e));

			vTakeImage(strMsg, true, 4);
			throw e;
		}
	}

	public boolean myWaitNAssertTrue(WebElement weElement, String strMsg) throws Exception
	{
		waitForElementToBeClickable(weElement);
		return myAssertTrue(weElement.isDisplayed(), strMsg);
	}

	public boolean isAlertPresent()
	{
		try
		{
			CommonClass.driver.switchTo().alert();
			CommonClass.driver.switchTo().defaultContent();
			return true;
		}
		catch (NoAlertPresentException e)
		{
			log.error(getClassFuncName(3)+getStackTrace(e));
			return false;
		}
	}

	public void waitForThread(int wait) throws InterruptedException 
	{
		Thread.sleep(wait);
	}

	public void vTakeImage() throws Exception
	{
		vTakeImage("");
	}

	public void vTakeImage(String strMsg) throws Exception
	{
		vTakeImage(strMsg, false, 4);
	}

	public void vTakeImage(String strMsg, boolean bIsError, int iLevel ) throws Exception
	{
		int iImgCounter = CommonClass.getNextImgCounter();

		String sFileName = CommonClass.IMAGES_PATH + iImgCounter + (bIsError?".Err":"") + "." + strMsg + ".png";
		try
		{
			log.debug(getClassFuncName(iLevel)+":Taking screenshot("+iImgCounter+"): " + strMsg + " :" + sFileName);

			File scrFile = ((TakesScreenshot) CommonClass.driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(sFileName));
			log.debug(getClassFuncName(iLevel)+":Taken screenshot("+iImgCounter+"): " + sFileName);
		}
		catch(Exception e1)
		{
			log.error(getClassFuncName(iLevel)+"Unable to take screenshot[" + sFileName + "]:" + strMsg + ":" + e1.toString());
			log.error(getStackTrace(e1));

			throw e1;
		}
	}

	public String GetBrowserName()
	{
		Capabilities cap = ((RemoteWebDriver) CommonClass.driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		log.debug(getClassFuncName(3)+"Browser Name is: "+browserName);
		return browserName;
	}

	public void ClickAndTakeImage(String sMessage, WebElement weElement) throws Exception
	{
		ClickAndTakeImage(sMessage, weElement, 500, 5);
	}

	public void ClickAndTakeImage(String sMessage, WebElement weElement, int iWaitForThread, int iLevel) throws Exception
	{
		long tmStart, tmEnd;

		log.debug(getClassFuncName(iLevel)+"Before clicking " + sMessage);
		vTakeImage("Before clicking " + sMessage, false, 4);

		tmStart = System.nanoTime();	
		waitForElementToBeClickable(weElement);
		weElement.click();
		tmEnd= System.nanoTime();

		if(iWaitForThread > 0)
		{
			waitForThread(iWaitForThread);
		}
		log.debug(getClassFuncName(iLevel)+"Time waited for " + sMessage + " :" + ((tmEnd-tmStart)/(1000*1000)) + " msecs");
		vTakeImage("After clicking " + sMessage, false, 4);
	}

	public void clickElement(WebElement weElement)
	{
		clickElement(weElement, "");
	}

	public void clickElement(WebElement weElement, String msg)
	{
		try 
		{
			waitForElementToBeClickable(weElement);
			weElement.click();
			log.debug(getClassFuncName(4)+"Click on: "+msg);
		} 
		catch (Exception e) 
		{
			log.error(getClassFuncName(4)+"Stale Exception:" + e);
			log.error("Retrying ..");

			waitForElementToBeClickable(weElement);
			CommonClass.action.click(weElement).build().perform();
			log.error(getClassFuncName(3)+": "+msg);
		}
	}

	//validation method
	public void DataValidation(String sActualValue, String sExpectedValue, String sFieldName) throws Exception
	{
		if(sActualValue.equalsIgnoreCase(sExpectedValue))
		{
			log.debug(getClassFuncName(4)+": "+sFieldName+" Data Validated !!");
		}
		else
		{
			log.debug(getClassFuncName(4)+": "+sFieldName+": Value does not match, Actual Value is :["+sActualValue+"]But it Should Be["+sExpectedValue+"]");
		}
	}

	public void DataValidation(WebElement weActualValue, String attrType, String sExpectedValue, String sFieldName) throws Exception
	{
		String sActualValue=weActualValue.getAttribute(attrType).trim();
		DataValidation(sActualValue, sExpectedValue, sFieldName);
	}

	public void DataValidation(WebElement weActualValue, String sExpectedValue, String sFieldName) throws Exception
	{
		String sActualValue=weActualValue.getText().trim();
		DataValidation(sActualValue, sExpectedValue, sFieldName);
	}

	public void selectValue(WebElement selectElement, String sValue, String msg, boolean bWaitForThread) throws InterruptedException
	{
		if(bWaitForThread) waitForThread(CommonClass.iWaitForThread);
		selectValue(selectElement, sValue, msg);
	}

	//to select value from select list
	public void selectValue(WebElement selectElement, String sValue, String msg) throws InterruptedException
	{
		if(selectElement.isEnabled())
		{
			try
			{
				new Select(selectElement).selectByVisibleText(sValue);
				log.debug(getClassFuncName(3)+": "+msg+" selected: " + sValue);
			} 
			catch (StaleElementReferenceException e) 
			{
				log.error(getClassFuncName(3)+"Stale Exception:" + e);
				log.error(getClassFuncName(3)+"Retrying ..");

				waitForThread(CommonClass.iWaitForThread);
				waitForElementToBeClickable(selectElement);
				new Select(selectElement).selectByVisibleText(sValue);
				selectElement.sendKeys(Keys.TAB);
				log.error(getClassFuncName(3)+": "+msg+" selected: " + sValue);
			}
		}
	}

	public void sendValue(WebElement weElement, String sValue, String msg, boolean bWaitForThread) throws InterruptedException
	{
		if(bWaitForThread) waitForThread(CommonClass.iWaitForThread);
		sendValue(weElement, sValue, msg, 4);
	}

	public String getClassFuncName(int iIndex)
	{
		StackTraceElement ste = (Thread.currentThread().getStackTrace())[iIndex];
		return (ste.getClassName() + "." + ste.getMethodName());
	}

	public void sendValue(WebElement weElement, String sValue, String msg)
	{
		    try
		    {
		    if(weElement.isEnabled())
			sendValue(weElement, sValue, msg, 4);
		    }
		    catch (Exception e) 
			{
		    	
			}
			
	}

	// to fill value in text field
	public void sendValue(WebElement weElement, String sValue, String msg, int iLevel)
	{
		try
		{
			waitForElementToBeClickable(weElement);
			weElement.click();
			weElement.clear();
			weElement.sendKeys(sValue);
			log.debug(getClassFuncName(iLevel) + ":" + msg + ":" + sValue);
		} 
		catch (Exception e) 
		{
			log.error(getClassFuncName(iLevel)+", Stale Exception:" + e);
			log.error(getClassFuncName(iLevel)+", Retrying ..");

			waitForElementToBeClickable(weElement);
			weElement.click();
			weElement.clear();
			weElement.sendKeys(sValue);
			log.error(getClassFuncName(iLevel) + ":" + msg + ":" + sValue);
		}
	}

	public void sendValue(WebElement weElement, String sValue)
	{
		sendValue(weElement, sValue, "Value", 4);
	}

	public void waitForElementToBeClickable(WebElement weElement)
	{
		try
		{	
			CommonClass.wait.until(ExpectedConditions.elementToBeClickable(weElement));
		}
		catch (StaleElementReferenceException e) 
		{
			log.error("Stale Exception:" + e);
			log.error("Retrying ..");

			CommonClass.wait.until(ExpectedConditions.elementToBeClickable(weElement));
		}
		catch(Exception e)
		{
			log.error("Exception:" + e);
		}
	}

	public static String getStackTrace(Throwable throwable)
	{
		String sMsg = "";
		Writer writer = new StringWriter();
		PrintWriter printWriter = new PrintWriter(writer);
		try
		{
			throwable.printStackTrace(printWriter);
			printWriter.flush();
			writer.flush();
			sMsg = writer.toString();
			writer.close();
			printWriter.close();
		}
		catch(Exception e) {}   //Ignore error

		return sMsg;
	}
}
