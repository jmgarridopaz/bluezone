package io.github.jmgarridopaz.bluezone.driver.forcheckingcars.test.illegallyparkedcar;

import io.github.jmgarridopaz.bluezone.driver.forcheckingcars.test.SystemUnderTest;
import io.github.jmgarridopaz.bluezone.hexagon.ports.driven.forstoringtickets.Ticket;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.math.BigDecimal;
import java.time.Clock;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneOffset;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/*
SCENARIO: All tickets expired
-----------------------------

    GIVEN
        these tickets at repository:
            | code       | carPlate | rateName   | startingDateTime | endingDateTime   | price |
            | 0000000658 | 6989JJH  | BLUE_ZONE  | 2022/06/11 08:30 | 2022/06/11 09:00 | 0.40  |
            | 0000000659 | 6989JJH  | BLUE_ZONE  | 2022/06/11 09:15 | 2022/06/11 10:15 | 0.80  |
            | 0000000660 | 1365MDS  | BLUE_ZONE  | 2022/06/11 09:30 | 2022/06/11 11:00 | 1.20  |
            | 0000000661 | 6989JJH  | GREEN_ZONE | 2022/06/11 10:00 | 2022/06/11 10:30 | 0.60  |
    WHEN
        I check at "2022/06/11 10:16" car "6989JJH" parked in an area with rate "BLUE_ZONE"
    THEN
        illegally parked car should be "true"
*/
public class AllTicketsExpired {

	// SystemUnderTest Outcome
	private boolean illegallyParkedCar;

	@Test ( dataProvider = "all-tickets-expired" )
	public void carShouldBeIllegallyParkedWhenAllTicketsExpired ( List<Ticket> tickets, LocalDateTime currentDateTime, String carPlate, String rateName, boolean expectedIllegallyParkedCar ) {
		givenTheseTicketsAtRepository ( tickets );
		whenICheckAtCurrentDateTimeCarParkedInAreaWithRate ( currentDateTime, carPlate, rateName );
		thenIllegallyParkedCarShouldBe ( expectedIllegallyParkedCar );
	}

	private void givenTheseTicketsAtRepository ( List<Ticket> tickets ) {
		Reporter.log ("GIVEN these tickets at repository:" + tickets );
		for ( Ticket ticket : tickets ) {
			SystemUnderTest.instance().appConfigurator().createTicket(ticket);
		}
	}

	private void whenICheckAtCurrentDateTimeCarParkedInAreaWithRate ( LocalDateTime currentDateTime, String carPlate, String rateName ) {
		Reporter.log ("WHEN I check at '" + currentDateTime + "' car '" + carPlate + "' parked in an area with rate '" + rateName + "'" );
		Clock clock = Clock.fixed(currentDateTime.toInstant(ZoneOffset.UTC),ZoneOffset.UTC);
		this.illegallyParkedCar = SystemUnderTest.instance().carChecker().illegallyParkedCar(clock,carPlate,rateName);
	}

	private void thenIllegallyParkedCarShouldBe ( boolean expectedIllegallyParkedCar ) {
		Reporter.log ("THEN illegally parked car ('" + this.illegallyParkedCar + "') should be '" + expectedIllegallyParkedCar + "'" );
		assertThat ( this.illegallyParkedCar, is(expectedIllegallyParkedCar) );
	}

	@DataProvider ( name = "all-tickets-expired")
	public Object[][] allTicketsExpiredData() {
		Ticket ticket1 = new Ticket("0000000658","6989JJH","BLUE_ZONE",LocalDateTime.of(2022, Month.JUNE, 11, 8, 30),LocalDateTime.of(2022, Month.JUNE, 11, 9, 0),new BigDecimal("0.40"));
		Ticket ticket2 = new Ticket("0000000659","6989JJH","BLUE_ZONE",LocalDateTime.of(2022, Month.JUNE, 11, 9, 15),LocalDateTime.of(2022, Month.JUNE, 11, 10, 15),new BigDecimal("0.80"));
		Ticket ticket3 = new Ticket("0000000660","1365MDS","BLUE_ZONE",LocalDateTime.of(2022, Month.JUNE, 11, 9, 30),LocalDateTime.of(2022, Month.JUNE, 11, 11, 0),new BigDecimal("1.20"));
		Ticket ticket4 = new Ticket("0000000661","6989JJH","GREEN_ZONE",LocalDateTime.of(2022, Month.JUNE, 11, 10, 0),LocalDateTime.of(2022, Month.JUNE, 11, 10, 30),new BigDecimal("0.60"));
		List<Ticket> expiredTickets = List.of ( ticket1, ticket2, ticket3, ticket4 );
		LocalDateTime currentDateTime = ticket2.getEndingDateTime().plusMinutes(1);
		String carPlate = ticket2.getCarPlate();
		String rateName = ticket2.getRateName();
		boolean expectedIllegallyParkedCar = true;
		return new Object[][] {
			{ expiredTickets, currentDateTime, carPlate, rateName, expectedIllegallyParkedCar },
		};
	}

}
