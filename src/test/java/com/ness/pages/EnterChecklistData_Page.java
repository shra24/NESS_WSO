package com.ness.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.ness.base.PageBase;

public class EnterChecklistData_Page extends PageBase {

	@FindBy(xpath = "//tr[@id='viewTableITEM1RS']/td[6]/label/i")
	private WebElement selectIndicator;

	@FindBy(xpath = "//tr[@id='viewTableITEM1RS_OAB1_OI1_OFA']/td[4]/label/i")
	private WebElement selectOunceIndicator;

	@FindBy(xpath = "//a[@id='backtoEnterBtn']/i")
	private WebElement backForChecklist;

	@FindBy(id = "comments")
	private WebElement enterComments;

	@FindBy(id = "comments0")
	private WebElement enterCommentsOunce;

	@FindBy(id = "msg")
	private WebElement autosaved;

	@FindBy(id = "msg0")
	private WebElement autosavedOunce;

	@FindBy(id = "navPrev")
	private WebElement previousButton;

	@FindBy(id = "navNext")
	private WebElement nextButton;

	@FindBy(id = "WI100")
	private WebElement guidelinesDomain1;

	@FindBy(id = "OI1")
	private WebElement guidelinesDomain1Ounce;

	@FindBy(xpath = "//table[@id='checklistViewTable']/tbody/tr[2]/td[3]/a")
	private WebElement EvidenceLinkedDomain1;

	@FindBy(xpath = "//table[@id='checklistViewTableOunce']/tbody/tr[2]/th[3]/a")
	private WebElement EvidenceLinkedDomain1Ounce;

	@FindBy(xpath = "//div[@id='observationId']/div")
	private WebElement noEvidenceUnlinked;

	@FindBy(xpath = "//div[@id='observationId']/a")
	private WebElement EvidenceUnlinked;

	public EnterChecklistData_Page(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public EnterChecklistData_Page selectIndicators() throws InterruptedException {
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(selectIndicator));
		selectIndicator.click();
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(nextButton));
		return new EnterChecklistData_Page(driver);
	}

	public EnterChecklistData_Page selectOunceIndicators() throws InterruptedException {
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(selectOunceIndicator));
		selectOunceIndicator.click();
		return new EnterChecklistData_Page(driver);
	}

	public EnterChecklist_Page clickBackForChecklist() throws InterruptedException {
		backForChecklist.click();
		Thread.sleep(5000);
		return new EnterChecklist_Page(driver);
	}

	public EnterChecklistData_Page enterComments(String comments) throws InterruptedException {
		enterComments.sendKeys(comments);
		Thread.sleep(2000);
		return new EnterChecklistData_Page(driver);
	}

	public EnterChecklistData_Page enterCommentsOunce(String comments) throws InterruptedException {
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(enterCommentsOunce));
		enterCommentsOunce.sendKeys(comments);
		Thread.sleep(2000);
		return new EnterChecklistData_Page(driver);
	}

	public EnterChecklistData_Page verifyAutosaveComments() {
		Assert.assertEquals(autosaved.getText(), "(Autosaved)", "Comments did not get autosaved");
		return new EnterChecklistData_Page(driver);
	}

	public EnterChecklistData_Page verifyAutosaveCommentsOunce() {
		Assert.assertEquals(autosavedOunce.getText(), "(Autosaved)", "Comments did not get autosaved");
		return new EnterChecklistData_Page(driver);
	}

	public EnterChecklistData_Page verifyPreviousButton() {
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(previousButton));
		if (!previousButton.isEnabled()) {
			System.out.println("Previous button is disabled");
		} else {
			System.out.println("Previous button is enabled");
		}
		return new EnterChecklistData_Page(driver);
	}

	public EnterChecklistData_Page verifyNextButton() throws InterruptedException {
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(nextButton));
		if (nextButton.isEnabled()) {
			System.out.println("Next button is Enabled");
			nextButton.click();
			new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(previousButton));
			if (previousButton.isEnabled()) {
				System.out.println("Previous button is now enabled");
				previousButton.click();
				Thread.sleep(2000);
			}
		} else {
			System.out.println("Next button is disabled");
		}
		return new EnterChecklistData_Page(driver);
	}

	public EnterChecklistData_Page verifyGuidelines() throws InterruptedException {
		guidelinesDomain1.click();
		new WebDriverWait(driver, 30).until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[@id='viewTableITEM1RS']/td[2]/div/h3")));
		String Guideline = driver.findElement(By.xpath("//tr[@id='viewTableITEM1RS']/td[2]/div/h3")).getText();
		String[] title = Guideline.split("\n");
		String t1 = title[0];
		// String t2 = title[1];
		Assert.assertEquals(t1, "Guideline", "Guideline is not verified");
		return new EnterChecklistData_Page(driver);
	}

	public EnterChecklistData_Page verifyGuidelinesOunce() throws InterruptedException {
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(guidelinesDomain1Ounce));
		guidelinesDomain1Ounce.click();
		new WebDriverWait(driver, 30).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//tr[@id='viewTableITEM1RS_OAB1_OI1_OFA']/td[2]/div/h3")));
		String Guideline = driver.findElement(By.xpath("//tr[@id='viewTableITEM1RS_OAB1_OI1_OFA']/td[2]/div/h3"))
				.getText();
		String[] title = Guideline.split("\n");
		String t1 = title[0];
		// String t2 = title[1];
		Assert.assertEquals(t1, "Guideline", "Guideline is not verified");
		return new EnterChecklistData_Page(driver);
	}

	public EnterChecklistData_Page verifyEvidenceLinked() throws InterruptedException {
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(EvidenceLinkedDomain1));
		EvidenceLinkedDomain1.click();
		new WebDriverWait(driver, 30).until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[@id='viewTableITEM1RS']/td[3]/div/h3")));
		String linkedEvidenceTitle = driver.findElement(By.xpath("//tr[@id='viewTableITEM1RS']/td[3]/div/h3"))
				.getText();
		String[] title = linkedEvidenceTitle.split("\n");
		String t1 = title[0];
		// String t2 = title[1];
		Assert.assertEquals(t1, "Evidence Notes", "Linked Evidence is not verified");
		return new EnterChecklistData_Page(driver);
	}

	public EnterChecklistData_Page verifyEvidenceLinkedOunce() throws InterruptedException {
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(EvidenceLinkedDomain1Ounce));
		EvidenceLinkedDomain1Ounce.click();
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//table[@id='checklistViewTableOunce']/tbody/tr[2]/th[3]/div/h3")));
		String linkedEvidenceTitle = driver
				.findElement(By.xpath("//table[@id='checklistViewTableOunce']/tbody/tr[2]/th[3]/div/h3")).getText();
		String[] title = linkedEvidenceTitle.split("\n");
		String t1 = title[0];
		// String t2 = title[1];
		Assert.assertEquals(t1, "Evidence Notes", "Linked Evidence is not verified");
		return new EnterChecklistData_Page(driver);
	}

	public EnterChecklistData_Page verifyEvidenceUnLinked() throws InterruptedException {
		if (noEvidenceUnlinked.isDisplayed()) {
			System.out.println(noEvidenceUnlinked.getText());
		} else if (EvidenceUnlinked.isDisplayed()) {
			System.out.println(EvidenceUnlinked.getText());
		}
		return new EnterChecklistData_Page(driver);
	}
}