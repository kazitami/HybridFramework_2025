package com.tutorialsNinja.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class searchProductPage {

	public WebDriver driver;
	
	@FindBy(linkText = "HP LP3065")
	private WebElement validProduct;
	
	@FindBy(xpath = "//p[text()='There is no product that matches the search criteria.']")
	private WebElement invalidProductMessage;
	
	public searchProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyValidProductPresence() {
		boolean displayStatus= validProduct.isDisplayed();
		return displayStatus;
	}
	
	public boolean verifyInvalidProductPresence() {
		boolean displayStatus= invalidProductMessage.isDisplayed();
		return displayStatus;
	}
	
}
