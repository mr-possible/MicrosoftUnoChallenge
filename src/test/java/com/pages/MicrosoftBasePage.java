package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MicrosoftBasePage extends MicrosoftBase{
	WebDriver driver;
	WebDriverWait ewait;
	public String firstPrice;
	
	public MicrosoftBasePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@Override
	public WebDriver chromeDriverConnection() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/webdrivers/chromedriver.exe");
		
		driver = new ChromeDriver();
		return driver;
	}

	@Override
	public void navigateTo(String url) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected String getPageTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getPageHeader(By locator) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected WebElement getElement(By locator) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void waitElementPresent(WebElement locator) {
		try {
			ewait = new WebDriverWait(driver, 20);
			ewait.until(ExpectedConditions.elementToBeSelected(locator));
		} catch (Exception e) {
			System.out.println("Something went wrong while waitingfor Element: " + locator);
		}
		
	}

	@Override
	protected void type(WebElement element, String value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void click(WebElement element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void driverQuit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void waitForPageTitle(String title) {
		try {
			ewait = new WebDriverWait(driver, 20);
			ewait.until(ExpectedConditions.titleContains(title));
		} catch (Exception e) {
			System.out.println("Something went wrong while waitingfor Element: " + title);
		}
		
	}

}
