package io.github.jmgarridopaz.bluezone.adapter.forcheckingcars.test;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlGroups;
import org.testng.xml.XmlRun;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import io.github.jmgarridopaz.bluezone.adapter.forcheckingcars.test.sut.SutProvider;
import io.github.jmgarridopaz.bluezone.adapter.forcheckingcars.test.testcases.IllegallyParkedCarTest;
import io.github.jmgarridopaz.bluezone.hexagon.driver.forcheckingcars.ForCheckingCars;
import io.github.jmgarridopaz.lib.portsadapters.DriverAdapter;

/**
 * 
 * Driver adapter that runs "forcheckingcars" port test cases.
 * 
 * It uses TestNG framework.
 * 
 * For each port operation (use case), there will be a '@Test' class.
 * 
 * Test cases are '@Test' methods in those classes.
 * 
 */
public class ForCheckingCarsTestAdapter extends DriverAdapter<ForCheckingCars> {
	
	public static final String	HARDCODED_HEXAGON_GROUP	= "hardcodedHexagon";

	// The driver adapter has a configurable dependency on the port
	public ForCheckingCarsTestAdapter ( ForCheckingCars forCheckingCars ) {
		super(forCheckingCars);
	}

	/**
	 * Runs the driver adapter with the given args.
	 * 
	 * Launches TestNG for a test suite with a test class for each port operation (use case).
	 * 
	 * Generates HTML report in an output directory called 'test-output'
	 * 
	 * Args: -hch	Optional flag.
	 * 							If present, run test cases included in the 'hardcodedHexagon' group
	 * 							Otherwise, run test cases not included in the 'hardcodedHexagon' group
	 */
	@Override
	public void run ( String[] args ) {
		
		// The SUT (System Under Test) is the driver port (forCheckingCars)
		SutProvider.FOR_CHECKING_CARS.set ( this.driverPort() );

		// Hardcoded Hexagon ?
		boolean hardCodedHexagon = ( (args.length > 0) && "-hch".equals(args[0]) );

		// Run TestNG with a XML virtual file
		XmlSuite suite = new XmlSuite();
		suite.setName("ForCheckingCars_Test_Suite");
		
		XmlTest test = new XmlTest(suite);
		test.setName("IllegallyParkedCar_Test");
		
		XmlGroups groups = new XmlGroups();
		XmlRun run = new XmlRun();
		if ( hardCodedHexagon ) {
			run.onInclude(HARDCODED_HEXAGON_GROUP);
		} else {
			run.onExclude(HARDCODED_HEXAGON_GROUP);
		}
		groups.setRun(run);
		test.setGroups(groups);
		
		List<XmlClass> testClasses = new ArrayList<XmlClass>();
		testClasses.add ( new XmlClass(IllegallyParkedCarTest.class) );
		test.setClasses(testClasses);
		
		List<XmlSuite> suites = new ArrayList<XmlSuite>();
		suites.add(suite);
		
		TestNG testng = new TestNG();
		
		testng.setXmlSuites(suites);
		
		testng.run();
	}
	
}
