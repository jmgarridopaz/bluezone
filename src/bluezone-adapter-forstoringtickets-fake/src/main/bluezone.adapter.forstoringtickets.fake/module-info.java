import io.github.jmgarridopaz.bluezone.hexagon.ports.driven.forstoringtickets.ForStoringTickets;

module bluezone.adapter.forstoringtickets.fake {

	// DEPENDS ON
	requires bluezone.hexagon;
	requires io.github.jmgarridopaz.lib.portsadapters;

	// PUBLISHES
	exports io.github.jmgarridopaz.bluezone.adapter.forstoringtickets.fake;

	// SERVICES
	provides ForStoringTickets
	with io.github.jmgarridopaz.bluezone.adapter.forstoringtickets.fake.FakeTicketStoreAdapter;
	
}
