package com.ness.pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.ness.base.PageBase;

public class ManageObservation_Page extends PageBase {
	
	Select selectFilter;
	Select selectDropdown;
	static int rowsBeforeDeletion;
	int rowsAfterDeletion;
	String actualStudent;
	String editStudent;
	String filteredValue;
	static String currentPeriod;
	String editedPeriod;
	static String currentTitle;
	String editedTitle;
	static String currentDescription;
	String editedDescription;

	@FindBy(xpath = "//a[@class='btn btn-primary' and contains (text(), 'Summary Chart')]")
	private WebElement summaryChart;

	@FindBy(css = "button#alertDoneBtn")
	private WebElement attentionPopup;

	@FindBy(id = "enterObs")
	private WebElement enterEvidence;

	@FindBy(id = "obsTitle0")
	private WebElement evidenceTitle;

	@FindBy(css = ".dataTables_empty")
	private WebElement emptyObservationTable;

	@FindBy(css = "#observationsTable tbody tr")
	private WebElement observationTable;

	@FindBy(css = "ul[id=studentList0]>li")
	private WebElement nameOfStudent;

	@FindBy(css = "tbody>tr>td>a[id='stud0']")
	private WebElement noOfStudents;

	@FindBy(css = "span[class='close']")
	private WebElement closeNoOfStudentsPopup;

	@FindBy(id = "filterDrop")
	private WebElement filterDrop;

	@FindBy(id = "nextDrop")
	private WebElement nextDrop;

	@FindBy(xpath = "//select[@id='nextDrop']/option[1]")
	private WebElement defaultFilterOption;

	@FindBy(xpath = "//select[@name='observationsTable_length']")
	private WebElement tablePagination;

	@FindBy(id = "observationsTable_wrapper")
	private WebElement observationsTable;

	@FindBy(id = "attach0")
	private WebElement attachments;

	@FindBy(xpath = "//ul[@id='attachmentList0']/li/p")
	private WebElement attachmentName;

	@FindBy(xpath = "//table[@id='observationsTable']/tbody/tr[1]/td[3]")
	private WebElement descriptionText;

	@FindBy(id = "appTitle")
	private WebElement pageTitle;

	public ManageObservation_Page(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void waitForManageObservationPageToLoad() {
		new WebDriverWait(driver, 30).until(ExpectedConditions.and(ExpectedConditions.elementToBeClickable(filterDrop),
				ExpectedConditions.visibilityOf(tablePagination),
				ExpectedConditions.visibilityOf((observationsTable))));
	}

	public Home_Page clickPageTitle() throws InterruptedException {
		pageTitle.click();
		Thread.sleep(2000);
		return new Home_Page(driver);
	}

	public SummaryChart_Page summaryChart() {
		waitForManageObservationPageToLoad();
		summaryChart.click();
		return new SummaryChart_Page(driver);
	}

	public EnterObservation_Page enterEvidence() {
		waitForManageObservationPageToLoad();
		enterEvidence.click();
		return new EnterObservation_Page(driver);
	}

	public ManageObservation_Page selectFilter(String filter) {
		waitForManageObservationPageToLoad();
		selectFilter = new Select(filterDrop);
		selectFilter.selectByVisibleText(filter);
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(nextDrop));
		return new ManageObservation_Page(driver);
	}

	public ManageObservation_Page selectNextDrop() throws InterruptedException {
		nextDrop.click();
		driver.findElement(By.xpath("//select[@id='nextDrop']/option[2]")).click();
		Thread.sleep(3000);
		if (isElementPresent(attentionPopup)) {
			Thread.sleep(3000);
			attentionPopup.click();
			Thread.sleep(3000);
			System.out.println("Selected option does not have any observations");
			nextDrop.click();
			driver.findElement(By.xpath("//select[@id='nextDrop']/option[3]")).click();
			Thread.sleep(3000);
		}
		filteredValue = driver.findElement(By.xpath("//select[@id='nextDrop']/option[2]")).getText();
		return new ManageObservation_Page(driver);
	}

