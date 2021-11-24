package io.github.jmgarridopaz.bluezone.hexagon;

import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.Objects;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


/**
 * DTO class with information about a payment card:
 * 
 * 		number			16 digits
 * 		cvv				Card verification value (3 digits)
 * 		expirationDate	Year and month from which the card will no longer be valid
 */
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class PaymentCardData {
	
	private String		number;
	private String		cvv;
	private YearMonth	expirationDate;

}
