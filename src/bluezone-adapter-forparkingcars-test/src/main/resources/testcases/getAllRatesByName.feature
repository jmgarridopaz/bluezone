Feature: Get all rates by name

  AS
  a car driver
  
  I WANT TO
  get all the available rates in the city indexed by name
  
  SO THAT
  I can choose the rate name of the area I want to park the car at
  

@hardCodedHexagon
Scenario: ORANGE AND RED RATES

Given it does not exist any rate repository
And it does not exist any permit repository
And it does not exist any payment recipient

When I do a get all rates by name request

Then I should obtain the following get all rates by name response:
|             | name        | amount per hour | min minutes allowed | max minutes allowed |
| ORANGE_ZONE | ORANGE_ZONE | 0.75            | 35                  | 150                 |
| RED_ZONE    | RED_ZONE    | 1.20            | 30                  | 60                  |


Scenario: BLUE AND GREEN RATES

Given there exist the following rates at rate repository:
| name       | amount per hour | min minutes allowed | max minutes allowed |
| BLUE_ZONE  | 0.80            | 35                  | 120                 |
| GREEN_ZONE | 0.65            | 60                  | 180                 |

When I do a get all rates by name request

Then I should obtain the following get all rates by name response:
|            | name       | amount per hour | min minutes allowed | max minutes allowed |
| BLUE_ZONE  | BLUE_ZONE  | 0.80            | 35                  | 120                 |
| GREEN_ZONE | GREEN_ZONE | 0.65            | 60                  | 180                 |
