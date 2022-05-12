package io.github.jmgarridopaz.bluezone.adapter.forpaying.mock;

/**
 * 
 * Driven adapter that implements "forpaying" port with a mock test double.
 * 
 */
public class ForPayingMockAdapter implements ForPaying {

	@Override
	public void payWithCard(PaymentCardData paymentCardData, Money amount, PermitTicketCode permitTicketCode) {
	}

}
