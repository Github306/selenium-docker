package com.vinsguru.tests.flightreservation;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.vinsguru.pages.flightreservation.FlightConfirmationPage;
import com.vinsguru.pages.flightreservation.FlightsSearchPage;
import com.vinsguru.pages.flightreservation.FlightsSelectionPage;
import com.vinsguru.pages.flightreservation.RegistrationConfirmationPage;
import com.vinsguru.pages.flightreservation.RegistrationPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlightReservationTest {
	
	private WebDriver driver;
	
	@BeforeTest
	public void setDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	@Test
	public void userRegistrationTest() {
		RegistrationPage registrationPage = new RegistrationPage(driver);
		registrationPage.goTo("https://d1uh9e7cu07ukd.cloudfront.net/selenium-docker/reservation-app/index.html");
		Assert.assertTrue(registrationPage.isAt());
		
		registrationPage.enterUserDetails("selenium", "Docker");
		registrationPage.enterUserCredentials("selenium@docker.com", "docker");
		registrationPage.enterAddress("123 main street", "Atlanta", "30001");
		registrationPage.register();		
	}

	@Test(dependsOnMethods="userRegistrationTest")
	public void registrationConfirmationTest() {
		
		RegistrationConfirmationPage registrationConfirmationPage = new RegistrationConfirmationPage(driver);
		Assert.assertTrue(registrationConfirmationPage.isAt());
		registrationConfirmationPage.goToFlightsSearch();
	}
		
	@Test(dependsOnMethods="registrationConfirmationTest")
	public void flightsSearchTest() {
		FlightsSearchPage flightsSearchPage = new FlightsSearchPage(driver);
		Assert.assertTrue(flightsSearchPage.isAt());
		flightsSearchPage.selectPassengers("3");
		flightsSearchPage.searchFlights();			
	}
	
	@Test(dependsOnMethods="flightsSearchTest")
	public void flightsSelectionTest() {
		FlightsSelectionPage flightsSelectionPage = new FlightsSelectionPage(driver);
		Assert.assertTrue(flightsSelectionPage.isAt());
		flightsSelectionPage.selectFlights();
		flightsSelectionPage.confirmFlights();		
	}
	
	@Test(dependsOnMethods="flightsSelectionTest")
	public void flightsReservationConfirmationTest() {
		FlightConfirmationPage flightConfirmationPage = new FlightConfirmationPage(driver);
		Assert.assertTrue(flightConfirmationPage.isAt());
		Assert.assertEquals(flightConfirmationPage.getPrice(), "$1169 USD");		
	}
	
	@AfterTest
	public void quitDriver() {
		driver.quit();
	}
	
		
}
