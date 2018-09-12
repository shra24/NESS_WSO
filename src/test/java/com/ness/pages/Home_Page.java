package com.ness.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ness.base.PageBase;

public class Home_Page extends PageBase {

	@FindBy(id = "appTitle")
	private WebElement pageTitle;

	@FindBy(xpath = "//div[@class='span4 homeItem observations']/div[2]/a[1]")
	private WebElement enterObservation;

	@FindBy(xpath = "//a[@class='btn' and contains(text(),'Manage Observations')]")
	private WebElement manageObservations;

	@FindBy(xpath = "//div[@class='span4 homeItem checklists']/div[2]/a[1]")
	private WebElement newChecklist;

	@FindBy(xpath = "//a[@class='btn' and contains(text(),'Manage Checklist')]")
	private WebElement manageChecklist;

	@FindBy(xpath = "//a[@class='btn' and contains(text(),'Manage Developmental Profiles')]")
	private WebElement manageDevProfile;

	@FindBy(xpath = "//div[@class='span4 homeItem reports']/div[2]/div[1]/a")
	private WebElement newSummaryReport;

	@FindBy(xpath = "//ul[@class='dropdown-menu reportDrop']/li[1]")
	private WebElement narrativesummary;

	@FindBy(xpath = "//ul[@class='dropdown-menu reportDrop']/li[2]")
	private WebElement headStartNarrativeSummary;

	@FindBy(xpath = "//ul[@class='dropdown-menu reportDrop']/li[3]")
	private WebElement headStartFamilySummary;

	@FindBy(xpath = "//ul[@class='dropdown-menu reportDrop']/li[1]")
	private WebElement ounceSummary;

	@FindBy(xpath = "//ul[@class='dropdown-menu reportDrop']/li[2]")
	private WebElement observationRecord;

	@FindBy(xpath = "//a[@class='btn' and contains(text(),'Manage Reports')]")
	private WebElement manageReports;

	@FindBy(xpath = "//ul[@class='dropdown-menu reportDropSummary']/li[1]")
	private WebElement manageSummaryReports;

	@FindBy(xpath = "//ul[@class='dropdown-menu reportDrop']/li[1]/a[contains(text(),'Manage Summary Reports')]")
	private WebElement manageSummaryReportsOunce;

	@FindBy(xpath = "//ul[@class='dropdown-menu reportDropSummary']/li[2]")
	private WebElement generateReports;

	@FindBy(xpath = "//ul[@class='dropdown-menu reportDrop']/li[2]/a[contains(text(),'Generate Reports')]")
	private WebElement generateReportsOunce;

	@FindBy(xpath = "//div[@class='span2 bottomNavItem']/a/strong")
	private WebElement resources;

	@FindBy(xpath = "//div[@class='span2 bottomNavItem']/a[contains(text(), 'Manage Students')]")
	private WebElement manageStudents;

	@FindBy(xpath = "//div[@class='span2 bottomNavItem']/a[contains(text(), 'Manage Children')]")
	private WebElement manageChildren;

	@FindBy(xpath = "//div[@class='span2 bottomNavItem']/a[contains(text(), 'Child Outcome Summary')]")
	private WebElement childOutcomeSummary;

	@FindBy(xpath = "//div[@class='span2 bottomNavItem']/a[contains(text(), 'Journal')]")
	private WebElement journal;

	@FindBy(xpath = "//ul[@class='dropdown-menu pull-right']/li[2]")
	private WebElement logout;

	public Home_Page(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	private void waitForHomePageToLoad() {
		new WebDriverWait(driver, 30).until(ExpectedConditions.and(ExpectedConditions.elementToBeClickable(pageTitle),
				ExpectedConditions.elementToBeClickable(enterObservation),
				ExpectedConditions.elementToBeClickable(manageObservations),
				ExpectedConditions.elementToBeClickable(newChecklist),
				ExpectedConditions.elementToBeClickable(newSummaryReport),
				ExpectedConditions.elementToBeClickable(manageReports),
				ExpectedConditions.elementToBeClickable(resources),
				ExpectedConditions.elementToBeClickable(childOutcomeSummary)));
	}

	public Home_Page clickPageTitle() throws InterruptedException {
		waitForHomePageToLoad();
		pageTitle.click();
		waitForHomePageToLoad();
		return new Home_Page(driver);
	}

	public EnterObservation_Page clickEnterObservation() throws InterruptedException {
		waitForHomePageToLoad();
		enterObservation.click();
		Thread.sleep(5000);
		return new EnterObservation_Page(driver);
	}

	public ManageObservation_Page clickManageObservations() throws InterruptedException {
		waitForHomePageToLoad();
		manageObservations.click();
		Thread.sleep(5000);
		return new ManageObservation_Page(driver);
	}

	public ManageObservation_Page clickOunceManageObservations() throws InterruptedException {
		waitForHomePageToLoad();
		pageTitle.click();
		Thread.sleep(3000);
		manageObservations.click();
		Thread.sleep(5000);
		return new ManageObservation_Page(driver);
	}

	public EnterChecklist_Page clickNewChecklist() throws InterruptedException {
		waitForHomePageToLoad();
		newChecklist.click();
		Thread.sleep(5000);
		return new EnterChecklist_Page(driver);
	}

	public EnterChecklist_Page clickNewChecklistOunce() throws InterruptedException {
		waitForHomePageToLoad();
		pageTitle.click();
		Thread.sleep(3000);
		newChecklist.click();
		Thread.sleep(5000);
		return new EnterChecklist_Page(driver);
	}

	public ManageChecklist_Page clickManageChecklist() throws InterruptedException {
		waitForHomePageToLoad();
		manageChecklist.click();
		Thread.sleep(5000);
		return new ManageChecklist_Page(driver);
	}

	public ManageChecklist_Page clickManageDevProfile() throws InterruptedException {
		waitForHomePageToLoad();
		pageTitle.click();
		Thread.sleep(3000);
		manageDevProfile.click();
		Thread.sleep(5000);
		return new ManageChecklist_Page(driver);
	}

	public NarrativeSummary_Page clickNarrativeSummary() throws InterruptedException {
		waitForHomePageToLoad();
		pageTitle.click();
		Thread.sleep(3000);
		newSummaryReport.click();
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(narrativesummary));
		narrativesummary.click();
		Thread.sleep(5000);
		return new NarrativeSummary_Page(driver);
	}

