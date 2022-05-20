Feature: Purchase ticket

  AS
  a car driver

  I WANT TO
  purchase a ticket for parking the car at a zone during a period of time

  SO THAT
  I can park the car without being fined


  Scenario: At orange zone paying for 2 hours

    Given there is the following rate at rate repository:
      | name        | amount per hour |
      | ORANGE_ZONE | 0.95            |

    And next available ticket code is "0000000001"

    And there is no ticket with code "0000000001" at ticket repository

    And the wallet of car "6989JJH" has "5.00" euros

    When I do the following purchase ticket request:
      | car plate | rate name   | clock            | amount |
      | 6989JJH   | ORANGE_ZONE | 2022/05/11 10:00 | 1.90   |

    Then I should obtain the ticket code "0000000001"

    And there should be the following ticket at ticket repository:
      | code       | car plate | rate name   | starting date time | ending date time | price |
      | 0000000001 | 6989JJH   | ORANGE_ZONE | 2022/05/11 10:00   | 2022/05/11 12:00 | 1.90  |

    And next available ticket code should be "0000000002"

    And the wallet of car "6989JJH" should have "3.10" euros


  Scenario: Not enough money in wallet

    Given there is the following rate at rate repository:
      | name      | amount per hour |
      | BLUE_ZONE | 0.80            |

    And next available ticket code is "0000000010"

    And there is no ticket with code "0000000010" at ticket repository

    And the wallet of car "8149GRH" has "1.19" euros

    When I do the following purchase ticket request:
      | car plate | rate name | clock            | amount |
      | 8149GRH   | BLUE_ZONE | 2022/05/12 07:00 | 1.20   |

    Then I should obtain no ticket code

    And there should be no ticket with code "0000000010" at ticket repository

    And next available ticket code should be "0000000010"

    And the wallet of car "8149GRH" should have "1.19" euros

    And a NotEnoughMoneyException should have been thrown
