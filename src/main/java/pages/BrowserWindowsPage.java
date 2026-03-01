package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;

public class BrowserWindowsPage extends Page {

	public By btnNewTab = By.id("tabButton");
	public By btnNewWindow = By.id("windowButton");
	public By btnNewWindowMessage = By.id("messageWindowButton");
	public BrowserWindowsPage(WebDriver driver) {
		super(driver);
	}
	
	public SampleNewTabPage clickOnNewTabOrWindow(By locator) {
		testBase.clickOnElement(locator);
		Set<String> windowHandles = dr.getWindowHandles();
		System.out.println("abc"+windowHandles.size());
		List<String> tabs = new ArrayList<>(windowHandles);
		dr.switchTo().window(tabs.get(tabs.size()-1)); // switch to new it window 
		WebElement element = dr.findElement(By.tagName("body"));
		System.out.println("element"+dr);
		return new SampleNewTabPage(dr);

	}
	
	public SampleNewTabPage clickOnNewWindowMessage(By locator) {
		testBase.clickOnElement(locator);
		dr.switchTo().newWindow(WindowType.TAB);
		WebElement element = dr.findElement(By.tagName("body"));
		System.out.println("element"+dr);
		return new SampleNewTabPage(dr);

	}
	
	
	

}
