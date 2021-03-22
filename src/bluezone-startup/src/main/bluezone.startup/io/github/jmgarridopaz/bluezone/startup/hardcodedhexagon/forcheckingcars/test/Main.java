package io.github.jmgarridopaz.bluezone.startup.hardcodedhexagon.forcheckingcars.test;

import java.util.ServiceLoader;
import java.util.stream.Collectors;

import io.github.jmgarridopaz.bluezone.adapter.forcheckingcars.test.ForCheckingCarsTestAdapter;
import io.github.jmgarridopaz.bluezone.hexagon.HardCodedHexagon;
import io.github.jmgarridopaz.bluezone.hexagon.driver.forcheckingcars.ForCheckingCars;

/**
 * One of the fixed entry points to the application.
 * It applies the configurable dependency pattern at both driven and driver sides.
 * It runs a driver port.
 * 
 * In this case:
 * 		- No driven adapters.
 * 		- Instantiates the hardcoded "forcheckingcars" driver port.
 * 		- It runs the "forcheckingcars" test adapter
 */
public class Main {
	
	public static void main ( String[] args ) {
		
		ForCheckingCars forCheckingCars = ServiceLoader.
											load(ForCheckingCars.class).
											stream().
											filter ( p -> p.type().isAnnotationPresent(HardCodedHexagon.class) ).
											collect ( Collectors.toList() ).
											get(0).
											get();
		
		ForCheckingCarsTestAdapter forCheckingCarsTestAdapter = new ForCheckingCarsTestAdapter ( forCheckingCars );
		
		forCheckingCarsTestAdapter.run ( new String[]{"-hch"} );
		
	}

}
