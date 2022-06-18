module bluezone.driver.forcheckingcars.test {

	requires bluezone.hexagon;

	requires org.testng;
	requires org.hamcrest;
	
	exports io.github.jmgarridopaz.bluezone.driver.forcheckingcars.test;
	exports io.github.jmgarridopaz.bluezone.driver.forcheckingcars.test.illegallyparkedcar
	to org.testng;

}
