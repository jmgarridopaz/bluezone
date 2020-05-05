package io.github.jmgarridopaz.bluezone.driveradapters.forparkingcars.test.stepdefs;

import io.github.jmgarridopaz.bluezone.hexagon.driverports.forparkingcars.ForParkingCars;


public enum ForParkingCarsProvider {

	INSTANCE;
	
	private ForParkingCars forParkingCars;
	
	public void set ( ForParkingCars forParkingCars ) {
		this.forParkingCars = forParkingCars;
	}

	ForParkingCars get() {
		return this.forParkingCars;
	}
	
}
