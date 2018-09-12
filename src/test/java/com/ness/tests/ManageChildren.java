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
import com.ness.pages.Logout_Page;
import com.ness.pages.ManageStudents_Page;
import com.ness.utilities.TestUtils;
import com.ness.utilities.Xls_Reader;

public class ManageChildren {

	Home_Page homepage;
	ManageStudents_Page manageStudentsPage;
	AdminHomePage adminHomePage;
	Logout_Page logoutPage;

	private final static String testData = Constants.TESTDATA_LOC;
	private static Xls_Reader xls = new Xls_Reader(testData);

	@DataProvider
	private Object[][] getTestData() {
		System.out.println("Executing DataProvider");
		return TestUtils.getData("Ounce", xls);
	}

	@Test(dataProvider = "getTestData", groups = "Sanity", priority = 121)
	public void addChild(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		manageStudentsPage = homepage.clickManageChildren();
		manageStudentsPage.clickAddStudent();
		manageStudentsPage.enterStudentName("childOne", "lastOne");
		manageStudentsPage.selectGender("Male");
		manageStudentsPage.selectGrade("Multi Age");
		manageStudentsPage.selectYear("2017");
		manageStudentsPage.selectMonth("May");
		manageStudentsPage.selectDay("31");
		manageStudentsPage.selectIEP();
		manageStudentsPage.selectLanguage("English");
		manageStudentsPage.selectEthnicity("Asian");
		manageStudentsPage.clickSave();
		manageStudentsPage.chooseAgeLevelAsBabies1();
		manageStudentsPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Sanity", priority = 122)
	public void addDuplicateChild(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		manageStudentsPage = homepage.clickManageChildren();
		manageStudentsPage.clickAddStudent();
		manageStudentsPage.enterStudentName("child-One", "last-One");
		manageStudentsPage.selectGender("Male");
		manageStudentsPage.selectGrade("Multi Age");
		manageStudentsPage.selectYear("2017");
		manageStudentsPage.selectMonth("May");
		manageStudentsPage.selectDay("31");
		manageStudentsPage.selectIEP();
		manageStudentsPage.selectLanguage("English");
		manageStudentsPage.selectEthnicity("Asian");
		manageStudentsPage.clickSave();
		manageStudentsPage.verifyDuplicateChildMsg();
		manageStudentsPage.chooseAgeLevelAsBabies1();
		manageStudentsPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Sanity", priority = 187, dependsOnMethods = { "addChild" })
	public void verifyRemoveFromClassChild(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		manageStudentsPage = homepage.clickManageChildren();
		manageStudentsPage.verifyRemoveFromClassStudent();
		manageStudentsPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Sanity", priority = 188, dependsOnMethods = {
			"verifyRemoveFromClassChild" })
	public void verifyAddExistingChild(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		manageStudentsPage = homepage.clickManageChildren();
		manageStudentsPage.verifyAddExistingStudent();
		manageStudentsPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Sanity", priority = 189, dependsOnMethods = {
			"verifyAddExistingChild" })
	public void verifyArchiveChild(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "OunceUsername"),
				TestUtils.getTestData(data, "OuncePassword"));

		homepage = new Home_Page(driver);
		manageStudentsPage = homepage.clickManageChildren();
		manageStudentsPage.verifyArchiveStudent();
		manageStudentsPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Sanity", priority = 190, dependsOnMethods = {
			"verifyAddExistingChild" })
	public void verifyDeleteChild(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		manageStudentsPage = homepage.clickManageChildren();
		manageStudentsPage.verifyDeleteStudent();
		manageStudentsPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Sanity", priority = 191)
	public void removeChildrenFromSystem(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "SiteAdminUsername"),
				TestUtils.getTestData(data, "Password"));

		adminHomePage = new AdminHomePage(driver);
		manageStudentsPage = adminHomePage.clickManageStudents();
		manageStudentsPage.verifyRemoveFromSystem();
		manageStudentsPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 206)
	public void addChildAdminSide(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "SiteAdminUsername"),
				TestUtils.getTestData(data, "Password"));

		adminHomePage = new AdminHomePage(driver);
		manageStudentsPage = adminHomePage.clickManageStudents();
		manageStudentsPage.clickAddStudent();
		manageStudentsPage.enterStudentName("childTwo", "lastTwo");
		manageStudentsPage.selectGender("Male");
		manageStudentsPage.selectGrade("Multi Age");
		manageStudentsPage.selectYear("2017");
		manageStudentsPage.selectMonth("May");
		manageStudentsPage.selectDay("31");
		manageStudentsPage.selectIEP();
		manageStudentsPage.selectLanguage("English");
		manageStudentsPage.selectEthnicity("Asian");
		manageStudentsPage.clickSave();
		manageStudentsPage.chooseAgeLevelAsBabies1();
		manageStudentsPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 207)
	public void verifyTransferChild(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "SiteAdminUsername"),
				TestUtils.getTestData(data, "Password"));

		adminHomePage = new AdminHomePage(driver);
		manageStudentsPage = adminHomePage.clickManageStudents();
		manageStudentsPage.verifyTransferChild();
		manageStudentsPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 208)
	public void verifyRemoveFromClassAdminSideOunce(Hashtable<String, String> data, ITestContext context)
			throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "SiteAdminUsername"),
				TestUtils.getTestData(data, "Password"));

		adminHomePage = new AdminHomePage(driver);
		manageStudentsPage = adminHomePage.clickManageStudents();
		manageStudentsPage.verifyRemoveFromClassAdminSide();
		manageStudentsPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 209)
	public void verifyArchiveChildAdminSide(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "SiteAdminUsername"),
				TestUtils.getTestData(data, "Password"));

		adminHomePage = new AdminHomePage(driver);
		manageStudentsPage = adminHomePage.clickManageStudents();
		manageStudentsPage.verifyArchiveStudentAdminSide();
		manageStudentsPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 210, dependsOnMethods = {
			"verifyArchiveChildAdminSide" })
	public void verifyUnarchiveOunce(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "SiteAdminUsername"),
				TestUtils.getTestData(data, "Password"));

		adminHomePage = new AdminHomePage(driver);
		manageStudentsPage = adminHomePage.clickManageStudents();
		manageStudentsPage.verifyUnarchive();
		manageStudentsPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 211)
	public void verifyDeleteChildAdminSide(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "SiteAdminUsername"),
				TestUtils.getTestData(data, "Password"));

		adminHomePage = new AdminHomePage(driver);
		manageStudentsPage = adminHomePage.clickManageStudents();
		manageStudentsPage.verifyDeleteStudentAdminSide();
		manageStudentsPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 212, dependsOnMethods = {
			"verifyDeleteChildAdminSide" })
	public void verifyUndeleteOunce(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "SiteAdminUsername"),
				TestUtils.getTestData(data, "Password"));

		adminHomePage = new AdminHomePage(driver);
		manageStudentsPage = adminHomePage.clickManageStudents();
		manageStudentsPage.verifyUndelete();
		manageStudentsPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 213, dependsOnMethods = {
			"verifyUndeleteOunce" })
	public void verifyAddToClassAdminSideOunce(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "SiteAdminUsername"),
				TestUtils.getTestData(data, "Password"));

		adminHomePage = new AdminHomePage(driver);
		manageStudentsPage = adminHomePage.clickManageStudents();
		manageStudentsPage.verifyAddToClassAdminSideOunce();
		manageStudentsPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 214)
	public void verifyHistoryOfChild(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "SiteAdminUsername"),
				TestUtils.getTestData(data, "Password"));

		adminHomePage = new AdminHomePage(driver);
		manageStudentsPage = adminHomePage.clickManageStudents();
		manageStudentsPage.verifyHistoryOfStudent();
		manageStudentsPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 215)
	public void verifyChildExport(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "SiteAdminUsername"),
				TestUtils.getTestData(data, "Password"));

		adminHomePage = new AdminHomePage(driver);
		manageStudentsPage = adminHomePage.clickManageStudents();
		manageStudentsPage.verifyStudentExport();
		manageStudentsPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 216)
	public void verifyProxyAsTeacherOunce(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "SiteAdminUsername"),
				TestUtils.getTestData(data, "Password"));

		adminHomePage = new AdminHomePage(driver);
		manageStudentsPage = adminHomePage.clickManageStudents();
		manageStudentsPage.verifyProxyAsTeacher();
		manageStudentsPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 217)
	public void verifySaveWithoutRequiredFieldsOunce(Hashtable<String, String> data, ITestContext context)
			throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "SiteAdminUsername"),
				TestUtils.getTestData(data, "Password"));

		adminHomePage = new AdminHomePage(driver);
		manageStudentsPage = adminHomePage.clickManageStudents();
		manageStudentsPage.clickAddStudent();
		manageStudentsPage.clickSave();
		manageStudentsPage.verifySaveWithoutRequiredFields();
		manageStudentsPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 218, dependsOnMethods = {
			"verifyAddToClassAdminSideOunce" })
	public void verifyEditChildAdminSide(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "SiteAdminUsername"),
				TestUtils.getTestData(data, "Password"));

		adminHomePage = new AdminHomePage(driver);
		manageStudentsPage = adminHomePage.clickManageStudents();
		manageStudentsPage.verifyEditChildAdminSide("childOne", "lastOne");
		manageStudentsPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 219)
	public void verifyChildPlusImportButtonOunce(Hashtable<String, String> data, ITestContext context)
			throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "SiteAdminUsername"),
				TestUtils.getTestData(data, "Password"));

		adminHomePage = new AdminHomePage(driver);
		manageStudentsPage = adminHomePage.clickManageStudents();
		manageStudentsPage.verifyChildPlusImportButtonOunce();
		manageStudentsPage.logout();
	}
}