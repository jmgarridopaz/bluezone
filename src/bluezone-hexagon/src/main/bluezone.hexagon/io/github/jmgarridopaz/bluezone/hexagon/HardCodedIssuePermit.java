package io.github.jmgarridopaz.bluezone.hexagon;

import java.math.BigDecimal;
import java.time.*;


public final class HardCodedIssuePermit {

	private static final LocalDateTime	EXPECTED_CURRENT_DATE_TIME		= LocalDateTime.of(2022,Month.JANUARY,4,19,15, 06);
	private static final String			EXPECTED_CAR_PLATE				= "9999ZZZ";
	private static final String			EXPECTED_RATE_NAME				= "RED_ZONE";
	private static final LocalDateTime	EXPECTED_ENDING_DATE_TIME		= LocalDateTime.of(2022,Month.JANUARY,4,20,0);
	private static final String			EXPECTED_PAYMENT_CARD_NUMBER	= "1234567890123456";

	private static final String			RETURNED_CODE					= "PT-20220104191506-9999252525";
	private static final String			RETURNED_CAR_PLATE				= "9999ZZZ";
	private static final LocalDateTime	RETURNED_STARTING_DATE_TIME		= LocalDateTime.of(2022,Month.JANUARY,4,19,15);
	private static final LocalDateTime	RETURNED_ENDING_DATE_TIME		= LocalDateTime.of(2022,Month.JANUARY,4,20,0);
	private static final String			RETURNED_RATE_NAME				= "RED_ZONE";
	private static final BigDecimal		RETURNED_PRICE					= new BigDecimal("0.90");

	
	private HardCodedIssuePermit() {}


	public static ParkingRequest expectedPermitRequest() {
		ParkingRequest permitRequest			= new ParkingRequest();
		permitRequest.setClock				(expectedClock());
		permitRequest.setCarPlate			(EXPECTED_CAR_PLATE);
		permitRequest.setRateName			(EXPECTED_RATE_NAME);
		permitRequest.setEndingDateTime		(EXPECTED_ENDING_DATE_TIME);
		permitRequest.setPaymentCardNumber	(EXPECTED_PAYMENT_CARD_NUMBER);
		return permitRequest;
	}


	public static PermitTicket returnedPermitTicket() {
		PermitTicket permitTicket			= new PermitTicket();
		permitTicket.setCode				(RETURNED_CODE);
		permitTicket.setCarPlate			(RETURNED_CAR_PLATE);
		permitTicket.setStartingDateTime	(RETURNED_STARTING_DATE_TIME);
		permitTicket.setEndingDateTime		(RETURNED_ENDING_DATE_TIME);
		permitTicket.setRateName			(RETURNED_RATE_NAME);
		permitTicket.setPrice				(RETURNED_PRICE);
		return permitTicket;
	}


	private static Clock expectedClock() {
		return Clock.fixed ( EXPECTED_CURRENT_DATE_TIME.toInstant(ZoneOffset.UTC), ZoneOffset.UTC );
	}

}
