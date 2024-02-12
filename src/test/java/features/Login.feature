Feature: Web Katalon-demo-cura Test

  Scenario: Login should be success
    Given User navigate to the web Web Katalon-demo-cura
    And User click on the make appointment button
    And User enter the username 
    And User enter the password 
    When User click on the login button
    Then Login should be success

  Scenario: Login should not be success
    Given User navigate to the web Web Katalon-demo-cura
    And User click on the make appointment button
    And User enter the username 
    And User enter the password 
    When User click on the login button
    But Login should fail
