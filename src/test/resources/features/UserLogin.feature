@UserLogin
Feature: Dietician API Login

  @Login_valid
  Scenario:  Verify Login valid functionality
    Given "User" creates request with "<Body>"
    When "User" call "POST" Request with "userLogin"
    Then User receives 200 Status with response body

  @Login_Invalid
  Scenario Outline: Verify Login invalid functionality
    Given "User" creates request with "<Body>"
    When User call HTTPs method
    Then  User receives status

    Examples:
      | Body                         |
      | Login with invalid email id  |
      | Login with invalid password  |
      | Login with invalid endpoints |
      | Login with Invalid methods   |
      | Login with NULL body         |
