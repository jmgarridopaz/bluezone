package io.github.jmgarridopaz.bluezone.hexagon;

import java.math.BigDecimal;
import java.util.List;


public class AppConfigurator implements ForConfiguringApp {

    private final ForObtainingRates rateProvider;
    private final ForStoringTickets ticketStore;
    private final ForPaying paymentService;

    public AppConfigurator(ForObtainingRates rateProvider, ForStoringTickets ticketStore, ForPaying paymentService) {
        this.rateProvider = rateProvider;
        this.ticketStore = ticketStore;
        this.paymentService = paymentService;
    }

    @Override
    public void createRates ( List<Rate> rates ) {
        this.rateProvider.empty();
        for ( Rate rate : rates ) {
            if ( ! this.rateProvider.exists(rate.getName()) ) {
                this.rateProvider.addRate ( rate );
            }
        }
    }

    @Override
    public void createTicket ( Ticket ticket ) {
        if ( ! this.ticketStore.exists(ticket.getCode()) ) {
            this.ticketStore.store ( ticket );
        }
    }

    @Override
    public void eraseTicket ( String ticketCode ) {
        if ( this.ticketStore.exists(ticketCode) ) {
            this.ticketStore.delete(ticketCode);
        }
    }

    @Override
    public void setNextTicketCodeToReturn(String ticketCode) {
        this.ticketStore.setNextCode(ticketCode);
    }

    @Override
    public String getNextTicketCodeToReturn() {
        return this.ticketStore.nextAvailableCode();
    }

    @Override
    public PayRequest getLastPayRequestDone() {
        return this.paymentService.lastPayRequest();
    }

}
