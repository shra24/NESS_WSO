package com.ness.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.ness.base.PageBase;

public class Dashboard_Page extends PageBase {

	@FindBy(id = "periodList")
	private WebElement periodList;

	@FindBy(id = "activeCnts")
	private WebElement activeCnts;

	@FindBy(id = "archCnts")
	private WebElement archCnts;

	@FindBy(id = "checklist")
	private WebElement checklistCnts;

	public Dashboard_Page(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public Dashboard_Page selectPeriod(String period) throws InterruptedException {
		Select selectPeriod = new Select(periodList);
		selectPeriod.selectByVisibleText(period);
		Thread.sleep(2000);
		return new Dashboard_Page(driver);
	}

	public Dashboard_Page verifyDashboardStatus() {
		Assert.assertEquals(true, activeCnts.isDisplayed());
		Assert.assertEquals(true, archCnts.isDisplayed());
		return new Dashboard_Page(driver);
	}
}
