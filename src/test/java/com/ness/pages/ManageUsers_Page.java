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

public class ManageUsers_Page extends PageBase {

	@FindBy(id = "addActions")
	private WebElement addButton;

	@FindBy(id = "addUser")
	private WebElement addNewUser;

	@FindBy(id = "existingUser")
	private WebElement addExistingUser;

	@FindBy(id = "userLocation")
	private WebElement manageLocation;

	@FindBy(id = "userAssignments")
	private WebElement userAssignments;

	@FindBy(id = "transferUser")
	private WebElement transferUser;

	@FindBy(id = "transferBtnId")
	private WebElement transferBtn;

	@FindBy(id = "userOpts")
	private WebElement userActions;

	@FindBy(id = "optLock")
	private WebElement lockUser;

	@FindBy(id = "optUnlock")
	private WebElement unlockUser;

	@FindBy(id = "optPassReset")
	private WebElement resetPassword;

	@FindBy(id = "optInvalidAttempts")
	private WebElement resetAttempts;

	@FindBy(id = "optRemove")
	private WebElement removeUser;

	@FindBy(id = "primary")
	private WebElement primaryContact;

	@FindBy(id = "exportOptions")
	private WebElement exportOptions;

	@FindBy(id = "exportExcel")
	private WebElement exportExcel;

	@FindBy(id = "exportCsv")
	private WebElement exportCsv;

	@FindBy(xpath = "//tbody[@id='userRecs']/tr/td[6]")
	private WebElement userType;

	@FindBy(xpath = "//tbody[@id='userRecs']/tr/td[7]")
	private WebElement assignedRole;

	@FindBy(id = "userName")
	private WebElement userName;

	@FindBy(id = "firstName")
	private WebElement firstName;

	@FindBy(id = "lastName")
	private WebElement lastName;

	@FindBy(id = "emailID")
	private WebElement emailID;

	@FindBy(id = "uTypeTeacher")
	private WebElement uTypeTeacher;

	@FindBy(id = "uTypeAdmin")
	private WebElement uTypeAdmin;

	@FindBy(id = "role")
	private WebElement userRole;

	@FindBy(id = "savebtn")
	private WebElement savebtn;

	@FindBy(xpath = "//tbody[@id='userRecs']/tr[1]/td[1]/label/i")
	private WebElement selectUserOne;

	@FindBy(xpath = "//tbody[@id='userRecs']/tr[2]/td[1]/label/i")
	private WebElement selectUserTwo;

	@FindBy(xpath = "//tbody[@id='userRecs']/tr[4]/td[1]/label/i")
	private WebElement selectUserFour;

	@FindBy(xpath = "//tbody[@id='userRecs']/tr[1]/td[2]/a")
	private WebElement userOne;

	@FindBy(xpath = "//table[@id='orgsAtLvl']/tbody/tr/td/input")
	private WebElement selectUserAssignLocation;

	@FindBy(xpath = "//div[@class='modal-footer']/button[1]")
	private WebElement addUserAssignLocation;

	@FindBy(id = "s2id_toProgId")
	private WebElement selectProgram;

	@FindBy(id = "s2id_toSiteId")
	private WebElement selectSite;

	@FindBy(id = "s2id_siteId")
	private WebElement selectSiteOnManageUsersPage;

	@FindBy(id = "deleteConfirmButtonId")
	private WebElement okButton;

	@FindBy(id = "btnProxy")
	private WebElement proxyButton;

	@FindBy(id = "selectAll")
	private WebElement selectAll;

	public ManageUsers_Page(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public ManageUsers_Page clickNewUser() throws InterruptedException {
		addButton.click();
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(addNewUser));
		addNewUser.click();
		return new ManageUsers_Page(driver);
	}

	public ManageUsers_Page enterUserName(String username) throws InterruptedException {
		Thread.sleep(5000);
		userName.sendKeys(username);
		return new ManageUsers_Page(driver);
	}

	public ManageUsers_Page enterName(String firstname, String lastname) throws InterruptedException {
		firstName.sendKeys(firstname);
		lastName.sendKeys(lastname);
		return new ManageUsers_Page(driver);
	}

