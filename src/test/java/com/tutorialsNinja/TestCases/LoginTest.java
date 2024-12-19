package com.tutorialsNinja.TestCases;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsNinja.Pages.AccountPage;
import com.tutorialsNinja.Pages.HomePage;
import com.tutorialsNinja.Pages.LoginPage;
import com.tutorialsNinja.TestBase.TestBase;
import com.tutorialsNinja.Utilities.Util;
import com.tutorialsnNinja.TestData.ExcelCode;


public class LoginTest extends TestBase{
	public LoginTest() throws Exception {
		super();
	}
	
	public HomePage homepage;
	public LoginPage loginpage;
	public AccountPage accountpage;
	
	
	
	@BeforeMethod
	public void loginSetup() {
		driver = initializeBrowserAndOpenApplication(prop.getProperty("browser"));
		homepage = new HomePage(driver);//HomePage
	    loginpage = new LoginPage(driver);//LoginPage
	    accountpage = new AccountPage(driver);//AccountPage
	    loginpage = homepage.combiningTwoActionToNavigateToLoginPage();
		
	}
	@Test(priority=1, dataProvider = "TNLogin", dataProviderClass = ExcelCode.class)
	public void verifyLoginWithValidCredentials(String email, String password) {
		
		accountpage = loginpage.navigateToLoginPageByCombining3Actions(email, password);
		AssertJUnit.assertTrue(accountpage.validateDisplayStatusOfLogoutLink());
		
		
	}
	
	@Test(priority=2)
	public void verifyLoginWithValidEmailInvalidPassword() {
		loginpage.navigateToLoginPageByCombining3Actions(prop.getProperty("validEmail"), dataProp.getProperty("invalidPassword"));
		AssertJUnit.assertEquals(loginpage.retrieveLoginWarningMessage(), dataProp.getProperty("loginWarningMessage"));
	}
	
	@Test(priority=3)
	public void verifyLoginWithInvalidEmailValidPassword() {
		
		loginpage.navigateToLoginPageByCombining3Actions(Util.emailWithDateTimeStamp(), prop.getProperty("validPassword"));
		AssertJUnit.assertEquals(loginpage.retrieveLoginWarningMessage(), dataProp.getProperty("loginWarningMessage"));
		
	}
	@Test(priority=4)
	public void verifyLoginwithInvalidCredentials() {
		
		loginpage.navigateToLoginPageByCombining3Actions(Util.emailWithDateTimeStamp(), dataProp.getProperty("invalidPassword"));
		AssertJUnit.assertEquals(loginpage.retrieveLoginWarningMessage(), dataProp.getProperty("loginWarningMessage"));
		
	}
	
	@Test(priority=5)
	public void verifyLoginwithNoCredentials() {
		
		loginpage.clickOnLoginButton();
		AssertJUnit.assertEquals(loginpage.retrieveLoginWarningMessage(), dataProp.getProperty("loginWarningMessage"));
		
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
