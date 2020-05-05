package io.github.jmgarridopaz.bluezone.hexagon.driverports.forparkingcars;

import java.time.Clock;
import java.util.Set;


public interface ForParkingCars {

	/**
	 * Returns the information of all the available rates in the city.
	 * 
	 * @return	a set of RateInfo objects
	 */
	public Set<RateInfo> getAllRates();

	
	/**
	 * Issues a permit for a car parked at a regulated area, valid until a datetime, paying it with a card.
	 * Returns a ticket with the permit information.
	 * 
	 * First the permit price is calculated, depending on the number of minutes of the permit period,
	 * according to the rate of the area where the car is parked.
	 * Then, permit price is charged to the payment card.
	 * And finally the permit is stored.
	 * 
	 * @param	a PermitRequest object with the following info:
	 * 
	 * 			clock			Clock to get current datetime from, since it will be the starting datetime of the permit period
	 * 			carPlate		Car plate of the car we want to get the permit for
	 * 			rateName		Rate name of the regulated area where we want to park the car
	 * 			endingDateTime	A datetime in the future, that will be the expiration date of the permit period
	 * 			paymentCardInfo	Information about the card to charge the permit price to.
	 * 
	 * @return	a PermitTicket object with the following info:
	 * 
	 * 			code				Unique identifier of the permit
	 * 			carPlate			Car plate of the car the permit has been issued for
	 * 			rateName			Rate name of the regulated area where the car is parked at
	 * 			startingDateTime	Datetime from when the permit is valid
	 * 			endingDateTime		Expiration datetime of the permit period
	 * 			priceAmount			Amount of money payed for the permit
	 * 			priceCurrencySymbol	Currency of the price amount
	 */
	public PermitTicket issuePermit ( Clock clock, PermitRequest permitRequest );

}
