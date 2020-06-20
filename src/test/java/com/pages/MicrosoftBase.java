package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class MicrosoftBase {
	WebDriver driver;

	public MicrosoftBase(WebDriver driver) {
		this.driver = driver;
	}
	
	public abstract WebDriver chromeDriverConnection();
	public abstract void navigateTo(String url);
	protected abstract String getPageTitle();
	protected abstract String getPageHeader(By locator);
	protected abstract WebElement getElement(By locator);
	protected abstract void waitElementPresent(WebElement locator);
	protected abstract void waitForPageTitle(String title);
	protected abstract void type(WebElement element, String value);
	protected abstract void click(WebElement element);
	protected abstract void driverQuit();
}
