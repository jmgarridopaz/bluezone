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
	
	public static void main ( String[] args ) {
		ForParkingCarsTestAdapter forParkingCarsTestAdapter = new ForParkingCarsTestAdapter();
		forParkingCarsTestAdapter.run(args);
	}
	
}
