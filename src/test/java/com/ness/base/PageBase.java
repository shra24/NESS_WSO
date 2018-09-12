package com.ness.base;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.google.common.base.Function;
import com.ness.config.DriverManager;
import com.ness.inputs.Constants;
import com.ness.pages.Logout_Page;
import com.ness.utilities.JSWaiter;

public class PageBase {

	protected WebDriver driver;

	protected static String downloadPath = "C:\\Users\\P7111024.PIDC\\Downloads";

	@FindBy(xpath = "//ul[@class='dropdown-menu pull-right']/li[2]")
	private WebElement logout;

	public PageBase(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Common Methods
	// =============================================

	protected void clickByJavaScript(WebElement element) throws Exception {
		JSWaiter.waitJQueryAngular();
		// This will enable this element if element is invisible
		String js = "arguments[0].style.height='auto'; arguments[0].style.visibility='visible';";
		((JavascriptExecutor) driver).executeScript(js, element);
		try {
			if (element.isEnabled() && element.isDisplayed()) {
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
			} else {
				System.out.println("Unable to click on element");
			}
		} catch (Exception e) {
			System.out.println("Element is not attached to the page document " + e.getStackTrace());
		}
		JSWaiter.waitJQueryAngular();
	}

	// user defined check color Method
	protected void checkElementColor(WebElement element, String expectedColorInHex) {
		try {
			JSWaiter.waitJQueryAngular();
			String color = element.getCssValue("color");
			String colorInHex = Color.fromString(color).asHex();
			assertEquals(colorInHex, expectedColorInHex);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void checkElementBackgroundColor(WebElement element, String expectedColorInHex) {
		try {
			JSWaiter.waitJQueryAngular();
			String color = element.getCssValue("background-color");
			String colorInHex = Color.fromString(color).asHex();
			assertEquals(colorInHex, expectedColorInHex);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// user defined mouseOver Method
	protected void mouseOver(WebElement element) {
		JSWaiter.waitJQueryAngular();
		try {
			final Actions builder = new Actions(driver);
			final Action mouseover = builder.moveToElement(element).build();
			mouseover.perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void mouseHoverByJavaScript(WebElement element) {
		JSWaiter.waitJQueryAngular();
		try {
			String javaScript = "var evObj = document.createEvent('MouseEvents');"
					+ "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);"
					+ "arguments[0].dispatchEvent(evObj);";
			((JavascriptExecutor) driver).executeScript(javaScript, element);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected boolean isAlertPresent() {
		JSWaiter.waitJQueryAngular();
		try {
			final Alert alert = driver.switchTo().alert();
			alert.getText();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	protected String getAlertText() {
		String text;
		try {
			final Alert alert = driver.switchTo().alert();
			text = alert.getText();
			return text;
		} catch (Exception e) {
			return null;
		}
	}

	protected void acceptAlert() {
		final Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	protected void dismissAlert() {
		final Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	protected void verifyLinks() {
		JSWaiter.waitJQueryAngular();
		List<WebElement> links = driver.findElements(By.tagName("a"));
		Reporter.log("Total links are: " + links.size(), true);
		for (WebElement link : links) {
			String url = link.getAttribute("href");
			verifyLinkActive(url);
		}
		JSWaiter.waitJQueryAngular();
	}

	private void verifyLinkActive(String linkUrl) {
		try {
			URL url = new URL(linkUrl);
			HttpURLConnection httpURLConnect = (HttpURLConnection) url.openConnection();
			httpURLConnect.setConnectTimeout(3000);
			httpURLConnect.connect();

			if (httpURLConnect.getResponseCode() == 200) {
				System.out.println(linkUrl + " - " + httpURLConnect.getResponseMessage());
			}
			if (httpURLConnect.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND) {
				System.out.println(linkUrl + " - " + httpURLConnect.getResponseMessage());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void dragAndDrop(WebElement sourceElement, WebElement destinationElement) {
		JSWaiter.waitJQueryAngular();
		if (sourceElement.isDisplayed() && destinationElement.isDisplayed()) {
			Actions action = new Actions(driver);
			action.dragAndDrop(sourceElement, destinationElement).build().perform();
		}
		JSWaiter.waitJQueryAngular();
	}

	protected void scrollByPixel() {
		JSWaiter.waitJQueryAngular();
		try {
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)");
		} catch (Exception e) {
			e.printStackTrace();
		}
		JSWaiter.waitJQueryAngular();
	}

	protected void scrollToBottom() {
		JSWaiter.waitJQueryAngular();
		try {
			((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		} catch (Exception e) {
			e.printStackTrace();
		}
		JSWaiter.waitJQueryAngular();
	}

	protected void scrollToGetElementIntoView(WebElement element) {
		JSWaiter.waitJQueryAngular();
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		} catch (Exception e) {
			e.printStackTrace();
		}
		JSWaiter.waitJQueryAngular();
	}

	protected void clickEscape() {
		JSWaiter.waitJQueryAngular();
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ESCAPE).build().perform();
		JSWaiter.waitJQueryAngular();
	}

	protected void switchWindowUsingURL(String platform) throws InterruptedException {
		JSWaiter.waitJQueryAngular();
		String currentHandle = null;
		try {
			final Set<String> handles = driver.getWindowHandles();
			if (handles.size() > 1) {
				currentHandle = driver.getWindowHandle();
			}
			if (currentHandle != null) {
				for (final String handle : handles) {
					driver.switchTo().window(handle);
					if (driver.getCurrentUrl().contains(platform) && !currentHandle.equals(handle)) {
						break;
					}
				}
			} else {
				for (final String handle : handles) {
					driver.switchTo().window(handle);
					if (driver.getCurrentUrl().contains(platform)) {
						break;
					}
				}
			}
		} catch (Exception e) {
			System.out.println("Switching tabs failed");
		}
		JSWaiter.waitJQueryAngular();
	}

	// Using frame id
	protected void switchToFrame(int frameInt) {
		JSWaiter.waitJQueryAngular();
		driver.switchTo().frame(frameInt);
		JSWaiter.waitJQueryAngular();
	}

	// using frame name
	protected void switchToFrame(String frameName) {
		JSWaiter.waitJQueryAngular();
		driver.switchTo().frame(frameName);
		JSWaiter.waitJQueryAngular();
	}

	// in case of more than 2 frames using frame name
	protected void switchToFrame(String ParentFrameName, String ChildFrameName) {
		JSWaiter.waitJQueryAngular();
		driver.switchTo().frame(ParentFrameName).switchTo().frame(ChildFrameName);
		JSWaiter.waitJQueryAngular();
	}

	// in case of more than 2 frames using frame id
	protected void switchToFrame(int ParentFrameId, int ChildFrameId) {
		JSWaiter.waitJQueryAngular();
		driver.switchTo().frame(ParentFrameId).switchTo().frame(ChildFrameId);
		JSWaiter.waitJQueryAngular();
	}

	// switching to default frame
	protected void switchToDefaultFrame() {
		JSWaiter.waitJQueryAngular();
		driver.switchTo().defaultContent();
		JSWaiter.waitJQueryAngular();
	}

	protected void rightClick(WebElement element) {
		JSWaiter.waitJQueryAngular();
		Actions action = new Actions(driver);
		action.contextClick(element).build().perform();
		JSWaiter.waitJQueryAngular();
	}

	protected void doubleClick(WebElement element) {
		JSWaiter.waitJQueryAngular();
		Actions action = new Actions(driver);
		action.doubleClick(element).build().perform();
		JSWaiter.waitJQueryAngular();
	}

	protected void clickExactText(List<WebElement> elements, String valueToBeSelected) throws Exception {
		JSWaiter.waitJQueryAngular();
		WebElement element = getExactMatchingTextElementFromList(elements, valueToBeSelected);
		element.click();
		JSWaiter.waitJQueryAngular();
	}

	private WebElement getExactMatchingTextElementFromList(List<WebElement> elements, String contentText)
			throws Exception {

		WebElement elementToBeReturned = null;
		boolean found = false;

		if (elements.size() > 0) {
			for (WebElement element : elements) {
				if (element.getText().trim().replaceAll("\\s+", " ").equalsIgnoreCase(contentText)) {
					elementToBeReturned = element;
					found = true;
					break;
				}
			}
			if (!found) {
				throw new Exception("Didn't find the correct text(" + contentText + ")..! from list");
			}
		} else {
			throw new Exception("Unable to find list element...!");
		}
		return elementToBeReturned;
	}

	protected void clickContainsText(List<WebElement> elements, String valueToBeSelected) throws Exception {
		JSWaiter.waitJQueryAngular();
		WebElement element = getContainsMatchingTextElementFromList(elements, valueToBeSelected);
		element.click();
		JSWaiter.waitJQueryAngular();
	}

	private WebElement getContainsMatchingTextElementFromList(List<WebElement> elements, String contentText)
			throws Exception {

		WebElement elementToBeReturned = null;
		boolean found = false;

		if (elements.size() > 0) {
			for (WebElement element : elements) {
				if (element.getText().trim().replaceAll("\\s+", " ").contains(contentText)) {
					elementToBeReturned = element;
					found = true;
					break;
				}
			}
			if (!found) {
				throw new Exception("Didn't find the correct text(" + contentText + ")..! from list");
			}
		} else {
			throw new Exception("Unable to find list element...!");
		}
		return elementToBeReturned;
	}

	protected void selectByValue(WebElement element, String value) {
		JSWaiter.waitJQueryAngular();
		new Select(element).selectByValue(value);
		JSWaiter.waitJQueryAngular();
	}

	protected synchronized void selectByIndex(WebElement element, int Index) {
		JSWaiter.waitJQueryAngular();
		new Select(element).selectByIndex(Index);
		JSWaiter.waitJQueryAngular();
	}

	protected synchronized void selectByVisibleText(WebElement element, String text) {
		JSWaiter.waitJQueryAngular();
		new Select(element).selectByVisibleText(text);
		JSWaiter.waitJQueryAngular();
	}

	// Fluent wait
	// Waiting 300 seconds for an element to be present on the page,
	// checking for its presence every 2 seconds.
	protected synchronized WebElement findFluentElement(WebElement element) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(300, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);

		return wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver webDriver) {
				return element;
			}
		});
	}

	// PASS FILE NAME FROM sample files folder WITH EXTENSION
	protected void uploadingFileWithSendKeys(String filename) {
		File filePath = new File(Constants.FILES_FOR_UPLOAD_LOC + filename); // local
																				// machine
																				// file
																				// location
		WebElement element = DriverManager.getDriver().findElement(By.xpath("//div[@id='item0']/input"));
		element.sendKeys(filePath.getAbsolutePath());
	}

	public boolean isFileDownloaded(String downloadPath, String fileName) {
		boolean flag = false;
		File dir = new File(downloadPath);
		File[] dir_contents = dir.listFiles();

		for (int i = 0; i < dir_contents.length; i++) {
			if (dir_contents[i].getName().startsWith(fileName))
				return flag = true;
		}

		return flag;
	}

	public boolean verifyPDFContent(String filePath, String reqTextInPDF) throws IOException {

		boolean flag = false;

		PDFTextStripper pdfStripper = null;
		PDDocument pdDoc = null;
		COSDocument cosDoc = null;
		String parsedText = null;

		try {
			File file = new File(filePath);
			PDFParser parser = new PDFParser(new FileInputStream(file));

			parser.parse();
			cosDoc = parser.getDocument();
			pdfStripper = new PDFTextStripper();
			pdfStripper.setStartPage(1);
			pdfStripper.setEndPage(1);

			pdDoc = new PDDocument(cosDoc);
			parsedText = pdfStripper.getText(pdDoc);
		} catch (IOException e) {
			System.err.println("Unable to open PDF Parser. " + e.getMessage());
			try {
				if (cosDoc != null)
					cosDoc.close();
				if (pdDoc != null)
					pdDoc.close();
			} catch (Exception e1) {
				e.printStackTrace();
			}
		}

		// System.out.println("-------------------");
		// System.out.println(parsedText);
		// System.out.println("-------------------");

		if (parsedText.contains(reqTextInPDF)) {
			flag = true;
			pdDoc.close();
		}
		return flag;
	}

	public Logout_Page logout() throws InterruptedException {
		Thread.sleep(2000);
		new WebDriverWait(driver, 30)
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='pull-left nameLink']")));
		driver.findElement(By.xpath("//span[@class='pull-left nameLink']")).click();
		logout.click();
		Thread.sleep(2000);
		return new Logout_Page(driver);
	}

	public boolean isElementPresent(By locatorKey) {
		try {
			driver.findElement(locatorKey);
			return true;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}
}
