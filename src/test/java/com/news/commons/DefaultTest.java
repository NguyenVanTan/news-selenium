package com.news.commons;

import static com.news.commons.FixedURL.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

public class DefaultTest {

	protected static WebDriver driver = null;

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", CHROME_DRIVER);
		driver = new ChromeDriver();
//		driver.manage().deleteAllCookies();
	}
	
	
	

}
