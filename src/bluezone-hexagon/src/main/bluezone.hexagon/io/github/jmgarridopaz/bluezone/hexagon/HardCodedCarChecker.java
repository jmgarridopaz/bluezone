package io.github.jmgarridopaz.bluezone.hexagon;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;


/**
 * 
 * Test double for the driver port.
 * Useful for testing driver adapters 'mocking' the hexagon.
 * 
 * It doesn't depend on any driven port.
 * 
 * Port operations takes/return hardcoded values.
 */
public class HardCodedCarChecker implements ForCheckingCars {

	private static final LocalDateTime	EXPECTED_CURRENT_DATE_TIME		= LocalDateTime.of(2022, Month.JANUARY, 14, 19, 30);
	private static final String			EXPECTED_CAR_PLATE				= "9999ZZZ";
	private static final String			EXPECTED_RATE_NAME				= "RED_ZONE";
	private static final boolean		RETURNED_ILLEGALLY_PARKED_CAR	= false;

	public HardCodedCarChecker() {}


	@Override
	public boolean illegallyParkedCar ( Clock clock, String carPlate, String rateName ) {
		if ( ! EXPECTED_CURRENT_DATE_TIME.equals ( LocalDateTime.now(clock).truncatedTo(ChronoUnit.MINUTES) ) ) {
			throw new IllegalArgumentException("clock");
		}
		if ( ! EXPECTED_CAR_PLATE.equals(carPlate) ) {
			throw new IllegalArgumentException("carPlate");			
		}
		if ( ! EXPECTED_RATE_NAME.equals(rateName) ) {
			throw new IllegalArgumentException("rateName");			
		}
		return RETURNED_ILLEGALLY_PARKED_CAR;
	}

}
