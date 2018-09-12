package com.ness.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.ness.base.PageBase;

public class Resources_Page extends PageBase {
	public Resources_Page(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
}