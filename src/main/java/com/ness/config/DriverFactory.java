package com.ness.config;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.ness.utilities.JSWaiter;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;

public class DriverFactory {

	/**
	 * Start browser based on input and used in WebDriverListener
	 *
	 * @param Browser fetched from xml
	 * @return driver instance
	 * 
	 */
	static RemoteWebDriver createInstance(String Browser) {
		RemoteWebDriver driver = null;

		if ((Browser).equalsIgnoreCase("Chrome")) {
			System.out.println("");
			System.out.println("-----CHROME Browser-----");
			System.out.println("");

			ChromeDriverManager.getInstance().setup();
			DesiredCapabilities caps = DesiredCaps.chrome_DesiredCapabilities();
			driver = new ChromeDriver(caps);
			driver.manage().window().maximize();
		}
		if ((Browser).equalsIgnoreCase("Firefox")) {
			System.out.println("");
			System.out.println("-----Firefox Browser-----");
			System.out.println("");

			FirefoxDriverManager.getInstance().setup();
			DesiredCapabilities caps = DesiredCaps.firefox_DesiredCapabilities();
			driver = new FirefoxDriver(caps);
			driver.manage().window().maximize();
		}
		
		JSWaiter.setDriver(driver);
		return driver;
	}
}
