package com.vinsguru.pages.vendorportal;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.vinsguru.pages.AbstractPage;

public class DashboardPage extends AbstractPage{

	private By monthlyEarningElement = By.id("monthly-earning");
	private By annualEarningElement = By.id("annual-earning");
	private By profitMarginElement = By.id("profit-margin");
	private By availableInventoryElement = By.id("available-inventory");
	private By searchInput = By.cssSelector("#dataTable_filter input");
	private By searchResultsCountElement = By.id("dataTable_info");
	private By userProfilePictureElement = By.cssSelector("img.img-profile");
	private By logoutLink = By.cssSelector("i.fa-sign-out-alt");
	private By modalLogoutButton = By.cssSelector("#logoutModal a");
		
	public DashboardPage(WebDriver driver) {
		super(driver);
	}
	
	@Override
	public boolean isAt() {
		wait.until(ExpectedConditions.visibilityOf(getElement(monthlyEarningElement)));
		return getElement(monthlyEarningElement).isDisplayed();
	}

	
	public String getMonthlyEarning() {
		return getElement(monthlyEarningElement).getText();
	}
	
	public String getAnnualEarning() {
		return getElement(annualEarningElement).getText();
	}
	
	public String getProfitMargin() {
		return getElement(profitMarginElement).getText();
	}
	
	public String getAvailableInventory() {
		return getElement(availableInventoryElement).getText();
	}
	
	public void searchOrderHistoryBy(String keyword) {
		getElement(searchInput).sendKeys(keyword);		
	}
	
	public int getSearchResultsCount() {
		wait.until(ExpectedConditions.visibilityOf(getElement(searchResultsCountElement)));
		String resultsText = getElement(searchResultsCountElement).getText();
		String[] arr = resultsText.split(" ");
		int count = Integer.parseInt(arr[5]);
		//if (arr[4].contentEquals("of"))
			return count;			
	}
	
	public LoginPage logout() {
		elementDDClick(userProfilePictureElement,logoutLink);
		wait.until(ExpectedConditions.visibilityOf(getElement(modalLogoutButton)));
		getElement(modalLogoutButton).click();
		return new LoginPage(driver);
	}
	
}
