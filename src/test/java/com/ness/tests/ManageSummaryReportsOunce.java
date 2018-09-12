package com.ness.tests;

import java.util.Hashtable;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ness.config.DriverManager;
import com.ness.inputs.Constants;
import com.ness.pages.Home_Page;
import com.ness.pages.Login_Page;
import com.ness.pages.Logout_Page;
import com.ness.pages.ManageSummaryReports_Page;
import com.ness.pages.NarrativeSummary_Page;
import com.ness.utilities.TestUtils;
import com.ness.utilities.Xls_Reader;

public class ManageSummaryReportsOunce {

	Home_Page homepage;
	NarrativeSummary_Page narrativeSummary_Page;
	ManageSummaryReports_Page manageSummaryReports_Page;
	Logout_Page logoutPage;

	private final static String testData = Constants.TESTDATA_LOC;
	private static Xls_Reader xls = new Xls_Reader(testData);

	@DataProvider
	private Object[][] getTestData() {
		System.out.println("Executing DataProvider");
		return TestUtils.getData("Ounce", xls);
	}

	@Test(dataProvider = "getTestData", groups = "Sanity", priority = 161)
	public void createOunceSummaryReport(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		narrativeSummary_Page = homepage.clickOunceSummary();
		narrativeSummary_Page.selectStudent();
		narrativeSummary_Page.enterCommentsOunce(TestUtils.getTestData(data, "DevProfileComments"));
		narrativeSummary_Page.clickSave();
		narrativeSummary_Page.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Sanity", priority = 162)
	public void verifyAddDevProfileComment(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		narrativeSummary_Page = homepage.clickOunceSummary();
		narrativeSummary_Page.selectStudent();
		narrativeSummary_Page.addDevProfileComment();
		narrativeSummary_Page.clickSave();
		narrativeSummary_Page.verifyAddedDevProfileComment();
		narrativeSummary_Page.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Sanity", priority = 163)
	public void autoSaveCommentsOunce(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		narrativeSummary_Page = homepage.clickOunceSummary();
		narrativeSummary_Page.selectStudent();
		narrativeSummary_Page.enterCommentsOunce(TestUtils.getTestData(data, "DevProfileComments"));
		narrativeSummary_Page.verifyAutoSaveComments();
		narrativeSummary_Page.clickSave();
		narrativeSummary_Page.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Sanity", priority = 164)
	public void deleteOunceSummary(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		narrativeSummary_Page = homepage.clickOunceSummary();
		narrativeSummary_Page.selectStudent();
		narrativeSummary_Page.enterCommentsOunce(TestUtils.getTestData(data, "DevProfileComments"));
		narrativeSummary_Page.clickSave();
		narrativeSummary_Page.verifyDeleteOunceSummary();
		narrativeSummary_Page.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Sanity", priority = 165)
	public void verifySaveTemplateOunce(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		narrativeSummary_Page = homepage.clickOunceSummary();
		narrativeSummary_Page.selectStudent();
		narrativeSummary_Page.enterCommentsOunce(TestUtils.getTestData(data, "DevProfileComments"));
		narrativeSummary_Page.clickSave();
		narrativeSummary_Page.verifySaveTemplateOunce();
		narrativeSummary_Page.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Sanity", priority = 166)
	public void verifyUseTemplateOunce(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		narrativeSummary_Page = homepage.clickOunceSummary();
		narrativeSummary_Page.selectStudent();
		narrativeSummary_Page.clickUseTemplate();
		narrativeSummary_Page.clickSave();
		narrativeSummary_Page.verifyUseTemplate();
		narrativeSummary_Page.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 167)
	public void verifyCommentsCounterForOunceSummary(Hashtable<String, String> data, ITestContext context)
			throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		narrativeSummary_Page = homepage.clickOunceSummary();
		narrativeSummary_Page.selectStudent();
		narrativeSummary_Page.enterCommentsOunce(TestUtils.getTestData(data, "DevProfileComments"));
		narrativeSummary_Page.verifyCommentCounter();
		manageSummaryReports_Page = narrativeSummary_Page.clickBack();
		manageSummaryReports_Page.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 168)
	public void verifyDownloadOunceSummaryEnglishPdf(Hashtable<String, String> data, ITestContext context)
			throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		narrativeSummary_Page = homepage.clickOunceSummary();
		narrativeSummary_Page.selectStudent();
		narrativeSummary_Page.enterCommentsOunce(TestUtils.getTestData(data, "DevProfileComments"));
		narrativeSummary_Page.clickSave();
		narrativeSummary_Page.verifyDownloadOunceSummaryEnglishPdf();
		narrativeSummary_Page.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 169)
	public void verifySaveButtonDisabledForNonCurrentAgeLevel(Hashtable<String, String> data, ITestContext context)
			throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		manageSummaryReports_Page = homepage.clickManageSummaryReportsOunce();
		narrativeSummary_Page = manageSummaryReports_Page.clickBabiesTwo();
		narrativeSummary_Page.verifySaveButtonDisabled();
		narrativeSummary_Page.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 170)
	public void verifyAgeLevelDisplayedForOunceSummary(Hashtable<String, String> data, ITestContext context)
			throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		narrativeSummary_Page = homepage.clickOunceSummary();
		narrativeSummary_Page.selectStudent();
		narrativeSummary_Page.enterCommentsOunce(TestUtils.getTestData(data, "DevProfileComments"));
		narrativeSummary_Page.verifyAgeLevelDisplayedForOunceSummary();
		narrativeSummary_Page.clickSave();
		narrativeSummary_Page.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Sanity", priority = 171)
	public void verifyObservationRecord(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		narrativeSummary_Page = homepage.clickObservationRecord();
		narrativeSummary_Page.selectStudent();
		narrativeSummary_Page.enterCommentsForObsRecord(TestUtils.getTestData(data, "DevProfileComments"));
		narrativeSummary_Page.clickSave();
		narrativeSummary_Page.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 172)
	public void verifyAuthorInfoForObsRecord(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		narrativeSummary_Page = homepage.clickObservationRecord();
		narrativeSummary_Page.selectStudent();
		narrativeSummary_Page.enterCommentsForObsRecord(TestUtils.getTestData(data, "DevProfileComments"));
		narrativeSummary_Page.clickSave();
		narrativeSummary_Page.verifyAuthorInfoForObsRecord();
		narrativeSummary_Page.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 173)
	public void verifyAddDevProfileCommentForObsRecord(Hashtable<String, String> data, ITestContext context)
			throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		narrativeSummary_Page = homepage.clickObservationRecord();
		narrativeSummary_Page.selectStudent();
		narrativeSummary_Page.addDevProfileCommentForObsRecord();
		narrativeSummary_Page.clickSave();
		narrativeSummary_Page.verifyAddedDevProfileCommentForObsRecord();
		narrativeSummary_Page.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 174)
	public void verifyCommentsCounterForObsRecord(Hashtable<String, String> data, ITestContext context)
			throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		narrativeSummary_Page = homepage.clickObservationRecord();
		narrativeSummary_Page.selectStudent();
		narrativeSummary_Page.enterCommentsForObsRecord(TestUtils.getTestData(data, "DevProfileComments"));
		narrativeSummary_Page.verifyCommentCounterForObsRecord();
		narrativeSummary_Page.clickSave();
		narrativeSummary_Page.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 175)
	public void verifyDownloadObsRecordEnglishPdf(Hashtable<String, String> data, ITestContext context)
			throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		narrativeSummary_Page = homepage.clickObservationRecord();
		narrativeSummary_Page.selectStudent();
		narrativeSummary_Page.enterCommentsForObsRecord(TestUtils.getTestData(data, "DevProfileComments"));
		narrativeSummary_Page.clickSave();
		narrativeSummary_Page.verifyDownloadObsRecordEnglishPdf();
		narrativeSummary_Page.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 176)
	public void verifyDeleteObservationRecord(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		narrativeSummary_Page = homepage.clickObservationRecord();
		narrativeSummary_Page.selectStudent();
		narrativeSummary_Page.enterCommentsForObsRecord(TestUtils.getTestData(data, "DevProfileComments"));
		narrativeSummary_Page.clickSave();
		narrativeSummary_Page.verifyDeleteObservationRecord();
		narrativeSummary_Page.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 177)
	public void verifySaveTemplateObsRecord(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		narrativeSummary_Page = homepage.clickObservationRecord();
		narrativeSummary_Page.selectStudent();
		narrativeSummary_Page.enterCommentsForObsRecord(TestUtils.getTestData(data, "DevProfileComments"));
		narrativeSummary_Page.clickSave();
		narrativeSummary_Page.verifySaveTemplateObsRecord();
		narrativeSummary_Page.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 178)
	public void verifyUseTemplateObsRecord(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		narrativeSummary_Page = homepage.clickObservationRecord();
		narrativeSummary_Page.selectStudent();
		narrativeSummary_Page.clickUseTemplate();
		narrativeSummary_Page.clickSave();
		narrativeSummary_Page.verifyUseTemplateObsRecord();
		narrativeSummary_Page.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 179)
	public void verifyAutoSaveCommentsObsRecord(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		narrativeSummary_Page = homepage.clickObservationRecord();
		narrativeSummary_Page.selectStudent();
		narrativeSummary_Page.enterCommentsForObsRecord(TestUtils.getTestData(data, "DevProfileComments"));
		narrativeSummary_Page.verifyAutoSaveCommentsObsRecord();
		narrativeSummary_Page.clickSave();
		narrativeSummary_Page.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 180)
	public void verifyGuidelinesForObsRecord(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		narrativeSummary_Page = homepage.clickObservationRecord();
		narrativeSummary_Page.selectStudent();
		narrativeSummary_Page.enterCommentsForObsRecord(TestUtils.getTestData(data, "DevProfileComments"));
		narrativeSummary_Page.verifyGuidelinesForObsRecord();
		narrativeSummary_Page.clickSave();
		narrativeSummary_Page.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 181)
	public void verifyNavigationViaManageSummaryPage(Hashtable<String, String> data, ITestContext context)
			throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		manageSummaryReports_Page = homepage.clickManageSummaryReportsOunce();
		narrativeSummary_Page = manageSummaryReports_Page.clickBabiesOne();
		narrativeSummary_Page.enterCommentsOunce(TestUtils.getTestData(data, "DevProfileComments"));
		narrativeSummary_Page.clickSave();
		narrativeSummary_Page.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 182)
	public void verifyChildInfoOnManageSummaryPage(Hashtable<String, String> data, ITestContext context)
			throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		manageSummaryReports_Page = homepage.clickManageSummaryReportsOunce();
		manageSummaryReports_Page.verifyChildInfoOnManageSummaryPage();
		manageSummaryReports_Page.logout();
	}
}