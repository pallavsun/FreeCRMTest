package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase {
	
	public static long Page_LOAd_TIME_OUT=30;
	public static long IMPLICIT_WAIT=20;
	
	public static String TESTDATA_SHEET_PATH="C:\\Users\\Lenovo\\eclipse-workspace\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\testdata\\FreeCrmTestdata.xlsx";
	
	static Workbook book;
	static org.apache.poi.ss.usermodel.Sheet sheet; 
	
	
	public void switchToFrame()
	{
		driver.switchTo().frame("mainpanel");
	}
	
	
	public static Object[][] getTestData(String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream file=null;
		
	try
	{
		file=new FileInputStream(TESTDATA_SHEET_PATH);
	}
	
	catch(FileNotFoundException e)
	{
		e.printStackTrace();
	}
	
	try {
		
		book=WorkbookFactory.create(file);
	} catch (InvalidFormatException e) {
		e.printStackTrace();
	}
	catch (IOException e) {
	e.printStackTrace();
	}
	
	sheet=book.getSheet(sheetName);
	Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	
       for(int i=0;i<sheet.getLastRowNum();i++)
       {
    	   for(int k=0;k<sheet.getRow(0).getLastCellNum();k++)
    	   {
    		   data[i][k]=sheet.getRow(i+1).getCell(k).toString();
    	   }
       }
	
	
	return data;
		
	}
	
	
	
  //==================Screenshot Code=======================
	
	public static void takeScreenshotAtEndOfTest() throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File srcFile=ts.getScreenshotAs(OutputType.FILE);
		String currentDir=System.getProperty("user.dir");
		
		FileUtils.copyFile(srcFile, new File(currentDir+"/screenshot/"+System.currentTimeMillis()+".png"));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
