module bluezone.adapter.forcheckingcars.test {

/*
 * DEPENDENCIES: Hexagon, libs, test framework
 */
	requires bluezone.hexagon;	
	
	requires io.github.jmgarridopaz.lib.portsadapters;
	
	requires org.junit.jupiter.engine;
	requires org.junit.jupiter.api;
	requires org.junit.platform.launcher;
	
	
/*
 * PUBLISH: adapter class
 */
	exports io.github.jmgarridopaz.bluezone.adapters.forcheckingcars.test;
	
}
