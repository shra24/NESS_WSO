package com.ness.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.ness.base.PageBase;

public class GenerateReports_Page extends PageBase {

	@FindBy(id = "printChecklist")
	private WebElement printChecklist;

	@FindBy(id = "outcomesReports")
	private WebElement outcomesReports;

	@FindBy(xpath = "//div[@class='panel-body']/div[4]")
	private WebElement classProfile;

	@FindBy(id = "classRatings")
	private WebElement classRatings;

	@FindBy(id = "studentList")
	private WebElement printFor;

	@FindBy(id = "grade")
	private WebElement gradeLevel;

	@FindBy(id = "year")
	private WebElement academicYear;

	@FindBy(id = "include")
	private WebElement includePrelim;

	@FindBy(id = "includeComments")
	private WebElement includeComments;

	@FindBy(id = "selectAll")
	private WebElement allDomains;

	@FindBy(xpath = "//div[@class='modal-footer']/button[1]")
	private WebElement submit;

	@FindBy(id = "title")
	private WebElement title;

	@FindBy(id = "reportType")
	private WebElement reportType;

	@FindBy(id = "filter")
	private WebElement filterBy;

	@FindBy(id = "printDevelopmentProfile")
	private WebElement printDevelopmentProfile;

	@FindBy(id = "ounceDueDate")
	private WebElement ageLevelExpiry;

	@FindBy(id = "studentList")
	private WebElement selectAChild;

	@FindBy(id = "sort")
	private WebElement sortBy;

	public GenerateReports_Page(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public GenerateReports_Page clickChecklist() throws InterruptedException {
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(printChecklist));
		printChecklist.click();
		// Thread.sleep(3000);
		return new GenerateReports_Page(driver);
	}

	public GenerateReports_Page selectPrintFor(String student) throws InterruptedException {
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(printFor));
		Select selectPrintFor = new Select(printFor);
		selectPrintFor.selectByVisibleText(student);
		Thread.sleep(3000);
		return new GenerateReports_Page(driver);
	}

	public GenerateReports_Page selectGradeLevel(String grade) throws InterruptedException {
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(gradeLevel));
		Select selectGradeLevel = new Select(gradeLevel);
		selectGradeLevel.selectByVisibleText(grade);
		Thread.sleep(3000);
		return new GenerateReports_Page(driver);
	}

	public GenerateReports_Page selectAcademicYear(String year) {
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(academicYear));
		Select selectAcademicYear = new Select(academicYear);
		selectAcademicYear.selectByVisibleText(year);
		return new GenerateReports_Page(driver);
	}

	public GenerateReports_Page includePreliminaryRatings() {
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(includePrelim));
		includePrelim.click();
		return new GenerateReports_Page(driver);
	}

	public GenerateReports_Page includeComments() {
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(includeComments));
		includeComments.click();
		return new GenerateReports_Page(driver);
	}

	public GenerateReports_Page selectAllDomains() {
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(allDomains));
		allDomains.click();
		return new GenerateReports_Page(driver);
	}

	public GenerateReports_Page clickSubmit() throws InterruptedException {
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(submit));
		submit.click();
		Thread.sleep(5000);
		return new GenerateReports_Page(driver);
	}

	public GenerateReports_Page verifyChecklistReportDownload() throws InterruptedException, IOException {
		Assert.assertTrue(isFileDownloaded(downloadPath, "CheckListReport"),
				"Failed to download expected file");
		return new GenerateReports_Page(driver);
	}

	public GenerateReports_Page verifyClassChecklistReportDownload() throws InterruptedException, IOException {
		Assert.assertTrue(isFileDownloaded(downloadPath, "ClassCheckListReport"),
				"Failed to download expected file");
		return new GenerateReports_Page(driver);
	}

	public GenerateReports_Page clickClassOutcomes() throws InterruptedException {
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(outcomesReports));
		outcomesReports.click();
		// Thread.sleep(3000);
		return new GenerateReports_Page(driver);
	}

	public GenerateReports_Page enterTitle(String reportTitle) {
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(title));
		title.sendKeys(reportTitle);
		return new GenerateReports_Page(driver);
	}

	public GenerateReports_Page selectReportType(String type) throws InterruptedException {
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(reportType));
		Select selectReportType = new Select(reportType);
		selectReportType.selectByVisibleText(type);
		return new GenerateReports_Page(driver);
	}

	public GenerateReports_Page verifyClassOutcomesReportDownload() throws InterruptedException, IOException {
		Assert.assertTrue(isFileDownloaded(downloadPath, "Class Outcomes Report"), "Failed to download expected file");
		return new GenerateReports_Page(driver);
	}

	public ClassProfile_Page clickClassProfile() throws InterruptedException {
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(classProfile));
		classProfile.click();
		Thread.sleep(5000);
		return new ClassProfile_Page(driver);
	}

	public GenerateReports_Page clickClassRatings() throws InterruptedException {
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(classRatings));
		classRatings.click();
		Thread.sleep(3000);
		return new GenerateReports_Page(driver);
	}

	public GenerateReports_Page selectFilter(String filter) throws InterruptedException {
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(filterBy));
		Select selectFilterBy = new Select(filterBy);
		selectFilterBy.selectByVisibleText(filter);
		return new GenerateReports_Page(driver);
	}

	public GenerateReports_Page verifyClassRatingsReportDownload() throws InterruptedException {
		Assert.assertTrue(isFileDownloaded(downloadPath, "WsClassRatingReport"),
				"Failed to download expected file");
		return new GenerateReports_Page(driver);
	}

	public GenerateReports_Page clickDevProfile() throws InterruptedException {
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(printDevelopmentProfile));
		printDevelopmentProfile.click();
		// Thread.sleep(3000);
		return new GenerateReports_Page(driver);
	}

	public GenerateReports_Page selectChild(String child) throws InterruptedException {
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(selectAChild));
		Select selectChild = new Select(selectAChild);
		selectChild.selectByVisibleText(child);
		Thread.sleep(3000);
		return new GenerateReports_Page(driver);
	}

	public GenerateReports_Page verifyDevProfileReportDownload() throws InterruptedException {
		Assert.assertTrue(isFileDownloaded(downloadPath, "DevelopmentalProfile"), "Failed to download expected file");
		return new GenerateReports_Page(driver);
	}

	public GenerateReports_Page clickAgeLevelExpiry() throws InterruptedException {
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(ageLevelExpiry));
		ageLevelExpiry.click();
		// Thread.sleep(3000);
		return new GenerateReports_Page(driver);
	}

	public GenerateReports_Page selectSortBy(String sort) throws InterruptedException {
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(sortBy));
		Select selectSortBy = new Select(sortBy);
		selectSortBy.selectByVisibleText(sort);
		return new GenerateReports_Page(driver);
	}

	public GenerateReports_Page verifyAgeLevelExpiryDateReportDownload() throws InterruptedException {
		Assert.assertTrue(isFileDownloaded(downloadPath, "AgeLevelExpiryDate"), "Failed to download expected file");
		return new GenerateReports_Page(driver);
	}
}