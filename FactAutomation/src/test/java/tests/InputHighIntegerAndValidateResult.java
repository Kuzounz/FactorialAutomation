package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import custom_strings.Strings_english;
import pages.HomePage;
import utils.BaseTest;
import utils.DriverWrapper;
import utils.Groups;

public class InputHighIntegerAndValidateResult extends BaseTest {
	private HomePage homePage;

	@BeforeClass(alwaysRun = true)
	public void setup() {
		DriverWrapper.initializeDriver();
		DriverWrapper.openURL("http://qainterview.pythonanywhere.com/");
		homePage = new HomePage(DriverWrapper.driver, DriverWrapper.wait);
	}
	
	@Test(groups = {Groups.HEARTBEAT},description = "Verify that input of high Integer 1000 is matching expected result")
	public void validateHighIntegerAndResult() {
		homePage.clickInputFieldAndEnterInteger(1000)
				.clickCalculate()
				.validateFactorialResults(Strings_english.FACTORIALRESULTFROM1000);
	}


}
