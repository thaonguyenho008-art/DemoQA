package common;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

	public void clickButton(By locator) {
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
}
