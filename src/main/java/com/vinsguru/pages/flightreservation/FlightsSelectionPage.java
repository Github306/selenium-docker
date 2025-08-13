package com.vinsguru.pages.flightreservation;

import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.vinsguru.pages.AbstractPage;

public class FlightsSelectionPage extends AbstractPage {
	
	private By departureFlightsOptions = By.name("departure-flight");
	private By arrivalFlightsOptions = By.name("arrival-flight");
	private By confirmFlightsButton = By.id("confirm-flights");
	

	public FlightsSelectionPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isAt() {
		wait.until(ExpectedConditions.visibilityOf(getElement(confirmFlightsButton)));
		return getElement(confirmFlightsButton).isDisplayed();
	}
	
	public void selectFlights(){
		int random = ThreadLocalRandom.current().nextInt(0, getElements(departureFlightsOptions).size());
		getElements(departureFlightsOptions).get(random).click();
		getElements(arrivalFlightsOptions).get(random).click();		
	}

	public void confirmFlights() {
		getElement(confirmFlightsButton).click();
	}
}
