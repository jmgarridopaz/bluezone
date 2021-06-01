package io.github.jmgarridopaz.bluezone.hexagon.usecases.forparkingcars;

import java.time.Clock;
import java.util.Map;

import io.github.jmgarridopaz.bluezone.hexagon.rate.RateData;
import io.github.jmgarridopaz.bluezone.hexagon.usecases.forparkingcars.PermitRequest;
import io.github.jmgarridopaz.bluezone.hexagon.usecases.forparkingcars.PermitTicket;


public interface ForParkingCars {

	/**
	 * Returns the information of all the available rates in the city.
	 * 
	 * @return	a map of RateData objects, indexed by rate name. @see RateInfo
	 */
	public Map<String, RateData> getAllRatesByName();

	
	/**
	 * Issues a permit for a car parked at a regulated area, valid until a datetime, paying it with a card.
	 * Returns a ticket with the permit information.
	 * 
	 * First the permit price is calculated, depending on the number of minutes of the permit period,
	 * according to the rate of the area where the car is parked at.
	 * Then, permit price is charged to the payment card.
	 * And finally the permit is stored.
	 * 
	 * @param	clock			Clock to get current datetime from, since it will be the starting datetime of the permit period
	 * 
	 * @param	permitRequest	DTO with the info needed for issuing the permit. @see PermitRequest
	 * 
	 * @return	permitTicket	DTO with the info of the issued permit. @see PermitTicket
	 */
	public PermitTicket issuePermit ( Clock clock, PermitRequest permitRequest );

}
