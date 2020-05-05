package io.github.jmgarridopaz.bluezone.driveradapters.forparkingcars.test;
	
import io.github.jmgarridopaz.bluezone.driveradapters.forparkingcars.test.stepdefs.ForParkingCarsProvider;

import io.github.jmgarridopaz.bluezone.hexagon.driverports.forparkingcars.ForParkingCars;
import io.github.jmgarridopaz.lib.portsadapters.AbstractDriverAdapter;


public class ForParkingCarsTestAdapter extends AbstractDriverAdapter<ForParkingCars> {

	private static final String DEFAULT_TESTCASES_DIR = "classpath:testcases";
	private static final String HARDCODED_TESTCASES_DIR = "classpath:hctestcases";

	
	public ForParkingCarsTestAdapter ( ForParkingCars forParkingCars ) {
		super(forParkingCars);
		ForParkingCarsProvider.INSTANCE.set(forParkingCars);
	}

	
	/**
	 * Run the "for parking cars" test cases.
	 * 
	 * Test cases are cucumber scenarios defined in feature files.
	 * There will be a feature file for each port operation.
	 * 
	 * Test cases execution results are shown in console and in html reports.
	 * 
	 * @param	args[0] =	<outputDirectory>
	 * 						Absolute path of the directory where html reports will be created
	 * 
	 * 			args[1] =	[--hc]
	 * 						Optional. Flag for running hardcoded hexagon tests cases (located at "hctestcases" resources folder).
	 * 						If not present, real hexagon test cases will be run (located at "testcases" resources folder).
	 */
	@Override
	public void run ( String[] args ) {

		if	( args.length==0 || args.length>2 || (args.length==2 && !"--hc".equals(args[1])) ) {
			throw new IllegalArgumentException();
		}
		
		String	reportsDirectory	= args[0];		
		String	featuresDirectory	= ( (args.length==2) ? HARDCODED_TESTCASES_DIR :  DEFAULT_TESTCASES_DIR );
		
		String[] cucumberArgs = new String[]
				{
				"--strict",
				"-p",			"pretty",
				"-p",			"html:" + reportsDirectory,
				"--snippets",	"camelcase",
				"-g",			ForParkingCarsTestAdapter.class.getPackageName()+".stepdefs",
				featuresDirectory
				};

		io.cucumber.core.cli.Main.main ( cucumberArgs );
		
		System.out.println("Output: HTML reports written to '"+reportsDirectory+"' directory.");
		System.out.println("Open 'index.html' in web browser to see them.");
		
	}
	
}
