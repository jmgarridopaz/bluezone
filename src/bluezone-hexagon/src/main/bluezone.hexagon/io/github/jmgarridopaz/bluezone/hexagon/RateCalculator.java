package io.github.jmgarridopaz.bluezone.hexagon;

import java.math.BigDecimal;
import java.time.LocalDateTime;


public class RateCalculator {

    private final RateData rate;

    public RateCalculator ( RateData rate ) {
        this.rate = rate;
    }

    public LocalDateTime getUntilGivenAmount ( LocalDateTime from, BigDecimal amount ) {
        // minutes = (amount*60)/amountPerHour
        int minutes = (int) ((amount.doubleValue()*60.0) / this.rate.getAmountPerHour().doubleValue());
        return from.plusMinutes(minutes);
    }

}
