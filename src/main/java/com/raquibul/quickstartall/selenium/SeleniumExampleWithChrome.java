package com.raquibul.quickstartall.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumExampleWithChrome {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"src/main/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// And now use this to visit Google
		driver.get("https://www.google.com");

		//maximize the browser
        driver.manage().window().maximize();
        
		// Alternatively the same thing can be done like this
		// driver.navigate().to("http://www.google.com");

		// System.out.println("Page title is: " + driver.getTitle());
		// Find the text input element by its name
		WebElement element = driver.findElement(By.name("q"));

		// Enter something to search for
		element.sendKeys("Cheese!");

		// Here we are mocking the enter key
		element.sendKeys(Keys.ENTER);
		
		Thread.sleep(5000);

		// Check the title of the page
		// Google's search is rendered dynamically with JavaScript.
		// Wait for the page to load, timeout after 10 seconds

		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.getTitle().toLowerCase().startsWith("cheese!");
			}
		});

		// Should see: "cheese! - Google Search"
		System.out.println("Page title is: " + driver.getTitle());

		// Close the browser
		driver.quit();
	}
}
