package com.vinsguru.pages.flightreservation;

//import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vinsguru.pages.AbstractPage;

public class FlightConfirmationPage extends AbstractPage{
	
	//private static final Logger log = LoggerFactory.getLogger(FlightConfirmationPage.class);

	By flightConfirmationElement = By.cssSelector("#flights-confirmation-section .card-body .row:nth-child(1) .col:nth-child(2)");
	By totalPriceElement = By.cssSelector("#flights-confirmation-section .card-body .row:nth-child(3) .col:nth-child(2)");
	
	public FlightConfirmationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isAt() {
		wait.until(ExpectedConditions.visibilityOf(getElement(flightConfirmationElement)));
		return getElement(flightConfirmationElement).isDisplayed();
	}

	public String getPrice() {
		String confirmation = getElement(flightConfirmationElement).getText();
		String price = getElement(totalPriceElement).getText();
		//log.info("Flight confirmation# : {}", confirmation);
		//log.info("Total price : {}", price);
		System.out.println("Flight confirmation# : " + confirmation);
		System.out.println("Total price :  " + price);
		return price;
	}
	
}
