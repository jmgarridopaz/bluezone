package io.github.jmgarridopaz.bluezone.adapter.forpaying.mock;

import io.github.jmgarridopaz.bluezone.hexagon.ForPaying;
import io.github.jmgarridopaz.bluezone.hexagon.Money;
import io.github.jmgarridopaz.bluezone.hexagon.PaymentCardData;
import io.github.jmgarridopaz.bluezone.hexagon.PermitTicketCode;

/**
 * 
 * Driven adapter that implements "forpaying" port with a mock test double.
 * 
 */
public class ForPayingMockAdapter implements ForPaying {

	@Override
	public void payWithCard(PaymentCardData paymentCardData, Money amount, PermitTicketCode permitTicketCode) {
	}

	@Override
	public boolean existsPayment(String cardNumber, String amount, String currencyCode, String permitTicketCode) {
		return true;
	}

}
