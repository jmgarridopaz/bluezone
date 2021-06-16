package io.github.jmgarridopaz.bluezone.startup;

import io.github.jmgarridopaz.bluezone.hexagon.CarParker;
import io.github.jmgarridopaz.bluezone.hexagon.ForObtainingRates;
import io.github.jmgarridopaz.bluezone.hexagon.ForParkingCars;


public class RealHexagonProvider implements HexagonProvider {

	public RealHexagonProvider() { }

	
	@Override
	public ForParkingCars getForParkingCarsInstance ( ForObtainingRates forObtainingRates ) {
		return new CarParker(forObtainingRates);
	}

}
