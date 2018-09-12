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
import com.ness.pages.ManageStudents_Page;
import com.ness.utilities.TestUtils;
import com.ness.utilities.Xls_Reader;

public class ObservationOunce {
	Home_Page homepage;
	ManageObservation_Page manageObservationPage;
	EnterObservation_Page enterObservationPage;
	ManageStudents_Page manageStudentsPage;
	Logout_Page logoutPage;

	private final static String testData = Constants.TESTDATA_LOC;
	private static Xls_Reader xls = new Xls_Reader(testData);

	@DataProvider
	private Object[][] getTestData() {
		System.out.println("Executing DataProvider");
		return TestUtils.getData("Ounce", xls);
	}

	@Test(dataProvider = "getTestData", groups = "Sanity", priority = 123)
	public void createNewObservationOunce(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		manageObservationPage = homepage.clickOunceManageObservations();
		enterObservationPage = manageObservationPage.clickEnterEvidence();
		enterObservationPage.selectStudent();
		enterObservationPage.clickLinkToPerformanceIndicatorsOunce();
		enterObservationPage.chooseOunceIndicators();
		enterObservationPage.saveIndicators();
		enterObservationPage.enterTitleDescription(TestUtils.getTestData(data, "OunceEvidenceTitle"),
				TestUtils.getTestData(data, "OunceEvidenceDescription"));
		manageObservationPage = enterObservationPage.clickSave();
		manageObservationPage.verifyEvidenceIsCreated();
		manageObservationPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Sanity", priority = 124)
	public void verifyAutoSaveDescriptionOunce(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		manageObservationPage = homepage.clickOunceManageObservations();
		enterObservationPage = manageObservationPage.clickEnterEvidence();
		enterObservationPage.selectStudent();
		enterObservationPage.clickLinkToPerformanceIndicatorsOunce();
		enterObservationPage.chooseOunceIndicators();
		enterObservationPage.saveIndicators();
		enterObservationPage.enterTitleDescription(TestUtils.getTestData(data, "OunceEvidenceTitle"),
				TestUtils.getTestData(data, "OunceEvidenceDescription"));
		enterObservationPage.verifyAutoSave();
		manageObservationPage = enterObservationPage.clickSave();
		manageObservationPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Sanity", priority = 125)
	public void deleteObservationOunce(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		manageObservationPage = homepage.clickOunceManageObservations();
		enterObservationPage = manageObservationPage.clickObservationOunce();
		manageObservationPage = enterObservationPage.clickDeleteObservation();
		manageObservationPage.verifyObservationIsDeleted();
		manageObservationPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Sanity", priority = 126)
	public void downloadObservationPresentOunce(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		manageObservationPage = homepage.clickOunceManageObservations();
		enterObservationPage = manageObservationPage.clickObservationOunce();
		enterObservationPage.verifyDownloadObservation();
		enterObservationPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Sanity", priority = 127)
	public void deleteObservationPresentOunce(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		manageObservationPage = homepage.clickOunceManageObservations();
		enterObservationPage = manageObservationPage.clickEnterEvidence();
		enterObservationPage.selectStudent();
		enterObservationPage.clickLinkToPerformanceIndicatorsOunce();
		enterObservationPage.chooseOunceIndicators();
		enterObservationPage.saveIndicators();
		enterObservationPage.enterTitleDescription(TestUtils.getTestData(data, "OunceEvidenceTitle"),
				TestUtils.getTestData(data, "OunceEvidenceDescription"));
		enterObservationPage.isDeleteButtonPresent();
		manageObservationPage = enterObservationPage.clickSave();
		manageObservationPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Sanity", priority = 128)
	public void saveWithoutTitleOunce(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		manageObservationPage = homepage.clickOunceManageObservations();
		enterObservationPage = manageObservationPage.clickEnterEvidence();
		enterObservationPage.selectStudent();
		enterObservationPage.clickSave();
		enterObservationPage.verifySaveWithoutTitleAlert();
		enterObservationPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Sanity", priority = 129)
	public void verifySaveButtonDisabledOunce(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		manageObservationPage = homepage.clickOunceManageObservations();
		enterObservationPage = manageObservationPage.clickEnterEvidence();
		enterObservationPage.verifySaveButtonDisabled();
		enterObservationPage.selectStudent();
		enterObservationPage.clickLinkToPerformanceIndicatorsOunce();
		enterObservationPage.chooseOunceIndicators();
		enterObservationPage.saveIndicators();
		enterObservationPage.enterTitleDescription(TestUtils.getTestData(data, "OunceEvidenceTitle"),
				TestUtils.getTestData(data, "OunceEvidenceDescription"));
		manageObservationPage = enterObservationPage.clickSave();
		manageObservationPage.verifyEvidenceIsCreated();
		manageObservationPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Sanity", priority = 130)
	public void verifyStudentFilterOunce(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		manageObservationPage = homepage.clickOunceManageObservations();
		manageObservationPage.selectFilter(TestUtils.getTestData(data, "ChildrenFilter"));
		manageObservationPage.selectNextDrop();
		manageObservationPage.verifyfilteredStudent();
		manageObservationPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Sanity", priority = 131)
	public void verifyFilterIsRetainedAfterBackOunce(Hashtable<String, String> data, ITestContext context)
			throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		manageObservationPage = homepage.clickOunceManageObservations();
		manageObservationPage.selectFilter(TestUtils.getTestData(data, "ChildrenFilter"));
		manageObservationPage.selectNextDrop();
		enterObservationPage = manageObservationPage.clickObservationOunce();
		manageObservationPage = enterObservationPage.backToManageObservationPage();
		manageObservationPage.verifyFilterIsRetained();
		manageObservationPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Sanity", priority = 132)
	public void verifyFilterIsRetainedAfterSaveOunce(Hashtable<String, String> data, ITestContext context)
			throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		manageObservationPage = homepage.clickOunceManageObservations();
		manageObservationPage.selectFilter(TestUtils.getTestData(data, "ChildrenFilter"));
		manageObservationPage.selectNextDrop();
		enterObservationPage = manageObservationPage.clickObservationOunce();
		manageObservationPage = enterObservationPage.clickSave();
		manageObservationPage.verifyFilterIsRetained();
		manageObservationPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Sanity", priority = 133)
	public void verifyFilterIsRetainedAfterDeleteOunce(Hashtable<String, String> data, ITestContext context)
			throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		manageObservationPage = homepage.clickOunceManageObservations();
		manageObservationPage.selectFilter(TestUtils.getTestData(data, "ChildrenFilter"));
		manageObservationPage.selectNextDrop();
		enterObservationPage = manageObservationPage.clickObservationOunce();
		manageObservationPage = enterObservationPage.clickDeleteObservation();
		manageObservationPage.verifyObservationIsDeleted();
		manageObservationPage.verifyFilterIsRetained();
		manageObservationPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Sanity", priority = 134)
	public void editStudentInObservationOunce(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		manageObservationPage = homepage.clickOunceManageObservations();
		manageObservationPage.verifyActualStudent();
		enterObservationPage = manageObservationPage.clickObservationOunce();
		enterObservationPage.editStudent();
		enterObservationPage.clickLinkToPerformanceIndicatorsOunce();
		enterObservationPage.chooseOunceIndicators();
		enterObservationPage.saveIndicators();
		enterObservationPage.enterTitleDescription(TestUtils.getTestData(data, "OunceEvidenceTitle"),
				TestUtils.getTestData(data, "OunceEvidenceDescription"));
		manageObservationPage = enterObservationPage.clickSave();
		manageObservationPage.verifyEditedStudent();
		manageObservationPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 135)
	public void editTitleDescriptionInObservationOunce(Hashtable<String, String> data, ITestContext context)
			throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		manageObservationPage = homepage.clickOunceManageObservations();
		enterObservationPage = manageObservationPage.clickObservationOunce();
		enterObservationPage.enterTitleDescription("Edited Ounce Evidence 1", "Edited Age level: Babies I");
		manageObservationPage = enterObservationPage.clickSave();
		manageObservationPage.verifyEditedTitleDescription();
		manageObservationPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 136)
	public void verifyDesciptionCounterOunce(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		manageObservationPage = homepage.clickOunceManageObservations();
		enterObservationPage = manageObservationPage.clickObservationOunce();
		enterObservationPage.verifyDescriptionCounter();
		manageObservationPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 137)
	public void verifyAddedAttachmentOunce(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		manageObservationPage = homepage.clickOunceManageObservations();
		enterObservationPage = manageObservationPage.clickEnterEvidence();
		enterObservationPage.selectStudent();
		enterObservationPage.clickLinkToPerformanceIndicatorsOunce();
		enterObservationPage.chooseOunceIndicators();
		enterObservationPage.saveIndicators();
		enterObservationPage.addAttachment();
		enterObservationPage.enterTitleDescription(TestUtils.getTestData(data, "OunceEvidenceTitle"),
				TestUtils.getTestData(data, "OunceEvidenceDescription"));
		manageObservationPage = enterObservationPage.clickSave();
		manageObservationPage.verifyAddedAttachment();
		manageObservationPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 138)
	public void addDescriptionWithoutChildSelect(Hashtable<String, String> data, ITestContext context)
			throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		manageObservationPage = homepage.clickOunceManageObservations();
		enterObservationPage = manageObservationPage.clickEnterEvidence();
		enterObservationPage.clickDescriptionTextBox();
		enterObservationPage.verifySelectChildAlert();
		enterObservationPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 139)
	public void addDescriptionWithoutTitleOunce(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		manageObservationPage = homepage.clickOunceManageObservations();
		enterObservationPage = manageObservationPage.clickEnterEvidence();
		enterObservationPage.selectStudent();
		enterObservationPage.clickDescriptionTextBox();
		enterObservationPage.verifyTitleFirstAlert();
		enterObservationPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 140)
	public void addIndicatorsWithoutChildSelect(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		manageObservationPage = homepage.clickOunceManageObservations();
		enterObservationPage = manageObservationPage.clickEnterEvidence();
		enterObservationPage.clickLinkToPerformanceIndicatorsOunce();
		enterObservationPage.verifySelectChildFirstAlert();
		enterObservationPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 141)
	public void verifyAttachmentNameAsTitleOunce(Hashtable<String, String> data, ITestContext context)
			throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		manageObservationPage = homepage.clickOunceManageObservations();
		enterObservationPage = manageObservationPage.clickEnterEvidence();
		enterObservationPage.selectStudent();
		enterObservationPage.addAttachment();
		manageObservationPage = enterObservationPage.clickSave();
		manageObservationPage.verifyAttachmentNameAsTitle();
		manageObservationPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 142)
	public void verifyNoDescriptionAddedTextOunce(Hashtable<String, String> data, ITestContext context)
			throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		manageObservationPage = homepage.clickOunceManageObservations();
		enterObservationPage = manageObservationPage.clickEnterEvidence();
		enterObservationPage.selectStudent();
		enterObservationPage.addAttachment();
		manageObservationPage = enterObservationPage.clickSave();
		manageObservationPage.verifyNoDescriptionAddedText();
		manageObservationPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 143)
	public void verifyMultipleChildrenMultipleAttachments(Hashtable<String, String> data, ITestContext context)
			throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		manageObservationPage = homepage.clickOunceManageObservations();
		enterObservationPage = manageObservationPage.clickEnterEvidence();
		enterObservationPage.selectAllStudents();
		enterObservationPage.clickLinkToPerformanceIndicatorsOunce();
		enterObservationPage.chooseOunceIndicators();
		enterObservationPage.saveIndicators();
		enterObservationPage.addMultipleAttachments();
		enterObservationPage.enterTitleDescription(TestUtils.getTestData(data, "OunceEvidenceTitle"),
				TestUtils.getTestData(data, "OunceEvidenceDescription"));
		manageObservationPage = enterObservationPage.clickSave();
		manageObservationPage.verifyMultipledAttachmentsAdded();
		manageObservationPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 144)
	public void verifyDeleteAttachmentOunce(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		manageObservationPage = homepage.clickOunceManageObservations();
		enterObservationPage = manageObservationPage.clickEnterEvidence();
		enterObservationPage.selectStudent();
		enterObservationPage.clickLinkToPerformanceIndicatorsOunce();
		enterObservationPage.chooseOunceIndicators();
		enterObservationPage.saveIndicators();
		enterObservationPage.addMultipleAttachments();
		enterObservationPage.enterTitleDescription(TestUtils.getTestData(data, "OunceEvidenceTitle"),
				TestUtils.getTestData(data, "OunceEvidenceDescription"));
		manageObservationPage = enterObservationPage.clickSave();
		enterObservationPage = manageObservationPage.clickObservationOunce();
		enterObservationPage.deleteAttachment();
		manageObservationPage = enterObservationPage.clickSave();
		manageObservationPage.verifyDeleteAttachment();
		manageObservationPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 145)
	public void verifySelectAllChildrenFilter(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		manageObservationPage = homepage.clickOunceManageObservations();
		manageObservationPage.selectFilter(TestUtils.getTestData(data, "ChildrenFilter"));
		manageObservationPage.verifyDefaultFilter();
		manageObservationPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 146)
	public void verifyChildrenFilterAfterRemoveChild(Hashtable<String, String> data, ITestContext context)
			throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		manageObservationPage = homepage.clickOunceManageObservations();
		enterObservationPage = manageObservationPage.clickEnterEvidence();
		enterObservationPage.selectAllStudents();
		enterObservationPage.enterTitleDescription(TestUtils.getTestData(data, "OunceEvidenceTitle"),
				TestUtils.getTestData(data, "OunceEvidenceDescription"));
		manageObservationPage = enterObservationPage.clickSave();
		manageObservationPage.selectFilter(TestUtils.getTestData(data, "ChildrenFilter"));
		manageObservationPage.selectNextDrop();
		enterObservationPage = manageObservationPage.clickObservationOunce();
		enterObservationPage.removeStudent();
		manageObservationPage = enterObservationPage.clickSave();
		manageObservationPage.verifyFilterIsRetained();
		manageObservationPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 147)
	public void verifyChildrenFilterNotRetained(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		manageObservationPage = homepage.clickOunceManageObservations();
		manageObservationPage.selectFilter(TestUtils.getTestData(data, "ChildrenFilter"));
		manageObservationPage.selectNextDrop();
		homepage = manageObservationPage.clickPageTitle();
		manageObservationPage = homepage.clickOunceManageObservations();
		manageObservationPage.verifyFilterIsNotRetained();
		manageObservationPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 148)
	public void verifyChildrenFilterAfterCancel(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		manageObservationPage = homepage.clickOunceManageObservations();
		manageObservationPage.selectFilter(TestUtils.getTestData(data, "ChildrenFilter"));
		manageObservationPage.selectNextDrop();
		enterObservationPage = manageObservationPage.clickObservationOunce();
		manageObservationPage = enterObservationPage.clickCancel();
		manageObservationPage.verifyFilterIsRetained();
		manageObservationPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 149)
	public void verifyObservationPdfOunce(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		manageObservationPage = homepage.clickOunceManageObservations();
		enterObservationPage = manageObservationPage.clickEnterEvidence();
		enterObservationPage.selectStudent();
		enterObservationPage.clickLinkToPerformanceIndicatorsOunce();
		enterObservationPage.chooseOunceIndicators();
		enterObservationPage.saveIndicators();
		enterObservationPage.addAttachment();
		manageObservationPage = enterObservationPage.clickSave();
		enterObservationPage = manageObservationPage.clickObservationOunce();
		enterObservationPage.verifyObservationPdfOunce();
		enterObservationPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 150)
	public void verifyDownloadAttachmentOunce(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		manageObservationPage = homepage.clickOunceManageObservations();
		enterObservationPage = manageObservationPage.clickObservationOunce();
		enterObservationPage.verifyDownloadAttachment();
		enterObservationPage.logout();
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 151)
	public void verifyDownloadAttachmentEvidencePageOunce(Hashtable<String, String> data, ITestContext context)
			throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.OUNCE_URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "TeacherUsername"),
				TestUtils.getTestData(data, "Password"));

		homepage = new Home_Page(driver);
		manageObservationPage = homepage.clickOunceManageObservations();
		manageObservationPage.verifyDownloadAttachmentOnEvidencePage();
		manageObservationPage.logout();
	}
}