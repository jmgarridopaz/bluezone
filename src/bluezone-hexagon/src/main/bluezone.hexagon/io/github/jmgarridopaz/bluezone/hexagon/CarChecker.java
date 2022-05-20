package io.github.jmgarridopaz.bluezone.hexagon;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.Set;


public class CarChecker implements ForCheckingCars {

    private final ForStoringTickets ticketStore;

    public CarChecker ( ForStoringTickets ticketStore) {
        this.ticketStore = ticketStore;
    }

    @Override
    public boolean illegallyParkedCar(Clock clock, String carPlate, String rateName) {
        LocalDateTime currentDateTime = LocalDateTime.now(clock);
        Set<Ticket> validTickets = this.ticketStore.findByDateTimeInPeriod ( carPlate, rateName, currentDateTime );
        if ( validTickets==null || validTickets.isEmpty() ) {
            return true;
        }
        return false;
    }

}
