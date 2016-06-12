Feature: Client friendliness
  As an API client
  I want a well documented, stable API
  So that I can easily code against it

  Scenario Outline: Consumer-driven contracts
    Given a sample contract that performs a <verb> against <endpoint>
    When I exercise that action
    Then I receive the adequate response
  Examples:
    | verb | endpoint |
    | GET  | bands/  |
    | POST  | bands/  |