module bluezone.adapter.forobtainingrates.stub {

/*
 * DEPENDENCIES: Hexagon, libs
 */
	requires bluezone.hexagon;		
	requires io.github.jmgarridopaz.lib.portsadapters;

/*
 * DRIVEN ADAPTER = provider for the driven port service
 */
	provides io.github.jmgarridopaz.bluezone.hexagon.driven.forobtainingrates.ForObtainingRates
		with io.github.jmgarridopaz.bluezone.adapter.forobtainingrates.stub.ForObtainingRatesStubAdapter;
	
}
