package io.github.jmgarridopaz.bluezone.adapters.forcheckingcars.test.sut;

import io.github.jmgarridopaz.bluezone.hexagon.driverports.forcheckingcars.ForCheckingCars;


public enum SutProvider {

	FOR_CHECKING_CARS;
	
	private ForCheckingCars forCheckingCars;
	
	public void set ( ForCheckingCars forCheckingCars ) {
		this.forCheckingCars = forCheckingCars;
	}

	public ForCheckingCars get() {
		return this.forCheckingCars;
	}
	
}
