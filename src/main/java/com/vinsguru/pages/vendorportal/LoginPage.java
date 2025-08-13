package com.vinsguru.pages.vendorportal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.vinsguru.pages.AbstractPage;

public class LoginPage extends AbstractPage {

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//Vendor Portal - https://d1uh9e7cu07ukd.cloudfront.net/selenium-docker/vendor-app/index.html	
	//sam  //mike
	
	private By usernameInput = By.id("username");
	private By passwordInput = By.id("password");
	private By loginButton = By.id("login");
	
	public void goTo(String url) {
		driver.get(url);
	}
	
	@Override
	public boolean isAt() {
		wait.until(ExpectedConditions.visibilityOf(getElement(loginButton)));
		return getElement(loginButton).isDisplayed();
	}	
		
		
	public DashboardPage login(String userName, String password) {
		sendElementKeys(usernameInput,userName);
		sendElementKeys(passwordInput,password);	
		getElement(loginButton).click();
		return new DashboardPage(driver);
	}	
	
}


