@Cancel
Feature: Verifying Adactin hotel cancel page details

  Background: 
    Given User is on Adactin hotel login page

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
    And User should cancel the order Id
    And User should verify the cancelled message "The booking has been cancelled."

    Examples: 
      | userName | password | Location | Hotels      | Room Type | Number of Rooms | Check In Date | Check Out Date | Adult Per Room | Children Per Room | First Name | Last Name | Billing Address |
      | Muraligokul | 41Z9S4   | Sydney   | Hotel Creek | Standard  | 1 - One         | 03/07/2022    | 04/07/2022     | 1 - One        | 1 - One           | gokul      | ravi      | trichy          |

  @cancels
  Scenario Outline: Verifying Adactin Hotel Login with valid credentials and Search Hotel giving different datas
    When User should perform login "<userName>", "<password>"
    Then User should verify after login page "Hello Muraligokul!"
    And User should delete the existing order Id "<Orderno>"
    And User should verify the cancelled message "The booking has been cancelled."

    Examples: 
      | userName | password | Orderno    |
      | Muraligokul | 41Z9S4   | 402XR1636N |
