@Search
Feature: Verifying Adactin Search Hotel details

 Background: 
    Given User is on Adactin hotel login page

  Scenario Outline: Verifying Adactin Hotel Login with valid credentials and Search Hotel giving different datas
    Given User is on Adactin hotel login page
    When User should perform login "<userName>", "<password>"
    Then User should verify after login page "Hello Muraligokul!"
    And User should perform Search Hotel by giving all required values "<Location>", "<Hotels>", "<Room Type>", "<Number of Rooms>", "<Check In Date>", "<Check Out Date>", "<Adult Per Room>" and "<Children Per Room>"
    Then User should verify after Search Hotel it navigate to select hotel page "Select Hotel"

    Examples: 
      | userName | password | Location | Hotels      | Room Type | Number of Rooms | Check In Date | Check Out Date | Adult Per Room | Children Per Room |
      | Muraligokul | 41Z9S4   | Sydney   | Hotel Creek | Standard  | 1 - One         | 03/07/2022    | 04/07/2022     | 1 - One        | 1 - One           |

  Scenario Outline: Verifying Adactin Hotel login with valid credentials and Search Hotel page is execute while filling only mandatory fields
    Given User is on Adactin hotel login page
    When User should perform login "<userName>", "<password>"
    Then User should verify after login page "Hello Muraligokul!"
    And User should perform Search Hotel by giving only mandatory values "<Location>", "<Number of Rooms>", "<Check In Date>", "<Check Out Date>" and "<Adult Per Room>"
    Then User should verify after Search Hotel it navigate to select hotel page "Select Hotel"

    Examples: 
      | userName | password | Location | Number of Rooms | Check In Date | Check Out Date | Adult Per Room |
      | Muraligokul | 41Z9S4   | Sydney   | 1 - One         | 03/07/2022    | 04/07/2022     | 1 - One        |

  Scenario Outline: Verifying Adactin Hotel login with valid credentials and getting error message in date fields Adactin Search Hotel page
    Given User is on Adactin hotel login page
    When User should perform login "<userName>", "<password>"
    Then User should verify after login page "Hello Muraligokul!"
    And User should perform Search Hotel details  "<Location>", "<Hotels>", "<Room Type>", "<Number of Rooms>", "<Check In Date>", "<Check Out Date>" and "<Adult Per Room>"
    Then User should verify error message after clicking search an error message in date field it contains "Check-In Date shall be before than Check-Out Date", "Check-Out Date shall be after than Check-In Date"

    Examples: 
      | userName | password | Location | Hotels      | Room Type | Number of Rooms | Check In Date | Check Out Date | Adult Per Room | Children Per Room |
      | Muraligokul | 41Z9S4   | Sydney   | Hotel Creek | Standard  | 1 - One         | 03/07/2023    | 04/07/2022     | 1 - One        | 1 - One           |

  Scenario Outline: Verifying Adactin Hotel login with valid credentials and getting error message in location field without enter any fields in Adactin Hotel Page
    Given User is on Adactin hotel login page
    When User should perform login "<userName>", "<password>"
    Then User should verify after login page "Hello Muraligokul!"
    And User should perform Search Hotel without enter any fields and verify an error message in location field it contains "Please Select a Location"

    Examples: 
      | userName | password |
      | Muraligokul | 41Z9S4   |
