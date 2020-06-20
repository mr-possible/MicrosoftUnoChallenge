package com.tests;

import org.testng.annotations.Test;

import com.pages.ResultsPage;
import com.pages.WindowsPage;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class WindowsTest {
	WebDriver driver;
	WindowsPage wp;
	String windowsPage = "https://www.microsoft.com/en-us/windows/";
	
	@BeforeMethod
	public void beforeMethod() {
		driver = new ChromeDriver();
		wp = new WindowsPage(driver);
		driver.get(windowsPage);
		driver.manage().window().maximize();
	}

	@Test
	public void f() {
		wp.waitElementPresent(wp.getBtnWin10());
		wp.getBtnWin10().click();
		
		for(int i = 0; i < wp.getDdWin10().size();i++) {
			System.out.println(wp.getDdWin10().get(i).getText());
		}
		
		wp.getBtnSearch().click();
		wp.getInputSearch().sendKeys("Visual Studio");
		wp.getInputSearch().submit();
		
		driver.switchTo().activeElement();
		
		ResultsPage rp = new ResultsPage(driver);
		rp.waitElementPresent(rp.getCancelAlert());
		rp.getCancelAlert().click();
		driver.switchTo().activeElement();
		
		assertTrue(rp.getLblSoftware().getText().contains("Software"));
	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
	}

}
