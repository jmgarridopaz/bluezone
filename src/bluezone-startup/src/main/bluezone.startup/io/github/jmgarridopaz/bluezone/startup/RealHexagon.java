package io.github.jmgarridopaz.bluezone.startup;

import io.github.jmgarridopaz.bluezone.hexagon.CarParker;
import io.github.jmgarridopaz.bluezone.hexagon.ForCheckingCars;
import io.github.jmgarridopaz.bluezone.hexagon.ForObtainingRates;
import io.github.jmgarridopaz.bluezone.hexagon.ForParkingCars;
import io.github.jmgarridopaz.bluezone.hexagon.ForPaying;
import io.github.jmgarridopaz.bluezone.hexagon.ForStoringPermits;


public class RealHexagon implements Hexagon {

	private final ForObtainingRates forObtainingRates;
	private final ForStoringPermits forStoringPermits;
	private final ForPaying forPaying;
	
	public RealHexagon ( ForObtainingRates forObtainingRates, ForStoringPermits forStoringPermits, ForPaying forPaying ) {
		this.forObtainingRates = forObtainingRates;
		this.forStoringPermits = forStoringPermits;
		this.forPaying = forPaying;
	}


	@Override
	public ForParkingCars forParkingCars() {
		return new CarParker ( this.forObtainingRates, this.forStoringPermits, this.forPaying );
	}


	@Override
	public ForCheckingCars forCheckingCars() {
		return null;
//		return new CarChecker ( this.forObtainingRates, this.forStoringPermits, this.forPaying );
	}

}