	public ManageUsers_Page enterEmail(String email) throws InterruptedException {
		emailID.sendKeys(email);
		return new ManageUsers_Page(driver);
	}

	public ManageUsers_Page selectTypeTeacher() throws InterruptedException {
		if (true != uTypeTeacher.isSelected()) {
			uTypeTeacher.click();
			Thread.sleep(2000);
		}
		return new ManageUsers_Page(driver);
	}

	public ManageUsers_Page selectTypeAdmin() throws InterruptedException {
		if (uTypeTeacher.isSelected()) {
			uTypeTeacher.click();
			Thread.sleep(2000);
			uTypeAdmin.click();
			Thread.sleep(2000);
		}
		return new ManageUsers_Page(driver);
	}

	public ManageUsers_Page selectRole(String role) throws InterruptedException {
		Select selectRole = new Select(userRole);
		selectRole.selectByVisibleText(role);
		return new ManageUsers_Page(driver);
	}

	public ManageUsers_Page save() throws InterruptedException {
		savebtn.click();
		Thread.sleep(5000);
		return new ManageUsers_Page(driver);
	}

	public ManageUsers_Page verifyUserExport() throws InterruptedException {
		exportOptions.click();
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(exportExcel));
		Assert.assertEquals(true, exportExcel.isDisplayed(), "Excel is not displayed");
		Assert.assertEquals(true, exportCsv.isDisplayed(), "Csv is not displayed");
		exportExcel.click();
		Thread.sleep(5000);
		Assert.assertTrue(isFileDownloaded(downloadPath, "UserData"), "Failed to download expected file");
		return new ManageUsers_Page(driver);
	}

	public ManageUsers_Page verifyUserAssignments() throws InterruptedException {
		selectUserTwo.click();
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(manageLocation));
		manageLocation.click();
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(userAssignments));
		userAssignments.click();
		Thread.sleep(5000);
		selectUserAssignLocation.click();
		addUserAssignLocation.click();
		Thread.sleep(5000);
		selectSiteOnManageUsersPage.click();
		driver.findElement(By.xpath("//div[@id='select2-drop']/ul/li[2]/div")).click();
		Thread.sleep(5000);
		Assert.assertEquals(true, driver.findElement(By.xpath("//tbody[@id='userRecs']/tr[1]")).isDisplayed());
		return new ManageUsers_Page(driver);
	}

	public ManageUsers_Page verifyTransferUser() throws InterruptedException {
		selectUserFour.click();
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(manageLocation));
		manageLocation.click();
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(transferUser));
		transferUser.click();
		Thread.sleep(2000);
		selectProgram.click();
		driver.findElement(By.xpath("//div[@id='select2-drop']/ul/li[2]/div")).click();
		Thread.sleep(3000);
		selectSite.click();
		driver.findElement(By.xpath("//div[@id='select2-drop']/ul/li[3]/div")).click();
		transferBtn.click();
		Thread.sleep(3000);
		selectSiteOnManageUsersPage.click();
		driver.findElement(By.xpath("//div[@id='select2-drop']/ul/li[2]/div")).click();
		Thread.sleep(5000);
		Assert.assertEquals(true, driver.findElement(By.xpath("//tbody[@id='userRecs']/tr[2]")).isDisplayed());
		return new ManageUsers_Page(driver);
	}

	public ManageUsers_Page verifyRemoveUser() throws InterruptedException {
		selectUserTwo.click();
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(userActions));
		userActions.click();
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(removeUser));
		removeUser.click();
		Thread.sleep(2000);
		selectSiteOnManageUsersPage.click();
		driver.findElement(By.xpath("//div[@id='select2-drop']/ul/li[2]/div")).click();
		Thread.sleep(5000);
		Assert.assertEquals(true, driver.findElement(By.xpath("//tbody[@id='userRecs']/tr[1]")).isDisplayed());
		return new ManageUsers_Page(driver);
	}

	public ManageUsers_Page verifyLockUser() throws InterruptedException {
		selectSiteOnManageUsersPage.click();
		driver.findElement(By.xpath("//div[@id='select2-drop']/ul/li[2]/div")).click();
		Thread.sleep(5000);
		selectUserOne.click();
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(userActions));
		userActions.click();
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(lockUser));
		lockUser.click();
		Thread.sleep(2000);
		Assert.assertEquals(true,
				driver.findElement(By.xpath("//tbody[@id='userRecs']/tr[1]/td[2]/a/i")).isDisplayed());
		return new ManageUsers_Page(driver);
	}

	public ManageUsers_Page verifyUnLockUser() throws InterruptedException {
		selectSiteOnManageUsersPage.click();
		driver.findElement(By.xpath("//div[@id='select2-drop']/ul/li[2]/div")).click();
		Thread.sleep(5000);
		selectUserOne.click();
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(userActions));
		userActions.click();
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(unlockUser));
		unlockUser.click();
		Thread.sleep(2000);
		Assert.assertEquals(false, isElementPresent(By.xpath("//tbody[@id='userRecs']/tr[1]/td[2]/a/i")));
		return new ManageUsers_Page(driver);
	}

	public ManageUsers_Page primaryContactForAdmin() throws InterruptedException {
		selectUserOne.click();
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(primaryContact));
		primaryContact.click();
		Thread.sleep(3000);
		if (true == isElementPresent(By.id("deleteConfirmButtonId"))) {
			okButton.click();
			Thread.sleep(3000);
		}
		Assert.assertEquals(true, isElementPresent(By.xpath("//tbody[@id='userRecs']/tr[1]/td[2]/a/i")));
		return new ManageUsers_Page(driver);
	}

	public ManageUsers_Page primaryContactForTeacher() throws InterruptedException {
		selectUserTwo.click();
		Assert.assertEquals(false, primaryContact.isEnabled());
		return new ManageUsers_Page(driver);
	}

	public ManageUsers_Page verifyProxyButtonActiveness() throws InterruptedException {
		Assert.assertEquals(true, proxyButton.isEnabled());
		return new ManageUsers_Page(driver);
	}

	public Home_Page verifySiteIsRetainedOnTeacherSide() throws InterruptedException {
		proxyButton.click();
		Thread.sleep(5000);
		Assert.assertEquals(driver.findElement(By.xpath("//select[@id='site']/option[2]")).isSelected(), true,
				"Site not retained");
		return new Home_Page(driver);
	}

	public ManageUsers_Page verifyEditUserRole() throws InterruptedException {
		selectSiteOnManageUsersPage.click();
		driver.findElement(By.xpath("//div[@id='select2-drop']/ul/li[2]/div")).click();
		Thread.sleep(5000);
		userOne.click();
		Thread.sleep(3000);
		if (uTypeAdmin.isSelected()) {
			uTypeAdmin.click();
			Thread.sleep(2000);
			uTypeTeacher.click();
			Thread.sleep(2000);
			selectRole("Teacher");
			save();
			Assert.assertEquals(assignedRole.getText(), "Teacher", "User Role not changed");
		} else {
			uTypeTeacher.click();
			Thread.sleep(2000);
			uTypeAdmin.click();
			Thread.sleep(2000);
			selectRole("Administrator");
			save();
			Assert.assertEquals(assignedRole.getText(), "Administrator", "User Role not changed");
		}
		return new ManageUsers_Page(driver);
	}

	public ManageUsers_Page verifyRemoveUserFromSystem() throws InterruptedException {
		selectSiteOnManageUsersPage.click();
		driver.findElement(By.xpath("//div[@id='select2-drop']/ul/li[2]/div")).click();
		Thread.sleep(5000);
		selectAll.click();
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(userActions));
		userActions.click();
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(removeUser));
		removeUser.click();
		Thread.sleep(3000);
		okButton.click();
		Thread.sleep(5000);
		Assert.assertEquals(driver.findElement(By.xpath("//tbody[@id='userRecs']/tr/td")).getText(),
				"No data available in table");
		return new ManageUsers_Page(driver);
	}
}
