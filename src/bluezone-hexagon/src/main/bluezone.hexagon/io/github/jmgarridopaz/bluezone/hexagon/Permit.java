package io.github.jmgarridopaz.bluezone.hexagon;

import java.time.LocalDateTime;
import java.util.Objects;


public class Permit {

	private final	String				carPlate;
	private final	LocalDateTime		startingDateTime;
	private final	Rate				rate;
	private final	LocalDateTime		endingDateTime;
	private			Money				price;
	private final	PermitTicketCode	ticketCode;
	

	private Permit (String carPlate, LocalDateTime from, Rate rate, LocalDateTime until) {
		this.carPlate = carPlate;
		this.startingDateTime = from;
		this.rate = rate;
		this.endingDateTime = until;
		this.price = calculatePrice();
		this.ticketCode = PermitTicketCode.of (this.carPlate, this.startingDateTime );
	}


	public static Permit untilDateTime ( String carPlate, Rate rate, LocalDateTime from, LocalDateTime until ) {
		return new Permit ( carPlate, from, rate, until );
	}


	public Money price() {
		return this.price;
	}
	
	public PermitTicketCode ticketCode() {
		return this.ticketCode;
	}

	private Money calculatePrice() {
		return this.rate.costBetweenDateTimes(this.startingDateTime,this.endingDateTime);
	}

	public PermitTicket toTicket() {
		PermitTicket ticket = new PermitTicket();
		ticket.setCode(this.ticketCode.value());
		ticket.setRateName(this.rate.name().value());
		ticket.setCarPlate(this.carPlate);
		ticket.setStartingDateTime(this.startingDateTime);
		ticket.setEndingDateTime(this.endingDateTime);
		ticket.setPrice(this.price.toData());
		return ticket;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash ( this.carPlate, this.startingDateTime );
	}

	
	@Override
	public boolean equals ( Object obj ) {
		if (obj == null) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Permit)) {
			return false;
		}
		Permit other = (Permit) obj;
		return
				(
				Objects.equals ( this.carPlate, other.carPlate)
				&&
				Objects.equals ( this.startingDateTime, other.startingDateTime )
				);
	}

	@Override
	public String toString() {
		return	String.format
							( "Permit [carPlate=%s, startingDateTime=%s, rate=%s, endingDateTime=%s, price=%s, ticketCode=%s]",
							this.carPlate,
							this.startingDateTime,
							this.rate,
							this.endingDateTime,
							this.price,
							this.ticketCode
							);
	}

}
