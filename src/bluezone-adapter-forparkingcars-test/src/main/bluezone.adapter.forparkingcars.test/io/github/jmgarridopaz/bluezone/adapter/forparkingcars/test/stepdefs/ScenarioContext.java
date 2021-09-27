																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																											package io.github.jmgarridopaz.bluezone.adapter.forparkingcars.test.stepdefs;

import java.time.Clock;
import java.util.Map;
import io.github.jmgarridopaz.bluezone.hexagon.ForObtainingRates;
import io.github.jmgarridopaz.bluezone.hexagon.ForParkingCars;
import io.github.jmgarridopaz.bluezone.hexagon.ForPaying;
import io.github.jmgarridopaz.bluezone.hexagon.ForStoringPermits;
import io.github.jmgarridopaz.bluezone.hexagon.Hexagon;
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

	private ForObtainingRates		rateProvider;
	private ForStoringPermits		permitStorage;
	private ForPaying				paymentService;
	private Clock					clockWithCurrentDateTime;
	private Map<String,RateData>	existingRatesByName;
	private PermitTicket			issuedPermitTicket;

	public ScenarioContext() {
	}
	

	Hexagon hexagon() {
		return Hexagon.build ( this.rateProvider(), this.permitStorage(), this.paymentService() );
	}


	ForObtainingRates rateProvider() {
		if ( this.rateProvider==null ) {
			this.rateProvider = RateProvider.get();
		}
		return this.rateProvider;
	}

	ForStoringPermits permitStorage() {
		if ( this.permitStorage==null ) {
			this.permitStorage = PermitStorage.get();
		}
		return this.permitStorage;
	}

	ForPaying paymentService() {
		if ( this.paymentService==null ) {
			this.paymentService = PaymentService.get();
		}
		return this.paymentService;
	}

	void setClockWithCurrentDateTime ( Clock clock ) {
		this.clockWithCurrentDateTime = clock;		
	}
	Clock clockWithCurrentDateTime() {
		return this.clockWithCurrentDateTime;
	}
	
	void setExistingRatesByName(Map<String,RateData> ratesByName) {
		this.existingRatesByName = ratesByName;
	}
	Map<String, RateData> existingRatesByName() {
		return this.existingRatesByName;
	}

	void setIssuedPermitTicket(PermitTicket permitTicket) {
		this.issuedPermitTicket = permitTicket;
	}
	PermitTicket issuedPermitTicket() {
		return this.issuedPermitTicket;
	}

}
