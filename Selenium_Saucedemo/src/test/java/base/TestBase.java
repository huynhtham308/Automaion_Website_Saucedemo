package base;

import core.configuration.Configuration;
import core.driver.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
  protected   WebDriver _driver;

    private Configuration _configuration;
    @BeforeMethod
    public void setUp() {
        _configuration = new Configuration("app.properties");
        _driver = new DriverFactory().getDriver(_configuration.getProperty("browser"));
        _driver.get(_configuration.getProperty("url"));

    }
    @AfterMethod
    public void teardown() {
        _driver.quit();
    }
}
