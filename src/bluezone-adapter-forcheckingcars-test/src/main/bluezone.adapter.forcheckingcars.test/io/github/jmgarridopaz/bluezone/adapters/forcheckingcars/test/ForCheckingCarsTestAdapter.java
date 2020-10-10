package io.github.jmgarridopaz.bluezone.adapters.forcheckingcars.test;

import io.github.jmgarridopaz.bluezone.adapters.forcheckingcars.test.runner.JUnit5Runner;
import io.github.jmgarridopaz.bluezone.adapters.forcheckingcars.test.sut.SutProvider;
import io.github.jmgarridopaz.bluezone.adapters.forcheckingcars.test.testcases.IllegallyParkedCarTest;
import io.github.jmgarridopaz.bluezone.hexagon.driverports.forcheckingcars.ForCheckingCars;
import io.github.jmgarridopaz.lib.portsadapters.DriverAdapter;

/**
 * Driver adapter that runs "forcheckingcars" port test cases.
 * 
 * It uses JUnit5 framework.
 * 
 * For each port operation, there will be a Java class for testing it.
 * 
 * Test cases are '@Test' annotated methods in those Java classes.
 */
public class ForCheckingCarsTestAdapter extends DriverAdapter<ForCheckingCars> {
	
	public	static final String	HARDCODED_HEXAGON_TAG		= "hardCodedHexagon";
	private static final String	NOT_HARDCODED_HEXAGON_TAG	= "!hardCodedHexagon";
	private	static final String TEST_CASES_PACKAGE			= IllegallyParkedCarTest.class.getPackageName();

	/*
	 * The driver adapter has a configurable dependency on the port
	 */
	public ForCheckingCarsTestAdapter ( ForCheckingCars forCheckingCars ) {
		super(forCheckingCars);
	}

	/**
	 * Runs the driver adapter with the given args.
	 * 
	 * Launches a JUni5 runner to run the test cases found in a given package.
	 * 
	 * Args: --hardcodedhexagon		Optional flag.
	 * 								If present, run test cases tagged with 'hardCodedHexagon'
	 * 								Otherwise, run test cases not tagged with 'hardCodedHexagon'
	 */
	@Override
	public void run ( String[] args ) {
		/*
		 * The SUT (System Under Test) is the driver port (forCheckingCars)
		 */
		SutProvider.FOR_CHECKING_CARS.set ( this.driverPort() );
		
		String tagExpressionToRun = NOT_HARDCODED_HEXAGON_TAG;
		
		if ( (args.length > 0) && "--hardcodedhexagon".equals(args[0]) ) {
			tagExpressionToRun = HARDCODED_HEXAGON_TAG;
		}
		
		JUnit5Runner junit5Runner = new JUnit5Runner();
		
		junit5Runner.runTaggedTestsOfPackage ( TEST_CASES_PACKAGE, tagExpressionToRun );
	}
	
}
