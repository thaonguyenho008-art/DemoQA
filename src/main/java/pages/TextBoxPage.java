package pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
		result = fullText.substring(index + 1);
		return result;

	}

	public boolean isEmailChecked(By locator) {
		boolean result = false;
		String classValue = testBase.getAttribute(locator, "class");
		if (classValue.contains("field-error")) {
			result = true;
		}
		return result;
	}

	// pratice form
	// input
	public By txtFirstNamePractice = By.id("firstName");
	public By txtLastNamePractice = By.id("lastName");
	public By txtEmailPractice = By.id("userEmail");
	public By txtgender = By.name("gender");
	public By txtMobile = By.id("userNumber");
	public By txthobbies = By.cssSelector("input[type='checkbox']");
	public By txtCurrentAddressPractice = By.id("currentAddress");
	public By btnSubmitPractice = By.id("submit");

	// ouput
	public By lblTable = By.cssSelector("table.table-dark");

	public void inputDataPractice(String firstName, String lastName, String email, String gender, String mobile,
			List<String> values, String adderss) {
		testBase.inputText(txtFirstNamePractice, firstName);
		testBase.inputText(txtLastNamePractice, lastName);
		testBase.inputText(txtEmailPractice, email);
		testBase.selectRadioBtn(txtgender, gender);
		testBase.selectCheckBoxBtn(txthobbies, values);
		testBase.inputText(txtMobile, mobile);
		testBase.inputText(txtCurrentAddressPractice, adderss);
		testBase.scrollToElement(btnSubmit);
		testBase.clickButton(btnSubmitPractice);
	}

	public String ouputDataPractice(int n) {
		
		List<String> values = testBase.getTableValues(lblTable);
		String result =values.get(n);
		return result;

	}

}
