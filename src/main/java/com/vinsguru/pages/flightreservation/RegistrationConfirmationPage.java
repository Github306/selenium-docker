package com.vinsguru.pages.flightreservation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.vinsguru.pages.AbstractPage;

public class RegistrationConfirmationPage extends AbstractPage{
	
	//WebDriver driver;
	private By goToFlightsSearchButton = By.id("go-to-flights-search");
	
	public RegistrationConfirmationPage(WebDriver driver) {
		super(driver);
	}
	
	public void goToFlightsSearch() {
		getElement(goToFlightsSearchButton).click();
	}

	@Override
	public boolean isAt() {
		wait.until(ExpectedConditions.visibilityOf(getElement(goToFlightsSearchButton)));
		return getElement(goToFlightsSearchButton).isDisplayed();
	}
	
}
