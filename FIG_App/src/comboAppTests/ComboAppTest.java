package comboAppTests;

import lib.BaseClass;
import lib.CommonExcel;
import lib.ComboAppData;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import comboAppPages.PlanPage;
import comboAppPages.PremiumPage;
import comboAppPages.BenifitPage;
import comboAppPages.HealthyPolicyPage;
import comboAppPages.MainPage;
import comboAppPages.NomineePage;
import comboAppPages.PayPrimiumPage;
import comboAppPages.PaymentInfoPage;
import comboAppPages.PersonalDeatilPage;

public class ComboAppTest extends BaseClass
{
	public static Logger log = LogManager.getLogger(ComboAppTest.class);
	
	@Test(dataProvider="getdata", dataProviderClass=CommonExcel.class)
	public void ulipKotakTest(final int iTestCaseID, ComboAppData testData) throws Exception 
	{
		long tmStart = 0, tmEnd = 0;
		try 
		{ 
			tmStart = System.nanoTime();	
			
			log.info("@@@@@Start Test:" + iTestCaseID);
			log.debug("Test Data:" + testData);
			
			
			MainPage mPage = new MainPage();
			mPage.fnHomePage(iTestCaseID, testData);
			
			 PlanPage pPage = new PlanPage();
			pPage.fnComboProduct(iTestCaseID, testData);
			
			 BenifitPage bpage = new BenifitPage();
			 bpage.fnBenifitcovrge(iTestCaseID, testData);
			 
			 PremiumPage Prmpage = new PremiumPage();
			 Prmpage.fnPremiumpay(iTestCaseID, testData);
			 
			 PaymentInfoPage Pinfopage = new PaymentInfoPage();
			 Pinfopage.fnPayinfo(iTestCaseID, testData);
			 
			 PersonalDeatilPage Pdetlpage = new PersonalDeatilPage();
			 Pdetlpage.fnPersonaldetl(iTestCaseID, testData);
			 
			 NomineePage Nomdetlpage = new NomineePage();
			 Nomdetlpage.fnNomineedetl(iTestCaseID, testData);
			 
			 HealthyPolicyPage Healthdlpage= new HealthyPolicyPage();
			 Healthdlpage.fnHealtydel(iTestCaseID, testData);
			 
			 
			 PayPrimiumPage Payprempage= new PayPrimiumPage();
			 Payprempage.fnPayprmdel(iTestCaseID, testData);
					
			 	
			log.info("@@@@@End Test:" + iTestCaseID);
			
		}
		// Catch exceptions on the complete test 
		catch (Exception ex) 
		{
			log.error("------************************************------");
			log.error("@@@@@Failed Test:" + iTestCaseID);
			log.error(getStackTrace(ex));
			log.error("------********Data Start******************------");
			log.error("Test Data:" + testData);
			log.error("------********Data End********************------");

			vTakeImage("Error.TCID-"+iTestCaseID);
			
			
			throw ex;
		}
		/*finally
		{
			tmEnd= System.nanoTime();
			log.debug("Total Time for Execution : " + ((tmEnd-tmStart)/(1000*1000)) + " msecs");
		}*/
	}
}
