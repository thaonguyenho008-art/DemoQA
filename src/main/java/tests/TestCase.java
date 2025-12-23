package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import common.TestBase;

public class TestCase {
 public TestBase base = new TestBase();
	@BeforeTest
	public void openWeb() {
		String url = "http://demoqa.com";
		String browser ="chrome";
		base.openSingleBrowser(url, browser);
	}
}
