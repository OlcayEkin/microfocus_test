package com.ebay.hook;

import com.ebay.pages.EbayPage;
import com.ebay.pages.MainPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BaseMethods implements BaseMethodInterface{
    protected WebDriver driver;
    private WebDriverWait wait;

    public BaseMethods(){
        SeleniumHook hook = new SeleniumHook ();
        this.driver = hook.getDriver ();
        this.wait = hook.getWait ((RemoteWebDriver)driver);
    }

    @Override
    public MainPage mainPage (){
        return new MainPage ();
    }

    @Override
    public EbayPage ebayPage (){ return new EbayPage (); }

    @Override
    public WebElement findElement (WebElement element){ return wait.until (ExpectedConditions.visibilityOf (element)); }

    @Override
    public List<WebElement> findElements (List<WebElement> element){ return wait.until (ExpectedConditions.visibilityOfAllElements (element));}

    @Override
    public void clickElement (WebElement element){ findElement (element).click (); }

    @Override
    public void sendInputKey (WebElement element, String input){ findElement (element).sendKeys (input); }

    @Override
    public void sendKey (WebElement element, Keys keyEvent){ findElement (element).sendKeys (keyEvent); }

    @Override
    public String getPageSource (){ return driver.getPageSource ();}
}
