package utils;



import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {

	protected WebDriver driver;
	//public final Logger log = LogManager.getLogger(this.getClass());
	public final Logger log = LogManager.getLogger(getClass());
	protected WebDriverWait wait;


	public BasePage(WebDriver driver, WebDriverWait wait) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.wait = wait;
	}

	protected void clickOnElement(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}

	protected void enterText(WebElement element, String text) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.sendKeys(text);
	}
	
	protected WebElement waitForElement(By by) {
        try {
            wait.until(ExpectedConditions.and(
                    ExpectedConditions.visibilityOfElementLocated(by),
                    ExpectedConditions.elementToBeClickable(by)
            ));
            return driver.findElement(by);
        } catch (StaleElementReferenceException e) {
        	log.debug("[WARNING] Stale element reference is caught while waiting for element: " + by.toString() + ". Waiting again...");
            wait.until(ExpectedConditions.and(
                    ExpectedConditions.visibilityOfElementLocated(by),
                    ExpectedConditions.elementToBeClickable(by)
            ));
            return driver.findElement(by);
        }
        }
        
        public Object waitUntilVisible(int timeOutInSeconds, WebElement webElement) {
            WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
            wait.until(ExpectedConditions.visibilityOf(webElement));
            return this;
    }
        protected WebElement waitForElement(WebElement element) {
            try {
                wait.until(ExpectedConditions.and(
                        ExpectedConditions.visibilityOf(element),
                        ExpectedConditions.elementToBeClickable(element)
                ));
                return element;
            } catch (StaleElementReferenceException e) {
            	log.debug("[WARNING] Stale element reference is caught while waiting for element: " + element + ". Waiting again...");
                wait.until(ExpectedConditions.and(
                        ExpectedConditions.visibilityOf(element),
                        ExpectedConditions.elementToBeClickable(element)
                ));
                return element;
            }
        }
        
        protected String getTextFromElement(WebElement element) {
            waitForElement(element);
            return element.getText();
        }

}
