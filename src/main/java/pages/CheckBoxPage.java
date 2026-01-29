package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckBoxPage extends Page {
	public By cbHome = By.xpath("//span[@class='rct-checkbox']");
	public By tgHome = By.xpath("//span[text()='Home']/preceding::button[@aria-label='Toggle'][1]");

	public CheckBoxPage(WebDriver driver) {
		super(driver);
	}

	public void selectCheckBox() {
		testBase.scrollToElement(cbHome);
		testBase.clickOnElement(cbHome);
		testBase.clickOnElement(tgHome);

	}

}
