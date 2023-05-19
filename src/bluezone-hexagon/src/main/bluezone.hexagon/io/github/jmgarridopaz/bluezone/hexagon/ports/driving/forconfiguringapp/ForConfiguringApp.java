package io.github.jmgarridopaz.bluezone.hexagon.ports.driving.forconfiguringapp;

import io.github.jmgarridopaz.bluezone.hexagon.ports.driven.forobtainingrates.Rate;
import io.github.jmgarridopaz.bluezone.hexagon.ports.driven.forpaying.PayRequest;
import io.github.jmgarridopaz.bluezone.hexagon.ports.driven.forstoringtickets.Ticket;

import java.util.List;

/**
 * DRIVER PORT
 */
public interface ForConfiguringApp {

    public void initRateProviderWith(List<Rate> rates );

    public void createTicket ( Ticket ticket );

    public void eraseTicket ( String ticketCode );

    public void setNextTicketCodeToReturn ( String ticketCode );

    public String getNextTicketCodeToReturn();

    public PayRequest getLastPayRequestDone();

    public void setPaymentErrorPercentage(int percent);
}
