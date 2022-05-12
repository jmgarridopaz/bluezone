package io.github.jmgarridopaz.bluezone.hexagon;

import java.time.Clock;


public interface ForCheckingCars {
		
	/**
	 * A car is illegally parked at a zone, if any of the following conditions are met:
	 * 		- The car does not have any ticket for the zone rate.
	 * 		- All the tickets the car has for the zone rate, have expired.
	 *
	 * A ticket has expired if current date-time is after the ending date-time of the ticket.
	 *
	 * @param clock		Clock to get current date-time from
	 * @param carPlate	Plate of the car that we want to check
	 * @param rateName	Rate name of the zone where the car to check is parked at
	 * @return			"true" if all the tickets the car has for the rate are expired,
	 * 					or if the car doesn't have any ticket for the rate.
	 * 					"false" otherwise.
	 */
	public boolean illegallyParkedCar ( Clock clock, String carPlate, String rateName );
	
}
