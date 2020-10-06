package io.github.jmgarridopaz.bluezone.adapters.forcheckingcars.test;

import io.github.jmgarridopaz.bluezone.adapters.forcheckingcars.test.runner.TestRunner;
import io.github.jmgarridopaz.bluezone.adapters.forcheckingcars.test.sut.SutProvider;
import io.github.jmgarridopaz.bluezone.adapters.forcheckingcars.test.testcases.IllegallyParkedCarTest;
import io.github.jmgarridopaz.bluezone.hexagon.forcheckingcars.ForCheckingCars;
import io.github.jmgarridopaz.lib.portsadapters.DriverAdapter;

/*
 * Driver adapter for testing the "forCheckingCars" port.
 * Uses JUnit5 framework.
 */
public class ForCheckingCarsTestAdapter extends DriverAdapter<ForCheckingCars> {
	
	public	static final String	HARDCODED_HEXAGON_TAG		= "hardCodedHexagon";
	private static final String	NOT_HARDCODED_HEXAGON_TAG	= "!hardCodedHexagon";
	private	static final String TEST_CASES_PACKAGE			= IllegallyParkedCarTest.class.getPackageName();

	public ForCheckingCarsTestAdapter ( ForCheckingCars forCheckingCars ) {
		super(forCheckingCars);
	}

	
	@Override
	public void run ( String[] args ) {
		
		// the SUT (system under test) is the driver port (forCheckingCars)
		SutProvider.FOR_CHECKING_CARS.set ( this.driverPort() );
		
		String tagExpressionToRun = NOT_HARDCODED_HEXAGON_TAG;
		
		if ( (args.length > 0) && "--hardcodedhexagon".equals(args[0]) ) {
			tagExpressionToRun = HARDCODED_HEXAGON_TAG;
		}
		
		TestRunner testRunner = new TestRunner();
		
		testRunner.runTaggedTestsOfPackage ( TEST_CASES_PACKAGE, tagExpressionToRun );
	}
	
}
