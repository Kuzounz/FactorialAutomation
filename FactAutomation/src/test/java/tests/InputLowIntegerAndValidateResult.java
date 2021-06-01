package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import custom_strings.Strings_english;
import pages.HomePage;
import utils.BaseTest;
import utils.DriverWrapper;
import utils.Groups;

public class InputLowIntegerAndValidateResult extends BaseTest {
	
	private HomePage homePage;

	@BeforeClass(alwaysRun = true)
	public void setup() {
		DriverWrapper.initializeDriver();
		DriverWrapper.openURL("http://qainterview.pythonanywhere.com/");
		homePage = new HomePage(DriverWrapper.driver, DriverWrapper.wait);
	}
	
	@Test(groups = {Groups.HEARTBEAT},description = "Verify that input of Low Integer 0 is matching expected result")
	public void validateLowIntegerAndResult() {
		homePage.clickInputFieldAndEnterInteger(0)
				.clickCalculate()
				.validateFactorialResults(Strings_english.FACTORIALRESULTFROM1);
	}



}
