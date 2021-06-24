package lib;

import java.io.FileInputStream;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class CommonExcel
{
	
	public static Logger log = LogManager.getLogger(CommonExcel.class);
	
	public static Sheet sheet;
	public static int iCount;
	public static Workbook wb;
	
	@DataProvider(name="getdata")
	private static Object[][] getData() throws Exception
	{
		Object [][] vedData = null;
		FileInputStream fis=null;
		try
		{
			log.debug("Opening file");

			fis = new FileInputStream(CommonClass.DATA_PATH);
			//Workbook wb= WorkbookFactory.create(fis);
			wb= WorkbookFactory.create(fis);
			//Sheet sheet = wb.getSheet(CommonClass.SHEET);
			sheet = wb.getSheet(CommonClass.SHEET);
			
			//int iCount = CommonClass.TESTCASES;
			 iCount = CommonClass.TESTCASES;
			vedData = new Object[iCount][2];

			vedData = ComboAppData.getData(sheet, iCount);
			    	
			
		}
		catch(Exception ex)
		{
			log.error("Exception:" + ex.getMessage());
			log.error(BaseClass.getStackTrace(ex));
		}
		finally
		{
			if(fis != null)
			{
				try 
				{ 
					fis.close(); 
				}
				catch(Exception ex)
				{
					
				}
			}
		}
		return vedData;
	}

	public static String getExcelCellValue(Row row, int iCell)
	{
		String sRetValue = "";
		try
		{
			//if(row.getCell(iCell).getCellType()==1)
			if(row.getCell(iCell).getRowIndex()==1)
				sRetValue = row.getCell(iCell).getStringCellValue().trim();
			else
				sRetValue = String.valueOf((long)row.getCell(iCell).getNumericCellValue()).trim();
			    
			    
		}
		catch(NullPointerException ex) 
		{
			
		}

		return sRetValue;
	}
	
	}

