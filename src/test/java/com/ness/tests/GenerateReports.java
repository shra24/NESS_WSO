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

public class GenerateReports {

	Home_Page homepage;
	GenerateReports_Page generateReportsPage;
	ClassProfile_Page classProfilePage;

	private final static String testData = Constants.TESTDATA_LOC;
	private static Xls_Reader xls = new Xls_Reader(testData);

	@DataProvider
	private Object[][] getTestData() {
		System.out.println("Executing DataProvider");
		return TestUtils.getData("Work", xls);
	}

	@Test(dataProvider = "getTestData", groups = { "Sanity", "Regression" }, priority = 74)
	public void verifyChecklistReportDownload(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		generateReportsPage = homepage.clickGenerateReports();
		generateReportsPage.clickChecklist();
		generateReportsPage.selectPrintFor("lastOne,studentOne");
		generateReportsPage.selectGradeLevel("Preschool 4");
		generateReportsPage.selectAcademicYear("2017/2018");
		generateReportsPage.includePreliminaryRatings();
		generateReportsPage.includeComments();
		generateReportsPage.selectAllDomains();
		generateReportsPage.clickSubmit();
		generateReportsPage.verifyChecklistReportDownload();
		generateReportsPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = { "Sanity", "Regression" }, priority = 75)
	public void verifyClassChecklistReportDownload(Hashtable<String, String> data, ITestContext context)
			throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		generateReportsPage = homepage.clickGenerateReports();
		generateReportsPage.clickChecklist();
		generateReportsPage.selectPrintFor("Entire Class");
		generateReportsPage.selectGradeLevel("Preschool 4");
		generateReportsPage.selectAcademicYear("2017/2018");
		generateReportsPage.includePreliminaryRatings();
		generateReportsPage.includeComments();
		generateReportsPage.selectAllDomains();
		generateReportsPage.clickSubmit();
		generateReportsPage.verifyClassChecklistReportDownload();
		generateReportsPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = { "Sanity", "Regression" }, priority = 76)
	public void verifyClassOutcomesReportDownload(Hashtable<String, String> data, ITestContext context)
			throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		generateReportsPage = homepage.clickGenerateReports();
		generateReportsPage.clickClassOutcomes();
		generateReportsPage.enterTitle("Class Outcomes Report");
		generateReportsPage.selectReportType("Outcomes by Domain");
		generateReportsPage.selectGradeLevel("Preschool-4");
		generateReportsPage.clickSubmit();
		generateReportsPage.verifyClassOutcomesReportDownload();
		generateReportsPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = { "Sanity", "Regression" }, priority = 77)
	public void verifyClassProfileReportDownload(Hashtable<String, String> data, ITestContext context)
			throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		generateReportsPage = homepage.clickGenerateReports();
		classProfilePage = generateReportsPage.clickClassProfile();
		classProfilePage.selectGradeLevel("Preschool 4");
		classProfilePage.selectPeriod("PERIOD 1");
		classProfilePage.selectDomain("All domains");
		classProfilePage.clickDownload();
		classProfilePage.verifyClassProfileReportDownload();
		classProfilePage.logout();
	}

	@Test(dataProvider = "getTestData", groups = { "Sanity", "Regression" }, priority = 78)
	public void verifyClassRatingsReportDownload(Hashtable<String, String> data, ITestContext context)
			throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		generateReportsPage = homepage.clickGenerateReports();
		generateReportsPage.clickClassRatings();
		generateReportsPage.enterTitle("Class Ratings Report");
		generateReportsPage.selectAcademicYear("2017/2018");
		generateReportsPage.selectGradeLevel("Preschool 4");
		generateReportsPage.selectFilter("Final");
		generateReportsPage.selectAllDomains();
		generateReportsPage.clickSubmit();
		generateReportsPage.verifyClassRatingsReportDownload();
		generateReportsPage.logout();
	}
}