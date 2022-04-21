package io.github.jmgarridopaz.bluezone.hexagon;

import lombok.*;

import java.math.BigDecimal;
import java.time.Clock;
import java.time.LocalDateTime;

/**
 * DTO class with the info returned when storing a parking permit:
 *		permitId		Id of the stored permit
 * 		permitPrice		Price of the stored permit
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class PermitResponse {

	private Long		permitId;
	private BigDecimal	permitPrice;

}
