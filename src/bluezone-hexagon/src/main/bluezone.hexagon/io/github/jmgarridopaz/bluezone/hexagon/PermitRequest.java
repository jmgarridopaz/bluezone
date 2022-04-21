package io.github.jmgarridopaz.bluezone.hexagon;

import java.time.Clock;
import java.time.LocalDateTime;

import lombok.*;

/**
 * DTO with the info needed when paying for a parking permit:
 * 		carPlate			Plate of the car that has been parked
 * 		rateName			Rate name of the regulated area where the car is parked at
 *		clock				A clock to get current datetime from, since it will be the starting datetime of the permit period
 * 		endingDateTime		Expiration datetime of the permit period
 * 		paymentCardNumber	16 digits number of the card that will be used to pay for the permit
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class PermitRequest {

	private String			carPlate;
	private String			rateName;
	private Clock			clock;
	private LocalDateTime	endingDateTime;
	private String			paymentCardNumber;

}
