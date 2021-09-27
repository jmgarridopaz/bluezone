package io.github.jmgarridopaz.bluezone.hexagon;

import io.github.jmgarridopaz.bluezone.hexagon.ForObtainingRates;
import io.github.jmgarridopaz.bluezone.hexagon.ForParkingCars;
import io.github.jmgarridopaz.bluezone.hexagon.ForPaying;
import io.github.jmgarridopaz.bluezone.hexagon.ForStoringPermits;


public interface Hexagon {

	public static Hexagon build
								(
								ForObtainingRates forObtainingRates,
								ForStoringPermits forStoringPermits,
								ForPaying forPaying
								) {
		// TODO Auto-generated method stub
		return null;
	}

	public ForParkingCars forParkingCars();
	
	public ForCheckingCars forCheckingCars();

}
