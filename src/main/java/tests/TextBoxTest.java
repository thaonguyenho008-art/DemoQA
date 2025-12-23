package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.HomePage;
import pages.TextBoxPage;

public class TextBoxTest extends TestCase {
	public static void submitDataSuccesfully() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\Automation\\03Project\\01Git\\DemoQA\\driver\\chromedriver.exe");
		WebDriver webDriver = new ChromeDriver();
		webDriver.get("http://demoqa.com");
		
		TextBoxPage boxPage = new TextBoxPage(webDriver);
		String fullName = "Ho Thao Nguyen";
		String email = "thaonguyen1108@gmail.com";
		String currentAddress ="Ha Noi";
		String permanentAddress="Nghe An";
		
		boxPage.inputFullName(fullName);
		boxPage.inputEmail(email);
		boxPage.inputCurrentAddress(currentAddress);
		boxPage.inputPermanentAddress(permanentAddress);
		
		boxPage.clickSubmit();

		
	}
	

}
