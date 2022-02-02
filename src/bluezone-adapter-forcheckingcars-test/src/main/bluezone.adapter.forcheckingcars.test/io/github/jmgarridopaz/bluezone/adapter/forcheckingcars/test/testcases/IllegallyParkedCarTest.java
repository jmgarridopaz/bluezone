package io.github.jmgarridopaz.bluezone.adapter.forcheckingcars.test.testcases;

import io.github.jmgarridopaz.bluezone.adapter.forcheckingcars.test.ForCheckingCarsTestDriver;
import io.github.jmgarridopaz.bluezone.hexagon.*;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneOffset;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

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
	private static final LocalDateTime	HARDCODED_CURRENT_DATE_TIME		= LocalDateTime.of(2022, Month.JANUARY, 14, 19, 30);
	private static final String			HARDCODED_CAR_PLATE				= "9999ZZZ";
	private static final String			HARDCODED_RATE_NAME				= "RED_ZONE";
	private static final boolean		EXPECTED_ILLEGALLY_PARKED_CAR	= false;
	
	// Test fixture ( driven side )
	private ForObtainingRates forObtainingRates;
	private ForStoringPermits forStoringPermits;
	private ForPaying forPaying;

	// Test outcome
	private boolean illegallyParkedCar;

	/*
		Test case: Hardcoded Hexagon
		----------------------------
			GIVEN
				it does not exist any rate repository
				AND it does not exist any permit repository
				AND it does not exist any payment recipient
			WHEN
				I check at "2022/01/14 19:30" whether the car with plate "9999ZZZ" is illegally parked at an area with rate "RED_ZONE"
			THEN
				illegally parked car should be "false"
	 */
	@Test ( groups = { ForCheckingCarsTestDriver.HARDCODED_HEXAGON_GROUP } )
	public void hardCodedHexagonTest() {
		givenItDoesNotExistAnyRateRepository();
		givenItDoesNotExistAnyPermitRepository();
		givenItDoesNotExistAnyPaymentRecipient();
		whenICheckNowWhetherCarIsIllegallyParkedAtAreaWithRate ( HARDCODED_CURRENT_DATE_TIME, HARDCODED_CAR_PLATE, HARDCODED_RATE_NAME );
		thenIllegallyParkedCarShouldBe (EXPECTED_ILLEGALLY_PARKED_CAR);
	}


	/*
		Test case: Exist active permit
		------------------------------
			GIVEN
				the following permit exists at permit repository:
					| id | car plate | rate name | created at          | ending date time | payment transaction id               |
					| 1  | 6989JJH   | BLUE_ZONE | 2022/01/05 14:30:19 | 2022/01/05 16:00 | 76d0f01a-25a6-4bd0-88f5-0cd026a06163 |
			WHEN
				I check at "2022/01/05 15:45" whether the car with plate "6989HJJ" is illegally parked at an area with rate "BLUE_ZONE"
			THEN
				illegally parked car should be "false"
	 */
	@Test(dataProvider = "active-permit")
	public void existActivePermitTest ( String carPlate, String rateName, LocalDateTime createdAt, LocalDateTime endingDateTime ) {
		givenPermitWithTheFollowingDataAtPermitRepository ( carPlate, rateName, createdAt, endingDateTime );
		givenCurrentDateTimeIsBetween ( this.permit.createdAt(), this.permit.endingDateTime() );
		whenICheckNowWhetherCarIsIllegallyParkedAtAreaWithRate ( this.currentDateTime, this.permit.carPlate(), this.permit.rateName() );
		thenIllegallyParkedCarShouldBe ( false );
	}














	private void givenItDoesNotExistAnyRateRepository() {
		Reporter.log("GIVEN it does not exist any rate repository");
		this.forObtainingRates = null;
	}

	private void givenItDoesNotExistAnyPermitRepository() {
		Reporter.log("GIVEN it does not exist any permit repository");
		this.forStoringPermits = null;
	}

	private void givenItDoesNotExistAnyPaymentRecipient() {
		Reporter.log("GIVEN it does not exist any payment recipient");
		this.forPaying = null;
	}

	private void whenICheckNowWhetherCarIsIllegallyParkedAtAreaWithRate ( LocalDateTime currentDateTime, String carPlate, String rateName ) {
		Reporter.log("WHEN I check now ('"+currentDateTime+"') whether car '"+carPlate+"' is illegally parked at area with rate '"+rateName+"'");
		ForCheckingCars forCheckingCars = new CarChecker ( this.forObtainingRates, this.forStoringPermits, this.forPaying );
		Clock clockWithCurrentDateTime = Clock.fixed ( currentDateTime.toInstant(ZoneOffset.UTC), ZoneOffset.UTC );
		this.illegallyParkedCar = forCheckingCars.illegallyParkedCar(clockWithCurrentDateTime,carPlate,rateName);
	}

	private void thenIllegallyParkedCarShouldBe ( boolean expectedIllegallyParkedCar ) {
		Reporter.log("THEN illegally parked car should be '"+expectedIllegallyParkedCar+"'");
		assertThat ( this.illegallyParkedCar, is(expectedIllegallyParkedCar) );
	}
	
}
