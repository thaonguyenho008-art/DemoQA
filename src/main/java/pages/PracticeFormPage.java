package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PracticeFormPage extends Page {
	public By txtFirstName = By.id("firstName");
	public By txtLastName = By.id("lastName");
	public By txtEmail = By.id("userEmail");
	public String rdGender = "//label[text()='@param']";
	public By txtMobile = By.id("userNumber");
	public By txtDateOfBirth = By.id("dateOfBirthInput");
	public By drYear = By.xpath("//select[@class='react-datepicker__year-select']");
	public By drMonth = By.xpath("//select[@class='react-datepicker__month-select']");
	public String dateXpath = "//div[@class='react-datepicker__week'][@paramweek]/div[text()='@paramday']";
	public By cbSubject = By.id("subjectsInput");
	public String hobbiesXpath = "//label[text()='@param']";
	public By txtPicture = By.id("uploadPicture");
	public By txtCurrentAddress = By.id("currentAddress");
	public By cbState = By.id("react-select-3-input");
	public By cbCity = By.id("react-select-4-input");
	public By btnSubmit = By.id("submit");

	public PracticeFormPage(WebDriver driver) {
		super(driver);
	}

	public ThanksForSubmitting inputData(String firstName, String lastName, String email, String gender, String mobile,
			String dateofBirth, String subjects, String hobbies, String picture, String currentAddress, String state,
			String city) {
		testBase.inputText(txtFirstName, firstName);
		testBase.inputText(txtLastName, lastName);
		testBase.inputText(txtEmail, email);
		testBase.selectRadioBtn(rdGender, gender);
		testBase.inputText(txtMobile, mobile);
		testBase.scrollToElement(txtDateOfBirth);
		inputDate(dateofBirth);
		testBase.inputCombobox(cbSubject, subjects);
		testBase.selectCheckBoxBtn(hobbiesXpath, hobbies);
		String imagePath = System.getProperty("user.dir") + "\\TestCase\\" + picture;
		testBase.inputText(txtPicture, imagePath);
		testBase.inputText(txtCurrentAddress, currentAddress);
		testBase.inputCombobox(cbState, state);
		testBase.inputCombobox(cbCity, city);
		testBase.clickOnElement(btnSubmit);
		return new ThanksForSubmitting(dr);
		
	}

	/**
	 * input date
	 * 
	 * @param dateOfBirth: format d mmmm yyyy
	 */
	public void inputDate(String dateOfBirth) {
		String[] dateOfBirths = dateOfBirth.split(" ");
		testBase.clickOnElement(txtDateOfBirth);
		testBase.selectDropDownByVisibleText(drYear, dateOfBirths[2].trim());
		testBase.selectDropDownByVisibleText(drMonth, dateOfBirths[1].trim());
		String newDateXpath = dateXpath.replace("@paramweek", "4");
		String newDateXpath1 = newDateXpath.replace("@paramday", dateOfBirths[0].trim());
		By lbDate = By.xpath(newDateXpath1);
		testBase.clickOnElement(lbDate);
	}

}
