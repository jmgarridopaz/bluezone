Feature: Issue permit

  AS
  a car driver
  
  I WANT TO
  get a permit for parking the car at a regulated area until a certain date-time paying with a card
  
  SO THAT
  I can park the car without being fined


@hardcoded
Scenario: Hardcoded permit

Given current date time is "2020/04/22 08:00"

When I do the following permit issuing request:
| carPlate | rateName   | endingDateTime   | paymentCardNumber | paymentCardCvv | paymentCardExpirationDate |
| 0000AAA  | GREEN_ZONE | 2020/04/22 10:00 | 1234567890123456  | 123            | 2025/06                   |

Then I should get the following permit ticket:
| code                       | carPlate | startingDateTime | endingDateTime   | rateName   | priceAmount | priceCurrencySymbol |
| PT/0000000000/202004220800 | 0000AAA  | 2020/04/22 08:00 | 2020/04/22 10:00 | GREEN_ZONE | 1.30        | €                   |
