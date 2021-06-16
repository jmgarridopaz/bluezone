package io.github.jmgarridopaz.bluezone.startup.forparkingcars.test;

/**
 * Entry points to the application.
 * It runs the "forparkingcars" test adapter.
 * 
 * Delegates to a dependency configurator
 * that applies configurable dependency pattern
 * at both driven and driver sides.
 */
public class Startup {
	
	private final boolean hardcodedHexagon;

	private Startup ( String[] args ) {
		this.hardcodedHexagon = ( (args.length > 0) && "-hch".equals(args[0]) );
	}

	
	public static void main ( String[] args ) {
		Startup startup = new Startup ( args ); 
		DependencyConfigurator dependencyConfigurator = startup.dependencyConfigurator();
		dependencyConfigurator.instantiateForParkingCarsTestAdapter().run ( args );		
	}
	
	
	private DependencyConfigurator dependencyConfigurator() {
		if ( this.hardcodedHexagon ) {
			return DependencyConfigurator.withHardcodedHexagon();
		}
		return DependencyConfigurator.withRealHexagon();
	}
	
}
