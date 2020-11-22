module bluezone.adapter.forcheckingcars.test {

/*
 * DEPENDENCIES: Hexagon, libs, test framework
 */
	requires bluezone.hexagon;	
	
	requires io.github.jmgarridopaz.lib.portsadapters;
	
	requires org.junit.jupiter.engine;
	requires org.junit.jupiter.api;
	requires org.junit.platform.launcher;
	requires org.junit.platform.engine;
	requires org.junit.platform.reporting;
	
/*
 * PUBLISH: adapter class, runtime access to framework
 */
	exports io.github.jmgarridopaz.bluezone.adapter.forcheckingcars.test;
	
	opens	io.github.jmgarridopaz.bluezone.adapter.forcheckingcars.test.testcases
	to		org.junit.platform.commons;
	
}
