package io.github.jmgarridopaz.bluezone.hexagon.forcheckingcars;

import java.time.Clock;

public interface ForCheckingCars {
		
	/**
	 * Checks whether a car parked in a regulated area has an active permit.
	 * A permit is active if the current datetime is before the ending datetime of the permit period.
	 * 
	 * @param	clock		Clock to get current datetime from
	 * @param	carPlate	Car plate of the car that we want to check
	 * @param	rateName	Rate name of the regulated area where the car to check is parked
	 * @return				true if there exists an active permit, false otherwise
	 */
	public boolean isParkedCorrectly ( Clock clock, String carPlate, String rateName );
	
}
