
module bluezone.hexagon {
	
	// DEPENDS ON
	// a tool to avoid boilerplate code writing
	requires static lombok;
	// utils of Java language
	requires io.github.jmgarridopaz.lib.javalangutils;

	// PUBLISHES
	// driving ports
	exports io.github.jmgarridopaz.bluezone.hexagon.ports.driving.forparkingcars;
	exports io.github.jmgarridopaz.bluezone.hexagon.ports.driving.forcheckingcars;
	exports io.github.jmgarridopaz.bluezone.hexagon.ports.driving.forconfiguringapp;
	// driven ports
	exports io.github.jmgarridopaz.bluezone.hexagon.ports.driven.forobtainingrates;
	exports io.github.jmgarridopaz.bluezone.hexagon.ports.driven.forstoringtickets;
	exports io.github.jmgarridopaz.bluezone.hexagon.ports.driven.forpaying;

	exports io.github.jmgarridopaz.bluezone.hexagon.factory;
}
