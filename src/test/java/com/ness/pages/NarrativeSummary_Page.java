package com.ness.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.ness.base.PageBase;

public class NarrativeSummary_Page extends PageBase {

	Select selectAPeriod;
	static String BeforeSaveTemplateTxt;
	static String AfterUseTemplateTxt;

	@FindBy(id = "studLink")
	private WebElement selectAStudent;

	@FindBy(xpath = "//ul[@id='studentDropDown']/li[1]/a")
	private WebElement selectStudent;

	@FindBy(id = "period")
	private WebElement selectPeriod;

	@FindBy(id = "daysPresent")
	private WebElement daysPresentTxtbx;

	@FindBy(id = "daysAbsent")
	private WebElement daysAbsentTxtbx;

	@FindBy(id = "daysTardy")
	private WebElement daysTardyTxtbx;

	@FindBy(id = "englishDes0")
	private WebElement domain1Comment;

	@FindBy(id = "engComment0")
	private WebElement teacherCommentHSFS;

	@FindBy(id = "spanishComments0")
	private WebElement spanishDomain1Comment;

	@FindBy(id = "spanishComments0")
	private WebElement teacherSpanishCommentHSFS;

	@FindBy(id = "englishDesOA1-0")
	private WebElement domain1CommentForObsRecord;

	@FindBy(id = "saveBtn")
	private WebElement saveNarrativeSummary;

	@FindBy(xpath = "//a[@class='back-btn']/i")
	private WebElement backForNarrativeSummary;

	@FindBy(id = "addComment_0")
	private WebElement addComment;

	@FindBy(xpath = "//div[@class='dropdown']/a")
	private WebElement addCommentOunce;

	@FindBy(id = "addComment_0_0")
	private WebElement addCommentOunceQ1;

	@FindBy(id = "addComment_OA1-0_OA1-0")
	private WebElement addCommentOunceObsRecordQ1;

	@FindBy(id = "checklistComment0")
	private WebElement checklistComment;

	@FindBy(xpath = "//div[@class='comment']")
	private WebElement devProfileComment;

	@FindBy(id = "delete")
	private WebElement deleteNarrativeSummary;

	@FindBy(css = "button[class='btn btn-primary']")
	private WebElement OKbtn;

	@FindBy(xpath = "//div[@class='modal-footer']/button[@class='btn btn-primary']")
	private WebElement OKbtnOunce;

	@FindBy(xpath = "//div[@class='modal-footer']/button[@class='btn']")
	private WebElement cancelBtnOunce;

	@FindBy(id = "saveTemplate")
	private WebElement saveTemplate;

	@FindBy(id = "useTemplate")
	private WebElement useTemplate;

	@FindBy(xpath = "//span[@class='maxlength-feedback']")
	private WebElement commentOneCounter;

	@FindBy(id = "eng")
	private WebElement englishLanguage;

	@FindBy(id = "spanish")
	private WebElement spanishLanguage;

	@FindBy(id = "both")
	private WebElement bothLanguage;

	@FindBy(xpath = "//a[@class='btn dropdown-toggle btn-primary']")
	private WebElement download;

	@FindBy(id = "downloadLinkId")
	private WebElement ounceDownload;

	@FindBy(id = "downloadId")
	private WebElement obsRecordDownload;

	@FindBy(id = "engButton")
	private WebElement selectEnglish;

	@FindBy(id = "spaButton")
	private WebElement selectSpanish;

	@FindBy(id = "printclassButton")
	private WebElement selectClass;

	@FindBy(css = "div[class='modal-body']>p")
	private WebElement alertMessage;

	@FindBy(id = "alertDoneBtn")
	private WebElement alertDone;

	@FindBy(id = "includes")
	private WebElement inclSumAssmnt;

	@FindBy(id = "incStdButton")
	private WebElement populateChkScore;

	@FindBy(xpath = "//p[@id='authorName']")
	private WebElement authorName;

	@FindBy(id = "OA1_Q1")
	private WebElement guidelinesQ1;

	@FindBy(xpath = "//div[@class='popover in guideline bottom']/h3")
	private WebElement guidelinesTitle;

	@FindBy(xpath = "//div[@class='popover in guideline bottom']/div[@class='popover-content']")
	private WebElement guidelinesBody;

