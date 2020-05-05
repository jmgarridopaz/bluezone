package io.github.jmgarridopaz.bluezone.hexagon.driverports.forparkingcars;

import java.util.Objects;


public final class PermitTicket {

	private final String code;
	private final String carPlate;
	private final String rateName;
	private final String startingDateTime;
	private final String endingDateTime;
	private final String price;
	
	
	public PermitTicket ( String code, String carPlate, String rateName, String startingDateTime, String endingDateTime, String price ) {
		this.code = code;
		this.carPlate = carPlate;
		this.rateName = rateName;
		this.startingDateTime = startingDateTime;
		this.endingDateTime = endingDateTime;
		this.price = price;
	}

	
	public String code() {
		return this.code;
	}
	
	public String carPlate() {
		return this.carPlate;
	};
	
	public String rateName() {
		return this.rateName;
	};
	
	public String startingDateTime() {
		return this.startingDateTime;
	};
	
	public String endingDateTime() {
		return this.endingDateTime;
	};
	
	public String price() {
		return this.price;
	};
	
	
	@Override
	public int hashCode() {
		return Objects.hash(this.code,this.carPlate,this.rateName,this.startingDateTime,this.endingDateTime,this.price);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if ( obj==null ) {
			return false;
		}
		if (!(obj instanceof PermitTicket)) {
			return false;
		}
		PermitTicket other = (PermitTicket) obj;
		
		return	Objects.equals(this.code, other.code()) &&
				Objects.equals(this.carPlate, other.carPlate()) &&
				Objects.equals(this.rateName, other.rateName()) &&
				Objects.equals(this.startingDateTime, other.startingDateTime()) &&
				Objects.equals(this.endingDateTime, other.endingDateTime()) &&
				Objects.equals(this.price, other.price());
	}


	@Override
	public String toString() {
		
		return String.format
							(
							"PermitTicket [code=%s, carPlate=%s, rateName=%s, startingDateTime=%s, endingDateTime=%s, price=%s]",
							code, carPlate, rateName, startingDateTime, endingDateTime, price
							);
	}
	
}
