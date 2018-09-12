package com.ness.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.ness.base.PageBase;

public class ClassProfile_Page extends PageBase {

	@FindBy(id = "gradeLevelId")
	private WebElement gradeLevel;

	@FindBy(id = "period")
	private WebElement period;

	@FindBy(id = "domainId")
	private WebElement domain;

	@FindBy(id = "download-btn")
	private WebElement download;

	public ClassProfile_Page(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public ClassProfile_Page selectGradeLevel(String grade) throws InterruptedException {
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(gradeLevel));
		Select selectGradeLevel = new Select(gradeLevel);
		selectGradeLevel.selectByVisibleText(grade);
		Thread.sleep(2000);
		return new ClassProfile_Page(driver);
	}

	public ClassProfile_Page selectPeriod(String prd) throws InterruptedException {
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(period));
		Select selectPeriod = new Select(period);
		selectPeriod.selectByVisibleText(prd);
		return new ClassProfile_Page(driver);
	}

	public ClassProfile_Page selectDomain(String domId) throws InterruptedException {
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(domain));
		Select selectDomain = new Select(domain);
		selectDomain.selectByVisibleText(domId);
		Thread.sleep(3000);
		return new ClassProfile_Page(driver);
	}

	public ClassProfile_Page clickDownload() throws InterruptedException {
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(download));
		download.click();
		Thread.sleep(5000);
		return new ClassProfile_Page(driver);
	}

	public ClassProfile_Page verifyClassProfileReportDownload() throws InterruptedException, IOException {
		Assert.assertTrue(isFileDownloaded(downloadPath, "WSOClassProfile"),
				"Failed to download expected file");
		return new ClassProfile_Page(driver);
	}
	
	public ClassProfile_Page verifyClassProfileOunceReportDownload() throws InterruptedException, IOException {
		Assert.assertTrue(isFileDownloaded(downloadPath, "OunceClassProfile"),
				"Failed to download expected file");
		return new ClassProfile_Page(driver);
	}
}
