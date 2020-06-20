package com.tests;

import org.testng.annotations.Test;

import com.pages.CartPage;
import com.pages.HomePage;
import com.pages.ResultsPage;
import com.pages.VisualStudioPage;
import com.pages.WindowsPage;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class E2ETest {
	private WebDriver driver;
	String homePageURL = "https://www.microsoft.com/en-us/";
	HomePage hp;
	
	@BeforeMethod
	public void setUp() {		
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/webdrivers/chromedriver.exe");
		driver = new ChromeDriver();
		hp = new HomePage(driver);
		
		driver.get(homePageURL);
		driver.manage().window().maximize();
	}

	@Test
	public void f() {
		//HOME PAGE
		hp.validateMenuItems();		
		hp.getWindows().click();			
		WindowsPage wp = new WindowsPage(driver);
		assertTrue(wp.getTitle().contains("Explore Win"));
		
		
		//WINDOWS
		wp.getBtnWin10().click();		
		wp.printDropDownElements();		
		wp.search("Visual Studio");		
		ResultsPage rp = new ResultsPage(driver);		
		
		//RESULTS
		rp.closeAlert();		
		assertTrue(rp.getLblSoftware().getText().contains("Software"));
		rp.print3Prices();
		rp.keepingPriceToCompare();					
		assertTrue(rp.getLblSoftware().getText().contains("Software"));		
		rp.getprices().get(0).click();		
		
		//VISUAL STUDIO
		VisualStudioPage vsp = new VisualStudioPage(driver);
		vsp.getCancelAlert();
		assertEquals(VisualStudioPage.firstPrice, vsp.getDetailsPrice().getText());		
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", vsp.getBtnAddCart());
		
		//CART
		CartPage cp = new CartPage(driver);
		cp.compare3Prices();		
		cp.selectValueFromSelectElement();		
		cp.validatePricex20();	
	}

	@AfterMethod
	public void afterMethod() {
		driver.close();//it closes the window
	}
}
