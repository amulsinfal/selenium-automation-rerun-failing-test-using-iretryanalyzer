package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utilities.ConfigReader;

public class LogoutTest extends BaseTest{
	
	@Test (priority = 1, groups = {"Sanity"}, description = "Test to verify logout functionality.")
	public void testLogout() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage = loginPage.login(ConfigReader.getValue("QA", "validUser"), ConfigReader.getValue("QA", "validPass")).logout();
		assertTrue(loginPage.isPageDisplayed(), "Login Page is not displayed.");
	}
}
