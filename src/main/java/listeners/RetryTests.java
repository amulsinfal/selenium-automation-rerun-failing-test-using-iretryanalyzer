package listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

import pages.LoginPage;
import utilities.ConfigReader;

public class RetryTests implements IRetryAnalyzer {
	
	private static final Logger log = LogManager.getLogger(RetryTests.class);
	private static final int MaxRetryCount =  Integer.parseInt(ConfigReader.getValue("QA", "maxRetryCount"));
	private static int retryCount = 1;

	@Override
	public boolean retry(ITestResult result) {
		if (retryCount <= MaxRetryCount) {
			log.warn("Retrying test: Attempt " + retryCount + " of " + MaxRetryCount);
			ReportListeners.test.log(Status.WARNING, "Retrying failing test: Attempt " + retryCount + " of " + MaxRetryCount);
			retryCount++;
			return true;
		}
		return false;
	}

}
