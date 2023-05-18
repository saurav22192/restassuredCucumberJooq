
Feature: SearchResults
  @SearchResults
Scenario: Validating the search results
Given User is on google home page
When User enters search keyword "Roses"
Then User should be navigated to search results page "Roses"