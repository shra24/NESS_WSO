package com.ness.config;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IExecutionListener;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;
import org.testng.SkipException;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.ness.extent.ExtentUtil;
import com.ness.utilities.TestUtils;

public class WebDriverListener implements IExecutionListener, IInvokedMethodListener {

	/**
	 * Creates a single report for test run
	 */
	@Override
	public void onExecutionStart() {
		System.out.println("Start extent reporting");
		String dir = "./ExtentReports/report";
		String time = new SimpleDateFormat("@dd_MM_yyyy@HH_mm_ss").format(new Date());
		String html = ".html";
		String path = dir + time + html;
		ExtentUtil.createReporter(path);
	}

	/**
	 * Saves html report in ExtentReports folder
	 */
	@Override
	public void onExecutionFinish() {
		System.out.println("End extent reporting");
		//ExtentUtil.saveReporter();
	}

	/**
	 * Creates test and assigns category in extent report & Launches browser
	 *
	 * @param method
	 *            current test method
	 * @param testResult
	 *            current test method result
	 */
	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
		if (method.isTestMethod()) {

			String className = method.getTestMethod().getRealClass().getSimpleName();
			String methodName = method.getTestMethod().getMethodName();

			// Checks in config.xlsx to run the test class or not
			if (!TestUtils.isTestExecutable(className)) {
				System.out.println("Skipping the TEST CLASS : '" + className + "' as Runmode is N");
				throw new SkipException("Skipping the TEST CLASS : '" + className + "' as Runmode is N");
			}

			// Checks in config.xlsx to run the test method or not
			if (!TestUtils.isTestExecutable(methodName)) {
				System.out.println("Skipping the TEST METHOD : '" + methodName + "' as Runmode is N");
				throw new SkipException("Skipping the TEST METHOD : '" + methodName + "' as Runmode is N");
			}

			// Runmode set to Y for both class and method in config.xlsx then
			// proceed with execution

			// Create test in extent report
			System.out.println("");
			System.out.println("Test Method Started : " + methodName);
			System.out.println("");

			ExtentUtil.createTest(methodName);

			// Assign category fetched from test groups to test method in extent
			// report
			String[] categories = method.getTestMethod().getGroups();
			for (String category : categories) {
				ExtentUtil.fetchTest().assignCategory(category);
			}

			// Fetch OS_Browser from xml files and start the browser
			String Browser = method.getTestMethod().getXmlTest().getLocalParameters().get("Browser");
			try {
				WebDriver driver = DriverFactory.createInstance(Browser);
				DriverManager.setWebDriver(driver);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	/**
	 * Logs test result and ends browser session
	 *
	 * @param method
	 *            current test method
	 * @param testResult
	 *            current test method result
	 */
	public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
		if (method.isTestMethod()) {

			WebDriver driver = DriverManager.getDriver();

			if (testResult.getTestContext().getAttribute("Browser") != null) {
				String Browser = testResult.getTestContext().getAttribute("Browser").toString();

				if (testResult.getStatus() == ITestResult.SUCCESS) {
					ExtentUtil.fetchTest().log(Status.INFO, Browser);
					ExtentUtil.fetchTest().log(Status.PASS, MarkupHelper.createLabel("TEST PASSED", ExtentColor.GREEN));
				}
				if (testResult.getStatus() == ITestResult.FAILURE) {
					ExtentUtil.fetchTest().log(Status.INFO, Browser);
					try {
						String screenShotPath = capture(driver, randomString());
						ExtentUtil.fetchTest().addScreenCaptureFromPath(screenShotPath);
					} catch (IOException e) {
						e.printStackTrace();
					}
					ExtentUtil.fetchTest().log(Status.INFO, testResult.getThrowable());
					ExtentUtil.fetchTest().log(Status.FAIL, MarkupHelper.createLabel("TEST FAILED", ExtentColor.RED));
				}
				if (testResult.getStatus() == ITestResult.SKIP) {
					ExtentUtil.fetchTest().log(Status.INFO, Browser);
					ExtentUtil.fetchTest().log(Status.INFO, testResult.getThrowable());
					ExtentUtil.fetchTest().log(Status.SKIP, MarkupHelper.createLabel("TEST SKIPPED", ExtentColor.ORANGE));
				}
			}

			if (driver != null) {
				driver.quit();
				ExtentUtil.saveReporter();
			}

		}
	}

	/**
	 * @param driver
	 *            current driver instance
	 * @param screenShotName
	 *            random 10 letter string
	 * @return failure screenshot folder path and image name
	 * @throws IOException
	 *             while copying file to folder
	 */
	private String capture(WebDriver driver, String screenShotName) throws IOException {
		screenShotName = screenShotName + ".png";
		String dir = System.getProperty("user.dir") + "/ExtentReports/";
		String todayAsString = new SimpleDateFormat("dd-MM-yyyy/").format(new Date());
		String directory = dir + todayAsString;
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File(directory + screenShotName));
		return directory + screenShotName;
	}

	/**
	 * @return random 10 letter string
	 */
	private String randomString() {
		final String data = "abcdefghijklmnopqrtuvwxyz1234567890";
		Random random = new Random();
		StringBuilder sb = new StringBuilder(15);
		for (int i = 0; i < 10; i++) {
			sb.append(data.charAt(random.nextInt(data.length())));
		}
		return sb.toString();
	}
}
