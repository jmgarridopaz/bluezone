package io.github.jmgarridopaz.bluezone.hexagon.payment;

import java.time.YearMonth;
import java.util.Objects;


/**
 * DTO class with information about a payment card:
 * 
 * 		number			16 digits
 * 		cvv				Card verification value (3 digits)
 * 		expirationDate	Year and month from which the card will no longer be valid
 */
public class PaymentCardData {
	
	private String		number;
	private String		cvv;
	private YearMonth	expirationDate;

	
	public PaymentCardData() {}


	public String getNumber() {
		return number;
	}


	public void setNumber(String number) {
		this.number = number;
	}


	public String getCvv() {
		return cvv;
	}


	public void setCvv(String cvv) {
		this.cvv = cvv;
	}


	public YearMonth getExpirationDate() {
		return expirationDate;
	}


	public void setExpirationDate(YearMonth expirationDate) {
		this.expirationDate = expirationDate;
	}


	@Override
	public int hashCode() {
		return Objects.hash(cvv, expirationDate, number);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof PaymentCardData)) {
			return false;
		}
		PaymentCardData other = (PaymentCardData) obj;
		return Objects.equals(cvv, other.cvv) && Objects.equals(expirationDate, other.expirationDate)
				&& Objects.equals(number, other.number);
	}


	@Override
	public String toString() {
		return String.format("PaymentCardData [number=%s, cvv=%s, expirationDate=%s]", number, cvv, expirationDate);
	}

}
