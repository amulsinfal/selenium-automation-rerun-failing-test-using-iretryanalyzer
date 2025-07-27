package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.SkipException;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.ProductsPage;
import utilities.ConfigReader;

public class LoginTest extends BaseTest {

	@Test(priority = 1, groups = {"Sanity"}, description = "Test to verify login with valid credentials.")
	public void testLoginWithValidCredentials() {
		LoginPage loginPage = new LoginPage(driver);
		ProductsPage productsPage = loginPage.login(ConfigReader.getValue("QA", "validUser"),ConfigReader.getValue("QA", "validPass"));
		assertTrue(productsPage.isPageDisplayed(), "Products Page is not displayed.");
	}

	@Test(priority = 2, groups = {"Regression"}, description = "Test to verify login with locked credentials.")
	public void testLoginWithLockedCredentials() {
		// Skipped for testing ITestListener implementation.
		throw new SkipException("This test is Intentionally skipped for ITestListener test.");
	}

	@Test(priority = 3, groups = {"Regression"}, description = "Test to verify login with invalid credentials.")
	public void testLoginWithInvalidCredentials() {
		LoginPage loginPage = new LoginPage(driver);
		ProductsPage productsPage = loginPage.login("Invalid_user","Invalid_Pass");
		assertEquals(loginPage.getErrorText(), "Epic sadface: Username and password do not match any user in this service" ,"Error message on the Login Page is incorrect.");
	}
	
	@Test(priority = 4, groups = {"Regression"}, description = "Test to verify login with blank credentials.")
	public void testLoginWithBlankCredentials() {
		LoginPage loginPage = new LoginPage(driver);
		ProductsPage productsPage = loginPage.login("","");
		assertEquals(loginPage.getErrorText(), "Username Required" ,"Error message on the Login Page is incorrect.");
	}
}
