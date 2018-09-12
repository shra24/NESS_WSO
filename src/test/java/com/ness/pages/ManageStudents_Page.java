package com.ness.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.ness.base.PageBase;

public class ManageStudents_Page extends PageBase {

	@FindBy(id = "appTitle")
	private WebElement pageTitle;

	@FindBy(id = "addStudent")
	private WebElement addStudent;

	@FindBy(id = "firstName")
	private WebElement enterFirstName;

	@FindBy(id = "lastName")
	private WebElement enterLastName;

	@FindBy(id = "gender")
	private WebElement chooseGender;

	@FindBy(id = "grade")
	private WebElement chooseGrade;

	@FindBy(id = "dobYear")
	private WebElement chooseDobYear;

	@FindBy(id = "month")
	private WebElement chooseMonth;

	@FindBy(id = "dateDob")
	private WebElement chooseDOB;

	@FindBy(id = "language")
	private WebElement chooseLanguage;

	@FindBy(id = "ethnicity")
	private WebElement chooseEthnicity;

	@FindBy(id = "iepFlag")
	private WebElement selectIEP;

	@FindBy(xpath = "//button[@class='btn btn-primary' and contains(text(), 'Save')]")
	private WebElement saveStudent;

	@FindBy(xpath = "//input[@class='btn btn-primary']")
	private WebElement saveExistingStudent;

	@FindBy(css = "#alertDoneBtn")
	private WebElement doneBtn;

	@FindBy(xpath = "//button[@class='btn btn-primary' and contains(text(), 'OK')]")
	private WebElement okBtn;

	@FindBy(xpath = "//div[@class='modal-body']/p")
	private WebElement duplicateStdMsg;

	@FindBy(xpath = "//table[@id='manageStudentTable']/tbody/tr[1]/td[1]/label/i")
	private WebElement selectStudent1;

	@FindBy(xpath = "//table[@id='addExistingTable']/tbody/tr/td[5]/label/i")
	private WebElement selectExistingStudent1;

	@FindBy(id = "archive")
	private WebElement archiveStudent;

	@FindBy(id = "unarchive")
	private WebElement unarchiveStudent;

	@FindBy(id = "deleteStudent")
	private WebElement deleteStudent;

	@FindBy(id = "undeleteStudent")
	private WebElement undeleteStudent;

	@FindBy(id = "remove")
	private WebElement removeStudent;

	@FindBy(id = "addExisting")
	private WebElement addExistingStudent;

	@FindBy(id = "manClass")
	private WebElement manageClasses;

	@FindBy(xpath = "//table[@id='manageStudentTable']/thead/tr/th/a/i")
	private WebElement selectAll;

	@FindBy(id = "studState")
	private WebElement manageStatus;

	@FindBy(id = "removeStudent")
	private WebElement removeStudentFromSystem;

	@FindBy(id = "childrenChk")
	private WebElement childrenChk;

	@FindBy(id = "classChk")
	private WebElement classChk;

	@FindBy(id = "teacherchk")
	private WebElement teacherchk;

	@FindBy(id = "deleteConfirmButtonId")
	private WebElement deleteConfirmButtonId;

	@FindBy(css = "img[src*='busy.gif']")
	private WebElement blockUI;

	@FindBy(xpath = "//tr[@class='odd']/td/span")
	private WebElement AgeLevelCueing1;

	@FindBy(xpath = "//tr[@class='even']/td/span")
	private WebElement AgeLevelCueing2;

	@FindBy(xpath = "//div[@class='popover-content']/span/a[@class='inline']")
	private WebElement manageAgeLevelOnCueing;

	@FindBy(xpath = "//div[@class='popover-content']/span/input")
	private WebElement doNotShowOnCueing;

	@FindBy(id = "1")
	private WebElement babies1AgeLevel;

	@FindBy(id = "2")
	private WebElement babies2AgeLevel;

	@FindBy(xpath = "//input[@class='btn btn-primary']")
	private WebElement saveAgeLevel;

	@FindBy(id = "studLoc")
	private WebElement manageLocation;

	@FindBy(id = "transfer")
	private WebElement transferStudent;

	@FindBy(id = "s2id_toSiteId")
	private WebElement selectSite;

