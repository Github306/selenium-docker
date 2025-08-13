package com.vinsguru.tests.vendorportal;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

//import com.vinsguru.pages.vendorportal.DashboardPage;
import com.vinsguru.pages.vendorportal.LoginPage;
import com.vinsguru.tests.AbstractTest;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class VendorPortalTest extends AbstractTest{
	
	//private WebDriver driver;
			
	@Test
	public void loginTest() {
		loginPage = new LoginPage(driver);
		loginPage.goTo("https://d1uh9e7cu07ukd.cloudfront.net/selenium-docker/vendor-app/index.html");
		Assert.assertTrue(loginPage.isAt());
		dashboardPage = loginPage.login("sam","sam");		
	}
	
	@Test(dependsOnMethods="loginTest")
	public void dashboardTest() {
		//DashboardPage dashboardPage = new DashboardPage(driver);
		Assert.assertTrue(dashboardPage.isAt());
		Assert.assertEquals(dashboardPage.getMonthlyEarning(), "$40,000");
		
		dashboardPage.searchOrderHistoryBy("adams");
		//int count = dashboardPage.getSearchResultsCount();
		Assert.assertEquals(dashboardPage.getSearchResultsCount(), 8);
		loginPage = dashboardPage.logout();	
		loginPage.isAt();
	}
	
	

}
