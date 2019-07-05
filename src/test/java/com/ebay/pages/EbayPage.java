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

    public void searchProduct(String product){
        findElement (ebayModel.SEARCH).sendKeys (product);
        findElement (ebayModel.SEARCH).sendKeys (Keys.ENTER);
    }

    public void isResultExist(){
        Assert.assertTrue (findElement (ebayModel.SEARCH_RESULT).isDisplayed ());
        log.info (findElement (ebayModel.SEARCH_RESULT).getText ()+" are found");
    }

    public void chooseProduct (int i){
        ebayModel.SEARCH_PRODUCT_LIST.get (i-1).click ();
    }

    public void isItemPage(){
        Assert.assertTrue ("Item page is not displayed",findElement (ebayModel.ITEM_TITLE).isDisplayed ());
        log.info ("ITEM => "+ebayModel.ITEM_TITLE.getText ());
    }

    public void addItemToTheCart(int i){
        findElement (ebayModel.ITEM_QUANTITY).clear ();
        findElement (ebayModel.ITEM_QUANTITY).sendKeys (Integer.toString (i));
        findElement (ebayModel.ITEM_ADDTOCART).click ();
    }
}
