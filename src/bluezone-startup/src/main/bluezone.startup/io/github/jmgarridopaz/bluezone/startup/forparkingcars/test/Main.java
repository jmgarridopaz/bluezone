package io.github.jmgarridopaz.bluezone.startup.forparkingcars.test;

import io.github.jmgarridopaz.bluezone.adapters.forparkingcars.test.ForParkingCarsTestAdapter;
import io.github.jmgarridopaz.bluezone.hexagon.HardCodedHexagon;


public class Main {
	
	public static void main ( String[] args ) {
		
		HardCodedHexagon hardCodedHexagon = new HardCodedHexagon();
		
		ForParkingCarsTestAdapter forParkingCarsTestAdapter = new ForParkingCarsTestAdapter ( hardCodedHexagon.forParkingCars() );
		
		forParkingCarsTestAdapter.run ( new String[]{"--hardcodedhexagon"} );
		
	}

}
