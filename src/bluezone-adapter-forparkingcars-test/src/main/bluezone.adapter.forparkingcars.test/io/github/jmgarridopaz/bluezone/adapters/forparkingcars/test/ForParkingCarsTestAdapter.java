package io.github.jmgarridopaz.bluezone.adapters.forparkingcars.test;

import java.nio.file.Paths;
import io.github.jmgarridopaz.bluezone.adapters.forparkingcars.test.stepdefs.ScenarioContext;
import io.github.jmgarridopaz.bluezone.adapters.forparkingcars.test.sut.SutProvider;
import io.github.jmgarridopaz.bluezone.hexagon.forparkingcars.ForParkingCars;
import io.github.jmgarridopaz.lib.portsadapters.DriverAdapter;


/**
 * Driver adapter that run test cases against "for parking cars" port.
 * It uses Cucumber testing tool.
 * It creates a html report file with the test execution results.
 * Test cases are Cucumber scenarios in feature files.
 * There will be a feature file for each port operation.
 */
public class ForParkingCarsTestAdapter extends DriverAdapter<ForParkingCars> {
	
	private static final String GLUECODE_PACKAGE		= ScenarioContext.class.getPackageName();
	private static final String HTML_PLUGIN_PREFIX		= "html:";
	private static final String HTML_REPORT_PATH		= "output";
	private static final String HTML_REPORT_FILENAME	= "forparkingcarsTestReport.html";
	private static final String PRETTY_PLUGIN			= "pretty";
	private static final String HARDCODED_HEXAGON_TAG	= "@hardCodedHexagon";
	private static final String REAL_HEXAGON_TAG		= "not @hardCodedHexagon";
	private static final String SNIPPETS_CAMELCASE		= "camelcase";
	private static final String TESTCASES_DIRECTORY		= "classpath:testcases";

	
	// The adapter has a configurable dependency on the port
	public ForParkingCarsTestAdapter ( ForParkingCars forParkingCars ) {
		super(forParkingCars);
	}


	/**
	 * Run Cucumber for the test cases located at "src/main/resources/testcases/"
	 * 
	 * Args:
	 * 
	 * --hardcodedhexagon		Optional flag. If present, run the tests cases for hardcoded driver port operations.
	 */
	@Override
	public void run ( String[] args ) {

		// the SUT (system under test) is the driver port (forParkingCars)
		SutProvider.FOR_PARKING_CARS.set ( this.driverPort() );

		String tagsToRun = REAL_HEXAGON_TAG;
		
		if ( (args.length > 0) && "--hardcodedhexagon".equals(args[0]) ) {
			tagsToRun = HARDCODED_HEXAGON_TAG;
		}

		String htmlReportFilePath = Paths.get ( HTML_REPORT_PATH, HTML_REPORT_FILENAME ).toAbsolutePath().toString();
		printMessage ( "||     VIEW THE HTML REPORT AT: " + htmlReportFilePath + "     ||" );
				
		String[] cucumberArgs = new String[]
				{
				"--glue",		GLUECODE_PACKAGE,
				"--plugin",		HTML_PLUGIN_PREFIX + htmlReportFilePath,
				"--plugin",		PRETTY_PLUGIN,
				"--tags",		tagsToRun,
				"--snippets",	SNIPPETS_CAMELCASE,
				TESTCASES_DIRECTORY
				};

		io.cucumber.core.cli.Main.main ( cucumberArgs );
		
	}


	private void printMessage ( String aMessagge ) {
		System.out.println();
		printLineForMessage(aMessagge);
		printLineForMessage(aMessagge);
		System.out.println(aMessagge);
		printLineForMessage(aMessagge);
		printLineForMessage(aMessagge);
	}

	private void printLineForMessage ( String aMessage ) {
		for ( int i=0; i < aMessage.length(); i++ ) {
			System.out.print("=");
		}
		System.out.println();
	}
	
}
