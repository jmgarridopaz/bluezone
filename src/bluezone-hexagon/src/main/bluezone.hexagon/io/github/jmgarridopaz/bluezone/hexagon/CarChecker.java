package io.github.jmgarridopaz.bluezone.hexagon;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;
import java.util.List;
import java.util.Set;


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
