Feature: Register to the Ebay
  As a normal user
  I want to register to the Ebay
  So that, I can start to use Ebay

  Scenario Outline: Register to the Ebay
    Given I navigate to the https://www.ebay.com/
    And I register to the with my <first name>, <last name>, <email> and <password>
    Then I see that I successfully registered the site


    Examples:
    |first name|last name|email|password|
    |User    |Name    |qfn47191@bcaoo.com|@123456User|
