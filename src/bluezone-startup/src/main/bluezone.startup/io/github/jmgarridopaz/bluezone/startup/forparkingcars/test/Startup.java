package io.github.jmgarridopaz.bluezone.startup.forparkingcars.test;

import io.github.jmgarridopaz.bluezone.adapter.forparkingcars.test.ForParkingCarsTestAdapter;

/**
 * Entry points to the application.
 * It runs the "forparkingcars" test adapter.
 * 
 * Delegates to a dependency configurator
 * that applies configurable dependency pattern
 * at both driven and driver sides.
 */
public class Startup {
	
	private static boolean hardcodedHexagon;

	
	public static void main ( String[] args ) {
		Startup.hardcodedHexagon = ( (args.length > 0) && "-hch".equals(args[0]) );
		ForParkingCarsTestAdapter forParkingCarsTestAdapter = new ForParkingCarsTestAdapter();
		forParkingCarsTestAdapter.run(args);
	}
	
	
	static boolean isHardcodedHexagon() {
		return Startup.hardcodedHexagon;
	}
	
}
