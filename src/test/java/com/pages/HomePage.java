package com.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends MicrosoftBasePage{
	
	@FindBy(id = "shellmenu_1") private WebElement Office;
	@FindBy(id = "shellmenu_2") private WebElement Windows;
	@FindBy(id = "shellmenu_3") private WebElement Surface;
	@FindBy(id = "shellmenu_4") private WebElement Xbox;
	@FindBy(id = "shellmenu_5") private WebElement Deals;
	@FindBy(id = "l1_support") private WebElement Support;
	
	public HomePage(WebDriver driver) {
		super(driver);
		//Initialize Elements	
	    PageFactory.initElements(driver, this);
	    
	}	
	
	public WebElement getOffice() {
		return Office;
	}

	public WebElement getWindows() {
		return Windows;
	}

	public WebElement getSurface() {
		return Surface;
	}

	public WebElement getXbox() {
		return Xbox;
	}

	public WebElement getDeals() {
		return Deals;
	}

	public WebElement getSupport() {
		return Support;
	}
	
	public void validateMenuItems() {
		assertEquals(getOffice().getText(), "Office");
		assertEquals(getWindows().getText(), "Windows");
		assertEquals(getSurface().getText(), "Surface");
		assertEquals(getXbox().getText(), "Xbox");
		assertEquals(getDeals().getText(), "Deals");
		assertEquals(getSupport().getText(), "Support");
	}
}
