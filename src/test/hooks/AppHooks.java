package hooks;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;

import java.util.Properties;

public class AppHooks {

    private DriverFactory driverFactory;
    private WebDriver driver;
    private ConfigReader configReader;
    Properties prop;

    @Before
    public void setup(){
        configReader = new ConfigReader();
        prop= configReader.initProperties();
        String browser = prop.getProperty("browser");
        driverFactory = new DriverFactory();
        driver = driverFactory.initDriver(browser);
    }
    /*@After
    public void teardown(){
        driver.quit();
    }*/
}