package io.github.jmgarridopaz.bluezone.hexagon;

import java.math.BigDecimal;
import java.util.List;

/**
 * DRIVER PORT
 */
public interface ForConfiguringApp {

    public void createRates ( List<Rate> rates );

    public void createTicket ( Ticket ticket );

    public void eraseTicket ( String ticketCode );

    public void setNextTicketCodeToReturn ( String ticketCode );

    public void createWalletOfOwnerWithAmount ( String walletOwner, BigDecimal initialAmount );

    public String getNextTicketCodeToReturn();

    public BigDecimal getEurosInWallet(String walletOwner);

}
