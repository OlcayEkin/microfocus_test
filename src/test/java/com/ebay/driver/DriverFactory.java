package com.ebay.driver;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

import static org.apache.logging.log4j.LogManager.getLogger;

public class DriverFactory implements DriverFactoryInterface{

        private static final Logger log    = getLogger (DriverFactory.class);
        private RemoteWebDriver driver;
        public DriverFactory(RemoteWebDriver driver){
            super();
            this.driver = driver;
        }

        @Override
        public RemoteWebDriver setRemoteWebDriver (String scenario){
            ChromeOptions options = new ChromeOptions();
            options.setCapability (CapabilityType.BROWSER_NAME, "chrome");
            options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
            options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
            options.setCapability(CapabilityType.VERSION,"latest");
            options.setCapability("enableVNC", true);
            options.setCapability("enableVideo", false);
            options.setCapability("name", scenario);
            try {
                driver = new RemoteWebDriver (new URL ("http://grid.test.fxclub.org:4444/wd/hub"), options);
                return driver;
            } catch (MalformedURLException e){
                e.printStackTrace ();
            }
            return null;
        }

        @Override
        public ChromeDriver setChromeDriver (){
            ChromeOptions co = new ChromeOptions();
            Map<String, Object> prefs = new HashMap<> ();
            LoggingPreferences logPrefs = new LoggingPreferences();
            logPrefs.enable (LogType.BROWSER, Level.ALL);
            co.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
            co.setExperimentalOption("prefs", prefs);
            co.addArguments("--test-type");
            co.addArguments("--disable-popup-blocking");
            co.addArguments("--disable-save-password-bubble");
            co.addArguments("--ignore-certificate-errors");
            co.addArguments("--disable-translate");
            co.addArguments("--start-maximized");
            co.addArguments("--allow-silent-push");
            co.addArguments("--enable-automation");
            co.addArguments("--enable-javascript");
            System.setProperty("webdriver.chrome.driver", "properties/driver/chromedriver");
            driver = new ChromeDriver(co);
            return (ChromeDriver)driver;
        }

        @Override
        public FirefoxDriver setFirefoxDriver (){
            FirefoxProfile profile = new FirefoxProfile();
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            profile.setPreference("dom.ipc.plugins.enabled.libflashplayer.so", "false");
            firefoxOptions.setProfile(profile);
            firefoxOptions.setAcceptInsecureCerts(true);
            firefoxOptions.setCapability("marionette","true");
            System.setProperty("webdriver.gecko.driver","properties/driver/geckodriver");
            driver = new FirefoxDriver(firefoxOptions);
            return (FirefoxDriver)driver;
        }

        @Override
        public ChromeDriver setOperaDriver (){
            System.setProperty("webdriver.chrome.driver", "properties/driver/operadriver");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--headless", "window-size=1024,768", "--no-sandbox");
            options.addArguments("--single-process ");
            options.setExperimentalOption("useAutomationExtension", false);
            options.addArguments("--disable-gpu");
            options.setBinary (new File ("properties/driver/operadriver"));
            driver = new ChromeDriver(options);
            return (ChromeDriver)driver;
        }

        @Override
        public ChromeDriver setMobileBrowser (String device){
            Map<String, String> mobileEmulation = new HashMap<>();
            switch(device) {
                case ("android") -> {
                    log.info ("Device: " + device + " - Android");
                    mobileEmulation.put ("deviceName", "Nexus 5");
                }
                case ("ios") -> {
                    log.info ("Device: " + device + " - ios");
                    mobileEmulation.put ("deviceName", "iPhone X");
                }
            }
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
            System.setProperty("webdriver.chrome.driver", "properties/driver/chromedriver");
            driver = new ChromeDriver(chromeOptions);
            return (ChromeDriver)driver;
        }

        public RemoteWebDriver getDriver (){
            return driver;
        }
}