	@FindBy(xpath = "//div[@class='popover in guideline bottom']/h3/span")
	private WebElement guidelinesClose;

	@FindBy(id = "grade")
	private WebElement grade;

	@FindBy(id = "summaryStdList0.areaStdList0.chkScore1")
	private WebElement chkScore1;

	@FindBy(id = "summaryStdList1.areaStdList0.chkScore1")
	private WebElement chkScore2;

	@FindBy(id = "summaryStdList2.areaStdList0.chkScore1")
	private WebElement chkScore3;

	@FindBy(id = "chkboxActive0")
	private WebElement chkBoxDomainOne;

	public NarrativeSummary_Page(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public NarrativeSummary_Page selectStudent() throws InterruptedException {
		selectAStudent.click();
		Thread.sleep(3000);
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(selectStudent));
		selectStudent.click();
		Thread.sleep(5000);
		return new NarrativeSummary_Page(driver);
	}

	public NarrativeSummary_Page selectPeriod(String period) throws InterruptedException {
		selectAPeriod = new Select(selectPeriod);
		selectAPeriod.selectByVisibleText(period);
		new WebDriverWait(driver, 30).until(ExpectedConditions.or(ExpectedConditions.visibilityOf(domain1Comment),
				ExpectedConditions.visibilityOf(spanishDomain1Comment)));
		return new NarrativeSummary_Page(driver);
	}

	public NarrativeSummary_Page selectPeriodForHSFS(String period) throws InterruptedException {
		selectAPeriod = new Select(selectPeriod);
		selectAPeriod.selectByVisibleText(period);
		return new NarrativeSummary_Page(driver);
	}

	public NarrativeSummary_Page editPeriod(String period) throws InterruptedException {
		selectAPeriod = new Select(selectPeriod);
		selectAPeriod.selectByVisibleText(period);
		return new NarrativeSummary_Page(driver);
	}

	public NarrativeSummary_Page enterReportOptions(String daysPresent, String daysAbsent, String daysTardy) {
		new WebDriverWait(driver, 30)
				.until(ExpectedConditions.and(ExpectedConditions.elementToBeClickable(daysPresentTxtbx),
						ExpectedConditions.elementToBeClickable(daysAbsentTxtbx),
						ExpectedConditions.elementToBeClickable(daysTardyTxtbx)));
		daysPresentTxtbx.clear();
		daysPresentTxtbx.sendKeys(daysPresent);
		daysAbsentTxtbx.clear();
		daysAbsentTxtbx.sendKeys(daysAbsent);
		daysTardyTxtbx.clear();
		daysTardyTxtbx.sendKeys(daysTardy);
		return new NarrativeSummary_Page(driver);
	}

	public NarrativeSummary_Page enterComments(String comment) throws InterruptedException {
		driver.findElement(By.xpath("//div[@id='std0']/div[2]/div[1]/div/ul/li[1]/a")).click();
		domain1Comment.clear();
		domain1Comment.sendKeys(comment);
		Thread.sleep(3000);
		return new NarrativeSummary_Page(driver);
	}

	public NarrativeSummary_Page enterCommentsHSFS(String comment) throws InterruptedException {
		driver.findElement(By.xpath("//ul[@id='myTab0']/li[1]/a")).click();
		teacherCommentHSFS.clear();
		teacherCommentHSFS.sendKeys(comment);
		Thread.sleep(3000);
		return new NarrativeSummary_Page(driver);
	}

	public NarrativeSummary_Page enterCommentsOunce(String comment) throws InterruptedException {
		domain1Comment.clear();
		domain1Comment.sendKeys(comment);
		Thread.sleep(3000);
		return new NarrativeSummary_Page(driver);
	}

	public NarrativeSummary_Page enterSpanishComments(String comment) throws InterruptedException {
		driver.findElement(By.xpath("//div[@id='std0']/div[2]/div[1]/div/ul/li[2]/a")).click();
		spanishDomain1Comment.clear();
		spanishDomain1Comment.sendKeys(comment);
		Thread.sleep(3000);
		return new NarrativeSummary_Page(driver);
	}

	public NarrativeSummary_Page enterSpanishCommentsHSFS(String comment) throws InterruptedException {
		driver.findElement(By.xpath("//ul[@id='myTab0']/li[2]/a")).click();
		teacherSpanishCommentHSFS.clear();
		teacherSpanishCommentHSFS.sendKeys(comment);
		Thread.sleep(3000);
		return new NarrativeSummary_Page(driver);
	}

