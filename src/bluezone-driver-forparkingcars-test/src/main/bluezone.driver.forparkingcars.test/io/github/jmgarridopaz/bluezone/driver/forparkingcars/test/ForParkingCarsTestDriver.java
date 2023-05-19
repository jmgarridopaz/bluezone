package io.github.jmgarridopaz.bluezone.driver.forparkingcars.test;

import io.github.jmgarridopaz.bluezone.driver.forparkingcars.test.stepdefs.ScenarioContext;
import io.github.jmgarridopaz.bluezone.hexagon.ports.driving.forconfiguringapp.ForConfiguringApp;
import io.github.jmgarridopaz.bluezone.hexagon.ports.driving.forparkingcars.ForParkingCars;
import io.github.jmgarridopaz.lib.portsadapters.Driver;

/**
 * 
 * Driver that runs "forparkingcars" port test cases.
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
public class ForParkingCarsTestDriver implements Driver {

	public static ForParkingCars CAR_PARKER;
	public static ForConfiguringApp APP_CONFIGURATOR;

	public ForParkingCarsTestDriver (ForParkingCars carParker, ForConfiguringApp appConfigurator ) {
		CAR_PARKER = carParker;
		APP_CONFIGURATOR = appConfigurator;
	}

	/**
	 * Launches Cucumber to run feature files at "src/main/resources/testcases/"
	 * Creates a html report at the URL given in the console output
	 */
	@Override
	public void run ( String... args) {

		// Calling Cucumber with command line args
		String[] cucumberArgs = new String[]
				{
				"classpath:testcases",
				"--glue",				ScenarioContext.class.getPackageName(),
				"--snippets",			"camelcase",
				"--plugin",				"pretty",			
				"--publish"
				};
		io.cucumber.core.cli.Main.main ( cucumberArgs );
		
	}

}
