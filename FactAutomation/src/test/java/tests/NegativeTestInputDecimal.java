package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import custom_strings.Strings_errors;
import pages.HomePage;
import utils.BaseTest;
import utils.DriverWrapper;
import utils.Groups;

public class NegativeTestInputDecimal extends BaseTest {

	private HomePage homePage;

	@BeforeClass(alwaysRun = true)
	public void setup() {
		DriverWrapper.initializeDriver();
		DriverWrapper.openURL("http://qainterview.pythonanywhere.com/");
		homePage = new HomePage(DriverWrapper.driver, DriverWrapper.wait);
	}
	
	@Test(groups = {Groups.HEARTBEAT},description = "Verify that inputing decimal number into input field is displaying expected error ")
	public void validateStringInputError() {
		homePage.clickInputFieldAndEnterString("10.5")
				.clickCalculate()
				.validateFactorialResults(Strings_errors.EnterIntigerError);
	}
}
