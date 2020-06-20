package com.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResultsPage extends MicrosoftBasePage {
private WebDriver driver;
	
	@FindBy(xpath = "//*[@id='R1MarketRedirect-1']/button")
	private WebElement cancelAlert;
	@FindBy(css = "div[aria-label*='software']>div>ul>li>div>a>div>div>div[class='c-price']") 
	private List<WebElement> prices;
	@FindBy(xpath = "//*[@id=\"coreui-productplacement-30l7ywa\"]/div[3]/h2/span") 
	private WebElement lblSoftware;
	
	
	public ResultsPage(WebDriver driver) {
		super(driver);
		//Initialize Elements	
		this.driver = driver;
	    PageFactory.initElements(driver, this);
	    
	}	
	
	public WebElement getCancelAlert() {
		return cancelAlert;
	}
	
	public List<WebElement> getprices() {
		return prices;
	}
	
	public WebElement getLblSoftware() {
		return lblSoftware;
	}
	
	public void closeAlert() {
		driver.switchTo().activeElement();
		getCancelAlert().click();
		driver.switchTo().activeElement();
	}
	
	public void print3Prices() {
		System.out.println("**************************************************");
		int j=0;
		while( j<3) {
			System.out.println(getprices().get(j).getText().replaceAll("\\n", "").trim().toLowerCase().replace("from  ", ""));
			j++;
		}
	}
	
	public void keepingPriceToCompare() {
		firstPrice = getprices().get(0).getText().replaceAll("\\n", "").trim().toLowerCase().replace("from  ", "");
	}
}
