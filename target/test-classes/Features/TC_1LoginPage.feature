@Login
Feature: Verifying Adactin Hotel login details

  Background: 
    Given User is on Adactin hotel login page

  Scenario Outline: Verifying Adactin Hotel login with valid credentials
    Given User is on Adactin hotel login page
    When User should perform login "<userName>", "<password>"
    Then User should verify after login page "Hello Muraligokul!"

    Examples: 
      | userName | password |
      | Muraligokul | 41Z9S4   |

  Scenario Outline: Verifying Adactin Hotel login with valid credentials by using Enter Key
    When User should perform login by clicking Enter Key "<userName>", "<password>"
    Then User should verify after login page "Hello Muraligokul!"

    Examples: 
      | userName | password |
      | Muraligokul | 41Z9S4   |

  
  Scenario Outline: Verifying Adactin Hotel login with invalid credentials
    When User should perform login "<userName>", "<password>"
    Then User should verify error message after enter the invalid credentials an error message contains "Invalid Login details or Your Password might have expired"

    Examples: 
      | userName | password |
      | Muraligokul | W400L2   |
