package Utilities;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;


public class SeleniumDriver {


    public SeleniumDriver(){

    }

    public static WebDriver driver;
    private static WebDriverWait webDriverWait;

    public final static int TIMEOUT = 120;
    public final static int PAGE_LOAD_TIMEOUT = 120;
    private WebDriverWait wait;
    JavascriptExecutor js;

    public void SetupTest(String url) throws IOException {

        BrowserConfig();
        driver.manage().window().maximize();
        webDriverWait = new WebDriverWait(driver,TIMEOUT);
        driver.manage().timeouts().implicitlyWait(TIMEOUT,TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
        js = (JavascriptExecutor) driver;
        OpenPage(url);
    }

    private void BrowserConfig() throws IOException {


        String driverPath = "Drivers/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
    }

    public void OpenPage(String url){
        driver.get(url);
    }

    public void EndTest(){

        if (driver!=null){

            driver.quit();
            driver = null;
        }

    }

    //Actions Section
    public void Click(By locator) {

        WaitForElementToBeClickable(locator);
        driver.findElement(locator).click();
    }



    public void SelectDropDownItemUsingSelector(By locator, String optionText) throws Exception {


        WaitForElementToBeClickable(locator);
        Select dropDownOptions = new Select(driver.findElement(locator));
        dropDownOptions.selectByVisibleText(optionText);
    }



    public void SendKeys(By locator, String text, String stepInfo) throws Exception {

        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);

    }



    public List<WebElement> ListOfElements(By locator) {

        List<WebElement> listOfElements = driver.findElements(locator);
        return  listOfElements;


    }

    public void WaitForElementToBeClickable(By locator)  {

        try{
            wait = new WebDriverWait(driver,30);
            wait.until(ExpectedConditions.elementToBeClickable (locator));
        }
        catch (Exception ignored){
        }
    }

    public String GetText(By locator){

        WaitForElementToBeClickable(locator);
        return driver.findElement(locator).getText();

    }

}
