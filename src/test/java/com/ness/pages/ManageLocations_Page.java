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

public class ManageLocations_Page extends PageBase {

	@FindBy(id = "orgAddId")
	private WebElement addButton;

	@FindBy(id = "distribute")
	private WebElement distributeButton;

	@FindBy(id = "clear")
	private WebElement clearButton;

	@FindBy(id = "moveLocation")
	private WebElement moveButton;

	@FindBy(id = "delOrg")
	private WebElement deleteButton;

	@FindBy(id = "name")
	private WebElement progName;

	@FindBy(id = "localOrgCode")
	private WebElement locationCode;

	@FindBy(id = "addressLine1")
	private WebElement addressLine1;

	@FindBy(id = "addressLine2")
	private WebElement addressLine2;

	@FindBy(id = "city")
	private WebElement cityName;

	@FindBy(id = "state")
	private WebElement stateName;

	@FindBy(id = "postalCode")
	private WebElement postalCode;

	@FindBy(id = "country")
	private WebElement countryName;

	@FindBy(id = "phoneNumber")
	private WebElement phoneNumber;

	@FindBy(xpath = "//div[@class='modal-footer']/button[1]")
	private WebElement saveButton;

	@FindBy(xpath = "//div[@class='modal-footer']/button[2]")
	private WebElement cancelButton;

	@FindBy(xpath = "//div[@class='modal-footer']/input[1]")
	private WebElement OKbutton;

	@FindBy(xpath = "//div[@class='modal-body']/p")
	private WebElement attentionMessage;

	@FindBy(id = "s2id_programId")
	private WebElement selectProgramOnManageLocationPage;

	@FindBy(id = "s2id_toProgId")
	private WebElement selectProg;

	@FindBy(xpath = "//tbody[@id='orgRecs']/tr[3]/td[1]/label/i")
	private WebElement chooseSite;

	@FindBy(xpath = "//tbody[@id='orgRecs']/tr[1]/td[1]/label/i")
	private WebElement chooseProgramOne;

	@FindBy(xpath = "//tbody[@id='orgRecs']/tr[2]/td[1]/label/i")
	private WebElement chooseProgramTwo;

	@FindBy(id = "transferBtnId")
	private WebElement transferBtn;

	@FindBy(id = "childrenChk")
	private WebElement childrenChk;

	@FindBy(id = "classChk")
	private WebElement classChk;

	@FindBy(id = "teacherchk")
	private WebElement teacherchk;

	@FindBy(id = "levelchk")
	private WebElement levelchk;

	@FindBy(id = "deleteConfirmButtonId")
	private WebElement deleteConfirmButton;

	@FindBy(xpath = "//div[@id='studentFields']/span[1]")
	private WebElement errorMessageOne;

	@FindBy(xpath = "//div[@id='studentFields']/span[2]")
	private WebElement errorMessageTwo;

	@FindBy(xpath = "//div[@id='studentFields']/span[3]")
	private WebElement errorMessageThree;

	@FindBy(xpath = "//div[@id='studentFields']/span[4]")
	private WebElement errorMessageFour;

	@FindBy(xpath = "//div[@id='studentFields']/span[5]")
	private WebElement errorMessageFive;

	@FindBy(xpath = "//div[@id='studentFields']/span[6]")
	private WebElement errorMessageSix;

	public ManageLocations_Page(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public ManageLocations_Page clickAddButton() throws InterruptedException {
		addButton.click();
		return new ManageLocations_Page(driver);
	}

	public ManageLocations_Page enterProgramName(String name) throws InterruptedException {
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(progName));
		progName.sendKeys(name);
		return new ManageLocations_Page(driver);
	}

