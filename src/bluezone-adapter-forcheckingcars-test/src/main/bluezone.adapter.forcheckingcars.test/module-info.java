module bluezone.adapter.forcheckingcars.test {

/*
 * DEPENDENCIES: Hexagon, libs, test framework
 */
	requires bluezone.hexagon;	
	
	requires io.github.jmgarridopaz.lib.portsadapters;
	
	
/*
 * PUBLISH: adapter class
 */
	exports io.github.jmgarridopaz.bluezone.driveradapters.forcheckingcars.test
	to		bluezone.startup;
	
}
