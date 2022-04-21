package io.github.jmgarridopaz.bluezone.hexagon;

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
class HardCodedCarParker implements ForParkingCars {
	
	HardCodedCarParker() {}

	
	@Override
	public Map<String,RateData> getAllRatesByName() {
		RateData orangeZoneRate = HardCodedOrangeZoneRate.get();
		RateData redZoneRate = HardCodedRedZoneRate.get();
		return Map.of
					(
					orangeZoneRate.getName(),orangeZoneRate,
					redZoneRate.getName(),redZoneRate
					);
	}


	@Override
	public PermitTicket issuePermit ( ParkingRequest permitRequest ) {
		if ( ! HardCodedIssuePermit.expectedPermitRequest().equals ( permitRequest ) ) {
			throw new IllegalArgumentException("permitRequest");
		}
		return HardCodedIssuePermit.returnedPermitTicket();
	}

}
