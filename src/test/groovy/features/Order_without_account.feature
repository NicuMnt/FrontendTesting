Feature: Order without account

  Scenario: Order jacket
    Given I open the browser
    Then I validate that I am on homepage
    Then I navigate to jackets shopping page
    When I select the first jacket in the list
    Then I validate shopping cart details
    When I click proceed to checkout

