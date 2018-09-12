package com.ness.config;

import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DesiredCaps {

	/**
	 * @return windows 7 chrome desired capabilities
	 */
	static synchronized DesiredCapabilities chrome_DesiredCapabilities() {
		DesiredCapabilities caps = DesiredCapabilities.chrome();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("ignore-certifcate-errors");
		options.addArguments("test-type");
		options.addArguments("allow-running-insecure-content");
		options.addArguments("--disable-popup-blocking");
		options.addArguments("--disable-extensions");
		options.addArguments("disable-infobars");
		options.addArguments("--disable-notifications");
		//options.addArguments("headless");
		//options.addArguments("window-size=1200x600");
		caps.setPlatform(Platform.WINDOWS);
		caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		caps.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		caps.setCapability(ChromeOptions.CAPABILITY, options);
		return caps;
	}

	/**
	 * @return windows 8.1 firefox desired capabilities
	 */
	static synchronized DesiredCapabilities firefox_DesiredCapabilities() {
		DesiredCapabilities caps = DesiredCapabilities.firefox();
		FirefoxProfile options = new FirefoxProfile();
		options.setAcceptUntrustedCertificates(true);
		options.setAssumeUntrustedCertificateIssuer(true);
		options.setPreference("OS_Browser.download.folderList", 2);
		options.setPreference("OS_Browser.helperApps.alwaysAsk.force", false);
		caps.setPlatform(Platform.WIN8_1);
		caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		caps.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		caps.setCapability(FirefoxDriver.PROFILE, options);
		return caps;
	}
}
