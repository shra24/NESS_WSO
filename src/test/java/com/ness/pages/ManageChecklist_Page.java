package com.ness.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.ness.base.PageBase;

public class ManageChecklist_Page extends PageBase {

	@FindBy(xpath = "//table[@id='checklistTable2']/tbody/tr[2]/td[1]/a")
	private WebElement period1;

	@FindBy(xpath = "//table[@id='checklistTable2']/tbody/tr[2]/td[2]/a")
	private WebElement period2;

	@FindBy(xpath = "//table[@id='checklistTable2']/tbody/tr[2]/td[3]/a")
	private WebElement period3;

	@FindBy(xpath = "//table[@id='checklistTable']/tbody/tr[2]/td[2]/a")
	private WebElement studFirstName;

	@FindBy(xpath = "//table[@id='checklistTable']/tbody/tr[2]/td[3]/a")
	private WebElement studLastName;

	@FindBy(xpath = "html/body/div[2]")
	private WebElement pageBody;

	public ManageChecklist_Page(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public EnterChecklist_Page clickGetStarted() throws InterruptedException {
		Thread.sleep(5000);
		period1.click();
		Thread.sleep(5000);
		return new EnterChecklist_Page(driver);
	}
}