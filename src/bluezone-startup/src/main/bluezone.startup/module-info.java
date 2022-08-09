module bluezone.startup {

	// DEPENDS ON
	// all the other modules
	requires bluezone.hexagon;
	requires bluezone.driver.forparkingcars.test;
	requires bluezone.driver.forcheckingcars.test;
	requires bluezone.adapter.forparkingcars.webui;
	requires bluezone.adapter.forobtainingrates.stub;
	requires bluezone.adapter.forstoringtickets.fake;
	requires bluezone.adapter.forpaying.spy;
	requires io.github.jmgarridopaz.lib.portsadapters;
	requires io.github.jmgarridopaz.lib.javalangutils;

	// SERVICES
	uses io.github.jmgarridopaz.bluezone.hexagon.ForObtainingRates;
	uses io.github.jmgarridopaz.bluezone.hexagon.ForStoringTickets;
	uses io.github.jmgarridopaz.bluezone.hexagon.ForPaying;

}
