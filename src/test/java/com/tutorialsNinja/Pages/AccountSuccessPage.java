package com.tutorialsNinja.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSuccessPage {
public WebDriver driver;

@FindBy(xpath = "//h1[contains(text(),'Your Account Has Been Created!')]")
private WebElement accounthasbeencreatd;

public AccountSuccessPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
}

public boolean accountHasBeenCreated() {
	boolean displayStatus = accounthasbeencreatd.isDisplayed();
	return displayStatus;
}

}
