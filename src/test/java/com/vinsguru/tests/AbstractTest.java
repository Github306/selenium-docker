package com.vinsguru.tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.vinsguru.pages.vendorportal.DashboardPage;
import com.vinsguru.pages.vendorportal.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AbstractTest {
	
	protected WebDriver driver;
	protected LoginPage loginPage;
	protected DashboardPage dashboardPage;
	
	public AbstractTest() {
		WebDriverManager.chromedriver().setup();
		this.driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));		
		
		//LoginPage loginPage = new LoginPage(driver);
		
	}
	
	@BeforeTest
	public void setDriver() {
		
	}
	
	@AfterTest
	public void quitDriver() {
		driver.quit();
	}
}
