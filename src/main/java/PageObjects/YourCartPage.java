package PageObjects;

import Utilities.SeleniumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class YourCartPage {

    SeleniumDriver driverActions = new SeleniumDriver();
    By itemsInCart = By.xpath("//div[@class='inventory_item_name']");


    public boolean VerifyItemsInCart(List<String> itemName) {

        for (int i = 0; i<itemName.size();i++){
            if (driverActions.ListOfElements(itemsInCart).get(i).getText().equals(itemName.get(i))){
                System.out.println("Item found " +itemName.get(i));
            }else {
                return false;
            }
        }
        return true;
    }
}
