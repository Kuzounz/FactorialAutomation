package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.BaseTest;
import utils.DriverWrapper;
import utils.Groups;
import custom_strings.Strings_english;

public class NaviagateToHomePageAndValidateStrings extends BaseTest {

	private HomePage homePage;
	
	@BeforeClass(alwaysRun = true)
	public void setup() {
		DriverWrapper.initializeDriver();
		DriverWrapper.openURL("http://qainterview.pythonanywhere.com/");
		homePage = new HomePage(DriverWrapper.driver, DriverWrapper.wait);
	}
	
	@Test(groups = {Groups.HEARTBEAT},description = "Verify that all of the element Strings on the home page are matching expected Strings")
	public void validateElementsonHomePage() {
		homePage.validateHomePageTitleString(Strings_english.PAGE_TITLE_STRING)
				.validateHomePageCaculatebuttonString(Strings_english.PAGE_CALCULATE_BUTTON_STRING)
				.validateHomePagePrivacyLinkString(Strings_english.PAGE_PRIVACY)
				.validateHomePageTermsLinkString(Strings_english.PAGE_TERMSANDCONDITIONS)
				.validateHomePageqxFLinkString(Strings_english.PAGE_QXF2SERVICES);
	}
}
