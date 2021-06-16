package io.github.jmgarridopaz.bluezone.adapter.forparkingcars.test.stepdefs;

import java.time.Clock;
import java.util.List;
import java.util.Map;
import java.util.Set;

import io.github.jmgarridopaz.bluezone.adapter.forparkingcars.test.InitialData;
import io.github.jmgarridopaz.bluezone.adapter.forparkingcars.test.sut.SutProvider;
import io.github.jmgarridopaz.bluezone.hexagon.ForParkingCars;
import io.github.jmgarridopaz.bluezone.hexagon.PermitTicket;
import io.github.jmgarridopaz.bluezone.hexagon.RateData;

/**
 * Class for sharing state between different steps files in one scenario.
 * 
 * It is instantiated and injected into the stepdefs by PicoContainer (DI framework).
 * 
 * Put this class in stepdefs package to be recreated for every scenario.
 * 
 * So that there won't be state leakage between scenarios.
 */
public class ScenarioContext {

	private ForParkingCars forParkingCars;
	private Map<String,RateData> ratesByName;
	private PermitTicket permitTicket;
	private Clock clock;
	private Set<RateData> initialRates;

	public ScenarioContext() {
	}
	
	
	ForParkingCars forParkingCars() {
		if ( this.forParkingCars==null ) {
			InitialData initialData = new InitialData(this.initialRates);
			this.forParkingCars = SutProvider.FOR_PARKING_CARS.from(initialData);
		}
		return this.forParkingCars;
	}

	
	void setRatesByName(Map<String,RateData> ratesByName) {
		this.ratesByName = ratesByName;
	}

	Map<String, RateData> ratesByName() {
		return this.ratesByName;
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


	void setInitialRates(Set<RateData> initialRates) {
		this.initialRates = initialRates;
	}
	
}
