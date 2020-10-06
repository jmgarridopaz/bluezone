package io.github.jmgarridopaz.bluezone.startup.forcheckingcars.test;

import io.github.jmgarridopaz.bluezone.adapters.forcheckingcars.test.ForCheckingCarsTestAdapter;
import io.github.jmgarridopaz.bluezone.hexagon.HardCodedHexagon;


public class Main {
	
	public static void main ( String[] args ) {
		
		HardCodedHexagon hardCodedHexagon = new HardCodedHexagon();
		
		ForCheckingCarsTestAdapter forCheckingCarsTestAdapter = new ForCheckingCarsTestAdapter ( hardCodedHexagon.forCheckingCars() );
		
		forCheckingCarsTestAdapter.run ( new String[]{"--hardcodedhexagon"} );
		
	}

}
