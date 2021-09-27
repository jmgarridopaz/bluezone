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
| code                     | carPlate | startingDateTime | endingDateTime   | rateName   | priceAmount | priceCurrencyCode |
| PT0000000000202004220800 | 0000AAA  | 2020/04/22 08:00 | 2020/04/22 10:00 | GREEN_ZONE | 1.30        | EUR               |



Scenario: With 24x7 rate

Given current date time is "2021/07/26 08:00"

And there exist this rate
| name     | costPerHourAmount | costPerHourCurrencyCode | minMinutesAllowed | maxMinutesAllowed | monday | tuesday | wednesday | thursday | friday | saturday | sunday |
| RED_ZONE | 0.50              | EUR                     | 60                | 480               | 00:00  | 00:00   | 00:00     | 00:00    | 00:00  | 00:00    | 00:00  |

When I do the following permit issuing request:
| carPlate | rateName | endingDateTime   | paymentCardNumber | paymentCardCvv | paymentCardExpirationDate |
| 0000AAA  | RED_ZONE | 2021/07/26 11:00 | 1234567890123456  | 123            | 2025/06                   |

Then I should get the following permit ticket:
| code                     | carPlate | startingDateTime | endingDateTime   | rateName | priceAmount | priceCurrencyCode |
| PT0000000000202107260800 | 0000AAA  | 2021/07/26 08:00 | 2021/07/26 11:00 | RED_ZONE | 1.50        | EUR               |

And the following permit ticket should have been stored:
| code                     | carPlate | startingDateTime | endingDateTime   | rateName | priceAmount | priceCurrencyCode |
| PT0000000000202107260800 | 0000AAA  | 2021/07/26 08:00 | 2021/07/26 11:00 | RED_ZONE | 1.50        | EUR               |

And the following payment should have been done:
| cardNumber       | amount | currencyCode | permitTicketCode         |
| 1234567890123456 | 1.50   | €            | PT0000000000202107260800 |
