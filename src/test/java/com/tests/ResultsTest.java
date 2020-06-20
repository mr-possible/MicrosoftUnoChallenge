package com.tests;

import org.testng.annotations.Test;

import com.pages.WindowsPage;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

import com.pages.ResultsPage;

public class ResultsTest {
	WebDriver driver;
	ResultsPage rp;
	String ResultsPage = "https://www.microsoft.com/en-us/search?q=visual+studio";
	@BeforeMethod
	public void beforeMethod() {
		driver = new ChromeDriver();
		rp = new ResultsPage(driver);
		driver.get(ResultsPage);
		driver.manage().window().maximize();
	}

	@Test
	public void f() {
		
		System.out.println("**************************************************");
		int j=0;
		while( j<3) {
			System.out.println(rp.getprices().get(j).getText().replaceAll("\\n", "").trim().toLowerCase().replace("from  ", ""));
			j++;
		}
		rp.firstPrice = rp.getprices().get(0).getText().replaceAll("\\n", "").trim().toLowerCase().replace("from  ", "");
		rp.getprices().get(0).click();
	}

	@AfterMethod
	public void afterMethod() {
	}

}
