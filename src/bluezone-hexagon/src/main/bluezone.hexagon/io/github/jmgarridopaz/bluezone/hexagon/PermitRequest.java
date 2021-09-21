package io.github.jmgarridopaz.bluezone.hexagon;

import java.time.LocalDateTime;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * DTO class with the input needed for issuing a permit:
 * 
 * 		carPlate		Plate of the car to get the permit for
 * 		rateName		Rate name of the regulated area where the car will be parked at
 * 		endingDateTime	Expiration datetime of the permit period
 * 		paymentCard		Data of the card to charge the permit price to. @see PaymentCardData
 */
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class PermitRequest {

	private String			carPlate;
	private String			rateName;
	private LocalDateTime	endingDateTime;
	private PaymentCardData	paymentCard;

}
