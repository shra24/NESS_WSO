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

public class DevelopmentalProfile {

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
		return TestUtils.getData("Ounce", xls);
	}

	@Test(dataProvider = "getTestData", groups = "Sanity", priority = 152)
	public void verifyCreateDevProfile(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		enterChecklist_Page = homepage.clickNewChecklistOunce();
		enterChecklist_Page.selectStudent();
		enterChecklistData_Page = enterChecklist_Page.enterDomainData();
		enterChecklistData_Page.selectOunceIndicators();
		enterChecklistData_Page.enterCommentsOunce(TestUtils.getTestData(data, "DevProfileComments"));
		enterChecklist_Page = enterChecklistData_Page.clickBackForChecklist();
		enterChecklist_Page.clickFlagAsFinalOunce();
		enterChecklist_Page.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Sanity", priority = 153)
	public void verifyClearDevProfile(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		enterChecklist_Page = homepage.clickNewChecklistOunce();
		enterChecklist_Page.selectStudent();
		enterChecklist_Page.clearChecklistOunce();
		enterChecklist_Page.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Sanity", priority = 154)
	public void verifyDeleteDevProfile(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		enterChecklist_Page = homepage.clickNewChecklistOunce();
		enterChecklist_Page.selectStudent();
		enterChecklist_Page.deleteChecklistOunce();
		enterChecklist_Page.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Sanity", priority = 155)
	public void verifyAutoSaveCommentsOunce(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		enterChecklist_Page = homepage.clickNewChecklistOunce();
		enterChecklist_Page.selectStudent();
		enterChecklistData_Page = enterChecklist_Page.enterDomainData();
		enterChecklistData_Page.selectOunceIndicators();
		enterChecklistData_Page.enterCommentsOunce(TestUtils.getTestData(data, "DevProfileComments"));
		enterChecklistData_Page.verifyAutosaveCommentsOunce();
		enterChecklist_Page = enterChecklistData_Page.clickBackForChecklist();
		enterChecklist_Page.clickFlagAsFinalOunce();
		enterChecklist_Page.deleteChecklistOunce();
		enterChecklist_Page.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Sanity", priority = 156)
	public void verifyNavigationViaManageDevProfile(Hashtable<String, String> data, ITestContext context)
			throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		manageChecklist_Page = homepage.clickManageDevProfile();
		enterChecklist_Page = manageChecklist_Page.clickGetStarted();
		enterChecklistData_Page = enterChecklist_Page.enterDomainData();
		enterChecklistData_Page.selectOunceIndicators();
		enterChecklistData_Page.enterCommentsOunce(TestUtils.getTestData(data, "DevProfileComments"));
		enterChecklist_Page = enterChecklistData_Page.clickBackForChecklist();
		enterChecklist_Page.clickFlagAsFinalOunce();
		enterChecklist_Page.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Sanity", priority = 157)
	public void verifyChildDataIsDisplayed(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		manageChecklist_Page = homepage.clickManageDevProfile();
		enterChecklist_Page = manageChecklist_Page.clickGetStarted();
		enterChecklist_Page.verifyChildDataIsDisplayed();
		enterChecklist_Page.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Sanity", priority = 158)
	public void verifyGuidelinesOunce(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		manageChecklist_Page = homepage.clickManageDevProfile();
		enterChecklist_Page = manageChecklist_Page.clickGetStarted();
		enterChecklistData_Page = enterChecklist_Page.enterDomainData();
		enterChecklistData_Page.verifyGuidelinesOunce();
		enterChecklist_Page.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Sanity", priority = 159)
	public void verifyEvidenceLinkedOunce(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		manageChecklist_Page = homepage.clickManageDevProfile();
		enterChecklist_Page = manageChecklist_Page.clickGetStarted();
		enterChecklistData_Page = enterChecklist_Page.enterDomainData();
		enterChecklistData_Page.verifyEvidenceLinkedOunce();
		enterChecklist_Page.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Sanity", priority = 160)
	public void verifyEvidenceUnlinkedOunce(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		manageChecklist_Page = homepage.clickManageDevProfile();
		enterChecklist_Page = manageChecklist_Page.clickGetStarted();
		enterChecklistData_Page = enterChecklist_Page.enterDomainData();
		enterChecklistData_Page.verifyEvidenceUnLinked();
		enterChecklist_Page.logout();
	}
}
