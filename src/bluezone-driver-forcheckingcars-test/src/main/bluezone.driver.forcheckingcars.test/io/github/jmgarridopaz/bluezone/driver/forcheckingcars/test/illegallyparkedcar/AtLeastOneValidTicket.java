package io.github.jmgarridopaz.bluezone.driver.forcheckingcars.test.illegallyparkedcar;

import io.github.jmgarridopaz.bluezone.driver.forcheckingcars.test.SystemUnderTest;
import io.github.jmgarridopaz.bluezone.hexagon.Ticket;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.math.BigDecimal;
import java.time.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/*
SCENARIO: At least one valid ticket
-----------------------------------

    GIVEN
        this ticket at repository:
            | code       | carPlate | rateName   | startingDateTime | endingDateTime   | price |
            | 0000001155 | 1365MDS  | GREEN_ZONE | 2022/06/17 12:15 | 2022/06/17 12:45 | 0.60  |
    WHEN
        I check at "2022/06/17 12:30" car "1365MDS" parked in an area with rate "GREEN_ZONE"
    THEN
        illegally parked car should be "false"
*/
public class AtLeastOneValidTicket {

    // SystemUnderTest Outcome
    private boolean illegallyParkedCar;

    @Test ( dataProvider = "one-valid-ticket" )
    public void carShouldNotBeIllegallyParkedWhenAtLeastOneValidTicket ( Ticket ticket, LocalDateTime currentDateTime, String carPlate, String rateName, boolean expectedIllegallyParkedCar ) {
        givenThisTicketAtRepository ( ticket );
        whenICheckAtCurrentDateTimeCarParkedInAreaWithRate ( currentDateTime, carPlate, rateName );
        thenIllegallyParkedCarShouldBe ( expectedIllegallyParkedCar );
    }

    private void givenThisTicketAtRepository ( Ticket ticket ) {
        Reporter.log ("GIVEN this ticket at repository:" + ticket );
        SystemUnderTest.instance().appConfigurator().createTicket(ticket);
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

    @DataProvider ( name = "one-valid-ticket")
    public Object[][] allTicketsExpiredData() {
        Ticket ticket = new Ticket("0000001155","1365MDS","GREEN_ZONE",LocalDateTime.of(2022, Month.JUNE, 17, 12, 15),LocalDateTime.of(2022, Month.JUNE, 17, 12, 45),new BigDecimal("0.60"));
        long minutesOfTicket = Duration.between(ticket.getStartingDateTime(),ticket.getEndingDateTime()).toMinutes();
        LocalDateTime currentDateTime = ticket.getStartingDateTime().plusMinutes( minutesOfTicket/2 );
        String carPlate = ticket.getCarPlate();
        String rateName = ticket.getRateName();
        boolean expectedIllegallyParkedCar = false;
        return new Object[][] {
                { ticket, currentDateTime, carPlate, rateName, expectedIllegallyParkedCar },
        };
    }
}
