package io.github.jmgarridopaz.bluezone.startup;

import io.github.jmgarridopaz.bluezone.hexagon.ForObtainingRates;
import io.github.jmgarridopaz.bluezone.hexagon.ForParkingCars;


public interface HexagonProvider {

	public ForParkingCars getForParkingCarsInstance ( ForObtainingRates forObtainingRates );

}
