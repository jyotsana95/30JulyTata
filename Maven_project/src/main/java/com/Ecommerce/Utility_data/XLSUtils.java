package com.Ecommerce.Utility_data;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLSUtils {

	public static FileInputStream FIS;
	public static XSSFWorkbook  XW;
	public static XSSFSheet  XS;
	public static XSSFRow  XR;
	public static XSSFCell  XC;
	
	
	
	public static int GetRowCount(String xfile, String Xsheet) throws IOException
	
	{
		FIS = new FileInputStream(xfile);
		XW= new XSSFWorkbook(FIS);
		XS = XW. getSheet(Xsheet);
		int RowCount = XS.getLastRowNum();
//		XW.close();
//		FIS.close();
			
		return RowCount;
		
	}
	
public static int GetCellCount(String xfile, String Xsheet,int rownum) throws IOException
	
	{
		FIS = new FileInputStream(xfile);
		XW= new XSSFWorkbook(FIS);
		XS = XW. getSheet(Xsheet);
	    XR = XS.getRow(rownum);
		
		int CELLCount = XR.getLastCellNum();
//		XW.close();
//		FIS.close();
			
		return CELLCount;
		
	}
	

public static String GetCellData(String xfile, String Xsheet,int rownum, int cellnum) throws IOException

{
	FIS = new FileInputStream(xfile);
	XW= new XSSFWorkbook(FIS);
	XS = XW. getSheet(Xsheet);
	
	XR = XS.getRow(rownum);
	XC= XR.getCell(cellnum);
	
	String Data;
	
	try {
		DataFormatter formatter = new DataFormatter();
		String CellData = formatter.formatCellValue(XC);
		return CellData;
	} catch (Exception e) {

          Data = "";
          
	}
	
	

//	XW.close();
//	FIS.close();
		
   return Data;
	
}



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
