package pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertsPage extends Page {

	public By btnClickMe = By.id("alertButton");
	public By btnClickMeWithTime = By.id("timerAlertButton");
	public By btnClickMeWithConfirm = By.id("confirmButton");
	public By btnClickMeWithPromt = By.id("promtButton");
	public By lblMessageWithPromt = By.id("promptResult");

	public AlertsPage(WebDriver driver) {
		super(driver);
	}

	public String sendKeyToAlert(String inputText) {
		String result = "";
		Alert alert = dr.switchTo().alert();
		alert.sendKeys(inputText);
		alert.accept();
		result = testBase.getTextByLocator(lblMessageWithPromt);
		return result;

	}

}
