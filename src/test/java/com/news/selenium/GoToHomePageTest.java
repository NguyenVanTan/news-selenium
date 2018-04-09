package com.news.selenium;

import static com.news.commons.FixedURL.DEFAULT_HOME_BASCIC_AUTHENT;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.news.commons.DefaultTest;

public class GoToHomePageTest extends DefaultTest {

	private static Logger logger = LoggerFactory.getLogger(GoToHomePageTest.class);

	@BeforeTest
	public void beforeTest() {
		logger.info("before test");

	}

	@Test
	public void testGoHomePage() throws InterruptedException {
		// Call the google page

		driver.get("https://eth.remitano.com/vn/");

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		WebElement ask = driver.findElement(By.xpath("//strong[@class='text-success ng-binding']"));
		logger.info( ask.getText());
		
		
		Double askVal=Double.valueOf(ask.getText().replaceAll("(,| |VND)", ""));
		
		WebElement bid = driver.findElement(By.xpath("//strong[@class='text-danger ng-binding']"));
	    logger.info(bid.getText());
		Double bidVal=Double.valueOf(bid.getText().replaceAll("(,| |VND)", ""));
		
		
		 logger.info("Diff: "+ (Math.abs(bidVal - askVal)));
	    
		
	}
	
	

		
		
		
			
		// .assertTrue(element.getText().equals("Java Programming tutorials and
		// Interview Questions"));

		// //maximize the browser
		// driver.manage().window().maximize();
		// // Find the text input element by its name
		// WebElement developmentElement =
		// driver.findElement(By.xpath("//a[@class='main' and @title='Development']"));
		// Assert.assertEquals(developmentElement.getText(), "Development");
		// Actions actions =new Actions(driver);
		// actions.moveToElement(developmentElement).build().perform();
		// driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// WebElement topUlElement
		// =driver.findElement(By.xpath("//ul[@class='top_submenu_links']/li/a[text()='Java']"));
		//
		// Assert.assertEquals(topUlElement.getAttribute("title"), "Java");
		// actions.click(topUlElement).build().perform();
		// driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// List<WebElement > divgridElemenst =
		// driver.findElements(By.xpath("//div[@class ='ref-topic__grid-container']"));
		//
		// divgridElemenst.forEach(element->{
		// List<WebElement> listArticalTitle = element.findElements(By.xpath("div[@class
		// ='ref-card']/h3/a"));
		// listArticalTitle.forEach(chilArticel->{
		// System.out.println(chilArticel.getText());
		// });
		//
		// });


	@AfterClass
	public void tearDown() {
		driver.close();
	}
}
