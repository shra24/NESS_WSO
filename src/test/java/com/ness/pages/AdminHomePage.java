package com.ness.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ness.base.PageBase;

public class AdminHomePage extends PageBase {

	@FindBy(id = "appTitle")
	private WebElement pageTitle;

	@FindBy(xpath = "//div[@class='span4 homeItem observations']/div[2]/div/a")
	private WebElement manage;

	@FindBy(id = "newAlert")
	private WebElement newAlert;

	@FindBy(xpath = "//div[@class='dropdown']/a[@class='nav-btn' and contains(text(), 'Status Reports')]")
	private WebElement statusReports;

	@FindBy(xpath = "//div[@class='span4 homeItem observations']/div[2]/a")
	private WebElement viewDashboard;

	@FindBy(id = "manageAlerts")
	private WebElement manageAlerts;

	@FindBy(xpath = "//div[@class='span4 homeItem reports']/div[2]/a")
	private WebElement manageReports;

	@FindBy(id = "btnGoStuMan")
	private WebElement manageStudents;

	@FindBy(id = "btnGoUsrMan")
	private WebElement manageUsers;

	@FindBy(id = "btnGoOrgMan")
	private WebElement manageLocations;

	@FindBy(xpath = "//div[@class='btn-wrap']/a[@class='btn' and contains(text(), 'View Dashboard')]")
	private WebElement dashboard;

	@FindBy(id = "s2id_siteId")
	private WebElement selectASite;

	public AdminHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	private void waitForHomePageToLoad() {
		new WebDriverWait(driver, 30).until(ExpectedConditions.and(ExpectedConditions.elementToBeClickable(pageTitle),
				ExpectedConditions.elementToBeClickable(manage), ExpectedConditions.elementToBeClickable(newAlert),
				ExpectedConditions.elementToBeClickable(statusReports),
				ExpectedConditions.elementToBeClickable(viewDashboard),
				ExpectedConditions.elementToBeClickable(manageAlerts),
				ExpectedConditions.elementToBeClickable(manageReports)));
	}

	public ManageStudents_Page clickManageStudents() throws InterruptedException {
		waitForHomePageToLoad();
		pageTitle.click();
		Thread.sleep(3000);
		manage.click();
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(manageStudents));
		manageStudents.click();
		Thread.sleep(15000);
		return new ManageStudents_Page(driver);
	}

	public Dashboard_Page clickDashboard() throws InterruptedException {
		waitForHomePageToLoad();
		pageTitle.click();
		Thread.sleep(3000);
		dashboard.click();
		Thread.sleep(5000);
		return new Dashboard_Page(driver);
	}

	public AdminHomePage selectSite() throws InterruptedException {
		Thread.sleep(10000);
		selectASite.click();
		driver.findElement(By.xpath("//div[@id='select2-drop']/ul/li[1]/div")).click();
		Thread.sleep(2000);
		return new AdminHomePage(driver);
	}

	public ManageUsers_Page clickManageUsers() throws InterruptedException {
		waitForHomePageToLoad();
		pageTitle.click();
		Thread.sleep(3000);
		manage.click();
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(manageUsers));
		manageUsers.click();
		Thread.sleep(15000);
		return new ManageUsers_Page(driver);
	}

	public ManageLocations_Page clickManageLocations() throws InterruptedException {
		waitForHomePageToLoad();
		pageTitle.click();
		Thread.sleep(3000);
		manage.click();
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(manageLocations));
		manageLocations.click();
		Thread.sleep(15000);
		return new ManageLocations_Page(driver);
	}
}