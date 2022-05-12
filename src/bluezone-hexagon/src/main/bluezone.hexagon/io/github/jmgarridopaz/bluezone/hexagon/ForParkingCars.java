package io.github.jmgarridopaz.bluezone.hexagon;

import java.util.Map;


public interface ForParkingCars {

	/**
	 * Returns the available rates in the city, indexed by name.
	 *
	 * @return	a map of RateData objects, with the rate name as the key.
	 * @see RateData
	 */
	public Map<String, RateData> getAllRatesByName();

	/**
	 * Pays an amount for a ticket, valid for parking a car at a zone during a period of time.
	 * The ticket period starts at current date-time.
	 * The ending date-time is calculated from the paid amount, according to the rate of the zone the car is parked at.
	 * The payment is done by charging the amount to the wallet associated to the car.
	 *
	 * @param ticketRequest	Data needed for buying a parking ticket.
	 * @return				A Ticket object with the data of the parking period that has been paid for.
	 * @throws NotEnoughMoneyException
	 * 						When the amount in the wallet associated to the car is lower than the amount to pay for the ticket.
	 * @see TicketRequest
	 * @see Ticket
	 * @see NotEnoughMoneyException
	 */
	public Ticket purchaseTicket ( TicketRequest ticketRequest );

}
