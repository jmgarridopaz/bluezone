module bluezone.adapter.forcheckingcars.test {

/*
 * DEPENDENCIES: Hexagon, libs, test framework
 */
	requires bluezone.hexagon;	
	
	requires io.github.jmgarridopaz.lib.portsadapters;
	
	requires org.testng;
	requires org.hamcrest;
	
/*
 * PUBLISH: adapter class, runtime access to framework
 */
	exports io.github.jmgarridopaz.bluezone.adapter.forcheckingcars.test;
	
	opens	io.github.jmgarridopaz.bluezone.adapter.forcheckingcars.test.testcases
	to		org.testng;
	
}
