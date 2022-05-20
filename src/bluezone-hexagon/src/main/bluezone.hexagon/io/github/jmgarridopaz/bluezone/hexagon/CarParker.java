package io.github.jmgarridopaz.bluezone.hexagon;

import java.math.BigDecimal;
import java.time.Clock;
import java.time.LocalDateTime;
import java.util.*;

public class CarParker implements ForParkingCars {

    private final ForObtainingRates rateProvider;
    private final ForPaying eWalletService;
    private final ForStoringTickets ticketStore;

    public CarParker(ForObtainingRates rateProvider, ForPaying eWalletService, ForStoringTickets ticketStore) {
        this.rateProvider = rateProvider;
        this.eWalletService = eWalletService;
        this.ticketStore = ticketStore;
    }

    @Override
    public Map<String, RateData> getAllRatesByName() {
        Map<String,RateData> allRatesByName = new HashMap<String,RateData>();
        Set<RateData> allRates = this.rateProvider.findAll();
        Iterator<RateData> ratesIterator = allRates.iterator();
        while (ratesIterator.hasNext()) {
            RateData rate = ratesIterator.next();
            allRatesByName.put ( rate.getName(), rate );
        }
        return allRatesByName;
    }

    @Override
    public String purchaseTicket ( PurchaseTicketRequest purchaseTicketRequest ) {
        // Pay
        String carPlate = purchaseTicketRequest.getCarPlate();
        BigDecimal moneyInWallet = this.eWalletService.getMoneyInWallet ( carPlate );
        BigDecimal moneyToPay = purchaseTicketRequest.getAmount();
        if ( moneyInWallet.compareTo(moneyToPay)==-1 ) {
            throw new NotEnoughMoneyException(moneyInWallet,moneyToPay);
        }
        this.eWalletService.payWithWallet ( carPlate, moneyToPay );
        // Calc ending date-time
        String rateName = purchaseTicketRequest.getRateName();
        RateData rate = this.rateProvider.findByName(rateName);
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
