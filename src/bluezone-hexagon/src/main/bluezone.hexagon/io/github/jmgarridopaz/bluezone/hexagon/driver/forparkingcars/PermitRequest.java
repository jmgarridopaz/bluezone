package io.github.jmgarridopaz.bluezone.hexagon.driver.forparkingcars;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * DTO class with the input needed for issuing a permit:
 * 
 * 		carPlate		Plate of the car to get the permit for
 * 		rateName		Rate name of the regulated area where the car will be parked at
 * 		endingDateTime	Expiration datetime of the permit period
 * 		paymentCard		Data of the card to charge the permit price to. @see PaymentCardData
 */
public class PermitRequest {

	private String			carPlate;
	private String			rateName;
	private LocalDateTime	endingDateTime;
	private PaymentCardData	paymentCard;
	

	public PermitRequest() {}


	public String getCarPlate() {
		return carPlate;
	}


	public void setCarPlate(String carPlate) {
		this.carPlate = carPlate;
	}


	public String getRateName() {
		return rateName;
	}


	public void setRateName(String rateName) {
		this.rateName = rateName;
	}


	public LocalDateTime getEndingDateTime() {
		return endingDateTime;
	}


	public void setEndingDateTime(LocalDateTime endingDateTime) {
		this.endingDateTime = endingDateTime;
	}


	public PaymentCardData getPaymentCard() {
		return paymentCard;
	}


	public void setPaymentCard(PaymentCardData paymentCard) {
		this.paymentCard = paymentCard;
	}


	@Override
	public int hashCode() {
		return Objects.hash(carPlate, endingDateTime, paymentCard, rateName);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof PermitRequest)) {
			return false;
		}
		PermitRequest other = (PermitRequest) obj;
		return Objects.equals(carPlate, other.carPlate) && Objects.equals(endingDateTime, other.endingDateTime)
				&& Objects.equals(paymentCard, other.paymentCard) && Objects.equals(rateName, other.rateName);
	}


	@Override
	public String toString() {
		return String.format("PermitRequest [carPlate=%s, rateName=%s, endingDateTime=%s, paymentCard=%s]", carPlate,
				rateName, endingDateTime, paymentCard);
	}

}