	public NarrativeSummary_Page clickOunceSummary() throws InterruptedException {
		waitForHomePageToLoad();
		pageTitle.click();
		Thread.sleep(3000);
		newSummaryReport.click();
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(ounceSummary));
		ounceSummary.click();
		Thread.sleep(5000);
		return new NarrativeSummary_Page(driver);
	}

	public NarrativeSummary_Page clickObservationRecord() throws InterruptedException {
		waitForHomePageToLoad();
		pageTitle.click();
		Thread.sleep(3000);
		newSummaryReport.click();
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(observationRecord));
		observationRecord.click();
		Thread.sleep(5000);
		return new NarrativeSummary_Page(driver);
	}

	public NarrativeSummary_Page clickHeadStartNarrativeSummary() throws InterruptedException {
		waitForHomePageToLoad();
		pageTitle.click();
		Thread.sleep(3000);
		newSummaryReport.click();
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(headStartNarrativeSummary));
		headStartNarrativeSummary.click();
		Thread.sleep(5000);
		return new NarrativeSummary_Page(driver);
	}

	public NarrativeSummary_Page clickHeadStartFamilySummary() throws InterruptedException {
		waitForHomePageToLoad();
		pageTitle.click();
		Thread.sleep(3000);
		newSummaryReport.click();
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(headStartFamilySummary));
		headStartFamilySummary.click();
		Thread.sleep(5000);
		return new NarrativeSummary_Page(driver);
	}

	public ManageSummaryReports_Page clickManageSummaryReports() throws InterruptedException {
		waitForHomePageToLoad();
		manageReports.click();
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(manageSummaryReports));
		manageSummaryReports.click();
		Thread.sleep(5000);
		return new ManageSummaryReports_Page(driver);
	}

	public ManageSummaryReports_Page clickManageSummaryReportsOunce() throws InterruptedException {
		waitForHomePageToLoad();
		pageTitle.click();
		Thread.sleep(3000);
		manageReports.click();
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(manageSummaryReportsOunce));
		manageSummaryReportsOunce.click();
		Thread.sleep(5000);
		return new ManageSummaryReports_Page(driver);
	}

	public GenerateReports_Page clickGenerateReports() throws InterruptedException {
		waitForHomePageToLoad();
		manageReports.click();
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(generateReports));
		generateReports.click();
		Thread.sleep(15000);
		return new GenerateReports_Page(driver);
	}

	public GenerateReports_Page clickGenerateReportsOunce() throws InterruptedException {
		waitForHomePageToLoad();
		manageReports.click();
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(generateReportsOunce));
		generateReportsOunce.click();
		Thread.sleep(15000);
		return new GenerateReports_Page(driver);
	}

	public ManageStudents_Page clickManageStudents() throws InterruptedException {
		waitForHomePageToLoad();
		manageStudents.click();
		Thread.sleep(15000);
		return new ManageStudents_Page(driver);
	}

	public ManageStudents_Page clickManageChildren() throws InterruptedException {
		waitForHomePageToLoad();
		manageChildren.click();
		Thread.sleep(15000);
		return new ManageStudents_Page(driver);
	}

	public ChildOutcomeSummary_Page clickChildOutcomeSummary() {
		waitForHomePageToLoad();
		childOutcomeSummary.click();
		return new ChildOutcomeSummary_Page(driver);
	}

	public Resources_Page clickResources() {
		waitForHomePageToLoad();
		resources.click();
		return new Resources_Page(driver);
	}

	public Logout_Page clickLogout() {
		driver.findElement(By.xpath("//img[@class='avatar']")).click();
		logout.click();
		return new Logout_Page(driver);
	}
}