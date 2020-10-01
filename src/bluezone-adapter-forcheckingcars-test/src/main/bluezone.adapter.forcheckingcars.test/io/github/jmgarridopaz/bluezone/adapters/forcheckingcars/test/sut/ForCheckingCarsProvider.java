package io.github.jmgarridopaz.bluezone.adapters.forcheckingcars.test.sut;

import io.github.jmgarridopaz.bluezone.hexagon.forcheckingcars.ForCheckingCars;


public enum ForCheckingCarsProvider {

	INSTANCE;
	
	private ForCheckingCars forCheckingCars;
	
	public void set ( ForCheckingCars forCheckingCars ) {
		this.forCheckingCars = forCheckingCars;
	}

	public ForCheckingCars get() {
		return this.forCheckingCars;
	}
	
}
