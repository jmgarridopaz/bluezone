package io.github.jmgarridopaz.bluezone.hexagon.driverports.forcheckingcars.implementation;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneOffset;
import io.github.jmgarridopaz.bluezone.hexagon.driverports.forcheckingcars.ForCheckingCars;


public class HardCodedCarChecker implements ForCheckingCars {
	
	private static final Clock				EXPECTED_CLOCK		= Clock.fixed(Instant.parse("2020-05-14T09:00:00.00Z"),ZoneOffset.UTC);
	private static final String				EXPECTED_CAR_PLATE	= "0000AAA";
	private static final String				EXPECTED_RATE_NAME	= "GREEN_ZONE";
	
	public HardCodedCarChecker() {
	}

	@Override
	public boolean isParkedCorrectly ( Clock clock, String carPlate, String rateName ) {
		if ( ! EXPECTED_CLOCK.equals(clock) ) {
			throw new IllegalArgumentException("clock");
		}
		if ( ! EXPECTED_CAR_PLATE.equals(carPlate) ) {
			throw new IllegalArgumentException("carPlate");			
		}
		if ( ! EXPECTED_RATE_NAME.equals(rateName) ) {
			throw new IllegalArgumentException("rateName");			
		}
		return true;
	}

}