	public EnterObservation_Page clickObservation() throws InterruptedException {
		List<WebElement> rows = driver.findElements(By.cssSelector("#observationsTable tbody tr"));
		rowsBeforeDeletion = rows.size();
		currentPeriod = driver.findElement(By.xpath("//table[@id='observationsTable']/tbody/tr/td[7]")).getText();
		currentTitle = driver.findElement(By.xpath("//table[@id='observationsTable']/tbody/tr/td[2]")).getText();
		currentDescription = driver.findElement(By.xpath("//table[@id='observationsTable']/tbody/tr/td[3]")).getText();
		evidenceTitle.click();
		Thread.sleep(10000);
		return new EnterObservation_Page(driver);
	}

	public EnterObservation_Page clickObservationOunce() throws InterruptedException {
		List<WebElement> rows = driver.findElements(By.cssSelector("#observationsTable tbody tr"));
		rowsBeforeDeletion = rows.size();
		currentTitle = driver.findElement(By.xpath("//table[@id='observationsTable']/tbody/tr/td[2]")).getText();
		currentDescription = driver.findElement(By.xpath("//table[@id='observationsTable']/tbody/tr/td[3]")).getText();
		evidenceTitle.click();
		Thread.sleep(10000);
		return new EnterObservation_Page(driver);
	}

	public EnterObservation_Page clickEnterEvidence() throws InterruptedException {
		Thread.sleep(3000);
		if (isElementPresent(attentionPopup)) {
			Thread.sleep(3000);
			attentionPopup.click();
			Thread.sleep(3000);
			enterEvidence.click();
			Thread.sleep(3000);
		} else {
			waitForManageObservationPageToLoad();
			enterEvidence.click();
			Thread.sleep(3000);
		}
		return new EnterObservation_Page(driver);
	}

	public ManageObservation_Page verifyObservationIsDeleted() throws InterruptedException {
		Thread.sleep(3000);
		if (isElementPresent(attentionPopup)) {
			Thread.sleep(3000);
			attentionPopup.click();
			Thread.sleep(3000);
			Assert.assertEquals(emptyObservationTable.getText(), "No data available in table",
					"Observation is not deleted");
		} else {
			List<WebElement> rows = driver.findElements(By.cssSelector("#observationsTable tbody tr"));
			rowsAfterDeletion = rows.size();
			if (rowsBeforeDeletion == (rowsAfterDeletion + 1)) {
				System.out.println("Observation is deleted");
			} else {
				System.out.println("Observation is not deleted");
			}
		}
		return new ManageObservation_Page(driver);
	}

	protected boolean isElementPresent(WebElement attentionPopup) {
		try {
			attentionPopup.getText();
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public ManageObservation_Page verifyEvidenceIsCreated() {
		String title = evidenceTitle.getText();
		if (title.isEmpty())
			System.out.println("Evidence is not created");
		else
			System.out.println(title + " is successfully created");
		return new ManageObservation_Page(driver);
	}

	public ManageObservation_Page verifyActualStudent() throws InterruptedException {
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf((noOfStudents)));
		noOfStudents.click();
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf((nameOfStudent)));
		actualStudent = nameOfStudent.getText();
		closeNoOfStudentsPopup.click();
		return new ManageObservation_Page(driver);
	}

