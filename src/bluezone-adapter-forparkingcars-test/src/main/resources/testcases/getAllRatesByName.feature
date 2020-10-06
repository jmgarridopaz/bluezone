Feature: Get all rates by name

  AS
  a car driver
  
  I WANT TO
  get all the available rates in the city indexed by name
  
  SO THAT
  I can choose the rate name of the area I want to park the car at
  

@hardCodedHexagon
Scenario: Hardcoded rates indexed by name

When I request all the rates indexed by name

Then I should get the following rates:

|            | name         | costPerHourAmount | costPerHourCurrencySymbol | minMinutesAllowed | maxMinutesAllowed | monday                  | tuesday                 | wednesday               | thursday                | friday                  | saturday    | sunday      |
| GREEN_ZONE | GREEN_ZONE   | 0.65              | €                         | 60                | 180               | 08:00-22:00             | 08:00-22:00             | 08:00-22:00             | 08:00-22:00             | 08:00-22:00             | 08:00-22:00 | 08:00-22:00 |
| BLUE_ZONE  | BLUE_ZONE    | 0.85              | €                         | 35                | 120               | 09:00-14:00 17:00-20:00 | 09:00-14:00 17:00-20:00 | 09:00-14:00 17:00-20:00 | 09:00-14:00 17:00-20:00 | 09:00-14:00 17:00-20:00 | 10:00-14:00 |             |
