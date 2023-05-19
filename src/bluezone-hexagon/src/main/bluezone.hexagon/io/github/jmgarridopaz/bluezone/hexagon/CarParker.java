package io.github.jmgarridopaz.bluezone.hexagon;

import io.github.jmgarridopaz.bluezone.hexagon.ports.driven.forobtainingrates.ForObtainingRates;
import io.github.jmgarridopaz.bluezone.hexagon.ports.driven.forobtainingrates.Rate;
import io.github.jmgarridopaz.bluezone.hexagon.ports.driven.forpaying.ForPaying;
import io.github.jmgarridopaz.bluezone.hexagon.ports.driven.forpaying.PayRequest;
import io.github.jmgarridopaz.bluezone.hexagon.ports.driven.forstoringtickets.ForStoringTickets;
import io.github.jmgarridopaz.bluezone.hexagon.ports.driven.forstoringtickets.Ticket;
import io.github.jmgarridopaz.bluezone.hexagon.ports.driving.forparkingcars.ForParkingCars;
import io.github.jmgarridopaz.bluezone.hexagon.ports.driving.forparkingcars.PurchaseTicketRequest;

import java.math.BigDecimal;
import java.time.Clock;
import java.time.LocalDateTime;
import java.util.*;


public class CarParker implements ForParkingCars {

    private final ForObtainingRates rateProvider;
    private final ForStoringTickets ticketStore;
    private final ForPaying paymentService;

    public CarParker(ForObtainingRates rateProvider, ForStoringTickets ticketStore, ForPaying eWalletService) {
        this.rateProvider = rateProvider;
        this.ticketStore = ticketStore;
        this.paymentService = eWalletService;
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
        String ticketCode = this.ticketStore.nextCode();
        String paymentCard = purchaseTicketRequest.getPaymentCard();
        BigDecimal moneyToPay = purchaseTicketRequest.getAmount();
        PayRequest payRequest = new PayRequest ( ticketCode, paymentCard, moneyToPay );
        this.paymentService.pay ( payRequest );
        // Calc ending date-time
        String rateName = purchaseTicketRequest.getRateName();
        Rate rate = this.rateProvider.findByName(rateName);
        RateCalculator rateCalculator = new RateCalculator(rate);
        Clock clock = purchaseTicketRequest.getClock();
        LocalDateTime starting = LocalDateTime.now(clock);
        LocalDateTime ending = rateCalculator.getUntilGivenAmount ( starting, moneyToPay );
        // Store
        String carPlate = purchaseTicketRequest.getCarPlate();
        Ticket ticket = new Ticket(ticketCode,carPlate,rateName,starting,ending,moneyToPay);
        this.ticketStore.store(ticket);
        return ticketCode;
    }

    @Override
    public Ticket getTicket (String ticketCode ) {
        return this.ticketStore.findByCode ( ticketCode);
    }
    
}
