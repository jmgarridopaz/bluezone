package io.github.jmgarridopaz.bluezone.adapters.forcheckingcars.test.testcases;

import static org.junit.jupiter.api.Assertions.assertTrue;
import java.time.Clock;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneOffset;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import io.github.jmgarridopaz.bluezone.adapters.forcheckingcars.test.sut.ForCheckingCarsProvider;
import io.github.jmgarridopaz.bluezone.hexagon.forcheckingcars.ForCheckingCars;

/*
	Class with the tests (Given-When-Then scenarios) for one feature (use case, operation) of the port

	FEATURE: Illegaly parked car
	----------------------------	
		AS
			a parking inspector
		I WANT TO
			check whether a parked car doesn't have any active permit for the rate of the area it is parked at
		SO THAT
			in that case I will issue a parking fine warning
*/
class IllegallyParkedCarTest {

	private static final String			HARDCODED_HEXAGON_TAG			= "hardcoded";
	
	// Hardcoded in-out values for the test
	private static final LocalDateTime	HARDCODED_CURRENT_DATE_TIME		= LocalDateTime.of(2020, Month.APRIL, 22, 9, 0);
	private static final String			HARDCODED_CAR_PLATE				= "0000AAA";
	private static final String			HARDCODED_RATE_NAME				= "GREEN_ZONE";
	private static final boolean		EXPECTED_ILLEGALY_PARKED_CAR	= false;
	
	// Scenario context
	private ForCheckingCars forCheckingCars;
	private Clock clock;
	private Boolean illegallyParkedCar;
	
	
	// Reset scenario (test) context before running each test in this class
	@BeforeEach
	void resetScenarioContext() {
		this.forCheckingCars = ForCheckingCarsProvider.INSTANCE.get();
		this.clock = null;
		this.illegallyParkedCar = null;
	}

/*
	Test for the Hardcoded hexagon
	------------------------------
		GIVEN
			current date time is "2020/04/22 09:00"
		WHEN
			I check if the car with plate "0000AAA" is illegaly parked at a "GREEN_ZONE" rate area
		THEN
			illegaly parked car should be "false"
*/
	@Test
	@Tag(HARDCODED_HEXAGON_TAG)
	void hardCodedTest() {
		givenCurrentDateTimeIs				( HARDCODED_CURRENT_DATE_TIME );
		whenICheckIfTheCarIsIllegalyParked	( HARDCODED_CAR_PLATE, HARDCODED_RATE_NAME );
		thenIllegallyParkedCarShouldBe		( EXPECTED_ILLEGALY_PARKED_CAR );
	}
	
	
	private void givenCurrentDateTimeIs ( LocalDateTime dateTime ) {
		this.clock = Clock.fixed ( dateTime.toInstant(ZoneOffset.UTC), ZoneOffset.UTC );
	}

	private void whenICheckIfTheCarIsIllegalyParked ( String carPlate, String rateName ) {
		this.illegallyParkedCar = this.forCheckingCars.illegallyParkedCar(clock, carPlate, rateName);
	}
	
	private void thenIllegallyParkedCarShouldBe ( boolean expectedIllegallyParkedCar ) {
		assertTrue ( expectedIllegallyParkedCar==this.illegallyParkedCar, "IllegallyParkedCar assertion error: Expected = " + expectedIllegallyParkedCar + ". Returned = "+this.illegallyParkedCar );
	}
	
}
