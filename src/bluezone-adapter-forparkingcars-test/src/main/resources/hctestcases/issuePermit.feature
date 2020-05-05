Feature: Issue permit

  AS a car driver
  I WANT TO get a permit ticket
  SO THAT I can park the car without being fined


Scenario: Hardcoded permit

Given current datetime is "2020/04/22 08:00"
When I do the following permit issuing request:
| carPlate | rateName   | endingDateTime   | cardNumber       | cardCvv | cardExpirationDate |
| 0000AAA  | GREEN_ZONE | 2020/04/22 10:00 | 1234567890123456 | 123     | 2025/06            |
Then I should get the following permit ticket:
| code                       | carPlate | rateName   | startingDateTime | endingDateTime   | price  |
| PT/0000000000/202004220800 | 0000AAA  | GREEN_ZONE | 2020/04/22 08:00 | 2020/04/22 10:00 | 1.30 € |
