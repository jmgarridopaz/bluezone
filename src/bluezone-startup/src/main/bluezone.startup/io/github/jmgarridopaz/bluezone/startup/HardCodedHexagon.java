package io.github.jmgarridopaz.bluezone.startup;

import io.github.jmgarridopaz.bluezone.hexagon.ForCheckingCars;
import io.github.jmgarridopaz.bluezone.hexagon.ForParkingCars;
import io.github.jmgarridopaz.bluezone.hexagon.HardCodedCarChecker;
import io.github.jmgarridopaz.bluezone.hexagon.HardCodedCarParker;


public class HardCodedHexagon implements Hexagon {

	public HardCodedHexagon() { }

	
	@Override
	public ForParkingCars forParkingCars() {
		return new HardCodedCarParker();
	}


	@Override
	public ForCheckingCars forCheckingCars() {
		return new HardCodedCarChecker();
	}

}
