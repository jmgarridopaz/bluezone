module bluezone.startup {

	/*
	 * Depends on all the other modules: hexagon and adapters
	 */
	requires bluezone.hexagon;
	requires bluezone.adapter.forparkingcars.test;
	requires bluezone.adapter.forcheckingcars.test;
	requires bluezone.adapter.forobtainingrates.stub;
	
	
	/*
	 * Service:		hexagon provider
	 * Providers:	real and hardcoded
	 */
	uses io.github.jmgarridopaz.bluezone.startup.HexagonProvider;
	
	provides	io.github.jmgarridopaz.bluezone.startup.HexagonProvider
	with		io.github.jmgarridopaz.bluezone.startup.RealHexagonProvider,
				io.github.jmgarridopaz.bluezone.startup.HardcodedHexagonProvider;

}
