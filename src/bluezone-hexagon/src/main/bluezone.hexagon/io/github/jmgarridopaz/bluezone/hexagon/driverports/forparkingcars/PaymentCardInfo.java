package io.github.jmgarridopaz.bluezone.hexagon.driverports.forparkingcars;

import java.util.Objects;


public final class PaymentCardInfo {
	
	private final String number;
	private final String cvv;
	private final String expirationDate;

	
	public PaymentCardInfo ( String number, String cvv, String expirationDate ) {
		this.number = number;
		this.cvv = cvv;
		this.expirationDate = expirationDate;
	}
	
	
	public String number() {
		return this.number;
	}

	public String cvv() {
		return this.cvv;
	}

	public String expirationDate() {
		return this.expirationDate;
	}

	
	@Override
	public int hashCode() {
		return Objects.hash ( this.number, this.cvv, this.expirationDate );
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if ( obj==null ) {
			return false;
		}
		if (!(obj instanceof PaymentCardInfo)) {
			return false;
		}
		PaymentCardInfo other = (PaymentCardInfo) obj;
		return
				Objects.equals(this.number, other.number()) &&
				Objects.equals(this.cvv, other.cvv()) &&
				Objects.equals(this.expirationDate, other.expirationDate());
	}
	
}
