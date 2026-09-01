package Pages.LoginPage;


import Utilities.GeneralUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {
    private final WebDriver driver;
    private final By InventoryModule = By.id ("Module");
    private final By ProductName = By.id ("Product Name");
    private final By Price = By.id ("Price");
    private final By SaveButton = By.id ("save");
    private final By Assertion = By.xpath ("//div[@role='state']");


    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public InventoryPage NavigateToInventoryPage(){
        GeneralUtility.Click_OnElement(driver,InventoryModule);
        return this;
    }

    public InventoryPage AddProduct(String Productname , String price){
        GeneralUtility.SendData(driver,ProductName, Productname);
        GeneralUtility.SendData(driver,Price,price);
        GeneralUtility.Click_OnElement(driver,SaveButton);
        return this;
    }

    public boolean isAssertionMessageDisplayed(String Expected)
    {
        return GeneralUtility.GetText(driver, Assertion).equals(Expected);
    }


}