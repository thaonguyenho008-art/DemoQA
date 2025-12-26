package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import common.Utils;
import pages.HomePage;
import pages.TextBoxPage;

public class TextBoxTest extends TestCase {
	// @Test
	public void submitDataSuccesfully() {
		TextBoxPage textBoxPage = new TextBoxPage(base.webDriver);
		base.webDriver.navigate().to("https://demoqa.com/text-box");
		String fullName = "Ho Thao Nguyen";
		String email = "thaonguyen1108@gmail.com";
		String currentAddress = "Ha Noi";
		String permanentAddress = "Nghe An";
		textBoxPage.inputData(fullName, email, currentAddress, permanentAddress);
		String actualFullName = textBoxPage.getActualText(textBoxPage.lblName);
		String actualEmail = textBoxPage.getActualText(textBoxPage.lblEmail);
		String actualCurrentAddress = textBoxPage.getActualText(textBoxPage.lblCurrentAddress);
		String actualPermanentAddress = textBoxPage.getActualText(textBoxPage.lblPermanentAddress);
		Assert.assertEquals(actualFullName, fullName);
		Assert.assertEquals(actualEmail, email);
		Assert.assertEquals(actualCurrentAddress, currentAddress);
		Assert.assertEquals(actualPermanentAddress, permanentAddress);
	}

//	@Test
	public void validateEmail() {
		TextBoxPage textBoxPage = new TextBoxPage(base.webDriver);
		base.webDriver.navigate().to("https://demoqa.com/text-box");
		String fullName = "Ho Thao Nguyen";
		String email = "thaonguyen1108gmail.com";
		String currentAddress = "Ha Noi";
		String permanentAddress = "Nghe An";
		textBoxPage.inputData(fullName, email, currentAddress, permanentAddress);
		Assert.assertTrue(textBoxPage.isEmailChecked(textBoxPage.txtEmail));
	}

	@Test(dataProvider = "EmailValidation")
	public void validateEmail1(String fullName, String email, String currentAddress, String permanentAddress) {
		TextBoxPage textBoxPage = new TextBoxPage(base.webDriver);
		base.webDriver.navigate().to("https://demoqa.com/text-box");
		textBoxPage.inputData(fullName, email, currentAddress, permanentAddress);
		Assert.assertTrue(textBoxPage.isEmailChecked(textBoxPage.txtEmail));
	}

	@DataProvider(name = "EmailValidation")
	public String[][] createDataForEmailValidation() {
		Utils utils = new Utils();
		String[][] emailData =  utils.readDataFormCSV();
		return emailData;
	}
	
	

}
