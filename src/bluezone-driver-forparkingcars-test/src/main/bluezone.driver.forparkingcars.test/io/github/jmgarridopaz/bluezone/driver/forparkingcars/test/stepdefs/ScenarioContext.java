package io.github.jmgarridopaz.bluezone.driver.forparkingcars.test.stepdefs;

import io.github.jmgarridopaz.bluezone.driver.forparkingcars.test.ForParkingCarsTestDriver;
import io.github.jmgarridopaz.bluezone.hexagon.*;

import java.util.Map;

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

	private final ForParkingCars carParker;
	private final ForConfiguringApp appConfigurator;
	private Map<String, Rate> currentRatesByName;
	private Ticket currentTicketWithCode;
	private String purchasedTicketCode;
	private PayErrorException payErrorException;

	public ScenarioContext() {
		this.carParker = ForParkingCarsTestDriver.CAR_PARKER;
		this.appConfigurator = ForParkingCarsTestDriver.APP_CONFIGURATOR;
	}

	public ForParkingCars carParker() { return this.carParker; }

	public ForConfiguringApp appConfigurator() {
		return this.appConfigurator;
	}

	public Map<String, Rate> currentRatesByName() {
		return this.currentRatesByName;
	}

	public void setCurrentRatesByName(Map<String, Rate> ratesByName) {
		this.currentRatesByName = ratesByName;
	}

	public Ticket currentTicketWithCode() {
		return this.currentTicketWithCode;
	}

	public void setCurrentTicketWithCode ( Ticket ticket ) {
		this.currentTicketWithCode = ticket;
	}

	public String purchasedTicketCode() {
		return this.purchasedTicketCode;
	}

	public void setPurchasedTicketCode ( String ticketCode) {
		this.purchasedTicketCode = ticketCode;
	}

	public PayErrorException payErrorException() {
		return this.payErrorException;
	}

	public void setPayErrorException(PayErrorException payErrorException) {
		this.payErrorException = payErrorException;
	}
}
