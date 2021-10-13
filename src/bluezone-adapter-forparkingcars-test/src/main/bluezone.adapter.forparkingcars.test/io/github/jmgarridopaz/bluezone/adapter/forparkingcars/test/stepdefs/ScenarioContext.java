package io.github.jmgarridopaz.bluezone.adapter.forparkingcars.test.stepdefs;

import java.time.Clock;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import io.github.jmgarridopaz.bluezone.adapter.forparkingcars.test.DrivenSide;
import io.github.jmgarridopaz.bluezone.hexagon.ForObtainingRates;
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

	private boolean					noRateRepositoryPresent;
	private boolean					noPermitRepositoryPresent;
	private boolean					noPaymentRecipientPresent;
	private Set<RateData>			initialRates;
	private Set<PermitTicket>		initialPermits;
	private Clock					clockWithCurrentDateTime;
	private Map<String,RateData>	existingRatesByName;
	private PermitTicket			issuedPermitTicket;

	
	public ScenarioContext() {
		this.noRateRepositoryPresent = false;
		this.noPermitRepositoryPresent = false;
		this.noPaymentRecipientPresent = false;
		this.initialRates = new HashSet<RateData>();
		this.initialPermits = new HashSet<PermitTicket>();
	}


	boolean isNoRateRepositoryPresent() {
		return noRateRepositoryPresent;
	}


	void setNoRateRepositoryPresent(boolean noRateRepositoryPresent) {
		this.noRateRepositoryPresent = noRateRepositoryPresent;
	}


	boolean isNoPermitRepositoryPresent() {
		return noPermitRepositoryPresent;
	}


	void setNoPermitRepositoryPresent(boolean noPermitRepositoryPresent) {
		this.noPermitRepositoryPresent = noPermitRepositoryPresent;
	}


	boolean isNoPaymentRecipientPresent() {
		return noPaymentRecipientPresent;
	}


	void setNoPaymentRecipientPresent(boolean noPaymentRecipientPresent) {
		this.noPaymentRecipientPresent = noPaymentRecipientPresent;
	}


	Set<RateData> getInitialRates() {
		return initialRates;
	}


	void setInitialRates(Set<RateData> initialRates) {
		this.initialRates = initialRates;
	}


	Set<PermitTicket> getInitialPermits() {
		return initialPermits;
	}


	void setInitialPermits(Set<PermitTicket> initialPermits) {
		this.initialPermits = initialPermits;
	}


	Clock getClockWithCurrentDateTime() {
		return clockWithCurrentDateTime;
	}


	void setClockWithCurrentDateTime(Clock clockWithCurrentDateTime) {
		this.clockWithCurrentDateTime = clockWithCurrentDateTime;
	}


	Map<String, RateData> getExistingRatesByName() {
		return existingRatesByName;
	}


	void setExistingRatesByName(Map<String, RateData> existingRatesByName) {
		this.existingRatesByName = existingRatesByName;
	}


	PermitTicket getIssuedPermitTicket() {
		return issuedPermitTicket;
	}


	void setIssuedPermitTicket(PermitTicket issuedPermitTicket) {
		this.issuedPermitTicket = issuedPermitTicket;
	}

}
