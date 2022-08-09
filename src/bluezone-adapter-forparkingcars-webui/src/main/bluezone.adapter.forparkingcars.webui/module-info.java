module bluezone.adapter.forparkingcars.webui {

	// DEPENDS ON
	requires bluezone.hexagon;
	requires io.github.jmgarridopaz.lib.portsadapters;
	requires spring.boot.starter.web;
	requires spring.boot.starter.thymeleaf;
	requires bootstrap;
	requires spring.boot;
	requires spring.boot.autoconfigure;
	requires spring.context;
	requires spring.beans;
	requires spring.web;
	requires org.apache.tomcat.embed.core;
	requires thymeleaf;
	requires thymeleaf.spring5;
    requires spring.webmvc;

    // PUBLISHES
	exports io.github.jmgarridopaz.bluezone.adapter.forparkingcars.webui;
	opens io.github.jmgarridopaz.bluezone.adapter.forparkingcars.webui
	to spring.core;

}
