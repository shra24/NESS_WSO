package com.ness.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.ness.base.PageBase;

public class ChildOutcomeSummary_Page extends PageBase {

	public ChildOutcomeSummary_Page(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);

	}
}
