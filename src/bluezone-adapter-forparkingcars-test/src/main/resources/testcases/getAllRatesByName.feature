Feature: Get all rates by name

  AS
  a car driver
  
  I WANT TO
  get all the available rates in the city indexed by name
  
  SO THAT
  I can choose the rate name of the area I want to park the car at
  

@hardCodedHexagon
Scenario: HardCoded Rates ( Orange & Red )

Given it does not exist any rate repository
And it does not exist any permit repository
And it does not exist any payment recipient

When I do a get all rates by name request

Then I should obtain the following get all rates by name response:
|             | name        | amountPerHour | minMinutesAllowed | maxMinutesAllowed |
| ORANGE_ZONE | ORANGE_ZONE | 0.70          | 35                | 150               |
| RED_ZONE    | RED_ZONE    | 1.25          | 30                | 60                |


Scenario: Blue & Green Rates

Given there are the following rates at the repository:
| name       | amountPerHour | minMinutesAllowed | maxMinutesAllowed |
| BLUE_ZONE  | 0.85          | 35                | 120               |
| GREEN_ZONE | 0.65          | 60                | 180               |

When I do a get all rates by name request

Then I should obtain the following get all rates by name response:
|            | name       | amountPerHour | minMinutesAllowed | maxMinutesAllowed |
| BLUE_ZONE  | BLUE_ZONE  | 0.85          | 35                | 120               |
| GREEN_ZONE | GREEN_ZONE | 0.65          | 60                | 180               |
