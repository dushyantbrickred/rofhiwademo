package PageObjects;

import Utilities.SeleniumDriver;
import org.openqa.selenium.By;

public class LoginPage {

    SeleniumDriver driverActions = new SeleniumDriver();
    By userNameFieldField = By.id("user-name");
    By passwordField = By.id("password");
    By loginButton = By.id("login-button");

    public void Login(String userName, String password) throws Exception {

        driverActions.SendKeys(userNameFieldField,userName,"Enter the user name as: "+userName);
        driverActions.SendKeys(passwordField,password,"Enter the password as");
        driverActions.Click(loginButton);
    }
}
