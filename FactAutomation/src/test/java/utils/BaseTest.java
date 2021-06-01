package utils;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class BaseTest {
	 protected WebDriver driver;

	@AfterClass(alwaysRun = true)
    public void tearDown() {
          DriverWrapper.driver.quit();    
	}

}
