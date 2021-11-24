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
 * 
 * It redirects request either to the hardcoded implementation or to the real one.
 * 
 */
public class CarParker implements ForParkingCars {
	
	private final ForParkingCars forParkingCars;

	
	public CarParker ( ForObtainingRates forObtainingRates, ForStoringPermits forStoringPermits, ForPaying forPaying ) {
		if ( forObtainingRates==null && forStoringPermits==null && forPaying==null ) {
			this.forParkingCars =  new HardCodedCarParker();
		} else {
			this.forParkingCars = new RealCarParker(forObtainingRates, forStoringPermits, forPaying);
		}
	}


	@Override
	public Map<String, RateData> getAllRatesByName() {
		return this.forParkingCars.getAllRatesByName();
	}


	@Override
	public PermitTicket issuePermit(Clock clock, PermitRequest permitRequest) {
		return this.forParkingCars.issuePermit(clock, permitRequest);
	}

}
