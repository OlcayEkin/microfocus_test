package com.ebay.steps;

import com.ebay.hook.BaseMethods;
import com.ebay.hook.SeleniumHook;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinition {

    private SeleniumHook hook;
    private BaseMethods baseMethods;

    /**
     * Setting browser and page elements
     */
    @Before
    public void setAll(){
        hook = new SeleniumHook ();
        hook.setUpSettings ("chrome");
        baseMethods = new BaseMethods ();
    }

    /**
     * Getting console logs and closing the browser
     */
    @After
    public void tearDown(){
        hook.tearDownTest ();
    }

    /**
     * Navigating specific page
     * @param url
     */
    @Given("I navigate to the (.*)")
    public void navigateToSite (String url){
            baseMethods.mainPage ().navigateTo (url);
        }

    /**
     * Register to Ebay
     * @param firstName
     * @param lastName
     * @param email
     * @param pass
     */
    @And("I register to the with my (.*), (.*), (.*) and (.*)")
    public void registerToEbay (String firstName, String lastName, String email, String pass){
        baseMethods.mainPage ().register (firstName,lastName,email,pass);
    }

    /**
     * Checking if the register process finished successfully
     */
    @Then("I see that I successfully registered the site")
    public void isRegistered (){
        baseMethods.mainPage ().isLogin ();
    }

    /**
     * Log in to Ebay
     * @param userName
     * @param pass
     */
    @And("I want to login with (.*) and (.*)")
    public void loginToEbay (String userName, String pass){ baseMethods.mainPage ().login (userName, pass); }

    /**
     * Choosing first product from the product list
     */
    @And("I choose first product from the list")
    public void chooseProduct (){ baseMethods.ebayPage ().chooseProduct (1); }

    /**
     * Checking the product page
     */
    @When("I see the product page")
    public void isProductPage (){ baseMethods.ebayPage ().isItemPage (); }

    /**
     * Adding i amount of item to the cart
     * @param i
     */
    @And ("I add (.*) product to the cart")
    public void addToCart (int i){ baseMethods.ebayPage ().addItemToTheCart (1); }

    /**
     * Searching product from main page's search panel
     * @param product
     */
    @And("I search (.*) from the main page")
    public void searchFromMainPage (String product){ baseMethods.ebayPage ().searchProduct (product); }

    /**
     * Controlling the result is correct for the product that searched before
     */
    @Then("I check the result is correct for the product")
    public void isResultCorrect (){ baseMethods.ebayPage ().isResultExist (); }

    /**
     * Controlling the main page
     */
    @When("I see the main page")
    public void isMainPage (){ baseMethods.mainPage ().isCartDisplayed (); }

    /**
     * Checking the cart is correctly filled up
     */
    @Then("I check there is some product in the cart")
    public void isCartCorrect (){ baseMethods.mainPage ().checkCart (); }
}
