Feature: TestingEmailSearch

  Scenario: Find User By Email
    Given The application is running
    When I make a search with a userEmail: "paschouale@hotmail.com"
    Then I get the User Details