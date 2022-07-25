@Book
Feature: Verifying Adactin Book a Hotel page details

  Background: 
    Given User is on Adactin hotel login page

  @BookConfirm
  Scenario Outline: Verifying Adactin Hotel Login with valid credentials and Search Hotel giving different datas
    When User should perform login "<userName>", "<password>"
    Then User should verify after login page "Hello Muraligokul!"
    And User should perform Search Hotel by giving all required values "<Location>", "<Hotels>", "<Room Type>", "<Number of Rooms>", "<Check In Date>", "<Check Out Date>", "<Adult Per Room>" and "<Children Per Room>"
    Then User should verify after Search Hotel then its navigate to select hotel page "Select Hotel"
    And User should select the hotel and click continue button
    And User should verify after Select Hotel then its navigate to Book a Hotel "Book A Hotel"
    And User should book a hotel by entering the credentials "<First Name>", "<Last Name>" and "<Billing Address>"
      | Credit Card No   | Credit Card Type | Expiry Month | Expiry Year | CVV number |
      | 1234567891234567 | VISA             | September    |        2022 |       1234 |
      | 1234567891234567 | Master Card      | March        |        2022 |       1235 |
      | 1234567891234567 | American Express | June         |        2022 |       1434 |
      | 1234567891234567 | Other            | July         |        2022 |       1734 |
    Then User should verify after book a hotel then its navigate to Book Confirmation "Booking Confirmation"

    Examples: 
      | userName | password | Location | Hotels      | Room Type | Number of Rooms | Check In Date | Check Out Date | Adult Per Room | Children Per Room | First Name | Last Name | Billing Address |
      | Muraligokul | 41Z9S4   | Sydney   | Hotel Creek | Standard  | 1 - One         | 03/07/2022    | 04/07/2022     | 1 - One        | 1 - One           | gokul      | ravi      | trichy          |

  @Credentials
  Scenario Outline: Verifying Adactin Hotel Login with valid credentials and getting error message
    When User should perform login "<userName>", "<password>"
    Then User should verify after login page "Hello Muraligokul!"
    And User should perform Search Hotel by giving all required values "<Location>", "<Hotels>", "<Room Type>", "<Number of Rooms>", "<Check In Date>", "<Check Out Date>", "<Adult Per Room>" and "<Children Per Room>"
    Then User should verify after Search Hotel then its navigate to select hotel page "Select Hotel"
    And User should select the hotel and click continue button
    And User should verify after Select Hotel then its navigate to Book a Hotel "Book A Hotel"
    And User should not any credentials in book confirmation page and click book now
    Then user should verify an error message contains "Please Enter your First Name", "Please Enter you Last Name", "Please Enter your Address", "Please Enter your 16 Digit Credit Card Number", "Please Select your Credit Card Type", "Please Select your Credit Card Expiry Month", "Please Enter your Credit Card CVV Number"

    Examples: 
      | userName | password | Location | Hotels      | Room Type | Number of Rooms | Check In Date | Check Out Date | Adult Per Room | Children Per Room |
      | Muraligokul | 41Z9S4   | Sydney   | Hotel Creek | Standard  | 1 - One         | 03/07/2022    | 04/07/2022     | 1 - One        | 1 - One           |
