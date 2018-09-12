package com.ness.tests;

import java.util.Hashtable;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ness.config.DriverManager;
import com.ness.inputs.Constants;
import com.ness.pages.AdminHomePage;
import com.ness.pages.Home_Page;
import com.ness.pages.Login_Page;
import com.ness.pages.ManageUsers_Page;
import com.ness.utilities.TestUtils;
import com.ness.utilities.Xls_Reader;

public class ManageUsersOunce {

	AdminHomePage adminHomePage;
	ManageUsers_Page manageUsersPage;
	Home_Page homepage;

	private final static String testData = Constants.TESTDATA_LOC;
	private static Xls_Reader xls = new Xls_Reader(testData);

	@DataProvider
	private Object[][] getTestData() {
		System.out.println("Executing DataProvider");
		return TestUtils.getData("Ounce", xls);
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 236)
	public void addNewOunceTeacher(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "ProgAdminUsername"),
				TestUtils.getTestData(data, "Password"));

		adminHomePage = new AdminHomePage(driver);
		adminHomePage.selectSite();
		manageUsersPage = adminHomePage.clickManageUsers();
		manageUsersPage.clickNewUser();
		manageUsersPage.enterUserName("OunceAutoSiteTeacher2");
		manageUsersPage.enterName("Auto", "SiteTeacher2");
		manageUsersPage.enterEmail("desai.nikunj@pearson.com");
		manageUsersPage.selectTypeTeacher();
		manageUsersPage.selectRole("Teacher");
		manageUsersPage.save();
		manageUsersPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 237, dependsOnMethods = {
			"addNewOunceTeacher" })
	public void addNewOunceAdmin(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "ProgAdminUsername"),
				TestUtils.getTestData(data, "Password"));

		adminHomePage = new AdminHomePage(driver);
		adminHomePage.selectSite();
		manageUsersPage = adminHomePage.clickManageUsers();
		manageUsersPage.clickNewUser();
		manageUsersPage.enterUserName("OunceAutoSiteAdmin2");
		manageUsersPage.enterName("Auto", "SiteAdmin2");
		manageUsersPage.enterEmail("desai.nikunj@pearson.com");
		manageUsersPage.selectTypeAdmin();
		manageUsersPage.selectRole("Administrator");
		manageUsersPage.save();
		manageUsersPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 238)
	public void verifyUserExportOunce(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "ProgAdminUsername"),
				TestUtils.getTestData(data, "Password"));

		adminHomePage = new AdminHomePage(driver);
		adminHomePage.selectSite();
		manageUsersPage = adminHomePage.clickManageUsers();
		manageUsersPage.verifyUserExport();
		manageUsersPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 239, dependsOnMethods = {
			"addNewOunceTeacher", "addNewOunceAdmin" })
	public void verifyUserAssignmentsOunce(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "ProgAdminUsername"),
				TestUtils.getTestData(data, "Password"));

		adminHomePage = new AdminHomePage(driver);
		adminHomePage.selectSite();
		manageUsersPage = adminHomePage.clickManageUsers();
		manageUsersPage.verifyUserAssignments();
		manageUsersPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 240, dependsOnMethods = {
			"verifyUserAssignmentsOunce" })
	public void verifyTransferUserOunce(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "ProgAdminUsername"),
				TestUtils.getTestData(data, "Password"));

		adminHomePage = new AdminHomePage(driver);
		adminHomePage.selectSite();
		manageUsersPage = adminHomePage.clickManageUsers();
		manageUsersPage.verifyTransferUser();
		manageUsersPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 241, dependsOnMethods = {
			"verifyUserAssignmentsOunce" })
	public void verifyRemoveUserOunce(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "ProgAdminUsername"),
				TestUtils.getTestData(data, "Password"));

		adminHomePage = new AdminHomePage(driver);
		adminHomePage.selectSite();
		manageUsersPage = adminHomePage.clickManageUsers();
		manageUsersPage.verifyRemoveUser();
		manageUsersPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 242, dependsOnMethods = {
			"verifyUserAssignmentsOunce", "verifyTransferUserOunce", "verifyRemoveUserOunce" })
	public void verifyLockUserOunce(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "ProgAdminUsername"),
				TestUtils.getTestData(data, "Password"));

		adminHomePage = new AdminHomePage(driver);
		adminHomePage.selectSite();
		manageUsersPage = adminHomePage.clickManageUsers();
		manageUsersPage.verifyLockUser();
		manageUsersPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 243, dependsOnMethods = {
			"verifyLockUserOunce" })
	public void verifyUnLockUserOunce(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "ProgAdminUsername"),
				TestUtils.getTestData(data, "Password"));

		adminHomePage = new AdminHomePage(driver);
		adminHomePage.selectSite();
		manageUsersPage = adminHomePage.clickManageUsers();
		manageUsersPage.verifyUnLockUser();
		manageUsersPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 244)
	public void primaryContactForAdminOunce(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "ProgAdminUsername"),
				TestUtils.getTestData(data, "Password"));

		adminHomePage = new AdminHomePage(driver);
		adminHomePage.selectSite();
		manageUsersPage = adminHomePage.clickManageUsers();
		manageUsersPage.primaryContactForAdmin();
		manageUsersPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 245, dependsOnMethods = {
			"verifyRemoveUserOunce" })
	public void primaryContactForTeacherOunce(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "ProgAdminUsername"),
				TestUtils.getTestData(data, "Password"));

		adminHomePage = new AdminHomePage(driver);
		adminHomePage.selectSite();
		manageUsersPage = adminHomePage.clickManageUsers();
		manageUsersPage.primaryContactForTeacher();
		manageUsersPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 246)
	public void verifyProxyButtonActivenessOunce(Hashtable<String, String> data, ITestContext context)
			throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "ProgAdminUsername"),
				TestUtils.getTestData(data, "Password"));

		adminHomePage = new AdminHomePage(driver);
		adminHomePage.selectSite();
		manageUsersPage = adminHomePage.clickManageUsers();
		manageUsersPage.verifyProxyButtonActiveness();
		manageUsersPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 247)
	public void verifySiteIsRetainedOnTeacherSideOunce(Hashtable<String, String> data, ITestContext context)
			throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "ProgAdminUsername"),
				TestUtils.getTestData(data, "Password"));

		adminHomePage = new AdminHomePage(driver);
		adminHomePage.selectSite();
		manageUsersPage = adminHomePage.clickManageUsers();
		homepage = manageUsersPage.verifySiteIsRetainedOnTeacherSide();
		homepage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 248, dependsOnMethods = {
			"addNewOunceTeacher", "addNewOunceAdmin", "verifyUserAssignmentsOunce", "verifyTransferUserOunce",
			"verifyRemoveUserOunce" })
	public void verifyEditUserRoleOunce(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "ProgAdminUsername"),
				TestUtils.getTestData(data, "Password"));

		adminHomePage = new AdminHomePage(driver);
		adminHomePage.selectSite();
		manageUsersPage = adminHomePage.clickManageUsers();
		manageUsersPage.verifyEditUserRole();
		manageUsersPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 249, dependsOnMethods = {
			"addNewOunceTeacher", "addNewOunceAdmin", "verifyUserAssignmentsOunce", "verifyTransferUserOunce",
			"verifyRemoveUserOunce" })
	public void verifyRemoveUserFromSystemOunce(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "ProgAdminUsername"),
				TestUtils.getTestData(data, "Password"));

		adminHomePage = new AdminHomePage(driver);
		adminHomePage.selectSite();
		manageUsersPage = adminHomePage.clickManageUsers();
		manageUsersPage.verifyRemoveUserFromSystem();
		manageUsersPage.logout();
	}
}