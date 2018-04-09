package com.news.commons;

public interface FixedURL {

	static final String CHROME_DRIVER = ConfigProperties.properties.getProperty("webdriver.chrome.driver");
	static final String HOME_PAGE_URL = "https://community.oracle.com/community/java/java-ee-java-enterprise-edition/";
	static final String DEFAULT_HOME_BASCIC_AUTHENT =HOME_PAGE_URL;

}
