package io.github.jmgarridopaz.bluezone.hexagon;

import java.math.BigDecimal;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class MoneyData {
	
	private BigDecimal amount;
	private String currencyCode;
		
}
