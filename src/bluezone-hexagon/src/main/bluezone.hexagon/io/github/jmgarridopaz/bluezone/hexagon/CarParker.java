package io.github.jmgarridopaz.bluezone.hexagon;

import java.time.Clock;
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
//	private final ForStoringPermits forStoringPermits;
//	private final ForPaying forPaying;

	
//	public CarParker ( ForObtainingRates forObtainingRates, ForStoringPermits forStoringPermits, ForPaying forPaying ) {
	public CarParker ( ForObtainingRates forObtainingRates ) {
		this.forObtainingRates = forObtainingRates;
//		this.forStoringPermits = forStoringPermits;
//		this.forPaying = forPaying;
	}

	
	@Override
	public Map<String,RateData> getAllRatesByName() {
		Set<RateData> allRates = this.forObtainingRates.getAll();
		return allRates.stream().collect(Collectors.toMap(rateData -> rateData.getName(), rateData -> rateData));
	}


	@Override
	public PermitTicket issuePermit ( Clock clock, PermitRequest permitRequest ) {
		return null;
//		// Gather data needed
//		LocalDateTime	now			= LocalDateTime.now(clock);
//		String			carPlate	= permitRequest.getCarPlate();
//		String			rateName	= permitRequest.getRateName();
//		LocalDateTime	until		= permitRequest.getEndingDateTime();
//		PaymentCardData paymentCard	= permitRequest.getPaymentCard();
//		
//		// Check business rule
//		if ( this.forStoringPermits.existsActive(now,carPlate,rateName) ) {
//			throw new RuntimeException("You already have an active permit for the rate");
//		}
//		
//		// Create the permit
//		Rate rate = Rate.fromData ( this.forObtainingRates.getByName(rateName) );
//		Permit permit = Permit.create ( carPlate, rate, now, until );
//		permit.calculatePrice();
//		
//		// Pay the permit price
//		this.forPaying.payWithCard ( paymentCard, permit.price() );
//		
//		// Store and return the permit ticket
//		PermitTicket permitTicket = permit.ticket();
//		this.forStoringPermits.save ( permitTicket );
//		return permitTicket;
	}

}
