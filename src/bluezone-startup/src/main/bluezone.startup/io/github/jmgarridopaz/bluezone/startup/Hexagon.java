package io.github.jmgarridopaz.bluezone.startup;

import java.util.ServiceLoader;

import io.github.jmgarridopaz.bluezone.hexagon.ForCheckingCars;
import io.github.jmgarridopaz.bluezone.hexagon.ForObtainingRates;
import io.github.jmgarridopaz.bluezone.hexagon.ForParkingCars;
import io.github.jmgarridopaz.bluezone.hexagon.ForPaying;
import io.github.jmgarridopaz.bluezone.hexagon.ForStoringPermits;


public interface Hexagon {

	public ForParkingCars forParkingCars();
	
	public ForCheckingCars forCheckingCars();

}
