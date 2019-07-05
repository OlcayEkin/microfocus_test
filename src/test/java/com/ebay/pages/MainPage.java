package com.ebay.pages;

import com.ebay.hook.BaseMethods;
import com.ebay.models.MainModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
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

    /**
     * Login to the Ebay
     * @param username
     * @param pass
     */
    public void login(String username, String pass){
        findElement(mainModel.LOGIN).click ();
        findElement (mainModel.LOGIN_USERNAME).sendKeys (username);
        findElement (mainModel.LOGIN_PASS).sendKeys (pass);
        findElement (mainModel.LOGIN_SUBMIT).click ();
        Assert.assertTrue ("Login process is not finished successfully",findElement (mainModel.MAINPAGE_CAROUSEL).isDisplayed ());
        log.info ("Logged in with user => "+username);
    }

    /**
     * Checking the login process successfully finished
     */
    public void isLogin(){
        Assert.assertTrue ("Login process is not finished successfully",findElement (mainModel.MAINPAGE_CAROUSEL).isDisplayed ());
    }

    /**
     * Register to the Ebay
     * @param firstName
     * @param lastName
     * @param email
     * @param pass
     */
    public void register(String firstName, String lastName, String email, String pass){
        findElement(mainModel.REGISTER).click ();
        findElement (mainModel.REGISTER_FIRSTNAME).sendKeys (firstName);
        findElement(mainModel.REGISTER_LASTNAME).sendKeys (lastName);
        findElement(mainModel.REGISTER_EMAIL).sendKeys (email);
        findElement(mainModel.REGISTER_PASSWORD).sendKeys (pass);
        findElement(mainModel.REGISTER_SUBMIT).click ();
        Assert.assertTrue ("Register process is not finished successfully",findElement (mainModel.MAINPAGE_CAROUSEL).isDisplayed ());
        log.info ("Register process is finished successfully");
    }

    /**
     * Checking the cart page is displayed
     */
    public void isCartDisplayed(){
        Assert.assertTrue ("Cart is not displayed",findElement (mainModel.MAINPAGE_CART).isDisplayed ());
        log.info ("Item count in cart from main menu = "+ mainModel.MAINPAGE_CART_COUNT.getText ());
    }

    /**
     * Checking the item count in the cart
     */
    public void checkCart(){
        String cartItemCount = mainModel.MAINPAGE_CART_COUNT.getText ();
        mainModel.MAINPAGE_CART.click ();
        String cartTitle = findElement (mainModel.CART_TITLE).getText ();
        Assert.assertTrue ("Cart count that is displaying in the main menu is not matching with actual shopping cart",cartTitle.contains (cartItemCount));
        log.info ("Item count in cart = "+cartTitle);

    }


}
