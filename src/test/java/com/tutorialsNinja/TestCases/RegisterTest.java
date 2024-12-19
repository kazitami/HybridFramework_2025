package com.tutorialsNinja.TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import java.io.IOException;

import org.testng.annotations.BeforeMethod;

import com.tutorialsNinja.Pages.AccountSuccessPage;
import com.tutorialsNinja.Pages.HomePage;
import com.tutorialsNinja.Pages.LoginPage;
import com.tutorialsNinja.Pages.RegisterPage;
import com.tutorialsNinja.TestBase.TestBase;
import com.tutorialsNinja.Utilities.Util;
import com.tutorialsnNinja.TestData.ExcelCode;

public class RegisterTest extends TestBase{

public RegisterTest() throws IOException {
		super();
	}
	
	public LoginPage loginpage;
	public HomePage homepage;
	public RegisterPage registerpage;
	public AccountSuccessPage accountSuccessPage;

	@BeforeMethod
	public void registerSetup() {
		driver = initializeBrowserAndOpenApplication(prop.getProperty("browser"));
		homepage = new HomePage(driver);
		accountSuccessPage = new AccountSuccessPage(driver);
		registerpage = new RegisterPage(driver);
		registerpage = homepage.combiningTwoActionToNavigateToRegisterPage();
	}
	
	
	@Test(priority=1, dataProvider="TNRegister", dataProviderClass=ExcelCode.class)
	public void registerWithMandatoryFields(String firstname, String lastname,String telephone,String password, String confirmPassword) {
		
		accountSuccessPage = registerpage.combiningMandatoryDetailsToNavigateToAccountSuccessPage(firstname, 
		lastname,Util.emailWithDateTimeStamp() , telephone, password, 
		confirmPassword);
		
		Assert.assertTrue(accountSuccessPage.accountHasBeenCreated());
		
		
	}
	
	@Test(priority=2)
	public void registerWithAllDetails() {
		accountSuccessPage = registerpage.combiningAllDetailsToNavigateToAccountSuccessPage
		(dataProp.getProperty("firstName"), dataProp.getProperty("lastName"),
		Util.emailWithDateTimeStamp(), dataProp.getProperty("telephone"), 
		prop.getProperty("validPassword"), prop.getProperty("validPassword"));
		
		Assert.assertTrue(accountSuccessPage.accountHasBeenCreated());
		
	}
	
	@Test(priority=3)
	public void registerWithExistingEmail() {
		registerpage.combiningAllDetailsToNavigateToAccountSuccessPage
		(dataProp.getProperty("firstName"), dataProp.getProperty("lastName"),
		prop.getProperty("validEmail"), dataProp.getProperty("telephone"), 
		prop.getProperty("validPassword"), prop.getProperty("validPassword"));
		
		Assert.assertEquals(registerpage.retrieveExistingEmailWarningMessag(), dataProp.getProperty("existingEmailWarningMessage"));
		
	}
	
	@Test(priority=4)
	public void registerWithWrongConfirmPassword() {	
		
		registerpage.combiningAllDetailsToNavigateToAccountSuccessPage
		(dataProp.getProperty("firstName"), dataProp.getProperty("lastName"),
		prop.getProperty("validEmail"), dataProp.getProperty("telephone"), 
		prop.getProperty("validPassword"), dataProp.getProperty("invalidPassword"));
		
		Assert.assertEquals(registerpage.retrievePasswordNotMatchWarningMessag(), dataProp.getProperty("passwordNotMatchingWarningMessage"));
	
	}
	
	@Test(priority=5)
	public void registerWithNoInputs() {
		
		
		registerpage.clickOnContinueButton();
		
		Assert.assertTrue(registerpage.retrieveAllWarningMessages
				(dataProp.getProperty("PrivacyPolicyWarningMessage"), 
				dataProp.getProperty("FirstNameWarningMessage"),
				dataProp.getProperty("LastNameWarningMessage"),
				dataProp.getProperty("EmailAddressWarningMessage"), 
				dataProp.getProperty("telephoneNumberWarningMessage"),
				dataProp.getProperty("passwordWarningMessage")));
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
}
