package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import utilities.ConfigReader;

public class RetryTests implements IRetryAnalyzer {

	private static final int MaxRetryCount =  Integer.parseInt(ConfigReader.getValue("QA", "maxRetryCount"));
	private static int retryCount = 1;

	@Override
	public boolean retry(ITestResult result) {
		if (retryCount <= MaxRetryCount) {
			retryCount++;
			return true;
		}
		return false;
	}

}
