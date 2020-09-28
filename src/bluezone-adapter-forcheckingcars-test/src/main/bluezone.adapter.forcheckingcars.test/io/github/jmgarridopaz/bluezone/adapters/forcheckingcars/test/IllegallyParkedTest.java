package io.github.jmgarridopaz.bluezone.adapters.forcheckingcars.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import io.github.jmgarridopaz.bluezone.hexagon.forcheckingcars.ForCheckingCars;

/*
	FEATURE: Illegaly parked car
	============================
	
	AS
	a parking inspector
	
	I WANT TO
	check whether a parked car doesn't have any active permit for the rate of the area it is parked at
	
	SO THAT
	in that case I will issue a parking fine warning
	
	
	TESTS (SCENARIOS G-W-T):
	========================
	
	Tag = hardcoded
	
		GIVEN
		current date time is "2020/04/22 09:00"
	
		WHEN
		I check if the car with plate "0000AAA" is illegaly parked at a "GREEN_ZONE" rate area
		
		THEN
		illegaly parked car should be "false"
	
*/
public class IllegallyParkedTest {

	// SUT (system under test) = the driver port of the hexagon
	private final ForCheckingCars forCheckingCars;
	
	// scenario context
	private Clock clock;
	private boolean illegallyParkedCar;

	public IllegallyParkedTest ( ForCheckingCars forCheckingCars ) {
		this.forCheckingCars =  forCheckingCars;
	}

	@Test
	@Tag(HARDCODED_HEXAGON_TEST_TAG)
	public void runHardCoded() {
	}
	
	
	public void givenCurrentDateTimeIs ( LocalDateTime dateTime ) {
		this.clock = Clock.fixed ( dateTime.toInstant(ZoneOffset.UTC), ZoneOffset.UTC );
	}

	public void whenICheckIfTheCarIsIllegalyParked ( String carPlate, String rateName ) {
		this.illegallyParkedCar = this.forCheckingCars.illegallyParkedCar(clock, carPlate, rateName);
	}
	
	public void thenIllegallyParkedCarShouldBe ( boolean expectedIllegallyParkedCar ) {
		assertTrue ( expectedIllegallyParkedCar==this.illegallyParkedCar, "IllegallyParkedCar assertion error: Expected = false. Returned = "+this.illegallyParkedCar );
	}
	
}
