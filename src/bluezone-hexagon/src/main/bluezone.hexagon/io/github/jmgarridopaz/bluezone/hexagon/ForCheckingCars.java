package io.github.jmgarridopaz.bluezone.hexagon;

import java.time.Clock;

/**
 * DRIVER PORT
 */
public interface ForCheckingCars {
		
	/**
	 * A car is illegally parked at a zone, if the car does not have any valid ticket for the zone rate at the current date-time.
	 * A ticket is valid if the given date-time is between the starting and ending date-time of the ticket.
	 *
	 * @param clock		Clock to get current date-time from
	 * @param carPlate	Plate of the car that we want to check
	 * @param rateName	Rate name of the zone where the car to check is parked at
	 * @return			"true" if the car has no valid ticket for the rate at current date-time,
	 * 					"false" otherwise.
	 */
	public boolean illegallyParkedCar ( Clock clock, String carPlate, String rateName );
	
}
