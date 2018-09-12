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

public class ManageUsers {

	AdminHomePage adminHomePage;
	ManageUsers_Page manageUsersPage;
	Home_Page homepage;

	private final static String testData = Constants.TESTDATA_LOC;
	private static Xls_Reader xls = new Xls_Reader(testData);

	@DataProvider
	private Object[][] getTestData() {
		System.out.println("Executing DataProvider");
		return TestUtils.getData("Work", xls);
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 222)
	public void addNewTeacher(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "ProgAdminUsername"),
				TestUtils.getTestData(data, "Password"));

		adminHomePage = new AdminHomePage(driver);
		adminHomePage.selectSite();
		manageUsersPage = adminHomePage.clickManageUsers();
		manageUsersPage.clickNewUser();
		manageUsersPage.enterUserName("WSAutoSiteTeacher2");
		manageUsersPage.enterName("Auto", "SiteTeacher2");
		manageUsersPage.enterEmail("desai.nikunj@pearson.com");
		manageUsersPage.selectTypeTeacher();
		manageUsersPage.selectRole("Teacher");
		manageUsersPage.save();
		manageUsersPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 223, dependsOnMethods = { "addNewTeacher" })
	public void addNewAdmin(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "ProgAdminUsername"),
				TestUtils.getTestData(data, "Password"));

		adminHomePage = new AdminHomePage(driver);
		adminHomePage.selectSite();
		manageUsersPage = adminHomePage.clickManageUsers();
		manageUsersPage.clickNewUser();
		manageUsersPage.enterUserName("WSAutoSiteAdmin2");
		manageUsersPage.enterName("Auto", "SiteAdmin2");
		manageUsersPage.enterEmail("desai.nikunj@pearson.com");
		manageUsersPage.selectTypeAdmin();
		manageUsersPage.selectRole("Administrator");
		manageUsersPage.save();
		manageUsersPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 224)
	public void verifyUserExport(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "ProgAdminUsername"),
				TestUtils.getTestData(data, "Password"));

		adminHomePage = new AdminHomePage(driver);
		adminHomePage.selectSite();
		manageUsersPage = adminHomePage.clickManageUsers();
		manageUsersPage.verifyUserExport();
		manageUsersPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 225, dependsOnMethods = { "addNewTeacher",
			"addNewAdmin" })
	public void verifyUserAssignments(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "ProgAdminUsername"),
				TestUtils.getTestData(data, "Password"));

		adminHomePage = new AdminHomePage(driver);
		adminHomePage.selectSite();
		manageUsersPage = adminHomePage.clickManageUsers();
		manageUsersPage.verifyUserAssignments();
		manageUsersPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 226, dependsOnMethods = {
			"verifyUserAssignments" })
	public void verifyTransferUser(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "ProgAdminUsername"),
				TestUtils.getTestData(data, "Password"));

		adminHomePage = new AdminHomePage(driver);
		adminHomePage.selectSite();
		manageUsersPage = adminHomePage.clickManageUsers();
		manageUsersPage.verifyTransferUser();
		manageUsersPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 227, dependsOnMethods = {
			"verifyUserAssignments" })
	public void verifyRemoveUser(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "ProgAdminUsername"),
				TestUtils.getTestData(data, "Password"));

		adminHomePage = new AdminHomePage(driver);
		adminHomePage.selectSite();
		manageUsersPage = adminHomePage.clickManageUsers();
		manageUsersPage.verifyRemoveUser();
		manageUsersPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 228, dependsOnMethods = {
			"verifyUserAssignments", "verifyTransferUser", "verifyRemoveUser" })
	public void verifyLockUser(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "ProgAdminUsername"),
				TestUtils.getTestData(data, "Password"));

		adminHomePage = new AdminHomePage(driver);
		adminHomePage.selectSite();
		manageUsersPage = adminHomePage.clickManageUsers();
		manageUsersPage.verifyLockUser();
		manageUsersPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 229, dependsOnMethods = { "verifyLockUser" })
	public void verifyUnLockUser(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "ProgAdminUsername"),
				TestUtils.getTestData(data, "Password"));

		adminHomePage = new AdminHomePage(driver);
		adminHomePage.selectSite();
		manageUsersPage = adminHomePage.clickManageUsers();
		manageUsersPage.verifyUnLockUser();
		manageUsersPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 230)
	public void primaryContactForAdmin(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "ProgAdminUsername"),
				TestUtils.getTestData(data, "Password"));

		adminHomePage = new AdminHomePage(driver);
		adminHomePage.selectSite();
		manageUsersPage = adminHomePage.clickManageUsers();
		manageUsersPage.primaryContactForAdmin();
		manageUsersPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 231, dependsOnMethods = {
			"verifyRemoveUser" })
	public void primaryContactForTeacher(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "ProgAdminUsername"),
				TestUtils.getTestData(data, "Password"));

		adminHomePage = new AdminHomePage(driver);
		adminHomePage.selectSite();
		manageUsersPage = adminHomePage.clickManageUsers();
		manageUsersPage.primaryContactForTeacher();
		manageUsersPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 232)
	public void verifyProxyButtonActiveness(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "ProgAdminUsername"),
				TestUtils.getTestData(data, "Password"));

		adminHomePage = new AdminHomePage(driver);
		adminHomePage.selectSite();
		manageUsersPage = adminHomePage.clickManageUsers();
		manageUsersPage.verifyProxyButtonActiveness();
		manageUsersPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 233)
	public void verifySiteIsRetainedOnTeacherSide(Hashtable<String, String> data, ITestContext context)
			throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "ProgAdminUsername"),
				TestUtils.getTestData(data, "Password"));

		adminHomePage = new AdminHomePage(driver);
		adminHomePage.selectSite();
		manageUsersPage = adminHomePage.clickManageUsers();
		homepage = manageUsersPage.verifySiteIsRetainedOnTeacherSide();
		homepage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 234, dependsOnMethods = { "addNewTeacher",
			"addNewAdmin", "verifyUserAssignments", "verifyTransferUser", "verifyRemoveUser" })
	public void verifyEditUserRole(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "ProgAdminUsername"),
				TestUtils.getTestData(data, "Password"));

		adminHomePage = new AdminHomePage(driver);
		adminHomePage.selectSite();
		manageUsersPage = adminHomePage.clickManageUsers();
		manageUsersPage.verifyEditUserRole();
		manageUsersPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 235, dependsOnMethods = { "addNewTeacher",
			"addNewAdmin", "verifyUserAssignments", "verifyTransferUser", "verifyRemoveUser" })
	public void verifyRemoveUserFromSystem(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

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