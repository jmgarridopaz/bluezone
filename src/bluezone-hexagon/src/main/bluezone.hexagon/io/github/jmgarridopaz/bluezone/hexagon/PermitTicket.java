package io.github.jmgarridopaz.bluezone.hexagon;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.*;

/**
 * DTO with the info returned when paying for a parking permit:
 * 		code				Unique identifier of the ticket
 * 		carPlate			Plate of the car that has been parked
 * 		rateName			Rate name of the regulated area where the car is parked at
 * 		startingDateTime	When the permit period begins
 * 		endingDateTime		When the permit period expires
 * 		price				Amount of money paid for the permit
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class PermitTicket {

	private String			code;
	private String			carPlate;
	private String			rateName;
	private LocalDateTime	startingDateTime;
	private LocalDateTime	endingDateTime;
	private BigDecimal		price;
	
}
