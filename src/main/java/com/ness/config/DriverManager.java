package com.ness.config;

import org.openqa.selenium.WebDriver;

public class DriverManager {

    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();

    /**
     * @return thread local webdriver
     */
    public static WebDriver getDriver() {
        return webDriver.get();
    }

    /**
     * @param driver set the driver instance
     */
    static void setWebDriver(WebDriver driver) {
        webDriver.set(driver);
    }
}
