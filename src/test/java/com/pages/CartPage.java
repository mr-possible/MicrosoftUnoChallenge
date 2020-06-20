package com.pages;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends MicrosoftBasePage{
private WebDriver driver;
	
	//@FindBy(css = "select[aria-label*='Vi']")
	//private Select selectQuantity;
	By selectQuantity = By.cssSelector("select[aria-label*='Vi']");
	@FindBy(css = "strong>span[itemprop='price']") 
	private WebElement lastPrice;
	@FindBy(xpath = "//span[@itemprop='price']") 
	private List<WebElement> cartPrices;
		
	
	public CartPage(WebDriver driver) {
		super(driver);
		//Initialize Elements	
		this.driver = driver;
	    PageFactory.initElements(driver, this);
	    
	}	
	
	public WebElement getSelectQuantity() {
		return getElement(selectQuantity);
	}
	
	public WebElement getLastPrice() {
		return lastPrice;
	}
	
	public List<WebElement> getCartPrices() {
		return cartPrices;
	}
	
	public void compare3Prices() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		assertEquals(getCartPrices().get(0).getText(), getCartPrices().get(1).getText());
		assertEquals(getCartPrices().get(1).getText(), getCartPrices().get(2).getText());
	}
	
	public void selectValueFromSelectElement() {		
		selectFromSelectElement(getSelectQuantity(), "20");
	}
	
	public void validatePricex20() {
		firstPrice = firstPrice.replaceAll("[$,]", "");
		double unitPrice = Double.parseDouble(firstPrice);
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(getLastPrice())));
		
		String lastlast = getLastPrice().getText();
		double lastPrices = Double.parseDouble(lastlast.replaceAll("[$,]", ""));
		System.out.println("unit price: " + (unitPrice*20) + " original 20: " + lastPrices);
		assertEquals(unitPrice*20, lastPrices);
	}
}
