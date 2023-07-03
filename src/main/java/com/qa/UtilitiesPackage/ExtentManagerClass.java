package com.qa.UtilitiesPackage;

import java.io.File;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManagerClass {

	public static ExtentReports extentreports;
	public static ExtentReports getInstance() {
		if(extentreports==null)
		{	extentreports= new ExtentReports("C:\\Users\\Vaibhav\\eclipse-workspace\\POMproject7\\HtmlReports\\extentrep.html", true, DisplayOrder.OLDEST_FIRST);
		(extentreports) .loadConfig(new File("C:\\Users\\Vaibhav\\eclipse-workspace\\POMproject7\\src\\test\\ExtentConfig\\ReportsConfig.xml"));
		}
		return extentreports; 
	}
	
}
