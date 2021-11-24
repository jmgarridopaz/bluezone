package io.github.jmgarridopaz.bluezone.adapter.forparkingcars.test.stepdefs;

import java.time.Clock;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import io.github.jmgarridopaz.bluezone.adapter.forparkingcars.test.TestFixture;
import io.github.jmgarridopaz.bluezone.adapter.forparkingcars.test.SystemUnderTest;
import io.github.jmgarridopaz.bluezone.hexagon.ForObtainingRates;
import io.github.jmgarridopaz.bluezone.hexagon.ForParkingCars;
import io.github.jmgarridopaz.bluezone.hexagon.ForPaying;
import io.github.jmgarridopaz.bluezone.hexagon.ForStoringPermits;
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

	private boolean					existSomeRateRepository;
	private boolean					existSomePermitRepository;
	private boolean					existSomePaymentRecipient;
	private Set<RateData>			initialRates;
	private Set<PermitTicket>		initialPermits;
	private Map<String,RateData>	existingRatesByName;
	private PermitTicket			issuedPermitTicket;
	
	public ScenarioContext() {
		this.existSomeRateRepository = true;
		this.existSomePermitRepository = true;
		this.existSomePaymentRecipient = true;
		this.initialRates = new HashSet<RateData>();
		this.initialPermits = new HashSet<PermitTicket>();
	}


	void setExistSomeRateRepository(boolean existSomeRateRepository) {
		this.existSomeRateRepository = existSomeRateRepository;
	}

	void setExistSomePermitRepository(boolean existSomePermitRepository) {
		this.existSomePermitRepository = existSomePermitRepository;
	}

	void setExistSomePaymentRecipient(boolean existSomePaymentRecipient) {
		this.existSomePaymentRecipient = existSomePaymentRecipient;
	}

	void setInitialRates(Set<RateData> initialRates) {
		this.initialRates = initialRates;
	}

	void setInitialPermits(Set<PermitTicket> initialPermits) {
		this.initialPermits = initialPermits;
	}

	Map<String, RateData> getExistingRatesByName() {
		return this.existingRatesByName;
	}

	void setExistingRatesByName(Map<String, RateData> existingRatesByName) {
		this.existingRatesByName = existingRatesByName;
	}

	PermitTicket getIssuedPermitTicket() {
		return this.issuedPermitTicket;
	}

	void setIssuedPermitTicket(PermitTicket issuedPermitTicket) {
		this.issuedPermitTicket = issuedPermitTicket;
	}

	ForParkingCars systemUnderTest() {
		ForObtainingRates rateRepository = rateRepository();
		ForStoringPermits permitRepository = permitRepository();
		ForPaying paymentRecipient = paymentRecipient();
		return SystemUnderTest.provider().buildForParkingCarsFrom(rateRepository,permitRepository,paymentRecipient);
	}
		
	private ForObtainingRates rateRepository() {
		if ( ! this.existSomeRateRepository ) {
			return null;
		}
		return TestFixture.provider().initRateRepositoryWith ( this.initialRates );
	}
	
	private ForStoringPermits permitRepository() {
		if ( ! this.existSomePermitRepository ) {
			return null;
		}
		return TestFixture.provider().initPermitRepositoryWith ( this.initialPermits );
	}

	private ForPaying paymentRecipient() {
		if ( ! this.existSomePaymentRecipient ) {
			return null;
		}
		return TestFixture.provider().initPaymentRecipient();
	}

}
