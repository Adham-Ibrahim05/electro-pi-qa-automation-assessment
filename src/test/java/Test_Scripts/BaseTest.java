package Test_Scripts;

import Listeners.IInvokedMethodListenerClass;
import Listeners.ITestResultMethodListenerClass;
import Utilities.LogsUtility;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

import static DriverFactory.Driver_Factory.*;
import static Utilities.DataUtility.GetJsonData;
import static Utilities.DataUtility.GetPropertiesDataFromFile;

@Listeners({IInvokedMethodListenerClass.class, ITestResultMethodListenerClass.class})
public class BaseTest {

    protected String UserName = GetJsonData("Login","username");
    protected String Password = GetJsonData("Login","password");

    @Parameters({"browser"})
    @BeforeClass
    public void Setup(@Optional String browser)
    {

        // If browser is not provided in XML, fallback to environment.properties
        if(browser == null || browser.isEmpty()){
            browser = GetPropertiesDataFromFile("environment","Browser");
        }

        // Initialize the browser
        SetupDriver(browser);
        LogsUtility.LoggerInfo("Browser is Opened");

        //Start use the driver
        GetDriver().get(GetPropertiesDataFromFile("environment","Login_URL"));
        LogsUtility.LoggerInfo("Page is redirecting to the URL");

        new WebDriverWait(GetDriver(), Duration.ofSeconds(15))
                .until(ExpectedConditions.urlContains("login"));
    }

    @AfterClass
    public void Quit()
    {
        QuitDriver();
    }
}
