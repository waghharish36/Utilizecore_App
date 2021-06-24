package lib;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.ITestContext;
import org.testng.TestRunner;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonClass
{
	public static WebDriver driver;
	public static Actions action;
	public static WebDriverWait wait;

	public static StringBuffer verificationErrors = new StringBuffer();
	private static int iImgCounter = 0; 
	public static Logger log = LogManager.getLogger(CommonClass.class);

	//Globals variables defined here --- START ---
	// Wait for long duration
	public static int iWaitForElement;
	public static int iWaitForThread;
	public static int iWaitForThread2;
	public static int iWaitForThread1;
	// Globals
	public static String BROWSER;
	public static String CHROME_DRIVER_PATH;
	public static String IE_DRIVER_PATH;
	public static String OUTPUT_PATH;
	public static String IMAGES_PATH;
	public static String DATA_PATH;
	public static String SHEET;
	public static boolean bRunInTestMode = false;
	public static boolean bPrintScreen = false;  
	public static int TESTCASES;
	public static String sBaseURL;

	//Globals variables defined here ---  END  ---

	@BeforeSuite
	@Parameters({"bRunInTestMode", "bPrintScreen",
		"CHROME_DRIVER_PATH","IE_DRIVER_PATH","OUTPUT_PATH","IMAGES_PATH",
		"iWaitForElement","iWaitForThread","iWaitForThread1","iWaitForThread2","sBaseURL"})
	public void setup(ITestContext ctx, Boolean bRunInTestMode, Boolean bPrintScreen,
			String CHROME_DRIVER_PATH, String IE_DRIVER_PATH, String OUTPUT_PATH, String IMAGES_PATH,
			int iWaitForElement, int iWaitForThread, int iWaitForThread1, int iWaitForThread2, String sBaseURL)
	{
		DOMConfigurator.configure("log4j.xml");
		log.info("Before suite launch...");
		TestRunner runner = (TestRunner) ctx;

		OUTPUT_PATH = (new File(runner.getOutputDirectory())).getParent();
		IMAGES_PATH = new File(runner.getOutputDirectory()).getParent() + "_Images\\";

		//Globals variables populated here --- START ---
		CommonClass.bRunInTestMode 		= bRunInTestMode;
		CommonClass.bPrintScreen 		= bPrintScreen;
		CommonClass.CHROME_DRIVER_PATH	= CHROME_DRIVER_PATH;
		CommonClass.IE_DRIVER_PATH 		= IE_DRIVER_PATH;
		CommonClass.OUTPUT_PATH 		= OUTPUT_PATH;
		CommonClass.IMAGES_PATH 		= IMAGES_PATH;
		CommonClass.iWaitForElement 	= iWaitForElement;
		CommonClass.iWaitForThread 		= iWaitForThread;
		CommonClass.iWaitForThread1 	= iWaitForThread1;
		CommonClass.iWaitForThread2 	= iWaitForThread2;
		CommonClass.sBaseURL			= sBaseURL;
		//Globals variables populated here ---  END  ---
		
		//Globals variables dumped here --- START ---
		log.debug("CHROME_DRIVER_PATH:" + CHROME_DRIVER_PATH);
		log.debug("IE_DRIVER_PATH:" + IE_DRIVER_PATH);
		log.debug("Output Folder:" + OUTPUT_PATH);
		log.debug("Images Folder:" + IMAGES_PATH);
		//Globals variables dumped here ---  END  ---
	}

	@BeforeTest
	
	@Parameters({"browser","DATA_PATH","SHEET","TESTCASES"})
	public void setUp(String browser,String DATA_PATH,String SHEET,int TESTCASES) throws Exception
	{
		log.info("Before test launch...");
		log.debug("Testing on browser: " + browser);		
		browser = browser.toLowerCase();
		if (browser.equals("chrome"))
		{        
			System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
			driver = new ChromeDriver();
		}
		else if (browser.equals("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else if (browser.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver", IE_DRIVER_PATH);
			driver = new InternetExplorerDriver();
		}
		else
		{
			throw new RuntimeException("No driver available for browser: " + browser);
		}

		CommonClass.BROWSER = browser; 
		CommonClass.DATA_PATH = DATA_PATH;
		CommonClass.SHEET = SHEET;
		CommonClass.TESTCASES = TESTCASES;
		

		action = new Actions(driver);
		wait = new WebDriverWait(driver, iWaitForElement);

		driver.manage().window().maximize(); // To Maximise Window	  
		driver.manage().timeouts().implicitlyWait(iWaitForElement, TimeUnit.SECONDS);
			
	}

	@AfterTest
	public void tearDown() throws Exception
	{
		// WebDriver will be closed
		log.info("Starting tear Down");
//				driver.close();
	}

	public static int getNextImgCounter()
	{
		iImgCounter++;
		return iImgCounter;
	}

	public static FirefoxProfile downloadPDFFile()
	{
		FirefoxProfile profile=new FirefoxProfile();
		profile.setPreference("browser.download.folderList", 2);
		profile.setPreference("pdfjs.disabled", true);
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk","application/pdf");
		return profile;
	}
	
	
}
