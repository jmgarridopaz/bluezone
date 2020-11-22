package io.github.jmgarridopaz.bluezone.adapter.forparkingcars.test;

import java.nio.file.Paths;

import io.github.jmgarridopaz.bluezone.adapter.forparkingcars.test.stepdefs.ScenarioContext;
import io.github.jmgarridopaz.bluezone.adapter.forparkingcars.test.sut.SutProvider;
import io.github.jmgarridopaz.bluezone.hexagon.driver.forparkingcars.ForParkingCars;
import io.github.jmgarridopaz.lib.portsadapters.DriverAdapter;

/**
 * Driver adapter that runs "forparkingcars" port test cases.
 * 
 * It uses Cucumber testing tool.
 * 
 * Test cases are Cucumber scenarios ("given-when-then" format) defined in feature files.
 * 
 * A feature ("As a <<role>> I want <<goal>> So that <<benefit>>" format) describes a port operation.
 * 
 * There will be a file for each feature (port operation).
 */
public class ForParkingCarsTestAdapter extends DriverAdapter<ForParkingCars> {
	
	private static final String GLUECODE_PACKAGE		= ScenarioContext.class.getPackageName();
	private static final String HTML_PLUGIN_PREFIX		= "html:";
	private static final String HTML_REPORT_PATH		= "target";
	private static final String HTML_REPORT_FILENAME	= "forparkingcarsTestReport.html";
	private static final String PRETTY_PLUGIN			= "pretty";
	private static final String HARDCODED_HEXAGON_TAG	= "@hardCodedHexagon";
	private static final String REAL_HEXAGON_TAG		= "not @hardCodedHexagon";
	private static final String SNIPPETS_CAMELCASE		= "camelcase";
	private static final String TESTCASES_DIRECTORY		= "classpath:testcases";

	/*
	 * The driver adapter has a configurable dependency on the port
	 */
	public ForParkingCarsTestAdapter ( ForParkingCars forParkingCars ) {
		super(forParkingCars);
	}

	/**
	 * Runs the driver adapter with the given args.
	 * 
	 * Launches Cucumber to run feature files at "src/main/resources/testcases/"
	 * 
	 * Creates a html report file ("output/forparkingcarsTestReport.html") under the working directory.
	 * 
	 * Args: --hardcodedhexagon		Optional flag.
	 * 								If present, run test cases tagged with '@hardCodedHexagon'
	 * 								Otherwise, run test cases not tagged with '@hardCodedHexagon'
	 */
	@Override
	public void run ( String[] args ) {
		/*
		 * The SUT (System Under Test) is the driver port (forParkingCars)
		 */
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
