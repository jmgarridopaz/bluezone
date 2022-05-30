package io.github.jmgarridopaz.bluezone.hexagon;

import java.time.LocalDateTime;
import java.util.Set;

/**
 * DRIVEN PORT
 */
public interface ForStoringTickets {

    public String nextCode();

    public Ticket findByCode ( String ticketCode );

    public void store ( Ticket ticket );

    public Set<Ticket> findByDateTimeInPeriod ( String carPlate, String rateName, LocalDateTime dateTime);

    public void delete ( String ticketCode );

    public boolean exists ( String ticketCode );

    public void setNextCode ( String ticketCode );

    public String nextAvailableCode();

}
