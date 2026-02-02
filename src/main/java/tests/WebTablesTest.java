package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import common.Utils;
import pages.WebTablesPage;

public class WebTablesTest extends TestCase {
	@Test(dataProvider = "WebTablesData")
	public void searchSuccessfully(String firstName, String lastName, String email, String age, String salary,
			String department, String searchText, String searchBy) {
		WebTablesPage webTablesPage = new WebTablesPage(base.webDriver);
		base.webDriver.navigate().to("https://demoqa.com/webtables");
		webTablesPage.addNewEmployee(firstName, lastName, email, age, salary, department);
		String actualResult = webTablesPage.searchBy(searchText, searchBy);
		assertTrue(actualResult.contains(searchText));
	}

	@DataProvider(name = "WebTablesData")
	public String[][] createDataWebTables() {
		Utils utils = new Utils();
		String registrationFormFiles = "TestData_WebTables.csv";
		String[][] registrationFormData = utils.readDataFormCSV(registrationFormFiles);
		return registrationFormData;

	}

}
