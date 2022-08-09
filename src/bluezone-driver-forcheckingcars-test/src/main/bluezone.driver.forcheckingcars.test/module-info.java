module bluezone.driver.forcheckingcars.test {

	// DEPENDS ON
	requires bluezone.hexagon;
	requires io.github.jmgarridopaz.lib.portsadapters;
	requires org.testng;
	requires org.hamcrest;

	// PUBLISHES
	exports io.github.jmgarridopaz.bluezone.driver.forcheckingcars.test;
	exports io.github.jmgarridopaz.bluezone.driver.forcheckingcars.test.illegallyparkedcar
	to org.testng;

}
