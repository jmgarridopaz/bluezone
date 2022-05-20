Feature: Get all rates by name

  AS
  a car driver
  
  I WANT TO
  get the available rates in the city indexed by name
  
  SO THAT
  I can choose the rate name of the zone I want to park the car at


Scenario: BLUE, GREEN and ORANGE rates

Given there are the following rates at rate repository:
| name        | amount per hour |
| BLUE_ZONE   | 0.80            |
| ORANGE_ZONE | 0.95            |
| GREEN_ZONE  | 1.20            |

When I ask for getting all rates by name

Then I should obtain the following rates indexed by name:
|             | name        | amount per hour |
| BLUE_ZONE   | BLUE_ZONE   | 0.80            |
| GREEN_ZONE  | GREEN_ZONE  | 1.20            |
| ORANGE_ZONE | ORANGE_ZONE | 0.95            |
