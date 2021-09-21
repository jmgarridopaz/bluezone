package io.github.jmgarridopaz.bluezone.startup;

import io.github.jmgarridopaz.bluezone.hexagon.ForCheckingCars;
import io.github.jmgarridopaz.bluezone.hexagon.ForParkingCars;


public interface Hexagon {

	public ForParkingCars forParkingCars();
	
	public ForCheckingCars forCheckingCars();

}
