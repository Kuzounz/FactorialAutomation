package tests;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.BaseTest;
import utils.DriverWrapper;
import utils.Groups;
import custom_strings.Strings_english;

public class InputHappyPathIntegerAndValidateResult extends BaseTest {
	private HomePage homePage;

	@BeforeClass(alwaysRun = true)
	public void setup() {
		DriverWrapper.initializeDriver();
		DriverWrapper.openURL("http://qainterview.pythonanywhere.com/");
		homePage = new HomePage(DriverWrapper.driver, DriverWrapper.wait);
	}
	
	@Test(groups = {Groups.HEARTBEAT},description = "Verify that Happy path with integer 10 is matching expected result")
	public void validateHappyPathIntegerAndResult() {
		homePage.clickInputFieldAndEnterInteger(10)
				.clickCalculate()
				.validateFactorialResults(Strings_english.FACTORIALRESULTFROM10);
	}

}
