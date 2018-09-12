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
import com.ness.pages.ManageChecklist_Page;
import com.ness.utilities.TestUtils;
import com.ness.utilities.Xls_Reader;

public class Checklists {
	Home_Page homepage;
	EnterChecklist_Page enterChecklist_Page;
	EnterChecklistData_Page enterChecklistData_Page;
	ManageChecklist_Page manageChecklist_Page;
	Logout_Page logoutPage;

	private final static String testData = Constants.TESTDATA_LOC;
	private static Xls_Reader xls = new Xls_Reader(testData);

	@DataProvider
	private Object[][] getTestData() {
		System.out.println("Executing DataProvider");
		return TestUtils.getData("Work", xls);
	}

	@Test(dataProvider = "getTestData", groups = "Sanity", priority = 39)
	public void verifyCreateChecklist(Hashtable<String, String> data, ITestContext context) throws Exception {

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
		enterChecklistData_Page = enterChecklist_Page.enterDomainData();
		enterChecklistData_Page.selectIndicators();
		enterChecklistData_Page.enterComments(TestUtils.getTestData(data, "ChecklistComments"));
		enterChecklist_Page = enterChecklistData_Page.clickBackForChecklist();
		enterChecklist_Page.clickFlagAsFinal();
		enterChecklist_Page.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Sanity", priority = 40)
	public void verifyClearChecklist(Hashtable<String, String> data, ITestContext context) throws Exception {

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
		enterChecklist_Page.clearChecklist();
		enterChecklist_Page.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Sanity", priority = 41)
	public void verifyDeleteChecklist(Hashtable<String, String> data, ITestContext context) throws Exception {

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
		enterChecklist_Page.deleteChecklist();
		enterChecklist_Page.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Sanity", priority = 42)
	public void verifyAutoSaveComments(Hashtable<String, String> data, ITestContext context) throws Exception {

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
		enterChecklistData_Page = enterChecklist_Page.enterDomainData();
		enterChecklistData_Page.selectIndicators();
		enterChecklistData_Page.enterComments(TestUtils.getTestData(data, "ChecklistComments"));
		enterChecklistData_Page.verifyAutosaveComments();
		enterChecklist_Page = enterChecklistData_Page.clickBackForChecklist();
		enterChecklist_Page.clickFlagAsFinal();
		enterChecklist_Page.deleteChecklist();
		enterChecklist_Page.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Sanity", priority = 43)
	public void verifyNavigationViaManageChecklist(Hashtable<String, String> data, ITestContext context)
			throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		manageChecklist_Page = homepage.clickManageChecklist();
		enterChecklist_Page = manageChecklist_Page.clickGetStarted();
		enterChecklistData_Page = enterChecklist_Page.enterDomainData();
		enterChecklistData_Page.selectIndicators();
		enterChecklistData_Page.enterComments(TestUtils.getTestData(data, "ChecklistComments"));
		enterChecklist_Page = enterChecklistData_Page.clickBackForChecklist();
		enterChecklist_Page.clickFlagAsFinal();
		enterChecklist_Page.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Sanity", priority = 44)
	public void verifyStudentDataIsDisplayed(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		manageChecklist_Page = homepage.clickManageChecklist();
		enterChecklist_Page = manageChecklist_Page.clickGetStarted();
		enterChecklist_Page.verifyStudentDataIsDisplayed();
		enterChecklist_Page.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Sanity", priority = 45)
	public void verifyNextPreviousLinks(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		manageChecklist_Page = homepage.clickManageChecklist();
		enterChecklist_Page = manageChecklist_Page.clickGetStarted();
		enterChecklistData_Page = enterChecklist_Page.enterDomainData();
		enterChecklistData_Page.verifyPreviousButton();
		enterChecklistData_Page.verifyNextButton();
		enterChecklistData_Page.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Sanity", priority = 46)
	public void verifyGuidelines(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		manageChecklist_Page = homepage.clickManageChecklist();
		enterChecklist_Page = manageChecklist_Page.clickGetStarted();
		enterChecklistData_Page = enterChecklist_Page.enterDomainData();
		enterChecklistData_Page.verifyGuidelines();
		enterChecklistData_Page.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Sanity", priority = 47)
	public void verifyEvidenceLinked(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		manageChecklist_Page = homepage.clickManageChecklist();
		enterChecklist_Page = manageChecklist_Page.clickGetStarted();
		enterChecklistData_Page = enterChecklist_Page.enterDomainData();
		enterChecklistData_Page.verifyEvidenceLinked();
		enterChecklistData_Page.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Sanity", priority = 48)
	public void verifyEvidenceUnlinked(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		manageChecklist_Page = homepage.clickManageChecklist();
		enterChecklist_Page = manageChecklist_Page.clickGetStarted();
		enterChecklistData_Page = enterChecklist_Page.enterDomainData();
		enterChecklistData_Page.verifyEvidenceUnLinked();
		enterChecklistData_Page.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Sanity", priority = 85)
	public void createChecklistForHsStudent(Hashtable<String, String> data, ITestContext context) throws Exception {

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
		enterChecklistData_Page = enterChecklist_Page.enterDomainData();
		enterChecklistData_Page.selectIndicators();
		enterChecklistData_Page.enterComments(TestUtils.getTestData(data, "ChecklistComments"));
		enterChecklist_Page = enterChecklistData_Page.clickBackForChecklist();
		enterChecklist_Page.clickFlagAsFinalForHsStudent();
		enterChecklist_Page.logout();
	}
}