package io.github.jmgarridopaz.bluezone.hexagon.driver.forparkingcars;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * DTO class with the output returned when issuing a permit:
 * 
 * 		code				Unique identifier of the permit
 * 		carPlate			Plate of the car the permit has been issued for
 * 		startingDateTime	When the permit period begins
 * 		endingDateTime		When the permit period expires
 * 		rateName			Rate name of the regulated area where the car is parked at
 * 		price				Amount of money payed for the permit
 */
public class PermitTicket {

	private String			code;
	private String			carPlate;
	private LocalDateTime	startingDateTime;
	private LocalDateTime	endingDateTime;
	private String			rateName;
	private MoneyDto		price;
	
	public PermitTicket() {}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCarPlate() {
		return carPlate;
	}

	public void setCarPlate(String carPlate) {
		this.carPlate = carPlate;
	}

	public LocalDateTime getStartingDateTime() {
		return startingDateTime;
	}

	public void setStartingDateTime(LocalDateTime startingDateTime) {
		this.startingDateTime = startingDateTime;
	}

	public LocalDateTime getEndingDateTime() {
		return endingDateTime;
	}

	public void setEndingDateTime(LocalDateTime endingDateTime) {
		this.endingDateTime = endingDateTime;
	}

	public String getRateName() {
		return rateName;
	}

	public void setRateName(String rateName) {
		this.rateName = rateName;
	}

	public MoneyDto getPrice() {
		return price;
	}

	public void setPrice(MoneyDto price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(carPlate, code, endingDateTime, price, rateName, startingDateTime);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof PermitTicket)) {
			return false;
		}
		PermitTicket other = (PermitTicket) obj;
		return Objects.equals(carPlate, other.carPlate) && Objects.equals(code, other.code)
				&& Objects.equals(endingDateTime, other.endingDateTime) && Objects.equals(price, other.price)
				&& Objects.equals(rateName, other.rateName) && Objects.equals(startingDateTime, other.startingDateTime);
	}

	@Override
	public String toString() {
		return String.format(
				"PermitTicket [code=%s, carPlate=%s, startingDateTime=%s, endingDateTime=%s, rateName=%s, price=%s]",
				code, carPlate, startingDateTime, endingDateTime, rateName, price);
	}
	
}
