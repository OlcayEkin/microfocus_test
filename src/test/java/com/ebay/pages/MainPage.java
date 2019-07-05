package com.ebay.pages;

import com.ebay.hook.BaseMethods;
import com.ebay.models.MainModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BaseMethods {
    private static final Logger log   = LogManager.getLogger (MainPage.class);
    private MainModel mainModel = new MainModel ();

    public MainPage (){
        super ();
        PageFactory.initElements (driver,mainModel);
    }

    /**
     * Navigating to the url
     * @param url
     */
    public void navigateTo(String url){
        driver.navigate ().to (url);
        log.info ("Navigating to the "+url);
    }

    public void login(String username, String pass){
        findElement(mainModel.LOGIN).click ();
        findElement (mainModel.LOGIN_USERNAME).sendKeys (username);
        findElement (mainModel.LOGIN_PASS).sendKeys (pass);
        findElement (mainModel.LOGIN_SUBMIT).click ();
        Assert.assertTrue ("Login process is not finished successfully",waitPage ().isDisplayed ());
        log.info ("Logged in with user => "+username);
    }

    public void register(String firstName, String lastName, String email, String pass){
        findElement(mainModel.REGISTER).click ();
        findElement (mainModel.REGISTER_FIRSTNAME).sendKeys (firstName);
        findElement(mainModel.REGISTER_LASTNAME).sendKeys (lastName);
        findElement(mainModel.REGISTER_EMAIL).sendKeys (email);
        findElement(mainModel.REGISTER_PASSWORD).sendKeys (pass);
        findElement(mainModel.REGISTER_SUBMIT).click ();
        Assert.assertTrue ("Register process is not finished successfully",waitPage ().isDisplayed ());
        log.info ("Register process is finished successfully");
    }

    public void isCartDisplayed(){
        Assert.assertTrue ("Cart is not displayed",findElement (mainModel.MAINPAGE_CART).isDisplayed ());
        log.info ("Item count in cart from main menu = "+ mainModel.MAINPAGE_CART_COUNT.getText ());
    }

    public void checkCart(){
        String cartItemCount = mainModel.MAINPAGE_CART_COUNT.getText ();
        mainModel.MAINPAGE_CART.click ();
        String cartTitle = findElement (mainModel.CART_TITLE).getText ();
        Assert.assertTrue ("Cart count that is displaying in the main menu is not matching with actual shopping cart",cartTitle.contains (cartItemCount));
        log.info ("Item count in cart = "+cartTitle);

    }

    public WebElement waitPage(){
        return findElement(mainModel.MAINPAGE_CAROUSEL);
    }

}