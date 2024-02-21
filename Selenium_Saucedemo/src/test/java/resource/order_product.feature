Feature: Order product
  Scenario Outline: User should be able to order product
    Given I login with <userName> & <password>
    When I add product with name<productName> to card and navigation to card
    And  I complete checkout flow with <lastName> <firstName> <postalCode>
    Then I verify the order success message display
    Examples:
      |userName|password|productName|lastName|firstName|postalCode|
      |standard_user|secret_sauce|Sauce Labs Backpack|Tham|Huynh|2317|

