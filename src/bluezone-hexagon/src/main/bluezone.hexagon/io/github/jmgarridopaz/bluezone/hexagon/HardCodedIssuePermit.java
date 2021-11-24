package io.github.jmgarridopaz.bluezone.hexagon;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.YearMonth;


public final class HardCodedIssuePermit {

	private static final String			EXPECTED_CAR_PLATE				= "9999ZZZ";
	private static final String			EXPECTED_RATE_NAME				= "RED_ZONE";
	private static final LocalDateTime	EXPECTED_CURRENT_DATE_TIME		= LocalDateTime.of(2021,Month.NOVEMBER,16,17,50);
	private static final LocalDateTime	EXPECTED_ENDING_DATE_TIME		= LocalDateTime.of(2021,Month.NOVEMBER,16,18,35);
	private static final String			EXPECTED_PAYMENT_CARD_NUMBER	= "9876543210654321";
	private static final String			EXPECTED_PAYMENT_CARD_CVV		= "321";
	private static final YearMonth		EXPECTED_CARD_EXPIRATION_DATE	= YearMonth.of(2030, Month.JANUARY);
	
	private static final String			RETURNED_PERMIT_TICKET_CODE		= "9999252525202111161750";
	private static final String			RETURNED_CAR_PLATE				= "9999ZZZ";
	private static final LocalDateTime	RETURNED_STARTING_DATE_TIME		= LocalDateTime.of(2021,Month.NOVEMBER,16,17,50);
	private static final LocalDateTime	RETURNED_ENDING_DATE_TIME		= LocalDateTime.of(2021,Month.NOVEMBER,16,18,35);
	private static final String			RETURNED_RATE_NAME				= "RED_ZONE";
	private static final BigDecimal		RETURNED_PRICE					= new BigDecimal("0.94");

	
	private HardCodedIssuePermit() {}


	public static LocalDateTime expectedCurrentDateTime() {
		return EXPECTED_CURRENT_DATE_TIME;
	}


	public static PermitRequest expectedPermitRequest() {
		PermitRequest permitRequest		= new PermitRequest();
		permitRequest.setCarPlate		(EXPECTED_CAR_PLATE);
		permitRequest.setRateName		(EXPECTED_RATE_NAME);
		permitRequest.setEndingDateTime	(EXPECTED_ENDING_DATE_TIME);
		permitRequest.setPaymentCard	(expectedPaymentCard());
		return permitRequest;
	}


	public static PermitTicket returnedPermitTicket() {
		PermitTicket permitTicket			= new PermitTicket();
		permitTicket.setCode				(RETURNED_PERMIT_TICKET_CODE);
		permitTicket.setCarPlate			(RETURNED_CAR_PLATE);
		permitTicket.setStartingDateTime	(RETURNED_STARTING_DATE_TIME);
		permitTicket.setEndingDateTime		(RETURNED_ENDING_DATE_TIME);
		permitTicket.setRateName			(RETURNED_RATE_NAME);
		permitTicket.setPrice				(RETURNED_PRICE);
		return permitTicket;
	}

	
	private static PaymentCardData expectedPaymentCard() {
		PaymentCardData paymentCardData		= new PaymentCardData();
		paymentCardData.setNumber			(EXPECTED_PAYMENT_CARD_NUMBER);
		paymentCardData.setCvv				(EXPECTED_PAYMENT_CARD_CVV);
		paymentCardData.setExpirationDate	(EXPECTED_CARD_EXPIRATION_DATE);
		return paymentCardData;
	}

}
