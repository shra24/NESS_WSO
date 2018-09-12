package com.ness.tests;

import java.util.Hashtable;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ness.config.DriverManager;
import com.ness.inputs.Constants;
import com.ness.pages.EnterChecklistData_Page;
import com.ness.pages.EnterChecklist_Page;
import com.ness.pages.Home_Page;
import com.ness.pages.Login_Page;
import com.ness.pages.Logout_Page;
import com.ness.pages.ManageSummaryReports_Page;
import com.ness.pages.NarrativeSummary_Page;
import com.ness.utilities.TestUtils;
import com.ness.utilities.Xls_Reader;

public class ManageSummaryReports {

	Home_Page homepage;
	NarrativeSummary_Page narrativeSummary_Page;
	ManageSummaryReports_Page manageSummaryReports_Page;
	EnterChecklist_Page enterChecklist_Page;
	EnterChecklistData_Page enterChecklistData_Page;
	Logout_Page logoutPage;

	private final static String testData = Constants.TESTDATA_LOC;
	private static Xls_Reader xls = new Xls_Reader(testData);

	@DataProvider
	private Object[][] getTestData() {
		System.out.println("Executing DataProvider");
		return TestUtils.getData("Work", xls);
	}

	@Test(dataProvider = "getTestData", groups = "Sanity", priority = 49)
	public void createNarrativeSummaryReport(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		narrativeSummary_Page = homepage.clickNarrativeSummary();
		narrativeSummary_Page.selectStudent();
		narrativeSummary_Page.selectPeriod(TestUtils.getTestData(data, "NarrativeSummaryPeriod"));
		narrativeSummary_Page.enterReportOptions("12", "13", "14");
		narrativeSummary_Page.enterComments(TestUtils.getTestData(data, "ChecklistComments"));
		narrativeSummary_Page.clickSave();
		narrativeSummary_Page.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Sanity", priority = 50)
	public void verifyAddChecklistComment(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		narrativeSummary_Page = homepage.clickNarrativeSummary();
		narrativeSummary_Page.selectStudent();
		narrativeSummary_Page.selectPeriod(TestUtils.getTestData(data, "NarrativeSummaryPeriod"));
		narrativeSummary_Page.enterReportOptions("12", "13", "14");
		narrativeSummary_Page.addChecklistComment();
		narrativeSummary_Page.clickSave();
		narrativeSummary_Page.verifyAddedChecklistComment();
		narrativeSummary_Page.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Sanity", priority = 51)
	public void autoSaveComments(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		narrativeSummary_Page = homepage.clickNarrativeSummary();
		narrativeSummary_Page.selectStudent();
		narrativeSummary_Page.selectPeriod(TestUtils.getTestData(data, "NarrativeSummaryPeriod"));
		narrativeSummary_Page.enterReportOptions("12", "13", "14");
		narrativeSummary_Page.enterComments(TestUtils.getTestData(data, "ChecklistComments"));
		narrativeSummary_Page.verifyAutoSaveComments();
		narrativeSummary_Page.clickSave();
		narrativeSummary_Page.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Sanity", priority = 52)
	public void deleteNarrativeSummary(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		narrativeSummary_Page = homepage.clickNarrativeSummary();
		narrativeSummary_Page.selectStudent();
		narrativeSummary_Page.selectPeriod(TestUtils.getTestData(data, "NarrativeSummaryPeriod"));
		narrativeSummary_Page.enterReportOptions("12", "13", "14");
		narrativeSummary_Page.enterComments(TestUtils.getTestData(data, "ChecklistComments"));
		narrativeSummary_Page.clickSave();
		narrativeSummary_Page.verifyDeleteNarrativeSummary();
		narrativeSummary_Page.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Sanity", priority = 53)
	public void verifySaveTemplate(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		narrativeSummary_Page = homepage.clickNarrativeSummary();
		narrativeSummary_Page.selectStudent();
		narrativeSummary_Page.selectPeriod(TestUtils.getTestData(data, "NarrativeSummaryPeriod"));
		narrativeSummary_Page.enterReportOptions("12", "13", "14");
		narrativeSummary_Page.enterComments(TestUtils.getTestData(data, "ChecklistComments"));
		narrativeSummary_Page.clickSave();
		narrativeSummary_Page.verifySaveTemplate();
		narrativeSummary_Page.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Sanity", priority = 54)
	public void verifyUseTemplate(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		narrativeSummary_Page = homepage.clickNarrativeSummary();
		narrativeSummary_Page.selectStudent();
		narrativeSummary_Page.selectPeriod(TestUtils.getTestData(data, "NarrativeSummaryPeriod"));
		narrativeSummary_Page.enterReportOptions("12", "13", "14");
		narrativeSummary_Page.clickUseTemplate();
		narrativeSummary_Page.clickSave();
		narrativeSummary_Page.verifyUseTemplate();
		narrativeSummary_Page.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 55)
	public void verifyCommentsCounterForNarrativeSummary(Hashtable<String, String> data, ITestContext context)
			throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		narrativeSummary_Page = homepage.clickNarrativeSummary();
		narrativeSummary_Page.selectStudent();
		narrativeSummary_Page.selectPeriod(TestUtils.getTestData(data, "NarrativeSummaryPeriod"));
		narrativeSummary_Page.enterComments(TestUtils.getTestData(data, "ChecklistComments"));
		narrativeSummary_Page.verifyCommentCounter();
		narrativeSummary_Page.clickSave();
		narrativeSummary_Page.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 56)
	public void verifyNarrativeSummaryWithEnglishLang(Hashtable<String, String> data, ITestContext context)
			throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		narrativeSummary_Page = homepage.clickNarrativeSummary();
		narrativeSummary_Page.selectStudent();
		narrativeSummary_Page.selectPeriod(TestUtils.getTestData(data, "NarrativeSummaryPeriod"));
		narrativeSummary_Page.enterReportOptions("12", "13", "14");
		narrativeSummary_Page.selectEnglishLanguage();
		narrativeSummary_Page.enterComments(TestUtils.getTestData(data, "ChecklistComments"));
		narrativeSummary_Page.clickSave();
		narrativeSummary_Page.verifyEnglishLangIsSelected();
		narrativeSummary_Page.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 57)
	public void verifyNarrativeSummaryWithSpanishLang(Hashtable<String, String> data, ITestContext context)
			throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		narrativeSummary_Page = homepage.clickNarrativeSummary();
		narrativeSummary_Page.selectStudent();
		narrativeSummary_Page.selectPeriod(TestUtils.getTestData(data, "NarrativeSummaryPeriod"));
		narrativeSummary_Page.enterReportOptions("12", "13", "14");
		narrativeSummary_Page.selectSpanishLanguage();
		narrativeSummary_Page.enterSpanishComments(TestUtils.getTestData(data, "SpanishComments"));
		narrativeSummary_Page.clickSave();
		narrativeSummary_Page.verifySpanishLangIsSelected();
		narrativeSummary_Page.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 58)
	public void verifyNarrativeSummaryWithBothLang(Hashtable<String, String> data, ITestContext context)
			throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		narrativeSummary_Page = homepage.clickNarrativeSummary();
		narrativeSummary_Page.selectStudent();
		narrativeSummary_Page.selectPeriod(TestUtils.getTestData(data, "NarrativeSummaryPeriod"));
		narrativeSummary_Page.enterReportOptions("12", "13", "14");
		narrativeSummary_Page.selectBothLanguage();
		narrativeSummary_Page.enterComments(TestUtils.getTestData(data, "ChecklistComments"));
		narrativeSummary_Page.enterSpanishComments(TestUtils.getTestData(data, "SpanishComments"));
		narrativeSummary_Page.clickSave();
		narrativeSummary_Page.verifyBothLangIsSelected();
		narrativeSummary_Page.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 59)
	public void verifyDownloadNarrativeSummaryEnglishPdf(Hashtable<String, String> data, ITestContext context)
			throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		narrativeSummary_Page = homepage.clickNarrativeSummary();
		narrativeSummary_Page.selectStudent();
		narrativeSummary_Page.selectPeriod(TestUtils.getTestData(data, "NarrativeSummaryPeriod"));
		narrativeSummary_Page.enterReportOptions("12", "13", "14");
		narrativeSummary_Page.selectEnglishLanguage();
		narrativeSummary_Page.unselectIncludeSummaryAssessments();
		narrativeSummary_Page.enterComments(TestUtils.getTestData(data, "ChecklistComments"));
		narrativeSummary_Page.clickSave();
		narrativeSummary_Page.verifyDownloadNarrativeSummaryEnglishPdf();
		narrativeSummary_Page.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 60)
	public void verifyDownloadNarrativeSummarySpanishPdf(Hashtable<String, String> data, ITestContext context)
			throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		narrativeSummary_Page = homepage.clickNarrativeSummary();
		narrativeSummary_Page.selectStudent();
		narrativeSummary_Page.selectPeriod(TestUtils.getTestData(data, "NarrativeSummaryPeriod"));
		narrativeSummary_Page.enterReportOptions("12", "13", "14");
		narrativeSummary_Page.selectSpanishLanguage();
		narrativeSummary_Page.unselectIncludeSummaryAssessments();
		narrativeSummary_Page.enterSpanishComments(TestUtils.getTestData(data, "SpanishComments"));
		narrativeSummary_Page.clickSave();
		narrativeSummary_Page.verifyDownloadNarrativeSummarySpanishPdf();
		narrativeSummary_Page.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 61)
	public void verifySelectStudentAlsoAttentionMsg(Hashtable<String, String> data, ITestContext context)
			throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		narrativeSummary_Page = homepage.clickNarrativeSummary();
		narrativeSummary_Page.editPeriod("PERIOD 2");
		narrativeSummary_Page.verifySelectStudentAlsoAttentionMsg();
		narrativeSummary_Page.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 62)
	public void verifySaveForDifferentPeriod(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		narrativeSummary_Page = homepage.clickNarrativeSummary();
		narrativeSummary_Page.selectStudent();
		narrativeSummary_Page.selectPeriod(TestUtils.getTestData(data, "NarrativeSummaryPeriod"));
		narrativeSummary_Page.enterReportOptions("12", "13", "14");
		narrativeSummary_Page.selectEnglishLanguage();
		narrativeSummary_Page.enterComments(TestUtils.getTestData(data, "ChecklistComments"));
		narrativeSummary_Page.clickSave();
		narrativeSummary_Page.editPeriod("PERIOD 2");
		narrativeSummary_Page.enterReportOptions("12", "13", "14");
		narrativeSummary_Page.selectEnglishLanguage();
		narrativeSummary_Page.enterComments(TestUtils.getTestData(data, "ChecklistComments"));
		narrativeSummary_Page.clickSave();
		narrativeSummary_Page.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 63)
	public void verifyIncludeStandardSummaryAssessments(Hashtable<String, String> data, ITestContext context)
			throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		narrativeSummary_Page = homepage.clickNarrativeSummary();
		narrativeSummary_Page.selectStudent();
		narrativeSummary_Page.selectPeriod(TestUtils.getTestData(data, "NarrativeSummaryPeriod"));
		narrativeSummary_Page.enterReportOptions("12", "13", "14");
		narrativeSummary_Page.selectEnglishLanguage();
		narrativeSummary_Page.selectIncludeSummaryAssessments();
		narrativeSummary_Page.enterComments(TestUtils.getTestData(data, "ChecklistComments"));
		narrativeSummary_Page.clickSave();
		narrativeSummary_Page.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 64)
	public void verifyDownloadStandardSummaryEnglishPdf(Hashtable<String, String> data, ITestContext context)
			throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		narrativeSummary_Page = homepage.clickNarrativeSummary();
		narrativeSummary_Page.selectStudent();
		narrativeSummary_Page.selectPeriod(TestUtils.getTestData(data, "NarrativeSummaryPeriod"));
		narrativeSummary_Page.enterReportOptions("12", "13", "14");
		narrativeSummary_Page.selectEnglishLanguage();
		narrativeSummary_Page.selectIncludeSummaryAssessments();
		narrativeSummary_Page.enterComments(TestUtils.getTestData(data, "ChecklistComments"));
		narrativeSummary_Page.clickSave();
		narrativeSummary_Page.verifyDownloadStandardSummaryEnglishPdf();
		narrativeSummary_Page.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 65)
	public void verifyDownloadStandardSummarySpanishPdf(Hashtable<String, String> data, ITestContext context)
			throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		narrativeSummary_Page = homepage.clickNarrativeSummary();
		narrativeSummary_Page.selectStudent();
		narrativeSummary_Page.selectPeriod(TestUtils.getTestData(data, "NarrativeSummaryPeriod"));
		narrativeSummary_Page.enterReportOptions("12", "13", "14");
		narrativeSummary_Page.selectSpanishLanguage();
		narrativeSummary_Page.selectIncludeSummaryAssessments();
		narrativeSummary_Page.enterSpanishComments(TestUtils.getTestData(data, "SpanishComments"));
		narrativeSummary_Page.clickSave();
		narrativeSummary_Page.verifyDownloadStandardSummarySpanishPdf();
		narrativeSummary_Page.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 66)
	public void verifyDownloadClassSummaryEnglishPdf(Hashtable<String, String> data, ITestContext context)
			throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		narrativeSummary_Page = homepage.clickNarrativeSummary();
		narrativeSummary_Page.selectStudent();
		narrativeSummary_Page.selectPeriod(TestUtils.getTestData(data, "NarrativeSummaryPeriod"));
		narrativeSummary_Page.enterReportOptions("12", "13", "14");
		narrativeSummary_Page.selectEnglishLanguage();
		narrativeSummary_Page.selectIncludeSummaryAssessments();
		narrativeSummary_Page.enterComments(TestUtils.getTestData(data, "ChecklistComments"));
		narrativeSummary_Page.clickSave();
		narrativeSummary_Page.verifyDownloadClassSummaryEnglishPdf();
		narrativeSummary_Page.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 67)
	public void verifyPopulateChecklistButton(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		narrativeSummary_Page = homepage.clickNarrativeSummary();
		narrativeSummary_Page.selectStudent();
		narrativeSummary_Page.selectPeriod("PERIOD 3");
		narrativeSummary_Page.enterReportOptions("12", "13", "14");
		narrativeSummary_Page.selectEnglishLanguage();
		narrativeSummary_Page.selectIncludeSummaryAssessments();
		narrativeSummary_Page.verifyPopulateChecklistButton();
		narrativeSummary_Page.enterComments(TestUtils.getTestData(data, "ChecklistComments"));
		narrativeSummary_Page.clickSave();
		narrativeSummary_Page.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 68)
	public void verifyPopulateChecklistWithPartialScores(Hashtable<String, String> data, ITestContext context)
			throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		enterChecklist_Page = homepage.clickNewChecklist();
		enterChecklist_Page.selectStudent();
		enterChecklistData_Page = enterChecklist_Page.enterDomain3Data();
		enterChecklistData_Page.selectIndicators();
		enterChecklistData_Page.enterComments(TestUtils.getTestData(data, "ChecklistComments"));
		enterChecklist_Page = enterChecklistData_Page.clickBackForChecklist();
		enterChecklist_Page.clickFlagAsFinalDomain3();
		homepage = enterChecklist_Page.clickPageTitle();
		narrativeSummary_Page = homepage.clickNarrativeSummary();
		narrativeSummary_Page.selectStudent();
		narrativeSummary_Page.selectPeriod("PERIOD 3");
		narrativeSummary_Page.enterReportOptions("12", "13", "14");
		narrativeSummary_Page.selectEnglishLanguage();
		narrativeSummary_Page.selectIncludeSummaryAssessments();
		narrativeSummary_Page.enterComments(TestUtils.getTestData(data, "ChecklistComments"));
		narrativeSummary_Page.verifyPopulateChecklistWithPartialScores();
		narrativeSummary_Page.clickSave();
		narrativeSummary_Page.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 69, dependsOnMethods = "verifyPopulateChecklistWithPartialScores")
	public void verifyPopulateChecklistWithExistingScores(Hashtable<String, String> data, ITestContext context)
			throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		narrativeSummary_Page = homepage.clickNarrativeSummary();
		narrativeSummary_Page.selectStudent();
		narrativeSummary_Page.selectPeriod("PERIOD 3");
		narrativeSummary_Page.verifyPopulateChecklistWithExistingScores();
		narrativeSummary_Page.clickSave();
		narrativeSummary_Page.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 70)
	public void verifyPopulateChecklistWithEmptyScores(Hashtable<String, String> data, ITestContext context)
			throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		narrativeSummary_Page = homepage.clickNarrativeSummary();
		narrativeSummary_Page.selectStudent();
		narrativeSummary_Page.selectPeriod("PERIOD 2");
		narrativeSummary_Page.enterComments(TestUtils.getTestData(data, "ChecklistComments"));
		narrativeSummary_Page.selectIncludeSummaryAssessments();
		narrativeSummary_Page.verifyPopulateChecklistWithEmptyScores();
		narrativeSummary_Page.clickSave();
		narrativeSummary_Page.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 71, dependsOnMethods = "verifyPopulateChecklistWithPartialScores")
	public void verifyPopulateChecklistWithClearedScores(Hashtable<String, String> data, ITestContext context)
			throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		enterChecklist_Page = homepage.clickNewChecklist();
		enterChecklist_Page.selectStudent();
		enterChecklist_Page.clearChecklistDomain3();
		homepage = enterChecklist_Page.clickPageTitle();
		narrativeSummary_Page = homepage.clickNarrativeSummary();
		narrativeSummary_Page.selectStudent();
		narrativeSummary_Page.selectPeriod("PERIOD 3");
		narrativeSummary_Page.verifyPopulateChecklistWithClearedScores();
		narrativeSummary_Page.clickSave();
		narrativeSummary_Page.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 72, dependsOnMethods = "verifyPopulateChecklistWithClearedScores")
	public void verifyPopulateChecklistWithDeletedScores(Hashtable<String, String> data, ITestContext context)
			throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		enterChecklist_Page = homepage.clickNewChecklist();
		enterChecklist_Page.selectStudent();
		enterChecklist_Page.deleteChecklistDomain3();
		homepage = enterChecklist_Page.clickPageTitle();
		narrativeSummary_Page = homepage.clickNarrativeSummary();
		narrativeSummary_Page.selectStudent();
		narrativeSummary_Page.selectPeriod("PERIOD 3");
		narrativeSummary_Page.verifyPopulateChecklistWithDeletedScores();
		narrativeSummary_Page.clickSave();
		narrativeSummary_Page.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 73)
	public void verifyPopulateChecklistWhenInIntermediateState(Hashtable<String, String> data, ITestContext context)
			throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		enterChecklist_Page = homepage.clickNewChecklist();
		enterChecklist_Page.selectStudent();
		enterChecklistData_Page = enterChecklist_Page.enterDomain3Data();
		enterChecklistData_Page.selectIndicators();
		enterChecklistData_Page.enterComments(TestUtils.getTestData(data, "ChecklistComments"));
		enterChecklist_Page = enterChecklistData_Page.clickBackForChecklist();
		homepage = enterChecklist_Page.clickPageTitle();
		narrativeSummary_Page = homepage.clickNarrativeSummary();
		narrativeSummary_Page.selectStudent();
		narrativeSummary_Page.selectPeriod("PERIOD 3");
		narrativeSummary_Page.enterReportOptions("12", "13", "14");
		narrativeSummary_Page.selectEnglishLanguage();
		narrativeSummary_Page.selectIncludeSummaryAssessments();
		narrativeSummary_Page.enterComments(TestUtils.getTestData(data, "ChecklistComments"));
		narrativeSummary_Page.verifyPopulateChecklistWhenInIntermediateState();
		narrativeSummary_Page.clickSave();
		narrativeSummary_Page.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Sanity", priority = 86)
	public void createHsSummaryReport(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		narrativeSummary_Page = homepage.clickHeadStartNarrativeSummary();
		narrativeSummary_Page.selectStudent();
		narrativeSummary_Page.selectPeriod(TestUtils.getTestData(data, "NarrativeSummaryPeriod"));
		narrativeSummary_Page.enterReportOptions("12", "13", "14");
		narrativeSummary_Page.enterComments(TestUtils.getTestData(data, "ChecklistComments"));
		narrativeSummary_Page.clickSave();
		narrativeSummary_Page.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 87)
	public void verifyAddChecklistCommentHS(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		narrativeSummary_Page = homepage.clickHeadStartNarrativeSummary();
		narrativeSummary_Page.selectStudent();
		narrativeSummary_Page.selectPeriod(TestUtils.getTestData(data, "NarrativeSummaryPeriod"));
		narrativeSummary_Page.enterReportOptions("12", "13", "14");
		narrativeSummary_Page.addChecklistComment();
		narrativeSummary_Page.clickSave();
		narrativeSummary_Page.verifyAddedChecklistComment();
		narrativeSummary_Page.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 88)
	public void autoSaveCommentsHS(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		narrativeSummary_Page = homepage.clickHeadStartNarrativeSummary();
		narrativeSummary_Page.selectStudent();
		narrativeSummary_Page.selectPeriod(TestUtils.getTestData(data, "NarrativeSummaryPeriod"));
		narrativeSummary_Page.enterReportOptions("12", "13", "14");
		narrativeSummary_Page.enterComments(TestUtils.getTestData(data, "ChecklistComments"));
		narrativeSummary_Page.verifyAutoSaveComments();
		narrativeSummary_Page.clickSave();
		narrativeSummary_Page.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 89)
	public void deleteHeadStartSummary(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		narrativeSummary_Page = homepage.clickHeadStartNarrativeSummary();
		narrativeSummary_Page.selectStudent();
		narrativeSummary_Page.selectPeriod(TestUtils.getTestData(data, "NarrativeSummaryPeriod"));
		narrativeSummary_Page.enterReportOptions("12", "13", "14");
		narrativeSummary_Page.enterComments(TestUtils.getTestData(data, "ChecklistComments"));
		narrativeSummary_Page.clickSave();
		narrativeSummary_Page.verifyDeleteNarrativeSummary();
		narrativeSummary_Page.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 90)
	public void verifySaveTemplateHS(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		narrativeSummary_Page = homepage.clickHeadStartNarrativeSummary();
		narrativeSummary_Page.selectStudent();
		narrativeSummary_Page.selectPeriod(TestUtils.getTestData(data, "NarrativeSummaryPeriod"));
		narrativeSummary_Page.enterReportOptions("12", "13", "14");
		narrativeSummary_Page.enterComments(TestUtils.getTestData(data, "ChecklistComments"));
		narrativeSummary_Page.clickSave();
		narrativeSummary_Page.verifySaveTemplate();
		narrativeSummary_Page.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 91)
	public void verifyUseTemplateHS(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		narrativeSummary_Page = homepage.clickHeadStartNarrativeSummary();
		narrativeSummary_Page.selectStudent();
		narrativeSummary_Page.selectPeriod(TestUtils.getTestData(data, "NarrativeSummaryPeriod"));
		narrativeSummary_Page.enterReportOptions("12", "13", "14");
		narrativeSummary_Page.clickUseTemplate();
		narrativeSummary_Page.clickSave();
		narrativeSummary_Page.verifyUseTemplate();
		narrativeSummary_Page.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 92)
	public void verifyCommentsCounterForHS(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		narrativeSummary_Page = homepage.clickHeadStartNarrativeSummary();
		narrativeSummary_Page.selectStudent();
		narrativeSummary_Page.selectPeriod(TestUtils.getTestData(data, "NarrativeSummaryPeriod"));
		narrativeSummary_Page.enterComments(TestUtils.getTestData(data, "ChecklistComments"));
		narrativeSummary_Page.verifyCommentCounter();
		narrativeSummary_Page.clickSave();
		narrativeSummary_Page.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 93)
	public void verifyHSSummaryWithEnglishLang(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		narrativeSummary_Page = homepage.clickHeadStartNarrativeSummary();
		narrativeSummary_Page.selectStudent();
		narrativeSummary_Page.selectPeriod(TestUtils.getTestData(data, "NarrativeSummaryPeriod"));
		narrativeSummary_Page.enterReportOptions("12", "13", "14");
		narrativeSummary_Page.selectEnglishLanguage();
		narrativeSummary_Page.enterComments(TestUtils.getTestData(data, "ChecklistComments"));
		narrativeSummary_Page.clickSave();
		narrativeSummary_Page.verifyEnglishLangIsSelected();
		narrativeSummary_Page.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 94)
	public void verifyHSSummaryWithSpanishLang(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		narrativeSummary_Page = homepage.clickHeadStartNarrativeSummary();
		narrativeSummary_Page.selectStudent();
		narrativeSummary_Page.selectPeriod(TestUtils.getTestData(data, "NarrativeSummaryPeriod"));
		narrativeSummary_Page.enterReportOptions("12", "13", "14");
		narrativeSummary_Page.selectSpanishLanguage();
		narrativeSummary_Page.enterSpanishComments(TestUtils.getTestData(data, "SpanishComments"));
		narrativeSummary_Page.clickSave();
		narrativeSummary_Page.verifySpanishLangIsSelected();
		narrativeSummary_Page.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 95)
	public void verifyHSSummaryWithBothLang(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		narrativeSummary_Page = homepage.clickHeadStartNarrativeSummary();
		narrativeSummary_Page.selectStudent();
		narrativeSummary_Page.selectPeriod(TestUtils.getTestData(data, "NarrativeSummaryPeriod"));
		narrativeSummary_Page.enterReportOptions("12", "13", "14");
		narrativeSummary_Page.selectBothLanguage();
		narrativeSummary_Page.enterComments(TestUtils.getTestData(data, "ChecklistComments"));
		narrativeSummary_Page.enterSpanishComments(TestUtils.getTestData(data, "SpanishComments"));
		narrativeSummary_Page.clickSave();
		narrativeSummary_Page.verifyBothLangIsSelected();
		narrativeSummary_Page.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 96)
	public void verifyDownloadHSSummaryEnglishPdf(Hashtable<String, String> data, ITestContext context)
			throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		narrativeSummary_Page = homepage.clickHeadStartNarrativeSummary();
		narrativeSummary_Page.selectStudent();
		narrativeSummary_Page.selectPeriod(TestUtils.getTestData(data, "NarrativeSummaryPeriod"));
		narrativeSummary_Page.enterReportOptions("12", "13", "14");
		narrativeSummary_Page.selectEnglishLanguage();
		narrativeSummary_Page.unselectIncludeSummaryAssessments();
		narrativeSummary_Page.enterComments(TestUtils.getTestData(data, "ChecklistComments"));
		narrativeSummary_Page.clickSave();
		narrativeSummary_Page.verifyDownloadHSSummaryEnglishPdf();
		narrativeSummary_Page.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 97)
	public void verifyDownloadHSSummarySpanishPdf(Hashtable<String, String> data, ITestContext context)
			throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		narrativeSummary_Page = homepage.clickHeadStartNarrativeSummary();
		narrativeSummary_Page.selectStudent();
		narrativeSummary_Page.selectPeriod(TestUtils.getTestData(data, "NarrativeSummaryPeriod"));
		narrativeSummary_Page.enterReportOptions("12", "13", "14");
		narrativeSummary_Page.selectSpanishLanguage();
		narrativeSummary_Page.unselectIncludeSummaryAssessments();
		narrativeSummary_Page.enterSpanishComments(TestUtils.getTestData(data, "SpanishComments"));
		narrativeSummary_Page.clickSave();
		narrativeSummary_Page.verifyDownloadHSSummarySpanishPdf();
		narrativeSummary_Page.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 98)
	public void verifySelectStudentAlsoAttentionMsgForHS(Hashtable<String, String> data, ITestContext context)
			throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		narrativeSummary_Page = homepage.clickHeadStartNarrativeSummary();
		narrativeSummary_Page.editPeriod("PERIOD 2");
		narrativeSummary_Page.verifySelectStudentAlsoAttentionMsg();
		narrativeSummary_Page.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 99)
	public void verifySaveForDifferentPeriodForHS(Hashtable<String, String> data, ITestContext context)
			throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		narrativeSummary_Page = homepage.clickHeadStartNarrativeSummary();
		narrativeSummary_Page.selectStudent();
		narrativeSummary_Page.selectPeriod(TestUtils.getTestData(data, "NarrativeSummaryPeriod"));
		narrativeSummary_Page.enterReportOptions("12", "13", "14");
		narrativeSummary_Page.selectEnglishLanguage();
		narrativeSummary_Page.enterComments(TestUtils.getTestData(data, "ChecklistComments"));
		narrativeSummary_Page.clickSave();
		narrativeSummary_Page.editPeriod("PERIOD 2");
		narrativeSummary_Page.enterReportOptions("12", "13", "14");
		narrativeSummary_Page.selectEnglishLanguage();
		narrativeSummary_Page.enterComments(TestUtils.getTestData(data, "ChecklistComments"));
		narrativeSummary_Page.clickSave();
		narrativeSummary_Page.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 100)
	public void verifyIncludeStandardSummaryAssessmentsForHS(Hashtable<String, String> data, ITestContext context)
			throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		narrativeSummary_Page = homepage.clickHeadStartNarrativeSummary();
		narrativeSummary_Page.selectStudent();
		narrativeSummary_Page.selectPeriod(TestUtils.getTestData(data, "NarrativeSummaryPeriod"));
		narrativeSummary_Page.enterReportOptions("12", "13", "14");
		narrativeSummary_Page.selectEnglishLanguage();
		narrativeSummary_Page.selectIncludeSummaryAssessments();
		narrativeSummary_Page.enterComments(TestUtils.getTestData(data, "ChecklistComments"));
		narrativeSummary_Page.clickSave();
		narrativeSummary_Page.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 101)
	public void verifyPopulateChecklistButtonForHS(Hashtable<String, String> data, ITestContext context)
			throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		narrativeSummary_Page = homepage.clickHeadStartNarrativeSummary();
		narrativeSummary_Page.selectStudent();
		narrativeSummary_Page.selectPeriod("PERIOD 3");
		narrativeSummary_Page.enterReportOptions("12", "13", "14");
		narrativeSummary_Page.selectEnglishLanguage();
		narrativeSummary_Page.selectIncludeSummaryAssessments();
		narrativeSummary_Page.verifyPopulateChecklistButton();
		narrativeSummary_Page.enterComments(TestUtils.getTestData(data, "ChecklistComments"));
		narrativeSummary_Page.clickSave();
		narrativeSummary_Page.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 102)
	public void verifyPopulateChecklistWithPartialScoresHS(Hashtable<String, String> data, ITestContext context)
			throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		enterChecklist_Page = homepage.clickNewChecklist();
		enterChecklist_Page.selectStudent();
		enterChecklistData_Page = enterChecklist_Page.enterDomain3Data();
		enterChecklistData_Page.selectIndicators();
		enterChecklistData_Page.enterComments(TestUtils.getTestData(data, "ChecklistComments"));
		enterChecklist_Page = enterChecklistData_Page.clickBackForChecklist();
		enterChecklist_Page.clickFlagAsFinalForHsStudentDomain3();
		homepage = enterChecklist_Page.clickPageTitle();
		narrativeSummary_Page = homepage.clickHeadStartNarrativeSummary();
		narrativeSummary_Page.selectStudent();
		narrativeSummary_Page.selectPeriod("PERIOD 3");
		narrativeSummary_Page.enterReportOptions("12", "13", "14");
		narrativeSummary_Page.selectEnglishLanguage();
		narrativeSummary_Page.selectIncludeSummaryAssessments();
		narrativeSummary_Page.enterComments(TestUtils.getTestData(data, "ChecklistComments"));
		narrativeSummary_Page.verifyPopulateChecklistWithPartialScores();
		narrativeSummary_Page.clickSave();
		narrativeSummary_Page.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 103, dependsOnMethods = "verifyPopulateChecklistWithPartialScoresHS")
	public void verifyPopulateChecklistWithExistingScoresHS(Hashtable<String, String> data, ITestContext context)
			throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		narrativeSummary_Page = homepage.clickHeadStartNarrativeSummary();
		narrativeSummary_Page.selectStudent();
		narrativeSummary_Page.selectPeriod("PERIOD 3");
		narrativeSummary_Page.verifyPopulateChecklistWithExistingScores();
		narrativeSummary_Page.clickSave();
		narrativeSummary_Page.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 104)
	public void verifyPopulateChecklistWithEmptyScoresHS(Hashtable<String, String> data, ITestContext context)
			throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		narrativeSummary_Page = homepage.clickHeadStartNarrativeSummary();
		narrativeSummary_Page.selectStudent();
		narrativeSummary_Page.selectPeriod("PERIOD 2");
		narrativeSummary_Page.enterComments(TestUtils.getTestData(data, "ChecklistComments"));
		narrativeSummary_Page.selectIncludeSummaryAssessments();
		narrativeSummary_Page.verifyPopulateChecklistWithEmptyScores();
		narrativeSummary_Page.clickSave();
		narrativeSummary_Page.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 105, dependsOnMethods = "verifyPopulateChecklistWithPartialScoresHS")
	public void verifyPopulateChecklistWithClearedScoresHS(Hashtable<String, String> data, ITestContext context)
			throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		enterChecklist_Page = homepage.clickNewChecklist();
		enterChecklist_Page.selectStudent();
		enterChecklist_Page.clearChecklistDomain3();
		homepage = enterChecklist_Page.clickPageTitle();
		narrativeSummary_Page = homepage.clickHeadStartNarrativeSummary();
		narrativeSummary_Page.selectStudent();
		narrativeSummary_Page.selectPeriod("PERIOD 3");
		narrativeSummary_Page.verifyPopulateChecklistWithClearedScores();
		narrativeSummary_Page.clickSave();
		narrativeSummary_Page.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 106, dependsOnMethods = "verifyPopulateChecklistWithClearedScoresHS")
	public void verifyPopulateChecklistWithDeletedScoresHS(Hashtable<String, String> data, ITestContext context)
			throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		enterChecklist_Page = homepage.clickNewChecklist();
		enterChecklist_Page.selectStudent();
		enterChecklist_Page.deleteChecklistDomain3();
		homepage = enterChecklist_Page.clickPageTitle();
		narrativeSummary_Page = homepage.clickHeadStartNarrativeSummary();
		narrativeSummary_Page.selectStudent();
		narrativeSummary_Page.selectPeriod("PERIOD 3");
		narrativeSummary_Page.verifyPopulateChecklistWithDeletedScores();
		narrativeSummary_Page.clickSave();
		narrativeSummary_Page.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 107, dependsOnMethods = {
			"verifyPopulateChecklistWithClearedScoresHS", "verifyPopulateChecklistWithDeletedScoresHS" })
	public void verifyPopulateChecklistWhenInIntermediateStateHS(Hashtable<String, String> data, ITestContext context)
			throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		enterChecklist_Page = homepage.clickNewChecklist();
		enterChecklist_Page.selectStudent();
		enterChecklistData_Page = enterChecklist_Page.enterDomain3Data();
		enterChecklistData_Page.selectIndicators();
		enterChecklistData_Page.enterComments(TestUtils.getTestData(data, "ChecklistComments"));
		enterChecklist_Page = enterChecklistData_Page.clickBackForChecklist();
		homepage = enterChecklist_Page.clickPageTitle();
		narrativeSummary_Page = homepage.clickHeadStartNarrativeSummary();
		narrativeSummary_Page.selectStudent();
		narrativeSummary_Page.selectPeriod("PERIOD 3");
		narrativeSummary_Page.enterReportOptions("12", "13", "14");
		narrativeSummary_Page.selectEnglishLanguage();
		narrativeSummary_Page.selectIncludeSummaryAssessments();
		narrativeSummary_Page.enterComments(TestUtils.getTestData(data, "ChecklistComments"));
		narrativeSummary_Page.verifyPopulateChecklistWhenInIntermediateState();
		narrativeSummary_Page.clickSave();
		narrativeSummary_Page.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Sanity", priority = 108)
	public void createHsFamilySummaryReport(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		narrativeSummary_Page = homepage.clickHeadStartFamilySummary();
		narrativeSummary_Page.selectStudent();
		narrativeSummary_Page.selectPeriodForHSFS(TestUtils.getTestData(data, "NarrativeSummaryPeriod"));
		narrativeSummary_Page.enterReportOptions("12", "13", "14");
		narrativeSummary_Page.selectDomainChkScore();
		narrativeSummary_Page.clickSave();
		narrativeSummary_Page.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 109)
	public void deleteHeadStartFamilySummary(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		narrativeSummary_Page = homepage.clickHeadStartFamilySummary();
		narrativeSummary_Page.selectStudent();
		narrativeSummary_Page.selectPeriodForHSFS(TestUtils.getTestData(data, "NarrativeSummaryPeriod"));
		narrativeSummary_Page.enterReportOptions("12", "13", "14");
		narrativeSummary_Page.selectDomainChkScore();
		narrativeSummary_Page.clickSave();
		narrativeSummary_Page.verifyDeleteNarrativeSummary();
		narrativeSummary_Page.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 110)
	public void verifySaveTemplateHSFS(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		narrativeSummary_Page = homepage.clickHeadStartFamilySummary();
		narrativeSummary_Page.selectStudent();
		narrativeSummary_Page.selectPeriodForHSFS(TestUtils.getTestData(data, "NarrativeSummaryPeriod"));
		narrativeSummary_Page.enterReportOptions("12", "13", "14");
		narrativeSummary_Page.selectDomainChkScore();
		narrativeSummary_Page.enterCommentsHSFS("Teacher comments for HeadStart Family Summary");
		narrativeSummary_Page.clickSave();
		narrativeSummary_Page.verifySaveTemplateHSFS();
		narrativeSummary_Page.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 111)
	public void verifyUseTemplateHSFS(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		narrativeSummary_Page = homepage.clickHeadStartFamilySummary();
		narrativeSummary_Page.selectStudent();
		narrativeSummary_Page.selectPeriodForHSFS(TestUtils.getTestData(data, "NarrativeSummaryPeriod"));
		narrativeSummary_Page.enterReportOptions("12", "13", "14");
		narrativeSummary_Page.selectDomainChkScore();
		narrativeSummary_Page.clickUseTemplate();
		narrativeSummary_Page.clickSave();
		narrativeSummary_Page.verifyUseTemplateHSFS();
		narrativeSummary_Page.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 112)
	public void verifyCommentsCounterForHSFS(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		narrativeSummary_Page = homepage.clickHeadStartFamilySummary();
		narrativeSummary_Page.selectStudent();
		narrativeSummary_Page.selectPeriodForHSFS(TestUtils.getTestData(data, "NarrativeSummaryPeriod"));
		narrativeSummary_Page.enterReportOptions("12", "13", "14");
		narrativeSummary_Page.selectDomainChkScore();
		narrativeSummary_Page.enterCommentsHSFS("Teacher comments for HeadStart Family Summary");
		narrativeSummary_Page.verifyCommentCounterHSFS();
		narrativeSummary_Page.clickSave();
		narrativeSummary_Page.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 113)
	public void verifyHSFSWithEnglishLang(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		narrativeSummary_Page = homepage.clickHeadStartFamilySummary();
		narrativeSummary_Page.selectStudent();
		narrativeSummary_Page.selectPeriodForHSFS(TestUtils.getTestData(data, "NarrativeSummaryPeriod"));
		narrativeSummary_Page.enterReportOptions("12", "13", "14");
		narrativeSummary_Page.selectEnglishLanguage();
		narrativeSummary_Page.selectDomainChkScore();
		narrativeSummary_Page.enterCommentsHSFS("Teacher english comments for HeadStart Family Summary");
		narrativeSummary_Page.clickSave();
		narrativeSummary_Page.verifyEnglishLangIsSelected();
		narrativeSummary_Page.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 114)
	public void verifyHSFSWithSpanishLang(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		narrativeSummary_Page = homepage.clickHeadStartFamilySummary();
		narrativeSummary_Page.selectStudent();
		narrativeSummary_Page.selectPeriodForHSFS(TestUtils.getTestData(data, "NarrativeSummaryPeriod"));
		narrativeSummary_Page.enterReportOptions("12", "13", "14");
		narrativeSummary_Page.selectSpanishLanguage();
		narrativeSummary_Page.selectDomainChkScore();
		narrativeSummary_Page.enterSpanishCommentsHSFS("Teacher spanish comments for HeadStart Family Summary");
		narrativeSummary_Page.clickSave();
		narrativeSummary_Page.verifySpanishLangIsSelected();
		narrativeSummary_Page.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 115)
	public void verifyHSFSWithBothLang(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		narrativeSummary_Page = homepage.clickHeadStartFamilySummary();
		narrativeSummary_Page.selectStudent();
		narrativeSummary_Page.selectPeriodForHSFS(TestUtils.getTestData(data, "NarrativeSummaryPeriod"));
		narrativeSummary_Page.enterReportOptions("12", "13", "14");
		narrativeSummary_Page.selectBothLanguage();
		narrativeSummary_Page.selectDomainChkScore();
		narrativeSummary_Page.enterCommentsHSFS("Teacher english comments for HeadStart Family Summary");
		narrativeSummary_Page.enterSpanishCommentsHSFS("Teacher spanish comments for HeadStart Family Summary");
		narrativeSummary_Page.clickSave();
		narrativeSummary_Page.verifyBothLangIsSelected();
		narrativeSummary_Page.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 116)
	public void verifyDownloadHSFSEnglishPdf(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		narrativeSummary_Page = homepage.clickHeadStartFamilySummary();
		narrativeSummary_Page.selectStudent();
		narrativeSummary_Page.selectPeriodForHSFS(TestUtils.getTestData(data, "NarrativeSummaryPeriod"));
		narrativeSummary_Page.enterReportOptions("12", "13", "14");
		narrativeSummary_Page.selectEnglishLanguage();
		narrativeSummary_Page.selectDomainChkScore();
		narrativeSummary_Page.clickSave();
		narrativeSummary_Page.verifyDownloadHSFSEnglishPdf();
		narrativeSummary_Page.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 117)
	public void verifyDownloadHSFSSpanishPdf(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		narrativeSummary_Page = homepage.clickHeadStartFamilySummary();
		narrativeSummary_Page.selectStudent();
		narrativeSummary_Page.selectPeriodForHSFS(TestUtils.getTestData(data, "NarrativeSummaryPeriod"));
		narrativeSummary_Page.enterReportOptions("12", "13", "14");
		narrativeSummary_Page.selectSpanishLanguage();
		narrativeSummary_Page.selectDomainChkScore();
		narrativeSummary_Page.clickSave();
		narrativeSummary_Page.verifyDownloadHSFSSpanishPdf();
		narrativeSummary_Page.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 118)
	public void verifyHSFSWithUncheckAnyDomain(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		narrativeSummary_Page = homepage.clickHeadStartFamilySummary();
		narrativeSummary_Page.selectStudent();
		narrativeSummary_Page.selectPeriodForHSFS(TestUtils.getTestData(data, "NarrativeSummaryPeriod"));
		narrativeSummary_Page.enterReportOptions("12", "13", "14");
		narrativeSummary_Page.selectEnglishLanguage();
		narrativeSummary_Page.selectDomainChkScore();
		narrativeSummary_Page.uncheckDomainOne();
		narrativeSummary_Page.clickSave();
		narrativeSummary_Page.verifyHSFSWithUncheckAnyDomain();
		narrativeSummary_Page.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 119)
	public void verifySaveForDifferentPeriodForHSFS(Hashtable<String, String> data, ITestContext context)
			throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		narrativeSummary_Page = homepage.clickHeadStartFamilySummary();
		narrativeSummary_Page.selectStudent();
		narrativeSummary_Page.selectPeriodForHSFS(TestUtils.getTestData(data, "NarrativeSummaryPeriod"));
		narrativeSummary_Page.enterReportOptions("12", "13", "14");
		narrativeSummary_Page.clickSave();
		narrativeSummary_Page.editPeriod("PERIOD 2");
		narrativeSummary_Page.enterReportOptions("12", "13", "14");
		narrativeSummary_Page.selectEnglishLanguage();
		narrativeSummary_Page.selectDomainChkScore();
		narrativeSummary_Page.clickSave();
		narrativeSummary_Page.logout();
	}
}