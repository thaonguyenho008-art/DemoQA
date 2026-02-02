package pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebTablesPage extends Page {

	public By txtSearch = By.id("searchBox");
	public By btnAdd = By.id("addNewRecordButton");
	public By txtFirstName = By.id("firstName");
	public By txtLastName = By.id("lastName");
	public By txtEmail = By.id("userEmail");
	public By txtAge = By.id("age");
	public By txtSalary = By.id("salary");
	public By txtDepartment = By.id("department");
	public By btnSubmit = By.id("submit");
	public By lbFirstName = By.xpath("//div[@class='rt-tbody']/div[@role='rowgroup'][1]//div[@class='rt-td'][1]");
	public By lbLastName = By.xpath("//div[@class='rt-tbody']/div[@role='rowgroup'][1]//div[@class='rt-td'][2]");
	public By lbAge = By.xpath("//div[@class='rt-tbody']/div[@role='rowgroup'][1]//div[@class='rt-td'][3]");
	public By lbEmail = By.xpath("//div[@class='rt-tbody']/div[@role='rowgroup'][1]//div[@class='rt-td'][4]");
	public By lbSalary = By.xpath("//div[@class='rt-tbody']/div[@role='rowgroup'][1]//div[@class='rt-td'][5]");
	public By lbDepartment = By.xpath("//div[@class='rt-tbody']/div[@role='rowgroup'][1]//div[@class='rt-td'][6]");

	public WebTablesPage(WebDriver driver) {
		super(driver);
	}

	public String searchBy(String searchText, String searchBy) {
//		addNewEmployee(firstName, lastName, email,age, salary, department);
		String result = "";
		testBase.inputText(txtSearch, searchText);
		switch (searchBy) {
		case "FirstName": {
			result = testBase.getTextByLocator(lbFirstName);
			break;
		}
		case "LastName":{
			result = testBase.getTextByLocator(lbLastName);
			break;
		}
		case "Email":{
			result = testBase.getTextByLocator(lbEmail);
			break;
		}
		case "Age":{
			result = testBase.getTextByLocator(lbLastName);
			break;
		}
		case "Salary":{
			result = testBase.getTextByLocator(lbLastName);
			break;
		}
		case "Department":{
			result = testBase.getTextByLocator(lbLastName);
			break;
		}
		default:
			result = "";
		}

		return result;

	}

	public void addNewEmployee(String firstName, String lastName, String email, String age, String salary,
			String department) {
		testBase.clickOnElement(btnAdd);
		testBase.inputText(txtFirstName, firstName);
		testBase.inputText(txtLastName, lastName);
		testBase.inputText(txtEmail, email);
		testBase.inputText(txtAge, age);
		testBase.inputText(txtSalary, salary);
		testBase.inputText(txtDepartment, department);
		testBase.clickOnElement(btnSubmit);

	}
}
