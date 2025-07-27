package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import listeners.ReportListeners;
import utilities.WaitUtil;

public class LoginPage {
	protected WebDriver driver;
	protected WaitUtil waitUtil;
	private static final Logger log = LogManager.getLogger(LoginPage.class);
	private By txtUsername = By.id("user-name");
	private By txtPassword = By.id("password");
	private By btnLogin = By.id("login-button");
	private By lblError = By.xpath("//h3[@data-test='error']");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		waitUtil = new WaitUtil(driver);
	}

	public ProductsPage login(String userName, String password) {
		try {
			waitUtil.waitForElementToBeClickable(txtUsername).sendKeys(userName);
			log.info("Entered '" + userName + "' in the username textbox.");
			ReportListeners.test.log(Status.INFO, "Entered '" + userName + "' in the username textbox.");
			waitUtil.waitForElementToBeClickable(txtPassword).sendKeys(password);
			log.info("Entered '" + password + "' in the password textbox.");
			ReportListeners.test.log(Status.INFO, "Entered '" + password + "' in the password textbox.");
			waitUtil.waitForElementToBeClickable(btnLogin).click();
			log.info("Clicked on the Login button.");
			ReportListeners.test.log(Status.INFO, "Clicked on the Login button.");
			return new ProductsPage(driver);
		} catch (Exception e) {
			log.info("Unable to login. Exception occured: " + e.getMessage());
			ReportListeners.test.log(Status.FAIL, "Unable to login. Exception occured: " + e.getMessage());
			return null;
		}
	}

	public boolean isPageDisplayed() {
		try {
			boolean isVisible = waitUtil.waitForElementToBeVisible(btnLogin).isDisplayed();
			if (isVisible) {
				log.info("Login page displayed.");
				ReportListeners.test.log(Status.INFO, "Login page displayed.");
			} else {
				log.warn("Login button not visible, Login page might not be displayed.");
				ReportListeners.test.log(Status.WARNING,
						"Login button not visible, Login page might not be displayed.");
			}
			return isVisible;
		} catch (Exception e) {
			log.error("Unable to display Login page. Exception occurred: ", e);
			ReportListeners.test.log(Status.FAIL, "Unable to display Login page. Exception occured: " + e.getMessage());
			return false;
		}
	}

	public String getErrorText() {
		try {
			if (waitUtil.waitForElementToBeVisible(lblError).isDisplayed()) {
				String errorMsg = waitUtil.waitForElementToBeVisible(lblError).getText();
				log.info("Error message '" + errorMsg + "' is displayed on Login page.");
				ReportListeners.test.log(Status.INFO, "Error message '" + errorMsg + "' is displayed on Login page.");
				return errorMsg;
			} else {
				log.warn("Error message is not displayed.");
				ReportListeners.test.log(Status.WARNING, "Error message not displayed.");
				return "";
			}
		} catch (Exception e) {
			log.error("Unable to get error message from Login page. Exception occurred: ", e);
			ReportListeners.test.log(Status.FAIL,
					"Unable to get error message from Login page. Exception occured: " + e.getMessage());
			return "";
		}
	}
}
