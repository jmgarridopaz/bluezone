package io.github.jmgarridopaz.bluezone.hexagon.forcheckingcars.implementation;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import io.github.jmgarridopaz.bluezone.hexagon.forcheckingcars.ForCheckingCars;


public class HardCodedCarChecker implements ForCheckingCars {
	
	private static final String			EXPECTED_CAR_PLATE			= "0000AAA";
	private static final String			EXPECTED_RATE_NAME			= "GREEN_ZONE";
	private static final LocalDateTime	EXPECTED_CURRENT_DATE_TIME	= LocalDateTime.of(2020,Month.APRIL,22,9,0);
	private static final boolean		ILLEGALLY_PARKED_CAR		= false;
	
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
		return ILLEGALLY_PARKED_CAR;
	}

}
