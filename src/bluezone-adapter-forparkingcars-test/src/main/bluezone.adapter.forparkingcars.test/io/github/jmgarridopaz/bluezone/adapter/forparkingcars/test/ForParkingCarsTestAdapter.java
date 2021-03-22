package io.github.jmgarridopaz.bluezone.adapter.forparkingcars.test;

import io.github.jmgarridopaz.bluezone.adapter.forparkingcars.test.stepdefs.ScenarioContext;
import io.github.jmgarridopaz.bluezone.adapter.forparkingcars.test.sut.SutProvider;
import io.github.jmgarridopaz.bluezone.hexagon.driver.forparkingcars.ForParkingCars;
import io.github.jmgarridopaz.lib.portsadapters.DriverAdapter;

/**
 * 
 * Driver adapter that runs "forparkingcars" port test cases.
 * 
 * It uses Cucumber testing automation tool
 * 
 * Test cases are scenarios described in feature files using Gherkin language.
 * 
 * There will be a feature file for each use case, containing scenarios as acceptance tests for the use case.
 * 
 * The feature is written using the "role-goal-benefit" template
 * ( "AS a role I WANT some goal SO THAT some benefit" ).
 * 
 * Scenarios are written using the "given-when-then" template
 * ( "GIVEN some context WHEN some action is carried out THEN a set of consequences should be obtained" ).
 * 
 */
public class ForParkingCarsTestAdapter extends DriverAdapter<ForParkingCars> {
	
	// The driver adapter has a configurable dependency on the port
	public ForParkingCarsTestAdapter ( ForParkingCars forParkingCars ) {
		super(forParkingCars);
	}

	/**
	 * Runs the driver adapter with the given args.
	 * 
	 * Launches Cucumber to run feature files at "src/main/resources/testcases/"
	 * 
	 * Creates a html report at the URL given in the console output
	 * 
	 * Args: -hch		Optional flag.
	 * 					If present, run test cases tagged with '@hardCodedHexagon'
	 * 					Otherwise, run test cases not tagged with '@hardCodedHexagon'
	 */
	@Override
	public void run ( String[] args ) {
		
		// The SUT (System Under Test) is the driver port (forParkingCars)
		SutProvider.FOR_PARKING_CARS.set ( this.driverPort() );

		// Defining tags to run
		String tagsToRun = "not @hardCodedHexagon";
		if ( (args.length > 0) && "-hch".equals(args[0]) ) {
			tagsToRun = "@hardCodedHexagon";
		}

		// Calling Cucumber with command line args
		String[] cucumberArgs = new String[]
				{
				"classpath:testcases",
				"--tags",				tagsToRun,
				"--glue",				ScenarioContext.class.getPackageName(),
				"--snippets",			"camelcase",
				"--plugin",				"pretty",			
				"--publish"
				};
		io.cucumber.core.cli.Main.main ( cucumberArgs );
		
	}
	
}
