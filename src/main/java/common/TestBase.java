package common;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {
	public WebDriver webDriver;

	public void openSingleBrowser(String url, String browser) {
		String projectDirectory = System.getProperty("user.dir");
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", projectDirectory + "\\driver\\chromedriver.exe");
			webDriver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "C:\\path\\to\\msedgedriver.exe");
			webDriver = new EdgeDriver();
		}
		webDriver.get("http://demoqa.com");
		webDriver.manage().window().maximize();
	}

	public void inputText(By locator, CharSequence... keysToSend) {
		if (isDisplayed(locator, 0)) {
			webDriver.findElement(locator).sendKeys(keysToSend);
		}
	}

	public void clickOnElement(By locator) {
		if (isDisplayed(locator, 0)) {
			webDriver.findElement(locator).click();
		}
	}

	public void scrollToElement(By locator) {
		WebElement webElement = webDriver.findElement(locator);
		JavascriptExecutor js = (JavascriptExecutor) webDriver;
		js.executeScript("arguments[0].scrollIntoView(true);", webElement);
	}

	public String getTextByLocator(By locator) {
		String result = "";
		if (isDisplayed(locator, 0)) {
			result = webDriver.findElement(locator).getText();
		}
		return result;
	}

//
	public String getAttribute(By locator, String attribute) {
		WebElement webElement = null;
		if (isDisplayed(locator, 0)) {
			webElement = webDriver.findElement(locator);
		}
		return webElement.getAttribute(attribute);
	}

	/**
	 * check element displayed in timeout-second
	 * 
	 * @param locator
	 * @param timeToSecond
	 * @return
	 */
	public boolean isDisplayed(By locator, int timeToSecond) {
		boolean result = false;
		WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(timeToSecond));
		WebElement webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		if (webElement.isDisplayed()) {
			result = true;
		}
		return result;

	}

	public void selectRadioBtn(String xpath, String text) {
		String newXpath = xpath.replace("@param", text);
		By locator = By.xpath(newXpath);
		if (isDisplayed(locator, 0)) {
			clickOnElement(locator);
		}
	}

	public void selectDropDownByVisibleText(By locator, String text) {
		WebElement dropDownElement = webDriver.findElement(locator);
		if (isDisplayed(locator, 0)) {
			Select selectElement = new Select(dropDownElement);
			selectElement.selectByVisibleText(text);
		}
	}

	/**
	 * 
	 * @param locator
	 * @param value:  multiple values which are separated by comma, E.g: "Physics,
	 *                Math"
	 */
	public void inputCombobox(By locator, String value) {
		String[] values = value.split(",");
		for (String element : values) {
			inputText(locator, element.trim());
			inputText(locator, Keys.ENTER);
		}

	}

	/**
	 * 
	 * @param locator
	 * @param value   multiple values which are separated by comma, E.g:
	 *                "Sports,Reading,Music"
	 */
	public void selectCheckBoxBtn(String xpathWithParam, String value) {
		String[] values = value.split(",");
		for (String element : values) {
			String newXpath = xpathWithParam.replace("@param", element.trim());
			By locator = By.xpath(newXpath);
			clickOnElement(locator);
		}

	}

	public String getAlertMessgae(WebDriver dr) {
		String result = "";
		Alert alert = dr.switchTo().alert();
		result = alert.getText();
		return result;
	}
	
	/**
	 * 
	 * @param timeToSecond: time for alert displayed after clicking 
	 * @param dr
	 * @return
	 */
	public String getAlertMessageWithTime(int timeToSecond,WebDriver dr) {
		String result = "";
		WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(timeToSecond));
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		Alert alerts = dr.switchTo().alert();
		result = alerts.getText();
		return result;
	}
	
	public void clickConfirmOnAlert(WebDriver dr) {
		Alert alert = dr.switchTo().alert();
		alert.accept();
	}
	
}
