package pages;

import org.openqa.selenium.WebDriver;

import common.TestBase;

public class Page {
	public TestBase testBase = new TestBase();
	protected WebDriver dr;

	public Page(WebDriver driver) {
		testBase.webDriver = driver; 
		this.dr = testBase.webDriver;
	}
	
	public void goToPage(String url) {
		testBase.webDriver.navigate().to(url);

	}

}
