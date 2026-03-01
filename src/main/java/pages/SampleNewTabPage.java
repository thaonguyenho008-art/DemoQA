package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SampleNewTabPage extends Page {

	public By lblSampleHeading = By.id("sampleHeading");
	public By lblWindownMessage = By.tagName("body");
	public SampleNewTabPage(WebDriver driver) {
		super(driver);
	}

	
}
