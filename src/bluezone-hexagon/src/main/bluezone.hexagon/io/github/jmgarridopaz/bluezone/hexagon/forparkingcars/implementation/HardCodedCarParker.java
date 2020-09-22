package io.github.jmgarridopaz.bluezone.hexagon.forparkingcars.implementation;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Map;
import io.github.jmgarridopaz.bluezone.hexagon.forparkingcars.ForParkingCars;
import io.github.jmgarridopaz.bluezone.hexagon.forparkingcars.PermitRequest;
import io.github.jmgarridopaz.bluezone.hexagon.forparkingcars.PermitTicket;
import io.github.jmgarridopaz.bluezone.hexagon.forparkingcars.RateData;


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
