package com.qa.UtilitiesPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Hashtable;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

import com.qa.Base.ParentClass;

public class UtilsClass extends ParentClass{

	public UtilsClass() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public static Date d;
	public static String dateAndTime;
	
	public static String TakeASnap() throws IOException {
		File  src= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		d=  new Date();
		 dateAndTime= d.toString().replaceAll(" ", "_").replaceAll(":", "_");
		String destFile= "C:\\Users\\Vaibhav\\eclipse-workspace\\POMproject7\\Screenshots\\"+dateAndTime+".png";
		FileUtils.copyFile(src, new File(destFile));
		return destFile;
	
	}
	
	@DataProvider(name="dp")
	public Object[][] getData(Method m) {


		String sheetName = m.getName();
		int rows = (Excelfile).getRowCount(sheetName);
		int cols = Excelfile.getColumnCount(sheetName);

		Object[][] data = new Object[rows-1][1];
		
		Hashtable<String,String> table = null;

		for (int rowNum = 2; rowNum <= rows; rowNum++) { // 2

			table = new Hashtable<String,String>();
			
			for (int colNum = 0; colNum < cols; colNum++) {

				// data[0][0]
				table.put(Excelfile.getCellData(sheetName, colNum, 1), Excelfile.getCellData(sheetName, colNum, rowNum));
			
					data[rowNum - 2][0] = table;
			//	data[rowNum - 2][colNum]= Excelfile.getCellData(sheetName, colNum, rowNum);
			}

		}

		return data;
}
}
