package io.github.jmgarridopaz.bluezone.hexagon;

import java.math.BigDecimal;
import java.time.Clock;
import java.time.LocalDateTime;
import java.util.*;

public class CarParker implements ForParkingCars {

    private final ForObtainingRates rateProvider;
    private final ForStoringTickets ticketStore;
    private final ForPaying eWalletService;

    public CarParker(ForObtainingRates rateProvider, ForStoringTickets ticketStore, ForPaying eWalletService) {
        this.rateProvider = rateProvider;
        this.ticketStore = ticketStore;
        this.eWalletService = eWalletService;
    }

    @Override
    public Map<String, Rate> getAllRatesByName() {
        Map<String, Rate> allRatesByName = new HashMap<String, Rate>();
        Set<Rate> allRates = this.rateProvider.findAll();
        Iterator<Rate> ratesIterator = allRates.iterator();
        while (ratesIterator.hasNext()) {
            Rate rate = ratesIterator.next();
            allRatesByName.put ( rate.getName(), rate );
        }
        return allRatesByName;
    }

    @Override
    public String purchaseTicket ( PurchaseTicketRequest purchaseTicketRequest ) {
        // Pay
        String carPlate = purchaseTicketRequest.getCarPlate();
        BigDecimal moneyToPay = purchaseTicketRequest.getAmount();
        this.eWalletService.payWithWallet ( carPlate, moneyToPay );
        // Calc ending date-time
        String rateName = purchaseTicketRequest.getRateName();
        Rate rate = this.rateProvider.findByName(rateName);
        RateCalculator rateCalculator = new RateCalculator(rate);
        Clock clock = purchaseTicketRequest.getClock();
        LocalDateTime starting = LocalDateTime.now(clock);
        LocalDateTime ending = rateCalculator.getUntilGivenAmount ( starting, moneyToPay );
        // Store
        String ticketCode = this.ticketStore.nextCode();
        Ticket ticket = new Ticket(ticketCode,carPlate,rateName,starting,ending,moneyToPay);
        this.ticketStore.store(ticket);
        return ticketCode;
    }

    @Override
    public Ticket getTicket ( String ticketCode ) {
        return this.ticketStore.findByCode ( ticketCode);
    }
    
}