	public ManageLocations_Page enterCode(String code) throws InterruptedException {
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(locationCode));
		locationCode.sendKeys(code);
		return new ManageLocations_Page(driver);
	}

	public ManageLocations_Page enterAddress(String addr1, String addr2) throws InterruptedException {
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(addressLine1));
		addressLine1.sendKeys(addr1);
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(addressLine2));
		addressLine2.sendKeys(addr2);
		return new ManageLocations_Page(driver);
	}

	public ManageLocations_Page enterCity(String city) throws InterruptedException {
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(cityName));
		cityName.sendKeys(city);
		return new ManageLocations_Page(driver);
	}

	public ManageLocations_Page selectState(String state) throws InterruptedException {
		Select selectState = new Select(stateName);
		selectState.selectByVisibleText(state);
		return new ManageLocations_Page(driver);
	}

	public ManageLocations_Page enterPostalCode(String code) throws InterruptedException {
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(postalCode));
		postalCode.sendKeys(code);
		return new ManageLocations_Page(driver);
	}

	public ManageLocations_Page selectCountry(String country) throws InterruptedException {
		Select selectCountry = new Select(countryName);
		selectCountry.selectByVisibleText(country);
		return new ManageLocations_Page(driver);
	}

	public ManageLocations_Page enterPhoneNumber(String phone) throws InterruptedException {
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(phoneNumber));
		phoneNumber.sendKeys(phone);
		return new ManageLocations_Page(driver);
	}

	public ManageLocations_Page clickSave() throws InterruptedException {
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(saveButton));
		saveButton.click();
		Thread.sleep(10000);
		return new ManageLocations_Page(driver);
	}

	public ManageLocations_Page clickCancel() throws InterruptedException {
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(cancelButton));
		cancelButton.click();
		return new ManageLocations_Page(driver);
	}

	public ManageLocations_Page clickDistribute() throws InterruptedException {
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(distributeButton));
		distributeButton.click();
		Thread.sleep(2000);
		Assert.assertEquals(
				"Are you sure you want to evenly distribute the licenses?This will override all existing allocations.",
				attentionMessage.getText());
		saveButton.click();
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(clearButton));
		return new ManageLocations_Page(driver);
	}

	public ManageLocations_Page clickClear() throws InterruptedException {
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(clearButton));
		clearButton.click();
		Thread.sleep(2000);
		Assert.assertEquals("Are you sure you want to clear all allocations?", attentionMessage.getText());
		saveButton.click();
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(distributeButton));
		return new ManageLocations_Page(driver);
	}

	public ManageLocations_Page selectProgramOnManageLocationsPage() throws InterruptedException {
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(selectProgramOnManageLocationPage));
		selectProgramOnManageLocationPage.click();
		driver.findElement(By.xpath("//div[@id='select2-drop']/ul/li[1]/div")).click();
		Thread.sleep(5000);
		return new ManageLocations_Page(driver);
	}

	public ManageLocations_Page moveLocation() throws InterruptedException {
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(chooseSite));
		chooseSite.click();
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(moveButton));
		moveButton.click();
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(selectProg));
		selectProg.click();
		driver.findElement(By.xpath("//div[@id='select2-drop']/ul/li[3]/div")).click();
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(transferBtn));
		transferBtn.click();
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(OKbutton));
		OKbutton.click();
		Thread.sleep(5000);
		Assert.assertEquals(false, isElementPresent(By.xpath("//tbody[@id='orgRecs']/tr[3]/td[1]/label/i")));
		return new ManageLocations_Page(driver);
	}

	public ManageLocations_Page deleteLocation() throws InterruptedException {
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(chooseProgramTwo));
		chooseProgramTwo.click();
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(deleteButton));
		deleteButton.click();
		new WebDriverWait(driver, 20).until(ExpectedConditions.and(ExpectedConditions.elementToBeClickable(childrenChk),
				ExpectedConditions.elementToBeClickable(classChk),
				ExpectedConditions.elementToBeClickable(teacherchk)));
		childrenChk.click();
		classChk.click();
		teacherchk.click();
		levelchk.click();
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(deleteConfirmButton));
		deleteConfirmButton.click();
		Thread.sleep(5000);
		Assert.assertEquals(false, isElementPresent(By.xpath("//tbody[@id='orgRecs']/tr[2]/td[1]/label/i")));
		return new ManageLocations_Page(driver);
	}

	public ManageLocations_Page verifyMoveButtonDisabled() throws InterruptedException {
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(chooseProgramOne));
		chooseProgramOne.click();
		Assert.assertEquals(false, moveButton.isEnabled());
		return new ManageLocations_Page(driver);
	}

	public ManageLocations_Page verifySaveWithoutData() throws InterruptedException {
		Assert.assertEquals("The field 'Program Name' cannot be blank.", errorMessageOne.getText());
		Assert.assertEquals("The field 'Address Line 1' cannot be blank.", errorMessageTwo.getText());
		Assert.assertEquals("The field 'City' cannot be blank.", errorMessageThree.getText());
		Assert.assertEquals("The field 'State' cannot be blank.", errorMessageFour.getText());
		Assert.assertEquals("The field 'Postal Code' cannot be blank.", errorMessageFive.getText());
		Assert.assertEquals("The field 'Phone Number' cannot be blank.", errorMessageSix.getText());
		return new ManageLocations_Page(driver);
	}
}