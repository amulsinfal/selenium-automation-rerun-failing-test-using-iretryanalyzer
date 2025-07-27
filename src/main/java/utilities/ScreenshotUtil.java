package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import factory.DriverFactory;

public class ScreenshotUtil {

	public static String captureScreenshot(String name) {
		new File("screenshots").mkdirs();
		File source = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
		String fileName = "Screenshot_" + name + "_" + new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date()) + ".png";
		String destinationPath = System.getProperty("user.dir") + "\\screenshots\\" + fileName;
		try {
			FileHandler.copy(source, new File(destinationPath));
		} catch (IOException e) {
			throw new RuntimeException("Error occured while copying screenshot to " + destinationPath);
		}
		
		return destinationPath;
	}
}
