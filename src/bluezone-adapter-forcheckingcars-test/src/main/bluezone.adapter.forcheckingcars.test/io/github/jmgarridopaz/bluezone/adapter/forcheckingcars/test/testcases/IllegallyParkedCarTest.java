package io.github.jmgarridopaz.bluezone.adapter.forcheckingcars.test.testcases;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneOffset;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.jmgarridopaz.bluezone.adapter.forcheckingcars.test.ForCheckingCarsTestAdapter;
import io.github.jmgarridopaz.bluezone.adapter.forcheckingcars.test.sut.SutProvider;

/*
	Class with test cases for "illegally parked car" port operation (use case)

	USE CASE: Illegaly parked car
	-----------------------------	
		AS
			a parking inspector
		I WANT TO
			check whether a parked car doesn't have any active permit for the rate of the area it is parked at
		SO THAT
			in that case I will issue a parking fine warning
*/
@Test
public class IllegallyParkedCarTest {
	
	// In-out values for the hardcoded test
	private static final LocalDateTime	HARDCODED_CURRENT_DATE_TIME		= LocalDateTime.of(2020, Month.APRIL, 22, 9, 0);
	private static final String			HARDCODED_CAR_PLATE				= "0000AAA";
	private static final String			HARDCODED_RATE_NAME				= "GREEN_ZONE";
	private static final boolean		EXPECTED_ILLEGALY_PARKED_CAR	= false;
	
	// Test case context
	private Clock clock;
	private Boolean illegallyParkedCar;
		
	// Before running each test case in this class
	@BeforeMethod
	public void resetTestCaseContext() {
		this.clock = null;
		this.illegallyParkedCar = null;
	}	

	/*
		Test case: Hardcoded Hexagon
		----------------------------
			GIVEN
				current date time is "2020/04/22 09:00"
			WHEN
				I check if car "0000AAA" is illegaly parked at area with rate "GREEN_ZONE"
			THEN
				illegally parked car should be "false"
	 */
	@Test ( groups = { ForCheckingCarsTestAdapter.HARDCODED_HEXAGON_GROUP } )
	public void hardCodedHexagonTest() {
		givenCurrentDateTimeIs							( HARDCODED_CURRENT_DATE_TIME );
		whenICheckIfCarIsIllegallyParkedAtAreaWithRate	( HARDCODED_CAR_PLATE, HARDCODED_RATE_NAME );
		thenIllegallyParkedCarShouldBe					( EXPECTED_ILLEGALY_PARKED_CAR );
	}
	

	private void givenCurrentDateTimeIs ( LocalDateTime dateTime ) {
		Reporter.log("GIVEN current date-time is '"+dateTime+"'");
		this.clock = Clock.fixed ( dateTime.toInstant(ZoneOffset.UTC), ZoneOffset.UTC );
	}

	private void whenICheckIfCarIsIllegallyParkedAtAreaWithRate ( String carPlate, String rateName ) {
		Reporter.log("WHEN I check if car '"+carPlate+"' is illegally parked at area with rate '"+rateName+"'");
		this.illegallyParkedCar = SutProvider.FOR_CHECKING_CARS.get().illegallyParkedCar(clock, carPlate, rateName);
	}
	
	private void thenIllegallyParkedCarShouldBe ( boolean expectedIllegallyParkedCar ) {
		Reporter.log("THEN illegally parked car should be '"+expectedIllegallyParkedCar+"'");
		boolean returnedIllegallyParkedCar = this.illegallyParkedCar;
		assertThat ( returnedIllegallyParkedCar, is(expectedIllegallyParkedCar) );	
	}
	
}
