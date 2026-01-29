package tests;

import org.testng.annotations.Test;

import pages.CheckBoxPage;
import pages.PracticeFormPage;

public class CheckBoxTest extends TestCase{
	
	@Test
	public void sumbitDataSuccessfully() {
		CheckBoxPage checkBoxPage = new CheckBoxPage(base.webDriver);
		base.webDriver.navigate().to("https://demoqa.com/checkbox");
		checkBoxPage.selectCheckBox() ;
	}
	

}
