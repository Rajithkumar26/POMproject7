package com.qa.BusinessPages;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.Base.ParentClass;

public class NewBikesPageClass extends ParentClass {

	@FindBy(xpath="//*[@title=\"Harley Davidson\"]")
	WebElement HarleydavidsonBike;
	
	@FindBy(xpath="//*[@title=\"TVS\"]")
	WebElement TVSBike;
	
	@FindBy(xpath="//*[text()='Search Brand']" )
	WebElement SearchBrandsLink;
	
	@FindBy(xpath= "//*[@id='txtsearchmakename']")
	WebElement SearchBarForBrands;
	
	@FindBy(xpath= "(//a[text()=\"TVS\"])[1]")
	WebElement  SuggestionsForABrand;
	
	public NewBikesPageClass() throws IOException {
		super();
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	
	public TVSHomePage TVSBike() {
		SearchBrandsLink.click();
		SearchBarForBrands.sendKeys("TVS");
		SearchBarForBrands.sendKeys(Keys.ENTER);
		SuggestionsForABrand.click();
		return new TVSHomePage();
	}
	
public HDHomePageClass HarleyDBike() throws IOException {
		
	HarleydavidsonBike.click();
		return new HDHomePageClass();
	}
}
