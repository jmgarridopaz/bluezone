import io.github.jmgarridopaz.bluezone.adapter.forpaying.spy.SpyPaymentServiceAdapter;
import io.github.jmgarridopaz.bluezone.hexagon.ports.driven.forpaying.ForPaying;

module bluezone.adapter.forpaying.spy {

	// DEPENDS ON
	requires bluezone.hexagon;
	requires io.github.jmgarridopaz.lib.portsadapters;

	// PUBLISHES
	exports io.github.jmgarridopaz.bluezone.adapter.forpaying.spy;

	// SERVICES
	provides ForPaying
		with SpyPaymentServiceAdapter;
}
