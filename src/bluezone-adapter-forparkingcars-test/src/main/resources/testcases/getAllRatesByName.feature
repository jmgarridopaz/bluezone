Feature: Get all rates by name

  AS
  a car driver
  
  I WANT TO
  get all the available rates in the city indexed by name
  
  SO THAT
  I can choose the rate name of the area I want to park the car at
  

@hardCodedHexagon
Scenario: HardCoded Rates ( Orange & Green )

Given no rate repository is present

And no permit repository is present

And no payment recipient is present

When I request all the rates indexed by name

Then I should get the following rates:

|             | name        | amountPerHour | minMinutesAllowed | maxMinutesAllowed |
| ORANGE_ZONE | ORANGE_ZONE | 0.80          | 35                | 180               |
| GREEN_ZONE  | GREEN_ZONE  | 0.95          | 60                | 540               |


Scenario: Green & Blue Rates

Given there exist these rates:

| name       | amountPerHour | minMinutesAllowed | maxMinutesAllowed |
| GREEN_ZONE | 0.70          | 60                | 180               |
| BLUE_ZONE  | 0.85          | 35                | 120               |

When I request all the rates indexed by name

Then I should get the following rates:

|            | name       | amountPerHour | minMinutesAllowed | maxMinutesAllowed |
| GREEN_ZONE | GREEN_ZONE | 0.70          | 60                | 180               |
| BLUE_ZONE  | BLUE_ZONE  | 0.85          | 35                | 120               |
