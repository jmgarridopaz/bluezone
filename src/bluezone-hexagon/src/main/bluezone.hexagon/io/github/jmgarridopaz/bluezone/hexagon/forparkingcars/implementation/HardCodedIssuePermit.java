package io.github.jmgarridopaz.bluezone.hexagon.forparkingcars.implementation;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.YearMonth;

import io.github.jmgarridopaz.bluezone.hexagon.forparkingcars.MoneyDto;
import io.github.jmgarridopaz.bluezone.hexagon.forparkingcars.PaymentCardData;
import io.github.jmgarridopaz.bluezone.hexagon.forparkingcars.PermitRequest;
import io.github.jmgarridopaz.bluezone.hexagon.forparkingcars.PermitTicket;


public final class HardCodedIssuePermit {

	private static final String			EXPECTED_CAR_PLATE				= "0000AAA";
	private static final String			EXPECTED_RATE_NAME				= "GREEN_ZONE";
	private static final LocalDateTime	EXPECTED_CURRENT_DATE_TIME		= LocalDateTime.of(2020,Month.APRIL,22,8,0);
	private static final LocalDateTime	EXPECTED_ENDING_DATE_TIME		= LocalDateTime.of(2020,Month.APRIL,22,10,0);
	private static final String			EXPECTED_PAYMENT_CARD_NUMBER	= "1234567890123456";
	private static final String			EXPECTED_PAYMENT_CARD_CVV		= "123";
	private static final YearMonth		EXPECTED_CARD_EXPIRATION_DATE	= YearMonth.of(2025, Month.JUNE);
	
	private static final String			RETURNED_PERMIT_TICKET_CODE		= "PT/0000000000/202004220800";
	private static final String			RETURNED_CAR_PLATE				= "0000AAA";
	private static final LocalDateTime	RETURNED_STARTING_DATE_TIME		= LocalDateTime.of(2020,Month.APRIL,22,8,0);;
	private static final LocalDateTime	RETURNED_ENDING_DATE_TIME		= LocalDateTime.of(2020,Month.APRIL,22,10,0);;
	private static final String			RETURNED_RATE_NAME				= "GREEN_ZONE";
	private static final BigDecimal		RETURNED_PRICE_AMOUNT			= new BigDecimal("1.30");
	private static final String			RETURNED_PRICE_CURRENCY_SYMBOL	= "€";

	
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
		permitTicket.setPrice				(returnedPrice());
		return permitTicket;
	}

	
	private static PaymentCardData expectedPaymentCard() {
		PaymentCardData paymentCardData		= new PaymentCardData();
		paymentCardData.setNumber			(EXPECTED_PAYMENT_CARD_NUMBER);
		paymentCardData.setCvv				(EXPECTED_PAYMENT_CARD_CVV);
		paymentCardData.setExpirationDate	(EXPECTED_CARD_EXPIRATION_DATE);
		return paymentCardData;
	}


	private static MoneyDto returnedPrice() {
		MoneyDto price			= new MoneyDto();
		price.setAmount			(RETURNED_PRICE_AMOUNT);
		price.setCurrencySymbol	(RETURNED_PRICE_CURRENCY_SYMBOL);
		return price;
	}
	
}
