package lib;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import comboAppPages.ComboAppBasePage;
//import iOnePages.IoneBasePage;

public class ComboAppData extends CommonExcel
{
		   public int  iTestCaseID;
		
		public  String sGender;
		public  String sTobacoUser;
		public   String sName;
		public  String sDOB;
		public  String sPopUp;
		public  String sMobileNO;
		public  String sEmail;
		
		public  String sPremiumType;
		public  String sAnuallIncome;
		public  String sAnualIncmeAmt;
		//public  String sAnualIncmeAmt;
		public  String sPolicyPeriod;
		public  String sPolicyPremium;
		public  String sQualification;
		public  String sCovrageAmt;
		public  String sCovrageAddon;
		public  String sPanNo;
		public  String sPincode;
		public  String sCardno;
		public String sMonthcreitcrd;
		public String sYearcrdtcard;
		public String sCvvnocredtcard;
		
		public String saddline1;
		public String saddline2;
		public String saddLandmark;	
		public String sAddharno;	
		public String sMaritialStatus;	
		public String sweightd;
		public String sHeightselctFt;
		public String sHeightselctinch;
		public  String sFatherName;	
		public String sMotherName;
				
		public String sNominGender;
		public  String sNomineeDOb;
		public  String sProposalSecStatus;
		public  String sSecPremium;
		public  String sProposalPremium;
		public  String sSumAssured;
		public  String sPremium;
		public  String sServiceTax;
		public  String sTPremium;
		
		public  ComboAppData plan = null;
		public  Row row;
		//public static int startline = 1;
		public static int startline = 1;	

	public static Object[][] getData(Sheet sheet, int iCount) throws Exception
	{
		Object [][] vedData = new Object[iCount][2];
		ComboAppData plan = null;

		for(int i = 0; i < iCount; i++)
		{
			plan = new ComboAppData();

			
			Row iRow= sheet.getRow(i + startline);
			plan.iTestCaseID=i+1;
							
			plan.sGender  					= CommonExcel.getExcelCellValue(iRow, 0);
			plan.sTobacoUser				    = CommonExcel.getExcelCellValue(iRow, 1);
			plan.sName			           = CommonExcel.getExcelCellValue(iRow, 2);
			plan.sDOB			            = CommonExcel.getExcelCellValue(iRow, 3);
			plan.sPopUp                    = CommonExcel.getExcelCellValue(iRow, 4);
			plan.sMobileNO					= CommonExcel.getExcelCellValue(iRow, 5);
			plan.sEmail					= CommonExcel.getExcelCellValue(iRow, 6);
		    plan.sPremiumType				= CommonExcel.getExcelCellValue(iRow, 7);
			plan.sAnuallIncome		            = CommonExcel.getExcelCellValue(iRow, 8);
			plan.sAnualIncmeAmt			            = CommonExcel.getExcelCellValue(iRow, 9);
			plan.sPolicyPeriod                       = CommonExcel.getExcelCellValue(iRow, 10);
			plan.sPolicyPremium 			            = CommonExcel.getExcelCellValue(iRow, 11);
			plan.sQualification				        = CommonExcel.getExcelCellValue(iRow, 12);
			plan.sCovrageAmt                       = CommonExcel.getExcelCellValue(iRow, 13);
		    plan.sCovrageAddon			    = CommonExcel.getExcelCellValue(iRow, 14);
			plan.sPanNo 			    = CommonExcel.getExcelCellValue(iRow, 15);
			plan.sPincode                 = CommonExcel.getExcelCellValue(iRow, 16);
			//plan.sAnnuityAge				= CommonExcel.getExcelCellValue(iRow, 15);
			plan.sCardno				= CommonExcel.getExcelCellValue(iRow, 17);
			plan.sMonthcreitcrd 				    = CommonExcel.getExcelCellValue(iRow, 18);	
			plan.sYearcrdtcard			    = CommonExcel.getExcelCellValue(iRow, 19);
			
			plan.sCvvnocredtcard		    = CommonExcel.getExcelCellValue(iRow, 20);	
			plan.saddline1          = CommonExcel.getExcelCellValue(iRow,21);	
			plan.saddline2		    = CommonExcel.getExcelCellValue(iRow,22);
			plan.saddLandmark                 = CommonExcel.getExcelCellValue(iRow,23);	
			plan.sAddharno		        = CommonExcel.getExcelCellValue(iRow,24);
			plan.sMaritialStatus		            = CommonExcel.getExcelCellValue(iRow,25);
			plan.sweightd		            = CommonExcel.getExcelCellValue(iRow,26);
			
			plan.sHeightselctFt		            = CommonExcel.getExcelCellValue(iRow,27);
			plan.sHeightselctinch		            = CommonExcel.getExcelCellValue(iRow,28);
			plan.sFatherName		            = CommonExcel.getExcelCellValue(iRow,29);
			plan.sMotherName		            = CommonExcel.getExcelCellValue(iRow,30);
			plan.sNominGender		            = CommonExcel.getExcelCellValue(iRow,31);
		    plan.sNomineeDOb                     = CommonExcel.getExcelCellValue(iRow,32);                                 
			
												
										
			vedData[i][0] = plan.iTestCaseID;
			vedData[i][1] = plan;
		}

		return vedData;
	}

	@Override
	public String toString() 
	{
		return "ComboAppData [iTestCaseID=" + iTestCaseID + ", sGender="
				+ sGender + ", sTobacoUser=" + sTobacoUser
				+ ", sName=" + sName + ", sDOB=" + sDOB + ",sPopUp=" + sPopUp
				+ ", sMobileNO=" + sMobileNO + ", sEmail=" + sEmail +", sPremiumType=" + sPremiumType + ", sAnuallIncome=" + sAnuallIncome + ","
						+ "sAnualIncmeAmt=" + sAnualIncmeAmt + ",sPolicyPeriod=" + sPolicyPeriod + ", sPolicyPremium=" + sPolicyPremium + 
						",sQualification=" + sQualification + ",sCovrageAmt=" + sCovrageAmt + ",sCovrageAddon=" + sCovrageAddon + ",sPanNo=" + sPanNo 
				+ ",sPincode=" + sPincode + " , sCardno =" + sCardno + ", sMonthcreitcrd=" + sMonthcreitcrd
				+ ", sYearcrdtcard =" + sYearcrdtcard + ", sCvvnocredtcard="
				+ sCvvnocredtcard + ", saddline1=" + saddline1 + ",saddline2="
				+ saddline2 + ", saddLandmark=" + saddLandmark + ",sAddharno="
				+ sAddharno + ", sMaritialStatus=" + sMaritialStatus +",sweightd="
				+ sweightd  + ", sHeightselctFt =" + sHeightselctFt +",sHeightselctinch="
				+ sHeightselctinch + ", sFatherName=" + sFatherName + ", sMotherName="
				+ sMotherName +", sNominGender="+ sNominGender +",sNomineeDOb="+ sNomineeDOb +"]";
	}

}
