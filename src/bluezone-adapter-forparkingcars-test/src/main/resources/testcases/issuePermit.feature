#Feature: Issue permit
#
  #AS
  #a car driver
  #
  #I WANT TO
  #get a permit for parking the car at a regulated area until a certain date-time paying with a card
  #
  #SO THAT
  #I can park the car without being fined
#
#
#
#@hardCodedHexagon
#Scenario: At Green Zone during 2h
#
#Given current date time is "2021/09/30 17:50"
#
#When I do the following permit issuing request:
#| carPlate | rateName   | endingDateTime   | paymentCardNumber | paymentCardCvv | paymentCardExpirationDate |
#| 9999ZZZ  | GREEN_ZONE | 2021/09/30 19:50 | 9876543210654321  | 321            | 2022/11                   |
#
#Then I should get the following permit ticket:
#| code                     | carPlate | startingDateTime | endingDateTime   | rateName   | amount |
#| PT9999252525202109301750 | 9999ZZZ  | 2021/09/30 17:50 | 2021/09/30 19:50 | GREEN_ZONE | 1.90   |
#
#
#
#Scenario: At Orange Zone during 2h 30m
#
#Given current date time is "2021/09/27 08:00"
#
#And there exist this rate
#| name        | amountPerHour | minMinutesAllowed | maxMinutesAllowed |
#| ORANGE_ZONE | 0.80          | 35                | 180               |
#
#And next paymentId is "76d0f01a-25a6-4bd0-88f5-0cd026a06163"
#
#When I do the following permit issuing request:
#| carPlate | rateName    | endingDateTime   | paymentCardNumber | paymentCardCvv | paymentCardExpirationDate |
#| 6989JJH  | ORANGE_ZONE | 2021/09/27 10:30 | 1234567890123456  | 123            | 2025/06                   |
#
#Then I should get the following permit ticket:
#| code                     | carPlate | startingDateTime | endingDateTime   | rateName    | amount |
#| PT6989090907202109270800 | 6989JJH  | 2021/09/27 08:00 | 2021/09/27 10:30 | ORANGE_ZONE | 2.00   |
#
#And the following permit should have been stored:
#| carPlate | startingDateTime | endingDateTime   | rateName    | paymentId                            |
#| 6989JJH  | 2021/09/27 08:00 | 2021/09/27 10:30 | ORANGE_ZONE | 76d0f01a-25a6-4bd0-88f5-0cd026a06163 |
#
#And the following payment should have been done:
#| id                                   | payerCardNumber  | amount |
#| 76d0f01a-25a6-4bd0-88f5-0cd026a06163 | 1234567890123456 | 2.00   |
