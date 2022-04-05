package io.github.jmgarridopaz.bluezone.hexagon;

import java.math.BigDecimal;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class RateData {
	
	private String		name;
	private BigDecimal	amountPerHour;
	private int			minMinutesAllowed;
	private int			maxMinutesAllowed;

}
