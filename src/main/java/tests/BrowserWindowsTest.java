package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pages.BrowserWindowsPage;
import pages.SampleNewTabPage;

public class BrowserWindowsTest extends TestCase {

	//@Test(testName="Verify that the  sample heading is displayed in a new tab ")
	public void verifySampleheadingInNewTab() {
		BrowserWindowsPage browserWindowsPage = new BrowserWindowsPage(base.webDriver);
		browserWindowsPage.goToPage("https://demoqa.com/browser-windows");
		SampleNewTabPage sampleNewTabPage = browserWindowsPage.clickOnNewTabOrWindow(browserWindowsPage.btnNewTab);
		String expectedSampleHeading = "This is a sample page";
		String actualSampleHeading = base.getTextByLocator(sampleNewTabPage.lblSampleHeading);
		assertEquals(expectedSampleHeading, actualSampleHeading);
	}
	
//	@Test(testName="Verify that the  sample heading is displayed in a new windows ")
	public void verifySampleheadingInNewWindow() {
		BrowserWindowsPage browserWindowsPage = new BrowserWindowsPage(base.webDriver);
		browserWindowsPage.goToPage("https://demoqa.com/browser-windows");
		SampleNewTabPage sampleNewTabPage = browserWindowsPage.clickOnNewTabOrWindow(browserWindowsPage.btnNewWindow);
		String expectedSampleHeading = "This is a sample page";
		String actualSampleHeading = base.getTextByLocator(sampleNewTabPage.lblSampleHeading);
		assertEquals(expectedSampleHeading, actualSampleHeading);
	}
	
	@Test(testName="Verify that the window message is displayed in a new windows ")
	public void verifyWindowMessageInNewWindow() {
		BrowserWindowsPage browserWindowsPage = new BrowserWindowsPage(base.webDriver);
		browserWindowsPage.goToPage("https://demoqa.com/browser-windows");
		SampleNewTabPage sampleNewTabPage = browserWindowsPage.clickOnNewTabOrWindow(browserWindowsPage.btnNewWindowMessage);
		
		System.out.println("");
		String expectedWindowMessage = "Knowledge increases by sharing but not by saving. Please share this website with your friends and in your organization.";
		String actualWindowMessage = base.getTextByLocator(sampleNewTabPage.lblWindownMessage);
		assertEquals(expectedWindowMessage, actualWindowMessage);
	}


}
