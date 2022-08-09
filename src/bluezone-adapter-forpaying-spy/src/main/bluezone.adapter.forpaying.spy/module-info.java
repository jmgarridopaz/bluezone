module bluezone.adapter.forpaying.spy {

	// DEPENDS ON
	requires bluezone.hexagon;
	requires io.github.jmgarridopaz.lib.portsadapters;

	// PUBLISHES
	exports io.github.jmgarridopaz.bluezone.adapter.forpaying.spy;

	// SERVICES
	provides io.github.jmgarridopaz.bluezone.hexagon.ForPaying
		with io.github.jmgarridopaz.bluezone.adapter.forpaying.spy.SpyEWalletServiceAdapter;
}
