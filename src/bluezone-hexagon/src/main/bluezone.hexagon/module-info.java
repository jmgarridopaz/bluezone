module bluezone.hexagon {
	
	exports io.github.jmgarridopaz.bluezone.hexagon;
	
	// driver ports
	exports io.github.jmgarridopaz.bluezone.hexagon.driver.forparkingcars;
	exports io.github.jmgarridopaz.bluezone.hexagon.driver.forcheckingcars;	
			
	// driven ports
	exports io.github.jmgarridopaz.bluezone.hexagon.driven.forobtainingrates;
	exports io.github.jmgarridopaz.bluezone.hexagon.driven.forstoringpermits;
	exports io.github.jmgarridopaz.bluezone.hexagon.driven.forpaying;

	// data used by ports
	exports io.github.jmgarridopaz.bluezone.hexagon.permit;
	
	// hardcoded hexagon implementation (providers of driver ports services)
	provides	io.github.jmgarridopaz.bluezone.hexagon.driver.forparkingcars.ForParkingCars
	with		io.github.jmgarridopaz.bluezone.hexagon.driver.forparkingcars.implementation.hardcoded.HardCodedCarParker;
	
	provides	io.github.jmgarridopaz.bluezone.hexagon.driver.forcheckingcars.ForCheckingCars
	with		io.github.jmgarridopaz.bluezone.hexagon.driver.forcheckingcars.implementation.hardcoded.HardCodedCarChecker;
	
}
