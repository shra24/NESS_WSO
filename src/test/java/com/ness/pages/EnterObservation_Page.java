package com.ness.pages;

import java.io.IOException;
import java.util.NoSuchElementException;

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

public class EnterObservation_Page extends PageBase {
	
	Select selectPeriod;
	static String autoSaved;
	static String currentPeriod;
	String defaultPeriod;

	@FindBy(id = "period")
	private WebElement choosePeriod;

	@FindBy(id = "saveBtnId")
	private WebElement save;

	@FindBy(xpath = "//div[@class='actionBar']/input[2]")
	private WebElement cancel;

	@FindBy(id = "deleteObsBtn")
	private WebElement deleteObservation;

	@FindBy(id = "downloadObsBtn")
	private WebElement downloadObservation;

	@FindBy(id = "linkToPFIndicators")
	private WebElement linkPerformanceIndicators;

	@FindBy(id = "domain0")
	private WebElement domain1;

	@FindBy(id = "domain1")
	private WebElement domain2;

	@FindBy(id = "domain2")
	private WebElement domain3;

	@FindBy(id = "domain3")
	private WebElement domain4;

	@FindBy(id = "domain4")
	private WebElement domain5;

	@FindBy(id = "domain5")
	private WebElement domain6;

	@FindBy(id = "domain6")
	private WebElement domain7;

	@FindBy(id = "domain7")
	private WebElement domain8;

	@FindBy(id = "domain8")
	private WebElement domain9;

	@FindBy(id = "domain9")
	private WebElement domain10;

	@FindBy(id = "domain10")
	private WebElement domain11;

	@FindBy(id = "WI100")
	private WebElement domain1Indicator1;

	@FindBy(id = "WI112")
	private WebElement domain2Indicator1;

	@FindBy(id = "WI124")
	private WebElement domain3Indicator1;

	@FindBy(id = "WI136")
	private WebElement domain4Indicator1;

	@FindBy(id = "WI148")
	private WebElement domain5Indicator1;

	@FindBy(id = "WI158")
	private WebElement domain6Indicator1;

	@FindBy(id = "WI162")
	private WebElement domain7Indicator1;

	@FindBy(id = "FI72")
	private WebElement hSdomain1Indicator1;

	@FindBy(id = "FI79")
	private WebElement hSdomain2Indicator1;

	@FindBy(id = "FI88")
	private WebElement hSdomain3Indicator1;

	@FindBy(id = "FI93")
	private WebElement hSdomain4Indicator1;

	@FindBy(id = "FI95")
	private WebElement hSdomain5Indicator1;

	@FindBy(id = "FI100")
	private WebElement hSdomain6Indicator1;

	@FindBy(id = "FI107")
	private WebElement hSdomain7Indicator1;

	@FindBy(id = "FI120")
	private WebElement hSdomain8Indicator1;

	@FindBy(id = "FI132")
	private WebElement hSdomain9Indicator1;

	@FindBy(id = "FI137")
	private WebElement hSdomain10Indicator1;

	@FindBy(id = "FI145")
	private WebElement hSdomain11Indicator1;

	@FindBy(id = "finishLink")
	private WebElement nextButton;

	@FindBy(id = "classDone")
	private WebElement doneButton;

	@FindBy(id = "msg")
	private WebElement autosaved;

	@FindBy(id = "editSL")
	private WebElement editStudent;

	@FindBy(id = "alertDoneBtn")
	private WebElement alertDone;

	@FindBy(id = "showAlertBoxbtn")
	private WebElement alertOK;

	@FindBy(css = "div[class='modal-body']>p")
	private WebElement alertMessage;

	@FindBy(css = "div.title>h1>a>i")
	private WebElement greenEyedBackIcon;

	@FindBy(xpath = "//ul[@id='slw']/li[2]/label[2]/i")
	private WebElement selectFirstStudent;

	@FindBy(xpath = "//ul[@id='slw']/li[3]/label[2]/i")
	private WebElement selectSecondStudent;

	@FindBy(id = "OA1")
	private WebElement AOD1;

	@FindBy(id = "OA2")
	private WebElement AOD2;

