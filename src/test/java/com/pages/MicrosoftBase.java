package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class MicrosoftBase {
	WebDriver driver;

	public MicrosoftBase(WebDriver driver) {
		this.driver = driver;
	}
		
	protected abstract WebElement getElement(By locator);
	protected abstract void selectFromSelectElement(WebElement element, String value);
}
