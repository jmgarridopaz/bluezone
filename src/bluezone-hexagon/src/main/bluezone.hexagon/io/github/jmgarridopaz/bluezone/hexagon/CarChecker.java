package io.github.jmgarridopaz.bluezone.hexagon;

import io.github.jmgarridopaz.bluezone.hexagon.ports.driven.forstoringtickets.ForStoringTickets;
import io.github.jmgarridopaz.bluezone.hexagon.ports.driven.forstoringtickets.Ticket;
import io.github.jmgarridopaz.bluezone.hexagon.ports.driving.forcheckingcars.ForCheckingCars;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.List;


public class CarChecker implements ForCheckingCars {

    private final ForStoringTickets ticketStore;

    public CarChecker ( ForStoringTickets ticketStore) {
        this.ticketStore = ticketStore;
    }

    @Override
    public boolean illegallyParkedCar(Clock clock, String carPlate, String rateName) {
        List<Ticket> ticketsOfCarAndRate = this.ticketStore.findByCarRateOrderByEndingDateTimeDesc ( carPlate, rateName );
        if ( ticketsOfCarAndRate==null || ticketsOfCarAndRate.isEmpty() ) {
            return true;
        }
        LocalDateTime currentDateTime = LocalDateTime.now(clock);
        LocalDateTime latestEndingDateTime = ticketsOfCarAndRate.get(0).getEndingDateTime();
        return currentDateTime.isAfter(latestEndingDateTime);
    }

}
