module bluezone.startup {

	/*
	 * Depends on all the other modules: hexagon and adapers
	 */
	requires bluezone.hexagon;
	requires bluezone.adapter.forparkingcars.test;
	requires bluezone.adapter.forcheckingcars.test;
	
	/*
	 * Services:	the driver ports
	 * 				(providers are the implementations at hexagon module)
	 */
	uses io.github.jmgarridopaz.bluezone.hexagon.driverports.forparkingcars.ForParkingCars;
	uses io.github.jmgarridopaz.bluezone.hexagon.driverports.forcheckingcars.ForCheckingCars;

}
