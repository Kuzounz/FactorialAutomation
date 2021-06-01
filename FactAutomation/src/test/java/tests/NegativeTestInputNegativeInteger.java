package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import custom_strings.Strings_errors;
import pages.HomePage;
import utils.BaseTest;
import utils.DriverWrapper;
import utils.Groups;

public class NegativeTestInputNegativeInteger extends BaseTest {

	private HomePage homePage;

	@BeforeClass(alwaysRun = true)
	public void setup() {
		DriverWrapper.initializeDriver();
		DriverWrapper.openURL("http://qainterview.pythonanywhere.com/");
		homePage = new HomePage(DriverWrapper.driver, DriverWrapper.wait);
	}
	
	@Test(groups = {Groups.HEARTBEAT},description = "Verify that inputing negative number into input field is displaying expected error ")
	public void validateStringInputError() {
		homePage.clickInputFieldAndEnterInteger(-10)
				.clickCalculate()
				.validateFactorialResults(Strings_errors.EnterIntigerError);
	}
}
