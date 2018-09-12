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

public class EnterChecklist_Page extends PageBase {

	@FindBy(id = "appTitle")
	private WebElement appTitle;

	@FindBy(xpath = "//ul[@id='studentDropDown']/li/a")
	private WebElement selectStudent;

	@FindBy(xpath = "//table[@id='checklistEntryTable']/tbody/tr[2]/td[2]/a")
	private WebElement enterDomainData;

	@FindBy(xpath = "//table[@id='checklistEntryTable']/tbody/tr[2]/td[4]/a")
	private WebElement enterDomain3Data;

	@FindBy(xpath = "//table[@id='checklistEntryTable']/tbody/tr[10]/td[2]/button[@class='btn btn-primary']")
	private WebElement flagAsFinal;

	@FindBy(xpath = "//table[@id='checklistEntryTable']/tbody/tr[7]/td[2]/button[@class='btn btn-primary']")
	private WebElement flagAsFinalOunce;

	@FindBy(xpath = "//table[@id='checklistEntryTable']/tbody/tr[14]/td[2]/button[@class='btn btn-primary']")
	private WebElement flagAsFinalForHsStudent;

	@FindBy(xpath = "//table[@id='checklistEntryTable']/tbody/tr[10]/td[4]/button[@class='btn btn-primary']")
	private WebElement flagAsFinalDomain3;

	@FindBy(xpath = "//table[@id='checklistEntryTable']/tbody/tr[14]/td[4]/button[@class='btn btn-primary']")
	private WebElement flagAsFinalForHsStudentDomain3;

	@FindBy(css = "div[id='period1']>div>a>i")
	private WebElement period1Toggle;

	@FindBy(css = "div[id='period3']>div>a>i")
	private WebElement period3Toggle;

	@FindBy(xpath = "//div[@id='periodB1']/div/a/i")
	private WebElement OunceB1Toggle;

	@FindBy(xpath = "//div[@id='period1']/div/ul/li[1]")
	private WebElement clearChecklist;

	@FindBy(xpath = "//div[@id='period3']/div/ul/li[1]")
	private WebElement clearChecklistPeriod3;

	@FindBy(xpath = "//div[@id='periodB1']/div/ul/li[1]")
	private WebElement clearChecklistOunce;

	@FindBy(xpath = "//div[@id='period1']/div/ul/li[2]")
	private WebElement deleteChecklist;

	@FindBy(xpath = "//div[@id='period3']/div/ul/li[2]")
	private WebElement deleteChecklistPeriod3;

	@FindBy(xpath = "//div[@id='periodB1']/div/ul/li[2]")
	private WebElement deleteChecklistOunce;

	@FindBy(id = "genderAndDob")
	private WebElement studentGenderAndDOB;

	@FindBy(id = "yearGrade")
	private WebElement studentYearAndGrade;

	@FindBy(id = "studLink")
	private WebElement selectAStudent;

	@FindBy(xpath = "//table[@id='checklistEntryTable']/tbody/tr[9]/td[2]")
	private WebElement checklistTableText;

	@FindBy(xpath = "//table[@id='checklistEntryTable']/tbody/tr[6]/td[2]")
	private WebElement ounceChecklistTableText;

	@FindBy(xpath = "//table[@id='checklistEntryTable']/tbody/tr[13]/td[2]")
	private WebElement hsChecklistTableText;

	@FindBy(xpath = "//table[@id='checklistEntryTable']/tbody/tr[9]/td[4]")
	private WebElement checklistTableTextPeriod3;

	@FindBy(xpath = "//table[@id='checklistEntryTable']/tbody/tr[13]/td[4]")
	private WebElement hsChecklistTableTextPeriod3;

	public EnterChecklist_Page(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public Home_Page clickPageTitle() throws InterruptedException {
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(appTitle));
		appTitle.click();
		Thread.sleep(5000);
		return new Home_Page(driver);
	}

