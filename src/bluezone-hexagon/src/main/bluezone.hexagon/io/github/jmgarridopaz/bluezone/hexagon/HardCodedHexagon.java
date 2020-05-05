package io.github.jmgarridopaz.bluezone.hexagon;

import io.github.jmgarridopaz.bluezone.hexagon.driverports.forcheckingcars.ForCheckingCars;
import io.github.jmgarridopaz.bluezone.hexagon.driverports.forcheckingcars.implementation.HardCodedCarChecker;
import io.github.jmgarridopaz.bluezone.hexagon.driverports.forparkingcars.ForParkingCars;
import io.github.jmgarridopaz.bluezone.hexagon.driverports.forparkingcars.implementation.HardCodedCarParker;

/**
 * Test double for the Hexagon.
 * 
 * For testing driver adapters 'mocking' the hexagon.
 * 
 * It doesn't depend on any driven port.
 * It returns driver ports with methods that receive/return hardcoded values.
 * 
 * It is used by the startup module to inject driver ports into driver adapters.
 */
public class HardCodedHexagon {

	// Driver Ports
	private ForParkingCars	forParkingCars;
	private ForCheckingCars	forCheckingCars;
	

	public HardCodedHexagon() {
	}

	
	public ForParkingCars forParkingCars() {
		if ( this.forParkingCars == null ) {
			this.forParkingCars = new HardCodedCarParker();
		}
		return this.forParkingCars;
	}

	public ForCheckingCars forCheckingCars() {
		if ( this.forCheckingCars == null ) {
			this.forCheckingCars = new HardCodedCarChecker();
		}
		return this.forCheckingCars;
	}
	
}
