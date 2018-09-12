package com.ness.tests;

import java.util.Hashtable;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ness.config.DriverManager;
import com.ness.inputs.Constants;
import com.ness.pages.EnterObservation_Page;
import com.ness.pages.Home_Page;
import com.ness.pages.Login_Page;
import com.ness.pages.Logout_Page;
import com.ness.pages.ManageObservation_Page;
import com.ness.utilities.TestUtils;
import com.ness.utilities.Xls_Reader;

public class Observation {
	Home_Page homepage;
	ManageObservation_Page manageObservationPage;
	EnterObservation_Page enterObservationPage;
	Logout_Page logoutPage;

	private final static String testData = Constants.TESTDATA_LOC;
	private static Xls_Reader xls = new Xls_Reader(testData);

	@DataProvider
	private Object[][] getTestData() {
		System.out.println("Executing DataProvider");
		return TestUtils.getData("Work", xls);
	}

	@Test(dataProvider = "getTestData", groups = { "Sanity", "Regression" }, priority = 3)
	public void createNewObservation(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		manageObservationPage = homepage.clickManageObservations();
		enterObservationPage = manageObservationPage.clickEnterEvidence();
		enterObservationPage.selectStudent();
		enterObservationPage.selectPeriod(TestUtils.getTestData(data, "EvidencePeriod"));
		enterObservationPage.clickLinkToPerformanceIndicators();
		enterObservationPage.chooseIndicators();
		enterObservationPage.saveIndicators();
		enterObservationPage.enterTitleDescription(TestUtils.getTestData(data, "EvidenceTitle"),
				TestUtils.getTestData(data, "EvidenceDescription"));
		manageObservationPage = enterObservationPage.clickSave();
		manageObservationPage.verifyEvidenceIsCreated();
		manageObservationPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = { "Sanity", "Regression" }, priority = 4)
	public void verifyAutoSaveDescription(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		manageObservationPage = homepage.clickManageObservations();
		enterObservationPage = manageObservationPage.clickEnterEvidence();
		enterObservationPage.selectStudent();
		enterObservationPage.selectPeriod(TestUtils.getTestData(data, "EvidencePeriod"));
		enterObservationPage.clickLinkToPerformanceIndicators();
		enterObservationPage.chooseIndicators();
		enterObservationPage.saveIndicators();
		enterObservationPage.enterTitleDescription(TestUtils.getTestData(data, "EvidenceTitle"),
				TestUtils.getTestData(data, "EvidenceDescription"));
		enterObservationPage.verifyAutoSave();
		manageObservationPage = enterObservationPage.clickSave();
		manageObservationPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = { "Sanity", "Regression" }, priority = 5)
	public void deleteObservation(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		manageObservationPage = homepage.clickManageObservations();
		enterObservationPage = manageObservationPage.clickObservation();
		manageObservationPage = enterObservationPage.clickDeleteObservation();
		manageObservationPage.verifyObservationIsDeleted();
		manageObservationPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = { "Sanity", "Regression" }, priority = 6)
	public void downloadObservationPresent(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		manageObservationPage = homepage.clickManageObservations();
		enterObservationPage = manageObservationPage.clickObservation();
		enterObservationPage.verifyDownloadObservation();
		enterObservationPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = { "Sanity", "Regression" }, priority = 7)
	public void deleteObservationPresent(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		manageObservationPage = homepage.clickManageObservations();
		enterObservationPage = manageObservationPage.clickEnterEvidence();
		enterObservationPage.selectStudent();
		enterObservationPage.selectPeriod(TestUtils.getTestData(data, "EvidencePeriod"));
		enterObservationPage.clickLinkToPerformanceIndicators();
		enterObservationPage.chooseIndicators();
		enterObservationPage.saveIndicators();
		enterObservationPage.enterTitleDescription(TestUtils.getTestData(data, "EvidenceTitle"),
				TestUtils.getTestData(data, "EvidenceDescription"));
		enterObservationPage.isDeleteButtonPresent();
		manageObservationPage = enterObservationPage.clickSave();
		manageObservationPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = { "Sanity", "Regression" }, priority = 8)
	public void saveWithoutTitle(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		manageObservationPage = homepage.clickManageObservations();
		enterObservationPage = manageObservationPage.clickEnterEvidence();
		enterObservationPage.selectStudent();
		enterObservationPage.clickSave();
		enterObservationPage.verifySaveWithoutTitleAlert();
		enterObservationPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = { "Sanity", "Regression" }, priority = 9)
	public void verifySaveButtonDisabled(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		manageObservationPage = homepage.clickManageObservations();
		enterObservationPage = manageObservationPage.clickEnterEvidence();
		enterObservationPage.verifySaveButtonDisabled();
		enterObservationPage.selectStudent();
		enterObservationPage.selectPeriod(TestUtils.getTestData(data, "EvidencePeriod"));
		enterObservationPage.clickLinkToPerformanceIndicators();
		enterObservationPage.chooseIndicators();
		enterObservationPage.saveIndicators();
		enterObservationPage.enterTitleDescription(TestUtils.getTestData(data, "EvidenceTitle"),
				TestUtils.getTestData(data, "EvidenceDescription"));
		manageObservationPage = enterObservationPage.clickSave();
		manageObservationPage.verifyEvidenceIsCreated();
		manageObservationPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = { "Sanity", "Regression" }, priority = 10)
	public void verifyStudentFilter(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		manageObservationPage = homepage.clickManageObservations();
		manageObservationPage.selectFilter(TestUtils.getTestData(data, "StudentsFilter"));
		manageObservationPage.selectNextDrop();
		manageObservationPage.verifyfilteredStudent();
		manageObservationPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = { "Sanity", "Regression" }, priority = 11)
	public void verifyPeriodFilter(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		manageObservationPage = homepage.clickManageObservations();
		manageObservationPage.selectFilter(TestUtils.getTestData(data, "PeriodFilter"));
		manageObservationPage.selectNextDrop();
		manageObservationPage.verifyfilteredPeriod();
		manageObservationPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = { "Sanity", "Regression" }, priority = 12)
	public void verifyFilterIsRetainedAfterBack(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		manageObservationPage = homepage.clickManageObservations();
		manageObservationPage.selectFilter(TestUtils.getTestData(data, "StudentsFilter"));
		manageObservationPage.selectNextDrop();
		enterObservationPage = manageObservationPage.clickObservation();
		manageObservationPage = enterObservationPage.backToManageObservationPage();
		manageObservationPage.verifyFilterIsRetained();
		manageObservationPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = { "Sanity", "Regression" }, priority = 13)
	public void verifyFilterIsRetainedAfterSave(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		manageObservationPage = homepage.clickManageObservations();
		manageObservationPage.selectFilter(TestUtils.getTestData(data, "StudentsFilter"));
		manageObservationPage.selectNextDrop();
		enterObservationPage = manageObservationPage.clickObservation();
		manageObservationPage = enterObservationPage.clickSave();
		manageObservationPage.verifyFilterIsRetained();
		manageObservationPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = { "Sanity", "Regression" }, priority = 14)
	public void verifyFilterIsRetainedAfterDelete(Hashtable<String, String> data, ITestContext context)
			throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		manageObservationPage = homepage.clickManageObservations();
		manageObservationPage.selectFilter(TestUtils.getTestData(data, "StudentsFilter"));
		manageObservationPage.selectNextDrop();
		enterObservationPage = manageObservationPage.clickObservation();
		manageObservationPage = enterObservationPage.clickDeleteObservation();
		manageObservationPage.verifyObservationIsDeleted();
		manageObservationPage.verifyFilterIsRetained();
		manageObservationPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = { "Sanity", "Regression" }, priority = 15)
	public void editStudentInObservation(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		manageObservationPage = homepage.clickManageObservations();
		manageObservationPage.verifyActualStudent();
		enterObservationPage = manageObservationPage.clickObservation();
		enterObservationPage.editStudent();
		enterObservationPage.clickLinkToPerformanceIndicators();
		enterObservationPage.chooseIndicators();
		enterObservationPage.saveIndicators();
		enterObservationPage.enterTitleDescription(TestUtils.getTestData(data, "EvidenceTitle"),
				TestUtils.getTestData(data, "EvidenceDescription"));
		manageObservationPage = enterObservationPage.clickSave();
		manageObservationPage.verifyEditedStudent();
		manageObservationPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = { "Sanity", "Regression" }, priority = 84)
	public void createObservationForHsStudent(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		manageObservationPage = homepage.clickManageObservations();
		enterObservationPage = manageObservationPage.clickEnterEvidence();
		enterObservationPage.selectStudent();
		enterObservationPage.selectPeriod(TestUtils.getTestData(data, "EvidencePeriod"));
		enterObservationPage.clickLinkToPerformanceIndicators();
		enterObservationPage.chooseHsIndicators();
		enterObservationPage.saveIndicators();
		enterObservationPage.enterTitleDescription(TestUtils.getTestData(data, "EvidenceTitle"),
				TestUtils.getTestData(data, "EvidenceDescription"));
		manageObservationPage = enterObservationPage.clickSave();
		manageObservationPage.verifyEvidenceIsCreated();
		manageObservationPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 16)
	public void editPeriodInObservation(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		manageObservationPage = homepage.clickManageObservations();
		enterObservationPage = manageObservationPage.clickObservation();
		enterObservationPage.selectPeriod("PERIOD 2");
		manageObservationPage = enterObservationPage.clickSave();
		manageObservationPage.verifyEditedPeriod();
		manageObservationPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 17)
	public void editTitleDescriptionInObservation(Hashtable<String, String> data, ITestContext context)
			throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		manageObservationPage = homepage.clickManageObservations();
		enterObservationPage = manageObservationPage.clickObservation();
		enterObservationPage.enterTitleDescription("Edited Evidence 1", "Grade: P4, Period 2");
		manageObservationPage = enterObservationPage.clickSave();
		manageObservationPage.verifyEditedTitleDescription();
		manageObservationPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 18)
	public void verifyDefaultPeriod(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		manageObservationPage = homepage.clickManageObservations();
		enterObservationPage = manageObservationPage.clickEnterEvidence();
		enterObservationPage.selectStudent();
		enterObservationPage.selectPeriod(TestUtils.getTestData(data, "EvidencePeriod"));
		enterObservationPage.checkCurrentPeriod();
		enterObservationPage.clickLinkToPerformanceIndicators();
		enterObservationPage.chooseIndicators();
		enterObservationPage.saveIndicators();
		enterObservationPage.enterTitleDescription(TestUtils.getTestData(data, "EvidenceTitle"),
				TestUtils.getTestData(data, "EvidenceDescription"));
		manageObservationPage = enterObservationPage.clickSave();
		enterObservationPage = manageObservationPage.clickEnterEvidence();
		enterObservationPage.verifyDefaultPeriod();
		enterObservationPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 19)
	public void verifyDesciptionCounter(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		manageObservationPage = homepage.clickManageObservations();
		enterObservationPage = manageObservationPage.clickObservation();
		enterObservationPage.verifyDescriptionCounter();
		enterObservationPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 20)
	public void verifyAddedAttachment(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		manageObservationPage = homepage.clickManageObservations();
		enterObservationPage = manageObservationPage.clickEnterEvidence();
		enterObservationPage.selectStudent();
		enterObservationPage.selectPeriod(TestUtils.getTestData(data, "EvidencePeriod"));
		enterObservationPage.clickLinkToPerformanceIndicators();
		enterObservationPage.chooseIndicators();
		enterObservationPage.saveIndicators();
		enterObservationPage.addAttachment();
		enterObservationPage.enterTitleDescription(TestUtils.getTestData(data, "EvidenceTitle"),
				TestUtils.getTestData(data, "EvidenceDescription"));
		manageObservationPage = enterObservationPage.clickSave();
		manageObservationPage.verifyAddedAttachment();
		manageObservationPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 21)
	public void addDescriptionWithoutStudentSelect(Hashtable<String, String> data, ITestContext context)
			throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		manageObservationPage = homepage.clickManageObservations();
		enterObservationPage = manageObservationPage.clickEnterEvidence();
		enterObservationPage.clickDescriptionTextBox();
		enterObservationPage.verifySelectStudentAlert();
		enterObservationPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 22)
	public void addDescriptionWithoutTitle(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		manageObservationPage = homepage.clickManageObservations();
		enterObservationPage = manageObservationPage.clickEnterEvidence();
		enterObservationPage.selectStudent();
		enterObservationPage.clickDescriptionTextBox();
		enterObservationPage.verifyTitleFirstAlert();
		enterObservationPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 23)
	public void addIndicatorsWithoutStudentSelect(Hashtable<String, String> data, ITestContext context)
			throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		manageObservationPage = homepage.clickManageObservations();
		enterObservationPage = manageObservationPage.clickEnterEvidence();
		enterObservationPage.clickLinkToPerformanceIndicators();
		enterObservationPage.verifySelectStudentFirstAlert();
		enterObservationPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 24)
	public void verifyAttachmentNameAsTitle(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		manageObservationPage = homepage.clickManageObservations();
		enterObservationPage = manageObservationPage.clickEnterEvidence();
		enterObservationPage.selectStudent();
		enterObservationPage.addAttachment();
		manageObservationPage = enterObservationPage.clickSave();
		manageObservationPage.verifyAttachmentNameAsTitle();
		manageObservationPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 25)
	public void verifyNoDescriptionAddedText(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		manageObservationPage = homepage.clickManageObservations();
		enterObservationPage = manageObservationPage.clickEnterEvidence();
		enterObservationPage.selectStudent();
		enterObservationPage.addAttachment();
		manageObservationPage = enterObservationPage.clickSave();
		manageObservationPage.verifyNoDescriptionAddedText();
		manageObservationPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 26)
	public void verifyMultipleStudentsMultipleAttachments(Hashtable<String, String> data, ITestContext context)
			throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		manageObservationPage = homepage.clickManageObservations();
		enterObservationPage = manageObservationPage.clickEnterEvidence();
		enterObservationPage.selectAllStudents();
		enterObservationPage.selectPeriod(TestUtils.getTestData(data, "EvidencePeriod"));
		enterObservationPage.clickLinkToPerformanceIndicators();
		enterObservationPage.chooseIndicators();
		enterObservationPage.saveIndicators();
		enterObservationPage.addMultipleAttachments();
		enterObservationPage.enterTitleDescription(TestUtils.getTestData(data, "EvidenceTitle"),
				TestUtils.getTestData(data, "EvidenceDescription"));
		manageObservationPage = enterObservationPage.clickSave();
		manageObservationPage.verifyMultipledAttachmentsAdded();
		manageObservationPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 27)
	public void verifyDeleteAttachment(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		manageObservationPage = homepage.clickManageObservations();
		enterObservationPage = manageObservationPage.clickEnterEvidence();
		enterObservationPage.selectStudent();
		enterObservationPage.selectPeriod(TestUtils.getTestData(data, "EvidencePeriod"));
		enterObservationPage.clickLinkToPerformanceIndicators();
		enterObservationPage.chooseIndicators();
		enterObservationPage.saveIndicators();
		enterObservationPage.addMultipleAttachments();
		enterObservationPage.enterTitleDescription(TestUtils.getTestData(data, "EvidenceTitle"),
				TestUtils.getTestData(data, "EvidenceDescription"));
		manageObservationPage = enterObservationPage.clickSave();
		enterObservationPage = manageObservationPage.clickObservation();
		enterObservationPage.deleteAttachment();
		manageObservationPage = enterObservationPage.clickSave();
		manageObservationPage.verifyDeleteAttachment();
		manageObservationPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 28)
	public void verifySelectAllStudentFilter(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		manageObservationPage = homepage.clickManageObservations();
		manageObservationPage.selectFilter(TestUtils.getTestData(data, "StudentsFilter"));
		manageObservationPage.verifyDefaultFilter();
		manageObservationPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 29)
	public void verifySelectAllPeriodFilter(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		manageObservationPage = homepage.clickManageObservations();
		manageObservationPage.selectFilter(TestUtils.getTestData(data, "PeriodFilter"));
		manageObservationPage.verifyDefaultFilter();
		manageObservationPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 30)
	public void verifyStudentFilterAfterRemoveStudent(Hashtable<String, String> data, ITestContext context)
			throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		manageObservationPage = homepage.clickManageObservations();
		enterObservationPage = manageObservationPage.clickEnterEvidence();
		enterObservationPage.selectAllStudents();
		enterObservationPage.enterTitleDescription(TestUtils.getTestData(data, "EvidenceTitle"),
				TestUtils.getTestData(data, "EvidenceDescription"));
		manageObservationPage = enterObservationPage.clickSave();
		manageObservationPage.selectFilter(TestUtils.getTestData(data, "StudentsFilter"));
		manageObservationPage.selectNextDrop();
		enterObservationPage = manageObservationPage.clickObservation();
		enterObservationPage.removeStudent();
		manageObservationPage = enterObservationPage.clickSave();
		manageObservationPage.verifyFilterIsRetained();
		manageObservationPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 31)
	public void verifyPeriodFilterAfterChangePeriod(Hashtable<String, String> data, ITestContext context)
			throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		manageObservationPage = homepage.clickManageObservations();
		enterObservationPage = manageObservationPage.clickEnterEvidence();
		enterObservationPage.selectStudent();
		enterObservationPage.selectPeriod(TestUtils.getTestData(data, "EvidencePeriod"));
		enterObservationPage.enterTitleDescription(TestUtils.getTestData(data, "EvidenceTitle"),
				TestUtils.getTestData(data, "EvidenceDescription"));
		manageObservationPage = enterObservationPage.clickSave();
		manageObservationPage.selectFilter(TestUtils.getTestData(data, "PeriodFilter"));
		manageObservationPage.selectNextDrop();
		enterObservationPage = manageObservationPage.clickObservation();
		enterObservationPage.selectPeriod("PERIOD 2");
		manageObservationPage = enterObservationPage.clickSave();
		manageObservationPage.verifyFilterIsRetained();
		manageObservationPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 32)
	public void verifyStudentFilterNotRetained(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		manageObservationPage = homepage.clickManageObservations();
		manageObservationPage.selectFilter(TestUtils.getTestData(data, "StudentsFilter"));
		manageObservationPage.selectNextDrop();
		homepage = manageObservationPage.clickPageTitle();
		manageObservationPage = homepage.clickManageObservations();
		manageObservationPage.verifyFilterIsNotRetained();
		manageObservationPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 33)
	public void verifyPeriodFilterNotRetained(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		manageObservationPage = homepage.clickManageObservations();
		manageObservationPage.selectFilter(TestUtils.getTestData(data, "PeriodFilter"));
		manageObservationPage.selectNextDrop();
		homepage = manageObservationPage.clickPageTitle();
		manageObservationPage = homepage.clickManageObservations();
		manageObservationPage.verifyFilterIsNotRetained();
		manageObservationPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 34)
	public void verifyStudentFilterAfterCancel(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		manageObservationPage = homepage.clickManageObservations();
		manageObservationPage.selectFilter(TestUtils.getTestData(data, "StudentsFilter"));
		manageObservationPage.selectNextDrop();
		enterObservationPage = manageObservationPage.clickObservation();
		manageObservationPage = enterObservationPage.clickCancel();
		manageObservationPage.verifyFilterIsRetained();
		manageObservationPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 35)
	public void verifyPeriodFilterAfterCancel(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		manageObservationPage = homepage.clickManageObservations();
		manageObservationPage.selectFilter(TestUtils.getTestData(data, "PeriodFilter"));
		manageObservationPage.selectNextDrop();
		enterObservationPage = manageObservationPage.clickObservation();
		manageObservationPage = enterObservationPage.clickCancel();
		manageObservationPage.verifyFilterIsRetained();
		manageObservationPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 36)
	public void verifyObservationPdf(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		manageObservationPage = homepage.clickManageObservations();
		enterObservationPage = manageObservationPage.clickEnterEvidence();
		enterObservationPage.selectStudent();
		enterObservationPage.clickLinkToPerformanceIndicators();
		enterObservationPage.chooseIndicators();
		enterObservationPage.saveIndicators();
		enterObservationPage.addAttachment();
		manageObservationPage = enterObservationPage.clickSave();
		enterObservationPage = manageObservationPage.clickObservation();
		enterObservationPage.verifyObservationPdf();
		enterObservationPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 37)
	public void verifyDownloadAttachment(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		manageObservationPage = homepage.clickManageObservations();
		enterObservationPage = manageObservationPage.clickObservation();
		enterObservationPage.verifyDownloadAttachment();
		enterObservationPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 38)
	public void verifyDownloadAttachmentEvidencePage(Hashtable<String, String> data, ITestContext context)
			throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		manageObservationPage = homepage.clickManageObservations();
		manageObservationPage.verifyDownloadAttachmentOnEvidencePage();
		manageObservationPage.logout();
	}
}