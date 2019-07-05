package com.ebay.models;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class EbayModel {

    @FindBy( how = How.ID, using = "gh-ac")
    public WebElement SEARCH;

    @FindBy(how = How.CLASS_NAME, using = "srp-controls__count-heading")
    public WebElement SEARCH_RESULT;

    @FindBy(how = How.CSS, using = "[id*='srp-river-results-listing'] > div > div.s-item__info.clearfix > a")
    public List<WebElement> SEARCH_PRODUCT_LIST;

    @FindBy(how = How.ID, using = "itemTitle")
    public WebElement ITEM_TITLE;

    @FindBy(how = How.ID, using = "qtyTextBox")
    public WebElement ITEM_QUANTITY;

    @FindBy(how = How.ID, using = "isCartBtn_btn")
    public WebElement ITEM_ADDTOCART;
}
