package io.github.jmgarridopaz.bluezone.hexagon;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;


public interface ForParkingCars {

	/**
	 * Returns all the available rates in the city, indexed by name.
	 * 
	 * @return	a map of RateData objects, with the rate name as the key. {@link RateData}
	 */
	public Map<String, RateData> getAllRatesByName();

	/**
	 * Calculates how much it would cost to park a car at a regulated area with a given rate,
	 * according to the number of minutes between two given date-times.
	 *
	 * @param rateName
	 * @param startingDateTime
	 * @param endingDateTime
	 * @return
	 */
	public BigDecimal calculatePrice ( String rateName, LocalDateTime startingDateTime, LocalDateTime endingDateTime );


	/**
	 * It pays and stores the parking permit with the given data
	 *
	 * @param	permitRequest	info needed to create and pay for a parking permit. {@link PermitRequest}
	 * @return	a PermitTicket object with the info of the permit that has been paid. {@link PermitTicket}
	 */
	public PermitTicket payPermit ( PermitRequest permitRequest );

}
