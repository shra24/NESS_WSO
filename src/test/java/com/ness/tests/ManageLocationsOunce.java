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

public class ManageLocationsOunce {

	AdminHomePage adminHomePage;
	ManageLocations_Page manageLocationsPage;

	private final static String testData = Constants.TESTDATA_LOC;
	private static Xls_Reader xls = new Xls_Reader(testData);

	@DataProvider
	private Object[][] getTestData() {
		System.out.println("Executing DataProvider");
		return TestUtils.getData("Ounce", xls);
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 258)
	public void verifyAddProgLocationOunce(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "OrgAdminUsername"),
				TestUtils.getTestData(data, "Password"));

		adminHomePage = new AdminHomePage(driver);
		manageLocationsPage = adminHomePage.clickManageLocations();
		manageLocationsPage.clickAddButton();
		manageLocationsPage.enterProgramName("AutomationOunceProg2");
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

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 259, dependsOnMethods = {
			"verifyAddProgLocationOunce" })
	public void verifyDistributeAllocationsOunce(Hashtable<String, String> data, ITestContext context)
			throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "OrgAdminUsername"),
				TestUtils.getTestData(data, "Password"));

		adminHomePage = new AdminHomePage(driver);
		manageLocationsPage = adminHomePage.clickManageLocations();
		manageLocationsPage.clickDistribute();
		manageLocationsPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 260, dependsOnMethods = {
			"verifyDistributeAllocationsOunce" })
	public void verifyClearAllocationsOunce(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "OrgAdminUsername"),
				TestUtils.getTestData(data, "Password"));

		adminHomePage = new AdminHomePage(driver);
		manageLocationsPage = adminHomePage.clickManageLocations();
		manageLocationsPage.clickClear();
		manageLocationsPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 261, dependsOnMethods = {
			"verifyAddProgLocationOunce" })
	public void verifyAddSiteLocationOunce(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "OrgAdminUsername"),
				TestUtils.getTestData(data, "Password"));

		adminHomePage = new AdminHomePage(driver);
		manageLocationsPage = adminHomePage.clickManageLocations();
		manageLocationsPage.selectProgramOnManageLocationsPage();
		manageLocationsPage.clickAddButton();
		manageLocationsPage.enterProgramName("AutomationOunceSite3");
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

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 262, dependsOnMethods = {
			"verifyAddSiteLocationOunce" })
	public void verifyMoveLocationOunce(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "OrgAdminUsername"),
				TestUtils.getTestData(data, "Password"));

		adminHomePage = new AdminHomePage(driver);
		manageLocationsPage = adminHomePage.clickManageLocations();
		manageLocationsPage.selectProgramOnManageLocationsPage();
		manageLocationsPage.moveLocation();
		manageLocationsPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 263, dependsOnMethods = {
			"verifyMoveLocationOunce" })
	public void verifyDeleteLocationOunce(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "OrgAdminUsername"),
				TestUtils.getTestData(data, "Password"));

		adminHomePage = new AdminHomePage(driver);
		manageLocationsPage = adminHomePage.clickManageLocations();
		manageLocationsPage.deleteLocation();
		manageLocationsPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 264, dependsOnMethods = {
			"verifyDeleteLocationOunce" })
	public void verifyMoveButtonDisabledOunce(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "OrgAdminUsername"),
				TestUtils.getTestData(data, "Password"));

		adminHomePage = new AdminHomePage(driver);
		manageLocationsPage = adminHomePage.clickManageLocations();
		manageLocationsPage.verifyMoveButtonDisabled();
		manageLocationsPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 265)
	public void verifySaveWithoutDataOunce(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

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