package io.github.jmgarridopaz.bluezone.adapter.forcheckingcars.test.testcases;

import io.github.jmgarridopaz.bluezone.adapter.forcheckingcars.test.ForCheckingCarsTestDriver;
import io.github.jmgarridopaz.bluezone.adapter.forobtainingrates.stub.ForObtainingRatesStubAdapter;
import io.github.jmgarridopaz.bluezone.hexagon.*;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.time.Clock;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

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
	private ForObtainingRates rateProvider;
	private ForStoringPermits permitStore;
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
				this permit exists at permit repository:
					| car plate | rate name | created at          | ending date time |
					| 6989JJH   | BLUE_ZONE | 2022/01/05 14:30:19 | 2022/01/05 16:00 |
				AND current date time is between "2022/01/05 14:30" and "2022/01/05 16:00"
			WHEN
				I check whether the car with plate "6989HJJ" is illegally parked at an area with rate "BLUE_ZONE"
			THEN
				illegally parked car should be "false"
	 */
	@Test
	public void testExistActivePermit() {
		RateData rate = new RateData( "BLUE_ZONE", new BigDecimal("0.80"), 35, 120 );
		Set<RateData> rates = new HashSet<>(rate);
		this.rateProvider = new ForObtainingRatesStubAdapter(rates);

		givenThisRateExistsAtRateRepository ( "BLUE_ZONE", "0.80", 35, 120 );
		givenThisPaymentTransactionHasBeenDone ( "76d0f01a-25a6-4bd0-88f5-0cd026a06163", "4651413851991298", "1.20" );
		givenThisPermitExistsAtPermitRepository ( "6989JJH", "BLUE_ZONE", "2022/01/05 14:30:19", "2022/01/05 16:00", "76d0f01a-25a6-4bd0-88f5-0cd026a06163" );
		givenCurrentDateTimeIsBetween ( this.permit.createdAt(), this.permit.endingDateTime() );
		whenICheckNowWhetherCarIsIllegallyParkedAtAreaWithRate ( this.currentDateTime, this.permit.carPlate(), this.permit.rateName() );
		thenIllegallyParkedCarShouldBe ( false );
	}

	private void givenThisPermitExistsAtPermitRepository(String carPlate, String rateName, String creationDTAsString, String endingDTAsString, String paymentTransactionId ) {

		LocalDateTime creationDateTime = LocalDateTime.parse ( endingDTAsString, DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss") );
		LocalDateTime endingDateTime = LocalDateTime.parse ( endingDTAsString, DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm") );

		Permit permit = new Permit();
		permit.setCarPlate(carPlate);
		permit.setRateName(rateName);
		permit.setCreatedAt(creationDateTime);
		permit.setEndingDateTime(endingDateTime);
		this.permitStore = new
	}


	/*
		Test case: No active permit for the car and rate
		------------------------------------------------
			GIVEN
				these permits exist at permit repository:
					| car plate | rate name | created at          | ending date time |
					| 6989JJH   | BLUE_ZONE | 2022/01/05 14:30:19 | 2022/01/05 16:00 |
					| 6989JJH   | BLUE_ZONE | 2022/01/05 16:05:52 | 2022/01/05 16:30 |
				AND current date time is at least "2022/01/05 16:30"
			WHEN
				I check whether the car with plate "6989HJJ" is illegally parked at an area with rate "BLUE_ZONE"
			THEN
				illegally parked car should be "true"
	 */
	@Test ( dataProvider="no-active-permit" )
	public void testExistActivePermit(String carPlate, String rateName, LocalDateTime currentDateTime ) {
		givenPermitWithTheFollowingDataAtPermitRepository ( carPlate, rateName, createdAt, endingDateTime );
		givenCurrentDateTimeIsBetween ( this.permit.createdAt(), this.permit.endingDateTime() );
		whenICheckNowWhetherCarIsIllegallyParkedAtAreaWithRate ( this.currentDateTime, this.permit.carPlate(), this.permit.rateName() );
		thenIllegallyParkedCarShouldBe ( false );
	}












	private void givenItDoesNotExistAnyRateRepository() {
		Reporter.log("GIVEN it does not exist any rate repository");
		this.rateProvider = null;
	}

	private void givenItDoesNotExistAnyPermitRepository() {
		Reporter.log("GIVEN it does not exist any permit repository");
		this.permitStore = null;
	}

	private void givenItDoesNotExistAnyPaymentRecipient() {
		Reporter.log("GIVEN it does not exist any payment recipient");
		this.forPaying = null;
	}

	private void whenICheckNowWhetherCarIsIllegallyParkedAtAreaWithRate ( LocalDateTime currentDateTime, String carPlate, String rateName ) {
		Reporter.log("WHEN I check now ('"+currentDateTime+"') whether car '"+carPlate+"' is illegally parked at area with rate '"+rateName+"'");
		ForCheckingCars carChecker = new CarChecker ( this.rateProvider, this.permitStore, this.forPaying );
		Clock clockWithCurrentDateTime = Clock.fixed ( currentDateTime.toInstant(ZoneOffset.UTC), ZoneOffset.UTC );
		this.illegallyParkedCar = carChecker.illegallyParkedCar(clockWithCurrentDateTime,carPlate,rateName);
	}

	private void thenIllegallyParkedCarShouldBe ( boolean expectedIllegallyParkedCar ) {
		Reporter.log("THEN illegally parked car should be '"+expectedIllegallyParkedCar+"'");
		assertThat ( this.illegallyParkedCar, is(expectedIllegallyParkedCar) );
	}
	
}
