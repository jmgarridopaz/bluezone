Feature: Get all rates by name

  AS
  a car driver
  
  I WANT TO
  get the available rates in the city indexed by name
  
  SO THAT
  I can choose the rate name of the zone I want to park the car at


Scenario: BLUE, GREEN and ORANGE rates

Given there exist the following rates at rate repository:
| name        | amount per hour |
| BLUE_ZONE   | 0.80            |
| GREEN_ZONE  | 1.20            |
| ORANGE_ZONE | 0.95            |

When I do a 'get all rates by name' request

Then I should obtain the following 'get all rates by name' response:
|             | name        | amount per hour |
| BLUE_ZONE   | BLUE_ZONE   | 0.80            |
| GREEN_ZONE  | GREEN_ZONE  | 1.20            |
| ORANGE_ZONE | ORANGE_ZONE | 0.95            |
