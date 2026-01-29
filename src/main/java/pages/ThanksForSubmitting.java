package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ThanksForSubmitting extends Page{
	public String lbValueXpath = "//tr/td[text()='@param']/following-sibling::td";

	public ThanksForSubmitting(WebDriver driver) {
		super(driver);
	}
	
	
	public By getLocatorByXpathString(String xpath,String paramValue) {
		By result = null;
		String newXpath = xpath.replace("@param", paramValue);
		result = By.xpath(newXpath);
		return result;

	}

}
