package tests;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import common.Utils;
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

//	@Test(dataProvider = "EmailValidation")
	public void validateEmail1(String fullName, String email, String currentAddress, String permanentAddress) {
		TextBoxPage textBoxPage = new TextBoxPage(base.webDriver);
		base.webDriver.navigate().to("https://demoqa.com/text-box");
		textBoxPage.inputData(fullName, email, currentAddress, permanentAddress);
		Assert.assertTrue(textBoxPage.isEmailChecked(textBoxPage.txtEmail));
	}

//	@DataProvider(name = "EmailValidation")
	public String[][] createDataForEmailValidation() {
		Utils utils = new Utils();
		String emailDataFile = "TestData.csv";
		String[][] emailData = utils.readDataFormCSV(emailDataFile);
		return emailData;
	}

//	@Test
//	public void submitDataSuccesfullyPracticeForm() {
//		TextBoxPage textBoxPage = new TextBoxPage(base.webDriver);
//		base.webDriver.navigate().to("https://demoqa.com/automation-practice-form");
//		String firstName = "Nguyen";
//		String lastName = "Ho Thi Thao";
//		String fullName = firstName + " " + lastName;
//		String email = "thaonguyen1108@gmail.com";
//		String gender = "other";
//		String mobile = "0987812345";
//		List<String> options = new ArrayList<String>();
//		options.add("Sports");
//		options.add("Reading");
//		// String subject = "Math";
//		String currentAddress = "Ha Noi";
//		textBoxPage.inputDataPractice(firstName, lastName, email, gender, mobile, options, currentAddress);
//		String actualFullName = textBoxPage.ouputDataPractice(0);
//		String actualEmail = textBoxPage.ouputDataPractice(1);
//		String actualGender = textBoxPage.ouputDataPractice(2);
//		String actualMobile = textBoxPage.ouputDataPractice(3);
//		String actualHobbiles = textBoxPage.ouputDataPractice(6);
//		String actualCurrentAddress = textBoxPage.ouputDataPractice(8);
//		Assert.assertEquals(actualFullName, fullName);
//		Assert.assertEquals(actualEmail, email);
//		Assert.assertEquals(actualGender.toLowerCase(), gender.toLowerCase());
//		Assert.assertEquals(actualMobile, mobile);
//		Assert.assertEquals(actualHobbiles, String.join(", ", options));
//		Assert.assertEquals(actualCurrentAddress, currentAddress);
//
//	}

}
