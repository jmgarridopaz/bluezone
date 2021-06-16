Feature: Issue permit

  AS
  a car driver
  
  I WANT TO
  get a permit for parking the car at a regulated area until a certain date-time paying with a card
  
  SO THAT
  I can park the car without being fined


@hardCodedHexagon
Scenario: Hardcoded permit

Given current date time is "2020/04/22 08:00"

When I do the following permit issuing request:
| carPlate | rateName   | endingDateTime   | paymentCardNumber | paymentCardCvv | paymentCardExpirationDate |
| 0000AAA  | GREEN_ZONE | 2020/04/22 10:00 | 1234567890123456  | 123            | 2025/06                   |

Then I should get the following permit ticket:
| code                     | carPlate | startingDateTime | endingDateTime   | rateName   | priceAmount | priceCurrencySymbol |
| PT-2020-000000000-161760 | 0000AAA  | 2020/04/22 08:00 | 2020/04/22 10:00 | GREEN_ZONE | 1.30        | €                   |


#Scenario: Successful permit
#
#Given there exist this rate
#
#| name     | costPerHourAmount | costPerHourCurrencySymbol | minMinutesAllowed | maxMinutesAllowed | monday      | tuesday     | wednesday   | thursday    | friday      | saturday    | sunday      |
#| RED_ZONE | 0.50              | €                         | 60                | 480               | 00:00-23:59 | 00:00-23:59 | 00:00-23:59 | 00:00-23:59 | 00:00-23:59 | 00:00-23:59 | 00:00-23:59 |
#
#And 
#
#current date time is "2020/04/22 08:00"
#
#When I do the following permit issuing request:
#| carPlate | rateName   | endingDateTime   | paymentCardNumber | paymentCardCvv | paymentCardExpirationDate |
#| 0000AAA  | GREEN_ZONE | 2020/04/22 10:00 | 1234567890123456  | 123            | 2025/06                   |
#
#Then I should get the following permit ticket:
#| code                     | carPlate | startingDateTime | endingDateTime   | rateName   | priceAmount | priceCurrencySymbol |
#| PT-2020-000000000-161760 | 0000AAA  | 2020/04/22 08:00 | 2020/04/22 10:00 | GREEN_ZONE | 1.30        | €                   |
