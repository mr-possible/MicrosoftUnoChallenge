package com.tests;

import org.testng.annotations.Test;

import com.pages.HomePage;

import org.testng.annotations.BeforeSuite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;

public class TestBase {
	WebDriver driver;
	String homePage = "https://www.microsoft.com/en-us/";//"https://www.microsoft.com/en-us/windows/";//"https://www.microsoft.com/en-us/";
	
	@BeforeSuite
	public void Setup() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/webdrivers/chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.get(homePage);
		driver.manage().window().maximize();
	}

	@AfterSuite
	public void afterSuite() {
	}

}
