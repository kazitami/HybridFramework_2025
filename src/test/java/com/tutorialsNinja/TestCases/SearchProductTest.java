package com.tutorialsNinja.TestCases;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import com.tutorialsNinja.Pages.HomePage;
import com.tutorialsNinja.Pages.searchProductPage;
import com.tutorialsNinja.TestBase.TestBase;

public class SearchProductTest extends TestBase {
	
	public SearchProductTest() throws Exception {
		super();
	}
	public HomePage homepage;
	public searchProductPage searchproductpage;
	@BeforeMethod
	public void SearchProductSetup() {
		driver = initializeBrowserAndOpenApplication(prop.getProperty("browser"));
		homepage = new HomePage(driver);
		searchproductpage = new searchProductPage(driver);
		
	}
	@Test(priority=1)
	public void verifySearchWithValidProduct() {
		searchproductpage =  homepage.navigateTosearchProductPage(dataProp.getProperty("validProduct"));
		
		//deliberately failing this test case
		AssertJUnit.assertTrue(searchproductpage.verifyValidProductPresence());
		AssertJUnit.fail();
	}

	@Test(priority = 2)
	public void verifySearchWithInvalidProduct() {
		
		searchproductpage =  homepage.navigateTosearchProductPage(dataProp.getProperty("invalidProduct"));
		AssertJUnit.assertTrue(searchproductpage.verifyInvalidProductPresence());
	}

	@Test(priority = 3)
	public void verifySearchWithNoProduct() {
		homepage.clickOnSearchButton();
		AssertJUnit.assertTrue(searchproductpage.verifyInvalidProductPresence());

	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	
}
