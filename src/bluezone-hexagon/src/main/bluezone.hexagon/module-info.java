module bluezone.hexagon {
	
	exports io.github.jmgarridopaz.bluezone.hexagon;
	
	// driver ports
	exports io.github.jmgarridopaz.bluezone.hexagon.driverports.forparkingcars;
	exports io.github.jmgarridopaz.bluezone.hexagon.driverports.forcheckingcars;	
			
	// driven ports
	exports io.github.jmgarridopaz.bluezone.hexagon.drivenports.forobtainingrates;
	exports io.github.jmgarridopaz.bluezone.hexagon.drivenports.forstoringpermits;
	exports io.github.jmgarridopaz.bluezone.hexagon.drivenports.forpaying;

	// hardcoded hexagon implementation (providers of driver ports services)
	provides	io.github.jmgarridopaz.bluezone.hexagon.driverports.forparkingcars.ForParkingCars
	with		io.github.jmgarridopaz.bluezone.hexagon.driverports.forparkingcars.implementation.hardcoded.HardCodedCarParker;
	
	provides	io.github.jmgarridopaz.bluezone.hexagon.driverports.forcheckingcars.ForCheckingCars
	with		io.github.jmgarridopaz.bluezone.hexagon.driverports.forcheckingcars.implementation.hardcoded.HardCodedCarChecker;
	
}
