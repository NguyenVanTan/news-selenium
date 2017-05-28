package com.raquibul.quickstartall.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SeleniumExampleWithChromeTest {

	private static final String CHROME_DRIVER = "src/main/resources/chromedriver.exe";
	private static WebDriver driver = null;
	
	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", CHROME_DRIVER);
		driver = new ChromeDriver();
	}
	
	@Test
	public void testGoogleSearch() throws InterruptedException {
		//Call the google page
		driver.get("https://www.google.com");
		
		//maximize the browser
        driver.manage().window().maximize();
		
		// Find the text input element by its name
		WebElement element = driver.findElement(By.name("q"));

		// Enter something to search for - here it;s "Cheese!"
		element.sendKeys("Cheese!");

		// Now submit the form. WebDriver will find the form for us from th element - alternative to above \n
		//element.submit(); 
		
		//Here we are mocking the enter key
		element.sendKeys(Keys.ENTER);

		//Wait for some time before the browser si closed - just for you to see the action in slow motion
		Thread.sleep(5000);


		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.getTitle().toLowerCase().startsWith("cheese!");
			}
		});

		// Should see: "cheese! - Google Search"
		String title = driver.getTitle();
		Assert.assertTrue(title.contains("Cheese!"));
		//System.out.println("Page title is: " + driver.getTitle());
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
