package io.github.jmgarridopaz.bluezone.hexagon;

import java.math.BigDecimal;
import java.time.Clock;
import lombok.*;

/**
 * DTO with the data needed for purchasing a parking ticket:
 * 		carPlate			Plate of the car to be parked
 * 		rateName			Rate name of the zone where the car will be parked at
 *		clock				A clock to get current date-time from, since it will be the starting date-time of the ticket period
 * 		amount				Money (euros) to be paid for the parking ticket
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class PurchaseTicketRequest {

	private String		carPlate;
	private String		rateName;
	private Clock		clock;
	private BigDecimal	amount;
	private String		paymentCard;

}
