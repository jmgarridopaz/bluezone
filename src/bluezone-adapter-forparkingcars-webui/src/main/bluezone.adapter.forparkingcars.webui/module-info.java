open module bluezone.adapter.forparkingcars.webui {
// Opened because Thymeleaf needs access to templates resources at runtime

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
	requires thymeleaf.extras.java8time;
    requires spring.webmvc;
	requires spring.core;

    // PUBLISHES
	exports io.github.jmgarridopaz.bluezone.adapter.forparkingcars.webui;

}
