package io.github.jmgarridopaz.bluezone.adapters.forparkingcars.test;

import io.github.jmgarridopaz.bluezone.adapters.forparkingcars.test.stepdefs.ScenarioContext;
import io.github.jmgarridopaz.bluezone.adapters.forparkingcars.test.sut.ForParkingCarsProvider;
import io.github.jmgarridopaz.bluezone.hexagon.forparkingcars.ForParkingCars;
import io.github.jmgarridopaz.lib.portsadapters.DriverAdapter;


/**
 * Adapter that uses Cucumber to run test cases against "for parking cars" port.
 * Test cases are feature files with cucumber scenarios.
 * There will be a feature file for each port operation.
 * Test cases execution results are shown in console and in html report.
 */
public class ForParkingCarsTestAdapter extends DriverAdapter<ForParkingCars> {
	
	private static final String TESTCASES_DIRECTORY		= "classpath:testcases";
	private static final String GLUECODE_PACKAGE		= ScenarioContext.class.getPackageName();
	private static final String HTML_PLUGIN_PREFIX		= "html:";
	private static final String HTML_REPORT_FILE_PATH	= "output/test/forparkingcarsreport.html";
	private static final String HTML_PLUGIN				= HTML_PLUGIN_PREFIX + HTML_REPORT_FILE_PATH;	
	private static final String HARDCODED_HEXAGON_TAG	= "@hardcoded";
	private static final String REAL_HEXAGON_TAG		= "not @hardcoded";

	
	public ForParkingCarsTestAdapter ( ForParkingCars forParkingCars ) {
		super(forParkingCars);
	}

	
	@Override
	public void run ( String[] args ) {

		ForParkingCarsProvider.INSTANCE.set ( this.driverPort() );
		
		String tagsToRun = REAL_HEXAGON_TAG;
		
		if ( (args.length > 0) && "--hardcoded".equals(args[0]) ) {
			tagsToRun = HARDCODED_HEXAGON_TAG;
		}
		
		String[] cucumberArgs = new String[]
				{
				"--glue",		GLUECODE_PACKAGE,
				"--plugin",		HTML_PLUGIN,
				"--plugin",		"pretty",
				"--tags",		tagsToRun,
				"--snippets",	"camelcase",
				TESTCASES_DIRECTORY
				};

		System.out.println ( "HTML report generated at: " + HTML_REPORT_FILE_PATH );
		
		io.cucumber.core.cli.Main.main ( cucumberArgs );
		
	}
	
}
