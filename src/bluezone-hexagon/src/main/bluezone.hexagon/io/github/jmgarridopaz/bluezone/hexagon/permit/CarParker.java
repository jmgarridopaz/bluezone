package io.github.jmgarridopaz.bluezone.hexagon.permit;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import io.github.jmgarridopaz.bluezone.hexagon.HardCodedHexagon;
import io.github.jmgarridopaz.bluezone.hexagon.permit.PermitRequest;
import io.github.jmgarridopaz.bluezone.hexagon.permit.PermitTicket;
import io.github.jmgarridopaz.bluezone.hexagon.rate.ForObtainingRates;
import io.github.jmgarridopaz.bluezone.hexagon.rate.RateData;

/**
 * Driver Port interface implementation.
 * Business logic inside the hexagon.
 * Uses driven ports if necessary.
 */
public class CarParker implements ForParkingCars {
	
	private final ForObtainingRates forObtainingRates;


	public CarParker ( ForObtainingRates forObtainingRates ) {
		this.forObtainingRates = forObtainingRates;
	}

	
	@Override
	public Map<String,RateData> getAllRatesByName() {
		Set<RateData> allRates = this.forObtainingRates.getAll();
		return allRates.stream().collect(Collectors.toMap(rateData -> rateData.getName(), rateData -> rateData));
	}


	@Override
	public PermitTicket issuePermit ( Clock clock, PermitRequest permitRequest ) {
		/* TODO */
		return null;
	}

}
