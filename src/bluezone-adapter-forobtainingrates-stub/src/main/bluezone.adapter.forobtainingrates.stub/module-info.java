import io.github.jmgarridopaz.bluezone.hexagon.ports.driven.forobtainingrates.ForObtainingRates;

module bluezone.adapter.forobtainingrates.stub {

	// DEPENDS ON
	requires bluezone.hexagon;
	requires io.github.jmgarridopaz.lib.portsadapters;

	// PUBLISHES
	exports io.github.jmgarridopaz.bluezone.adapter.forobtainingrates.stub;

	// SERVICES
	provides ForObtainingRates
		with io.github.jmgarridopaz.bluezone.adapter.forobtainingrates.stub.StubRateProviderAdapter;

}
