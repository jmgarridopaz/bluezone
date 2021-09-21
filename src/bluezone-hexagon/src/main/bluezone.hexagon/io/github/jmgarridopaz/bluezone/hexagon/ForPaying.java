package io.github.jmgarridopaz.bluezone.hexagon;


public interface ForPaying {

	public void payWithCard ( PaymentCardData paymentCardData, Money amount, PermitTicketCode permitTicketCode );

	public boolean existsPayment(String cardNumber, String amount, String currencyCode, String permitTicketCode);

}
