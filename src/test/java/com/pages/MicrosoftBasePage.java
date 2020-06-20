package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MicrosoftBasePage extends MicrosoftBase{
	WebDriver driver;
	WebDriverWait ewait;
	public static String firstPrice;
	
	public MicrosoftBasePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}	

	@Override
	protected WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	protected void selectFromSelectElement(WebElement element, String value) {
		Select sele = new Select(element);
		sele.selectByValue(value);
	}

}
