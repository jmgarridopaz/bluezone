package io.github.jmgarridopaz.bluezone.hexagon;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.*;

/**
 * DTO with the data of a parking ticket:
 * 		code				Unique identifier of the ticket
 * 		carPlate			Plate of the car that has been parked
 * 		rateName			Rate name of the zone where the car is parked at
 * 		startingDateTime	When the parking period begins
 * 		endingDateTime		When the parking period expires
 * 		price				Amount of money paid for the ticket
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Ticket {

	private String			code;
	private String			carPlate;
	private String			rateName;
	private LocalDateTime	startingDateTime;
	private LocalDateTime	endingDateTime;
	private BigDecimal		price;
	
}
