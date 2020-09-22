package io.github.jmgarridopaz.bluezone.adapters.forcheckingcars.test;

import io.github.jmgarridopaz.bluezone.hexagon.driverports.forcheckingcars.ForCheckingCars;
import io.github.jmgarridopaz.lib.portsadapters.AbstractDriverAdapter;
import io.github.jmgarridopaz.lib.portsadapters.DriverAdapter;


public class ForCheckingCarsTestAdapter extends DriverAdapter<ForCheckingCars> {
	
	public ForCheckingCarsTestAdapter ( ForCheckingCars forCheckingCars ) {
		super(forCheckingCars);
	}

	
	@Override
	public void run ( String[] args ) {		
	}
	
}
