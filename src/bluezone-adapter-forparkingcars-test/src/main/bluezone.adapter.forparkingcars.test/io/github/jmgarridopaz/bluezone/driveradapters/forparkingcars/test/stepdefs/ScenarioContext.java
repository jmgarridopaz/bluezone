package io.github.jmgarridopaz.bluezone.driveradapters.forparkingcars.test.stepdefs;

import java.time.Clock;
import java.util.Set;
import io.github.jmgarridopaz.bluezone.hexagon.driverports.forparkingcars.PermitTicket;
import io.github.jmgarridopaz.bluezone.hexagon.driverports.forparkingcars.RateInfo;


/**
 * Class for sharing state between different steps files in one scenario.
 * It is instantiated and injected into the step defs by PicoContainer (DI framework).
 * 
 * Put this class in stepdefs package to be recreated for every scenario, so that
 * there won't be state leakage between scenarios.
 */
public class ScenarioContext {

	private Set<RateInfo> rates;
	private PermitTicket permitTicket;
	private Clock clock;

	public ScenarioContext() {}
	
	
	void setRates(Set<RateInfo> rates) {
		this.rates = rates;
	}

	Set<RateInfo> rates() {
		return this.rates;
	}


	void setPermitTicket(PermitTicket permitTicket) {
		this.permitTicket = permitTicket;
	}

	PermitTicket permitTicket() {
		return this.permitTicket;
	}

	
	void setClock(Clock clock) {
		this.clock = clock;		
	}

	Clock clock() {
		return this.clock;
	}
	
}
