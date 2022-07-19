module bluezone.adapter.forparkingcars.webui {

	requires bluezone.hexagon;

	uses io.github.jmgarridopaz.bluezone.adapter.forparkingcars.webui.ForParkingCarsGetter;

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
//	requires thymeleaf.spring5;
//

	exports io.github.jmgarridopaz.bluezone.adapter.forparkingcars.webui;

	opens io.github.jmgarridopaz.bluezone.adapter.forparkingcars.webui
	to spring.core;





//	exports io.github.jmgarridopaz.webapp.library;
//
//	exports io.github.jmgarridopaz.webapp.library.business
//			to spring.beans;
//
//	exports io.github.jmgarridopaz.webapp.library.presentation
//			to spring.beans, spring.web;
//
//	opens io.github.jmgarridopaz.webapp.library
//			to spring.core;

}