	public ManageObservation_Page verifyEditedStudent() throws InterruptedException {
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf((noOfStudents)));
		noOfStudents.click();
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf((nameOfStudent)));
		editStudent = nameOfStudent.getText();
		assertNotEquals(actualStudent, editStudent, "Student has not been edited");
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable((closeNoOfStudentsPopup)));
		closeNoOfStudentsPopup.click();
		return new ManageObservation_Page(driver);
	}

	public ManageObservation_Page verifyfilteredStudent() throws InterruptedException {
		if (isElementPresent(attentionPopup)) {
			Thread.sleep(3000);
			String obsAttentionMessage = driver.findElement(By.cssSelector("div[class='modal-body']>p")).getText();
			attentionPopup.click();
			System.out.println(obsAttentionMessage);
			Thread.sleep(3000);
		} else {
			verifyActualStudent();
			assertEquals(actualStudent, filteredValue, "Filter failed");
		}
		return new ManageObservation_Page(driver);
	}

	public ManageObservation_Page verifyfilteredPeriod() throws InterruptedException {
		if (isElementPresent(attentionPopup)) {
			Thread.sleep(3000);
			String obsAttentionMessage = driver.findElement(By.cssSelector("div[class='modal-body']>p")).getText();
			attentionPopup.click();
			System.out.println(obsAttentionMessage);
			Thread.sleep(3000);
		} else {
			String periodValue = driver.findElement(By.xpath("//table[@id='observationsTable']/tbody/tr[1]/td[7]"))
					.getText();
			assertEquals(periodValue, filteredValue, "Filter failed");
		}
		return new ManageObservation_Page(driver);
	}

	public ManageObservation_Page verifyFilterIsRetained() throws InterruptedException {
		Thread.sleep(3000);
		if (isElementPresent(attentionPopup)) {
			Thread.sleep(3000);
			attentionPopup.click();
			Thread.sleep(3000);
			Assert.assertEquals(true, filterDrop.isDisplayed());
			Assert.assertEquals(true, nextDrop.isDisplayed());
		} else {
			Assert.assertEquals(true, filterDrop.isDisplayed());
			Assert.assertEquals(true, nextDrop.isDisplayed());
		}
		return new ManageObservation_Page(driver);
	}

	public ManageObservation_Page verifyFilterIsNotRetained() throws InterruptedException {
		Thread.sleep(3000);
		if (isElementPresent(attentionPopup)) {
			Thread.sleep(3000);
			attentionPopup.click();
			Thread.sleep(3000);
			Assert.assertEquals(true, filterDrop.isDisplayed());
			Assert.assertNotEquals(true, nextDrop.isDisplayed());
		} else {
			Assert.assertEquals(true, filterDrop.isDisplayed());
			Assert.assertNotEquals(true, nextDrop.isDisplayed());
		}
		return new ManageObservation_Page(driver);
	}

	public ManageObservation_Page verifyEditedPeriod() throws InterruptedException {
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf((noOfStudents)));
		editedPeriod = driver.findElement(By.xpath("//table[@id='observationsTable']/tbody/tr/td[7]")).getText();
		assertNotEquals(currentPeriod, editedPeriod, "Period has not been edited");
		return new ManageObservation_Page(driver);
	}

	public ManageObservation_Page verifyEditedTitleDescription() throws InterruptedException {
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf((noOfStudents)));
		editedTitle = driver.findElement(By.xpath("//table[@id='observationsTable']/tbody/tr/td[2]")).getText();
		editedDescription = driver.findElement(By.xpath("//table[@id='observationsTable']/tbody/tr/td[3]")).getText();
		assertNotEquals(currentTitle, editedTitle, "Title has not been edited");
		assertNotEquals(currentDescription, editedDescription, "Description has not been edited");
		return new ManageObservation_Page(driver);
	}

	public ManageObservation_Page verifyAddedAttachment() throws InterruptedException {
		attachments.click();
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf((attachmentName)));
		assertEquals(attachmentName.getText(), "Arsenal.jpg", "Attachment not added");
		return new ManageObservation_Page(driver);
	}

	public ManageObservation_Page verifyMultipledAttachmentsAdded() throws InterruptedException {
		assertEquals(attachments.getText(), "2", "Multiple attachments not added");
		return new ManageObservation_Page(driver);
	}

	public ManageObservation_Page verifyAttachmentNameAsTitle() throws InterruptedException {
		String eviTitle = evidenceTitle.getText();
		attachments.click();
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf((attachmentName)));
		String attachmentTitle = attachmentName.getText();
		assertEquals(eviTitle, attachmentTitle, "Title don't match");
		return new ManageObservation_Page(driver);
	}

	public ManageObservation_Page verifyNoDescriptionAddedText() throws InterruptedException {
		assertEquals(descriptionText.getText(), "No Descriptive text", "No description added text incorrect");
		return new ManageObservation_Page(driver);
	}

	public ManageObservation_Page verifyDeleteAttachment() throws InterruptedException {
		assertEquals(attachments.getText(), "1", "Attachment not deleted");
		return new ManageObservation_Page(driver);
	}

	public ManageObservation_Page verifyDefaultFilter() throws InterruptedException {
		assertEquals(defaultFilterOption.getText(), "Select All", "Default filter is incorrect");
		return new ManageObservation_Page(driver);
	}

	public EnterObservation_Page verifyDownloadAttachmentOnEvidencePage() throws InterruptedException, IOException {
		attachments.click();
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf((attachmentName)));
		attachmentName.click();
		Thread.sleep(5000);
		Assert.assertTrue(isFileDownloaded(downloadPath, "Arsenal.jpg"), "Failed to download expected file");
		return new EnterObservation_Page(driver);
	}
}
