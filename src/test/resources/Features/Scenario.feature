
Feature: MailChimp
  Try to start a new account on Mailchimp.

  @mytag

  Scenario:Sign up
    Given I want to add my email.
    Given I also want to set an username
    And  I want to set a Password
    When I press signup
    Then The result should be that i see a confirm page.