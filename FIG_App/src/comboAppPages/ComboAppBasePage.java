package comboAppPages;

import lib.BaseClass;
import lib.CommonClass;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.openqa.jetty.html.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ComboAppBasePage extends BaseClass
{
	public static Logger log = LogManager.getLogger(ComboAppBasePage.class);
	public static String sNumber = "0";
	public static String sQuoteNumber;
	public static String sProposalNumberCombo;
	public static int user;
	private FileOutputStream fos = null;

	public ComboAppBasePage()
	{
		PageFactory.initElements(CommonClass.driver, this);
		
	}
	// Date format Conversion
		public String DateFormateConversion(String sActualDate) throws Exception 
		{
			SimpleDateFormat sdfSource = new SimpleDateFormat("dd/MM/yyyy");
			Date date = sdfSource.parse(sActualDate);
			SimpleDateFormat sdfDestination = new SimpleDateFormat("d/MMMM/YYYY");
			String sDate = sdfDestination.format(date);
			return sDate;
		}

		public boolean isPresent(WebElement weElement)
		{
			try 
			{
				weElement.isEnabled();
				return true;

			}
			catch (Exception e) 
			{
				return false;
			}
		}

		public void fnDate(WebElement weElement, String date, String strdd) throws Exception 
		{
			String date1 = DateFormateConversion(date);
			String[] d1 = date1.split("/");
			String dd = d1[0];
			String mm = d1[1];

			waitForThread(CommonClass.iWaitForThread);
			clickElement(weElement);

			Calendar cal = Calendar.getInstance();
			System.out.println(new SimpleDateFormat("MMMM").format(cal.getTime()));

			if (mm.equalsIgnoreCase(new SimpleDateFormat("MMMM").format(cal
					.getTime()))) {
				waitForThread(CommonClass.iWaitForElement);
				WebElement weDate = CommonClass.driver
						.findElement(By
								.xpath("//table[contains(@id,'"
										+ strdd
										+ "')]//td[not(contains(@class,'calendar_Day DayStyle calendar_previousMonthDay'))]/table/tbody/tr/td[text()='"
										+ dd + "']"));
				clickElement(weDate);
			} else 
			{
				if (strdd.equalsIgnoreCase("RequestLetterDate")) 
				{
					WebElement weMonth = CommonClass.driver.findElement(By
							.xpath("//table[contains(@id,'" + strdd
									+ "')]//td//select[contains(@id,'Months')]"));
					clickElement(weMonth);
					new Select(weMonth).selectByVisibleText(mm);

					waitForThread(500);
					WebElement weDate = CommonClass.driver
							.findElement(By
									.xpath("//table[contains(@id,'"
											+ strdd
											+ "')]//td[not(contains(@class,'calendar_Day DayStyle calendar_previousMonthDay'))]/table/tbody/tr/td[text()='"
											+ dd + "']"));
					clickElement(weDate);
				} else 
				{
					WebElement weMonth = CommonClass.driver.findElement(By
							.xpath("//table[contains(@id,'" + strdd
									+ "')]//td//select[contains(@id,'Months')]"));
					clickElement(weMonth);
					new Select(weMonth).selectByVisibleText(mm);

					waitForThread(CommonClass.iWaitForThread2);
					CommonClass.action.click(weElement).build().perform();
					WebElement weDate = CommonClass.driver
							.findElement(By
									.xpath("//table[contains(@id,'"
											+ strdd
											+ "')]//td[not(contains(@class,'calendar_Day DayStyle calendar_previousMonthDay'))]/table/tbody/tr/td[text()='"
											+ dd + "']"));
					
					clickElement(weDate);
					
				}
			}
		}
		
		/*public static String fnQuotenProposal(WebElement weElement, String sString,
				int istart, int iEnd) throws Exception 
		{
			String sQuoteText = weElement.getText();
			int index = sQuoteText.indexOf(sString);
			int i = 0;
			while (i <= 5) {
				i++;
				if (sQuoteText == null) {
					Thread.sleep(CommonClass.iWaitForThread);
				} else {
					sNumber = sQuoteText.substring(index + istart, index + iEnd);
					i = 6;
				}
			}
			return sNumber;
		}*/
		
		public void setExcelCellValue(int iCell, String sdata, int iTestCaseID)
		{
			try 
			{
				sheet.getRow(startline+user+iTestCaseID).createCell(iCell).setCellValue(sdata);
				fos = new FileOutputStream(CommonClass.DATA_PATH);
				wb.write(fos);

			} catch (Exception e) 
			{
				e.printStackTrace();
			}
			
			finally
			{
				if(fos != null)
				{
					try { fos.close(); }
					catch(Exception ex){}
				}
			}
		}
		
		
	}


