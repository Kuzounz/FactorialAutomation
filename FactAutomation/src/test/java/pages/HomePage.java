package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.FindBy;

import utils.BasePage;

public class HomePage extends BasePage {

	// Elements

	@FindBy(xpath = "//p//button[@type=\"submit\"]")
	private WebElement calculateButton;
	@FindBy(xpath = "//a[@href='/privacy']")
	private WebElement privacylink;
	@FindBy(xpath = "//p[@id='resultDiv']")
	private WebElement resulttext;
	@FindBy(xpath = "//a[@href='/terms']")
	private WebElement termslink;
	@FindBy(xpath = "//div/h1[@class=\"margin-base-vertical text-center\"]")
	private WebElement h1Title;
	@FindBy(xpath = "//input[@id=\"number\"]")
	private WebElement inputFieldempty;
	@FindBy(xpath = "//a[contains(@href,'source=qa')]")
	private WebElement qxF2serviceslink;
	@FindBy(xpath = "//p[@id='resultDiv']")
	private WebElement factresultdiv;

	// Constructor

	public HomePage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}

	// Methods

	public HomePage clickCalculate() {
		log.debug("clickCalculate();");
		waitForElement(calculateButton);
		clickOnElement(calculateButton);
		return new HomePage(driver,wait);
	}
	public HomePage validateHomePageTitleString(String pageTitleString) {
		log.debug("validateHomePageTitleString();");
		waitForElement(h1Title);
		Assert.assertTrue(
				"validatePageTitleString method failed due to string: \"" + h1Title.getText()
						+ "\" not matching expected string: \"" + pageTitleString + "\"",
				getTextFromElement(h1Title).toLowerCase().contains(pageTitleString.toLowerCase()));
		return new HomePage(driver, wait);
	}

	public HomePage validateHomePageCaculatebuttonString(String submitButtonString) {
		log.debug("validateHomePageCaculatebuttonString();");
		waitForElement(calculateButton);
		Assert.assertTrue(
				"validatePageCaculatebuttonString method failed due to string: \"" + calculateButton.getText()
						+ "\" not matching expected string: \"" + submitButtonString + "\"",
				getTextFromElement(calculateButton).toLowerCase().contains(submitButtonString.toLowerCase()));
		return new HomePage(driver, wait);
	}

	public HomePage validateHomePagePrivacyLinkString(String privacyLinkText) {
		log.debug("validateHomePagePrivacyLinkString();");
		waitForElement(privacylink);
		Assert.assertTrue(
				"ValidatePrivacyLinkString method failed due to string: \"" + privacylink.getText()
						+ "\" not matching expected string: \"" + privacyLinkText + "\"",
				getTextFromElement(privacylink).toLowerCase().contains(privacyLinkText.toLowerCase()));
		return new HomePage(driver, wait);
	}

	public HomePage validateHomePageTermsLinkString(String termsLinkText) {
		log.debug("validateHomePageTermsLinkString();");
		waitForElement(termslink);
		Assert.assertTrue(
				"validateTermsLinkString method failed due to string: \"" + termslink.getText()
						+ "\" not matching expected string: \"" + termsLinkText + "\"",
				getTextFromElement(termslink).toLowerCase().contains(termsLinkText.toLowerCase()));
		return new HomePage(driver, wait);
	}

	public HomePage validateHomePageqxFLinkString(String qxFLinkText) {
		log.debug("validateHomePageqxFLinkString();");
		waitForElement(qxF2serviceslink);
		Assert.assertTrue(
				"validateqxFLinkString method failed due to string: \"" + qxF2serviceslink.getText()
						+ "\" not matching expected string: \"" + qxFLinkText + "\"",
				getTextFromElement(qxF2serviceslink).toLowerCase().contains(qxFLinkText.toLowerCase()));
		return new HomePage(driver, wait);
	}

	public HomePage clickInputFieldAndEnterInteger(int inputNumber) {
		log.debug("clickInputFieldAndEnterInteger();");
		enterText(inputFieldempty, String.valueOf(inputNumber));
		return new HomePage(driver, wait);
	}

	public HomePage clickInputFieldAndEnterString(String inputString) {
		//log.debug("clickInputFieldAndEnterString();");
		enterText(inputFieldempty, inputString);
		return new HomePage(driver, wait);
	}

	public HomePage validateFactorialResults(String factorialResults) {
		//log.debug("validateFactorialResults();");
		waitForElement(factresultdiv);
		Assert.assertTrue(
				"validateFactorialResults method failed due to: \"" + factresultdiv.getText()
						+ "\" not matching expected: \"" + factorialResults + "\"",
				getTextFromElement(factresultdiv).toLowerCase().contains(factorialResults.toLowerCase()));
		return new HomePage(driver, wait);
	}

}
