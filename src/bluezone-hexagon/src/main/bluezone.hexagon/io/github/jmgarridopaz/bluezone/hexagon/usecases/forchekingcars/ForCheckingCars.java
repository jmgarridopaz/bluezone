package io.github.jmgarridopaz.bluezone.hexagon.usecases.forchekingcars;

import java.time.Clock;

public interface ForCheckingCars {
		
	/**
	 * Checks whether a car parked at a regulated area doesn't have any active permit.
	 * A permit is active if the current datetime is before the ending datetime of the permit period.
	 * 
	 * @param	clock		Clock to get current datetime from
	 * @param	carPlate	Car plate of the car that we want to check
	 * @param	rateName	Rate name of the regulated area where the car to check is parked at
	 * @return				true if the car doesn't have any active permit for the rate, false otherwise
	 */
	public boolean illegallyParkedCar ( Clock clock, String carPlate, String rateName );
	
}
