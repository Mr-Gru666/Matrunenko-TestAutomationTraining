Feature: Google Search

  Scenario: User searches for Selenide in Google
    Given the user opens Google homepage
    When the user searches for "Selenide"
    Then the search results should contain "selenide.org"
