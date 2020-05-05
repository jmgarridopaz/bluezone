package io.github.jmgarridopaz.bluezone.hexagon.driverports.forparkingcars.implementation;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneOffset;
import java.util.Set;
import io.github.jmgarridopaz.bluezone.hexagon.driverports.forparkingcars.ForParkingCars;
import io.github.jmgarridopaz.bluezone.hexagon.driverports.forparkingcars.PaymentCardInfo;
import io.github.jmgarridopaz.bluezone.hexagon.driverports.forparkingcars.PermitRequest;
import io.github.jmgarridopaz.bluezone.hexagon.driverports.forparkingcars.PermitTicket;
import io.github.jmgarridopaz.bluezone.hexagon.driverports.forparkingcars.RateInfo;
import io.github.jmgarridopaz.bluezone.hexagon.driverports.forparkingcars.Timetable;


public class HardCodedCarParker implements ForParkingCars {

	private static final Clock				EXPECTED_CLOCK				= Clock.fixed(Instant.parse("2020-04-22T08:00:00.00Z"),ZoneOffset.UTC);
	private static final String				EXPECTED_CAR_PLATE			= "0000AAA";
	private static final String				EXPECTED_RATE_NAME			= "GREEN_ZONE";
	private static final String 			EXPECTED_ENDING_DATETIME	= "2020/04/22 10:00";
	private static final PaymentCardInfo	EXPECTED_PAYMENT_CARD_INFO	= new PaymentCardInfo("1234567890123456","123","2025/06");
	
	
	public HardCodedCarParker() {
	}

	
	@Override
	public Set<RateInfo> getAllRates() {
		
		return Set.of
					(
					new RateInfo("GREEN_ZONE", "0.65 €", "60-180", new Timetable("08:00-22:00","08:00-22:00","08:00-22:00","08:00-22:00","08:00-22:00","08:00-22:00","08:00-22:00")),
					new RateInfo("BLUE_ZONE", "0.85 €", "35-120", new Timetable("09:00-14:00-17:00-20:00","09:00-14:00-17:00-20:00","09:00-14:00-17:00-20:00","09:00-14:00-17:00-20:00","09:00-14:00-17:00-20:00","10:00-14:00",""))
					);
	}


	@Override
	public PermitTicket issuePermit ( Clock clock, PermitRequest permitRequest ) {
		if ( ! clock.equals(EXPECTED_CLOCK) ) {
			throw new IllegalArgumentException("clock");
		}
		if ( ! permitRequest.carPlate().equals(EXPECTED_CAR_PLATE) ) {
			throw new IllegalArgumentException("carPlate");			
		}
		if ( ! permitRequest.rateName().equals(EXPECTED_RATE_NAME) ) {
			throw new IllegalArgumentException("rateName");			
		}
		if ( ! permitRequest.endingDateTime().equals(EXPECTED_ENDING_DATETIME) ) {
			throw new IllegalArgumentException("endingDateTime");			
		}
		if ( ! permitRequest.paymentCardInfo().equals(EXPECTED_PAYMENT_CARD_INFO) ) {
			throw new IllegalArgumentException("paymentCardInfo");
		}
		return new PermitTicket("PT/0000000000/202004220800","0000AAA","GREEN_ZONE","2020/04/22 08:00","2020/04/22 10:00", "1.30 €");
	}

}
