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

public class ManageStudents {

	Home_Page homepage;
	ManageStudents_Page manageStudentsPage;
	Logout_Page logoutPage;
	AdminHomePage adminHomePage;

	private final static String testData = Constants.TESTDATA_LOC;
	private static Xls_Reader xls = new Xls_Reader(testData);

	@DataProvider
	private Object[][] getTestData() {
		System.out.println("Executing DataProvider");
		return TestUtils.getData("Work", xls);
	}

	@Test(dataProvider = "getTestData", groups = { "Sanity", "Regression" }, priority = 1)
	public void addStudent(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		manageStudentsPage = homepage.clickManageStudents();
		manageStudentsPage.clickAddStudent();
		manageStudentsPage.enterStudentName("studentOne", "lastOne");
		manageStudentsPage.selectGender("Male");
		manageStudentsPage.selectGrade("Preschool 4");
		manageStudentsPage.selectYear("2018");
		manageStudentsPage.selectMonth("February");
		manageStudentsPage.selectDay("02");
		manageStudentsPage.selectIEP();
		manageStudentsPage.selectLanguage("English");
		manageStudentsPage.selectEthnicity("Asian");
		manageStudentsPage.clickSave();
		manageStudentsPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = { "Sanity", "Regression" }, priority = 2)
	public void addDuplicateStudent(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		manageStudentsPage = homepage.clickManageStudents();
		manageStudentsPage.clickAddStudent();
		manageStudentsPage.enterStudentName("student-One", "last-One");
		manageStudentsPage.selectGender("Male");
		manageStudentsPage.selectGrade("Preschool 4");
		manageStudentsPage.selectYear("2018");
		manageStudentsPage.selectMonth("February");
		manageStudentsPage.selectDay("02");
		manageStudentsPage.selectIEP();
		manageStudentsPage.selectLanguage("English");
		manageStudentsPage.selectEthnicity("Asian");
		manageStudentsPage.clickSave();
		manageStudentsPage.verifyDuplicateStudentMsg();
		manageStudentsPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = { "Sanity", "Regression" }, priority = 79, dependsOnMethods = {
			"addStudent" })
	public void verifyRemoveFromClassStudent(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		manageStudentsPage = homepage.clickManageStudents();
		manageStudentsPage.verifyRemoveFromClassStudent();
		manageStudentsPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = { "Sanity", "Regression" }, priority = 80, dependsOnMethods = {
			"verifyRemoveFromClassStudent" })
	public void verifyAddExistingStudent(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		manageStudentsPage = homepage.clickManageStudents();
		manageStudentsPage.verifyAddExistingStudent();
		manageStudentsPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = { "Sanity", "Regression" }, priority = 81, dependsOnMethods = {
			"verifyAddExistingStudent" })
	public void verifyArchiveStudent(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		manageStudentsPage = homepage.clickManageStudents();
		manageStudentsPage.verifyArchiveStudent();
		manageStudentsPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = { "Sanity", "Regression" }, priority = 82, dependsOnMethods = {
			"verifyAddExistingStudent" })
	public void verifyDeleteStudent(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		manageStudentsPage = homepage.clickManageStudents();
		manageStudentsPage.verifyDeleteStudent();
		manageStudentsPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = { "Sanity", "Regression" }, priority = 83)
	public void addHsStudent(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		manageStudentsPage = homepage.clickManageStudents();
		manageStudentsPage.clickAddStudent();
		manageStudentsPage.enterStudentName("HS", "studentone");
		manageStudentsPage.selectGender("Male");
		manageStudentsPage.selectGrade("Head Start 4");
		manageStudentsPage.selectYear("2018");
		manageStudentsPage.selectMonth("February");
		manageStudentsPage.selectDay("02");
		manageStudentsPage.selectIEP();
		manageStudentsPage.selectLanguage("English");
		manageStudentsPage.selectEthnicity("Asian");
		manageStudentsPage.clickSave();
		manageStudentsPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = { "Sanity", "Regression" }, priority = 120)
	public void removeStudentsFromSystem(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "SiteAdminUsername"),
				TestUtils.getTestData(data, "Password"));

		adminHomePage = new AdminHomePage(driver);
		manageStudentsPage = adminHomePage.clickManageStudents();
		manageStudentsPage.verifyRemoveFromSystem();
		manageStudentsPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 192)
	public void addStudentAdminSide(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "SiteAdminUsername"),
				TestUtils.getTestData(data, "Password"));

		adminHomePage = new AdminHomePage(driver);
		manageStudentsPage = adminHomePage.clickManageStudents();
		manageStudentsPage.clickAddStudent();
		manageStudentsPage.enterStudentName("studentTwo", "lastTwo");
		manageStudentsPage.selectGender("Male");
		manageStudentsPage.selectGrade("Preschool 4");
		manageStudentsPage.selectYear("2018");
		manageStudentsPage.selectMonth("February");
		manageStudentsPage.selectDay("02");
		manageStudentsPage.selectIEP();
		manageStudentsPage.selectLanguage("English");
		manageStudentsPage.selectEthnicity("Asian");
		manageStudentsPage.clickSave();
		manageStudentsPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 193)
	public void verifyTransferStudent(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "SiteAdminUsername"),
				TestUtils.getTestData(data, "Password"));

		adminHomePage = new AdminHomePage(driver);
		manageStudentsPage = adminHomePage.clickManageStudents();
		manageStudentsPage.verifyTransferStudent();
		manageStudentsPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 194, dependsOnMethods = {
			"verifyTransferStudent" })
	public void verifyRemoveFromClassAdminSide(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "SiteAdminUsername"),
				TestUtils.getTestData(data, "Password"));

		adminHomePage = new AdminHomePage(driver);
		manageStudentsPage = adminHomePage.clickManageStudents();
		manageStudentsPage.verifyRemoveFromClassAdminSide();
		manageStudentsPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 195)
	public void verifyArchiveStudentAdminSide(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "SiteAdminUsername"),
				TestUtils.getTestData(data, "Password"));

		adminHomePage = new AdminHomePage(driver);
		manageStudentsPage = adminHomePage.clickManageStudents();
		manageStudentsPage.verifyArchiveStudentAdminSide();
		manageStudentsPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 196, dependsOnMethods = {
			"verifyArchiveStudentAdminSide" })
	public void verifyUnarchive(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "SiteAdminUsername"),
				TestUtils.getTestData(data, "Password"));

		adminHomePage = new AdminHomePage(driver);
		manageStudentsPage = adminHomePage.clickManageStudents();
		manageStudentsPage.verifyUnarchive();
		manageStudentsPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 197)
	public void verifyDeleteStudentAdminSide(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "SiteAdminUsername"),
				TestUtils.getTestData(data, "Password"));

		adminHomePage = new AdminHomePage(driver);
		manageStudentsPage = adminHomePage.clickManageStudents();
		manageStudentsPage.verifyDeleteStudentAdminSide();
		manageStudentsPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 198, dependsOnMethods = {
			"verifyDeleteStudentAdminSide" })
	public void verifyUndelete(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "SiteAdminUsername"),
				TestUtils.getTestData(data, "Password"));

		adminHomePage = new AdminHomePage(driver);
		manageStudentsPage = adminHomePage.clickManageStudents();
		manageStudentsPage.verifyUndelete();
		manageStudentsPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 199, dependsOnMethods = { "verifyUndelete" })
	public void verifyAddToClassAdminSide(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "SiteAdminUsername"),
				TestUtils.getTestData(data, "Password"));

		adminHomePage = new AdminHomePage(driver);
		manageStudentsPage = adminHomePage.clickManageStudents();
		manageStudentsPage.verifyAddToClassAdminSide();
		manageStudentsPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 200)
	public void verifyHistoryOfStudent(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "SiteAdminUsername"),
				TestUtils.getTestData(data, "Password"));

		adminHomePage = new AdminHomePage(driver);
		manageStudentsPage = adminHomePage.clickManageStudents();
		manageStudentsPage.verifyHistoryOfStudent();
		manageStudentsPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 201)
	public void verifyStudentExport(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "SiteAdminUsername"),
				TestUtils.getTestData(data, "Password"));

		adminHomePage = new AdminHomePage(driver);
		manageStudentsPage = adminHomePage.clickManageStudents();
		manageStudentsPage.verifyStudentExport();
		manageStudentsPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 202)
	public void verifyProxyAsTeacher(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "SiteAdminUsername"),
				TestUtils.getTestData(data, "Password"));

		adminHomePage = new AdminHomePage(driver);
		manageStudentsPage = adminHomePage.clickManageStudents();
		homepage = manageStudentsPage.verifyProxyAsTeacher();
		homepage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 203)
	public void verifySaveWithoutRequiredFields(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

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

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 204, dependsOnMethods = {
			"verifyAddToClassAdminSide" })
	public void verifyEditStudentAdminSide(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "SiteAdminUsername"),
				TestUtils.getTestData(data, "Password"));

		adminHomePage = new AdminHomePage(driver);
		manageStudentsPage = adminHomePage.clickManageStudents();
		manageStudentsPage.verifyEditStudentAdminSide("studentOne", "lastOne");
		manageStudentsPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 205)
	public void verifyChildPlusImportButton(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "SiteAdminUsername"),
				TestUtils.getTestData(data, "Password"));

		adminHomePage = new AdminHomePage(driver);
		manageStudentsPage = adminHomePage.clickManageStudents();
		manageStudentsPage.verifyChildPlusImportButton();
		manageStudentsPage.logout();
	}
}