	public NarrativeSummary_Page enterCommentsForObsRecord(String comment) throws InterruptedException {
		domain1CommentForObsRecord.clear();
		domain1CommentForObsRecord.sendKeys(comment);
		Thread.sleep(3000);
		return new NarrativeSummary_Page(driver);
	}

	public NarrativeSummary_Page clickSave() throws InterruptedException, AWTException {
		if (saveNarrativeSummary.isDisplayed()) {
			new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(saveNarrativeSummary));
			saveNarrativeSummary.click();
			Thread.sleep(5000);
		} else {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_F12);
			robot.keyRelease(KeyEvent.VK_F12);
			new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(saveNarrativeSummary));
			saveNarrativeSummary.click();
			Thread.sleep(5000);
			robot.keyPress(KeyEvent.VK_F12);
			robot.keyRelease(KeyEvent.VK_F12);
			robot.keyPress(KeyEvent.VK_F12);
			robot.keyRelease(KeyEvent.VK_F12);
			Thread.sleep(5000);
		}
		return new NarrativeSummary_Page(driver);
	}

	public ManageSummaryReports_Page clickBack() throws InterruptedException {
		backForNarrativeSummary.click();
		Thread.sleep(5000);
		return new ManageSummaryReports_Page(driver);
	}

	public NarrativeSummary_Page addChecklistComment() throws InterruptedException {
		domain1Comment.clear();
		addComment.click();
		new WebDriverWait(driver, 30)
				.until(ExpectedConditions.and(ExpectedConditions.elementToBeClickable(saveTemplate),
						ExpectedConditions.elementToBeClickable(useTemplate)));
		return new NarrativeSummary_Page(driver);
	}

	public NarrativeSummary_Page addDevProfileComment() throws InterruptedException {
		domain1Comment.clear();
		addCommentOunce.click();
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(addCommentOunceQ1));
		addCommentOunceQ1.click();
		Thread.sleep(5000);
		return new NarrativeSummary_Page(driver);
	}

	public NarrativeSummary_Page addDevProfileCommentForObsRecord() throws InterruptedException {
		domain1CommentForObsRecord.clear();
		addCommentOunce.click();
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(addCommentOunceObsRecordQ1));
		addCommentOunceObsRecordQ1.click();
		Thread.sleep(5000);
		return new NarrativeSummary_Page(driver);
	}

	public NarrativeSummary_Page verifyAddedChecklistComment() throws InterruptedException {
		Assert.assertEquals(domain1Comment.getText(), checklistComment.getText(), "Comments did not match");
		return new NarrativeSummary_Page(driver);
	}

	public NarrativeSummary_Page verifyAddedDevProfileComment() throws InterruptedException {
		String devComment = devProfileComment.getText();
		String[] title = devComment.split("\n");
		String c1 = title[0];
		String c2 = title[1];
		String c3 = title[2];
		String c4 = c1 + "\n" + c2 + "\n" + c3;
		Assert.assertEquals(domain1Comment.getText(), c4, "Comments did not match");
		return new NarrativeSummary_Page(driver);
	}

	public NarrativeSummary_Page verifyAddedDevProfileCommentForObsRecord() throws InterruptedException {
		String devComment = devProfileComment.getText();
		String[] title = devComment.split("\n");
		String c1 = title[0];
		String c2 = title[1];
		String c3 = title[2];
		String c4 = c1 + "\n" + c2 + "\n" + c3;
		Assert.assertEquals(domain1CommentForObsRecord.getText(), c4, "Comments did not match");
		return new NarrativeSummary_Page(driver);
	}

	public NarrativeSummary_Page verifyAutoSaveComments() throws InterruptedException {
		Assert.assertEquals(driver.findElement(By.id("msg_0")).getText(), "(Autosaved)",
				"Comments did not got Autosaved");
		return new NarrativeSummary_Page(driver);
	}

	public NarrativeSummary_Page verifyAutoSaveCommentsObsRecord() throws InterruptedException {
		Assert.assertEquals(driver.findElement(By.id("msg_OA1-0")).getText(), "(Autosaved)",
				"Comments did not got Autosaved");
		return new NarrativeSummary_Page(driver);
	}

	public NarrativeSummary_Page verifyDeleteNarrativeSummary() throws InterruptedException {
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(deleteNarrativeSummary));
		deleteNarrativeSummary.click();
		Thread.sleep(5000);
		OKbtn.click();
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(daysAbsentTxtbx));
		Assert.assertEquals(daysAbsentTxtbx.getText(), "", "Narrative Summary is not deleted");
		return new NarrativeSummary_Page(driver);
	}

	public NarrativeSummary_Page verifyDeleteOunceSummary() throws InterruptedException {
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(deleteNarrativeSummary));
		deleteNarrativeSummary.click();
		Thread.sleep(5000);
		OKbtnOunce.click();
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(domain1Comment));
		Assert.assertEquals(domain1Comment.getText(), "", "Narrative Summary is not deleted");
		return new NarrativeSummary_Page(driver);
	}

	public NarrativeSummary_Page verifyDeleteObservationRecord() throws InterruptedException {
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(deleteNarrativeSummary));
		deleteNarrativeSummary.click();
		Thread.sleep(5000);
		OKbtnOunce.click();
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(domain1CommentForObsRecord));
		Assert.assertEquals(domain1CommentForObsRecord.getText(), "", "Observation Record is not deleted");
		return new NarrativeSummary_Page(driver);
	}

	public NarrativeSummary_Page verifySaveTemplate() throws InterruptedException {
		driver.navigate().refresh();
		BeforeSaveTemplateTxt = domain1Comment.getText();
		saveTemplate.click();
		Thread.sleep(5000);
		try {
			if (OKbtn.isDisplayed()) {
				Thread.sleep(3000);
				OKbtn.click();
				Thread.sleep(3000);
				verifyDeleteNarrativeSummary();
			}
		} catch (Exception e) {
			verifyDeleteNarrativeSummary();
		}
		return new NarrativeSummary_Page(driver);
	}

	public NarrativeSummary_Page verifySaveTemplateOunce() throws InterruptedException {
		driver.navigate().refresh();
		BeforeSaveTemplateTxt = domain1Comment.getText();
		saveTemplate.click();
		Thread.sleep(5000);
		try {
			if (OKbtnOunce.isDisplayed()) {
				Thread.sleep(3000);
				OKbtnOunce.click();
				Thread.sleep(3000);
				verifyDeleteOunceSummary();
			}
		} catch (Exception e) {
			verifyDeleteOunceSummary();
		}
		return new NarrativeSummary_Page(driver);
	}

	public NarrativeSummary_Page verifySaveTemplateObsRecord() throws InterruptedException {
		driver.navigate().refresh();
		BeforeSaveTemplateTxt = domain1CommentForObsRecord.getText();
		saveTemplate.click();
		Thread.sleep(5000);
		if (OKbtnOunce.isDisplayed()) {
			Thread.sleep(3000);
			OKbtnOunce.click();
			Thread.sleep(3000);
			verifyDeleteObservationRecord();
		} else {
			verifyDeleteObservationRecord();
		}
		return new NarrativeSummary_Page(driver);
	}

	public NarrativeSummary_Page verifySaveTemplateHSFS() throws InterruptedException {
		driver.navigate().refresh();
		BeforeSaveTemplateTxt = teacherCommentHSFS.getText();
		saveTemplate.click();
		Thread.sleep(5000);
		try {
			if (OKbtn.isDisplayed()) {
				Thread.sleep(3000);
				OKbtn.click();
				Thread.sleep(3000);
				verifyDeleteNarrativeSummary();
			}
		} catch (Exception e) {
			verifyDeleteNarrativeSummary();
		}
		return new NarrativeSummary_Page(driver);
	}

	public NarrativeSummary_Page clickUseTemplate() throws InterruptedException {
		useTemplate.click();
		Thread.sleep(5000);
		return new NarrativeSummary_Page(driver);
	}

	public NarrativeSummary_Page verifyUseTemplate() throws InterruptedException {
		AfterUseTemplateTxt = domain1Comment.getText();
		Assert.assertEquals(BeforeSaveTemplateTxt, AfterUseTemplateTxt, "Use Template functionality did not worked");
		return new NarrativeSummary_Page(driver);
	}

	public NarrativeSummary_Page verifyUseTemplateObsRecord() throws InterruptedException {
		AfterUseTemplateTxt = domain1CommentForObsRecord.getText();
		Assert.assertEquals(BeforeSaveTemplateTxt, AfterUseTemplateTxt, "Use Template functionality did not worked");
		return new NarrativeSummary_Page(driver);
	}

	public NarrativeSummary_Page verifyUseTemplateHSFS() throws InterruptedException {
		AfterUseTemplateTxt = teacherCommentHSFS.getText();
		Assert.assertEquals(BeforeSaveTemplateTxt, AfterUseTemplateTxt, "Use Template functionality did not worked");
		return new NarrativeSummary_Page(driver);
	}

	public NarrativeSummary_Page verifyCommentCounter() throws InterruptedException {
		Actions action = new Actions(driver);
		WebElement we = domain1Comment;
		action.moveToElement(we).build().perform();
		Assert.assertEquals(true, commentOneCounter.isDisplayed());
		return new NarrativeSummary_Page(driver);
	}

	public NarrativeSummary_Page verifyCommentCounterForObsRecord() throws InterruptedException {
		Actions action = new Actions(driver);
		WebElement we = domain1CommentForObsRecord;
		action.moveToElement(we).build().perform();
		Assert.assertEquals(true, commentOneCounter.isDisplayed());
		return new NarrativeSummary_Page(driver);
	}

	public NarrativeSummary_Page verifyCommentCounterHSFS() throws InterruptedException {
		Actions action = new Actions(driver);
		WebElement we = teacherCommentHSFS;
		action.moveToElement(we).build().perform();
		Assert.assertEquals(true, commentOneCounter.isDisplayed());
		return new NarrativeSummary_Page(driver);
	}

	public NarrativeSummary_Page selectEnglishLanguage() throws InterruptedException {
		englishLanguage.click();
		return new NarrativeSummary_Page(driver);
	}

	public NarrativeSummary_Page verifyEnglishLangIsSelected() throws InterruptedException {
		Assert.assertEquals(true, englishLanguage.isSelected());
		return new NarrativeSummary_Page(driver);
	}

	public NarrativeSummary_Page selectSpanishLanguage() throws InterruptedException {
		spanishLanguage.click();
		return new NarrativeSummary_Page(driver);
	}

	public NarrativeSummary_Page verifySpanishLangIsSelected() throws InterruptedException {
		Assert.assertEquals(true, spanishLanguage.isSelected());
		return new NarrativeSummary_Page(driver);
	}

	public NarrativeSummary_Page selectBothLanguage() throws InterruptedException {
		bothLanguage.click();
		return new NarrativeSummary_Page(driver);
	}

	public NarrativeSummary_Page verifyBothLangIsSelected() throws InterruptedException {
		Assert.assertEquals(true, bothLanguage.isSelected());
		return new NarrativeSummary_Page(driver);
	}

	public NarrativeSummary_Page verifyDownloadNarrativeSummaryEnglishPdf() throws InterruptedException, IOException {
		download.click();
		selectEnglish.click();
		Thread.sleep(5000);
		Assert.assertTrue(isFileDownloaded(downloadPath, "WsoNarrativeSummary"), "Failed to download expected file");
		return new NarrativeSummary_Page(driver);
	}

	public NarrativeSummary_Page verifyDownloadHSSummaryEnglishPdf() throws InterruptedException, IOException {
		download.click();
		selectEnglish.click();
		Thread.sleep(5000);
		Assert.assertTrue(isFileDownloaded(downloadPath, "HSNarrativeFamilyEnglish"),
				"Failed to download expected file");
		return new NarrativeSummary_Page(driver);
	}

	public NarrativeSummary_Page verifyDownloadHSFSEnglishPdf() throws InterruptedException, IOException {
		download.click();
		selectEnglish.click();
		Thread.sleep(5000);
		Assert.assertTrue(isFileDownloaded(downloadPath, "WsoFamilySummary"), "Failed to download expected file");
		return new NarrativeSummary_Page(driver);
	}

	public NarrativeSummary_Page verifyDownloadOunceSummaryEnglishPdf() throws InterruptedException, IOException {
		ounceDownload.click();
		Thread.sleep(5000);
		Assert.assertTrue(isFileDownloaded(downloadPath, "SummaryReport_child-Onelast-One_B1"),
				"Failed to download expected file");
		return new NarrativeSummary_Page(driver);
	}

	public NarrativeSummary_Page verifyDownloadObsRecordEnglishPdf() throws InterruptedException, IOException {
		obsRecordDownload.click();
		Thread.sleep(5000);
		Assert.assertTrue(isFileDownloaded(downloadPath, "ObservationRecord_child-Onelast-One_B1"),
				"Failed to download expected file");
		return new NarrativeSummary_Page(driver);
	}

	public NarrativeSummary_Page verifyDownloadNarrativeSummarySpanishPdf() throws InterruptedException, IOException {
		download.click();
		selectSpanish.click();
		Thread.sleep(5000);
		Assert.assertTrue(isFileDownloaded(downloadPath, "WsoNarrativeSummary_Spanish"),
				"Failed to download expected file");
		return new NarrativeSummary_Page(driver);
	}

	public NarrativeSummary_Page verifyDownloadHSSummarySpanishPdf() throws InterruptedException, IOException {
		download.click();
		selectSpanish.click();
		Thread.sleep(5000);
		Assert.assertTrue(isFileDownloaded(downloadPath, "HSNarrativeFamilySpanish"),
				"Failed to download expected file");
		return new NarrativeSummary_Page(driver);
	}

	public NarrativeSummary_Page verifyDownloadHSFSSpanishPdf() throws InterruptedException, IOException {
		download.click();
		selectSpanish.click();
		Thread.sleep(5000);
		Assert.assertTrue(isFileDownloaded(downloadPath, "WsoFamilySummary_Spanish"),
				"Failed to download expected file");
		return new NarrativeSummary_Page(driver);
	}

	public NarrativeSummary_Page verifyDownloadStandardSummaryEnglishPdf() throws InterruptedException, IOException {
		download.click();
		selectEnglish.click();
		Thread.sleep(5000);
		Assert.assertTrue(isFileDownloaded(downloadPath, "WsoStandardSummary"),
				"Failed to download expected file");
		return new NarrativeSummary_Page(driver);
	}

	public NarrativeSummary_Page verifyDownloadStandardSummarySpanishPdf() throws InterruptedException, IOException {
		download.click();
		selectSpanish.click();
		Thread.sleep(5000);
		Assert.assertTrue(isFileDownloaded(downloadPath, "WsoStandardSummary_Spanish"),
				"Failed to download expected file");
		return new NarrativeSummary_Page(driver);
	}

	public NarrativeSummary_Page verifyDownloadClassSummaryEnglishPdf() throws InterruptedException, IOException {
		download.click();
		selectClass.click();
		Thread.sleep(5000);
		Assert.assertTrue(isFileDownloaded(downloadPath, "MainNarrativeSummaryReport"),
				"Failed to download expected file");
		return new NarrativeSummary_Page(driver);
	}

	public NarrativeSummary_Page verifySelectStudentAlsoAttentionMsg() throws InterruptedException, IOException {
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf((alertMessage)));
		Assert.assertEquals(alertMessage.getText(), "Please select a student also.", "Alert did not appear");
		alertDone.click();
		return new NarrativeSummary_Page(driver);
	}

	public NarrativeSummary_Page selectIncludeSummaryAssessments() throws InterruptedException, IOException {
		if (inclSumAssmnt.isSelected()) {
			Assert.assertTrue(populateChkScore.isDisplayed());
		} else {
			inclSumAssmnt.click();
			Thread.sleep(3000);
			Assert.assertTrue(populateChkScore.isDisplayed());
		}
		return new NarrativeSummary_Page(driver);
	}

	public NarrativeSummary_Page verifyPopulateChecklistButton() throws InterruptedException, IOException {
		Assert.assertTrue(populateChkScore.isEnabled());
		return new NarrativeSummary_Page(driver);
	}

	public NarrativeSummary_Page verifyPopulateChecklistWithPartialScores() throws InterruptedException {
		populateChkScore.click();
		Thread.sleep(5000);
		Assert.assertEquals(alertMessage.getText(),
				"Some recommendations are left empty because those checklist items have no rating in Period 3",
				"Alert did not appear");
		alertDone.click();
		Thread.sleep(3000);
		return new NarrativeSummary_Page(driver);
	}

	public NarrativeSummary_Page verifyPopulateChecklistWithExistingScores() throws InterruptedException {
		populateChkScore.click();
		Thread.sleep(5000);
		Assert.assertEquals(alertMessage.getText(),
				"Recommended checklist score for this period already exists. Do you want to overwrite it?",
				"Alert did not appear");
		OKbtn.click();
		Thread.sleep(3000);
		return new NarrativeSummary_Page(driver);
	}

	public NarrativeSummary_Page verifyPopulateChecklistWithEmptyScores() throws InterruptedException {
		populateChkScore.click();
		Thread.sleep(5000);
		Assert.assertEquals(alertMessage.getText(),
				"In order to populate the checklist scores, the checklist must be finalized.", "Alert did not appear");
		alertDone.click();
		Thread.sleep(3000);
		return new NarrativeSummary_Page(driver);
	}

	public NarrativeSummary_Page verifyPopulateChecklistWithClearedScores() throws InterruptedException {
		populateChkScore.click();
		Thread.sleep(5000);
		Assert.assertEquals(alertMessage.getText(),
				"Recommended checklist score for this period already exists. Do you want to overwrite it?");
		OKbtn.click();
		Thread.sleep(3000);
		return new NarrativeSummary_Page(driver);
	}

	public NarrativeSummary_Page verifyPopulateChecklistWithDeletedScores() throws InterruptedException {
		populateChkScore.click();
		Thread.sleep(5000);
		Assert.assertEquals(alertMessage.getText(),
				"In order to populate the checklist scores, the checklist must be finalized.");
		alertDone.click();
		Thread.sleep(3000);
		return new NarrativeSummary_Page(driver);
	}

	public NarrativeSummary_Page verifyPopulateChecklistWhenInIntermediateState() throws InterruptedException {
		populateChkScore.click();
		Thread.sleep(5000);
		Assert.assertEquals(alertMessage.getText(),
				"In order to populate the checklist scores, the checklist must be finalized.");
		alertDone.click();
		Thread.sleep(3000);
		return new NarrativeSummary_Page(driver);
	}

	public NarrativeSummary_Page unselectIncludeSummaryAssessments() throws InterruptedException {
		if (inclSumAssmnt.isSelected()) {
			inclSumAssmnt.click();
			Thread.sleep(3000);
		}
		return new NarrativeSummary_Page(driver);
	}

	public NarrativeSummary_Page verifySaveButtonDisabled() throws InterruptedException {
		Assert.assertFalse(saveNarrativeSummary.isEnabled());
		return new NarrativeSummary_Page(driver);
	}

	public NarrativeSummary_Page verifyAuthorInfoForObsRecord() throws InterruptedException {
		Assert.assertTrue(authorName.isDisplayed());
		return new NarrativeSummary_Page(driver);
	}

	public NarrativeSummary_Page verifyGuidelinesForObsRecord() throws InterruptedException {
		guidelinesQ1.click();
		Thread.sleep(2000);
		Assert.assertTrue(guidelinesTitle.isDisplayed());
		guidelinesClose.click();
		return new NarrativeSummary_Page(driver);
	}

	public NarrativeSummary_Page verifyAgeLevelDisplayedForOunceSummary() throws InterruptedException {
		Assert.assertEquals(grade.getText(), "Babies I (0 - 4 months)", "Grade is not mentioned");
		return new NarrativeSummary_Page(driver);
	}

	public NarrativeSummary_Page selectDomainChkScore() throws InterruptedException {
		try {
			if (chkScore1.isSelected()) {
				chkScore2.click();
				chkScore3.click();
			} else {
				chkScore1.click();
				chkScore2.click();
				chkScore3.click();
			}
		} catch (Exception e) {

		}
		Thread.sleep(3000);
		return new NarrativeSummary_Page(driver);
	}

	public NarrativeSummary_Page uncheckDomainOne() throws InterruptedException {
		try {
			if (chkBoxDomainOne.isSelected()) {
				chkBoxDomainOne.click();
			}
		} catch (Exception e) {

		}
		return new NarrativeSummary_Page(driver);
	}

	public NarrativeSummary_Page verifyHSFSWithUncheckAnyDomain() throws InterruptedException {
		Assert.assertFalse(chkBoxDomainOne.isSelected());
		return new NarrativeSummary_Page(driver);
	}
}