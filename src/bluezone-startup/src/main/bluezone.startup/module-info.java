module bluezone.startup {

	requires bluezone.hexagon;

	requires bluezone.driver.forparkingcars.test;
	requires bluezone.driver.forcheckingcars.test;
	requires bluezone.adapter.forparkingcars.webui;

	requires bluezone.adapter.forobtainingrates.stub;
	requires bluezone.adapter.forstoringtickets.fake;
	requires bluezone.adapter.forpaying.spy;

	provides io.github.jmgarridopaz.bluezone.adapter.forparkingcars.webui.ForParkingCarsGetter
	with io.github.jmgarridopaz.bluezone.startup.Main;

}
