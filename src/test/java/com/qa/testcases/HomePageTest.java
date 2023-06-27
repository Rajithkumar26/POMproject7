package com.qa.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.Base.ParentClass;
import com.qa.BusinessPages.HomePageClass;

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
	
	@Test
	public void SearchingForAutomobileMethod() {
		homepage.SearchForAutomobile();
	}
	
	@Test
	public void FindforACarMethod() {
		homepage.FindaCar();
	}
	
	@Test(priority=0)
	public void FindForBikeMethod() {
		homepage.FindNewBike();
	}
	
	@AfterMethod
	public void flushMethod() {
		CloseBrowser();
	}
}
