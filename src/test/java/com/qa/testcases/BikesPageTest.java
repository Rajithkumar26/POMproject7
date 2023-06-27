package com.qa.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.Base.ParentClass;
import com.qa.BusinessPages.HomePageClass;
import com.qa.BusinessPages.NewBikesPageClass;

public class BikesPageTest extends ParentClass{

public HomePageClass homepage;
public NewBikesPageClass newbikespageclass;
	
	public BikesPageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeMethod
	public void setUp() throws IOException {
		initiaizationMethod();
		homepage= new HomePageClass();
		newbikespageclass= new NewBikesPageClass();
	}
	
	@Test
	public void ClickingOnTVSBikeLogo() throws IOException {
		homepage.FindNewBike();
		newbikespageclass.TVSBike();
	}
	

	@AfterMethod
	public void flushMethod() {
		CloseBrowser();
	}
}
