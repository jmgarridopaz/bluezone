package io.github.jmgarridopaz.bluezone.hexagon;

import java.math.BigDecimal;
import lombok.*;

/**
 * DTO with data of a rate:
 *		name			Rate name. Unique. Two uppercase words separated by _
 * 		amountPerHour	Cost in euros of parking the car during one hour
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Rate {
	
	private String		name;
	private BigDecimal	amountPerHour;

	@Override
	public String toString() {
		return this.name + " ( " + this.amountPerHour + "€ / hour )";
	}

}
