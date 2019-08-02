package com.ebay.hook;

import com.ebay.pages.EbayPage;
import com.ebay.pages.MainPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

interface BaseMethodInterface {
    MainPage mainPage ();

    EbayPage ebayPage ();

    WebElement findElement (WebElement element);

    List<WebElement> findElements (List<WebElement> element);

    void clickElement (WebElement element);

    void sendInputKey (WebElement element, String input);

    void sendKey (WebElement element, Keys keyEvent);

    String getPageSource ();
}
