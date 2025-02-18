@with_account

Feature: Order with account

  Scenario: Order jacket

    Given I open the browser
    Then I validate that I am on homepage
    Then I Login
    Then I clear all cart items
    Then I navigate to jackets shopping page
    When I select the first jacket in the list
    Then I validate shopping cart details
    When I click proceed to checkout
    Then I fill Shipping page for loggedin user
    Then I place the order