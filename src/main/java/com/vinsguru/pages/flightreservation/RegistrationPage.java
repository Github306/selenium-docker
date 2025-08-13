package com.vinsguru.pages.flightreservation;

//import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.vinsguru.pages.AbstractPage;

public class RegistrationPage extends AbstractPage{
	
	//private WebDriver driver;
	
	private By firstNameInput = By.id("firstName");
	private By lastNameInput = By.id("lastName");
	private By emailInput = By.id("email");
	private By passwordInput = By.id("password");
	private By streetInput = By.name("street");
	private By cityInput = By.name("city");
	private By zipInput = By.name("zip");
	private By registerButton = By.id("register-btn");
	
	public RegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	public void goTo(String url) {
		driver.get(url);
	}
	
	@Override
	public boolean isAt() {
		wait.until(ExpectedConditions.visibilityOf(getElement(firstNameInput)));
		return getElement(firstNameInput).isDisplayed();
	}	
		
	public void enterUserDetails(String firstName, String lastName) {
		sendElementKeys(firstNameInput,firstName);
		sendElementKeys(lastNameInput,lastName);		
	}
	
	public void enterUserCredentials(String email, String password) {
		sendElementKeys(emailInput,email);
		sendElementKeys(passwordInput,password);		
	}
	
	public void enterAddress(String street, String city, String zip) {
		sendElementKeys(streetInput,street);
		sendElementKeys(cityInput,city);	
		sendElementKeys(zipInput,zip);	
	}
	
	public void register() {
		driver.findElement(registerButton).click();
	}
		
	
	
//Flight Reservation - https://d1uh9e7cu07ukd.cloudfront.net/selenium-docker/reservation-app/index.html
//Vendor Portal - https://d1uh9e7cu07ukd.cloudfront.net/selenium-docker/vendor-app/index.html	
	
	
}
