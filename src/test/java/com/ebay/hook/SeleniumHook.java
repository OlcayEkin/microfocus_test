package com.ebay.hook;

import com.ebay.driver.DriverFactory;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Date;

import static org.apache.logging.log4j.LogManager.getLogger;

public class SeleniumHook extends DriverFactory {


    private static          RemoteWebDriver driver;
    private static final Logger    log    = getLogger (SeleniumHook.class);

    public SeleniumHook(){
        super (driver);
    }

    public void setUpBrowser (String browser, String scenarioName) {
        driver = switch(browser){
            case "chrome" -> driver = setChromeDriver ();
            case "firefox" -> driver = setFirefoxDriver ();
            case "opera" -> driver = setOperaDriver ();
            case "android" -> driver = setMobileBrowser ("android");
            case "ios" -> driver = setMobileBrowser ("ios");
            case "remote" -> driver = setRemoteWebDriver (scenarioName);
            default -> throw new IllegalStateException ("Unexpected value: " + browser);
        };
    }

    WebDriverWait getWait (RemoteWebDriver driver){ return new WebDriverWait(driver,30); }

    public void tearDownTest(){
        try{
            LogEntries logEntries = getDriver ().manage().logs().get(LogType.BROWSER);
            logEntries.forEach (entry -> log.info("CONSOLE LOGS == > "+new Date(entry.getTimestamp()) + " " + entry.getLevel () + " " + entry.getMessage()));
        }catch (Exception e){
            e.printStackTrace ();
        }
        getDriver ().quit();
    }

}
