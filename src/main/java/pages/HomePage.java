package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends Page {
	public By lblElements = By.xpath("//h5[text()='Elements']");

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public ElementsPage clickElementsPage() {
		dr.findElement(lblElements).click();
		return new ElementsPage(dr);
		
	}

}