	@FindBy(id = "s2id_toClassId")
	private WebElement selectClass;

	@FindBy(id = "transferBtnId")
	private WebElement transferButton;

	@FindBy(xpath = "//tbody[@id='manageStudentTableBody']/tr/td[8]")
	private WebElement classColumn;

	@FindBy(xpath = "//tbody[@id='manageStudentTableBody']/tr/td[6]")
	private WebElement statusColumn;

	@FindBy(id = "addClass")
	private WebElement addClass;

	@FindBy(id = "history")
	private WebElement historyButton;

	@FindBy(xpath = "//form[@id='histFormHtml']/div[3]/button[1]")
	private WebElement historyOKButton;

	@FindBy(id = "eventChart")
	private WebElement eventChart;

	@FindBy(xpath = "//div[@class='studentEvent']")
	private WebElement studentEvent;

	@FindBy(id = "exportOptions")
	private WebElement exportOptions;

	@FindBy(id = "exportExcel")
	private WebElement exportExcel;

	@FindBy(id = "exportCsv")
	private WebElement exportCsv;

	@FindBy(id = "btnProxy")
	private WebElement proxyButton;

	@FindBy(id = "redirectFromClassSiteSelector")
	private WebElement returnProxyButton;

	@FindBy(xpath = "//div[@id='studentFields']/span[1]")
	private WebElement nameBlankError;

	@FindBy(xpath = "//div[@id='studentFields']/span[2]")
	private WebElement genderBlankError;

	@FindBy(xpath = "//div[@id='studentFields']/span[3]")
	private WebElement gradeBlankError;

	@FindBy(xpath = "//div[@id='studentFields']/span[4]")
	private WebElement birthdateBlankError;

	@FindBy(xpath = "//tbody[@id='manageStudentTableBody']/tr[1]/td[2]/a")
	private WebElement studentName;

	@FindBy(id = "childPlusImport")
	private WebElement childPlusImport;

	public ManageStudents_Page(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public ManageStudents_Page clickAddStudent() throws InterruptedException {
		try {
			if (doneBtn.isDisplayed()) {
				Thread.sleep(5000);
				doneBtn.click();
				Thread.sleep(5000);
				addStudent.click();
				Thread.sleep(5000);
			}
		} catch (Exception e) {
			addStudent.click();
			Thread.sleep(5000);
		}
		return new ManageStudents_Page(driver);
	}

	public ManageStudents_Page enterStudentName(String firstName, String lastName) {
		enterFirstName.clear();
		enterFirstName.sendKeys(firstName);
		enterLastName.clear();
		enterLastName.sendKeys(lastName);
		return new ManageStudents_Page(driver);
	}

	public ManageStudents_Page selectGender(String gender) {
		Select selectGender = new Select(chooseGender);
		selectGender.selectByVisibleText(gender);
		return new ManageStudents_Page(driver);
	}

	public ManageStudents_Page selectGrade(String grade) {
		Select selectGrade = new Select(chooseGrade);
		selectGrade.selectByVisibleText(grade);
		return new ManageStudents_Page(driver);
	}

	public ManageStudents_Page selectYear(String year) {
		Select selectYear = new Select(chooseDobYear);
		selectYear.selectByVisibleText(year);
		return new ManageStudents_Page(driver);
	}

	public ManageStudents_Page selectMonth(String month) {
		Select selectMonth = new Select(chooseMonth);
		selectMonth.selectByVisibleText(month);
		return new ManageStudents_Page(driver);
	}

	public ManageStudents_Page selectDay(String day) {
		Select selectDate = new Select(chooseDOB);
		selectDate.selectByVisibleText(day);
		return new ManageStudents_Page(driver);
	}

	public ManageStudents_Page selectIEP() {
		selectIEP.click();
		return new ManageStudents_Page(driver);
	}

	public ManageStudents_Page selectLanguage(String language) {
		Select selectLanguage = new Select(chooseLanguage);
		selectLanguage.selectByVisibleText(language);
		return new ManageStudents_Page(driver);
	}

	public ManageStudents_Page selectEthnicity(String ethnicity) {
		Select selectEthnicity = new Select(chooseEthnicity);
		selectEthnicity.selectByVisibleText(ethnicity);
		return new ManageStudents_Page(driver);
	}

	public ManageStudents_Page clickSave() throws InterruptedException {
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(saveStudent));
		saveStudent.click();
		Thread.sleep(10000);
		return new ManageStudents_Page(driver);
	}

