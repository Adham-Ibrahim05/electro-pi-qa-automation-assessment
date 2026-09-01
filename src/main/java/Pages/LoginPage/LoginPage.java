package Pages.LoginPage;


import Utilities.GeneralUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final WebDriver driver;
    private final By UserName = By.id ("UserName");
    private final By Password = By.id ("Password");
    private final By LoginButton = By.id ("Login);");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage EnterUserName(String username)
    {
        GeneralUtility.SendData(driver,UserName,username);
        return this;
    }

    public LoginPage EnterPassword(String password)
    {
        GeneralUtility.SendData(driver,Password,password);
        return this;
    }

    public void ClickOnLoginButton()
    {
        GeneralUtility.Click_OnElement(driver,LoginButton);
    }

}
