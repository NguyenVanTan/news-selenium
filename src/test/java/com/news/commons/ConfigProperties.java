package com.news.commons;

import static com.news.commons.FixedURL.CHROME_DRIVER;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConfigProperties {

	private static final Logger slf4jLogger = LoggerFactory.getLogger(ConfigProperties.class);
	private static final String filename = "config.properties";
	public static Properties properties = new Properties();
	static InputStream inputStream = null;
	static {
		getAllConfig();
	}

	public static void getAllConfig() {

		inputStream = ConfigProperties.class.getClassLoader().getResourceAsStream(filename);
		if (inputStream == null) {
			System.out.println("Sorry, unable to load: " + filename);
		}

		try {
			properties.load(inputStream);
			slf4jLogger.info(properties.toString());
		} catch (IOException e) {
			// File not found
			e.printStackTrace();
		}

	}

}
