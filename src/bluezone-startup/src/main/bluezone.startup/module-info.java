module bluezone.startup {

	/*
	 * Depends on all the other modules: hexagon and adapters
	 */
	requires bluezone.hexagon;
	requires bluezone.adapter.forparkingcars.test;
	requires bluezone.adapter.forcheckingcars.test;
	
	/*
	 * Services:	the driver ports
	 * Providers:	the implementations at hexagon module
	 */
	uses io.github.jmgarridopaz.bluezone.hexagon.driver.forparkingcars.ForParkingCars;
	uses io.github.jmgarridopaz.bluezone.hexagon.driver.forcheckingcars.ForCheckingCars;

}
