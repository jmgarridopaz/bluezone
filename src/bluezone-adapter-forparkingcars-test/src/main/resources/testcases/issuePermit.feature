Feature: Request parking permit

  AS
  a car driver
  
  I WANT TO
  request a permit for parking the car at a regulated area until a certain date-time

  SO THAT
  later on I can pay for the permit to get a parking ticket


@hardCodedHexagon
Scenario: At Red Zone during 45 minutes

Given it does not exist any rate repository
And it does not exist any permit repository
And it does not exist any payment recipient

When I do the following issue parking permit request:
| current date time | carPlate | rateName | endingDateTime   |
| 2021/11/16 17:50  | 9999ZZZ  | RED_ZONE | 2021/11/16 18:35 |

 #paymentCardNumber | paymentCardCvv | paymentCardExpirationDate |
 #9876543210654321  | 321            | 2030/01                   |
 
Then the following permit should have been stored:
| id                     | carPlate | startingDateTime | endingDateTime   | rateName | price | paymentTransactionId |
| 9999252525202111161750 | 9999ZZZ  | 2021/11/16 17:50 | 2021/11/16 18:35 | RED_ZONE | 0.94  |                      |

And the following issue parking permit response:
| id                     |
| 9999252525202111161750 |


Scenario: At Blue Zone during 1 hour 30 minutes

Given there are the following rates at the repository:
| name       | amountPerHour | minMinutesAllowed | maxMinutesAllowed |
| BLUE_ZONE  | 0.85          | 35                | 120               |

When I do the following issue permit request at "2021/11/17 08:15":
| carPlate | rateName  | endingDateTime   | paymentCardNumber | paymentCardCvv | paymentCardExpirationDate |
| 6989JJH  | BLUE_ZONE | 2021/11/17 09:45 | 1234567890123456  | 123            | 2025/06                   |

Then I should get the following issue permit response:
| ticketCode             | carPlate | startingDateTime | endingDateTime   | rateName  | price | paymentTransactionId |
| 6989090907202111170815 | 6989JJH  | 2021/11/17 08:15 | 2021/11/17 09:45 | BLUE_ZONE | 1.28  |                      |

#Then I should get the following permit ticket:
#| code                     | carPlate | startingDateTime | endingDateTime   | rateName  | price |
#| PT6989090907202109270800 | 6989JJH  | 2021/09/27 08:00 | 2021/09/27 09:30 | BLUE_ZONE | 1.05  |
#
#And the following permit should have been stored:
	#| carPlate | startingDateTime | endingDateTime   | rateName  | paymentId                            |
#| 6989JJH  | 2021/09/27 08:00 | 2021/09/27 09:30 | BLUE_ZONE | 76d0f01a-25a6-4bd0-88f5-0cd026a06163 |
#
#And the following payment should have been done:
#| id                                   | payerCardNumber  | amount |
#| 76d0f01a-25a6-4bd0-88f5-0cd026a06163 | 1234567890123456 | 1.05   |
