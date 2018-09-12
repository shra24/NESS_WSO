package com.ness.extent;

import java.util.HashMap;
import java.util.Map;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentUtil {

    static ExtentReports extentReports = null;
    static Map<Integer, ExtentTest> extentTestMap = new HashMap<Integer, ExtentTest>();

    /**
     * @param fileName report name
     * @return extent report object
     */
    public static ExtentReports createReporter(String fileName) {

        //HTML Reporter
        ExtentHtmlReporter extentHtmlReporter = new ExtentHtmlReporter(fileName);
        extentHtmlReporter.config().setTheme(Theme.STANDARD);
        extentHtmlReporter.config().setReportName("Clinical Automation Report");
        extentHtmlReporter.config().setDocumentTitle("Clinical Automation Report");
        extentHtmlReporter.config().setChartVisibilityOnOpen(false);

        extentReports = new ExtentReports();
        extentReports.attachReporter(extentHtmlReporter);

        extentReports.setSystemInfo("OS", System.getProperty("os.name"));
        extentReports.setSystemInfo("UserName", "Nikunj Desai");
        extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));
        extentReports.setSystemInfo("Selenium Version", "3.4.0");
        extentReports.setSystemInfo("TestNG Version", "6.10");

        return extentReports;
    }

    /**
     * report html file is created after this method is called
     */
    public static void saveReporter() {
        if (extentReports != null)
            extentReports.flush();
    }

    /**
     * Creates the test in extent report
     *
     * @param testName test method name
     * @return extent test object
     */
    public static synchronized ExtentTest createTest(String testName) {
        ExtentTest extentTest = extentReports.createTest(testName);
        extentTestMap.put((int) (Thread.currentThread().getId()), extentTest);
        return extentTest;
    }

    /**
     * Creates the test in extent report
     *
     * @param testName test method name
     * @param testDesc test method description
     * @return extent test object
     */
    public static synchronized ExtentTest createTest(String testName, String testDesc) {
        ExtentTest extentTest = extentReports.createTest(testName, testDesc);
        extentTestMap.put((int) (Thread.currentThread().getId()), extentTest);
        return extentTest;
    }

    /**
     * @return thread safe current test
     */
    public static synchronized ExtentTest fetchTest() {
        return extentTestMap.get((int) (Thread.currentThread().getId()));
    }
}
