package com.ness.tests;

import java.util.Hashtable;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ness.config.DriverManager;
import com.ness.inputs.Constants;
import com.ness.pages.ClassProfile_Page;
import com.ness.pages.GenerateReports_Page;
import com.ness.pages.Home_Page;
import com.ness.pages.Login_Page;
import com.ness.utilities.TestUtils;
import com.ness.utilities.Xls_Reader;

public class GenerateReportsOunce {

	Home_Page homepage;
	GenerateReports_Page generateReportsPage;
	ClassProfile_Page classProfilePage;

	private final static String testData = Constants.TESTDATA_LOC;
	private static Xls_Reader xls = new Xls_Reader(testData);

	@DataProvider
	private Object[][] getTestData() {
		System.out.println("Executing DataProvider");
		return TestUtils.getData("Ounce", xls);
	}

	@Test(dataProvider = "getTestData", groups = { "Sanity", "Regression" }, priority = 183)
	public void verifyDevProfileReportDownload(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		generateReportsPage = homepage.clickGenerateReportsOunce();
		generateReportsPage.clickDevProfile();
		generateReportsPage.selectChild("lastOne,childOne");
		generateReportsPage.clickSubmit();
		generateReportsPage.verifyDevProfileReportDownload();
		generateReportsPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = { "Sanity", "Regression" }, priority = 184)
	public void verifyClassOutcomesOunceReportDownload(Hashtable<String, String> data, ITestContext context)
			throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		generateReportsPage = homepage.clickGenerateReportsOunce();
		generateReportsPage.clickClassOutcomes();
		generateReportsPage.enterTitle("Class Outcomes Report");
		generateReportsPage.selectReportType("Outcomes by Domain");
		generateReportsPage.selectGradeLevel("Babies I");
		generateReportsPage.clickSubmit();
		generateReportsPage.verifyClassOutcomesReportDownload();
		generateReportsPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = { "Sanity", "Regression" }, priority = 185)
	public void verifyClassProfileOunceReportDownload(Hashtable<String, String> data, ITestContext context)
			throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		generateReportsPage = homepage.clickGenerateReportsOunce();
		classProfilePage = generateReportsPage.clickClassProfile();
		classProfilePage.selectGradeLevel("Babies I");
		classProfilePage.selectDomain("All domains");
		classProfilePage.clickDownload();
		classProfilePage.verifyClassProfileOunceReportDownload();
		classProfilePage.logout();
	}

	@Test(dataProvider = "getTestData", groups = { "Sanity", "Regression" }, priority = 186)
	public void verifyAgeLevelExpiryDateReportDownload(Hashtable<String, String> data, ITestContext context)
			throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		generateReportsPage = homepage.clickGenerateReportsOunce();
		generateReportsPage.clickAgeLevelExpiry();
		generateReportsPage.enterTitle("Age Level Expiry Date");
		generateReportsPage.selectSortBy("Current Age Level Expiration Date");
		generateReportsPage.clickSubmit();
		generateReportsPage.verifyAgeLevelExpiryDateReportDownload();
		generateReportsPage.logout();
	}
}