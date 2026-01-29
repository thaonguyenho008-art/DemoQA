package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import common.Utils;
import pages.PracticeFormPage;
import pages.ThanksForSubmitting;

public class PracticeFormTest extends TestCase {
	@Test(dataProvider = "PraticeFormData")
	public void sumbitDataSuccessfully(String firstName, String lastName, String email, String gender, String mobile,
			String dateofBirth, String subjects, String hobbies, String picture, String currentAddress, String state,
			String city) {
		PracticeFormPage practiceFormPage = new PracticeFormPage(base.webDriver);
		base.webDriver.navigate().to("https://demoqa.com/automation-practice-form");
		ThanksForSubmitting thanksForSubmitting = practiceFormPage.inputData(firstName, lastName, email, gender, mobile,
				dateofBirth, subjects, hobbies, picture, currentAddress, state, city);
		String expectedStudentName = firstName + " " + lastName;
		String actualStudentName = practiceFormPage.testBase.getTextByLocator(
				thanksForSubmitting.getLocatorByXpathString(thanksForSubmitting.lbValueXpath, "Student Name"));
		assertEquals(expectedStudentName, actualStudentName);
		String actualEmail = practiceFormPage.testBase.getTextByLocator(
				thanksForSubmitting.getLocatorByXpathString(thanksForSubmitting.lbValueXpath, "Student Email"));
		assertEquals(email, actualEmail);
		String actualGender = practiceFormPage.testBase.getTextByLocator(
				thanksForSubmitting.getLocatorByXpathString(thanksForSubmitting.lbValueXpath, "Gender"));
		assertEquals(gender, actualGender);
		String actualMobile = practiceFormPage.testBase.getTextByLocator(
				thanksForSubmitting.getLocatorByXpathString(thanksForSubmitting.lbValueXpath, "Mobile"));
		assertEquals(mobile, actualMobile);
		String[] dateOfBirths = dateofBirth.split(" ");
		String expectedDateOfBirth = dateOfBirths[0].trim() + " " + dateOfBirths[1].trim() + ","
				+ dateOfBirths[2].trim();
		String actualDateOfBirth = practiceFormPage.testBase.getTextByLocator(
				thanksForSubmitting.getLocatorByXpathString(thanksForSubmitting.lbValueXpath, "Date of Birth"));
		assertEquals(expectedDateOfBirth, actualDateOfBirth);
		String actualSubject = practiceFormPage.testBase.getTextByLocator(
				thanksForSubmitting.getLocatorByXpathString(thanksForSubmitting.lbValueXpath, "Subjects"));
		assertEquals(subjects, actualSubject);
		String actualHobbies = practiceFormPage.testBase.getTextByLocator(
				thanksForSubmitting.getLocatorByXpathString(thanksForSubmitting.lbValueXpath, "Hobbies"));
		assertEquals(hobbies, actualHobbies);
		String actualPicture = practiceFormPage.testBase.getTextByLocator(
				thanksForSubmitting.getLocatorByXpathString(thanksForSubmitting.lbValueXpath, "Picture"));
		assertEquals(picture, actualPicture);
		String actualCurrentAddress = practiceFormPage.testBase.getTextByLocator(
				thanksForSubmitting.getLocatorByXpathString(thanksForSubmitting.lbValueXpath, "Address"));
		assertEquals(currentAddress, actualCurrentAddress);
		String expectedStateAndCity = state + " " + city;
		String actualStateAndCity = practiceFormPage.testBase.getTextByLocator(
				thanksForSubmitting.getLocatorByXpathString(thanksForSubmitting.lbValueXpath, "State and City"));
		assertEquals(expectedStateAndCity, actualStateAndCity);

	}

	@DataProvider(name = "PraticeFormData")
	public String[][] createDataForPratciceForm() {
		Utils utils = new Utils();
		String praticeFormDataFile = "TestData_PracticeForm.csv";
		String[][] practiceFormData = utils.readDataFormCSV(praticeFormDataFile);
		return practiceFormData;
	}
	
//	@Test
//	public void sumbitDataSuccessfully_Way2() {
//		PracticeFormPage practiceFormPage = new PracticeFormPage(base.webDriver);
//		base.webDriver.navigate().to("https://demoqa.com/automation-practice-form");
//		ThanksForSubmitting thanksForSubmitting = practiceFormPage.inputData(firstName, lastName, email, gender, mobile,
//				dateofBirth, subjects, hobbies, picture, currentAddress, state, city);
//		String expectedStudentName = firstName + " " + lastName;
//		String actualStudentName = practiceFormPage.testBase.getTextByLocator(
//				thanksForSubmitting.getLocatorByXpathString(thanksForSubmitting.lbValueXpath, "Student Name"));
//		assertEquals(expectedStudentName, actualStudentName);
//		String actualEmail = practiceFormPage.testBase.getTextByLocator(
//				thanksForSubmitting.getLocatorByXpathString(thanksForSubmitting.lbValueXpath, "Student Email"));
//		assertEquals(email, actualEmail);
//		String actualGender = practiceFormPage.testBase.getTextByLocator(
//				thanksForSubmitting.getLocatorByXpathString(thanksForSubmitting.lbValueXpath, "Gender"));
//		assertEquals(gender, actualGender);
//		String actualMobile = practiceFormPage.testBase.getTextByLocator(
//				thanksForSubmitting.getLocatorByXpathString(thanksForSubmitting.lbValueXpath, "Mobile"));
//		assertEquals(mobile, actualMobile);
//		String[] dateOfBirths = dateofBirth.split(" ");
//		String expectedDateOfBirth = dateOfBirths[0].trim() + " " + dateOfBirths[1].trim() + ","
//				+ dateOfBirths[2].trim();
//		String actualDateOfBirth = practiceFormPage.testBase.getTextByLocator(
//				thanksForSubmitting.getLocatorByXpathString(thanksForSubmitting.lbValueXpath, "Date of Birth"));
//		assertEquals(expectedDateOfBirth, actualDateOfBirth);
//		String actualSubject = practiceFormPage.testBase.getTextByLocator(
//				thanksForSubmitting.getLocatorByXpathString(thanksForSubmitting.lbValueXpath, "Subjects"));
//		assertEquals(subjects, actualSubject);
//		String actualHobbies = practiceFormPage.testBase.getTextByLocator(
//				thanksForSubmitting.getLocatorByXpathString(thanksForSubmitting.lbValueXpath, "Hobbies"));
//		assertEquals(hobbies, actualHobbies);
//		String actualPicture = practiceFormPage.testBase.getTextByLocator(
//				thanksForSubmitting.getLocatorByXpathString(thanksForSubmitting.lbValueXpath, "Picture"));
//		assertEquals(picture, actualPicture);
//		String actualCurrentAddress = practiceFormPage.testBase.getTextByLocator(
//				thanksForSubmitting.getLocatorByXpathString(thanksForSubmitting.lbValueXpath, "Address"));
//		assertEquals(currentAddress, actualCurrentAddress);
//		String expectedStateAndCity = state + " " + city;
//		String actualStateAndCity = practiceFormPage.testBase.getTextByLocator(
//				thanksForSubmitting.getLocatorByXpathString(thanksForSubmitting.lbValueXpath, "State and City"));
//		assertEquals(expectedStateAndCity, actualStateAndCity);
//
//	}

}
