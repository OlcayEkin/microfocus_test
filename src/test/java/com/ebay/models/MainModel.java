package com.ebay.models;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainModel {

    @FindBy(how = How.CSS, using = "[href*='SignIn']")
    public WebElement LOGIN;

    @FindBy(how = How.CSS, using = "[name='userid']")
    public WebElement LOGIN_USERNAME;

    @FindBy(how = How.CSS, using = "[type='password']")
    public WebElement LOGIN_PASS;

    @FindBy(how = How.ID, using = "sgnBt")
    public WebElement LOGIN_SUBMIT;

    @FindBy(how = How.CSS, using = "[href*='PartialReg']")
    public WebElement REGISTER;

    @FindBy(how = How.ID, using = "firstname")
    public WebElement REGISTER_FIRSTNAME;

    @FindBy(how = How.ID, using = "lastname")
    public WebElement REGISTER_LASTNAME;

    @FindBy(how = How.ID, using = "email")
    public WebElement REGISTER_EMAIL;

    @FindBy(how = How.ID, using = "PASSWORD")
    public WebElement REGISTER_PASSWORD;

    @FindBy(how = How.ID, using = "ppaFormSbtBtn")
    public WebElement REGISTER_SUBMIT;

    @FindBy(how = How.ID, using = "carousel-status-s0-0-3_1-0-2[0]-1-match-media-0-ebay-carousel")
    public WebElement MAINPAGE_CAROUSEL;

    @FindBy(how=How.ID, using = "gh-cart-i")
    public WebElement MAINPAGE_CART;

    @FindBy(how=How.ID, using = "gh-cart-n")
    public WebElement MAINPAGE_CART_COUNT;

    @FindBy(how = How.CSS, using = "[data-test-id='main-title']")
    public WebElement CART_TITLE;
}
