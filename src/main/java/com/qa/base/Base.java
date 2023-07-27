package com.qa.base;

import java.io.*;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import com.qa.util.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public static WebDriver d;
	public static ChromeOptions chromeopt;
	public static FirefoxOptions ffopt;
	public static SafariOptions safariopt;
	public static Properties p;

	public void loadConfig() throws Throwable {

		try {
			FileInputStream fis = new FileInputStream(new File(
					"C:\\Users\\Virendra\\eclipse-workspace\\TestExcelData\\src\\main\\java\\com\\qa\\config\\config.properties"));
			p = new Properties();
			p.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}

		String browserName = p.getProperty("Browser");

		if (browserName.contains("Chrome")) {
			WebDriverManager.chromedriver().setup();
			chromeopt = new ChromeOptions();
			chromeopt.addArguments("--disable-infobars");
			chromeopt.setAcceptInsecureCerts(true);
			d = new ChromeDriver(chromeopt);
			Reporter.log("Browser Opened");

			d.manage().window().maximize();
			d.manage().deleteAllCookies();
			d.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			d.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			d.get(p.getProperty("Application_url"));// Staff login
			Reporter.log("URL Entered");
		}
	}

	@DataProvider
	public static Object[][] getData() {
		Xls_Reader xls = new Xls_Reader(
				"C:\\Users\\Virendra\\eclipse-workspace\\TestExcelData\\src\\main\\java\\com\\qa\\testData\\Users.xlsx");
		int r = xls.getColumnCount("Sheet1");
		int c = xls.getColumnCount("Sheet1");
		Object[][] obj = new Object[r - 1][c];
		for (int i = 2; i <= r; i++) {
			for (int j = 0; j < c; j++) {

				obj[i - 2][j] = xls.getCellData("Sheet1", j, i);

			}

		}
		return obj;
	}

}
