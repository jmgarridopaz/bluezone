Feature: Get ticket

  AS
  a car driver

  I WANT TO
  get the ticket from its code

  SO THAT
  I can see the whole ticket data after purchasing it


  Scenario: Can get an existing ticket

    Given there is the following ticket at ticket repository:
      | code       | carPlate | rateName   | startingDateTime | endingDateTime   | price |
      | 0000000019 | 7607KWH  | GREEN_ZONE | 2022/05/19 17:00 | 2022/05/19 17:30 | 0.60  |

    When I ask for getting the ticket with code "0000000019"

    Then I should obtain the following ticket:
      | code       | carPlate | rateName   | startingDateTime | endingDateTime   | price |
      | 0000000019 | 7607KWH  | GREEN_ZONE | 2022/05/19 17:00 | 2022/05/19 17:30 | 0.60  |



  Scenario: The ticket code doesn't exist

    Given there is no ticket with code "0000000052" at ticket repository

    When I ask for getting the ticket with code "0000000052"

    Then I should obtain no ticket
