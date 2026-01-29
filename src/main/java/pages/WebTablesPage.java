package pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebTablesPage extends Page {

	public By txtSearch = By.id("searchBox");
	public By fristName = By.xpath("//div[@class='rt-tr-group']//div[@class='rt-td'][1]");

	public WebTablesPage(WebDriver driver) {
		super(driver);
	}

	public void searchByFristName() {

//		List<WebElement> fristNames = dr.findElements(fristName);
//		for(WebElement webElement : fristNames) {
//			if(webElement.getText().equalsIgnoreCase(txtSearch))
//		}
		
	}
}
