package com.ebay.hook;

import com.ebay.pages.EbayPage;
import com.ebay.pages.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseMethods implements BaseMethodInterface{
    protected WebDriver driver;
    private WebDriverWait wait;

    public BaseMethods(){
        SeleniumHook hook = new SeleniumHook ();
        this.driver = hook.getDriver ();
        this.wait = hook.getWait (driver);
    }

    @Override
    public MainPage mainPage (){
        return new MainPage ();
    }

    @Override
    public EbayPage ebayPage (){
        return new EbayPage ();
    }

    @Override
    public WebElement findElement (WebElement element){
        return wait.until (ExpectedConditions.visibilityOf (element));
    }
}
