package com.vinsguru.pages.flightreservation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.vinsguru.pages.AbstractPage;

public class FlightsSearchPage extends AbstractPage {

	private By passengerSelect = By.id("passengers");
	private By searchFlightsButton = By.id("search-flights");
	Select passengers;
		
	public FlightsSearchPage(WebDriver driver) {
		super(driver);
	}
	
	@Override
	public boolean isAt() {
		wait.until(ExpectedConditions.visibilityOf(getElement(passengerSelect)));
		return getElement(passengerSelect).isDisplayed();
	}
	
	public void selectPassengers(String noOfPassengers) {
		passengers = new Select(getElement(passengerSelect));
		passengers.selectByValue(noOfPassengers);				
	}

	public void searchFlights() {
		getElement(searchFlightsButton).click();
	}
	
}
