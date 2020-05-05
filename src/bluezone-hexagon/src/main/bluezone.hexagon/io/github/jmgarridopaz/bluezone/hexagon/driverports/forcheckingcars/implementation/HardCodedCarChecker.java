package io.github.jmgarridopaz.bluezone.hexagon.driverports.forcheckingcars.implementation;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import io.github.jmgarridopaz.bluezone.hexagon.driverports.forcheckingcars.ForCheckingCars;


public class HardCodedCarChecker implements ForCheckingCars {
	
	public HardCodedCarChecker() {
	}

	@Override
	public boolean isParkedCorrectly ( Clock clock, String carPlate, String rateName ) {
		if (  ! LocalDateTime.of(2020,04,01,18,30).equals(LocalDateTime.now(clock).truncatedTo(ChronoUnit.MINUTES)) ) {
			throw new IllegalArgumentException("clock");
		}
		if ( ! "0000AAA".equalsIgnoreCase(carPlate) ) {
			throw new IllegalArgumentException("carPlate");
		}
		if ( ! "RED_ZONE".equalsIgnoreCase(rateName) ) {
			throw new IllegalArgumentException("rateName");
		}
		return true;
	}

}
