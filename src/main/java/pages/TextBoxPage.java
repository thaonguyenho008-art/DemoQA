package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TextBoxPage extends Page {
	// input
	public By txtFullName = By.id("userName");
	public By txtEmail = By.id("userEmail");
	public By txtCurrentAddress = By.id("currentAddress");
	public By txtPermanentAddress = By.id("permanentAddress");
	public By btnSubmit = By.id("submit");

	// ouput
	public By lblName = By.id("name");
	public By lblEmail = By.id("email");
	public By lblCurrentAddress = By.xpath("//p[@id='currentAddress']");
	public By lblPermanentAddress = By.xpath("//p[@id='permanentAddress']");

	public TextBoxPage(WebDriver driver) {
		super(driver);
	}

	public void inputData(String fullName, String email, String currentAddress, String permanentAddress) {
		testBase.inputText(txtFullName, fullName);
		testBase.inputText(txtEmail, email);
		testBase.inputText(txtCurrentAddress, currentAddress);
		testBase.inputText(txtPermanentAddress, permanentAddress);
		testBase.scrollToElement(btnSubmit);
		testBase.clickButton(btnSubmit);
	}

	public String getActualText(By locator) {
		String result = "";
		String fullText = testBase.getTextByLocator(locator);
		int index = fullText.indexOf(":");
		result = fullText.substring(index+1);
		return result;

	}

}
