package io.github.jmgarridopaz.bluezone.hexagon;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


/**
 * Real implementation for the driver port.
 * It depends on driven ports.
 * As opposed to the hardcoded implementation.
 */
class RealCarParker implements ForParkingCars {
	
	private final ForObtainingRates forObtainingRates;
	private final ForStoringPermits forStoringPermits;
	private final ForPaying forPaying;

	
	RealCarParker ( ForObtainingRates forObtainingRates, ForStoringPermits forStoringPermits, ForPaying forPaying ) {
		this.forObtainingRates = forObtainingRates;
		this.forStoringPermits = forStoringPermits;
		this.forPaying = forPaying;
	}


	@Override
	public Map<String, RateData> getAllRatesByName() {
		Set<RateData> allRates = this.forObtainingRates.getAll();
		return allRates.stream().collect(Collectors.toMap(rateData -> rateData.getName(), rateData -> rateData));
	}


	@Override
	public PermitTicket issuePermit(Clock clock, PermitRequest permitRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	
//	@Override
//	public Map<String,RateData> getAllRatesByName() {
//		Set<RateData> allRates = this.forObtainingRates.getAll();
//		return allRates.stream().collect(Collectors.toMap(rateData -> rateData.getName(), rateData -> rateData));
//	}
//
//
//	@Override
//	public PermitTicket issuePermit ( Clock clock, PermitRequest permitRequest ) {
//		
//		// Gather data needed
//		LocalDateTime	now			= LocalDateTime.now(clock);
//		String			carPlate	= permitRequest.getCarPlate();
//		String			rateName	= permitRequest.getRateName();
//		LocalDateTime	until		= permitRequest.getEndingDateTime();
//		PaymentCardData paymentCard	= permitRequest.getPaymentCard();
//		
//		// Create the permit
//		RateData rateData = this.forObtainingRates.findByName(rateName);
//		Rate rate = Rate.fromData ( rateData );
//		Permit permit = Permit.untilDateTime ( carPlate, rate, now, until );
//
//		// Pay the permit price
//		this.forPaying.payWithCard ( paymentCard, permit.price(), permit.ticketCode() );
//
//		// Store and return the permit ticket
//		PermitTicket permitTicket = permit.toTicket();
//		this.forStoringPermits.save ( permitTicket );
//		return permitTicket;
//		
//	}

}
