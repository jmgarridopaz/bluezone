package io.github.jmgarridopaz.bluezone.adapter.forcheckingcars.test;

import io.github.jmgarridopaz.bluezone.adapter.forcheckingcars.test.testcases.IllegallyParkedCarTest;
import org.testng.TestNG;
import org.testng.xml.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Driver (primary actor).
 * Test cases for the operations of "forcheckingcars" port.
 * It uses TestNG framework.
 */
public class ForCheckingCarsTestDriver {
	
	public static final String HARDCODED_HEXAGON_GROUP = "hardcodedHexagon";
	private static final String REPORTS_DIRECTORY = Reports.targetSubDirectory("reports");

	/**
	 * Program that launches a TestNG suite.
	 * The test suite has a '@Test' class for each port operation (use case).
	 * Test cases are '@Test' methods in those classes.
	 *
	 * Generates HTML report in the 'reports' subdirectory under 'target' maven directory.
	 * 
	 * Args: -hch	Optional flag.
	 * 							If present, run test cases included in the 'hardcodedHexagon' group
	 * 							Otherwise, run test cases not included in the 'hardcodedHexagon' group
	 */
	public static void main ( String[] args ) {
		
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
