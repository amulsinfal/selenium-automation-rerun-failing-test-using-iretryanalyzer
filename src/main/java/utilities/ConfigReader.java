package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	public static String getValue(String env, String key) {
		Properties properties = new Properties();
		FileInputStream fileInputStream = null;
		String configFilePath = System.getProperty("user.dir") + "\\src\\test\\resources\\configuration\\" + env.toUpperCase() + "-config.properties";
		try {
			fileInputStream = new FileInputStream(configFilePath);
			properties.load(fileInputStream);
			fileInputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties.getProperty(key);
	}
}
