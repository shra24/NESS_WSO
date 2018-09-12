package com.ness.tests;

import java.util.Hashtable;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ness.config.DriverManager;
import com.ness.inputs.Constants;
import com.ness.pages.AdminHomePage;
import com.ness.pages.Login_Page;
import com.ness.pages.ManageLocations_Page;
import com.ness.utilities.TestUtils;
import com.ness.utilities.Xls_Reader;

public class ManageLocations {

	AdminHomePage adminHomePage;
	ManageLocations_Page manageLocationsPage;

	private final static String testData = Constants.TESTDATA_LOC;
	private static Xls_Reader xls = new Xls_Reader(testData);

	@DataProvider
	private Object[][] getTestData() {
		System.out.println("Executing DataProvider");
		return TestUtils.getData("Work", xls);
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 250)
	public void verifyAddProgLocation(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "OrgAdminUsername"),
				TestUtils.getTestData(data, "Password"));

		adminHomePage = new AdminHomePage(driver);
		manageLocationsPage = adminHomePage.clickManageLocations();
		manageLocationsPage.clickAddButton();
		manageLocationsPage.enterProgramName("AutomationWSOProg2");
		manageLocationsPage.enterCode("codeProg2");
		manageLocationsPage.enterAddress("Ness", "Airoli");
		manageLocationsPage.enterCity("Mumbai");
		manageLocationsPage.selectState("AZ");
		manageLocationsPage.enterPostalCode("85223");
		manageLocationsPage.selectCountry("USA");
		manageLocationsPage.enterPhoneNumber("4807038888");
		manageLocationsPage.clickSave();
		manageLocationsPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 251, dependsOnMethods = {
			"verifyAddProgLocation" })
	public void verifyDistributeAllocations(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "OrgAdminUsername"),
				TestUtils.getTestData(data, "Password"));

		adminHomePage = new AdminHomePage(driver);
		manageLocationsPage = adminHomePage.clickManageLocations();
		manageLocationsPage.clickDistribute();
		manageLocationsPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 252, dependsOnMethods = {
			"verifyDistributeAllocations" })
	public void verifyClearAllocations(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "OrgAdminUsername"),
				TestUtils.getTestData(data, "Password"));

		adminHomePage = new AdminHomePage(driver);
		manageLocationsPage = adminHomePage.clickManageLocations();
		manageLocationsPage.clickClear();
		manageLocationsPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 253, dependsOnMethods = {
			"verifyAddProgLocation" })
	public void verifyAddSiteLocation(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "OrgAdminUsername"),
				TestUtils.getTestData(data, "Password"));

		adminHomePage = new AdminHomePage(driver);
		manageLocationsPage = adminHomePage.clickManageLocations();
		manageLocationsPage.selectProgramOnManageLocationsPage();
		manageLocationsPage.clickAddButton();
		manageLocationsPage.enterProgramName("AutomationWSOSite3");
		manageLocationsPage.enterCode("codeSite3");
		manageLocationsPage.enterAddress("Ness", "Airoli");
		manageLocationsPage.enterCity("Mumbai");
		manageLocationsPage.selectState("AZ");
		manageLocationsPage.enterPostalCode("85223");
		manageLocationsPage.selectCountry("USA");
		manageLocationsPage.enterPhoneNumber("4807038888");
		manageLocationsPage.clickSave();
		manageLocationsPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 254, dependsOnMethods = {
			"verifyAddSiteLocation" })
	public void verifyMoveLocation(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "OrgAdminUsername"),
				TestUtils.getTestData(data, "Password"));

		adminHomePage = new AdminHomePage(driver);
		manageLocationsPage = adminHomePage.clickManageLocations();
		manageLocationsPage.selectProgramOnManageLocationsPage();
		manageLocationsPage.moveLocation();
		manageLocationsPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 255, dependsOnMethods = {
			"verifyMoveLocation" })
	public void verifyDeleteLocation(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "OrgAdminUsername"),
				TestUtils.getTestData(data, "Password"));

		adminHomePage = new AdminHomePage(driver);
		manageLocationsPage = adminHomePage.clickManageLocations();
		manageLocationsPage.deleteLocation();
		manageLocationsPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 256, dependsOnMethods = {
			"verifyDeleteLocation" })
	public void verifyMoveButtonDisabled(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "OrgAdminUsername"),
				TestUtils.getTestData(data, "Password"));

		adminHomePage = new AdminHomePage(driver);
		manageLocationsPage = adminHomePage.clickManageLocations();
		manageLocationsPage.verifyMoveButtonDisabled();
		manageLocationsPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 257)
	public void verifySaveWithoutData(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "OrgAdminUsername"),
				TestUtils.getTestData(data, "Password"));

		adminHomePage = new AdminHomePage(driver);
		manageLocationsPage = adminHomePage.clickManageLocations();
		manageLocationsPage.clickAddButton();
		manageLocationsPage.clickSave();
		manageLocationsPage.verifySaveWithoutData();
		manageLocationsPage.clickCancel();
		manageLocationsPage.logout();
	}
}