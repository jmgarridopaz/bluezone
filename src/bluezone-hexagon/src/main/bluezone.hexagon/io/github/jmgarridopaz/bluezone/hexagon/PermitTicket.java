package io.github.jmgarridopaz.bluezone.hexagon;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class PermitTicket {

	private String			code;
	private String			carPlate;
	private LocalDateTime	startingDateTime;
	private LocalDateTime	endingDateTime;
	private String			rateName;
	private BigDecimal		price;
	
}
