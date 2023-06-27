package com.qa.BusinessPages;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.Base.ParentClass;

public class HomePageClass extends ParentClass {


	@FindBy(id="txt_lg_search")
	WebElement searchBar;
	
	@FindBy(xpath="//*[text()='Find a Car ']")
	WebElement FindACarDropdown;
	
	@FindBy(xpath="//*[text()='Find a Bike ']")
	WebElement FindABikeDropdown;
	
	@FindBy(xpath="(//*[text()='New Cars'])[1]")
	WebElement NewCarOption;
	
	@FindBy (xpath="(//*[text()='Bikes'])[1]")
	WebElement BikesUnderFindAoption;

	public HomePageClass() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}
	
	public NewCarsPage SearchForAutomobile() {
		searchBar.sendKeys("Range Rover");
		searchBar.sendKeys(Keys.ENTER);
	return new NewCarsPage();
	}
	
	public NewCarsPage FindaCar() {
	new Actions(driver).moveToElement(FindACarDropdown).build().perform();
	NewCarOption.click();
	return new NewCarsPage();
	}
	
	public NewBikesPageClass FindNewBike() throws IOException {
		new Actions(driver).moveToElement(FindABikeDropdown).build().perform();
	BikesUnderFindAoption.click();	
	return new NewBikesPageClass();
	}
	
	
}
