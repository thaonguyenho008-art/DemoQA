package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AlertsPage;

public class AlertsTest extends TestCase {

	 @Test(testName="Verify that the alert popup is displayed with a button")
	public void verifyPopupWithAButton() {
		AlertsPage alertsPage = new AlertsPage(base.webDriver);
//		base.webDriver.navigate().to("https://demoqa.com/alerts");
		alertsPage.goToPage("https://demoqa.com/alerts");
		base.scrollToElement(alertsPage.btnClickMe);
		base.clickOnElement(alertsPage.btnClickMe);
		String actualAlert = base.getAlertMessgae(base.webDriver);
		String expectedAlert = "You clicked a button";
		assertEquals(expectedAlert, actualAlert);
	}

	// @Test(testName="Verify that the alert popup is displayed with a PromptBox")
	public void verifyPopupWithTime() {
		AlertsPage alertsPage = new AlertsPage(base.webDriver);
		alertsPage.goToPage("https://demoqa.com/alerts");
		base.clickOnElement(alertsPage.btnClickMeWithTime);
		String actualAlertWithTime = base.getAlertMessageWithTime(5, base.webDriver);
		String expectedAlertWithTime = "This alert appeared after 5 seconds";
		assertEquals(actualAlertWithTime, expectedAlertWithTime);
	}

	//@Test
	public void verifyPopupWithConfirm() {
		AlertsPage alertsPage = new AlertsPage(base.webDriver);
		base.webDriver.navigate().to("https://demoqa.com/alerts");
		base.scrollToElement(alertsPage.btnClickMeWithConfirm);
		base.clickOnElement(alertsPage.btnClickMeWithConfirm);
		String actualAlertWithConfirm = base.getAlertMessgae(base.webDriver);
		String expectedAlertWithConfirm = "Do you confirm action?";
		assertEquals(actualAlertWithConfirm, expectedAlertWithConfirm);

	}

	//@Test
	public void verifyPopupWithPromt() {
		AlertsPage alertsPage = new AlertsPage(base.webDriver);
		base.webDriver.navigate().to("https://demoqa.com/alerts");
		base.scrollToElement(alertsPage.btnClickMeWithPromt);
		base.clickOnElement(alertsPage.btnClickMeWithPromt);
		String actualAlertWithPromt = base.getAlertMessgae(base.webDriver);
		String expectedAlertWithPromt = "Please enter your name";
		String promtText = "ThaoNguyen";
		String actualMessage = alertsPage.sendKeyToAlert(promtText);
		
		assertEquals(actualAlertWithPromt, expectedAlertWithPromt);
		assertTrue(actualMessage.contains(promtText));

	}
	//@Test
	public void verifyAlertButton() {
		AlertsPage alertsPage = new AlertsPage(base.webDriver);
		base.webDriver.navigate().to("https://demoqa.com/alerts");
		base.scrollToElement(alertsPage.btnClickMeWithConfirm);
		base.clickOnElement(alertsPage.btnClickMeWithConfirm);
		base.clickConfirmOnAlert(base.webDriver);
		
	}
	

	

}
