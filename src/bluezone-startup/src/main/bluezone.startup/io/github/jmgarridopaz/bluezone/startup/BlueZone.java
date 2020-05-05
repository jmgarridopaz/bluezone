package io.github.jmgarridopaz.bluezone.startup;

import java.nio.file.Path;
import java.nio.file.Paths;
import io.github.jmgarridopaz.bluezone.driveradapters.forparkingcars.test.ForParkingCarsTestAdapter;
import io.github.jmgarridopaz.bluezone.hexagon.HardCodedHexagon;
import io.github.jmgarridopaz.lib.javalangutils.FileUtils;


public class BlueZone {

	private static final Path	DEFAULT_CONFIG_FILE		= Paths.get ( System.getProperty("user.dir"), "bluezone.properties" );
	private static final String	HTML_REPORTS_DIR_KEY	= "forparkingcars.test.htmlreports";

	
	public static void main ( String[] args ) {
		
		if ( args.length > 1 ) {
			System.out.println( "Wrong number of arguments." );
			return;
		}
		
		Path configFile = DEFAULT_CONFIG_FILE;		
		if ( args.length == 1 ) {
			configFile = Paths.get ( args[0] );
		}
		
		HardCodedHexagon hardCodedHexagon = new HardCodedHexagon();
		
		ForParkingCarsTestAdapter forParkingCarsTestAdapter = new ForParkingCarsTestAdapter(hardCodedHexagon.forParkingCars());
		
		String htmlReportsDirectory	= FileUtils.valueOfKeyFromPropertiesFile(configFile,HTML_REPORTS_DIR_KEY).orElse("");

		forParkingCarsTestAdapter.run ( new String[]{htmlReportsDirectory,"--hc"} );

	}

}
