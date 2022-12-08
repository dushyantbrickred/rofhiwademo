package PageObjects;

import Utilities.SeleniumDriver;
import org.openqa.selenium.By;

public class SwagLabsInventoryPage {

    SeleniumDriver driverActions = new SeleniumDriver();
    By sortDropDown = By.cssSelector("Select[class='product_sort_container']");
    By inventoryItemName = By.xpath("(//div[@class ='inventory_item_name'])[1]");
    By addFirstItemButton = By.xpath("(//button[@class= 'btn btn_primary btn_small btn_inventory'])[1]");
    By cartIcon = By.xpath("//span[@class='shopping_cart_badge']");


    public void SortBy(String option) throws Exception {

        driverActions.SelectDropDownItemUsingSelector(sortDropDown,option);
    }

    public void AddInventoryItemToChat(){

        driverActions.Click(addFirstItemButton);
    }

    public String GetInventoryItemName(){

        return driverActions.GetText(inventoryItemName);
    }

    public void ClickOnCart()
    {
        driverActions.Click(cartIcon);
    }
}
