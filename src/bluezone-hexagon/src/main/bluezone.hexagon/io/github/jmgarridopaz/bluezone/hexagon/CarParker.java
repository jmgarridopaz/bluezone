package io.github.jmgarridopaz.bluezone.hexagon;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


/**
 * Business logic inside the hexagon.
 * Implements driver port interface.
 * Configurable dependency on driven port interfaces.
 */
public class CarParker implements ForParkingCars {
	
	private final ForObtainingRates forObtainingRates;
	private final ForStoringPermits forStoringPermits;
	private final ForPaying forPaying;

	
	public CarParker ( ForObtainingRates forObtainingRates, ForStoringPermits forStoringPermits, ForPaying forPaying ) {
		this.forObtainingRates = forObtainingRates;
		this.forStoringPermits = forStoringPermits;
		this.forPaying = forPaying;
	}

	
	@Override
	public Map<String,RateData> getAllRatesByName() {
		Set<RateData> allRates = this.forObtainingRates.getAll();
		return allRates.stream().collect(Collectors.toMap(rateData -> rateData.getName(), rateData -> rateData));
	}


	@Override
	public PermitTicket issuePermit ( Clock clock, PermitRequest permitRequest ) {
		
		// Gather data needed
		LocalDateTime	now			= LocalDateTime.now(clock);
		String			carPlate	= permitRequest.getCarPlate();
		String			rateName	= permitRequest.getRateName();
		LocalDateTime	until		= permitRequest.getEndingDateTime();
		PaymentCardData paymentCard	= permitRequest.getPaymentCard();
		
		// Create the permit
		RateData rateData = this.forObtainingRates.findByName(rateName);
		Rate rate = Rate.fromData ( rateData );
		Permit permit = Permit.untilDateTime ( carPlate, rate, now, until );

		// Pay the permit price
		this.forPaying.payWithCard ( paymentCard, permit.price(), permit.ticketCode() );

		// Store and return the permit ticket
		PermitTicket permitTicket = permit.toTicket();
		this.forStoringPermits.save ( permitTicket );
		return permitTicket;
		
	}


	@Override
	public void addRatesToRepo(Set<RateData> rates) {
		this.forObtainingRates.addAll(rates);
		return;
	}


	@Override
	public PermitTicket getPermitTicketByCode(String permitTicketCode) {
		return this.forStoringPermits.findByCode ( permitTicketCode );
	}


	@Override
	public boolean paymentIsDone(String cardNumber, String amount, String currencyCode, String permitTicketCode) {
		return this.forPaying.existsPayment(cardNumber,amount,currencyCode,permitTicketCode);
	}

}