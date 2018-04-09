package com.news.commons;

import static com.news.commons.FixedURL.CHROME_DRIVER;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class DefaultTestDatabase {

	Logger logger = LoggerFactory.getLogger(DefaultTestDatabase.class);

	protected static WebDriver driver = null;
	protected Connection connection;
	protected QueryRunner queryRunner;

	String databaseURL = "";
	String user = "";
	String password = "";

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", CHROME_DRIVER);
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		databaseURL = ConfigProperties.properties.getProperty("databaseURL");
		user = ConfigProperties.properties.getProperty("user");
		password = ConfigProperties.properties.getProperty("password");
		connection = null;
		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance();
			// DriverManager.registerDriver(new com.mysql.jdbc.Driver ());

			logger.info("Connecting to Database...");
			connection = DriverManager.getConnection(databaseURL, user, password);
			queryRunner=new QueryRunner();
			if (connection != null) {
				logger.info("Connected to the Database...");
			}
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	@AfterClass
	public void tearDown() {
		if (connection != null) {
			logger.info("Closing Database Connection...");
//				connection.close();
			DbUtils.closeQuietly(connection);
		}
	}

}
