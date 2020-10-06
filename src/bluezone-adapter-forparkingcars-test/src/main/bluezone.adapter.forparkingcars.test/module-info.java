module bluezone.adapter.forparkingcars.test {

/*
 * DEPENDENCIES: Hexagon, libs, test framework
 */
	requires bluezone.hexagon;	
	
	requires io.github.jmgarridopaz.lib.portsadapters;
	requires io.github.jmgarridopaz.lib.javalangutils;
	
	requires io.cucumber.java;
	requires junit;
	requires io.cucumber.datatable;
	requires io.cucumber.core;
	
	
/*
 * PUBLISH: adapter class, runtime access to frameworks
 */
	exports io.github.jmgarridopaz.bluezone.adapters.forparkingcars.test;
	
	opens	io.github.jmgarridopaz.bluezone.adapters.forparkingcars.test.stepdefs
	to		picocontainer,
			io.cucumber.java;
	
}
