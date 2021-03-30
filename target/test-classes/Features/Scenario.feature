
Feature: MailChimp
  Try to start a new account on Mailchimp.

  @mytag

  Scenario Outline:Sign up
    Given I want to add my email "<email>"
    Given I also want to set an username "<username>"
    And  I want to set a Password "<password>"
    When I press signup
    Then The "<result>" mail should be on the confirm page.
    Examples:
      | email | username | password | result |
      | jst@fun.com | jstfun | H4rdP@ssW0rd | jst@fun.com |