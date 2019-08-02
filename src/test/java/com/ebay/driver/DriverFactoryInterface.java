package com.ebay.driver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

interface DriverFactoryInterface {
    RemoteWebDriver setRemoteWebDriver (String scenario);

    ChromeDriver setChromeDriver ();

    FirefoxDriver setFirefoxDriver ();

    ChromeDriver setOperaDriver ();

    ChromeDriver setMobileBrowser (String device);
}
