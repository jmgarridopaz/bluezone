package io.github.jmgarridopaz.bluezone.startup;

import io.github.jmgarridopaz.bluezone.hexagon.ForObtainingRates;
import io.github.jmgarridopaz.bluezone.hexagon.ForParkingCars;
import io.github.jmgarridopaz.bluezone.hexagon.HardCodedCarParker;


@HardCodedHexagon
public class HardcodedHexagonProvider implements HexagonProvider {

	public HardcodedHexagonProvider() { }

	
	@Override
	public ForParkingCars getForParkingCarsInstance ( ForObtainingRates forObtainingRates ) {
		return new HardCodedCarParker();
	}

}
