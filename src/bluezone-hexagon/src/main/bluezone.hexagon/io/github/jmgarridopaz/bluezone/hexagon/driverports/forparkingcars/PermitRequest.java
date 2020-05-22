package io.github.jmgarridopaz.bluezone.hexagon.driverports.forparkingcars;

import java.util.Objects;

/**
 * DTO class with the input needed for issuing a permit:
 * 
 * 		carPlate		Plate of the car to get the permit for
 * 		rateName		Rate name of the regulated area where the car will be parked at
 * 		endingDateTime	Expiration datetime of the permit period. Format: "2020/12/31 13:59"
 * 		paymentCardInfo	Information about the card to charge the permit price to. @see PaymentCardInfo
 */
public final class PermitRequest {

	private final String			carPlate;
	private final String			rateName;
	private final String			endingDateTime;
	private final PaymentCardInfo	paymentCardInfo;
	
	
	public PermitRequest ( String carPlate, String rateName, String endingDateTime, PaymentCardInfo paymentCardInfo ) {
		this.carPlate = carPlate;
		this.rateName = rateName;
		this.endingDateTime = endingDateTime;
		this.paymentCardInfo = paymentCardInfo;
	}
	
	
	public String carPlate() {
		return this.carPlate;
	}

	public String rateName() {
		return this.rateName;
	}

	public String endingDateTime() {
		return this.endingDateTime;
	}

	public PaymentCardInfo paymentCardInfo() {
		return this.paymentCardInfo;
	}

	
	@Override
	public int hashCode() {
		return Objects.hash ( this.carPlate, this.rateName, this.endingDateTime, this.paymentCardInfo );
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if ( obj==null ) {
			return false;
		}
		if (!(obj instanceof PermitRequest)) {
			return false;
		}
		PermitRequest other = (PermitRequest) obj;
		
		return	Objects.equals(this.carPlate, other.carPlate()) &&
				Objects.equals(this.rateName, other.rateName()) &&
				Objects.equals(this.endingDateTime, other.endingDateTime()) &&
				Objects.equals(this.paymentCardInfo, other.paymentCardInfo());
	}
	
}
