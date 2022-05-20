module bluezone.driver.forparkingcars.test {

	requires bluezone.hexagon;

	requires io.cucumber.java;
	requires io.cucumber.datatable;
	requires io.cucumber.core;
	requires org.hamcrest;

	exports io.github.jmgarridopaz.bluezone.driver.forparkingcars.test;
	
	opens	io.github.jmgarridopaz.bluezone.driver.forparkingcars.test.stepdefs
	to		io.cucumber.java,
			picocontainer;
	
}
