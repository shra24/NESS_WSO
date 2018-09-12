package com.ness.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.ness.base.PageBase;

public class ManageSummaryReports_Page extends PageBase {

	@FindBy(xpath = "//table[@id='manageSummaryReportsTable']/tbody/tr[1]/td[5]/a")
	private WebElement babiesOne;

	@FindBy(xpath = "//table[@id='manageSummaryReportsTable']/tbody/tr[1]/td[6]/a")
	private WebElement babiesTwo;

	@FindBy(xpath = "//table[@id='manageSummaryReportsTable']/tbody/tr[1]/td[1]/a")
	private WebElement childInfo;

	@FindBy(xpath = "//table[@id='manageSummaryReportsTable']/tbody/tr[1]/td[1]/div/h3/span")
	private WebElement childInfoClose;

	public ManageSummaryReports_Page(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public NarrativeSummary_Page clickBabiesOne() throws InterruptedException {
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(babiesOne));
		babiesOne.click();
		Thread.sleep(5000);
		return new NarrativeSummary_Page(driver);
	}

	public NarrativeSummary_Page clickBabiesTwo() throws InterruptedException {
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(babiesTwo));
		babiesTwo.click();
		Thread.sleep(5000);
		return new NarrativeSummary_Page(driver);
	}

	public ManageSummaryReports_Page verifyChildInfoOnManageSummaryPage() throws InterruptedException {
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(childInfo));
		Assert.assertEquals(true, childInfo.isEnabled());
		childInfo.click();
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(childInfoClose));
		childInfoClose.click();
		return new ManageSummaryReports_Page(driver);
	}
}