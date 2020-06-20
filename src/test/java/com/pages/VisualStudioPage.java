package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VisualStudioPage extends MicrosoftBasePage {
private WebDriver driver;
	
	@FindBy(xpath = "//div[@id='ProductPrice_productPrice_PriceContainer']/span")
	private WebElement detailsPrice;
	@FindBy(xpath = "//*[@id='buttonPanel_AddToCartButton']") 
	private WebElement btnAddCart;
	@FindBy(css = "button[data-m*='{\\\"cN\\\":\\\"R1MarketRedirect-cancel\\\",\\\"id\\\":\\\"nn1c2m1r1a']")
	private WebElement cancelAlert;
	
	
	public VisualStudioPage(WebDriver driver) {
		super(driver);
		//Initialize Elements	
		this.driver = driver;
	    PageFactory.initElements(driver, this);
	    
	}	
	
	public WebElement getDetailsPrice() {
		return detailsPrice;
	}
	
	public WebElement getBtnAddCart() {
		return btnAddCart;
	}
	
	public WebElement getCancelAlert() {
		return cancelAlert;
	}
	
	public void closeAlert() {
		driver.switchTo().activeElement();
		getCancelAlert().click();
		driver.switchTo().activeElement();
	}
}
