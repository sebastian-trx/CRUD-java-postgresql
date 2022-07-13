package org.example.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppGetPropertyValues {
    static Messages messages = Messages.getInstance();
    String result = "";
	InputStream inputStream;
 
	public String getPropValues(String key) throws IOException {
 
		try {
			Properties prop = new Properties();
			String propFileName = "config.properties";
 
			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
 
			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}
 
			String propertie = prop.getProperty(key);
 
			result = propertie;

		} catch (Exception e) {
			messages.showMessage("Exception: " + e);
		} 
		return result;
	}


}