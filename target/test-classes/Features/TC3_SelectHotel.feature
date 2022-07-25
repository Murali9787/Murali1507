@Select
Feature: Verifying Adactin Select Hotel details

  Background: 
    Given User is on Adactin hotel login page

  Scenario Outline: Verifying Adactin Hotel Login with valid credentials and Select a hotel.
    When User should perform login "<userName>", "<password>"
    Then User should verify after login page "Hello Muraligokul!"
    And User should perform Search Hotel by giving all required values "<Location>", "<Hotels>", "<Room Type>", "<Number of Rooms>", "<Check In Date>", "<Check Out Date>", "<Adult Per Room>" and "<Children Per Room>"
    Then User should verify after Search Hotel then its navigate to select hotel page "Select Hotel"
    And User should select the hotel and click continue button
    And User should verify after Select Hotel then its navigate to Book a Hotel "Book A Hotel"

    Examples: 
      | userName | password | Location | Hotels      | Room Type | Number of Rooms | Check In Date | Check Out Date | Adult Per Room | Children Per Room |
      | Muraligokul | 41Z9S4   | Sydney   | Hotel Creek | Standard  | 1 - One         | 03/07/2022    | 04/07/2022     | 1 - One        | 1 - One           |

  Scenario Outline: Verifying Adactin Hotel Login with valid credentials and Without Select hotel
    When User should perform login "<userName>", "<password>"
    Then User should verify after login page "Hello Muraligokul!"
    And User should perform Search Hotel by giving all required values "<Location>", "<Hotels>", "<Room Type>", "<Number of Rooms>", "<Check In Date>", "<Check Out Date>", "<Adult Per Room>" and "<Children Per Room>"
    Then User should verify after Search Hotel then its navigate to select hotel page "Select Hotel"
    And User should verify an error message by without selecting the hotel and click continue an error message contains "Please Select a Hotel"

    Examples: 
      | userName | password | Location | Hotels      | Room Type | Number of Rooms | Check In Date | Check Out Date | Adult Per Room | Children Per Room |
      | Muraligokul | 41Z9S4   | Sydney   | Hotel Creek | Standard  | 1 - One         | 03/07/2022    | 04/07/2022     | 1 - One        | 1 - One           |
