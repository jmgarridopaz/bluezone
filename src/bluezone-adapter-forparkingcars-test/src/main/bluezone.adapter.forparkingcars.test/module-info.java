module bluezone.adapter.forparkingcars.test {

//	DEPENDENCIES: Hexagon, libs, test framework

	requires bluezone.hexagon;	
	
	requires io.github.jmgarridopaz.lib.portsadapters;
	
	requires io.cucumber.java;
	requires io.cucumber.datatable;
	requires io.cucumber.core;
	requires org.hamcrest;


//	PUBLISH: adapter class, runtime access to frameworks

	exports io.github.jmgarridopaz.bluezone.adapter.forparkingcars.test;
	
	opens	io.github.jmgarridopaz.bluezone.adapter.forparkingcars.test.stepdefs
	to		io.cucumber.java,
			picocontainer;
	
	
//	SERVICES for accessing driven side and build the driver port from it
	
	uses	io.github.jmgarridopaz.bluezone.adapter.forparkingcars.test.SystemUnderTest;
	uses	io.github.jmgarridopaz.bluezone.adapter.forparkingcars.test.TestFixture;
	
}
