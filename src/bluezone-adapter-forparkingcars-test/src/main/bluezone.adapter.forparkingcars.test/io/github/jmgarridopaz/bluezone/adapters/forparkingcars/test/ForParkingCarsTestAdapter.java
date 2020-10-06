package io.github.jmgarridopaz.bluezone.adapters.forparkingcars.test;

import java.io.IOException;
import java.nio.file.Paths;

import io.github.jmgarridopaz.bluezone.adapters.forparkingcars.test.stepdefs.ScenarioContext;
import io.github.jmgarridopaz.bluezone.adapters.forparkingcars.test.sut.SutProvider;
import io.github.jmgarridopaz.bluezone.hexagon.forparkingcars.ForParkingCars;
import io.github.jmgarridopaz.lib.javalangutils.FileUtils;
import io.github.jmgarridopaz.lib.portsadapters.DriverAdapter;


/**
 * Adapter that uses Cucumber to run test cases against "for parking cars" port.
 * Test cases are feature files with cucumber scenarios.
 * There will be a feature file for each port operation.
 * Test cases execution results are shown in console and in html report.
 */
public class ForParkingCarsTestAdapter extends DriverAdapter<ForParkingCars> {
	
	private static final String GLUECODE_PACKAGE		= ScenarioContext.class.getPackageName();
	private static final String HTML_PLUGIN_PREFIX		= "html:";
	private static final String HTML_REPORT_FILE_PATH	= "forparkingcarsTestReport.html";
	private static final String PRETTY_PLUGIN			= "pretty";
	private static final String HARDCODED_HEXAGON_TAG	= "@hardCodedHexagon";
	private static final String REAL_HEXAGON_TAG		= "not @hardCodedHexagon";
	private static final String SNIPPETS_CAMELCASE		= "camelcase";
	private static final String TESTCASES_DIRECTORY		= "classpath:testcases";

	
	public ForParkingCarsTestAdapter ( ForParkingCars forParkingCars ) {
		super(forParkingCars);
	}

	
	@Override
	public void run ( String[] args ) {

		// the SUT (system under test) is the driver port (forParkingCars)
		SutProvider.FOR_PARKING_CARS.set ( this.driverPort() );
		
		String tagsToRun = REAL_HEXAGON_TAG;
		
		if ( (args.length > 0) && "--hardcodedhexagon".equals(args[0]) ) {
			tagsToRun = HARDCODED_HEXAGON_TAG;
		}
		
		System.out.println ( "=================================================" );
		System.out.println ( "HTML report: " + htmlReportFilePath );
		System.out.println ( "=================================================" );
				
		String[] cucumberArgs = new String[]
				{
				"--glue",		GLUECODE_PACKAGE,
				"--plugin",		HTML_PLUGIN_PREFIX + HTML_REPORT_FILE_PATH,
				"--plugin",		PRETTY_PLUGIN,
				"--tags",		tagsToRun,
				"--snippets",	SNIPPETS_CAMELCASE,
				TESTCASES_DIRECTORY
				};

		io.cucumber.core.cli.Main.main ( cucumberArgs );
		
	}


	private String buildHtmlReportFilePath() {
		String targetDiretory = FileUtils.valueOfKeyFromPropertiesFile ( Paths.get("project.properties"), "target.dir" ).orElseThrow(() -> new RuntimeException("Could not read target directory"));
		String filePath;
		try {
			filePath = Paths.get(targetDiretory,HTML_REPORT_FILE_NAME).toRealPath().toString();
		} catch (IOException e) {
			throw new RuntimeException("Could not build html report file path",e);
		}
		return filePath;
	}
	
}
