Feature: Ebay Shopping Testing
  As a Ebay user
  I want to purchase something
  So that, I can use Ebay

   Background: Login
     Given I navigate to the https://www.ebay.com/
     And I want to login with qfn47191@bcaoo.com and @123456User

     Scenario: Search Product
       And I search NINTENDO SWITCH from the main page
       Then I check the result is correct for the product

     Scenario: Add to cart
        And I search NINTENDO SWITCH from the main page
        When I check the result is correct for the product
        And I choose first product from the list
        When I see the product page
        And I add 1 product to the cart

     Scenario: Check the cart
        When I see the main page
        Then I check there is some product in the cart
