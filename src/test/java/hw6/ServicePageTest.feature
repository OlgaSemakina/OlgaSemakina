Feature: Service Page tests

  Scenario: Service Page Interface test
    Given I am on the Home Page
#    Then The browser title is Home Page
    When I login as user "epam" with password "1234"
#    Then The username PITER CHAILOVSKII is displayed in the right-top side of the screen
#    And Home page interface contains all needed elements
#    And Service dropdown contains options:
#      |Support|
#      |Dates|
#      |Complex Table|
#      |Simple Table|
#      |User Table|
#      |Table with pages|
#      |Different Elements|
#      |Performance|
#    And Service dropdown in left section contains options:
#      |Support|
#      |Dates|
#      |Complex Table|
#      |Simple Table|
#      |User Table|
#      |Table with pages|
#      |Different Elements|
#      |Performance|
    Given I am on the Different Elements page
#    Then Different elements page interface contains all needed elements
#    And There is Right Section
#    And There is Left Section
    When I select checkboxes:
          |Water|
          |Wind|