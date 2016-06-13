Feature: Client friendliness
  As an API client
  I want a well documented, stable API
  So that I can easily code against it

  Scenario Outline: Consumer-driven contracts
    Given a sample contract that performs a <verb> against <endpoint>
    When I exercise that action
    Then I receive the adequate response with http status <status>
  Examples:
    | verb | endpoint | status |
    | GET  | bands    | 200    |
    | POST | bands    | 201    |