	public ManageStudents_Page verifyDuplicateStudentMsg() throws InterruptedException {
		try {
			if (okBtn.isDisplayed()) {
				Assert.assertEquals(duplicateStdMsg.getText(),
						"A student of name student-One last-One already exists in this license. Do you want to add another student of the same name?");
				okBtn.click();
				Thread.sleep(10000);
			}
		} catch (Exception e) {
		}
		return new ManageStudents_Page(driver);
	}

	public ManageStudents_Page verifyDuplicateChildMsg() throws InterruptedException {
		try {
			if (okBtn.isDisplayed()) {
				Assert.assertEquals(duplicateStdMsg.getText(),
						"A child of name child-One last-One already exists in this license. Do you want to add another child of the same name?");
				okBtn.click();
				Thread.sleep(10000);
			}
		} catch (Exception e) {
		}
		return new ManageStudents_Page(driver);
	}

	public ManageStudents_Page verifyRemoveFromClassStudent() throws InterruptedException {
		selectStudent1.click();
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(removeStudent));
		removeStudent.click();
		Thread.sleep(3000);
		okBtn.click();
		Thread.sleep(5000);
		try {
			if (doneBtn.isDisplayed()) {
				doneBtn.click();
				Thread.sleep(5000);
				System.out.println("Student(s) is been removed from the class.");
			}
		} catch (Exception e) {

		}
		return new ManageStudents_Page(driver);
	}

	public ManageStudents_Page verifyAddExistingStudent() throws InterruptedException {
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(addExistingStudent));
		addExistingStudent.click();
		Thread.sleep(3000);
		selectExistingStudent1.click();
		saveExistingStudent.click();
		Thread.sleep(5000);
		return new ManageStudents_Page(driver);
	}

	public ManageStudents_Page verifyArchiveStudent() throws InterruptedException {
		selectStudent1.click();
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(archiveStudent));
		archiveStudent.click();
		Thread.sleep(3000);
		okBtn.click();
		Thread.sleep(5000);
		try {
			if (doneBtn.isDisplayed()) {
				doneBtn.click();
				Thread.sleep(5000);
				System.out.println("Student(s) is been archived.");
			}
		} catch (Exception e) {

		}
		return new ManageStudents_Page(driver);
	}

	public ManageStudents_Page verifyDeleteStudent() throws InterruptedException {
		selectStudent1.click();
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(deleteStudent));
		deleteStudent.click();
		Thread.sleep(3000);
		okBtn.click();
		Thread.sleep(5000);
		try {
			if (doneBtn.isDisplayed()) {
				doneBtn.click();
				Thread.sleep(5000);
				System.out.println("Student(s) is been deleted.");
			}
		} catch (Exception e) {

		}
		return new ManageStudents_Page(driver);
	}

	public ManageStudents_Page verifyRemoveFromSystem() throws InterruptedException {
		selectAll.click();
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(manageStatus));
		manageStatus.click();
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(removeStudentFromSystem));
		removeStudentFromSystem.click();
		new WebDriverWait(driver, 20).until(ExpectedConditions.and(ExpectedConditions.elementToBeClickable(childrenChk),
				ExpectedConditions.elementToBeClickable(classChk),
				ExpectedConditions.elementToBeClickable(teacherchk)));
		childrenChk.click();
		classChk.click();
		teacherchk.click();
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(deleteConfirmButtonId));
		deleteConfirmButtonId.click();
		Thread.sleep(5000);
		return new ManageStudents_Page(driver);
	}

	public ManageStudents_Page verifyTransferStudent() throws InterruptedException {
		selectStudent1.click();
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(manageLocation));
		manageLocation.click();
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(transferStudent));
		transferStudent.click();
		Thread.sleep(3000);
		selectSite.click();
		driver.findElement(By.xpath("//div[@id='select2-drop']/ul/li[2]/div")).click();
		Thread.sleep(3000);
		selectClass.click();
		driver.findElement(By.xpath("//div[@id='select2-drop']/ul/li[2]/div")).click();
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(transferButton));
		transferButton.click();
		Thread.sleep(10000);
		Assert.assertEquals(classColumn.getText(), "AutomationWSOClass", "Student not transferred");
		return new ManageStudents_Page(driver);
	}

	public ManageStudents_Page verifyTransferChild() throws InterruptedException {
		selectStudent1.click();
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(manageLocation));
		manageLocation.click();
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(transferStudent));
		transferStudent.click();
		Thread.sleep(3000);
		selectSite.click();
		driver.findElement(By.xpath("//div[@id='select2-drop']/ul/li[2]/div")).click();
		Thread.sleep(3000);
		selectClass.click();
		driver.findElement(By.xpath("//div[@id='select2-drop']/ul/li[2]/div")).click();
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(transferButton));
		transferButton.click();
		Thread.sleep(10000);
		Assert.assertEquals(classColumn.getText(), "AutomationOunceClass", "Student not transferred");
		return new ManageStudents_Page(driver);
	}

	public ManageStudents_Page verifyRemoveFromClassAdminSide() throws InterruptedException {
		selectStudent1.click();
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(manageLocation));
		manageLocation.click();
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(removeStudent));
		removeStudent.click();
		Thread.sleep(3000);
		okBtn.click();
		Thread.sleep(7000);
		Assert.assertEquals(classColumn.getText(), "-", "Student not removed from class");
		return new ManageStudents_Page(driver);
	}

	public ManageStudents_Page verifyArchiveStudentAdminSide() throws InterruptedException {
		selectStudent1.click();
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(manageStatus));
		manageStatus.click();
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(archiveStudent));
		archiveStudent.click();
		Thread.sleep(3000);
		okBtn.click();
		Thread.sleep(7000);
		Assert.assertEquals(statusColumn.getText(), "Archived", "Student not Archived");
		return new ManageStudents_Page(driver);
	}

	public ManageStudents_Page verifyUnarchive() throws InterruptedException {
		selectStudent1.click();
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(manageStatus));
		manageStatus.click();
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(unarchiveStudent));
		unarchiveStudent.click();
		Thread.sleep(5000);
		Assert.assertEquals(statusColumn.getText(), "Active", "Student not Unarchived");
		return new ManageStudents_Page(driver);
	}

	public ManageStudents_Page verifyDeleteStudentAdminSide() throws InterruptedException {
		selectStudent1.click();
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(manageStatus));
		manageStatus.click();
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(deleteStudent));
		deleteStudent.click();
		Thread.sleep(3000);
		okBtn.click();
		Thread.sleep(7000);
		Assert.assertEquals(statusColumn.getText(), "Deleted", "Student not Deleted");
		return new ManageStudents_Page(driver);
	}

	public ManageStudents_Page verifyUndelete() throws InterruptedException {
		selectStudent1.click();
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(manageStatus));
		manageStatus.click();
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(undeleteStudent));
		undeleteStudent.click();
		Thread.sleep(5000);
		Assert.assertEquals(statusColumn.getText(), "Active", "Student not Undeleted");
		return new ManageStudents_Page(driver);
	}

	public ManageStudents_Page verifyAddToClassAdminSide() throws InterruptedException {
		selectStudent1.click();
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(manageLocation));
		manageLocation.click();
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(addExistingStudent));
		addExistingStudent.click();
		Thread.sleep(3000);
		Select selectClass = new Select(addClass);
		selectClass.selectByVisibleText("AutomationWSOClass (A SiteTeacher)");
		saveExistingStudent.click();
		Thread.sleep(7000);
		Assert.assertEquals(classColumn.getText(), "AutomationWSOClass", "Student not added to class");
		return new ManageStudents_Page(driver);
	}

	public ManageStudents_Page verifyAddToClassAdminSideOunce() throws InterruptedException {
		selectStudent1.click();
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(manageLocation));
		manageLocation.click();
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(addExistingStudent));
		addExistingStudent.click();
		Thread.sleep(3000);
		Select selectClass = new Select(addClass);
		selectClass.selectByVisibleText("AutomationOunceClass (A SiteTeacher)");
		saveExistingStudent.click();
		Thread.sleep(7000);
		Assert.assertEquals(classColumn.getText(), "AutomationOunceClass", "Child not added to class");
		return new ManageStudents_Page(driver);
	}

	public ManageStudents_Page verifyHistoryOfStudent() throws InterruptedException {
		selectStudent1.click();
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(historyButton));
		historyButton.click();
		Thread.sleep(5000);
		Assert.assertEquals(true, eventChart.isDisplayed(), "Event chart is not displayed");
		Assert.assertEquals(true, studentEvent.isDisplayed(), "Student Events are not displayed");
		historyOKButton.click();
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(historyButton));
		return new ManageStudents_Page(driver);
	}

	public ManageStudents_Page chooseAgeLevelAsBabies1() throws InterruptedException {
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(AgeLevelCueing1));
		AgeLevelCueing1.click();
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(manageAgeLevelOnCueing));
		manageAgeLevelOnCueing.click();
		Thread.sleep(3000);
		babies1AgeLevel.click();
		Thread.sleep(3000);
		saveAgeLevel.click();
		Thread.sleep(3000);
		try {
			if (AgeLevelCueing1.isDisplayed()) {
				AgeLevelCueing1.click();
				new WebDriverWait(driver, 20)
						.until(ExpectedConditions.and(ExpectedConditions.elementToBeClickable(manageAgeLevelOnCueing),
								ExpectedConditions.elementToBeClickable(doNotShowOnCueing)));
				doNotShowOnCueing.click();
				Thread.sleep(3000);
			}
		} catch (Exception e) {
		}
		return new ManageStudents_Page(driver);
	}

	public ManageStudents_Page verifyStudentExport() throws InterruptedException {
		exportOptions.click();
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(exportExcel));
		Assert.assertEquals(true, exportExcel.isDisplayed(), "Excel is not displayed");
		Assert.assertEquals(true, exportCsv.isDisplayed(), "Csv is not displayed");
		exportExcel.click();
		Thread.sleep(5000);
		Assert.assertTrue(isFileDownloaded(downloadPath, "StudentData"), "Failed to download expected file");
		return new ManageStudents_Page(driver);
	}

	public Home_Page verifyProxyAsTeacher() throws InterruptedException {
		proxyButton.click();
		Thread.sleep(5000);
		Assert.assertEquals(driver.findElement(By.xpath("//select[@id='class']/option[2]")).isSelected(), true,
				"Class not selected");
		returnProxyButton.click();
		Thread.sleep(5000);
		return new Home_Page(driver);
	}

	public ManageStudents_Page verifySaveWithoutRequiredFields() throws InterruptedException {
		Assert.assertEquals(true, nameBlankError.isDisplayed());
		Assert.assertEquals(true, genderBlankError.isDisplayed());
		Assert.assertEquals(true, gradeBlankError.isDisplayed());
		Assert.assertEquals(true, birthdateBlankError.isDisplayed());
		return new ManageStudents_Page(driver);
	}

	public ManageStudents_Page verifyEditStudentAdminSide(String firstName, String lastName)
			throws InterruptedException {
		studentName.click();
		Thread.sleep(5000);
		enterStudentName(firstName, lastName);
		clickSave();
		Assert.assertEquals(studentName.getText(), "studentOne", "Student not edited");
		return new ManageStudents_Page(driver);
	}

	public ManageStudents_Page verifyEditChildAdminSide(String firstName, String lastName) throws InterruptedException {
		studentName.click();
		Thread.sleep(5000);
		enterStudentName(firstName, lastName);
		clickSave();
		Assert.assertEquals(studentName.getText(), "childOne", "Student not edited");
		return new ManageStudents_Page(driver);
	}

	public ManageStudents_Page verifyChildPlusImportButton() throws InterruptedException {
		Assert.assertEquals(true, childPlusImport.isDisplayed());
		return new ManageStudents_Page(driver);
	}

	public ManageStudents_Page verifyChildPlusImportButtonOunce() throws InterruptedException {
		Assert.assertEquals(false, childPlusImport.isDisplayed());
		return new ManageStudents_Page(driver);
	}
}
