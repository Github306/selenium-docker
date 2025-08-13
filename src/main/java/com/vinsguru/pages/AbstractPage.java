package com.vinsguru.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;


public abstract class AbstractPage {
	
	protected final WebDriver driver;
	protected final WebDriverWait wait;
		
	Actions act;
		
	public AbstractPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));		
		act = new Actions(driver);
	}
	
	public void elementDDClick(By elementDD, By selectElement) {
		act.click(getElement(elementDD)).moveToElement(getElement(selectElement)).click().build().perform();		
	}
	
	public void sendElementKeys(By locator, String inputData) {
		driver.findElement(locator).sendKeys(inputData);
	}
	
	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator); 
	}
	
	public abstract boolean isAt();

}
