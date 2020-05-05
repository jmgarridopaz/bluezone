Feature: Get all rates

  AS a car driver
  I WANT TO get the info about all the available rates
  SO THAT I can choose the rate of the area I want to park the car at

Scenario: Hardcoded rates

When I request all the rates
Then I should get the following rates:
	| name         | costPerHour | minutesAllowedInterval | monday                  | tuesday                 | wednesday               | thursday                | friday                  | saturday      | sunday        |
 	| GREEN_ZONE   | 0.65 €      | 60-180                 | 08:00-22:00             | 08:00-22:00             | 08:00-22:00             | 08:00-22:00             | 08:00-22:00             | 08:00-22:00   | 08:00-22:00   |
 	| BLUE_ZONE    | 0.85 €      | 35-120                 | 09:00-14:00-17:00-20:00 | 09:00-14:00-17:00-20:00 | 09:00-14:00-17:00-20:00 | 09:00-14:00-17:00-20:00 | 09:00-14:00-17:00-20:00 | 10:00-14:00   |               |
