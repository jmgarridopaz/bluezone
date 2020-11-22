package io.github.jmgarridopaz.bluezone.adapter.forparkingcars.test.sut;

import io.github.jmgarridopaz.bluezone.hexagon.driver.forparkingcars.ForParkingCars;


public enum SutProvider {

	FOR_PARKING_CARS;
	
	private ForParkingCars forParkingCars;
	
	public void set ( ForParkingCars forParkingCars ) {
		this.forParkingCars = forParkingCars;
	}

	public ForParkingCars get() {
		return this.forParkingCars;
	}
	
}
