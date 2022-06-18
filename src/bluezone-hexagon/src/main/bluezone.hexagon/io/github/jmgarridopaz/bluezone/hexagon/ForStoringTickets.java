package io.github.jmgarridopaz.bluezone.hexagon;

import java.util.List;

/**
 * DRIVEN PORT
 */
public interface ForStoringTickets {

    public String nextCode();

    public Ticket findByCode ( String ticketCode );

    public void store ( Ticket ticket );

    public List<Ticket> findByCarRateOrderByEndingDateTimeDesc(String carPlate, String rateName);

    public void delete ( String ticketCode );

    public boolean exists ( String ticketCode );

    public void setNextCode ( String ticketCode );

    public String nextAvailableCode();

}
