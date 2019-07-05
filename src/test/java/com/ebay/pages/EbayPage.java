package com.ebay.pages;

import com.ebay.hook.BaseMethods;
import com.ebay.models.EbayModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;

public class EbayPage extends BaseMethods {
    private static final Logger log   = LogManager.getLogger (MainPage.class);
    private EbayModel ebayModel = new EbayModel ();

    public EbayPage (){
        super ();
        PageFactory.initElements (driver,ebayModel);

    }

    /**
     * Searching the product from the main page
     * @param product
     */
    public void searchProduct(String product){
        findElement (ebayModel.SEARCH).sendKeys (product);
        findElement (ebayModel.SEARCH).sendKeys (Keys.ENTER);
    }

    /**
     * Checking the search result is exist
     */
    public void isResultExist(){
        Assert.assertTrue (findElement (ebayModel.SEARCH_RESULT).isDisplayed ());
        log.info (findElement (ebayModel.SEARCH_RESULT).getText ()+" are found");
    }

    /**
     * Choosing i th product from the list
     * @param i
     */
    public void chooseProduct (int i){ ebayModel.SEARCH_PRODUCT_LIST.get (i-1).click (); }

    /**
     * Checking the item page is loaded
     */
    public void isItemPage(){
        Assert.assertTrue ("Item page is not displayed",findElement (ebayModel.ITEM_TITLE).isDisplayed ());
        log.info ("ITEM => "+ebayModel.ITEM_TITLE.getText ());
    }

    /**
     * Adding the item with specific i amount to the cart
     * @param i
     */
    public void addItemToTheCart(int i){
        findElement (ebayModel.ITEM_QUANTITY).clear ();
        findElement (ebayModel.ITEM_QUANTITY).sendKeys (Integer.toString (i));
        findElement (ebayModel.ITEM_ADDTOCART).click ();
    }
}
