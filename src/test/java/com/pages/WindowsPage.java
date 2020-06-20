package com.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WindowsPage extends MicrosoftBasePage {
private WebDriver driver;
	
	@FindBy(css = "button#c-shellmenu_50") private WebElement btnWin10;
	@FindBy(css = "ul[data-m*='{\\\"cN\\\":\\\"Windows10_cont']") private List<WebElement> ddWin10;
	@FindBy(id = "search") private WebElement btnSearch;
	@FindBy(name = "q") private WebElement inputSearch;
	
	public WindowsPage(WebDriver driver) {
		super(driver);
		//Initialize Elements	
		this.driver = driver;
	    PageFactory.initElements(driver, this);
	    
	}	
	
	public WebElement getBtnWin10() {
		return btnWin10;
	}
	
	public List<WebElement> getDdWin10() {
		return ddWin10;
	}
	
	public WebElement getBtnSearch() {
		return btnSearch;
	}
	
	public WebElement getInputSearch() {
		return inputSearch;
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
}
