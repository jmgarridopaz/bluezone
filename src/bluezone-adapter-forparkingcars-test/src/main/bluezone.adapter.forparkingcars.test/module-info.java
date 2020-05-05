module bluezone.adapter.forparkingcars.test {

/*
 * DEPENDENCIES: Hexagon, libs, test framework
 */
	requires bluezone.hexagon;	
	
	requires io.github.jmgarridopaz.lib.portsadapters;
	requires io.github.jmgarridopaz.lib.javalangutils;
	
	requires io.cucumber.java;
	requires io.cucumber.core;
	requires io.cucumber.datatable;
	requires junit;
	
	
/*
 * PUBLISH: adapter class, runtime access to frameworks
 */
	exports io.github.jmgarridopaz.bluezone.driveradapters.forparkingcars.test
	to		bluezone.startup;
	
	opens	io.github.jmgarridopaz.bluezone.driveradapters.forparkingcars.test.stepdefs
	to		io.cucumber.core,
			io.cucumber.java,
			picocontainer;
	
}
