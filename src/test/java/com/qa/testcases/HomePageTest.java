package com.qa.testcases;

import java.io.IOException;
import java.util.Hashtable;

import org.bouncycastle.asn1.dvcs.Data;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.Base.ParentClass;
import com.qa.BusinessPages.HomePageClass;
import com.qa.UtilitiesPackage.UtilsClass;

public class HomePageTest extends ParentClass{

	public HomePageClass homepage;
	
	public HomePageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeMethod
	public void setUp() throws IOException {
		initiaizationMethod();
		homepage= new HomePageClass();
		}
	
	@Test(dataProviderClass = UtilsClass.class, dataProvider = "dp")
	public void SearchingForAutomobileMethod(Hashtable<String, String> data) {
		homepage.SearchForAutomobile(data.get("CarBrands"));
	}
	
	@Test(priority=1)
	public void FindforACarMethod() {
		homepage.FindaCar();
	}
	
	@Test(priority=2)
	public void FindForBikeMethod() throws IOException {
		homepage.FindNewBike();
	}
	
	@AfterMethod
	public void flushMethod() {
		CloseBrowser();
	}
}
