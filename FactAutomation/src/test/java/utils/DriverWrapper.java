package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverWrapper {
	
	public static WebDriver driver;
	public static int defaultWaitTime = 10;
	public static WebDriverWait wait;

	public static WebDriver initializeDriver() {
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, defaultWaitTime);
		return driver;
	}

	public static void openURL(String URL) {
		driver.manage().window().maximize();
		driver.get(URL);
	}

	public static void closeBrowser() {
		driver.quit();
	}

}
