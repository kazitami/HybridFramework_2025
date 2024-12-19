package com.tutorialsNinja.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tutorialsNinja.Utilities.Util;

public class RegisterPage {

	public WebDriver driver;
	
	@FindBy(id = "input-firstname")
	private WebElement enterFirstnameTextbox;
	
	@FindBy(id = "input-lastname")
	private WebElement enterLastnameTextbox;
	
	@FindBy(id = "input-email")
	private WebElement enterEmailTextbox;
	
	@FindBy(id = "input-telephone")
	private WebElement enterTelephoneTextbox;
	
	@FindBy(id = "input-password")
	private WebElement enterPasswordTextbox;
	
	@FindBy(id = "input-confirm")
	private WebElement enterConfirmPasswordTextbox;
	
	@FindBy(xpath ="//input[@name='newsletter' and @value='1']")
	private WebElement subscribeYesRadioButton;
	
	@FindBy(xpath = "//input[@name='agree' and @value='1']")
	private WebElement privacyPolicyCheckbox;
	
	@FindBy(css = "input.btn.btn-primary")
	private WebElement continueButton;
	
	//-------------------------------------------------------
	@FindBy(css = "#input-firstname+div")
	private WebElement firstNameWarningMessage;
	
	@FindBy(css = "#input-lastname+div")
	private WebElement lastNameWarningMessage;
	
	@FindBy(css = "#input-email+div")
	private WebElement EmailAddressWarningMessage;
	
	@FindBy(css = "#input-telephone+div")
	private WebElement telephoneNumberWarningMessage;
	
	@FindBy(css = "#input-password+div")
	private WebElement passwordWarningMessage;
	
	@FindBy(css = "#input-confirm+div")
	private WebElement passwordNotMatchingWarningMessage;
	
	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	private WebElement existingEmailWarningMessage;
	
	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	private WebElement privacyPolicyWarningMessage;
	
	
	//-------------------------------------------------------
	
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterFirstName(String firstnameTest) {
		enterFirstnameTextbox.sendKeys(firstnameTest);
	}
	
	public void enterLastName(String lastnameText) {
		enterLastnameTextbox.sendKeys(lastnameText);
	}
	
	public void enterEmail(String emailText) {
		enterEmailTextbox.sendKeys(emailText);
	}
	
	public void enterTelephone(String telephoneNumber) {
		enterTelephoneTextbox.sendKeys(telephoneNumber);
	}
	
	public void enterPassword(String passwordText) {
		enterPasswordTextbox.sendKeys(passwordText);
	}
	
	public void enterConfirmPassword(String confirmPasswordText) {
		enterConfirmPasswordTextbox.sendKeys(confirmPasswordText);
	}
	
	public void newsLetterRadioButton() {
		subscribeYesRadioButton.click();
	}
	
	public void privacyPolicyCheckbox() {
		privacyPolicyCheckbox.click();
	}
	
	public void clickOnContinueButton() {
		continueButton.click();
	}
	//---------Warning Message---------------
	public String retrievePrivacypolicyWarningMessag() {
		String text = privacyPolicyWarningMessage.getText();
		return text;
	}
	
	public String retrieveFirstnameWarningMessag() {
		String text = firstNameWarningMessage.getText();
		return text;
	}
	
	public String retrieveLastnameWarningMessag() {
		String text = lastNameWarningMessage.getText();
		return text;
	}
	
	public String retrieveEmailWarningMessag() {
		String text = EmailAddressWarningMessage.getText();
		return text;
	}
	
	public String retrieveTelephoneWarningMessag() {
		String text = telephoneNumberWarningMessage.getText();
		return text;
	}
	
	public String retrievePasswordWarningMessag() {
		String text = passwordWarningMessage.getText();
		return text;
	}
	public String retrievePasswordNotMatchWarningMessag() {
		String text = passwordNotMatchingWarningMessage.getText();
		return text;
	}
	
	
	public String retrieveExistingEmailWarningMessag() {
		String text = existingEmailWarningMessage.getText();
		return text;
	}
	//---------------------------------------
	
	
	public AccountSuccessPage combiningMandatoryDetailsToNavigateToAccountSuccessPage(String 
	firstnameTest,String lastnameText,String emailText,String 
	telephoneNumber,String passwordText, String confirmPasswordText) {
		enterFirstnameTextbox.sendKeys(firstnameTest);
		enterLastnameTextbox.sendKeys(lastnameText);
		enterEmailTextbox.sendKeys(emailText);
		enterTelephoneTextbox.sendKeys(telephoneNumber);
		enterPasswordTextbox.sendKeys(passwordText);
		enterConfirmPasswordTextbox.sendKeys(confirmPasswordText);
		privacyPolicyCheckbox.click();
		continueButton.click();
		return new AccountSuccessPage(driver);
	}
	
	public AccountSuccessPage combiningAllDetailsToNavigateToAccountSuccessPage(String 
			firstnameTest,String lastnameText,String emailText,String 
			telephoneNumber,String passwordText, String confirmPasswordText) {
		
				enterFirstnameTextbox.sendKeys(firstnameTest);
				enterLastnameTextbox.sendKeys(lastnameText);
				enterEmailTextbox.sendKeys(emailText);
				enterTelephoneTextbox.sendKeys(telephoneNumber);
				enterPasswordTextbox.sendKeys(passwordText);
				enterConfirmPasswordTextbox.sendKeys(confirmPasswordText);
				subscribeYesRadioButton.click();
				privacyPolicyCheckbox.click();
				continueButton.click();
				return new AccountSuccessPage(driver);
			}
	
	public AccountSuccessPage combiningRegisterWithExistingEmail(String 
			firstnameTest,String lastnameText,String emailText,String 
			telephoneNumber,String passwordText, String confirmPasswordText) {
		
				enterFirstnameTextbox.sendKeys(firstnameTest);
				enterLastnameTextbox.sendKeys(lastnameText);
				enterEmailTextbox.sendKeys(emailText);
				enterTelephoneTextbox.sendKeys(telephoneNumber);
				enterPasswordTextbox.sendKeys(passwordText);
				enterConfirmPasswordTextbox.sendKeys(confirmPasswordText);
				subscribeYesRadioButton.click();
				privacyPolicyCheckbox.click();
				continueButton.click();
				return new AccountSuccessPage(driver);
			}
	
	public boolean retrieveAllWarningMessages(String expectedPrivacyPolicyWarning,String expectedFirstNameWarning,
		String extectedLastNameWarning, String expectedEmailWarning, String expectedTelephoneWarning,
		String expectedPasswordWarning) {
		
		boolean privacyPolicyWarningStatus = privacyPolicyWarningMessage.getText().contains(expectedPrivacyPolicyWarning);
		boolean firstNameWarningStatus = firstNameWarningMessage.getText().contains(expectedFirstNameWarning);
		boolean lastNameWarningStatus = lastNameWarningMessage.getText().contains(extectedLastNameWarning);
		boolean emailWarningStatus = EmailAddressWarningMessage.getText().contains(expectedEmailWarning);
		boolean telephoneWarningStatus = telephoneNumberWarningMessage.getText().contains(expectedTelephoneWarning);
		boolean passwordWarningStatus = passwordWarningMessage.getText().contains(expectedPasswordWarning);
			
		return privacyPolicyWarningStatus && firstNameWarningStatus && lastNameWarningStatus 
				&& emailWarningStatus && telephoneWarningStatus && passwordWarningStatus;
		
	}
	//------------------------------------------
}
