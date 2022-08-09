package io.github.jmgarridopaz.bluezone.driver.forcheckingcars.test;

import io.github.jmgarridopaz.lib.portsadapters.Driver;
import org.testng.TestNG;
import org.testng.xml.*;
import io.github.jmgarridopaz.bluezone.hexagon.ForCheckingCars;
import io.github.jmgarridopaz.bluezone.hexagon.ForConfiguringApp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Driver (primary actor).
 * Test cases for the methods of "forcheckingcars" port.
 * It uses TestNG framework.
 */
public class ForCheckingCarsTestDriver implements Driver {

	private static final String REPORTS_DIRECTORY =
												System.getProperty("user.home") +
												System.getProperty("file.separator") +
												".testng" +
												System.getProperty("file.separator") +
												"reports";

	private final ForCheckingCars carChecker;
	private final ForConfiguringApp appConfigurator;

	/**
	 * The driver has a configurable dependency on two ports:
	 * @param carChecker		Port to be tested.
	 * @param appConfigurator	Port with the API for setting-up the driven side through the application.
	 */
	public ForCheckingCarsTestDriver ( ForCheckingCars carChecker, ForConfiguringApp appConfigurator) {
		this.carChecker = carChecker;
		this.appConfigurator = appConfigurator;
	}

	/**
	 * Launches TestNG.
	 * TestNG suite ==> test ==> test class ==> test method.
	 * Generates HTML report in the 'path-to-user-home-directory/.testng/reports' directory.
	 */
	@Override
	public void run ( String... args ) {

		// Set the 2 driver ports as the system under test
		SystemUnderTest.instance().setCarChecker( this.carChecker );
		SystemUnderTest.instance().setAppConfigurator( this.appConfigurator );

		// Run TestNG with a XML virtual file
		XmlSuite suite = new XmlSuite();
		suite.setName("ForCheckingCars_Test_Suite");

		XmlTest test = new XmlTest(suite);
		test.setName("IllegallyParkedCar_Test");

		XmlPackage xmlPackage = new XmlPackage ( "io.github.jmgarridopaz.bluezone.driver.forcheckingcars.test.illegallyparkedcar.*" );
		test.setPackages( Arrays.asList(new XmlPackage[]{xmlPackage}));

		List<XmlSuite> suites = new ArrayList<XmlSuite>();
		suites.add(suite);

		TestNG testng = new TestNG();

		testng.setXmlSuites(suites);

		testng.setOutputDirectory (REPORTS_DIRECTORY);

		System.out.println();
		System.out.println("=====");
		System.out.println("Reports will be generated in the following output directory:");
		System.out.println( testng.getOutputDirectory() );
		System.out.println("=====");
		System.out.println();

		testng.run();
	}
	
}
