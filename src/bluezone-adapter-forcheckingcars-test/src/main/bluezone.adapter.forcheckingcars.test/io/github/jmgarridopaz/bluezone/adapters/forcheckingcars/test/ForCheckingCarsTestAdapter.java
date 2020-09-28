package io.github.jmgarridopaz.bluezone.adapters.forcheckingcars.test;

import io.github.jmgarridopaz.bluezone.hexagon.forcheckingcars.ForCheckingCars;
import io.github.jmgarridopaz.lib.portsadapters.DriverAdapter;


public class ForCheckingCarsTestAdapter extends DriverAdapter<ForCheckingCars> {
	
	public ForCheckingCarsTestAdapter ( ForCheckingCars forCheckingCars ) {
		super(forCheckingCars);
	}

	
	@Override
	public void run ( String[] args ) {
		
		boolean hardCodedHexagon = false;
		if ( (args.length > 0) && "--hardcoded".equals(args[0]) ) {
			hardCodedHexagon = true;
		}
		
		TestRunner testRunner = new TestRunner ( this.driverPort(), hardCodedHexagon );
		
		testRunner.runAllFeatures();
		
		testRunner.printExecutionSummary();

	}
	
}