	@FindBy(id = "OA3")
	private WebElement AOD3;

	@FindBy(id = "OA4")
	private WebElement AOD4;

	@FindBy(id = "OA5")
	private WebElement AOD5;

	@FindBy(id = "OA6")
	private WebElement AOD6;

	@FindBy(xpath = "//span[@class='maxlength-feedback']")
	private WebElement descriptionCounter;

	@FindBy(xpath = "//button[@class='btn btn-inverse dropdown-toggle']")
	private WebElement navWidget;

	@FindBy(xpath = "//li[@id='checkNode2']/a")
	private WebElement navWidgetEvidence;

	@FindBy(id = "selectAll")
	private WebElement selectAll;

	@FindBy(xpath = "//div[@id='item0']/span[2]/a")
	private WebElement downloadAttachment;

	public EnterObservation_Page(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public EnterObservation_Page selectStudent() throws InterruptedException {
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf((selectFirstStudent)));
		Actions actions = new Actions(driver);
		actions.moveToElement(selectFirstStudent).click().perform();
		return new EnterObservation_Page(driver);
	}

	public EnterObservation_Page selectAllStudents() throws InterruptedException {
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf((selectAll)));
		Actions actions = new Actions(driver);
		actions.moveToElement(selectAll).click().perform();
		return new EnterObservation_Page(driver);
	}

	public EnterObservation_Page selectPeriod(String period) {
		selectPeriod = new Select(choosePeriod);
		selectPeriod.selectByVisibleText(period);
		return new EnterObservation_Page(driver);
	}

	public ManageObservation_Page clickDeleteObservation() throws InterruptedException {
		deleteObservation.click();
		Thread.sleep(5000);
		for (String popupWindow : driver.getWindowHandles()) {
			driver.switchTo().window(popupWindow);
			driver.findElement(By.xpath("//div[@class='modal-footer']/button[1]")).click();
		}
		Thread.sleep(5000);
		return new ManageObservation_Page(driver);
	}

	public EnterObservation_Page clickLinkToPerformanceIndicators() throws InterruptedException {
		linkPerformanceIndicators.click();
		// new WebDriverWait(driver,
		// 30).until(ExpectedConditions.visibilityOf((domain1)));
		return new EnterObservation_Page(driver);
	}

	public EnterObservation_Page clickLinkToPerformanceIndicatorsOunce() throws InterruptedException {
		linkPerformanceIndicators.click();
		// new WebDriverWait(driver,
		// 30).until(ExpectedConditions.visibilityOf((AOD1)));
		return new EnterObservation_Page(driver);
	}

	public EnterObservation_Page chooseIndicators() {
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf((domain1)));
		domain1.click();
		domain1Indicator1.click();
		domain2.click();
		domain2Indicator1.click();
		domain3.click();
		domain3Indicator1.click();
		domain4.click();
		domain4Indicator1.click();
		domain5.click();
		domain5Indicator1.click();
		domain6.click();
		domain6Indicator1.click();
		domain7.click();
		domain7Indicator1.click();
		return new EnterObservation_Page(driver);
	}

	public EnterObservation_Page chooseHsIndicators() {
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf((domain1)));
		domain1.click();
		hSdomain1Indicator1.click();
		domain2.click();
		hSdomain2Indicator1.click();
		domain3.click();
		hSdomain3Indicator1.click();
		domain4.click();
		hSdomain4Indicator1.click();
		domain5.click();
		hSdomain5Indicator1.click();
		domain6.click();
		hSdomain6Indicator1.click();
		domain7.click();
		hSdomain7Indicator1.click();
		domain8.click();
		hSdomain8Indicator1.click();
		domain9.click();
		hSdomain9Indicator1.click();
		domain10.click();
		hSdomain10Indicator1.click();
		domain11.click();
		hSdomain11Indicator1.click();
		return new EnterObservation_Page(driver);
	}

	public EnterObservation_Page chooseOunceIndicators() {
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf((AOD1)));
		AOD1.click();
		AOD2.click();
		AOD3.click();
		AOD4.click();
		AOD5.click();
		AOD6.click();
		return new EnterObservation_Page(driver);
	}

	public EnterObservation_Page saveIndicators() throws InterruptedException {
		nextButton.click();
		doneButton.click();
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf((save)));
		return new EnterObservation_Page(driver);
	}

	public EnterObservation_Page enterTitleDescription(String title, String description) throws InterruptedException {
		driver.findElement(By.id("title")).clear();
		driver.findElement(By.id("title")).sendKeys(title);
		driver.findElement(By.id("description")).clear();
		driver.findElement(By.id("description")).sendKeys(description);
		Thread.sleep(2000);
		return new EnterObservation_Page(driver);
	}

	public ManageObservation_Page clickSave() throws InterruptedException {
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(save));
		save.click();
		Thread.sleep(5000);
		return new ManageObservation_Page(driver);
	}

	public EnterObservation_Page verifyAutoSave() throws InterruptedException {
		autoSaved = autosaved.getText();
		Assert.assertEquals(autoSaved, "(Autosaved)", "Comments did not get autosaved");
		return new EnterObservation_Page(driver);
	}

	public EnterObservation_Page editStudent() throws InterruptedException {
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf((editStudent)));
		editStudent.click();
		Actions actions = new Actions(driver);
		Thread.sleep(5000);
		actions.moveToElement(selectFirstStudent).click().perform();
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf((selectSecondStudent)));
		actions.moveToElement(selectSecondStudent).click().perform();
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf((linkPerformanceIndicators)));
		return new EnterObservation_Page(driver);
	}

	public EnterObservation_Page removeStudent() throws InterruptedException {
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf((editStudent)));
		editStudent.click();
		Actions actions = new Actions(driver);
		Thread.sleep(5000);
		actions.moveToElement(selectFirstStudent).click().perform();
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf((linkPerformanceIndicators)));
		return new EnterObservation_Page(driver);
	}

	public EnterObservation_Page verifyDownloadObservation() {
		Assert.assertEquals(true, downloadObservation.isDisplayed());
		return new EnterObservation_Page(driver);
	}

	public boolean isDeleteButtonPresent() {
		try {
			deleteObservation.isDisplayed();
			return false;
		} catch (NoSuchElementException e) {
			return true;
		}
	}

	public EnterObservation_Page verifySaveWithoutTitleAlert() {
		Assert.assertEquals(alertMessage.getText(), "Please enter a valid title.",
				"Incorrect message is displayed on save without title alert");
		alertDone.click();
		return new EnterObservation_Page(driver);
	}

	public EnterObservation_Page verifySaveButtonDisabled() {
		try {
			if (!save.isEnabled()) {
				System.out.println("Save button is Disabled");
			}
		} catch (Exception e) {
			System.out.println("Save button is Enabled. Exception occurred: " + e.getMessage());
		}

		return new EnterObservation_Page(driver);
	}

	public ManageObservation_Page backToManageObservationPage() throws InterruptedException {
		greenEyedBackIcon.click();
		Thread.sleep(5000);
		return new ManageObservation_Page(driver);
	}

	public EnterObservation_Page checkCurrentPeriod() throws InterruptedException {
		currentPeriod = choosePeriod.getText();
		return new EnterObservation_Page(driver);
	}

	public EnterObservation_Page verifyDefaultPeriod() throws InterruptedException {
		defaultPeriod = choosePeriod.getText();
		Assert.assertEquals(defaultPeriod, currentPeriod, "Default period is incorrect");
		return new EnterObservation_Page(driver);
	}

	public EnterObservation_Page verifyDescriptionCounter() throws InterruptedException {
		Assert.assertEquals(true, descriptionCounter.isDisplayed());
		return new EnterObservation_Page(driver);
	}

	public EnterObservation_Page addAttachment() throws InterruptedException {
		uploadingFileWithSendKeys("Arsenal.jpg");
		Thread.sleep(2000);
		return new EnterObservation_Page(driver);
	}

	public EnterObservation_Page addMultipleAttachments() throws InterruptedException {
		uploadingFileWithSendKeys("Arsenal.jpg");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='item1']/input")).sendKeys(
				"D:\\Perforce_Workspace\\CLINICAL_AUTOMATION\\pem_rd\\portal\\development\\code\\clinical_redesign\\"
						+ "ClinicalTestingFramework\\src\\main\\java\\com\\ness\\attachments\\DC Comics Universe.jpg");
		Thread.sleep(2000);
		return new EnterObservation_Page(driver);
	}

	public EnterObservation_Page clickDescriptionTextBox() throws InterruptedException {
		driver.findElement(By.id("description")).click();
		return new EnterObservation_Page(driver);
	}

	public EnterObservation_Page verifySelectStudentAlert() throws InterruptedException {
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf((alertMessage)));
		Assert.assertEquals(alertMessage.getText(), "Please select at least one student.", "Alert did not appear");
		alertOK.click();
		return new EnterObservation_Page(driver);
	}

	public EnterObservation_Page verifySelectChildAlert() throws InterruptedException {
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf((alertMessage)));
		Assert.assertEquals(alertMessage.getText(), "Please select at least one child.", "Alert did not appear");
		alertOK.click();
		return new EnterObservation_Page(driver);
	}

	public EnterObservation_Page verifyTitleFirstAlert() throws InterruptedException {
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf((alertMessage)));
		Assert.assertEquals(alertMessage.getText(), "Please enter a valid title or an attachment.",
				"Alert did not appear");
		alertOK.click();
		return new EnterObservation_Page(driver);
	}

	public EnterObservation_Page verifySelectStudentFirstAlert() throws InterruptedException {
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf((alertMessage)));
		Assert.assertEquals(alertMessage.getText(), "Please select at least one student first.",
				"Alert did not appear");
		alertDone.click();
		return new EnterObservation_Page(driver);
	}

	public EnterObservation_Page verifySelectChildFirstAlert() throws InterruptedException {
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf((alertMessage)));
		Assert.assertEquals(alertMessage.getText(), "Please select at least one child first.", "Alert did not appear");
		alertDone.click();
		return new EnterObservation_Page(driver);
	}

	public EnterObservation_Page deleteAttachment() throws InterruptedException {
		driver.findElement(By.id("itemPreview0")).click();
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.id("modalDelete")));
		driver.findElement(By.id("modalDelete")).click();
		driver.findElement(By.xpath("//div[@id='previewModal']/div[1]/button")).click();
		Thread.sleep(2000);
		return new EnterObservation_Page(driver);
	}

	public ManageObservation_Page clickCancel() throws InterruptedException {
		cancel.click();
		Thread.sleep(2000);
		return new ManageObservation_Page(driver);
	}

	public EnterObservation_Page verifyObservationPdf() throws InterruptedException, IOException {
		downloadObservation.click();
		Thread.sleep(5000);
		Assert.assertTrue(isFileDownloaded(downloadPath, "Observation_last-Onestudent-One_2017-2018.pdf"),
				"Failed to download expected file");
		Assert.assertTrue(
				verifyPDFContent("C:\\Users\\P7111024.PIDC\\Downloads\\Observation_last-Onestudent-One_2017-2018.pdf",
						"Observation Report"));
		return new EnterObservation_Page(driver);
	}

	public EnterObservation_Page verifyObservationPdfOunce() throws InterruptedException, IOException {
		downloadObservation.click();
		Thread.sleep(5000);
		Assert.assertTrue(isFileDownloaded(downloadPath, "Observation_last-Onechild-One.pdf"),
				"Failed to download expected file");
		Assert.assertTrue(verifyPDFContent("C:\\Users\\P7111024.PIDC\\Downloads\\Observation_last-Onechild-One.pdf",
				"Observation Report"));
		return new EnterObservation_Page(driver);
	}

	public EnterObservation_Page verifyDownloadAttachment() throws InterruptedException, IOException {
		downloadAttachment.click();
		Thread.sleep(5000);
		Assert.assertTrue(isFileDownloaded(downloadPath, "Arsenal.jpg"), "Failed to download expected file");
		return new EnterObservation_Page(driver);
	}
}