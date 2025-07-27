package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import listeners.ReportListeners;
import utilities.WaitUtil;

public class ProductsPage {
	protected WebDriver driver;
	protected WaitUtil waitUtil;
	private static final Logger log = LogManager.getLogger(ProductsPage.class);
	private By lblPageHeader = By.xpath("//span[@class='title']");
	private By btnMenu = By.id("react-burger-menu-btn");
	private By lnkLogout = By.id("logout_sidebar_link");

	public ProductsPage(WebDriver driver) {
		this.driver = driver;
		waitUtil = new WaitUtil(driver);
	}

	public LoginPage logout() {
		try {
			waitUtil.waitForElementToBeClickable(btnMenu).click();
			log.info("Clicked on the Menu button.");
			ReportListeners.test.log(Status.INFO, "Clicked on the Menu button.");
			waitUtil.waitForElementToBeClickable(lnkLogout).click();
			log.info("Clicked on the Logout link.");
			ReportListeners.test.log(Status.INFO, "Clicked on the Logout link.");
			return new LoginPage(driver);
		} catch (Exception e) {
			log.error("Unable to logout. Exception occured: " + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Unable to logout. Exception occured: " + e.getMessage());
			return null;
		}
	}

	public boolean isPageDisplayed() {
		try {
			boolean isVisible = waitUtil.waitForElementToBeVisible(lblPageHeader).isDisplayed();
			if (isVisible) {
				log.info("Products page displayed.");
				ReportListeners.test.log(Status.INFO, "Products page displayed.");
			} else {
				log.warn("Products page not displayed.");
				ReportListeners.test.log(Status.WARNING, "Products page not displayed.");
			}
			return isVisible;
		} catch (Exception e) {
			log.error("Unable to display Products page. Exception occured: ", e);
			ReportListeners.test.log(Status.FAIL,
					"Unable to display Products page. Exception occured: " + e.getMessage());
			return false;
		}
	}
}