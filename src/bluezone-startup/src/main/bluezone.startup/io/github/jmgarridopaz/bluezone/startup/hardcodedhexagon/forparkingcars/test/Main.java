package io.github.jmgarridopaz.bluezone.startup.hardcodedhexagon.forparkingcars.test;

import java.util.ServiceLoader;
import java.util.stream.Collectors;

import io.github.jmgarridopaz.bluezone.adapter.forparkingcars.test.ForParkingCarsTestAdapter;
import io.github.jmgarridopaz.bluezone.hexagon.HardCodedHexagon;
import io.github.jmgarridopaz.bluezone.hexagon.driver.forparkingcars.ForParkingCars;

/**
 * One of the fixed entry points to the application.
 * It applies the configurable dependency pattern at both driven and driver sides.
 * It runs a driver port.
 * 
 * In this case:
 * 		- No driven adapters.
 * 		- Instantiates the hardcoded "forparkingcars" driver port.
 * 		- It runs the "forparkingcars" test adapter
 */
public class Main {
	
	public static void main ( String[] args ) {
		
		ForParkingCars forParkingCars = ServiceLoader.
											load(ForParkingCars.class).
											stream().
											filter ( p -> p.type().isAnnotationPresent(HardCodedHexagon.class) ).
											collect ( Collectors.toList() ).
											get(0).
											get();
		
		ForParkingCarsTestAdapter forParkingCarsTestAdapter = new ForParkingCarsTestAdapter ( forParkingCars );
		
		forParkingCarsTestAdapter.run ( new String[]{"--hardcodedhexagon"} );
		
	}

}
