package PageObjects;

import Utilities.SeleniumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class YourCartPage {

    SeleniumDriver driverActions = new SeleniumDriver();
    By itemsInCart = By.xpath("//div[@class='inventory_item_name']");


    public boolean VerifyItemsInCart(String itemName) throws Exception {

        System.out.println(driverActions.GetText(itemsInCart).equals(itemName));
        if (driverActions.GetText(itemsInCart).equals(itemName)){
            System.out.println("Item found " +itemName);
        }else {
            return false;
        }
        return true;
    }
}
