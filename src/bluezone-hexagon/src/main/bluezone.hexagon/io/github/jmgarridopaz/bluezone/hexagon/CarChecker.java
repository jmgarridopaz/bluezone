package io.github.jmgarridopaz.bluezone.hexagon;

import java.time.Clock;
import java.util.Map;


/**
 * Business logic inside the hexagon.
 * Implements driver port interface.
 * Configurable dependency on driven port interfaces.
 * 
 * It redirects request either to the hardcoded implementation or to the real one.
 * 
 */
public class CarChecker implements ForCheckingCars {

	private final ForCheckingCars forCheckingCars;

	public CarChecker(ForObtainingRates forObtainingRates, ForStoringPermits forStoringPermits, ForPaying forPaying ) {
		if ( forObtainingRates==null && forStoringPermits==null && forPaying==null ) {
			this.forCheckingCars =  new HardCodedCarChecker();
		} else {
			this.forCheckingCars = null;
		}
	}

	@Override
	public boolean illegallyParkedCar(Clock clock, String carPlate, String rateName) {
		return this.forCheckingCars.illegallyParkedCar(clock, carPlate, rateName);
	}

}
