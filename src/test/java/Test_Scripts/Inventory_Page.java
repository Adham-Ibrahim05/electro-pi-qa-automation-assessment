package Test_Scripts;


import Listeners.IInvokedMethodListenerClass;
import Listeners.ITestResultMethodListenerClass;
import Pages.LoginPage.InventoryPage;
import Pages.LoginPage.LoginPage;
import Test_Scripts.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static DriverFactory.Driver_Factory.GetDriver;

@Listeners({IInvokedMethodListenerClass.class, ITestResultMethodListenerClass.class})
public class Inventory_Page extends BaseTest{

    @Test
    public void CreateInventoryItem(){
        new LoginPage(GetDriver())
                .EnterUserName("User_Name")
                .EnterPassword("Password")
                .ClickOnLoginButton();

        InventoryPage inventoryPage = new InventoryPage(GetDriver());

        inventoryPage
                .NavigateToInventoryPage()
                .AddProduct("Product_Name", "Price");
        Assert.assertTrue(inventoryPage
                . isAssertionMessageDisplayed("Item has been created successfully"));
    }
}


