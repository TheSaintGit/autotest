
Feature: MailChimp
  Try to start a new account on Mailchimp.

  @mytag

  Scenario Outline:Sign up
    Given I want to add my email "<email>"
    Given I also want to set an username "<username>"
    And  I want to set a Password "<password>"
    When I press signup
    Then When user is "<username>" then the "<result>" should be.
    Examples:
      | email             | username    | password     | result |
      | newuser@test.com  | randUser    | H4rdP@ssW0rd | Didn’t get an email? |
      | longuser@test.com | randUser100 | H4rdP@ssW0rd | Please check your entry and try again. |
      | olduser@test.com  | oldUser     | H4rdP@ssW0rd | Please check your entry and try again. |
      |                   | userName    | H4rdP@ssW0rd | Please check your entry and try again. |