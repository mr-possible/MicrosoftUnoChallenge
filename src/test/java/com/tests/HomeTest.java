package com.tests;

import org.testng.annotations.Test;

import com.pages.HomePage;
import com.pages.WindowsPage;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.ToDoubleBiFunction;

import javax.swing.text.html.ListView;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class HomeTest {
	WebDriver driver;
	String homePage = "https://www.microsoft.com/en-us/";//"https://www.microsoft.com/en-us/windows/";//"https://www.microsoft.com/en-us/";
	HomePage hp;
	
	@BeforeMethod
	public void SetUp() {
		
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/webdrivers/chromedriver.exe");
		
		driver = new ChromeDriver();
		
		hp = new HomePage(driver);
		
		driver.get(homePage);
		driver.manage().window().maximize();
	}

	@Test
	public void f() {
		
		System.out.println(hp.getOffice().getText());
		assertEquals(hp.getOffice().getText(), "Office");
		assertEquals(hp.getWindows().getText(), "Windows");
		assertEquals(hp.getSurface().getText(), "Surface");
		assertEquals(hp.getXbox().getText(), "Xbox");
		assertEquals(hp.getDeals().getText(), "Deals");
		assertEquals(hp.getSupport().getText(), "Support");
		
		hp.getWindows().click();
		
		
		WindowsPage wp = new WindowsPage(driver);
		assertTrue(wp.getTitle().contains("Explore Win"));
	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
	}

}
