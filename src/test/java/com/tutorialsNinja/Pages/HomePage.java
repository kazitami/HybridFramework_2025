package com.tutorialsNinja.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	//in the Page class, we will define the WebElements, we will initialize the WebElements and we will create actions for those WebElements
	
	public WebDriver driver;
	
	@FindBy(linkText = "My Account")
	private WebElement myAccountDropdown;
	
	@FindBy(linkText = "Login")
	private WebElement loginOption;
	
	@FindBy (linkText = "Register")
	private WebElement registerOption;
	
	//SearchProduct
	@FindBy(name = "search")
	private WebElement searchTextbox; 
	
	@FindBy(css = "button.btn.btn-default.btn-lg")
	private WebElement searchButton;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public LoginPage combiningTwoActionToNavigateToLoginPage() {
		myAccountDropdown.click();
		loginOption.click();
		return new LoginPage(driver);
	}
	
	public RegisterPage combiningTwoActionToNavigateToRegisterPage() {
		myAccountDropdown.click();
		registerOption.click();
		return new RegisterPage(driver);
	}
	

	public void enterProductName(String validProductText) {
		searchTextbox.sendKeys(validProductText);
	}
	
	public void clickOnSearchButton() {
		searchButton.click();
	}
	
	public searchProductPage navigateTosearchProductPage(String validProductText) {
		searchTextbox.sendKeys(validProductText);
		searchButton.click();
		return new searchProductPage(driver);
	}
	
}
