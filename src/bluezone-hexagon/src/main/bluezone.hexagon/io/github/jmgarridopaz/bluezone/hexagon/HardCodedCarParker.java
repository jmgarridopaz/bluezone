package io.github.jmgarridopaz.bluezone.hexagon;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Map;


/**
 * 
 * Test double for the driver port.
 * Useful for testing driver adapters 'mocking' the hexagon.
 * 
 * It doesn't depend on any driven port.
 * 
 * Port operations takes/return hardcoded values.
 */
public class HardCodedCarParker implements ForParkingCars {
	
	public HardCodedCarParker() {}

	
	@Override
	public Map<String,RateData> getAllRatesByName() {
		RateData blueZoneRate = HardCodedBlueZoneRate.get();
		RateData greenZoneRate = HardCodedGreenZoneRate.get();
		return Map.of
					(
					blueZoneRate.getName(),blueZoneRate,
					greenZoneRate.getName(),greenZoneRate
					);
	}


	@Override
	public PermitTicket issuePermit ( Clock clock, PermitRequest permitRequest ) {
		if ( ! HardCodedIssuePermit.expectedCurrentDateTime().equals ( LocalDateTime.now(clock).truncatedTo(ChronoUnit.MINUTES) ) ) {
			throw new IllegalArgumentException("clock");
		}
		if ( ! HardCodedIssuePermit.expectedPermitRequest().equals ( permitRequest ) ) {
			throw new IllegalArgumentException("permitRequest");
		}
		return HardCodedIssuePermit.returnedPermitTicket();
	}

}
