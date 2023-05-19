package io.github.jmgarridopaz.bluezone.adapter.forstoringtickets.fake;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import io.github.jmgarridopaz.bluezone.hexagon.ports.driven.forstoringtickets.Ticket;
import io.github.jmgarridopaz.bluezone.hexagon.ports.driven.forstoringtickets.ForStoringTickets;
import io.github.jmgarridopaz.lib.portsadapters.Adapter;


/**
 * Driven adapter that implements "forstoringtickets" port with a fake (in-memory db) test double.
 */
@Adapter(name="test-double")
public class FakeTicketStoreAdapter implements ForStoringTickets {

    private static final int MAX_TICKET_CODE_LENGTH = 10;

    private Map<String,Ticket> ticketsByCode;
	private AtomicLong value;

    public FakeTicketStoreAdapter () {
        this.ticketsByCode = new HashMap<String,Ticket>();
        setNextCode("1");
    }

    @Override
    public String nextCode() {
        String currentTicketCodeAndIncrement  = Long.toString(value.getAndIncrement());
        return leftPaddedTicketCode ( currentTicketCodeAndIncrement );
    }

    @Override
    public void setNextCode ( String ticketCode ) {
        if ( ticketCode.length() > MAX_TICKET_CODE_LENGTH ) {
            throw new RuntimeException("Ticket code overflow");
        }
        long codeAsLong = Long.valueOf(ticketCode);
        this.value = new AtomicLong(codeAsLong);
    }

    @Override
    public String nextAvailableCode() {
        String currentTicketCode = Long.toString(value.get());
        return leftPaddedTicketCode ( currentTicketCode );
    }

    private String leftPaddedTicketCode ( String ticketCode ) {
        int numberOfZeroesToPad = MAX_TICKET_CODE_LENGTH - ticketCode.length();
        if ( numberOfZeroesToPad < 0 ) {
            throw new RuntimeException("Ticket code overflow");
        }
        for ( int counter = 0; counter < numberOfZeroesToPad; counter++ ) {
            ticketCode = "0" + ticketCode;
        }
        return ticketCode;
    }

    @Override
    public Ticket findByCode(String ticketCode) {
        if ( ! exists(ticketCode) ) {
            return null;
        }
        return this.ticketsByCode.get ( ticketCode );
    }

    @Override
    public void store(Ticket ticket) {
		if ( exists(ticket.getCode()) ) {
			throw new RuntimeException("Cannot store ticket. Code '"+ticket.getCode()+"' already exists.");
		}
		this.ticketsByCode.put(ticket.getCode(),ticket);
    }

    @Override
    public List<Ticket> findByCarRateOrderByEndingDateTimeDesc ( String carPlate, String rateName ) {
        List<Ticket> ticketsOfCarAndRate = new ArrayList<Ticket>();
        if ( this.ticketsByCode==null || this.ticketsByCode.isEmpty() ) {
            return ticketsOfCarAndRate;
        }
        for ( Ticket ticket : this.ticketsByCode.values() ) {
            if ( ticket.getCarPlate().equals(carPlate) && ticket.getRateName().equals(rateName) ) {
                ticketsOfCarAndRate.add(ticket);
            }
        }
        Comparator<Ticket> byEndingDateTimeDescTicketComparator = new Comparator<Ticket>() {
            @Override
            public int compare(Ticket ticket1, Ticket ticket2) {
                LocalDateTime endingDateTime1 = ticket1.getEndingDateTime();
                LocalDateTime endingDateTime2 = ticket2.getEndingDateTime();
                if ( endingDateTime1.isAfter(endingDateTime2) ) {
                    return -1;
                }
                if ( endingDateTime1.isBefore(endingDateTime2) ) {
                    return 1;
                }
                return 0;
            }
        };
        ticketsOfCarAndRate.sort(byEndingDateTimeDescTicketComparator);
        return ticketsOfCarAndRate;
    }

    @Override
    public void delete ( String ticketCode ) {
        if ( ! exists(ticketCode) ) {
            throw new RuntimeException("Cannot delete ticket. Code '"+ticketCode+"' does not exist.");
        }
        this.ticketsByCode.remove ( ticketCode );
    }

    @Override
    public boolean exists ( String ticketCode ) {
		return ( this.ticketsByCode.get(ticketCode) != null );
	}


}
