package com.ebay.hook;

import com.ebay.pages.EbayPage;
import com.ebay.pages.MainPage;
import org.openqa.selenium.WebElement;

interface BaseMethodInterface {
    MainPage mainPage ();

    EbayPage ebayPage ();

    WebElement findElement (WebElement element);
}