	public EnterChecklist_Page selectStudent() throws InterruptedException {
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(selectAStudent));
		selectAStudent.click();
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(selectStudent));
		selectStudent.click();
		Thread.sleep(5000);
		return new EnterChecklist_Page(driver);
	}

	public EnterChecklistData_Page enterDomainData() throws InterruptedException {
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(enterDomainData));
		enterDomainData.click();
		Thread.sleep(5000);
		return new EnterChecklistData_Page(driver);
	}

	public EnterChecklistData_Page enterDomain3Data() throws InterruptedException {
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(enterDomain3Data));
		enterDomain3Data.click();
		Thread.sleep(5000);
		return new EnterChecklistData_Page(driver);
	}

	public EnterChecklist_Page clickFlagAsFinal() throws InterruptedException {
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(flagAsFinal));
		flagAsFinal.click();
		new WebDriverWait(driver, 30).until(ExpectedConditions.textToBePresentInElement(checklistTableText, "Final"));
		return new EnterChecklist_Page(driver);
	}

	public EnterChecklist_Page clickFlagAsFinalOunce() throws InterruptedException {
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(flagAsFinalOunce));
		flagAsFinalOunce.click();
		new WebDriverWait(driver, 30)
				.until(ExpectedConditions.textToBePresentInElement(ounceChecklistTableText, "Final"));
		return new EnterChecklist_Page(driver);
	}

	public EnterChecklist_Page clickFlagAsFinalForHsStudent() throws InterruptedException {
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(flagAsFinalForHsStudent));
		flagAsFinalForHsStudent.click();
		new WebDriverWait(driver, 30).until(ExpectedConditions.textToBePresentInElement(hsChecklistTableText, "Final"));
		return new EnterChecklist_Page(driver);
	}

	public EnterChecklist_Page clickFlagAsFinalDomain3() throws InterruptedException {
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(flagAsFinalDomain3));
		flagAsFinalDomain3.click();
		new WebDriverWait(driver, 30)
				.until(ExpectedConditions.textToBePresentInElement(checklistTableTextPeriod3, "Final"));
		return new EnterChecklist_Page(driver);
	}

	public EnterChecklist_Page clickFlagAsFinalForHsStudentDomain3() throws InterruptedException {
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(flagAsFinalForHsStudentDomain3));
		flagAsFinalForHsStudentDomain3.click();
		new WebDriverWait(driver, 30)
				.until(ExpectedConditions.textToBePresentInElement(hsChecklistTableTextPeriod3, "Final"));
		return new EnterChecklist_Page(driver);
	}

	public EnterChecklist_Page clearChecklist() throws InterruptedException {
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(period1Toggle));
		period1Toggle.click();
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(clearChecklist));
		clearChecklist.click();
		Thread.sleep(3000);
		String finalText = checklistTableText.getText();
		Assert.assertEquals(finalText, "Final", "Checklist is not cleared");
		return new EnterChecklist_Page(driver);
	}

	public EnterChecklist_Page clearChecklistDomain3() throws InterruptedException {
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(period3Toggle));
		period3Toggle.click();
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(clearChecklistPeriod3));
		clearChecklistPeriod3.click();
		Thread.sleep(3000);
		String finalText = checklistTableTextPeriod3.getText();
		Assert.assertEquals(finalText, "Final", "Checklist is not cleared");
		return new EnterChecklist_Page(driver);
	}

	public EnterChecklist_Page clearChecklistOunce() throws InterruptedException {
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(OunceB1Toggle));
		OunceB1Toggle.click();
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(clearChecklistOunce));
		clearChecklistOunce.click();
		Thread.sleep(3000);
		String finalText = ounceChecklistTableText.getText();
		Assert.assertEquals(finalText, "Final", "Checklist is not cleared");
		return new EnterChecklist_Page(driver);
	}

	public EnterChecklist_Page deleteChecklist() throws InterruptedException {
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(period1Toggle));
		period1Toggle.click();
		new WebDriverWait(driver, 30)
				.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(deleteChecklist),
						ExpectedConditions.elementToBeClickable(clearChecklist)));
		int toggleSize = driver.findElements(By.xpath("//div[@id='period1']/div/ul/li/a")).size();
		if (toggleSize == 2) {
			deleteChecklist.click();
		} else {
			clearChecklist.click();
		}
		Thread.sleep(3000);
		String NotStartedText = checklistTableText.getText();
		Assert.assertEquals(NotStartedText, "Not Started", "Checklist is not deleted");
		return new EnterChecklist_Page(driver);
	}

	public EnterChecklist_Page deleteChecklistDomain3() throws InterruptedException {
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(period3Toggle));
		period3Toggle.click();
		new WebDriverWait(driver, 30)
				.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(deleteChecklistPeriod3),
						ExpectedConditions.elementToBeClickable(clearChecklistPeriod3)));
		int toggleSize = driver.findElements(By.xpath("//div[@id='period3']/div/ul/li/a")).size();
		if (toggleSize == 2) {
			deleteChecklistPeriod3.click();
		} else {
			clearChecklistPeriod3.click();
		}
		Thread.sleep(3000);
		String NotStartedText = checklistTableTextPeriod3.getText();
		Assert.assertEquals(NotStartedText, "Not Started", "Checklist is not deleted");
		return new EnterChecklist_Page(driver);
	}

	public EnterChecklist_Page deleteChecklistOunce() throws InterruptedException {
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(OunceB1Toggle));
		OunceB1Toggle.click();
		new WebDriverWait(driver, 30)
				.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(deleteChecklistOunce),
						ExpectedConditions.elementToBeClickable(clearChecklistOunce)));
		int toggleSize = driver.findElements(By.xpath("//div[@id='periodB1']/div/ul/li/a")).size();
		if (toggleSize == 2) {
			deleteChecklistOunce.click();
		} else {
			clearChecklistOunce.click();
		}
		Thread.sleep(3000);
		String NotStartedText = ounceChecklistTableText.getText();
		Assert.assertEquals(NotStartedText, "Not Started", "Checklist is not deleted");
		return new EnterChecklist_Page(driver);
	}

	public EnterChecklist_Page verifyStudentDataIsDisplayed() throws InterruptedException {
		if (studentGenderAndDOB.isDisplayed() && studentYearAndGrade.isDisplayed()) {
			System.out.println("Student Gender, DOB, Year and Grade is displayed");
		} else {
			System.out.println("Student Gender, DOB, Year and Grade is not displayed");
		}
		return new EnterChecklist_Page(driver);
	}

	public EnterChecklist_Page verifyChildDataIsDisplayed() throws InterruptedException {
		if (studentGenderAndDOB.isDisplayed() && studentYearAndGrade.isDisplayed()) {
			System.out.println("Child Gender, DOB, and Grade is displayed");
		} else {
			System.out.println("Child Gender, DOB, and Grade is not displayed");
		}
		return new EnterChecklist_Page(driver);
	}
}
