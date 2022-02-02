Feature: Issue permit

  AS
  a car driver

  I WANT TO
  get a permit for parking the car at a regulated area until a certain date-time paying with a card

  SO THAT
  I can park the car without being fined


  @hardCodedHexagon
  Scenario: AT RED ZONE DURING 45 MINUTES

    Given it does not exist any rate repository
    And it does not exist any permit repository
    And it does not exist any payment recipient

    When I do the following issue permit request:
      | current date time   | car plate | rate name | ending date time | payment card number |
      | 2022/01/04 19:15:06 | 9999ZZZ   | RED_ZONE  | 2022/01/04 20:00 | 1234567890123456    |

    Then I should obtain the following issue permit response:
      | code                         | car plate | starting date time | ending date time | rate name | price |
      | PT-20220104191506-9999252525 | 9999ZZZ   | 2022/01/04 19:15   | 2022/01/04 20:00 | RED_ZONE  | 0.90  |


  Scenario: AT BLUE ZONE DURING 1 HOUR 30 MINUTES

    Given there exist the following rates at rate repository:
      | name      | amount per hour | min minutes allowed | max minutes allowed |
      | BLUE_ZONE | 0.80            | 35                  | 120                 |
    And next available permit id is "1"
    And next available payment transaction id is "76d0f01a-25a6-4bd0-88f5-0cd026a06163"

    When I do the following issue permit request:
      | current date time   | car plate | rate name | ending date time | payment card number |
      | 2022/01/05 14:30:19 | 6989JJH   | BLUE_ZONE | 2022/01/05 16:00 | 4651413851991298    |

    Then I should obtain the following issue permit response:
      | code                         | car plate | starting date time | ending date time | rate name | price |
      | PT-20220105143019-6989090907 | 6989JJH   | 2022/01/05 14:30   | 2022/01/05 16:00 | BLUE_ZONE | 1.20  |
    And the following permit should have been stored at permit repository:
      | id | car plate | rate name | created at          | ending date time | payment transaction id               |
      | 1  | 6989JJH   | BLUE_ZONE | 2022/01/05 14:30:19 | 2022/01/05 16:00 | 76d0f01a-25a6-4bd0-88f5-0cd026a06163 |
    And the a transaction with the following data should have been done by the payment system:
      | transaction id                       | card number      | amount |
      | 76d0f01a-25a6-4bd0-88f5-0cd026a06163 | 4651413851991298 | 1.20   |
