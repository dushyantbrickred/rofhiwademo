import PageObjects.LoginPage;
import PageObjects.SwagLabsInventoryPage;
import PageObjects.YourCartPage;
import Utilities.SeleniumDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class VerifyItemsInCartTest {

    SeleniumDriver seleniumDriver;
    LoginPage loginPage;
    SwagLabsInventoryPage swagLabsInventoryPage;
    YourCartPage yourCartPage;

    @BeforeMethod
    public void PrepareTest() throws IOException {

        seleniumDriver = new SeleniumDriver();
        seleniumDriver.SetupTest("https://www.saucedemo.com/");
        loginPage = new LoginPage();
        swagLabsInventoryPage = new SwagLabsInventoryPage();
        yourCartPage = new YourCartPage();


    }


    @Test
    public void VerifyItemsInCart() throws Exception {

        loginPage.Login("standard_user","secret_sauce");
        swagLabsInventoryPage.SortBy("Price (low to high)");
        swagLabsInventoryPage.AddInventoryItemToChat();
        String itemName = swagLabsInventoryPage.GetInventoryItemName();
        System.out.println(itemName);
        swagLabsInventoryPage.ClickOnCart();
        Assert.assertTrue(yourCartPage.VerifyItemsInCart(itemName));
       /* swagLabsInventoryPage.SortBy("Price (high to low)");
        swagLabsInventoryPage.AddInventoryItemToChat();
        String itemName = swagLabsInventoryPage.GetInventoryItemName();
        swagLabsInventoryPage.ClickOnCart();
        Assert.assertTrue(yourCartPage.VerifyItemsInCart(itemName));
        System.out.println(itemName);*/
        seleniumDriver.EndTest();

    }


}
