package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TextBoxPage extends Page {
	// input
	public By fullName = By.id("userName");
	public By email = By.id("userEmail");
	public By currentAddress = By.id("currentAddress");
	public By permanentAddress = By.id("permanentAddress");
	public By buttonSubmit = By.id("submit");
    // ouput
	public By outputFullName = By.id("userName");
	public By outputEmail = By.id("userEmail");
	public By ouputCurrentAddress = By.id("currentAddress");
	public By ouputPermanentAddress = By.id("permanentAddress");
	public TextBoxPage(WebDriver driver) {
		super(driver);
	}

	public void inputFullName(String valueFullName) {
		dr.findElement(fullName).sendKeys(valueFullName);
	}

	public void inputEmail(String valueinputEmail) {
		dr.findElement(email).sendKeys(valueinputEmail);
	}

	public void inputCurrentAddress(String valueinputCurrentAddress) {
		dr.findElement(currentAddress).sendKeys(valueinputCurrentAddress);
	}

	public void inputPermanentAddress(String valuepermanentAddress) {
		dr.findElement(permanentAddress).sendKeys(valuepermanentAddress);
	}
	
	public void clickSubmit() {
		dr.findElement(buttonSubmit).click();
	}
	
	public String getFullName() {
		return dr.findElement(outputFullName).getText();
	}
	
	public String getEmail() {
		return dr.findElement(outputEmail).getText();
	}
	
	public String getCurrentAddress() {
		return dr.findElement(ouputCurrentAddress).getText();
	}
	
	public String getPermanentAddress() {
		return dr.findElement(ouputPermanentAddress).getText();
	}

}
