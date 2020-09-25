package io.github.jmgarridopaz.bluezone.adapters.forcheckingcars.test;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

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
	
*/
public class IllegallyParkedTest {

	private final ForCheckingCars forCheckingCars;
	private LocalDateTime currentDateTime;
	private Clock clock;
	private boolean illegallyParked;

	public IllegallyParkedTest ( ForCheckingCars forCheckingCars ) {
		this.forCheckingCars =  forCheckingCars;
	}

	public void run() {
	}
	
	
	public void givenCurrentDateTimeIs ( LocalDateTime dateTime ) {
		this.clock = Clock.fixed ( dateTime.toInstant(ZoneOffset.UTC), ZoneOffset.UTC );
	}

	public void whenICheckIfTheCarIsIllegalyParked ( String carPlate, String rateName ) {
		this.illegallyParked = this.forCheckingCars.illegallyParkedCar(clock, carPlate, rateName);
	}
	
	public void thenIShouldGetThatTheCarIs ( boolean illegallyParked ) {
		assertFalse ( this.illegallyParked, "IllegallyParkedCar assertion error: Expected = false. Returned = "+this.illegallyParked );
	}
	
}
