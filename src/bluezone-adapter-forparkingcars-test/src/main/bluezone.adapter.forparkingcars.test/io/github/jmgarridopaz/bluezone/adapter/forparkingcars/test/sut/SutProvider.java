package io.github.jmgarridopaz.bluezone.adapter.forparkingcars.test.sut;

import java.util.function.Function;

import io.github.jmgarridopaz.bluezone.adapter.forparkingcars.test.InitialData;
import io.github.jmgarridopaz.bluezone.hexagon.driver.forparkingcars.ForParkingCars;


public enum SutProvider {

	FOR_PARKING_CARS;
	
	private Function<InitialData,ForParkingCars> forParkingCarsSetup;
	
	public void set ( Function<InitialData,ForParkingCars> forParkingCarsSetup ) {
		this.forParkingCarsSetup = forParkingCarsSetup;
	}

	public ForParkingCars from ( InitialData initialData ) {
		return this.forParkingCarsSetup.apply(initialData);
	}
	
}
