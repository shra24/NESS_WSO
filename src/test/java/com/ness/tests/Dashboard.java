package com.ness.tests;

import java.util.Hashtable;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ness.config.DriverManager;
import com.ness.inputs.Constants;
import com.ness.pages.AdminHomePage;
import com.ness.pages.Dashboard_Page;
import com.ness.pages.Login_Page;
import com.ness.utilities.TestUtils;
import com.ness.utilities.Xls_Reader;

public class Dashboard {

	AdminHomePage adminHomePage;
	Dashboard_Page dashboardPage;

	private final static String testData = Constants.TESTDATA_LOC;
	private static Xls_Reader xls = new Xls_Reader(testData);

	@DataProvider
	private Object[][] getTestData() {
		System.out.println("Executing DataProvider");
		return TestUtils.getData("Work", xls);
	}

	@Test(dataProvider = "getTestData", groups = "Regression", priority = 220)
	public void verifyDashboardStatus(Hashtable<String, String> data, ITestContext context) throws Exception {

		String Browser = context.getCurrentXmlTest().getParameter("Browser");
		context.setAttribute("Browser", Browser);

		WebDriver driver = DriverManager.getDriver();
		driver.get(Constants.URL);

		Login_Page LoginPage = new Login_Page(driver);

		LoginPage.wait_For_Login_PageLoad().login(TestUtils.getTestData(data, "SiteAdminUsername"),
				TestUtils.getTestData(data, "Password"));

		adminHomePage = new AdminHomePage(driver);
		dashboardPage = adminHomePage.clickDashboard();
		dashboardPage.selectPeriod("PERIOD 1");
		dashboardPage.verifyDashboardStatus();
		dashboardPage.logout();
	}
}
