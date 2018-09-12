package com.ness.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ness.base.PageBase;

public class ManageChildren_Page extends PageBase {

	@FindBy(id = "addStudent")
	private WebElement addChild;

	@FindBy(css = "#alertDoneBtn")
	private WebElement alertOKBtn;

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
	private WebElement saveChild;

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

	@FindBy(xpath = "//button[@class='btn btn-primary' and contains(text(), 'OK')]")
	private WebElement attentionOKBtn;

	@FindBy(xpath = "//table[@id='manageStudentTable']/tbody/tr[1]/td[1]/label/i")
	private WebElement selectChild1;

	@FindBy(id = "remove")
	private WebElement removeChild;

	@FindBy(id = "addExisting")
	private WebElement addExistingChild;

	@FindBy(xpath = "//table[@id='addExistingTable']/tbody/tr/td[5]/label/i")
	private WebElement selectExistingChild1;

	@FindBy(xpath = "//input[@class='btn btn-primary']")
	private WebElement saveExistingChild;

	@FindBy(id = "archive")
	private WebElement archiveChild;

	@FindBy(id = "deleteStudent")
	private WebElement deleteChild;

	public ManageChildren_Page(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public ManageChildren_Page clickAddChild() throws InterruptedException {
		try {
			if (alertOKBtn.isDisplayed()) {
				Thread.sleep(5000);
				alertOKBtn.click();
				Thread.sleep(5000);
				addChild.click();
				new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.id("firstName")));
			}
		} catch (Exception e) {
			addChild.click();
			new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.id("firstName")));
		}
		return new ManageChildren_Page(driver);
	}

	public ManageChildren_Page enterChildName(String firstName, String lastName) {
		enterFirstName.sendKeys(firstName);
		enterLastName.sendKeys(lastName);
		return new ManageChildren_Page(driver);
	}

	public ManageChildren_Page selectGender(String gender) {
		Select selectGender = new Select(chooseGender);
		selectGender.selectByVisibleText(gender);
		return new ManageChildren_Page(driver);
	}

	public ManageChildren_Page selectGrade(String grade) {
		Select selectGrade = new Select(chooseGrade);
		selectGrade.selectByVisibleText(grade);
		return new ManageChildren_Page(driver);
	}

	public ManageChildren_Page selectYear(String year) {
		Select selectYear = new Select(chooseDobYear);
		selectYear.selectByVisibleText(year);
		return new ManageChildren_Page(driver);
	}

	public ManageChildren_Page selectMonth(String month) {
		Select selectMonth = new Select(chooseMonth);
		selectMonth.selectByVisibleText(month);
		return new ManageChildren_Page(driver);
	}

	public ManageChildren_Page selectDay(String day) {
		Select selectDate = new Select(chooseDOB);
		selectDate.selectByVisibleText(day);
		return new ManageChildren_Page(driver);
	}

	public ManageChildren_Page selectIEP() {
		selectIEP.click();
		return new ManageChildren_Page(driver);
	}

	public ManageChildren_Page selectLanguage(String language) {
		Select selectLanguage = new Select(chooseLanguage);
		selectLanguage.selectByVisibleText(language);
		return new ManageChildren_Page(driver);
	}

	public ManageChildren_Page selectEthnicity(String ethnicity) {
		Select selectEthnicity = new Select(chooseEthnicity);
		selectEthnicity.selectByVisibleText(ethnicity);
		return new ManageChildren_Page(driver);
	}

	public ManageChildren_Page clickSave() throws InterruptedException {
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(saveChild));
		saveChild.click();
		Thread.sleep(10000);
		return new ManageChildren_Page(driver);
	}

	public ManageChildren_Page chooseAgeLevelAsBabies1() throws InterruptedException {
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
		return new ManageChildren_Page(driver);
	}

	public ManageChildren_Page verifyDuplicateChild() throws InterruptedException {
		try {
			if (attentionOKBtn.isDisplayed()) {
				attentionOKBtn.click();
				Thread.sleep(10000);
				System.out.println("Duplicate child is created");
			}
		} catch (Exception e) {
			System.out.println("Child is not duplicate");
		}
		return new ManageChildren_Page(driver);
	}

	public ManageChildren_Page verifyRemoveFromClassChild() throws InterruptedException {
		selectChild1.click();
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(removeChild));
		removeChild.click();
		Thread.sleep(3000);
		attentionOKBtn.click();
		Thread.sleep(5000);
		try {
			if (alertOKBtn.isDisplayed()) {
				alertOKBtn.click();
				Thread.sleep(5000);
				System.out.println("Child is been removed from the class.");
			}
		} catch (Exception e) {
		}
		return new ManageChildren_Page(driver);
	}

	public ManageChildren_Page verifyAddExistingChild() throws InterruptedException {
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(addExistingChild));
		addExistingChild.click();
		Thread.sleep(3000);
		selectExistingChild1.click();
		saveExistingChild.click();
		Thread.sleep(5000);
		return new ManageChildren_Page(driver);
	}

	public ManageChildren_Page verifyArchiveChild() throws InterruptedException {
		selectChild1.click();
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(archiveChild));
		archiveChild.click();
		Thread.sleep(3000);
		attentionOKBtn.click();
		Thread.sleep(5000);
		try {
			if (alertOKBtn.isDisplayed()) {
				alertOKBtn.click();
				Thread.sleep(5000);
				System.out.println("Child is been archived.");
			}
		} catch (Exception e) {

		}

		return new ManageChildren_Page(driver);
	}

	public ManageStudents_Page verifyDeleteChild() throws InterruptedException {
		selectChild1.click();
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(deleteChild));
		deleteChild.click();
		Thread.sleep(3000);
		attentionOKBtn.click();
		Thread.sleep(5000);
		try {
			if (alertOKBtn.isDisplayed()) {
				alertOKBtn.click();
				Thread.sleep(5000);
				System.out.println("Child is been deleted.");
			}
		} catch (Exception e) {

		}
		return new ManageStudents_Page(driver);
	}
}