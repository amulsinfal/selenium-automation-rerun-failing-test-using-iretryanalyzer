package base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import factory.DriverFactory;
import utilities.ConfigReader;

public class BaseTest {
	
	protected WebDriver driver;
	private static final Logger log = LogManager.getLogger(BaseTest.class);

	@BeforeMethod(alwaysRun = true)
	public void setup() {
		String browser = ConfigReader.getValue("QA", "browser");
		String url = ConfigReader.getValue("QA", "url");
		driver = DriverFactory.initializeDriver(browser);
		log.info("Navigated to url: " +url);
		driver.get(url);
	}
	
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}

}
