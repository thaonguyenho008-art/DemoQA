package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ElementsPage extends Page{
    public By lblTextBox = By.xpath("//span[text()='Text Box']");
	public ElementsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public TextBoxPage TextBoxPage() {
		dr.findElement(lblTextBox).click();
		return new TextBoxPage(dr);
		
	}

}
