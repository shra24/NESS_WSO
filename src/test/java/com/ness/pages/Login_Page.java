package com.ness.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ness.base.PageBase;
import com.ness.utilities.JSWaiter;

public class Login_Page extends PageBase {

	@FindBy(id = "userName")
	private WebElement login_username;
	@FindBy(id = "password")
	private WebElement login_password;
	@FindBy(name = "login")
	private WebElement button_signIn;
	@FindBy(css = "body > div.topWrapper > div > div.rightGroup > div.profileNav.dropdown > a > span")
	private WebElement usernameTxt;
	@FindBy(id = "userName.errors")
	private WebElement invalidUser;

	// Constructor takes a reference to the driver
	public Login_Page(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public Login_Page login(String username, String password) {
		JSWaiter.waitJQueryAngular();
		login_username.clear();
		login_username.sendKeys(username);

		login_password.clear();
		login_password.sendKeys(password);

		button_signIn.click();
		return this;
	}

	public Login_Page wait_For_Login_PageLoad() {
		JSWaiter.waitJQueryAngular();

		(new WebDriverWait(driver, 15)).until(ExpectedConditions.and(ExpectedConditions.visibilityOf(login_username),
				ExpectedConditions.visibilityOf(login_password), ExpectedConditions.visibilityOf(button_signIn)));
		return this;
	}

	public boolean verifyLogin(String username) {
		boolean status = false;
		String userTxt = usernameTxt.getText();
		if (userTxt.toLowerCase().contains(username)) {
			System.out.println(username + " is verified");
			status = true;
		} else {
			System.out.println(username + " is not verified");
			status = false;
		}
		return status;
	}

	public void invalidUsername() {
		String invalidTxt = invalidUser.getText();
		System.out.println(invalidTxt);
	}
}