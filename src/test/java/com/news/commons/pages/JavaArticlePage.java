package com.news.commons.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaArticlePage {

	private final By ARTICLES = By.xpath("//span[contains(./@id,'jive-widgetframe-title')]");
	private WebDriver driver;
	private final String URL = "https://community.oracle.com/community/java/java-ee-java-enterprise-edition/";

	public JavaArticlePage(WebDriver driver) {
		this.driver = driver;

	}

	public List<WebElement> getListArtical() {
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return driver.findElements(ARTICLES);

	}

}
